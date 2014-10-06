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
public class PracticeApps {

    /**
     * @param args the command line arguments
     */

    public static void main(String... args) {
        Vertex a = new Vertex();
        Vertex b = new Vertex();
        Vertex c = new Vertex();
        Vertex d = new Vertex();
        Edge ab = new Edge(a, b, 2);
        Edge ac = new Edge(a, c, 3);
        Edge ad = new Edge(a, d, 4);
        Edge bd = new Edge(b, d, 1);
        a.addNeighbor(b, ab);
        a.addNeighbor(c, ac);
        a.addNeighbor(d,ad);
        b.addNeighbor(d, bd);
        //Graph A = new Graph(a, b, c, d);
        Graph B = new Graph();
        B.addVertex(a);
        B.addVertex(b);
        B.addVertex(c);
        B.addVertex(d);
        //for (Vertex each : A.members) {
        //    each.displayNeighbors();
        //}
        for (Vertex each : B.members) {
            each.displayNeighbors();
        }
        System.out.println(B.findDistance(a, d));
        /*Vertex2 a = new Vertex2("a");
        Vertex2 b = new Vertex2("b");
        Edge2 ab = new Edge2(a, b, 1.5);
        a = new Vertex2("a", ab);
        */
    }
}
