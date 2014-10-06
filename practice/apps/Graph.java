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
public class Graph {
    Vertex[] members;
    public void addVertex( Vertex newVertex) {
        for (Vertex neighbor : newVertex.neighbors) {
            neighbor.addNeighbor(newVertex);
        }
        // add the new vertex to the list of members
        Vertex[] newMembers = new Vertex[this.members.length + 1];
        System.arraycopy(this.members, 0, newMembers, 0, newMembers.length - 1);
        newMembers[newMembers.length - 1] = newVertex;
        this.members = newMembers;
    }
    public int findDistance (Vertex initial, Vertex destination) {
        int result = -1;
        //create array of unvisited verticies
        Vertex[] unvisited = new Vertex[this.members.length];
        System.arraycopy(this.members, 0, unvisited, 0, unvisited.length);
        //create array of edges to record the tenative distances, -1 is infinity
        Edge[] tenative = new Edge[this.members.length];
        for (int i = 0; i < unvisited.length; i++) {
            if (initial != unvisited[i]) {
               tenative[i] = new Edge(initial, unvisited[i]);
            } else {
                tenative[i] = new Edge(initial, initial, 0);
            }
        }
        Vertex current = initial;
        while (this.isIn(unvisited, destination)) {
            //records the tenative edge for the current vertex, for ease
            Edge currentEdge = new Edge();
            for (Edge each : tenative) {
                if (each.edgeOf(initial, current)) {
                    currentEdge = each;
                }
            }
            Edge neighborEdge = new Edge();
            Edge neighborTenative = new Edge();
            //itterates through current's neighbors
            for (Vertex eachNeighbor : current.neighbors){
                if (this.isIn(unvisited, eachNeighbor)) {
                    //finds the ddge between current and neighbor
                    for (Edge eachEdge : current.neighborEdge) {
                        if(eachEdge.edgeOf(current, eachNeighbor)) {
                            neighborEdge = eachEdge;
                        }
                    }
                    //finds tenative edge to neighbor 
                    for (Edge eachEdge : tenative) {
                        if(eachEdge.edgeOf(initial, eachNeighbor)){
                            neighborTenative = eachEdge;
                        }
                    }
                    int a = neighborTenative.distance;
                    int b;
                    //if either the current edge's distance is infinty or the distance between current and the neighbor is, b is infity
                    if (currentEdge.distance == -1 || neighborEdge.distance == -1) {
                        b = -1;
                    } else {
                        b = currentEdge.distance + neighborEdge.distance;
                    }
                    neighborTenative.distance = Graph.min(a, b);
                }
            }
            Vertex[] cycle = new Vertex[unvisited.length - 1];
            int count = 0;
            //removes current from unvisited
            for (Vertex each : unvisited) {
                if (!each.equals(current)) {
                    cycle[count] = each;
                    count++;
                }
            }
            unvisited = new Vertex[cycle.length];
            System.arraycopy(cycle, 0, unvisited, 0, unvisited.length);
            if (unvisited.length == 0) {
                break;
            }
            //sets current to the unvisited point with the shortest distance
            current = unvisited[0];
            for (Edge each : tenative) {
                if (each.edgeOf(initial, current)) {
                    currentEdge = each;
                }
            }
            Edge testEdge = new Edge();
            for (int i = 0; i < unvisited.length; i++) {
                for (Edge each : tenative) {
                    if (each.edgeOf(initial, unvisited[i])){
                        testEdge = each;
                    }
                }
                if (testEdge.distance <= currentEdge.distance) {
                    current = unvisited[i];
                    for (Edge each : tenative) {
                        if (each.edgeOf(initial, current)) {
                            currentEdge = each;
                        }
                    }
                }
            }
        }
        Edge currentEdge = new Edge();
        for (Edge each : tenative) {
            if (each.edgeOf(initial, destination)) {
                currentEdge = each;
            }
        }
        result = currentEdge.distance;
        return result;
    }
    private boolean isIn(Vertex[] set, Vertex element) {
        boolean in = false;
        for (Vertex each : set) {
            in = (element == each);
            if (in) break;
        }
        return in;
    }
    public static int min(int a, int b) {
        int min;
        if (a >= b) {
            if (b == -1) {
                min = a;
            } else {
                min = b;
            }
        } else {
            if (a == -1) {
                min = b;
            } else {
                min = a;
            }
        }
        return min;
    }
    Graph () {
        this.members = new Vertex[0];
    }
    Graph (Vertex... members) {
        this.members = new Vertex[members.length];
        System.arraycopy(members, 0, this.members, 0, this.members.length - 1);
    }
}
