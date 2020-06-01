/*
Invert Binary Tree
Invert a binary tree.

Example:
Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
*/
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root; //if root is null, just return null.
        /*
        Pass root node as a paramter to swap function which will just swap root's left node with root's right.
        */
        swap(root);
        return root;
    }
    public static void swap(TreeNode root){
        if(root.left==null && root.right==null)//if both nodes are null, return null
            return;
        /*
        Just swap the root's left node with root's right node and then perform the swap function on root.left
        and root.right recursively.
        NOTE: DON'T SWAP THE VALUES OF NODES because that will just swap values of node and the desecendants of
        that node will not be swapped in a right way.
        */
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        
        if(root.left!=null) swap(root.left);
        if(root.right!=null)swap(root.right);
    }
}
