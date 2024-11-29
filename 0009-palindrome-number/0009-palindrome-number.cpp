class Solution {
public:
    bool isPalindrome(int x) {
        int d = x, rev = 0;

        while (d > 0) {
            if(rev>(INT_MAX/10)||rev<(INT_MIN/10)) 
             return false;
          
            rev = (rev * 10) + (d % 10);
            d /= 10;
        }
    

        return x==rev;
    }
};