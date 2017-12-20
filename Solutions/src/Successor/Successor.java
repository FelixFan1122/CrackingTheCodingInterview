package com.felix.ctci.Successor;

import com.felix.ctci.CodeLibrary.TreeNode;

import javax.swing.*;

public class Successor {
    public static <E> TreeNode<E> getSuccessorInOrder(TreeNode<E> bst) {
        if (bst == null) {
            return null;
        }

        if (bst.getRightChild() == null) {
            TreeNode<E> current = bst;
            TreeNode<E> parent = bst.getParent();
            while (parent != null && parent.getLeftChild() != current) {
                current = parent;
                parent = current.getParent();
            }

            return parent;
        } else {
            TreeNode<E> current = bst.getRightChild();
            while (current.getLeftChild() != null) {
                current = current.getLeftChild();
            }

            return current;
        }
    }
}
