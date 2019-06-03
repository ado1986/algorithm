package algorithm.other;

public class Chip {

	/**
	 * 
	 * @param initial
	 *            初始筹码
	 * @param round
	 *            每轮次结果
	 * @return
	 */
	public static int chip(int initial, String round) {
		int sum = initial;
		int len = round.length();
		int delta = 1;
		for (int i = 0; i < len; i++) {
			System.out.println("line:" + i);
			if (sum >= delta && 'W' == round.charAt(i)) {
				sum += delta;
				delta = 1;
			} else if (sum >= delta && 'L' == round.charAt(i)) {
				sum -= delta;
				delta *= 2;
			} else
				return sum;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(chip(2, "WLLLL"));
	}

}
