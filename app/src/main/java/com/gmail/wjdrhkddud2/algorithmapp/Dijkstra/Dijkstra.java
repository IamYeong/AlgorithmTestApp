package com.gmail.wjdrhkddud2.algorithmapp.Dijkstra;

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
            vertexes[i] = i;
            paths[i] = "";
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

        boolean allVisit = false;

        while (true) {

            //하나라도 false 가 있다면 false로 마무리, 모두 true 라면 true 로 마무리.
            allVisit = isVisit[0];
            for (int i = 1; i < isVisit.length; i++) {
                allVisit = (isVisit[i] && allVisit);
            }

            if (allVisit) break;

            //현재 거리 중 가장 짧은데 방문 안 한 곳 방문

            int shortestDistance = Integer.MAX_VALUE;
            int shortestIndex = -1;

            for (int i = 0; i < vertexes.length; i++) {

                if (!isVisit[i] && (distances[i] < shortestDistance)) shortestIndex = i;

            }

            isVisit[shortestIndex] = true;

            //방문한 곳과 인접한 정점 최단거리 업데이트
            for (int i = 0; i < vertexes.length; i++) {

                for (int j = 0; j < vertexes.length; j++) {

                    if (distances[i] > (distances[shortestIndex] + weights[shortestIndex][j])) {
                        distances[i] = (distances[shortestIndex] + weights[shortestIndex][j]);
                    }

                }


            }


        }



        printResult(startVertexIndex);
    }

    public void printResult(int start) {

        for (int i = 0; i < paths.length; i++) {

            String a = paths[i];

            System.out.print(start + " Vertex 부터 " + i + " Vertex 까지 최단경로 : " + a);
            System.out.print("Distances " + i + " : " + distances[i]);
            //System.out.print(a);

            System.out.println();
            System.out.println();

        }

    }


}
