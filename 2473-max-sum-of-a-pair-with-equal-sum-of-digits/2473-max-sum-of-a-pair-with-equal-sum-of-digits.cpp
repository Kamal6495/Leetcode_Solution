class Solution {
public:
    int digitSum(int n) {
        int res = 0;
        int num = n;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
    int maximumSum(vector<int>& nums) {
        map<int, pair<int, int>> mp;

        int res = -1;

        for (int num : nums) {

            int dSum = digitSum(num);

            auto& p = mp[dSum];

            
            if (num > p.first) {
                p.second = p.first;
                p.first = num;

            } else if (num > p.second) {
                p.second = num;
            }

            if(p.second!=0){
                res=max(res,p.first+p.second);
            }

           // cout<<num<<" "<<p.first<<" "<<p.second<<endl;
        }
        return res;
    }
};