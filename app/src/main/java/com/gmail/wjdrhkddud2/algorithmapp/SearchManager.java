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
     *
     *
     * @param data
     * @param target
     * @return
     */
    public int binarySearch(List<Integer> data, int target) {



    }



}
