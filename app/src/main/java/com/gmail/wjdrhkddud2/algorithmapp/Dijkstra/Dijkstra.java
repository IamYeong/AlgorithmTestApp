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

    }

    //Add weight both a and b
    public void addWeight(int a, int b, int weight) {

        //서로 같은 값을 가지고 있으니 무방향 그래프라고 생각할 수 있다.
        weights[a][b] = weight;
        weights[b][a] = weight;
    }


    public void run(int startVertexIndex) {

        //자기 자신으로의 거리 0으로 초기화
        distances[startVertexIndex] = 0;
        isVisit[startVertexIndex] = true;
        //path

        //시작점과 인접한 정점 거리 업데이트
        for (int i = 0; i < vertexes.length; i++) {
            if (!isVisit[i] && (weights[startVertexIndex][i] != 0)) {
                distances[i] = weights[startVertexIndex][i];
            }
        }

        for (int i = 0; i < vertexes.length - 1; i++) {

            int shortestIndex = -1;
            int shortestDistance = Integer.MAX_VALUE;

            //방문 안 했고 거리정보가 있는 곳 중, 가장 짧은 곳을 골라서 방문
            for (int j = 0; j < vertexes.length; j++) {

                if (!isVisit[j] && distances[j] != Integer.MAX_VALUE) {

                    if (shortestDistance > distances[j]) {
                        shortestDistance = distances[j];
                        shortestIndex = j;
                    }

                }

            }

            isVisit[shortestIndex] = true;

            for (int j = 0; j < vertexes.length; j++) {

                //정점을 순회하면서 방문을 아직 안 했고 방금 방문한 정점과 인접한 정점
                if (!isVisit[j] && (weights[shortestIndex][j] != 0)) {

                    //거리업데이트
                    if (distances[j] > (distances[shortestIndex] + weights[shortestIndex][j])) {
                        distances[j] = (distances[shortestIndex] + weights[shortestIndex][j]);
                    }

                }

            }

            //printDistances(startVertexIndex);

        }


        printDistances(startVertexIndex);
    }

    public void printDistances(int start) {

        for (int i = 0; i < distances.length; i++) {

            System.out.print("Distances " + i + " : " + distances[i]);
            //System.out.print(a);

            System.out.println();
            System.out.println();

        }

    }

    public void printPaths(int start) {



    }


}
