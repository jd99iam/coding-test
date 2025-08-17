/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 후위순회 

        /**
        자식 노드 순회 먼저 하고 왔는데 , 반환값이 
        왼쪽 반환값 오른쪽 반환값 둘 다 p, q 가 아닐 때 
        
        
        
        1) 내 val 이 p나 q 의 val 이면 내 val 리턴 
        2) 내 val 은 p나 ,q 의 val 이 아니고, 자식 노드의 반환값이 p나 q의 val 이면 똑같이 해당 값 리턴 
        3) 왼쪽이 p, 오른쪽이 q 면 내가 정답이니까 내 val 리턴 
        4) 내 값이 p, q 중에 하나고 자식 노드중에 p, q 가 있으면 나 리턴 (내가 정답) 
        5) 아무것도 아니면 10^6 리턴 (val 범위 밖의 아무것도 아닌 값 표시용)
        
        
         */

        int pVal = p.val;
        int qVal = q.val;

        TreeNode answer = dfs(root, pVal, qVal);

        return answer;
    }

    public TreeNode dfs(TreeNode node, int pVal, int qVal){
        TreeNode left = node.left;
        TreeNode right = node.right;

        TreeNode leftResult = null;
        TreeNode rightResult = null;

        if (left!=null){
            leftResult = dfs(left, pVal, qVal);
        }
        if (right!=null){
            rightResult = dfs(right, pVal, qVal);
        }



        int val = node.val;

        // 1) 내 val 이 p, q val 중에 하나인 경우
        if (val == pVal || val ==qVal) return node;


        if (leftResult == null && rightResult == null) return null;
        if (leftResult != null && rightResult != null){
            if ((leftResult.val == pVal && rightResult.val == qVal) || (leftResult.val ==qVal || rightResult.val == pVal)){
                return node;
            }
        }

        if (leftResult != null) return leftResult;
        if (rightResult != null) return rightResult;


        //2) 내 val 은 p나 ,q 의 val 이 아니고, 자식 노드의 반환값이 p나 q의 val 이면 똑같이 해당 값 리턴 
        //3) 왼쪽이 p, 오른쪽이 q 면 내가 정답이니까 내 val 리턴 
        //5) 아무것도 아니면 10^6 리턴 (val 범위 밖의 아무것도 아닌 값 표시용)

        return null;
    }
}

/**
이진 트리 주어짐
두 노드 주어짐 
두 노드의 LCA 구하기 


 */