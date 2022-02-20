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
     *
     * 기본적인 삽입정렬은 항상 gap 이 1인 shell 정렬인 것이다.
     * 삽입/교환할 데이터 간의 논리적 거리가 멀 때 삽입정렬의 효율이 가장 나빠지기 때문에
     * 이를 막기 위해서 멀리 떨어져 있는 값을 미리 옮겨두는 것이다.
     * 그리고 gap 만큼 떨어져있는 값들을 부분 배열이라고 보는 것이다.
     *
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

    /**
     * 일반적인 경우에 정렬 시간이 O(n log n) 인 정렬 방법이다.
     * 이름 그대로 가장 빠른 알고리즘이며 특수한 상황을 제외하고서는 가장 좋을 듯 하다.
     * 다만 자기호출이 포함돼있어서 이해가 조금 힘든데,
     * 1. 먼저 pivot 이라는 기준값을 뽑는다.
     * 아래 코드에서는 index 0 번째 값을 pivot 으로 뽑았지만 이 값을 기준으로 부분리스트가 나뉘기 때문에
     * 실제 중간크기의 값을 뽑는 것이 가장 유리하다.
     *
     * 2. 배열의 왼쪽부터
     *
     *
     * @param data
     * @param left
     * @param right
     * @return
     */

    public List<Integer> quickSort(List<Integer> data, int left, int right) {

        if (left < right) {
            //partition() 을 수행하고 나면 pivot 은 중간에 있고,
            //작은 값들은 pivot 왼쪽에, 큰 값들은 pivot 오른쪽에 위치함.
            //마지막으로 pivot 이 어디있는지 반환함.
            int pivotIndex = partition(data, left, right);

            //작은 값들이 모여있는 부분을 대상으로 다시 정렬 및 분할
            quickSort(data, left, pivotIndex - 1);

            //큰 값들이 모여있는 부분을 대상으로 다시 정렬 및 분할 반복복
            quickSort(data, pivotIndex + 1, right);

            //*pivot 을 남기고 왼쪽과 오른쪽을 분할하는 것이 맞음. 현재 pivot 의 위치는 최종 정렬된 데이터를 기준으로 올바른 자리이기 때문임.
        }

        return data;
    }

    private int partition(List<Integer> list, int left, int right) {

        int pivot;

        pivot = list.get(left);
        int low = left;
        int high = right + 1;

        do {
            System.out.println("do");

            do {
                low++;
                System.out.println("low++");

                //전달받은 list 의 가장 왼쪽에서 시작한 low가 가장 오른쪽인 right를 넘지는 않았는지 검사해서
                //IndexOutOfBounds 를 예방하고,
                //low 번쨰 값이 pivot 이상일 때 까지 전진시킨다.
            } while ((low <= right) && (list.get(low) < pivot));

            do {

                high--;
                System.out.println("high--");

                //전달받은 list 의 가장 오른쪽에서 시작한 high 가 가장 왼쪽인 left 를 넘지 않았는지 검사해서 예외예방하고
                //high 번째 값이 pivot 이하일 때 까지 후진시킨다.
            } while ((high >= left) && (list.get(high) > pivot));


            //low 번째 값이 pivot 이상이고 high번째 값이 pivot 이하이면서
            //high 가 low 를 넘지 않았는지 마지막 확인 후에
            //low 번째 값과 high 번째 값을 교환한다.

            //이는 당연한 행위이다.
            //low 부터 시작한 왼쪽에는 pivot 보다 작은 값들만 있어야 하고
            //high 부터 시작한 오른쪽에는 pivot 보다 큰 값들만 있어야 하는데
            //이 조건에 맞지 않는 값들 끼리 교환하면 조건에 맞아간다.

            //그 후, 교환할 값이 아직 교차하지 않았는지 최종 확인 후 교환작업을 하고,
            //서로 교차했을 경우에
            if (low < high) {
                System.out.println("if(low<high)");
                int temp = list.get(low);
                list.set(low, list.get(high));
                list.set(high, temp);
            }

        } while (low < high);

        //큰 while 문을 빠져나오려면 high 가 low 보다 작아져야만 함.
        //그러면 원래 low -->>> <<<-- high 이렇게 움직여서 조건을 통과하다가
        //<<-- high low -->> 이렇게 순서가 뒤집혔을 경우에 탈출하는 것임.
        //그러면 high위치에는 pivot보다 작은 값이 있을 테니
        //high 와 left 를 바꿔주면 완벽함.
        int temp = list.get(left);
        list.set(left, list.get(high));
        list.set(high, temp);

        //피벗의 위치 반환
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
