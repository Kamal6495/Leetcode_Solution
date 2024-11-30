<h2><a href="https://leetcode.com/problems/divide-two-integers">29. Divide Two Integers</a></h2><h3>Medium</h3><hr><p>Given two integers <code>dividend</code> and <code>divisor</code>, divide two integers <strong>without</strong> using multiplication, division, and mod operator.</p>

<p>The integer division should truncate toward zero, which means losing its fractional part. For example, <code>8.345</code> would be truncated to <code>8</code>, and <code>-2.7335</code> would be truncated to <code>-2</code>.</p>

<p>Return <em>the <strong>quotient</strong> after dividing </em><code>dividend</code><em> by </em><code>divisor</code>.</p>

<p><strong>Note: </strong>Assume we are dealing with an environment that could only store integers within the <strong>32-bit</strong> signed integer range: <code>[&minus;2<sup>31</sup>, 2<sup>31</sup> &minus; 1]</code>. For this problem, if the quotient is <strong>strictly greater than</strong> <code>2<sup>31</sup> - 1</code>, then return <code>2<sup>31</sup> - 1</code>, and if the quotient is <strong>strictly less than</strong> <code>-2<sup>31</sup></code>, then return <code>-2<sup>31</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> dividend = 10, divisor = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> 10/3 = 3.33333.. which is truncated to 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> dividend = 7, divisor = -3
<strong>Output:</strong> -2
<strong>Explanation:</strong> 7/-3 = -2.33333.. which is truncated to -2.
</pre>

<p>&nbsp;</p>



# Division of Two Integers Using Bitwise Operations

This function performs division of two integers using bitwise operations without directly using the `/` or `%` operators. Here's how it works:

---

## Handle Special Cases:
1. If `dividend == divisor`, the result is `1`.
2. If `dividend == INT_MIN` (smallest possible integer) and `divisor == -1`, the result overflows the range of integers, so we return `INT_MAX`.
3. If `dividend == INT_MAX` (largest possible integer) and `divisor == -1`, the result will be `INT_MIN + 1`.

---

## Determine Sign:
- Use XOR (`^`) to determine if the signs of `dividend` and `divisor` are different.
  - If they are different, the result should be negative (`-1`).
  - Otherwise, the result is positive (`1`).

---

## Convert to Absolute Values:
- Convert both `dividend` and `divisor` to their absolute values to simplify the bitwise calculations.

---

## Perform Division Using Bitwise Shifting:
- Use a loop to repeatedly subtract multiples of `divisor` from `dividend` until `dividend` becomes smaller than `divisor`.
- The multiples are computed by left-shifting (`d << count`) to speed up subtraction.
- For every iteration:
  - Determine the largest multiple of `divisor` (using left shifts) that can be subtracted from `dividend`.

---

## Accumulate the Quotient:
- Add the corresponding power of `2` (`1 << count`) to the result (`ans`) for each subtraction.

---

## Check Overflow in Result:
1. If `ans` reaches `INT_MAX` and the sign is positive, return `INT_MAX`.
2. If `ans` reaches `INT_MAX` and the sign is negative, return `INT_MIN`.

---

## Apply Sign:
- Multiply `ans` by the sign calculated earlier to restore the correct sign of the result.

<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= dividend, divisor &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>divisor != 0</code></li>
</ul>
