/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int depth(TreeNode root, int f) {
        if (root == null) return -1;

        if (root.val == f) return 0;

        int ld = depth(root.left, f);
        if (ld != -1) return ld + 1;

        int rd = depth(root.right, f);
        if (rd != -1) return rd + 1;

        return -1;
    }

    public void checkLineage(TreeNode root, int x, int y, bool[] c){
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
    public bool IsCousins(TreeNode root, int x, int y) {
        int xd = depth(root, x);
        int yd = depth(root, y);

        if(xd == yd){
            bool[] c = {true};
            checkLineage(root, x, y, c);
            return(c[0]);
        }
        else{
            return(false);
        }
    }
}
