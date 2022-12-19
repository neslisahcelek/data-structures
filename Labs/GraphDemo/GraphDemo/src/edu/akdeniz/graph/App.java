package edu.akdeniz.graph;
public class App {
    public static void main(String[] args) throws Exception {

        Graph gg = createGraph1(3);
        gg.addEdge1(0,1);
        System.out.println("");
        gg.addEdge1(2,2);
        gg.addEdge1(2,1);
        gg.removeEdge1(2,2);
        gg.printGraph1();


        //System.out.println(GraphTraversal.breadthFirstTraversal(gg, "Bob"));
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
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
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
                    graph.addEdge(vertex, s1);
                }
                if (column > 0) {
                    String s2 = "" + (row);
                    s2 += (column - 1);
                    graph.addEdge(vertex, s2);
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
