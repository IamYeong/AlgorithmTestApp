package com.gmail.wjdrhkddud2.algorithmapp;

import java.util.List;

public class SortManager {

    public SortManager() {}

    /** 2022.02.14 Bubble sort
     *  이웃한 데이터들을 비교하며 가장 큰 데이터를 가장 뒤로 보내며 정렬한다.
     *  전체에서 가장 큰 데이터가 맨 뒤, 맨 뒤로 하나 보냈으니 전체 - 1에서 가장 큰 수를 맨 뒤에서 -1 번쨰로.... 반복
     *  O(n^2)
     * @param data
     * @return
     */
    public List<Integer> bubbleSort(List<Integer> data) {

        for (int i = data.size(); i >= 0; i--) {

            for (int j = 1; j < i; j++) {

                int n = data.get(j);
                int m = data.get(j - 1);

                if (m > n) {
                    data.set(j, m);
                    data.set(j - 1, n);
                }

            }

        }

        return data;
    }

    /** 2022.02.14 Selectoin sort
     * 가장 작은 값을 찾아서 차례차례 처음부터 채워나가는 방식
     * O(n^2)
     * @param data
     * @return
     */
    public List<Integer> selectionSort(List<Integer> data) {


        for (int i = 0; i < data.size(); i++) {

            int selectIndex = i;

            for (int j = i; j < data.size(); j++) {

                if (data.get(selectIndex) > data.get(j)) {
                    selectIndex = j;

                }

            }

            int min = data.get(selectIndex);
            data.set(selectIndex, data.get(i));
            data.set(i, min);


        }


        return data;
    }

    /**
     *
     * O(n^2)
     * @param data
     * @return
     */
    public List<Integer> insertionSort(List<Integer> data) {


        return data;
    }




}
