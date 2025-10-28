/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // Map to store parent for each node value
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, parent); // Build the parent map

        // BFS queue
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int dist = 0;

        // BFS to find all nodes at distance k
        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                }
                if (parent.containsKey(node) && !visited.contains(parent.get(node))) {
                    q.add(parent.get(node));
                    visited.add(parent.get(node));
                }
            }
            dist++;
        }

        // Collect all nodes exactly at distance k
        while (!q.isEmpty()) {
            res.add(q.poll().val);
        }

        return res;
    }

    // Helper function to map each node → its parent
    private void buildParent(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}
