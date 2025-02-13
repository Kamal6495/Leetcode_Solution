class Solution {
public:
    long long ops(long long x, long long y) { return ((min(x, y) * 2ll + max(x, y))); }

    int minOperations(vector<int>& nums, int k) {

        priority_queue<long long, vector<long long>, greater<long>> pq;

        int l = 0;
        for (int num : nums) {
            pq.push((long long)num);
        }

        while (pq.size() > 1 && pq.top() < k) {
          //  cout << "PQTOP " << pq.top() << " ll ";
            long long x = pq.top();

            pq.pop();
            long long y = pq.top();

            pq.pop();

            //  if (ops(x, y) < k)
            pq.push(ops(x, y));
           // cout << x << " " << y << " " << ops(x, y) << endl;
            l++;
        }

        return l;
    }
};
