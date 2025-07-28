/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ls = new ArrayList<>();
    if (root == null)
      return ls;
    Stack<TreeNode> st1 = new Stack<>();
    // Stack<TreeNode> st2 = new Stack<>();
    TreeNode curr = root;
    //st1.push(root);

    while (curr != null || !st1.isEmpty()) {
      if (curr != null) {
        st1.push(curr);
        curr = curr.left;
      } else {
        TreeNode temp = st1.peek().right;
        if (temp == null) {
          temp = st1.pop();
          ls.add(temp.val);
          while (!st1.isEmpty() && temp == st1.peek().right) {
            temp = st1.pop();
            ls.add(temp.val);
          }

        } else {
          curr = temp;
        }
      }

    }
    return ls;
  }

}