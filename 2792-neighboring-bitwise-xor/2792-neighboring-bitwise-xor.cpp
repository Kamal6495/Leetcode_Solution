class Solution {
public:
    bool doesValidArrayExist(vector<int>& derived) {
        
int sum=0;
for(int i=0;i<derived.size();i++)
sum^=derived[i];
    

   // sum^=derived[0];

    if(sum==0)
    return true;
    
    return false;
}};