class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> arr = new ArrayList<>();

        int i = 0, j = 0;
        int n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2) {

            if ((arr.isEmpty() || arr.get(arr.size() - 1) != nums1[i]) && nums1[i] == nums2[j]) {
                arr.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        // convert to int[]
        int[] result = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            result[k] = arr.get(k);
        }

        return result;

    }
}