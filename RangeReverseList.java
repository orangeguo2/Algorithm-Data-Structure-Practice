

public class RangeReverseList {
	class ListNode{
		ListNode next;
		int val;
		ListNode(int v){
			val = v;
		}
		
	}
	boolean stop;
	ListNode left;
public ListNode recurseRecursion(ListNode head, int m, int n) {
	this.left = head;
	this.stop = false;
	recurseRecursionHelper(head, m ,n);
	return head;
}
public void recurseRecursionHelper(ListNode right, int m, int n) {
	if(n == 1)
		return;
	right = right.next;
	if(m > 1)
		this.left = this.left.next;
	recurseRecursionHelper(right, m - 1, n - 1);
	if(this.left == right || right.next == this.left)
		this.stop = true;
	if(!this.stop) {
		int t = this.left.val;
		this.left.val = right.val;
		right.val = t;
		this.left = this.left.next;
	}
}
public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        int i = 1;
        ListNode cur = head, pre = null;
        while(i < m) {
        	pre = cur;
        	cur = cur.next;
        	i++;
        }
       ListNode tail = cur, before = pre;
       ListNode next = null;
       while(i <= n) {
    	   next = cur.next;
    	   cur.next = pre;
    	   pre = cur;
    	   cur = next;
    	   i++;
       }
       if(before == null) {
    	   tail.next = cur;
    	   return pre;
       }else {
    	   before.next = pre;
    	   tail.next = cur;
    	   return head;
       }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
