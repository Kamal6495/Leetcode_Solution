class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];  // set current element as new candidate
                    count = 1;
                }
            }

           // System.out.println(nums[i]+" ="+count+" cabdiate="+candidate);
        }

        return candidate;
    }
}
