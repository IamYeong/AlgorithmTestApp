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
     */
    public void insertNode(int value) {

        if (root == null) {
            root = new BinaryTreeNode<>(value);

        } else {

            BinaryTreeNode<Integer> currentNode = root;
            BinaryTreeNode<Integer> parentNode = null;

            while (true) {

                parentNode = currentNode;

                if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(new BinaryTreeNode<>(value));
                        return;
                    }
                } else {

                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(new BinaryTreeNode<>(value));
                        return;
                    }
                }

            }


        }


    }

    /** 2022.03.05 이진탐색트리의 삭제
     * 삭제할 값을 내려가면서 쭉 탐색을 하고,
     * 삭제할 노드의 자식이 없는 경우, 한개인경우, 두개인 경우를 나눠서 구성한다.
     *
     */
    public void deleteNode(int value) {

        if (root == null) return;

        //먼저 탐색을 한다.
        BinaryTreeNode<Integer> deleteTargetNode = root;
        BinaryTreeNode<Integer> parentNode = root;
        boolean isLeft = false;

        if (root.getValue() == value) {
            root = null;
        } else {

            BinaryTreeNode<Integer> currentNode = root;
            while (currentNode.getValue() != value) {

                parentNode = currentNode;

                if (currentNode.getValue() > value) {
                    isLeft = true;
                    currentNode = currentNode.getLeftChild();
                } else {
                    isLeft = false;
                    currentNode = currentNode.getRightChild();

                }

                if (currentNode == null) return;

            }

            //둘 다 없는 경우
            if (deleteTargetNode.getLeftChild() == null && deleteTargetNode.getRightChild() == null) {
                if (isLeft) parentNode.setLeftChild(null);
                else parentNode.setRightChild(null);

                //왼쪽만 있는 경우
            } else if (deleteTargetNode.getRightChild() == null) {

                if (isLeft) parentNode.setLeftChild(deleteTargetNode.getLeftChild());
                else parentNode.setRightChild(deleteTargetNode.getLeftChild());

                //오른쪽만 있는 경우
            } else if (deleteTargetNode.getLeftChild() == null) {

                if (isLeft) parentNode.setLeftChild(deleteTargetNode.getRightChild());
                else parentNode.setRightChild(deleteTargetNode.getRightChild());

                //둘 다 있는 경우
            } else {

                BinaryTreeNode<Integer> minimumNode = getMinimumNode(deleteTargetNode);

                if (isLeft) {
                    parentNode.setLeftChild(minimumNode);
                } else {
                    parentNode.setRightChild(minimumNode);
                }

                minimumNode.setLeftChild(deleteTargetNode.getLeftChild());
                minimumNode.setRightChild(deleteTargetNode.getRightChild());

            }

        }

    }

    private BinaryTreeNode<Integer> getMinimumNode(BinaryTreeNode<Integer> deleteTargetNode) {

        BinaryTreeNode<Integer> parent = deleteTargetNode;
        BinaryTreeNode<Integer> minimum = deleteTargetNode.getRightChild();

        while (true) {
            if (minimum.getLeftChild() == null) {
                parent.setLeftChild(null);
                return minimum;
            } else {

                parent = minimum;
                minimum = minimum.getLeftChild();

            }
        }

    }

    public void selectTree(BinaryTreeNode<Integer> parentNode) {

        if (parentNode == null) {
            return;
        } else {
            System.out.println(parentNode.getValue());
        }

        if (parentNode.getLeftChild() == null) {
            return;
        } else {
            System.out.println(parentNode.getLeftChild().getValue());
            selectTree(parentNode.getLeftChild());
        }

        if (parentNode.getRightChild() == null) {
            return;
        } else {
            System.out.println(parentNode.getRightChild().getValue());
            selectTree(parentNode.getRightChild());
        }


    }

    public BinaryTreeNode<Integer> getRoot() {
        return root;
    }
}
