package Factoring.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OutputFactory {
    private List<Integer> listOfNodesNames = new ArrayList<>();
    private HashMap<Integer, Node> hashMapOfNodes = new HashMap<>();
    private int distance=0;

    public void getOutput(HashMap<Integer, Node> nodeList, HashMap<Integer, List<Integer>> connections, int from, int to) {
        hashMapOfNodes =nodeList;
        listOfNodesNames = hashMapOfNodes.keySet().stream().collect(Collectors.toList());

        //Add connections to Nodes
        for ( int i =0; i< connections.size(); i++) {
            List<Integer> currentlyList = connections.get(listOfNodesNames.get(i));
            List<Node> currentlyNodeList = new ArrayList<>();
            if (currentlyList!=null) {
                for (int o = 0; o < currentlyList.size(); o++) {
                    currentlyNodeList.add(hashMapOfNodes.get(currentlyList.get(o)));
                }
                for (int p = 0; p < currentlyNodeList.size(); p++) {
                    hashMapOfNodes.get(listOfNodesNames.get(i)).addDestination(currentlyNodeList.get(p), 1);
                }
                currentlyList.clear();
                currentlyNodeList.clear();
            }

        }

        //Create new graph and add Nodes
        Graph graph = new Graph();
        for (int i = 0; i < hashMapOfNodes.size(); i++) {
            graph.addNode(hashMapOfNodes.get(listOfNodesNames.get(i)));
        }

        //Take the shortest way
        graph = Dijkstra.calculateShortestPathFromSource(graph, hashMapOfNodes.get(from));


        //to print
        var listOfNodes = hashMapOfNodes.get(listOfNodesNames.get(listOfNodesNames.indexOf(to))).getShortestPath();
        var namelist = new ArrayList<>();
        for (int i =0; i< listOfNodes.size(); i++) {
            namelist.add(listOfNodes.get(i).getName());
        }
        namelist.add(to);
        distance = hashMapOfNodes.get(listOfNodesNames.get(listOfNodesNames.indexOf(to))).getDistance();
        if(distance==Integer.MAX_VALUE) {
            distance=-1;
        }
        System.out.println("Dystans: "+ distance);
        System.out.println(namelist);
    }

    public int getDistance() {
        return distance;
    }
}
