package com.gmail.wjdrhkddud2.algorithmapp.Dijkstra;

public class DijkstraTest {

    private int n; //꼭지점 수를 변수로 선언
    private int[][] weight; //2차원 배열 weight에 각 꼭지점의 가중치를 저장
    private String[] saveRoute;
    private String[] vertex = {"a","b","c","d","e","f","g","z"};

    public DijkstraTest(int n) {
        this.n = n; //정점갯수
        weight = new int[n][n]; //정점갯수만큼의 행/열을 가진 가중치배열
        saveRoute = new String[n];
    }

    //해당하는 vertex 의 index 를 반환한다.
    public int stringToInt(String s) {

        int x = 0;
        for(int i=0; i<vertex.length; i++) {
            if(vertex[i].equals(s)) x = i;
        }

        return x;
    }

    //입력된 정점 사이의 가중치를 수동설정
    public void input(String v1, String v2, int w) {

        int x1 = stringToInt(v1);
        int x2 = stringToInt(v2);

        weight[x1][x2] = w;
        weight[x2][x1] = w;
    }

    public void algorithm(String a) {
        boolean[] visited = new boolean[n]; //각 꼭지점의 방문 여부
        int[] distance = new int[n]; //시작 꼭지점에서부터 각 꼭지점까지의 거리

        for(int i=0; i < n; i++) {

            //무한대 대신 최댓값으로 초기화
            distance[i] = Integer.MAX_VALUE;
        }

        int x = stringToInt(a); //문자열로 입력된 시작 꼭지점을 해당되는 숫자 인덱스 x로 바꾸고
        distance[x] = 0; //시작 꼭지점 x의 거리를 0으로 초기화하고,
        visited[x] = true; //방문 꼭지점이므로 true값 저장
        saveRoute[x] = vertex[x]; //경로는 자기자신

        for(int i = 0; i < n; i++) {

            //시작점과 인접한(가중치가 0이 아닌) 정점 중 방문 안 한 곳 거리업데이트
            if(!visited[i] && weight[x][i] != 0) {
                distance[i] = weight[x][i];
                saveRoute[i] = vertex[x];
            }
        }


        for(int i = 0; i < n - 1; i++) {
            int minDistance = Integer.MAX_VALUE; //최단거리 minDistance에 일단 가장 큰 정수로 저장하고,
            int minVertex = -1; //그 거리값이 있는 인덱스 minIndex에 -1을 저장해둔다.

            for(int j = 0; j < n; j++) {

                //거리정보가 있는 곳 중 가장 가중치가 작은 정점을 탐색 후 방문
                if(!visited[j] && distance[j] != Integer.MAX_VALUE) {

                    if(distance[j] < minDistance) {
                        minDistance = distance[j];
                        minVertex = j;
                    }
                }

            }

            visited[minVertex] = true; //위의 반복문을 통해 도출된 가장 가까운 꼭지점에 방문 표시

            for(int j = 0; j < n; j++) {
                //방문하지 않았고 minVertex와의 가중치가 존재하는(minVertex에서 연결된) 꼭지점이라면
                if(!visited[j] && weight[minVertex][j]!=0) {
                    //지금 그 꼭지점이 가지고 있는 거리값이 minVertex와 가중치를 더한 값보다 크다면 최단거리 갱신
                    if(distance[j]>distance[minVertex]+weight[minVertex][j]) {
                        distance[j] = distance[minVertex]+weight[minVertex][j];
                        saveRoute[j] = vertex[minVertex]; //최단거리가 갱신된 꼭지점의 경로에 minVertex에 해당하는 꼭지점 저장
                    }
                }
            }
        }
        //시작 꼭지점부터 특정 꼭지점까지의 거리 출력
        for(int i=0; i<n; i++) {
            System.out.println("시작 꼭지점 "+a+"부터 꼭지점 "+vertex[i]+"까지의 거리 :"+distance[i]);
        }

        System.out.println("==================================");

        //시작 꼭지점부터 특정 꼭지점까지의 경로 출력
        for(int i=0; i<n; i++) {
            StringBuilder route = new StringBuilder();
            System.out.println("시작 꼭지점 "+a+"부터 꼭지점 "+vertex[i]+"까지의 경로");
            int index = i;
            while(true) {
                if(saveRoute[index].equals(vertex[index])) break;

                route.append(" ").append(saveRoute[index]);
                index = stringToInt(saveRoute[index]);
            }
            StringBuilder sb = new StringBuilder(route.toString());
            System.out.println(sb.reverse() + vertex[i]);
        }
    }
}
