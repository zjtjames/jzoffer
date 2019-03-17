/**
 * created by Zheng Jiateng on 2019/3/16.
 */

import base.TreeLinkNode;

/**
 * 二叉树的下一个结点:  特别注意最右下的结点 也就是中序遍历的最后一个结点 次节点没有下一个结点
 * 不借助辅助空间
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            return inOrderTraversal(pNode.right);
        }
        while (pNode.next != null && pNode != pNode.next.left) {
            pNode = pNode.next;
        }
        if (pNode.next == null) {
            return null;
        }
        return pNode.next;
    }

    private TreeLinkNode inOrderTraversal(TreeLinkNode pNode) {
        while (pNode.left != null) {
            pNode = pNode.left;
        }
        return pNode;
    }
}
