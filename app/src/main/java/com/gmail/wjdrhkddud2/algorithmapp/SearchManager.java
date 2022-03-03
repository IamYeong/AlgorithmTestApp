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




}
