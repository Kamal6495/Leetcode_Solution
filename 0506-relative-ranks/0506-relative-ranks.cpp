class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        vector<string> ans(score.size());
        priority_queue<pair<int, int>> pq;

        for (int i = 0; i < score.size(); i++) {
            pq.push({score[i], i});
        }

        int x = 0;
        while (!pq.empty()) {
            pair<int, int> p = pq.top();
            pq.pop();

            if (x == 0)
                ans[p.second] = "Gold Medal";
            else if (x == 1)
                ans[p.second] = "Silver Medal";
            else if (x == 2)
                ans[p.second] = "Bronze Medal";
            else
                ans[p.second] = to_string(x + 1);
            x++;
        }

        return ans;
    }
};
