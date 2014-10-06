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
public class Vertex2 {
    String label;
    Graph2 neighbors;
    //adds a neighbor and creates an edge of unitialized weight
    public void addNeighbor(Vertex2 newNeighbor) {
        Vertex2[] cycleMembers = new Vertex2[this.neighbors.members.length];
        System.arraycopy(this.neighbors.members, 0, cycleMembers, 0, this.neighbors.members.length - 1);
        this.neighbors.members = new Vertex2[this.neighbors.members.length + 1];
        System.arraycopy(cycleMembers, 0, this.neighbors.members, 0, cycleMembers.length - 1);
        this.neighbors.members[this.neighbors.members.length - 1] = newNeighbor;
        
        Edge2[] cycleMemberEdges = new Edge2[this.neighbors.memberEdges.length];
        System.arraycopy(this.neighbors.memberEdges, 0, cycleMemberEdges, 0, this.neighbors.memberEdges.length - 1);
        this.neighbors.memberEdges = new Edge2[this.neighbors.memberEdges.length + 1];
        System.arraycopy(cycleMembers, 0, this.neighbors.memberEdges, 0, cycleMembers.length - 1);
        this.neighbors.memberEdges[this.neighbors.memberEdges.length - 1] = new Edge2(this, newNeighbor);
    }
    //adds a neighbor and its associated edge
    public void addNeighbor(Vertex2 newNeighbor, Edge2 newNeighborEdge) {
        Vertex2[] cycleMembers = new Vertex2[this.neighbors.members.length];
        System.arraycopy(this.neighbors.members, 0, cycleMembers, 0, this.neighbors.members.length - 1);
        this.neighbors.members = new Vertex2[this.neighbors.members.length + 1];
        System.arraycopy(cycleMembers, 0, this.neighbors.members, 0, cycleMembers.length - 1);
        this.neighbors.members[this.neighbors.members.length - 1] = newNeighbor;
        
        Edge2[] cycleMemberEdges = new Edge2[this.neighbors.memberEdges.length];
        System.arraycopy(this.neighbors.memberEdges, 0, cycleMemberEdges, 0, this.neighbors.memberEdges.length - 1);
        this.neighbors.memberEdges = new Edge2[this.neighbors.memberEdges.length + 1];
        System.arraycopy(cycleMembers, 0, this.neighbors.memberEdges, 0, cycleMembers.length - 1);
        this.neighbors.memberEdges[this.neighbors.memberEdges.length - 1] = newNeighborEdge;
    }
    //adds a neighbor and creates an edge with a speciied weight
    public void addNeighbor(Vertex2 newNeighbor, double edgeWeight) {
        Vertex2[] cycleMembers = new Vertex2[this.neighbors.members.length];
        System.arraycopy(this.neighbors.members, 0, cycleMembers, 0, this.neighbors.members.length - 1);
        this.neighbors.members = new Vertex2[this.neighbors.members.length + 1];
        System.arraycopy(cycleMembers, 0, this.neighbors.members, 0, cycleMembers.length - 1);
        this.neighbors.members[this.neighbors.members.length - 1] = newNeighbor;
        
        Edge2[] cycleMemberEdges = new Edge2[this.neighbors.memberEdges.length];
        System.arraycopy(this.neighbors.memberEdges, 0, cycleMemberEdges, 0, this.neighbors.memberEdges.length - 1);
        this.neighbors.memberEdges = new Edge2[this.neighbors.memberEdges.length + 1];
        System.arraycopy(cycleMembers, 0, this.neighbors.memberEdges, 0, cycleMembers.length - 1);
        this.neighbors.memberEdges[this.neighbors.memberEdges.length - 1] = new Edge2(this, newNeighbor, edgeWeight);
    }
    
    public boolean equals(Vertex2 next) {
        return (this.label.equals(next.label));
    }
    
    public boolean isIn(Vertex2[] set) {
        boolean check = true;
        for (Vertex2 each : set) {
            check = check && (each.equals(this));
            if (!check) {
                break;
            }
        }
        return check;
    }
    public boolean isIn(Graph2 graph) {
        return this.isIn(graph.members);
    }
    
    Vertex2(String label) {
        this.label = label;
    }
    Vertex2(String label, Edge2... NeighborEdges) {
        this.label = label;
        this.neighbors = new Graph2(NeighborEdges);
    }
}
