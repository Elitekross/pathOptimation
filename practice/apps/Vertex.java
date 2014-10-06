/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice.apps;

/**
 *
 * @author Meyer
 */
public class Vertex {
    Vertex[] neighbors;
    Edge[] neighborEdge;
    public void displayNeighbors() {
        System.out.println(this + " " + this.neighbors.length);
        for (int i = 0; i < this.neighbors.length; i++) {
            System.out.println("   " + neighbors[i] + " " + neighborEdge[i].distance);
        }
    }
    public void addNeighbor(Vertex newVertex) {
        boolean check = false;
        for (Vertex neighbor : this.neighbors) {//checks if newVertex is a neighbor of this
            check = (neighbor == newVertex);
            if (check) break;
        }
        if (!check) {//adds newVertex to this's neighbors
            Vertex[] neighbor1 = new Vertex[this.neighbors.length + 1];
            System.arraycopy(this.neighbors, 0, neighbor1, 0, neighbor1.length - 1);
            neighbor1[neighbor1.length - 1] = newVertex;
            this.neighbors = neighbor1;
            Edge[] edge1 = new Edge[this.neighborEdge.length + 1];
            System.arraycopy(this.neighborEdge, 0, edge1, 0, edge1.length - 1);
            edge1[edge1.length - 1] = new Edge(this, newVertex, -1);
            this.neighborEdge = edge1;
        }
        check = false;
        for (Vertex neighbor : newVertex.neighbors) {//checks if this is a neighbor of newVertex
            check = (neighbor == this);
            if (check) break;
        }
        if (!check) {//adds this to newVertex's neighbors.
            Vertex[] neighbor2 = new Vertex[newVertex.neighbors.length + 1];
            System.arraycopy(newVertex.neighbors, 0, neighbor2, 0, neighbor2.length - 1);
            neighbor2[neighbor2.length - 1] = this;
            newVertex.neighbors = neighbor2;
            Edge[] edge2 = new Edge[newVertex.neighborEdge.length + 1];
            System.arraycopy(newVertex.neighborEdge, 0, edge2, 0, edge2.length - 1);
            edge2[edge2.length - 1] = new Edge(newVertex, this, -1);
            newVertex.neighborEdge = edge2;
        }
        this.refactorEdges();
    }
    
     public void addNeighbor(Vertex newVertex, Edge newEdge) {
        boolean check = false;
        for (Vertex neighbor : this.neighbors) {//checks if newVertex is a neighbor of this
            check = (neighbor == newVertex);
            if (check) break;
        }
        if (!check) {//adds newVertex to this's neighbors
            Vertex[] neighbor1 = new Vertex[this.neighbors.length + 1];
            System.arraycopy(this.neighbors, 0, neighbor1, 0, neighbor1.length - 1);
            neighbor1[neighbor1.length - 1] = newVertex;
            this.neighbors = neighbor1;
            Edge[] edge1 = new Edge[this.neighborEdge.length + 1];
            System.arraycopy(this.neighborEdge, 0, edge1, 0, edge1.length - 1);
            edge1[edge1.length - 1] = newEdge;
            this.neighborEdge = edge1;
        }
        check = false;
        for (Vertex neighbor : newVertex.neighbors) {//checks if this is a neighbor of newVertex
            check = (neighbor == this);
            if (check) break;
        }
        if (!check) {//adds this to newVertex's neighbors.
            Vertex[] neighbor2 = new Vertex[newVertex.neighbors.length + 1];
            System.arraycopy(newVertex.neighbors, 0, neighbor2, 0, neighbor2.length - 1);
            neighbor2[neighbor2.length - 1] = this;
            newVertex.neighbors = neighbor2;
            Edge[] edge2 = new Edge[newVertex.neighborEdge.length + 1];
            System.arraycopy(newVertex.neighborEdge, 0, edge2, 0, edge2.length - 1);
            edge2[edge2.length - 1] = newEdge.compliment();
            newVertex.neighborEdge = edge2;
        }
        this.refactorEdges();
    }
    
    private void refactorEdges() {
        for (int i = 0; i < this.neighbors.length; i++) { //iterates through all neighbor vertexs
            for (int j = 0; j < this.neighbors[i].neighborEdge.length; j++) {//iterates through all neighbor vertex's edges
                if (this.neighborEdge[i].equals(this.neighbors[i].neighborEdge[j])) {//if two edges are found to be equal
                    int a = this.neighborEdge[i].distance;
                    int b = this.neighbors[i].neighborEdge[j].distance;
                    if (a != b) {//average their distances and set both to this average;
                        a = (a + b) / 2;
                        b = a;
                    }
                    
                }
            }
        }
    }
    
    public int distanceBetween(Vertex b) {
        Edge test = new Edge(this, b, 0);
        for (Edge each : this.neighborEdge) {
            if (test.equals(each)) {
                test.distance = each.distance;
            }
        }
        return test.distance;
    }
    Vertex (Vertex... neighbor) {
        this.neighbors = new Vertex[neighbor.length];
        System.arraycopy(neighbor, 0, this.neighbors, 0, this.neighbors.length);
        this.neighborEdge = new Edge[neighbor.length];
        for (int i = 0; i < this.neighborEdge.length; i++) {
            this.neighborEdge[i] = new Edge(this, this.neighbors[i], (int)(Math.random()*10));
        }
    }
    Vertex () {
        this.neighbors = new Vertex[0];
        this.neighborEdge = new Edge[0];
    }
}
