package algorithm.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome {

    /**
     * 复制链表并逆转
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode node = head;
        while (node != null) {
            ListNode newNode = new ListNode(node.val);
            newNode.next = dummy.next;
            dummy.next = newNode;

            node = node.next;
        }

        ListNode slow = head, fast = head;
        ListNode tempNode = dummy.next;
        while (fast != null) {
            if (slow.val != tempNode.val) {
                return false;
            }

            tempNode = tempNode.next;
            // 移动快慢指针
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return true;
    }


    /**
     * 使用数组+双指针
     *
     * @param head
     * @return
     */
    public boolean isPalindromeInArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add((head.val));
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * 逆转后半段，O(n)时间复杂度，O(1)空间复杂度
     *
     * @param head
     * @return
     */
    public boolean isPalindromeReverse(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        // 逆转后半段
        ListNode pre = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);

//        node.next = new ListNode(1);
//        node.next.next = new ListNode(2);
//        node.next.next.next = new ListNode(1);

        System.out.println(isPalindrome.isPalindromeReverse(node));
    }

}
