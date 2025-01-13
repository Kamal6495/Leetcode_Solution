class Solution {
public:
    int minimumLength(string s) {
        map<char, int> mp;

        for(int i = 0; i < s.length(); i++) {
            mp[s[i]]++;
        }
    

    int count = 0;
    for(auto i = mp.begin(); i != mp.end(); i++) {

        if (i->second & 1)
            count += 1;
        else
            count += 2;
    }
    return count;
}};