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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
            
             return solve(preorder,0,preorder.length-1,postorder,0,postorder.length-1);


    }

     public TreeNode solve(int[] pre,int psi,int pei, int[] post,int ppsi,int ppei) {
     if(psi>pei) return null;

        TreeNode root=new TreeNode(pre[psi]);

        int idx=ppsi;

        if(psi==pei) 
        return root;

        while(post[idx]!=pre[psi+1]) idx++;

        int tel=idx-ppsi+1;
        root.left=solve(pre,psi+1,psi+tel,post,ppsi,idx);
        root.right=solve(pre,psi+tel+1,pei,post,idx+1,ppei-1);

        return root;
    }
}