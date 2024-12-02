class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
     
     istringstream iss(sentence);
int i=1;
         do {
        string subs;
 
        // Get the word from the istringstream
        iss >> subs;

        if(subs.find(searchWord)==0)
        return i;
          ++i;

 
        // Print the word fetched
        // from the istringstream
        cout << subs << endl;
 
    } while (iss);

return -1;

    }
};