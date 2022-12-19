package edu.akdeniz.graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;
    private int[][] arrGraph;
    private  List<Integer> vertices;
    private  List<Integer> removedVertices;
    Graph() {
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }
    Graph(int vertexNumber) {
        arrGraph = new int[vertexNumber][vertexNumber];
        for(int[] arr : arrGraph) {
            for (int a : arr) {
                a=0;
            }
        }
        printGraph1();
        vertices = new ArrayList<>();
        removedVertices = new ArrayList<>();
    }
    void printGraph1() {
        for(int[] arr : arrGraph) {
            for (int a : arr) {
                System.out.print(a+ " ");
            }
            System.out.println(" ");
        }
    }
    void addEdge1(int index1, int index2) {
        if (removedVertices.contains(index1) || removedVertices.contains(index2)){
            throw new RuntimeException();
        }
        if (!vertices.contains(index1)){
            addVertex1(index1);
        }
        if (!vertices.contains(index2)){
            addVertex1(index2);
        }
        arrGraph[index1][index2] = 1;
        //arrGraph[index2][index1] = 1;
    }
    void addVertex1(int index) {
        vertices.add(index);
    }
    void removeEdge1(int index1, int index2) {
        arrGraph[index1][index2] = 0;
       // arrGraph[index2][index1] = 0;
    }

    String getAdjVertices1(int vertex) {
        List<Integer> adjacents = new ArrayList<>();
        if(vertices.contains(vertex)){
            for (int i=0; i<arrGraph[vertex].length; i++){
                adjacents.add(arrGraph[vertex][i]);
            }
        }
        return vertex + ": " + adjacents.toString();
    }
    void removeVertex1(int v) {
        vertices.remove(v);
        removedVertices.add(v);
    }
    void addVertex(String label) {

        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertex> getAdjVertices(String label) {

        return adjVertices.get(new Vertex(label));
    }
    
    String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Vertex v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
        }
        return sb.toString();
    }

    class Vertex {
        public String label;
        Vertex(String label) {
            this.label = label;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }
}