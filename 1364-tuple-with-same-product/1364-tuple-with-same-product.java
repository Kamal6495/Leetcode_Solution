import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] arr) {
        int count = 0;
        HashMap<Integer, Integer> f = new HashMap<>();

        // Count frequency of products
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { 
                int x = arr[i] * arr[j];
                f.put(x, f.getOrDefault(x, 0) + 1);
            }
        }

       
        for (Integer key : f.keySet()) {
            int freq = f.get(key);
            if (freq > 1) {
                count += (8 * (freq * (freq - 1)) / 2); //  tuple count formula
            }
        }
        return count;
    }
}
