package solution;

import java.util.Scanner;
import java.util.TreeSet;

public class SetCalculator {

    TreeSet<Integer> set1 = new TreeSet<>();
    TreeSet<Integer> set2 = new TreeSet<>();
    char operator;



    public void makeSetsFromUserInput (){
        System.out.println("Please type the set calculation you would like to compute.");
        System.out.println("The expression should take the form of two sets, each surrounded by square braces, ");
        System.out.println("with the elements separated by commas, and an operator between sets.");
        System.out.println("Use \"+\" to find the union, \"*\" to find the intersection, and \"-\" to find the difference.");
        System.out.println("Example: [0, 1, 2, 3,] + [4, 5]");

        boolean setStarted = false;
        boolean isSet1 = true;
        Scanner userInputScanner = new Scanner(System.in);
        String userInputString = userInputScanner.nextLine();
        StringBuilder nextIntString = new StringBuilder();
        int nextInt;

        for(int i = 0; i<userInputString.length(); i++){
            char nextChar = userInputString.charAt(i);

            if(!setStarted){
                switch (nextChar){
                    case ' ':
                        break;
                    case '[':
                        setStarted = true;
                        break;
                    case '*':
                        if(!isSet1){
                            operator = '*';
                            break;
                        }
                    case '-':
                        if(!isSet1){
                            operator = '-';
                            break;
                        }
                    case '+':
                        if(!isSet1){
                            operator = '+';
                            break;
                        }
                    default:
                        System.out.println(userInputString + " was not a valid input!");
                        return;
                }
            }
            else if(Character.isDigit(nextChar)){
                nextIntString.append(nextChar);
                if(!Character.isDigit(userInputString.charAt(i+1))){
                    nextInt = Integer.parseInt(nextIntString.toString());
                    nextIntString = new StringBuilder();
                    if(isSet1){
                        set1.add(nextInt);
                    }else{
                        set2.add(nextInt);
                    }
                }
            }
            else if(nextChar == ']'){
                if(isSet1){
                    isSet1 = false;
                    setStarted = false;
                }else{
                    break;
                }
            }else if(nextChar !=','&& nextChar != ' '){
                System.out.println(userInputString + " was not a valid input!");
                return;
            }
        }
    }


    public void calculateSet (char operator,TreeSet<Integer> set1, TreeSet<Integer> set2){
        switch(operator){
            case '*':
                set1.retainAll(set2);
                break;
            case '+':
                set1.addAll(set2);
                break;
            case '-':
                set1.removeAll(set2);
                break;
            default:
                System.out.println("Invalid operator entered!");
                break;
        }

    }

    public void printSet(){
        System.out.println(set1);
    }






}
