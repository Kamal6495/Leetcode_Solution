class Solution {
    public boolean search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (arr[mid] == target)
                return true;

            if (arr[low] == arr[mid] & arr[high] == arr[mid]) {
                low++;
                high--;
                continue;
            }
            //Left Part Sorted
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {//Right Part Sorted
                if (target >= arr[mid] && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

        }

        return false;
    }
}
