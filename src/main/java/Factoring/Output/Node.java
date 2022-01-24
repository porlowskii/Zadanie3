package Factoring.Output;

import java.util.*;

public class Node {
    private String name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(final List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    Integer getDistance() {
        return distance;
    }

    void setDistance(final Integer distance) {
        this.distance = distance;
    }

    Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    void setAdjacentNodes(final Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}