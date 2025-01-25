<h2><a href="https://leetcode.com/problems/combination-sum-ii">40. Combination Sum II</a></h2><h3>Medium</h3><hr><p>Given a collection of candidate numbers (<code>candidates</code>) and a target number (<code>target</code>), find all unique combinations in <code>candidates</code>&nbsp;where the candidate numbers sum to <code>target</code>.</p>

<p>Each number in <code>candidates</code>&nbsp;may only be used <strong>once</strong> in the combination.</p>

<p><strong>Note:</strong>&nbsp;The solution set must not contain duplicate combinations.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> candidates = [10,1,2,7,6,1,5], target = 8
<strong>Output:</strong> 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2,5,2,1,2], target = 5
<strong>Output:</strong> 
[
[1,2,2],
[5]
]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;candidates.length &lt;= 100</code></li>
	<li><code>1 &lt;=&nbsp;candidates[i] &lt;= 50</code></li>
	<li><code>1 &lt;= target &lt;= 30</code></li>
</ul>


# Key Characteristics

## Backtracking Approach:

- The function explores all possible combinations of elements in the array.
- Each recursive call includes or excludes an element in the current subset (`ds`).
- The recursion stops when the target (`tar`) becomes `0` (valid combination found) or goes negative (invalid path).

## Sorting for Pruning and Deduplication:

### Why Sorting?
Sorting ensures that elements are processed in non-decreasing order.

### Benefits of Sorting:
1. **Prune branches early**:
   - When `arr[i] > tar`, further elements are skipped because they will also exceed the target.
2. **Avoid duplicates**:
   - By skipping consecutive duplicate elements (`if (i > ind && arr[i] == arr[i - 1])`).

## Duplicate Handling:

- The condition `if (i > ind && arr[i] == arr[i - 1])` skips duplicate elements when processing the same level of recursion.
- This ensures no duplicate combinations are included in the results.

## Efficient Space Usage:

- The algorithm uses a single vector `ds` for building combinations, which is modified using `push_back` and `pop_back` during recursive calls.
- This avoids creating new vectors at every step, saving memory.

## Early Stopping:

- The condition `if (arr[i] > tar) break;` stops recursion early when the current element exceeds the remaining target (`tar`).
- Since the array is sorted, no further elements can contribute to the target.

