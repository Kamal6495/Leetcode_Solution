class Solution {
    public boolean divideArray(int[] nums) {//using freq array withing range given 1<= n <=500
        int freq[] = new int[501];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;

        }

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] % 2 != 0)
                return false;

        }

        return true;
    }
}