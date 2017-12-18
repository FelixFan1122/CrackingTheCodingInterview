package com.felix.ctci.CodeLibrary;

public class TreeNode<E> {
    private E element;
    private TreeNode<E> leftChild;
    private TreeNode<E> rightChild;

    public TreeNode(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}
