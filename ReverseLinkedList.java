
public class ReverseLinkedList {
	static class ListNode{
		ListNode next;
		int val;
		ListNode(int v){
			val = v;
		}
		
	}
	public static ListNode reverse(ListNode head) {
		if(head == null) return head;
		ListNode curr = head;
		ListNode pre = null;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = null;
		ListNode print = reverse(head);
		while(print != null) {
			System.out.println(print.val);
			print = print.next;
		}
	}

}
