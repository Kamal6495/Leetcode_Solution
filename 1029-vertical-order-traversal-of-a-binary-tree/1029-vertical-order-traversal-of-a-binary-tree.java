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

class Tuple {
  TreeNode node;
  int ver;
  int hor;

  public Tuple(TreeNode t, int v, int h) {
    node = t;
    ver = v;
    hor = h;

  }
}

class Solution {
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    Map<Integer, Map<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();

    Queue<Tuple> q = new LinkedList<>();

    Tuple t = new Tuple(root, 0, 0);
    q.offer(t);

    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        Tuple temp = q.poll();

        mp.putIfAbsent(temp.ver, new TreeMap<>());
        mp.get(temp.ver).putIfAbsent(temp.hor, new PriorityQueue<>());
        mp.get(temp.ver).get(temp.hor).offer(temp.node.val);

        if (temp.node.left != null)
          q.offer(new Tuple(temp.node.left, temp.ver - 1, temp.hor + 1));
        if (temp.node.right != null)
          q.offer(new Tuple(temp.node.right, temp.ver + 1, temp.hor + 1));

      }
    }

    for (Map<Integer, PriorityQueue<Integer>> rows : mp.values()) {
      List<Integer> colValue = new ArrayList<>();

      for (PriorityQueue<Integer> pq : rows.values()) {

        while (!pq.isEmpty())
          colValue.add(pq.poll());
      }
      res.add(colValue);
    }
    return res;
  }
}