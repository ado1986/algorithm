package algorithm.sort.quicksort;

/**
 * 对单链表的数据进行快速排序
 * 
 * @author ado1986
 *
 */
public class LinkQuickSort {
	public void swap(Node n1, Node n2) {
		int temp = n1.key;
		n1.key = n2.key;
		n2.key = temp;
	}

	/**
	 * 分治进行，只是交换值，而不对链表指针做处理
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	public Node partition(Node low, Node high) {
		int pivo = low.key;
		Node p = low;
		Node q = low.next;
		// 采用快慢指针方式，交换处理
		while (q != high) {
			if (q.key < pivo) {
				p = p.next;
				swap(p, q);
			}
			q = q.next;
		}

		swap(low, p);

		return p;
	}

	public void quickSort(Node n1, Node n2) {
		if (n1 == n2)
			return;
		Node pivo = partition(n1, n2);
		quickSort(n1, pivo);
		quickSort(pivo.next, n2);
	}

	public static void main(String[] args) {
		// 测试
		Node node1 = new Node(5, null);
		Node node2 = new Node(1, node1);
		Node node3 = new Node(3, node2);
		Node node4 = new Node(7, node3);
		Node head = new Node(10, node4);

		// 原始链表
		Node p = head;
		while (p != null) {
			System.out.print(p.key + " ");
			p = p.next;
		}

		LinkQuickSort qs = new LinkQuickSort();
		qs.quickSort(head, null);
		System.out.println();
		p = head;
		// 排序后的链表
		while (p != null) {
			System.out.print(p.key + " ");
			p = p.next;
		}
	}
}

class Node {
	public int key;
	public Node next;

	public Node(int key, Node next) {
		this.key = key;
		this.next = next;
	}
}
