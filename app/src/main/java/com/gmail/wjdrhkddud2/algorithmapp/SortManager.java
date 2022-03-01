package com.gmail.wjdrhkddud2.algorithmapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class SortManager {



    public SortManager() {


    }

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
     * 2. pivot의 index 를 제외하고 나머지 부분은 왼쪽과 오른쪽에서 좁혀오면서 pivot크기를 기준으로 교환해나간다.
     * 왼쪽 커서와 오른쪽 커서가 교차할 때 반복이 끝나면서 pivot을 올바른 위치와 교환한다.
     *
     * 3. pivot을 기준으로 왼쪽과 오른쪽은 또 다시 분리교환의 대상이 되는 부분리스트다.
     * 4. 반복해나가면 부분리스트들이 1개만 남았을 때 모든 정렬이 완료된다.
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



    /** 22.02.22 Counting sort
     *
     * 신기한 정렬방법이다. 조건만 맞는다면 이 방법을 써야 한다.
     * 왜냐하면 값의 비교가 없이 index 를 활용하기 때문에 O(n) 의 효율이다.
     * 정렬이 안 된 배열이 있을 때, 해당 배열의 수 범위 만큼 새로운 배열을 만들어준다.
     * 0~999 의 수가 중복허용 조건으로 섞여있을 때 index 가 999까지 있는(length 가 1000인) 배열을 새로 만들어 준다.
     * 이후 반복문으로 정렬이 안 된 배열을 순회하며 값이 몇 번 등장했는지 counting 하면서 새로 만들었던 counting 배열에
     * 해당하는 index 값을 1씩 올려준다. 예를 들어 555라는 값이 3번 나왔다면 counting[555] 의 값은 3이 된다.
     * 이 counting 값들을 작은 index 에서 큰 index 순으로 누적시켜준다.
     * 그러면 신기하게도 값을 상징하는 counting 배열의 index 안에 들어있는 값은 실제 해당 값이 위치해야 할 (inde + 1) 이 된다.
     * 따라서 1을 뺴준 값에 해당하는 index 에 counting 배열 index 를 넣어주면 값의 정렬이 되는 것이다.
     * 이 말을 코드로 풀어보면 각 값의 등장횟수를 누적까지 시킨 counting[] 배열이 있고, 정렬이 안 된 array[] 가 있다면
     * array[counting[i] - 1] = i;
     *
     * 단, 수의 범위만큼 counting 배열의 길이가 커지므로 수의 범위가 적당한지 확인해봐야 한다.
     *
     * @param data
     * @return
     */

    public List<Integer> countingSort(List<Integer> data) {

        //값의 범위를 알아야 하기 때문에 최댓값 먼저 탐색
        int max = 0;

        for (int i : data) {
            if (i > max) max = i;
        }

        int[] counting = new int[max + 1];

        //등장횟수 세기 (모두 1일 것임. 이 배열엔 중복된 요소가 없음)
        for (int i : data) {

            counting[i]++;

        }

        //누적하여 큰 인덱스를 무겁게 하여 비교할 필요를 없앰.
        for (int i = 1; i < counting.length; i++) {

            counting[i] += counting[i - 1];

        }

        for (int i = counting.length - 1; i >= 0; i--) {
            data.set(counting[i] - 1, i);
        }

        return data;
    }


    /**
     * 22.02.20 Merge sort
     * 분할 정복 알고리즘이다. 일단 쪼개고 다시 합치면서 정렬을 마친다.
     * 아래 코드는 2way 합병 정렬이다.
     * 솔직히 구현하고 나니 이 이상으로 나누는 건 너무 헷갈릴 것 같기도 하다.
     *
     * 데이터 분포에 영향을 덜 받는 장점이 있고
     * 배열 하나만큼의 공간을 더 차지하고 데이터 이동이 많다는 단점이 있지만
     * 최악의 경우에도 O(n log n) 이기 때문에 효율이 우수하다.
     *
     * 익숙하지 않던 이진트리 방법이었기 떄문에 이해가 잘 안 갔었다.
     * 우선 맨 처음 받은 정렬이 안 된 배열을 루트노드라고 생각한다.
     * 2way니까 반씩 쪼개서 자식노드들을 만든다.
     * 조건식을 이용해 1개씩이 될 때 까지 노드를 이진트리로 나누고
     * 다시 부모노드로 하나씩 올라오면서 인덱스를 이용하여 해당하는 부분을 정렬하며 합친다.
     *
     * 자기 호출을 하며 두개로 나누면 이진트리 검색처럼 최하단 노드까지 내려갔다가 차근차근 올라오는 코드를 짤 수 있지만
     * 모든 함수가 스택에 쌓여있기 때문에 역시 스택오버플로는 주의해야 한다.
     *
     * @param data
     * @return
     */

    public List<Integer> mergeSort(List<Integer> data, int left, int right) {

        int mid;

        if (left < right) {
            //자기호출하면서 부분리스트의 중간 위치도 찾아야 함.

            mid = (left + right) / 2;

            mergeSort(data, left, mid);


            mergeSort(data, mid + 1, right);


            merge(data, left, mid, right);

        }


        return data;
    }

    private void merge(List<Integer> data, int left, int mid, int right) {

        List<Integer> mergeSortedList = new ArrayList<>();

        //i는 왼쪽 노드의 첫번째 인덱스,
        //j는 오른쪽 노드의 첫번째 인덱스,
        //k는 새로운 배열의 인덱스.
        int i, j, k, l;
        i = left;
        j = mid + 1;
        k = left;

        while (i <= mid && j <= right) {

            if (data.get(i) <= data.get(j)) {


                mergeSortedList.add(k++, data.get(i++));
            } else {

                mergeSortedList.add(k++, data.get(j++));
            }

        }

        //위에서 임의의 왼쪽 노드와 오른쪽 노드를 합치며 정렬했지만 아직 남은 부분이 있을 수 있음.
        //어느 부분이 남았냐에 따라 끝까지 배열에 추가해줌.
        if (i > mid) {
            for (l = j; l <= right; l++) {


                mergeSortedList.add(k++, data.get(l));
            }
        } else {
            for (l = i; l <= mid; l++) {


                mergeSortedList.add(k++, data.get(l));
            }

        }

        //병합할 때 마다 해당 인덱스 부분을 복사.
        for (l = left; l <= right; l++) {

            data.set(l, mergeSortedList.get(l));
        }


    }

    public List<Integer> heapSort(List<Integer> base) {

        int len = base.size();
        for(int i = len / 2; i > 0; i--){
            heapify(base,i,len);
        }
        do{
            int tmp = base.get(0);
            base.set(0, base.get(len - 1));
            base.set(len - 1, tmp);
            len = len-1;
            heapify(base,1,len);
        }while(len > 1);

        return base;
    }

    private void heapify(List<Integer> base, int i, int len) {

        int j;
        int tmp = base.get(i - 1);
        while(i<=len/2){ // 자식 존재 여부
            j = i*2;
            if((j<len) && (base.get(j - 1) <base.get(j))){
                j++;
            }
            if(tmp >= base.get(j - 1)){
                break;
            }
            base.set(i - 1, base.get(j - 1));
            i = j;
        }
        base.set(i - 1, tmp);


    }

    private int getParentIndex(int childIndex) {

        return (childIndex - 1) / 2;
    }

    /** 22.03.01 Radix sort
     * 자릿수별로 정렬을 해나가는 방법이다.
     * 자연수 정렬 전 배열이 있다고 했을 때,
     * 각 자릿수는 10진법이므로 0~9 까지 있다.
     * 여기에 카운팅정렬을 적용시키면
     * 10개짜리 배열만 만들어서 각 자릿수별로
     * 0~9에 해당하는 index에 원소가 증가될 것이다.
     * 첫 번 째로 1의자릿수가 0~9 크기대로 정렬될 수 있고
     * 두 번째로 10의 자릿수가 0~9 크기대로 정렬될 수 있다.
     *
     * 여기서 의문은 왜 가장 큰 자릿수부터 정렬을 수행하지 않는가이다.
     *
     * 그것도 한 번 구현해보자.
     *
     * 만약 그 자릿수에 미치지 못 한다면 0으로 취급하면 된다.
     *
     * 지금도 비슷하게 진행되고 있다.
     * 예를 들어 exp가 1000인데 1000이외의 수는 모두 이보다 모자라다면
     * count 배열에서 count[0]만 999 이고 count[1] 만 1일 것이다.
     * count[0]-- 해가며 999개 정렬안된채로 다시 넣고 마지막에 count[1] 을 넣으면 큰 수 부터 정렬 완성.
     *
     *
     * @param data
     * @return
     */
    public List<Integer> radixSort(List<Integer> data) {

        //최대 자릿수만큼만 정렬시키기 위한 변수
        int max = data.get(0);

        for (int i = 1; i < data.size(); i++) {

            int k = data.get(i);
            if (max < k) max = k;

        }

        for (int exp = 1; exp < max; exp *= 10) {

            countingSortForRadix(data, exp);

        }


        return data;
    }

    private void countingSortForRadix(List<Integer> data, int exp) {

        int[] count = new int[10];
        int[] result = new int[data.size()];
        //List<Integer> result = new ArrayList<>();

        //exp로 받은 자릿수의 수를 카운팅함. 0~9 만 나옴
        for (int i = 0; i < data.size(); i++) {
            count[(data.get(i) / exp) % 10]++;
        }

        //누적
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = data.size() - 1; i >= 0; i--) {
            result[count[(data.get(i) / exp) % 10] - 1] = data.get(i);
            count[(data.get(i) / exp) % 10]--;
        }

        //복사
        for (int i = 0; i < data.size(); i++) {
            data.set(i, result[i]);
        }

    }

    /** 22.02.27 Bucket sort
     * 특정 범위안에 데이터가 균등하게 분포해있을 때 쓰기 좋은 정렬,
     * 2차원배열형태로 만든 bucket 배열을 이용해서 정렬한다.
     * 특정 범위별로 각 바구니(bucket)에 수를 집어 넣는다.
     * 예를 들어 0~10, 11~20 이런식이다.
     * 그 뒤 바구니별로 다시 삽입정렬해준다.(정렬방법 상관없음)
     * 바구니에서 차례대로 수를 꺼내오면 정렬된다.
     *
     * 예시들은 0~1 이었지만
     * 아래의 배열은 0~999이다.
     * bucket 의 간격을 100으로 잡고
     * 각 요소 / 간격 을 해준 결과만큼의 index 에 값을 넣으면 된다.
     * ex) bucket[(int)(data.get(i) / interval)].add(data.get(i));
     * 예를 들어 995는 9.95가 된 후 9로 형변환돼서 900 ~ 1000을 의미하는 index에 들어간다.
     *
     * 바구니별로 정렬 후 순서대로 꺼내오기만 하면 된다.
     *
     * 이걸 여러 수의 범위에 적용시키는 것이 고민이긴 하지만
     * 이미 어떤 방법인지 이해했기 때문에 개념만 알고 있고,
     * 적절할 때 찾아서 쓸 수 있는 것이 핵심이다.
     * @param data
     * @return
     */

    public List<Integer> bucketSort(List<Integer> data) {

        int interval = 100;
        LinkedList[] bucket;

        //1. 최댓값 고르기
        int max = data.get(0);
        for (int ref : data) {
            if (max < ref) max = ref;
        }

        //2. 수동으로 설정한 텀대로 나눌 수 있는 버킷 만들기
        //3. 일정 갯수의 바구니를 생성했고, 최악의 경우 한 바구니에 몰릴 수도 있으므로
        //각 바구니는 정렬할 배열만큼의 크기를 가짐.

        bucket = new LinkedList[(max / interval) + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList();
        }

        //바구니에 넣기
        for (int i = 0; i < data.size(); i++) {

            int ref = data.get(i);
            bucket[ref / interval].add(ref);

        }

        //바구니별 정렬하기
        for (int i = 0; i < bucket.length; i++) {

            Collections.sort(bucket[i]);

        }

        int index = 0;
        //각 값을 순서대로 꺼내서 정렬하기
        for (int i = 0; i < bucket.length; i++) {

            for (int j = 0; j < bucket[i].size(); j++) {

                data.set(index++, (int)bucket[i].get(j));

            }

        }

        return data;
    }

    private void swap(List<Integer> list, int n, int m) {

        int temp = list.get(n);
        list.set(n, list.get(m));
        list.set(m, temp);
    }

}
