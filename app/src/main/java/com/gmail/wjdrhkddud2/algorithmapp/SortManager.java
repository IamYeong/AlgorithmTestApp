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

    /** 셸이라는 사람이 만든 삽입정렬 보완 방법
     *  기존 삽입정렬은 한칸씩 이동하면서 만약 필요하다면 이전 값을 하나씩 모두 옮겨야 했기 때문에 O(n^2) 이었으나
     * 셸정렬은 큰 간격 기준으로 옮겨가면서 그 간격을 점차 줄이며 삽입정렬을 하기 때문에 평균적으로 O(n^1.5) 이지만
     * 가장 최악의 경우에는 O(n^2) 이다.
     * @param data
     * @return
     */
    public List<Integer> shellSort(List<Integer> data) {

        int gap, i;
        int k = data.size();

        for (gap = k / 2; gap > 0; gap /= 2) {

            if (gap % 2 == 0) {
                gap++;
            }

            for (i = 0; i < gap; i++) {

                insertionForShell(data, gap, i, data.size());

            }

        }


        return data;
    }

    private void insertionForShell(List<Integer> data, int gap, int start, int last) {

        int i, j;

        for (i = start + gap; i < last; i += gap) {

            int key = data.get(i);

            for (j = i - gap; j >= 0; j -= gap) {

                int ref = data.get(j);

                if (ref < key) {
                    break;
                }

                data.set(j + gap, ref);

            }

            data.set(j + gap, key);

        }

    }

    public List<Integer> quickSort(List<Integer> data, int left, int right) {

        if (left < right) {
            int pivotIndex = partition(data, left, right);
            quickSort(data, left, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, right);
        }

        return data;
    }

    private int partition(List<Integer> list, int left, int right) {

        int pivot;

        pivot = list.get(left);
        int low = left;
        int high = right + 1;

        do {

            do {
                low++;

                //매개변수로 전달 받은 리스트에서
                //가장 오른쪽 인덱스보다 가장 왼쪽에서 전진하는 low 인덱스가 이하인지,
                //low 번째 요소가 기준값인 pivot 보다 작은지 확인하여
                //맞다면 right 방향으로 한 칸 더 전진
            } while ((low <= right) && (list.get(low) < pivot));

            do {

                high--;

            } while ((high >= left) && (list.get(high) > pivot));

            if (low < high) {
                int temp = list.get(low);
                list.set(low, list.get(high));
                list.set(high, temp);
            }

        } while (low < high);

        int temp = list.get(left);
        list.set(left, list.get(high));
        list.set(high, temp);
        //피벗의 위치
        return high;

    }

    private void swap(List<Integer> list, int n, int m) {

        int temp = list.get(n);
        list.set(n, list.get(m));
        list.set(m, temp);
    }


    public List<Integer> countingSort(List<Integer> data) {

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
