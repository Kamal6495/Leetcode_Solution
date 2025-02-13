class Solution {

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = sumOfDigits(num);

            // If key is absent, initialize an array to store top 2 numbers
            map.putIfAbsent(digitSum, new int[]{-1, -1});

            int[] topTwo = map.get(digitSum);

         
            if (num > topTwo[0]) {
                topTwo[1] = topTwo[0];
                topTwo[0] = num;      
            } else if (num > topTwo[1]) {
                topTwo[1] = num;      
            }

           
            if (topTwo[1] != -1) {
                maxSum = Math.max(maxSum, topTwo[0] + topTwo[1]);
            }
        }

        return maxSum;
    }}