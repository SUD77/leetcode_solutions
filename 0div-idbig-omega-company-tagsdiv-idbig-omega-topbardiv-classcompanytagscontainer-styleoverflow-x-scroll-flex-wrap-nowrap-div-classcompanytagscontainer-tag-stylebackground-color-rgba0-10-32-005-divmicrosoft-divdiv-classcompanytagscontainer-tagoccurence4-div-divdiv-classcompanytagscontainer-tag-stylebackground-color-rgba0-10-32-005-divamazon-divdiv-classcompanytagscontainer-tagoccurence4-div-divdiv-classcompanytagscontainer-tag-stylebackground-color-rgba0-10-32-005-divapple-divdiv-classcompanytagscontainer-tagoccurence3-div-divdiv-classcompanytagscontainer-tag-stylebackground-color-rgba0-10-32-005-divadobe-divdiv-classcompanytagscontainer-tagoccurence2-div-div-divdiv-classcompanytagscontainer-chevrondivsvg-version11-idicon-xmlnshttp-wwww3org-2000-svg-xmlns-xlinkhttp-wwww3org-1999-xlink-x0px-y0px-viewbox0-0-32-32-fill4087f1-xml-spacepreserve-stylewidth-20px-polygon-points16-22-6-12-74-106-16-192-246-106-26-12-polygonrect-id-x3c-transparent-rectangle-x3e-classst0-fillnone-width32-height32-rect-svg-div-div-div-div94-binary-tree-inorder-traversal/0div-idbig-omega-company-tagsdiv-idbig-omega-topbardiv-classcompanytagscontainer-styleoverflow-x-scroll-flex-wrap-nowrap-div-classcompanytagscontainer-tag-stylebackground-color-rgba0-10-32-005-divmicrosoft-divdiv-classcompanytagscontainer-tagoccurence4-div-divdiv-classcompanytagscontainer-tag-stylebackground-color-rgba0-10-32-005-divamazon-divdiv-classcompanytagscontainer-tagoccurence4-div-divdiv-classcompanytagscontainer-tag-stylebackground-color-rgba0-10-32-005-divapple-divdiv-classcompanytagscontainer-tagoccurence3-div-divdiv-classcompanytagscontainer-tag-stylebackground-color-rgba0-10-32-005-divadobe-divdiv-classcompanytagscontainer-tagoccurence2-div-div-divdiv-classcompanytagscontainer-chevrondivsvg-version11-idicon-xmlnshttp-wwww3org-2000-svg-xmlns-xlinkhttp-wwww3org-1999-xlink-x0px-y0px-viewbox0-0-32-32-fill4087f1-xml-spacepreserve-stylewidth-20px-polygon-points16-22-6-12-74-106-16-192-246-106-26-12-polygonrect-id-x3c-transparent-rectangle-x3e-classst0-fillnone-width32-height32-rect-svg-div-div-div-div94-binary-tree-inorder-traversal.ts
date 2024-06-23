/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function inorderTraversal(root: TreeNode | null): number[] {
    const result: number[]=[];
    solUtil(root,result);
    return result;
    
};

function solUtil(root: TreeNode | null, result: number[]): void {
    if(root==null) return;
    solUtil(root.left,result);
    result.push(root.val);
    solUtil(root.right,result);
}