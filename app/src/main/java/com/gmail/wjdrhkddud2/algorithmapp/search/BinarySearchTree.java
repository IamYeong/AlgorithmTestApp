package com.gmail.wjdrhkddud2.algorithmapp.search;

/** 2022.03.05 Binary search tree
 * Node 는 다형성을 위해서 제네릭으로 구현했지만
 * 트리의 탐색알고리즘을 위해서는 값 간의 비교 연산자를 써야 하기 때문에
 * Integer 형으로 구현했다.
 * 물론 더 고민해보면 방법은 많겠지만 설계까지 고민할 시간여유는 없으므로 보류한다.
 *
 */
public class BinarySearchTree {

    private BinaryTreeNode<Integer> root = null;

    /** 2022.03.05
     * 이진트리탐색의 탐색은 쉽다.
     * 루트노드부터 대소관계를 반복문으로 비교하면서
     * 맞다면 노드를 반환하도록 했다.
     * 어차피 값이 중복허용도 안 되고 인덱스를 반환하는 것도 아니기 때문에
     * 특정 노드를 반환하기만 하면 알아서 자식노드들 정보도 같이 반환되는 것이기 때문에
     * 적절하지 않나 한다.
     *
     * @param target
     * @return
     */
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

    /** 2022.03.05 이진탐색트리의 삽입
     * 삽입도 쉽다.
     * 대소관계를 비교하면서 자식이 있는지 확인하길 반복하다가
     * 값이 비어있는 대소관계 조건이 맞는 자리에 들어가기만 하면 된다.
     *
     *
     * @param node
     */
    public void insertNode(BinaryTreeNode<Integer> node) {

        if (root == null) {
            root = node;

        } else {

            BinaryTreeNode<Integer> currentNode = root;
            BinaryTreeNode<Integer> parentNode = null;

            while (true) {

                parentNode = currentNode;

                if (node.getValue() < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(node);
                        return;
                    }
                } else {

                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(node);
                        return;
                    }
                }

            }


        }


    }

    /** 2022.03.05 이진탐색트리의 삭제
     *
     *
     */
    public void deleteNode() {

    }

}
