package Factoring;

import Factoring.Output.OutputFactory;
import Factoring.Output.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputFactoring {
    private Integer numberOfVertex;
    private Integer numberOfConnections;
    private Integer numberOfStart;
    private Integer numberOfStop;
    HashMap<Integer, Node> nodeHashMap = new HashMap<>();
    HashMap<Integer, List<Integer>> connections = new HashMap<>();
    private int distance = 0;

public InputFactoring() {

    }

    public String firstLine(String input) {
        String[] split = input.split(" ");
        numberOfVertex = null;
        numberOfConnections = null;
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("[0-9]*") && split.length == 2 && Integer.valueOf(split[i]) > 0) {
                if (i == 0) {
                    numberOfVertex = Integer.valueOf(split[0]);
                }
                if (i == 1 && numberOfVertex !=null) {
                    numberOfConnections = Integer.valueOf(split[1]);
                }
            }
        }
        if (numberOfVertex == null || numberOfConnections == null) {
            return "Wrong format! Write only two(2) numbers!"+"\n"+ "Format: number(space)number"+"\n"+"Example:X X";
        }
        return "Correct";
    }

    public String secondLine(List <String> list) {
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(" ");
                if (split[0].matches("[0-9]*") && split.length ==2 && list.size() == numberOfConnections && Integer.valueOf(split[0])>0) {
                    if (split[1].matches("[0-9]*") && split.length ==2 && list.size() == numberOfConnections && Integer.valueOf(split[0])>0) {
                        nodeHashMap.put(Integer.valueOf(split[0]), new Node(split[0]));
                        if (!connections.containsKey(Integer.valueOf(split[0]))) {
                            connections.put(Integer.valueOf(split[0]), new ArrayList<>());
                        }
                        nodeHashMap.put(Integer.valueOf(split[1]), new Node(split[1]));
                        connections.get(Integer.valueOf(split[0])).add(Integer.valueOf(split[1]));
                    }
            }
        }
        if(list.size()!= numberOfConnections) {
            return "Incorrect number of numbers! You set numbers of vertex as "+ numberOfConnections +" but you give "+list.size();
        }

        if (nodeHashMap.isEmpty()) {
            return "Incorrect format, write only numbers!";
        }
        if (nodeHashMap.size()!= numberOfVertex) {
            return "Incorrect format, write only numbers and be sure, that you write this same number of Vertex as on start!";
        }


        return "Correct";
    }

    public String thirdLine(String input) {
        String[] split = input.split(" ");
        numberOfStart = null;
        numberOfStop = null;
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("[0-9]*") && split.length == 2 && Integer.valueOf(split[i]) > 0) {
                if (i == 0) {
                    numberOfStart = Integer.valueOf(split[0]);
                }
                if (i == 1 && numberOfStart !=null) {
                    numberOfStop = Integer.valueOf(split[1]);
                }
            }
        }
        if (numberOfStart == null || numberOfStop == null) {
            return "Wrong format! Write only two(2) numbers!"+"\n"+ "Format: number(space)number"+"\n"+"Example:X X";
        }
        if (!(nodeHashMap.containsKey(numberOfStart) && nodeHashMap.containsKey(numberOfStop))) {
            return "Start value or stop value is out of range";
        }
        return "Correct";
    }

    public Integer getNumberOfVertex() {
        return numberOfVertex;
    }

    public void getLookingForNumber() {
        OutputFactory factory = new OutputFactory();
        factory.getOutput(nodeHashMap, connections, numberOfStart, numberOfStop);
        distance = factory.getDistance();
    }

    public Integer getNumberOfConnections() {
        return numberOfConnections;
    }

    int getDistance() {
        return distance;
    }
}
