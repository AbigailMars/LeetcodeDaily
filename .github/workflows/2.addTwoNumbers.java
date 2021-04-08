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
/* Wrong Answer
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        ListNode l3 = new ListNode();
        ** for(int i = 0; i < ListNode.size();i++){
            int add = l1.get(i) + l2.get(i);            
            l3.add((add + count)%10);
            if(add + count >= 10){
             count =1;
                if(i = ListNode.size() - 1){
                    l3.add(1);
                }
            }
        }
    }
}
*/

/*
The pseudocode is as following:

Initialize current node to dummy head of the returning list.
Initialize carry to 00.
Initialize pp and qq to head of l1l1 and l2l2 respectively.
Loop through lists l1l1 and l2l2 until you reach both ends.
Set xx to node pp's value. If pp has reached the end of l1l1, set to 00.
Set yy to node qq's value. If qq has reached the end of l2l2, set to 00.
Set sum = x + y + carrysum=x+y+carry.
Update carry = sum / 10carry=sum/10.
Create a new node with the digit value of (sum \bmod 10)(summod10) and set it to current node's next, then advance current node to next.
Advance both pp and qq.
Check if carry = 1carry=1, if so append a new node with digit 11 to the returning list.
Return dummy head's next node.
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();// default new ListNode(0);
        int carry = 0;
        ListNode p = l1; ListNode q = l2;ListNode curr = dummyHead;
        while(p!= null || q!= null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10; // maxSum = 9+9+1 = 19
            curr.next = new ListNode(sum%10);
            curr = curr.next; 
            
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
//if return dummyHead : Wrong Answer
/*
Details 
Input
[2,4,3]    
[5,6,4]
Output
[0,7,0,8]
Expected
[7,0,8]
*/
        
      //  Runtime: 2 ms, faster than 76.46% of Java online submissions for Add Two Numbers.
//Memory Usage: 38.8 MB, less than 96.65% of Java online submissions for Add Two Numbers.
      
      //Complexity Analysis

//Time complexity : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively, the algorithm above iterates at most \max(m, n)max(m,n) times.

//Space complexity : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1.
    }
    
}
