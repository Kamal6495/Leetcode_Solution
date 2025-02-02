class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        vector<string> temp = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        vector<string> ans(score.size());
        priority_queue<pair<int, int>> pq;

       
        for (int i = 0; i < score.size(); i++) {
            pq.push({score[i], i});
        }

        int x = 0;
        while (!pq.empty()) {
            pair<int, int> p = pq.top();
            pq.pop();

            if (x < 3) {
                ans[p.second] = temp[x];
            } else {
                ans[p.second] = to_string(x + 1);
            }
            x++;
        }

        return ans;
    }
};
