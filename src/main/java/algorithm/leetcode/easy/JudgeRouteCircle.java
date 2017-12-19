package algorithm.leetcode.easy;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its
 * moves, judge if this robot makes a circle, which means it moves back to the
 * original place.
 * 
 * The move sequence is represented by a string. And each move is represent by a
 * character. The valid robot moves are R (Right), L (Left), U (Up) and D
 * (down). The output should be true or false representing whether the robot
 * makes a circle.
 * 
 * @author ado1986
 *
 */
public class JudgeRouteCircle {

	public static boolean judgeCircle(String moves) {
		int lp = 0, rp = 0;
		char[] ch = moves.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			switch (c) {
			case 'U':
				rp++;
				break;
			case 'D':
				rp--;
				break;
			case 'R':
				lp++;
				break;
			case 'L':
				lp--;
				break;
			}
		}

		return (lp == rp) && (rp == 0);
	}

	public static void main(String[] args) {
		System.out.println(judgeCircle("UUDDR"));
	}

}
