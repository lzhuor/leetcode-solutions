/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    const res = [];
    visit(root, res, 0);
    return res;
};

const visit = (root, res, level) => {
    if (!root) return res;
    
    if (res.length === level) {
        res.push(root.val);
    }
    
    visit(root.right, res, level + 1);
    visit(root.left, res, level + 1);
}
