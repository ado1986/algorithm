package algorithm.leetcode.easy;

public class HammingDistance {
	private static final long mask = (1L << 32) - 1;

	public static int hammingDistance(int x, int y) {
		int ret = x ^ y;
		int count = 0;
		while ((ret & mask) != 0) {
			if ((ret & 1) != 0)
				count++;
			ret >>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(hammingDistance(3, 4));
	}

}
