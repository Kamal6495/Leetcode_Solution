class Solution {
public:
    long long coloredCells(int n) {
        long long x=0ll;
        int d=n-1;
        for(int i=1;i<n;i++){

            x+=((long long)d*2ll-1ll);
            d--;
        }
        x*=2;

        return x+(n*2-1);
    }
};