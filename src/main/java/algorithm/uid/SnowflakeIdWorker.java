package algorithm.uid;

/**
 * Twitter-snowflake实现唯一id
 * 
 * ref：http://www.jianshu.com/p/54a87a7c3622
 * 
 * @author ado1986
 *
 */
public class SnowflakeIdWorker {
	private final long twepoch = 1483271955000L; // 从2017年1月开始计算
	private final long workerIdBits = 5L;
	private final long datacenterIdBits = 5L;
	private final long sequenceBits = 12L;
	private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
	private final long maxDatacenterId = -1L ^ (-1L << workerIdBits);
	private final long workerIdShift = sequenceBits;
	private final long datacenterIdShift = sequenceBits + workerIdBits;
	private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

	private final long sequenceMask = -1L;

	private long workerId;
	private long datacenterId;
	private long lastTimestamp = -1L;
	private long sequence = 0L;

	public SnowflakeIdWorker(long workerId, long datacenterId) {
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
		}
		if (datacenterId > maxDatacenterId || datacenterId < 0) {
			throw new IllegalArgumentException(
					String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
		}
		this.workerId = workerId;
		this.datacenterId = datacenterId;
	}

	public synchronized long nextId() {
		long timestamp = timeGen();
		if (timestamp < lastTimestamp) {
			throw new RuntimeException(String.format(
					"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}
		if (timestamp == lastTimestamp) {
			// 比较巧妙的判断相等的方式，同时sequence又重置为0。
			sequence = (sequence + 1L) & sequenceMask;
			if (sequence == 0L) {
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0L;
		}

		lastTimestamp = timestamp;

		return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
				| (workerId << workerIdShift) | sequence;
	}

	/**
	 * 如果当前时间小于上次设置的时间，则循环等待
	 * 
	 * @param lastTimestamp
	 * @return
	 */
	private long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}

		return timestamp;
	}

	/**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	private long timeGen() {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {
		SnowflakeIdWorker suid = new SnowflakeIdWorker(0, 0);
		System.out.println(suid.nextId());
		System.out.println(Long.toBinaryString(suid.nextId()));
		System.out.println(Long.toBinaryString(suid.nextId()));

	}

}
