package com.gmail.wjdrhkddud2.algorithmapp;

import java.util.Random;

public class Dijkstra {

    private static final int VERTEX_SIZE = 10;

    private boolean[] isVisit;
    private int[][] weights;
    private int[] vertexes;
    private int[] distances;
    private String[] paths;

    public Dijkstra() {

        //0으로 초기화
        vertexes = new int[VERTEX_SIZE];
        weights = new int[VERTEX_SIZE][VERTEX_SIZE];

        //false 로 초기화
        isVisit = new boolean[VERTEX_SIZE];
        distances = new int[VERTEX_SIZE];

        paths = new String[VERTEX_SIZE];

        deployWeights();

    }

    private void deployWeights() {

        //각 정점으로의 거리는 무한대의 의미로 Integer 의 최댓값으로 입력
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < weights.length; i++) {

            for (int j = 0; j < weights.length; j++) {

                if (i == j) {
                    weights[i][j] = 0;

                } else {

                    int randomWeight = (int)(Math.random() * weights.length);
                    weights[i][j] = randomWeight;

                }

                System.out.println(i + " 행, " + j + " 열 : " + weights[i][j]);

            }

        }

    }

    public void run(int startVertexIndex) {

        //자기 자신으로의 거리 0으로 초기화
        distances[startVertexIndex] = 0;

        //자기 자신으로의 방문 완료
        isVisit[startVertexIndex] = true;

        //출력을 위한 경로(2번 정점에서 4번 정점까지의 경로를 출력하면 2, 5, 4 처럼 나오도록)를 저장하는 배열이 paths인데,
        //자기 자신으로의 경로는 하나만 저장하면 되니 미리 출발정점을 문자열로 변환하여 넣어둔다. 2번에서 2번으로 가는 경로는 "2" 하나면 되기 때문이다.
        paths[startVertexIndex] += (startVertexIndex + "");

        for (int i = 0; i < VERTEX_SIZE; i++) {

            //일단 시작점을 기준으로 인접된 점 중에 방문하지 않은 곳을 탐색한다.
            if (!isVisit[i] && weights[startVertexIndex][i] != 0) {

                distances[i] = weights[startVertexIndex][i];
                paths[i] += (startVertexIndex + "");
            }


        }



        printResult(startVertexIndex);
    }

    public void printResult(int start) {

        for (int i = 0; i < paths.length; i++) {

            String a = paths[i];

            System.out.print(start + " Vertex 부터 " + i + " Vertex 까지 최단경로 : ");

            for (int j = 0; j < a.length(); j++) {
                System.out.print(a.charAt(j));
                System.out.print(", ");
            }

            System.out.println();

        }

    }


}
