class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {

     stringstream s(sentence);
        string temp;
        for(int i = 1; s >> temp; i++)
            if(temp.substr(0, searchWord.length()) == searchWord) return i;
        return -1;
    }
};