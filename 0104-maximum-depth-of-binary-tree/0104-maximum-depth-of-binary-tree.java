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
    public int maxDepth(TreeNode root) {
        return bfs(root);

    }

    public int bfs(TreeNode root) {

        if (root==null) return 0;

        int maxDepth = 1;

        ArrayDeque<Node> queue = new ArrayDeque<>();
        // depth 1 로 시작
        queue.offer(new Node(root, 1));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (maxDepth<current.depth) maxDepth +=1;
            TreeNode left = current.treeNode.left;
            TreeNode right = current.treeNode.right;
            if (left != null) {
                queue.offer(new Node(left, current.depth + 1));
            }
            if (right != null) {
                queue.offer(new Node(right, current.depth + 1));
            }
        }

        return maxDepth;
    }

    public class Node {
        TreeNode treeNode;
        int depth;

        public Node(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}

/**
이진 트리가 주어졌을 때, 트리의 max depth 구하기 (루트가 1)


큐 ArrayDeque
 */