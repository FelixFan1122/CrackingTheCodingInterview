package com.felix.ctci.Successor;

import com.felix.ctci.CodeLibrary.TreeNode;

public class Successor {
    public static <E> TreeNode<E> getSuccessorInOrder(TreeNode<E> bst) {
        if (bst.getRightChild() != null) {
            return bst.getRightChild();
        }

        TreeNode<E> current = bst;
        TreeNode<E> parent = bst.getParent();
        while (parent != null && parent.getLeftChild() != current) {
            current = parent;
            parent = current.getParent();
        }

        return parent == null ? current : parent;
    }
}
