package solution;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        SetCalculator runSetCalculator = new SetCalculator();
        System.out.println("This is a little program to determine intersection, union, or difference of two sets.");
        Scanner inputScanner = new Scanner(System.in);
        while(true){
            System.out.println("Would you like to put in a problem?(Type yes/no)");
            String input = inputScanner.nextLine();
            if(input.equals("no")){
                System.out.println("Alright. Goodbye!");
                break;
            }else if (input.equals("yes")){
                runSetCalculator.makeSetsFromUserInput();
                runSetCalculator.calculateSet(runSetCalculator.operator, runSetCalculator.set1, runSetCalculator.set2);
                runSetCalculator.printSet();
            }else{
                System.out.println("Sorry, that was not a valid input.");
            }
        }
    }
}
