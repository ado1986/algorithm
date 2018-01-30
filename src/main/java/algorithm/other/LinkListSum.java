package algorithm.other;

/**
 * 给定两个非空链表，其中链表中的每一个节点都是一个十以内的数字，链表的倒序数字串代表相应的十进制数值，因此每一个链表都会对应一个数值。题目中给定两个链表，
 * 需要求出其数值和，并将该数值和也相同的形式用链表表达，返回链表的头结点。例如，给定聊表2->4->3和5->6->4，其代表的数值分别为342和465，
 * 数值和为907，将807用链表倒序表示为7->0->8，因此输出7->0->8链表的头结点。
 * 
 * @author ado1986
 *
 */
public class LinkListSum {
	public static Node sum(Node a, Node b) {
		Node ret = null, ret_p = ret;
		Node p = a, q = b;
		int high = 0;
		while (p != null && q != null) {
			int key1 = p.key;
			int key2 = q.key;
			int sum = key1 + key2 + high;
			int low = sum % 10;
			if (ret_p == null) {
				ret = new Node(low);
				ret_p = ret;
			} else {
				ret_p.next = new Node(low);
				ret_p = ret_p.next;
			}

			high = sum / 10;
			p = p.next;
			q = q.next;
		}

		while (p != null) {
			int sum = p.key + high;
			int low = sum % 10;
			if (ret_p == null) {
				ret = new Node(low);
				ret_p = ret;
			} else {
				ret_p.next = new Node(low);
				ret_p = ret_p.next;
			}
			high = sum / 10;

			p = p.next;
		}

		while (q != null) {
			int sum = q.key + high;
			int low = sum % 10;
			if (ret_p == null) {
				ret = new Node(low);
				ret_p = ret;
			} else {
				ret_p.next = new Node(low);
				ret_p = ret_p.next;
			}
			high = sum / 10;

			q = q.next;
		}

		if (high != 0) {
			ret_p.next = new Node(high);
			ret_p = ret_p.next;
		}

		return ret;
	}

	public static void main(String[] args) {
		Node a = new Node(2);
		a.next = new Node(1);

		Node b = new Node(8);
		b.next = new Node(9);

		Node c = sum(a, b);
		while (c != null) {
			System.out.print(c.key);
			c = c.next;
		}
	}
}

class Node {
	public int key;
	public Node next;

	public Node(int key) {
		this.key = key;
	}
}
