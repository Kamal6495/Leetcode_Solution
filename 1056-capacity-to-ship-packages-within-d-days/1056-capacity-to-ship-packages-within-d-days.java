class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = minA(weights);
        int high = sumA(weights);
        int ans = high;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int requiredDays = reqDays(weights, mid);

            if (requiredDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int reqDays(int[] arr, int cap) {
        int days = 1;
        int load = 0;

        for (int weight : arr) {
            if (load + weight > cap) {
                days++;
                load = weight;
            } else {
                load += weight;
            }
        }
        return days;
    }

    public int minA(int[] arr) {
        int x = arr[0];
        for (int num : arr)
            x = Math.max(x, num);
        return x;
    }

    public int sumA(int[] arr) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        return sum;
    }
}
