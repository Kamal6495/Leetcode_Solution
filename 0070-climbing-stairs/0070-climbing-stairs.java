class Solution {
    public int climbStairs(int n) {
        int arr[] = new int[47];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < 47; i++)
            arr[i] = arr[i - 1] + arr[i - 2];

        return (int)arr[n + 1];
    }
}