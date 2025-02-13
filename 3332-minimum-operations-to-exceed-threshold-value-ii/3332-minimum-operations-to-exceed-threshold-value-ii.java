class Solution {
    public long ops(long x, long y) {
        return Math.min(x, y) * 2l + Math.max(x, y);
    }

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        int l = 0;
        for (int num : nums) {
            pq.add((long)num);
        }

        while (pq.peek() < k && pq.size() > 1) {
            long x = pq.poll();
            long y = pq.poll();
                pq.add(ops(x, y));
            l++;

        }

        return l;
    }
}