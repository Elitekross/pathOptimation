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
public class Graph2 {
    Vertex2[] members;
    Edge2[] memberEdges;
    
    public void addMember(Vertex2 newVertex) {
        for (Edge2 eachEdge : newVertex.neighbors.memberEdges) {
            for (Vertex2 eachVertex : this.members) {
                if (eachEdge.edgeOf(eachVertex, newVertex)) {
                    Edge2[] cycle = new Edge2[this.memberEdges.length];
                    System.arraycopy(this.memberEdges, 0, cycle, 0, cycle.length);
                    this.memberEdges = new Edge2[this.memberEdges.length + 1];
                    System.arraycopy(cycle, 0, this.members, 0, cycle.length - 1);
                    this.memberEdges[this.memberEdges.length - 1] = eachEdge;
                }
            }
        }
        Vertex2[] cycle = new Vertex2[this.members.length];
        System.arraycopy(this.members, 0, cycle, 0, cycle.length);
        this.members = new Vertex2[this.members.length + 1];
        System.arraycopy(cycle, 0, this.members, 0, cycle.length - 1);
        this.members[this.members.length - 1] = newVertex;
    }
    public void removeMember(Vertex2 oldVertex) {
        Vertex2[] cycleVertex = new Vertex2[this.members.length - 1];
        int count = 0;
        for (Vertex2 each : this.members) {
            if (oldVertex.equals(each)) {
                cycleVertex[count] = each;
                count++;
            }
        }
        this.members = cycleVertex;
        Edge2[] cycleEdge = new Edge2[this.memberEdges.length - 1];
        count = 0;
        for (Edge2 each : this.memberEdges) {
            if (each.edgeOf(oldVertex)) {
                cycleEdge[count] = each;
                count++;
            }
        }
        this.memberEdges = cycleEdge;
        count = 0;
    }
    /*public void displayGraph() {
        
    }*/
    Graph2 () {
        this.members = new Vertex2[0];
        this.memberEdges = new Edge2[0];
    }
    Graph2 (Edge2[] memberEdges) {
        this.memberEdges = memberEdges;
        this.members = new Vertex2[0];
        for (Edge2 each : this.memberEdges) {
            //if neither endpoint has been added to members
            if (!(each.endpoint1.isIn(this.members) && each.endpoint2.isIn(this.members))) {
                Vertex2[] cycleMembers = new Vertex2[this.members.length];
                System.arraycopy(this.members, 0, cycleMembers, 0, cycleMembers.length - 1);
                this.members = new Vertex2[this.members.length + 2];
                System.arraycopy(cycleMembers, 0, this.members, 0, cycleMembers.length - 1);
                this.members[this.members.length - 2] = each.endpoint1;
                this.members[this.members.length - 1] = each.endpoint2;
            }
            //if endpoint1 has not been added to members
            if (!(each.endpoint1.isIn(this.members)) && each.endpoint2.isIn(this.members)) {
                Vertex2[] cycleMembers = new Vertex2[this.members.length];
                System.arraycopy(this.members, 0, cycleMembers, 0, cycleMembers.length - 1);
                this.members = new Vertex2[this.members.length + 1];
                System.arraycopy(cycleMembers, 0, this.members, 0, cycleMembers.length - 1);
                this.members[this.members.length - 1] = each.endpoint1;
            }
            //if endpoint2 has not been added to members
            if (each.endpoint1.isIn(this.members) && !(each.endpoint2.isIn(this.members))) {
                Vertex2[] cycleMembers = new Vertex2[this.members.length];
                System.arraycopy(this.members, 0, cycleMembers, 0, cycleMembers.length - 1);
                this.members = new Vertex2[this.members.length + 1];
                System.arraycopy(cycleMembers, 0, this.members, 0, cycleMembers.length - 1);
                this.members[this.members.length - 1] = each.endpoint2;
            }
        }
    }
}
