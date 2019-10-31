package a12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 173.
 * Binary Search Tree Iterator
 * Difficulty
 * Medium
 * 881
 * 185
 * Discuss (339)
 *
 * Favorite
 * Share
 * ACCEPTED
 * 156,028
 * SUBMISSIONS
 * 348,402
 * Description
 * Hints
 * Solution
 * Submissions
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree.
 */
public class binarySearachTreeIterator_173 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public class BSTIterator {
        Deque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            pushStack(root);
        }

        private void pushStack(TreeNode root){
            if(root == null){
                return;
            }
            while(root != null){
                stack.offerFirst(root);
                root = root.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode temp = stack.pollFirst();
            if(temp.right != null){
                 pushStack(temp.right);
            }
            return temp.val;
        }
    }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
}