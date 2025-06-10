class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        List<Integer> ls = new ArrayList<>();
int minelements=(n/3)+1;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
            int x=mp.get(num);
            if(mp.get(num)==minelements)
            ls.add(num);

            if(ls.size()==2) break;
        
        }


        return ls;
    }
}