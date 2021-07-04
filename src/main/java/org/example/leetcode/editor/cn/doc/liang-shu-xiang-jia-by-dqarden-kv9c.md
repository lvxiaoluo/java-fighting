### 解题思路
此处撰写解题思路

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode t1 = l1;
		ListNode t2 = l2;
		int jinwei = 0;
		ListNode output;
		if (t1.val + t2.val < 10) {
			output = new ListNode(t1.val + t2.val);
			jinwei = 0;
		} else {
			output = new ListNode(t1.val + t2.val - 10);
			jinwei = 1;
		}
		ListNode out = output;
		while (t1.next != null && t2.next != null) {
			t1 = t1.next;
			t2 = t2.next;
			if (t1.val + t2.val + jinwei < 10) {
				output.next = new ListNode(t1.val + t2.val + jinwei);
				jinwei = 0;
			} else {
				output.next = new ListNode(t1.val + t2.val - 10 + jinwei);
				jinwei = 1;
			}
			output = output.next;
		}
		while(t1.next != null) {
			t1 = t1.next;
			if (t1.val + jinwei < 10) {
				output.next = new ListNode(t1.val + jinwei);
				jinwei = 0;
			} else {
				output.next = new ListNode(t1.val - 10 + jinwei);
				jinwei = 1;
			}
			output = output.next;
		}
		while(t2.next != null) {
			t2 = t2.next;
			if (t2.val + jinwei < 10) {
				output.next = new ListNode(t2.val + jinwei);
				jinwei = 0;
			} else {
				output.next = new ListNode(t2.val - 10 + jinwei);
				jinwei = 1;
			}
			output = output.next;
		}
		if(jinwei == 1) {
			output.next = new ListNode(1);
			jinwei = 0;
		}
		return out;
	}
}
```