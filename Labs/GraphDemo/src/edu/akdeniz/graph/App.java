package edu.akdeniz.graph;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Graph gg = createGraph();

        GraphTraversal.floydWarshall(gg);
    }

    static Graph createGraph1(int vertex) {
        Graph graph = new Graph(vertex);
        graph.addVertex1(0);
        graph.addVertex1(1);
        graph.addVertex1(2);

        return graph;
    }
    static Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("n1");
        graph.addVertex("n2");
        graph.addVertex("n3");
        graph.addVertex("n4");
        graph.addVertex("n5");
        graph.addVertex("n6");
        graph.addEdge("n1", "n2",5);
        graph.addEdge("n2", "n3",1);
        graph.addEdge("n1", "n6",8);
        graph.addEdge("n2", "n6",2);
        graph.addEdge("n6", "n3",6);
        graph.addEdge("n1", "n5",16);
        graph.addEdge("n6", "n5",4);
        graph.addEdge("n4", "n5",4);
        graph.addEdge("n6", "n4",5);
        graph.addEdge("n3", "n4",1);
        return graph;
    }

    static Graph createMaze() {
        Graph graph = new Graph();
        for (int row=0;row<6;row++) {
            for (int column = 0; column < 7; column++) {
                String vertex = "" + row + column;
                graph.addVertex(vertex);
                if (row > 0) {
                    String s1 = "" + (row - 1);
                    s1 += column;
                    graph.addEdge(vertex, s1,3);
                }
                if (column > 0) {
                    String s2 = "" + (row);
                    s2 += (column - 1);
                    graph.addEdge(vertex, s2,2);
                }
            }
        }
        graph.removeEdge("02", "03");
        graph.removeEdge("03", "04");
        graph.removeEdge("10", "11");
        graph.removeEdge("11", "01");
        graph.removeEdge("13", "14");

        graph.removeEdge("15", "16");
        graph.removeEdge("15", "05");
        graph.removeEdge("21", "22");
        graph.removeEdge("22", "23");
        graph.removeEdge("23", "24");

        graph.removeEdge("24", "25");
        graph.removeEdge("25", "26");
        graph.removeEdge("31", "32");
        graph.removeEdge("33", "23");
        graph.removeEdge("34", "35");

        graph.removeEdge("40", "30");
        graph.removeEdge("40", "41");
        graph.removeEdge("41", "42");
        graph.removeEdge("42", "43");
        graph.removeEdge("43", "44");

        graph.removeEdge("44", "34");
        graph.removeEdge("44", "45");
        graph.removeEdge("45", "46");

        graph.removeEdge("52", "53");
        graph.removeEdge("54", "55");

        return graph;
    }

}
