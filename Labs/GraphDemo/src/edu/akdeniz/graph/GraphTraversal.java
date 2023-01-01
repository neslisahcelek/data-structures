package edu.akdeniz.graph;
import java.util.*;

import edu.akdeniz.graph.Graph.Vertex;


public class GraphTraversal {
    static void floydWarshall(Graph graph){
        ArrayList<Vertex> cities = graph.getKeySet();
        double[][] adjacentMatrix = new double[cities.size()][cities.size()];
        for (int i=0; i<adjacentMatrix.length; i++){
            for (int j=0; j<adjacentMatrix.length; j++){ //if ji + ik < jk then jk=ji+ik
                for (int k =0; k<adjacentMatrix.length; k++){
                    LinkedHashMap<Vertex,Integer> adjacents = graph.getAdjVertices(cities.get(i));
                    Integer distance = adjacents.get(cities.get(j));
                    if(i==j){
                        adjacentMatrix[i][j] = 0;
                    }
                    else if (distance!= null)
                        adjacentMatrix[i][j] = distance;
                    else
                        adjacentMatrix[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        printMatrix(adjacentMatrix);
    }
    static void printMatrix(double[][] matrix){
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix.length; j++){
                if (matrix[i][j] == Double.POSITIVE_INFINITY){
                    System.out.print("  -   ");
                }
                else
                    System.out.print(matrix[i][j] + "   ");
            }
            System.out.println(" ");
        }
    }
    static Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex).keySet()) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }
    static Set<String> depthFirstTraversal(Graph graph,String start,String end){
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(start);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (vertex.equals(end)) {
                visited.add(vertex);
                break;
            }
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex).keySet()) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }
    static Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex).keySet()) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
}
