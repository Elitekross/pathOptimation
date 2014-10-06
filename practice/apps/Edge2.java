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
public class Edge2 {
    Vertex2 endpoint1;
    Vertex2 endpoint2;
    double weight;
    
    public boolean equals(Edge2 next) {
        return ((this.endpoint1.equals(next.endpoint1) 
                    && this.endpoint2.equals(next.endpoint2)) 
                || (this.endpoint1.equals(next.endpoint2) 
                    && this.endpoint2.equals(next.endpoint1)))
                && (this.weight == next.weight);
    }
    public boolean edgeOf(Vertex2 endpoint1, Vertex2 endpoint2) {
        return this.equals(new Edge2(endpoint1, endpoint2, this.weight));
    }
    public boolean edgeOf(Vertex2 endpoint1) {
        return this.isIn(endpoint1.neighbors.memberEdges);
    }
    public boolean isIn(Edge2[] set) {
        boolean check = true;
        for (Edge2 each : set) {
            check = check && (each.equals(this));
            if (!check) {
                break;
            }
        }
        return check;
    }
    public boolean isIn(Graph2 graph) {
        return this.isIn(graph.memberEdges);
    }
    Edge2(Vertex2 endpoint1, Vertex2 endpoint2) {
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
        this.weight = -1.0;
    }
    Edge2(Vertex2 endpoint1, Vertex2 endpoint2, double weight) {
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
        this.weight = weight;
    }
}
