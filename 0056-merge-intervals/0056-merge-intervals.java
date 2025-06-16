class Solution {
    //Brute Force
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, new IntervalComparator());
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : arr) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

class IntervalComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
}