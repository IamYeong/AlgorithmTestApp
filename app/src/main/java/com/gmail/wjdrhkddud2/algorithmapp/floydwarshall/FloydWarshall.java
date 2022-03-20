package com.gmail.wjdrhkddud2.algorithmapp.floydwarshall;

public class FloydWarshall {

    private int[][] distances;
    private int[][] weights;
    private int[] vertexes;
    private int max;

    public FloydWarshall(int n) {
        distances = new int[n][n];
        weights = new int[n][n];
        vertexes = new int[n];
        max = n;
    }

    public void prepare() {

        for (int i = 0; i < max; i++) {

            for (int j = 0; j < max; j++) {

                if (i == j) {
                    weights[i][j] = 0;
                } else if (weights[i][j] != Integer.MAX_VALUE) {
                    int ramdom = (int)(Math.random() * 10);
                    if (ramdom > 5) ramdom = Integer.MAX_VALUE;
                    weights[i][j] = ramdom;
                    weights[j][i] = ramdom;
                }

            }
        }


    }

    /**
     * i : 경유지
     * j : 출발지
     * k : 도착지
     *
     * 한 정점을 경유지로 놓고 for loop
     * 경유지로 둔 정점을 피해서 출발지 for loop
     * 경유지와 출발지를 피해서 도착지 for loop
     *
     * 현재 알고 있는 출발지 ~ 도착지 거리가
     * 지금 조회해본 출발지 ~ 경유지 + 경유지 ~ 도착지 보다 비효율적이라면
     * 새로운 거리로 업데이트 반복
     *
     * 모든 정점으로부터 모든 정점까지의 최단거리가 있는 distances 2차원배열 완성
     *
     */

    public void run() {

        for (int i = 0; i < max; i++) {

            for (int j = 0; j < max; j++) {

                if (i == j) continue;

                for (int k = 0; k < max; k++) {

                    if ((k == j) || (k == i)) continue;

                    if (distances[j][k] > (distances[j][i] + distances[i][k])) {

                        distances[j][k] = distances[j][i] + distances[i][k];

                    }


                }

            }

        }

    }





}
