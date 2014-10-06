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
public class Edge {
    Vertex vertex1;
    Vertex vertex2;
    int distance;
    private boolean equals(Edge a) {
        return (this.vertex1 == a.vertex1 && this.vertex2 == a.vertex2) || (this.vertex2 == a.vertex1 && this.vertex1 == a.vertex2);
    }
    public Edge compliment() {
        return new Edge(this.vertex2, this.vertex1, this.distance);
    }
    public boolean edgeOf(Vertex a, Vertex b) {
        return this.equals(new Edge(a, b));
    }
    Edge (Vertex a, Vertex b, int distance) {
        this.distance = distance;
        this.vertex1 = a;
        this.vertex2 = b;
    }
    Edge (Vertex a, Vertex b) {
        this.distance = -1;
        this.vertex1 = a;
        this.vertex2 = b;
    }
    Edge () {
        this.distance = -1;
        this.vertex1 = new Vertex();
        this.vertex2 = new Vertex();
    }
}
