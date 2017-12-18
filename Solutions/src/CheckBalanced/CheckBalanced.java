package com.felix.ctci.CheckBalanced;

import com.felix.ctci.CodeLibrary.TreeNode;

public class CheckBalanced {
    public static <E extends Comparable<E>> boolean isBalanced(TreeNode<E> binaryTree) {
        try {
            E max = validateAndGetMinValue(binaryTree.getRightChild());
            E min = validateAndGetMaxValue(binaryTree.getLeftChild());
            return binaryTree.getElement().compareTo(max) < 0 && binaryTree.getElement().compareTo(min) >= 0;
        }
        catch (Exception e) { // TODO: Replace with a custom Exception.
            return false;
        }
    }

    private static <E extends Comparable<E>> E validateAndGetMaxValue(TreeNode<E> binaryTree) throws Exception {
        E element = binaryTree.getElement();
        E max = element;
        if (binaryTree.getLeftChild() != null) {
            if (element.compareTo(validateAndGetMaxValue(binaryTree.getLeftChild())) < 0) {
                throw new Exception();
            }
        }

        if (binaryTree.getRightChild() != null) {
            max = validateAndGetMinValue(binaryTree.getRightChild());
            if (element.compareTo(max) >= 0) {
                throw new Exception();
            }
        }

        return max;
    }

    private static <E extends Comparable<E>> E validateAndGetMinValue(TreeNode<E> binaryTree) throws Exception {
        E element = binaryTree.getElement();
        E min = element;
        if (binaryTree.getRightChild() != null) {
            if (element.compareTo(validateAndGetMinValue(binaryTree.getRightChild())) >= 0) {
                throw new Exception();
            }
        }

        if (binaryTree.getLeftChild() != null) {
            min = validateAndGetMaxValue(binaryTree.getLeftChild());
            if (element.compareTo(min) < 0) {
                throw new Exception();
            }
        }

        return min;
    }
}
