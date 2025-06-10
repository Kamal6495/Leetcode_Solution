class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        int elements = (int) Math.floor(n / 3);
        List<Integer> ls = new ArrayList<>();

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        Iterator<Map.Entry<Integer, Integer>> it = mp.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getValue() > (n / 3))
                ls.add(entry.getKey());
        }

        return ls;
    }
}