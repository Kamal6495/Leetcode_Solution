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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    recurRightView(root, 0, res);
    return res;
  }

  public void recurRightView(TreeNode root, int level, List<Integer> res) {
    if (root == null)
      return;

    if (level == res.size())
      res.add(root.val);
    recurRightView(root.right, level + 1, res);
    recurRightView(root.left, level + 1, res);

  }
}