package com.gmail.wjdrhkddud2.algorithmapp.search;

public class BinarySearchTree {

    private BinaryTreeNode<Integer> root = null;

    public BinaryTreeNode<Integer> searchTree(int target) {

        if (root == null) {
            return null;
        } else {

            BinaryTreeNode<Integer> currentNode = root;
            while (currentNode != null) {

                if (currentNode.getValue() > target) {
                    currentNode = currentNode.getLeftChild();
                } else if (currentNode.getValue() < target) {
                    currentNode = currentNode.getRightChild();
                } else {
                    return currentNode;
                }

            }

        }

        return null;
    }

    public void insertNode() {



    }

    public void deleteNode() {

    }

}
