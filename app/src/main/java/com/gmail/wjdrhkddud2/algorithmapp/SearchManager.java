package com.gmail.wjdrhkddud2.algorithmapp;

import java.util.List;

public class SearchManager {

    public SearchManager() {

    }

    /** 2022.03.03 Sequential search
     * 순차탐색법은 간단하다. 처음부터 확인하면 된다.
     *
     * @return
     */
    public int sequentialSearch(List<Integer> data, int target) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == target) return i;
        }

        return -1;
    }


    /** 2022.03.03 Binary search
     * 이진탐색법,
     * 업다운 게임과 비슷하다.
     * 정렬된 데이터를 기준으로 중간값 대비 찾으려는 값이 큰지 작은지 비교해서 쪼개나간다.
     *
     * @param target
     * @return
     */
    public int binarySearch(List<Integer> sortedData, int target) {

        return realBinarySearch(sortedData, target, 0, sortedData.size() - 1);

    }

    private int realBinarySearch(List<Integer> sortedData, int target, int low, int high) {

        //중간 index
        int middle = (low + high) / 2;

        if (target > middle) {

            return realBinarySearch(sortedData, target, low, middle - 1);

        } else if (target < middle) {

            return realBinarySearch(sortedData, target, middle + 1, high);
        } else {
            return middle;
        }

    }

    /** 2022.03.03 Binary search tree
     * 이진탐색트리는 이진탐색이 쉬운 트리라고 생각해도 된다.
     * 완전이진트리로 구성되어 있고
     * 부모노드보다 작은 값은 왼쪽 자식으로, 큰 값은 오른쪽 자식으로 구성한다.
     * 이러한 특성으로 인해 같은 값은 허용되지 않는다.
     * 삽입/수정/삭제가 빈번히 일어날 때 유용하고 값이 많더라도 검색이 빠르다.
     *
     *
     * @param list
     * @return
     */

    public List<Integer> convertListToBinarySearchTree(List<Integer> list) {



        return list;
    }



}
