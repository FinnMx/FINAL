import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class main {
    public static void main(String[] args) {
        menu(); //calls the menu procedure
    }

    public static void menu(){ //Complete method for the menu
        int option = 0;
        Scanner read = new Scanner(System.in);
        String input;
            while(option != 9) {
            System.out.println(" JAVA MINI APPS\n---------------\n1)Keep counting\n2)square root calculator\n3)check digit generator\n4)check digit checker\n9)Exit");
            System.out.println("\nenter a number to start the app.");
            try {
                option = read.nextInt();
            }
            catch(Exception e){
                input = read.nextLine();
            }
                switch (option) { // switch statement to choose which procedure to run
                    case 1:
                        app1();
                        break;
                    case 2:
                        app2();
                        break;
                    case 3:
                        app3();
                        break;
                    case 4:
                        app4();
                        break;
                    default:
                        System.out.println("please enter a valid choice");
                        break;
                    case 9:
                        return;
                }
            }

        }


    public static void app1(){ //keep counting app
        Random random = new Random();
        Scanner read = new Scanner(System.in);

        int firstDone = 0;
        int userAnswer;

        int firstInt = random.nextInt(10 - 1) + 1; //declare all initial variables
        int secondInt = random.nextInt(10 - 1) + 1;
        int decider = random.nextInt(2);
        int correctAnswer = 0;

        long nanoStartTime = System.nanoTime();

        //all variables predefined
        System.out.println("KEEP COUNTING:\n");

        for(int i =1; i<=10; i++) {//start the questions

            if(decider == 1) {

                if (firstDone == 1) { //checks to see if the first iteration i.E first question has been completed, if so reuse the answer for the question.
                    firstInt = correctAnswer;
                } else {
                    firstInt = firstInt;
                }

                System.out.println("what is " + firstInt + " + " + secondInt + " =");
                try {
                    userAnswer = read.nextInt();
                }
                catch (Exception e){
                    System.out.println("Incorrect, thats not a number! the correct answer is " + correctAnswer);
                    break;
                }
                correctAnswer = firstInt + secondInt;

                if (userAnswer == correctAnswer) {
                    System.out.println("\nCorrect! next question.");
                    firstDone = 1;
                    secondInt = random.nextInt(10 - 1) + 1;
                    decider = random.nextInt(2);
                } else {
                    System.out.println("Incorrect! the correct answer is " + correctAnswer);
                    break;
                }
            }
            //same routine but for a subtraction / quite annoying but i couldnt get it to work in one routine with a + or a - using a bool rand
            else if(decider == 0){
                if (firstDone == 1) { //checks to see if the first iteration i.E first question has been completed, if so reuse the answer for the question.
                    firstInt = correctAnswer;
                } else {
                    firstInt = firstInt;
                }

                System.out.println("what is " + firstInt + " - " + secondInt + " =");
                try {
                    userAnswer = read.nextInt();
                }
                catch (Exception e){
                    System.out.println("Incorrect, thats not a number! the correct answer is " + correctAnswer);
                    break;
                }
                correctAnswer = firstInt - secondInt;

                if (userAnswer == correctAnswer) {
                    System.out.println("\nCorrect! next question.");
                    firstDone = 1;
                    secondInt = random.nextInt(10 - 1) + 1;
                    decider = random.nextInt(2);
                } else {
                    System.out.println("Incorrect! the correct answer is " + correctAnswer);
                    break;
                }
            }

        }
        long nanoEndTime = System.nanoTime();
        System.out.println("\nthat took "+ (nanoEndTime - nanoStartTime) / 1000000000 +" seconds\n"); //nanotime is a java import that calculates the nanoseconds of the apps runtime
    }

    public static void app2() {
        double uB, lB, avg, avgComp;
        int num = 0;
        Scanner read = new Scanner(System.in);
        String input;
        int dp = 0;
        String dpPattern = "#."; //used for the formatter
        while (num <= 0) {
            System.out.println("SQUARE ROOT CALCULATOR:\nPlease enter a number: ");
            try {
                num = read.nextInt();
            } catch (Exception e) {
                System.out.println("\nPLEASE ENTER A VALID INPUT\n");
                input = read.nextLine();
            }
        }
        do {
            System.out.println("please enter a decimal place up to 7");
            try {
                dp = read.nextInt();
            }
            catch(Exception e){
                System.out.println("\nPLEASE ENTER A VALID INPUT");
                input = read.nextLine();
            }
        }while(dp >7 || dp<=0);

        for(int x=1; x<=dp;x++){ //sets the formatter to the correct decimal places by concatinating a #
            dpPattern += '#';
        }

        java.text.DecimalFormat formatter = new java.text.DecimalFormat(dpPattern);

        uB = Math.pow(num, 0.5) + ((Math.pow(num, 0.5)) % 1) / 10000;  // gets the upper bound close to the actual square
        lB = Math.pow(num, 0.5) - ((Math.pow(num, 0.5)) % 1) / 10000; //gets the lower bound close to the actual square
        for (int i = 1; i <= dp; i++) { //iterates dp number of times to produce the result
            avg = (uB + lB) / 2;
            avgComp = Math.pow(avg, 2);
            System.out.print("\nPASS " + i + ": THIS IS ESTIMATED RESULT " + formatter.format(avg) +"\n");
            System.out.println("UB: "+formatter.format(lB) + "\nLB: " + formatter.format(uB)+"\n");
            if (avgComp > num) { //inserts the avg into either the ub or lb to get a more accurate result
                uB = avg;
            } else if (avgComp < num) {
                lB = avg;
            }
        }
    }

    /*
     TEST INPUTS           EXPECTED OUTPUT           ACTUAL OUTPUT
e.g1)     a                error message            error message prompts user to enter int
                           return to menu.          and user returns to menu.

e.g2)     2                user is asked to         the user is asked to enter 5 digit int and
                           enter 5 digits           program loops until they do so

e.g3)   22222              222226                   222226

e.g4)    " "               error message            error message prompts user to enter int
                           return to menu.          and user returns to menu.

e.g5)  -22222              user is asked to         the user is asked to enter 5 digit int and
                           enter 5 positive         program loops until they do so
                           digits
     */

    public static void app3(){
        int userNum = 111111; //define the variables to determine the length and number
        Scanner read = new Scanner(System.in);
        String input;
        int usernumLength = (int)(Math.log10(userNum)+1); //mathmatical way to get the length of any number
        int[] digits = new int[6];
        while (usernumLength != 5) {
            System.out.println("CHECK-DIGIT GENERATOR:\nplease enter a 5 digit positive number");
            try { //catches false inputs
                userNum = read.nextInt();
            }
            catch (Exception a){
                System.out.println("entry must be a integer\n");
                input = read.nextLine();
            }
            usernumLength = (int)(Math.log10(userNum)+1); // calculates the length of the input with logarithm.
        }
        for(int i =4; i>=0; i--){ //for loop that reverses the division into an array
            digits[i] = userNum % 10;
            userNum = userNum/10;
        }
        int odds = (digits[0] + digits[2] + digits[4]) * 7; // adds 1st 3rd and 5th digits then * 7
        int evens = (digits[1] + digits[3]) *3; // adds 2nd and forth digits then * 3
        if((odds+evens) % 10 == 0){ //determine the check digit
            digits[5] = 0;
        }
        else{
            digits[5] = 10 - ((odds+evens) % 10);
        }
        System.out.println("This is the conversion: "+digits[0]+""+digits[1]+""+digits[2]+""+digits[3]+""+digits[4]+""+digits[5]);
    }

    public static void app4(){
        int userNum = 1111111;
        int usernumLength = (int)(Math.log10(userNum)+1); // same predefined variables as app3
        Scanner read = new Scanner(System.in);
        String input;
        int[] digits = new int[6];
        while (usernumLength != 6) {
            System.out.println("CHECK-DIGIT CHECKER:\nplease enter a 6 digit number");
            try { //catch invalid inputs
                userNum = read.nextInt();
            }
            catch (Exception a){
                System.out.println("entry must be a integer\n");
                input = read.nextLine();
            }
            usernumLength = (int)(Math.log10(userNum)+1); //mathmatical way to get the length of any number
        }
        for(int i =5; i>=0; i--){ //same reversal as app3 however the checkdigit is included this time
            digits[i] = userNum % 10;
            userNum = userNum/10;
        }
        int odds = (digits[0] + digits[2] + digits[4]) * 7; // adds 1st 3rd and 5th digits then * 7
        int evens = (digits[1] + digits[3]) *3; // adds 2nd and forth digits then * 3
        int addition = odds+evens;
        if(digits[5] == 0){ //check to see if the checkdigit is correct
            if(addition % 10 == 0){ //equation for if the last digit is 0
                System.out.println("CORRECT!");
            }
            else{
                System.out.println("INCORRECT!");
            }
        }
        else{
            if (10 - (addition % 10) == digits[5]){ //equation for if the last digit is not 0
                System.out.println("CORRECT!");
            }
            else{
                System.out.println("INCORRECT!");
            }
        }
    }
}
