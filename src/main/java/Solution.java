public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = {-1, -1};

        ListNode temp = head;
        int prev = head.val;
        int first = -1;
        int last = -1;
        head = head.next;
        int count = 1;
        while(head.next != null) {
            if((head.val > prev && head.val > head.next.val) || (head.val < prev && head.val < head.next.val)) {

                if(first == -1) {
                    first = count;
                }else {
                    res[0] = res[0] == -1 ? count - first : Math.min(res[0], count - last);
                    res[1] = count - first;
                }
                last = count;
            }
            prev = head.val;
            count++;
            head = head.next;
        }

        return res;
    }
}
