package edu.akdeniz.graph;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import edu.akdeniz.graph.Graph.Vertex;


public class GraphTraversal {
    static Set<String> depthFirstTraversal(Graph graph, String source, String dest) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(source);
        while (!stack.isEmpty()) {
            String vertexPop = stack.pop();
            if(vertexPop.equals(dest)){
                visited.add(vertexPop);
                break;
            }
            if (!visited.contains(vertexPop)) {
                visited.add(vertexPop);
                for (Vertex v : graph.getAdjVertices(vertexPop)) {
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
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
}