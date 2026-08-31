class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int l = -1;
        int r = -1;
        int c = 1;
        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE;
        res[1] = -1;
        int prev = head.val;
        head = head.next;
        if (head == null) {
            return new int[]{-1, -1};
        }
        int prevR = -1;
        while (head.next != null) {
            if (head.val > prev && head.val > head.next.val ||
                    head.val < prev && head.val < head.next.val) {
                if (l == -1) {
                    l = c;
                    prevR = c;
                } else {
                    prevR = r == -1 ? prevR : r;
                    r = c;
                }
                if (l != -1 && r != -1) {
                    if (prevR != -1) {
                        res[0] = Math.min(res[0], r - prevR);
                    }

                    res[1] = Math.max(res[1], r - l);
                }
            }
            c++;
            prev = head.val;
            head = head.next;

        }
        if (res[1] != -1) {
            return res;
        } else return new int[]{-1, -1};
    }
}