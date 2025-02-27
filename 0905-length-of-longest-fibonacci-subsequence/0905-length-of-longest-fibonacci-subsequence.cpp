class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        int n=arr.size();
        vector<vector<int>> dp(n,vector<int>(n));
        //(Subproblem) dp[x][y]: Longest fib chain length ending at 'y' with 'x' being the previous item

        int longest=0;
        for(int sum=2;sum<n;++sum){
            int a=0;
            int b=sum-1;
            //Two-Sum approach
            while(a<b){
                if(arr[a]+arr[b]<arr[sum])       a++;
                else if(arr[a]+arr[b]>arr[sum])  b--;
                else{
                    dp[b][sum] = 1+dp[a][b];
                    longest = max(longest,dp[b][sum]);
                    a++;
                    b--;
                }
            }
        }
        return longest==0? 0 : 2+longest;
    }
};