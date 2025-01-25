<h2><a href="https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements">3219. Make Lexicographically Smallest Array by Swapping Elements</a></h2><h3>Medium</h3><hr><p>You are given a <strong>0-indexed</strong> array of <strong>positive</strong> integers <code>nums</code> and a <strong>positive</strong> integer <code>limit</code>.</p>

<p>In one operation, you can choose any two indices <code>i</code> and <code>j</code> and swap <code>nums[i]</code> and <code>nums[j]</code> <strong>if</strong> <code>|nums[i] - nums[j]| &lt;= limit</code>.</p>

<p>Return <em>the <strong>lexicographically smallest array</strong> that can be obtained by performing the operation any number of times</em>.</p>

<p>An array <code>a</code> is lexicographically smaller than an array <code>b</code> if in the first position where <code>a</code> and <code>b</code> differ, array <code>a</code> has an element that is less than the corresponding element in <code>b</code>. For example, the array <code>[2,10,3]</code> is lexicographically smaller than the array <code>[10,2,3]</code> because they differ at index <code>0</code> and <code>2 &lt; 10</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,5,3,9,8], limit = 2
<strong>Output:</strong> [1,3,5,8,9]
<strong>Explanation:</strong> Apply the operation 2 times:
- Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
- Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
We cannot obtain a lexicographically smaller array by applying any more operations.
Note that it may be possible to get the same result by doing different operations.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,7,6,18,2,1], limit = 3
<strong>Output:</strong> [1,6,7,18,1,2]
<strong>Explanation:</strong> Apply the operation 3 times:
- Swap nums[1] with nums[2]. The array becomes [1,6,7,18,2,1]
- Swap nums[0] with nums[4]. The array becomes [2,6,7,18,1,1]
- Swap nums[0] with nums[5]. The array becomes [1,6,7,18,1,2]
We cannot obtain a lexicographically smaller array by applying any more operations.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,7,28,19,10], limit = 3
<strong>Output:</strong> [1,7,28,19,10]
<strong>Explanation:</strong> [1,7,28,19,10] is the lexicographically smallest array we can obtain because we cannot apply the operation on any two indices.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= limit &lt;= 10<sup>9</sup></code></li>
</ul>



# Explanation of the Code

This solution rearranges elements of the array `nums` into a lexicographically smallest order under the constraint that differences between consecutive elements in the sorted group must not exceed a specified `limit`.

### Steps:

1. **Store Elements with Indices**:
   - Create a vector of pairs, `xy`, where each pair contains a number from `nums` and its corresponding index. This helps us keep track of the original positions of elements.

2. **Sort the Vector of Pairs**:
   - Sort `xy` based on the values of `nums`. This groups elements that should be together lexicographically.

3. **Rearrange Values by Groups**:
   - Use a two-pointer approach (`left` and `right`) to find groups of elements in `xy` where the difference between consecutive values is less than or equal to `limit`.
   - Sort the indices of each group to preserve the lexicographical order.

4. **Place Values Back**:
   - Use the sorted indices to place the ordered values back into their original positions in `nums`.

5. **Return the Result**:
   - After processing all groups, the updated `nums` will be the lexicographically smallest array.

---

# Code: Lexicographically Smallest Array with Comments

```cpp
class Solution {
public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
        // Step 1: Store each number with its original index
        vector<pair<int, int>> xy; // Pair of {value, index}
        for (int i = 0; i < nums.size(); i++)
            xy.push_back({nums[i], i});

        // Step 2: Sort the vector by value to group items lexicographically
        sort(xy.begin(), xy.end());

        // Initialize pointers to process groups
        int left = 0, right = 1;
        int n = nums.size();

        // Step 3: Find groups of elements where consecutive values differ by <= limit
        while (right < n) {
            vector<int> pos = {xy[left].second}; // Store indices of the current group

            // Expand the group while the difference between consecutive values <= limit
            while (right < n && abs(xy[right].first - xy[right - 1].first) <= limit) {
                pos.push_back(xy[right].second);
                right++;
            }

            // Step 4: Sort indices in the group for lexicographical order
            sort(pos.begin(), pos.end());

            // Place the sorted values into their original positions in nums
            for (int i = 0; i < right - left; i++)
                nums[pos[i]] = xy[left + i].first;

            // Move to the next group
            left = right;
            right++;
        }

        // Return the updated nums array
        return nums;
    }
};

