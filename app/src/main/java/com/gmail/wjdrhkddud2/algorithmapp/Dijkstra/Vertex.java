package com.gmail.wjdrhkddud2.algorithmapp.Dijkstra;

public class Vertex {
    private int id;
    private boolean isVisited;
    private int distance;

    public Vertex(int id, boolean isVisited) {
        this.id = id;
        this.isVisited = isVisited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
