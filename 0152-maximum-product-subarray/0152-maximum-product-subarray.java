class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int suffixProduct = 1, prefixProduct = 1;
        int n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (suffixProduct == 0)
                suffixProduct = 1;
            if (prefixProduct == 0)
                prefixProduct = 1;

            prefixProduct *= nums[i];
            suffixProduct *= nums[n- 1 - i];
            maxProduct = Math.max(maxProduct, suffixProduct);
            maxProduct = Math.max(maxProduct, prefixProduct);

        }
        return maxProduct;
    }
}