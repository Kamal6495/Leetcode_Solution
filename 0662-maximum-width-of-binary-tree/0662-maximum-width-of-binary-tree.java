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

 class Tuple{
  TreeNode node;
  int index;
  public Tuple(TreeNode node,int index){
    this.node=node;
    this.index=index;
  }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int width=1;

        Queue<Tuple> q=new LinkedList<>();

        q.offer(new Tuple(root,0));//O Indexing Used

        while(!q.isEmpty()){
          int size=q.size();
          int min=q.peek().index;
          int first=0,last=0;

          for(int i=0;i<size;i++){
            Tuple t=q.poll();

            int curr_id=t.index-min;
            if(i==0)first=curr_id;
            if(i==size-1)  last=curr_id;
            
            if(t.node.left!=null)
            q.offer(new Tuple(t.node.left,2*curr_id+1));
            if(t.node.right!=null)
            q.offer(new Tuple(t.node.right,2*curr_id+2));
          }
          width=Math.max(width,last-first+1);
        }

        return width;
    }
}