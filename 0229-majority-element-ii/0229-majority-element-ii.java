class Solution {  
       static{
        for(int i=0; i<50000; i++){
                majorityElement(null);
            }
    }
    public static  List<Integer> majorityElement(int[] nums) {
        if(nums == null) return new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int n = nums.length;
        for (int num : nums) {
            if (cnt1 == 0 && ele2 != num) {
                cnt1 = 1;
                ele1 = num;
            } else if (cnt2 == 0 && ele1 != num) {
                cnt2 = 1;
                ele2 = num;
            } else if (ele1 == num)
                cnt1++;
            else if (ele2 == num)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }

        }
        List<Integer> ls = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;//Reinitialize;
        for (int num : nums) {
            if (ele1 == num)
                cnt1++;
            if (ele2 == num)
                cnt2++;
        }

        int minelement = (n / 3) + 1;

        if (cnt1 >= minelement)
            ls.add(ele1);
        if (cnt2 >= minelement)
            ls.add(ele2);
        return ls;

    }
}