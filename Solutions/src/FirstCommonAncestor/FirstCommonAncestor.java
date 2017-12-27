package com.felix.ctci.FirstCommonAncestor;

import com.felix.ctci.CodeLibrary.TreeNode;

public class FirstCommonAncestor {
    public static <E> TreeNode<E> getFirstCommonAncestor(TreeNode<E> node1, TreeNode<E> node2) {
        if (node1 == null || node2 == null) {
            throw new IllegalArgumentException();
        }

        int height1 = getHeight(node1);
        int height2 = getHeight(node2);

        TreeNode<E> deeperNode;
        TreeNode<E> shallowerNode;
        if (height1 < height2) {
            shallowerNode = node1;
            deeperNode = node2;
        } else {
            shallowerNode = node2;
            deeperNode = node1;
        }

        int heightDifference = Math.abs(height1 - height2);
        for (int i = 0; i < heightDifference; i++) {
            deeperNode = deeperNode.getParent();
        }

        while (deeperNode != null && deeperNode != shallowerNode) {
            deeperNode = deeperNode.getParent();
            shallowerNode = shallowerNode.getParent();
        }

        return deeperNode;
    }

    private static <E> int getHeight(TreeNode<E> node) {
        int height = 1;
        node = node.getParent();
        while (node != null) {
            height++;
            node = node.getParent();
        }

        return height;
    }
}
