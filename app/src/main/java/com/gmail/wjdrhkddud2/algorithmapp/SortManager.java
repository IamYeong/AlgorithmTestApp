package com.gmail.wjdrhkddud2.algorithmapp;

import java.util.List;

public class SortManager {

    public SortManager() {}

    /** 2022.02.14 Bubble sort
     *  이웃한 데이터를 비교하여 가장 큰 값을 서서히 뒤로 보내면서 탐색범위를 좁혀가는 정렬방식
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
     * 탐색범위를 한 칸씩 좁혀나가며 가장 작은 값을 처음부터 차례차례 채우는 정렬방식
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

    /** 22.02.15 Insertion sort
     * 순차적으로 값을 하나 뽑아서 그 앞에 있는 값들과 하나씩 비교하여 알맞은 위치에 삽입해가는 정렬이다.
     * 다만 i가 1일 때 헷갈려서 고생했다.
     * 이 때 넣는 곳 이후의 값들은 모두 뒤로 밀어야 하기 때문에 일이 많아져서
     * 값이 많을 수록 느리다.
     * O(n^2)
     * @param data
     * @return
     */
    public List<Integer> insertionSort(List<Integer> data) {

        int i = 0;
        int j = 0;

        for (i = 1; i < data.size(); i++) {

            int key = data.get(i);

            for (j = i - 1; j >= 0; j--) {

                int m = data.get(j);

                if (m < key) {
                    break;
                }

                data.set(j + 1, m);

            }

            data.set(j + 1, key);

            //System.out.println(i);

        }

        return data;
    }

    /** 셸이라는 사람이 만든 삽입정렬 보완보전
     *
     * @param data
     * @return
     */
    public List<Integer> shellSort(List<Integer> data) {



        return data;
    }

    public List<Integer> countingSort(List<Integer> data) {

        return data;
    }

    public List<Integer> quickSort(List<Integer> data) {

        return data;
    }

    public List<Integer> mergeSort(List<Integer> data) {

        return data;
    }

    public List<Integer> heapSort(List<Integer> data) {

        return data;
    }

    public List<Integer> radixSort(List<Integer> data) {

        return data;
    }
    public List<Integer> bucketSort(List<Integer> data) {

        return data;
    }


}
