package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner=new Scanner(System.in);

    }
    public String getString(){
        return scanner.nextLine();
    }

    // Will prompt the user's input for whether or not they would like to continue using the program.
    public boolean yesNo(){
        String userInput = this.scanner.nextLine();
        return userInput.equalsIgnoreCase("y")|| userInput.equalsIgnoreCase("yes");
    }

    public int getInt(int min, int max){
        Integer number=getInt();
        if(number>=min && number<=max){
            return number;
        }
    else{
           return getInt(min, max);
        }
    }
    public int getInt() {
        System.out.println("Please enter an integer.");
        try{
            return Integer.valueOf(getString());
        }
        catch (NumberFormatException e){
            System.out.println("whoops that is not an integer");
            return  getInt();
        }
//        if (this.scanner.hasNextInt()) {
//            return this.scanner.nextInt();
//    }
//    else {
//            System.out.println("Invalid Input");
//            scanner.nextLine();
//            return getInt();
//        }
    }

    public double getDouble(double min, double max){
        System.out.println("");
        System.out.println("Please enter a number within the given bounds.");
        Double number=this.scanner.nextDouble();
        if(number>=min && number<=max){
            System.out.println("Thank you");
            return number;

        }
        else{
            return getDouble(min, max);
        }
    }
    public double getDouble(){
        System.out.println("Please enter a number.");
        try{
            return Double.valueOf(getString());
        }
        catch (NumberFormatException e){
            System.out.println("Sorry that is not a number.");
            return getDouble();
        }
    }
    public int getBinary(){
        //At this point getBinary only works for integers
        System.out.println("Please enter a binary number");
        try {
            return Integer.valueOf(String.valueOf(getString()), 2);
        }
        catch (NumberFormatException e){
            System.out.println("Sorry that is not binary number");
            return getBinary();
        }
    }
    public int getHex(){
        //At this point getHex only works for integers
        System.out.println("Please enter a hexidecimal number");
        try {
            return Integer.valueOf(String.valueOf(getString()), 16);
        }
        catch (NumberFormatException e){
            System.out.println("Sorry that is not a hexacimal number");
            return getHex();
        }
    }

    public static void main(String[] args) {
//        Input input=new Input();
////        System.out.println(input.getDouble());
//        System.out.println(input.getBinary());

    }

}
