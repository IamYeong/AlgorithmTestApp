package com.gmail.wjdrhkddud2.algorithmapp.Dijkstra;

public class Edge {

    private int weight;
    private Vertex leftVertex;
    private Vertex rightVertex;

    public Edge(int weight, Vertex leftVertex, Vertex rightVertex) {
        this.weight = weight;
        this.leftVertex = leftVertex;
        this.rightVertex = rightVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getLeftVertex() {
        return leftVertex;
    }

    public void setLeftVertex(Vertex leftVertex) {
        this.leftVertex = leftVertex;
    }

    public Vertex getRightVertex() {
        return rightVertex;
    }

    public void setRightVertex(Vertex rightVertex) {
        this.rightVertex = rightVertex;
    }
}
