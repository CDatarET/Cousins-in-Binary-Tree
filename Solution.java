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
    public int depth(TreeNode root, int f) {
        if (root == null) return -1;

        if (root.val == f) return 0;

        int ld = depth(root.left, f);
        if (ld != -1) return ld + 1;

        int rd = depth(root.right, f);
        if (rd != -1) return rd + 1;

        return -1;
    }

    public void checkLineage(TreeNode root, int x, int y, boolean[] c){
        if(root == null || !c[0]){
            return;
        }

        if (root.left != null && root.right != null){
            if ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)){
                c[0] = false;
                return;
            }
        }
        
        checkLineage(root.left, x, y, c);
        checkLineage(root.right, x, y, c);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int xd = depth(root, x);
        int yd = depth(root, y);

        if(xd == yd){
            boolean[] c = {true};
            checkLineage(root, x, y, c);
            return(c[0]);
        }
        else{
            return(false);
        }
    }
}
