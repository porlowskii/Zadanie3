package UserInterface;

import Factoring.InputFactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    private InputFactoring factoring = new InputFactoring();

    public UserInterface() {
        this.scan=new Scanner(System.in);
    }
    public void start() {
        System.out.println("Write number of vertex and number of connections");
        System.out.println("Format: number(space)number");
        System.out.println("Example:X X");
        //first part of input
        while (true) {
            String input;
            input = String.valueOf(scan.nextLine());
            if (!factoring.firstLine(input).equals("Correct")) {
                System.out.println(factoring.firstLine(input));
                continue;
            }
            break;
        }

        //second part of input
        System.out.println("Write "+factoring.getNumberOfConnections()+" connections for add to table");
        List <String> list = new ArrayList<>();
        while (true) {
            list.clear();
            while (!(list.size()==factoring.getNumberOfConnections())) {
                list.add(String.valueOf(scan.nextLine()));
            }
            if (!factoring.secondLine(list).equals("Correct")) {
                System.out.println(factoring.secondLine(list));
                continue;
            }
            break;
        }

        //third part of input
        while (true) {
            System.out.println("Write number of vertex between you looking for the way");
            String input;
            input = String.valueOf(scan.nextLine());
            if (!factoring.thirdLine(input).equals("Correct")) {
                System.out.println(factoring.thirdLine(input));
                continue;
            }
            break;
        }

        factoring.getLookingForNumber();
    }
}