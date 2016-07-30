package training.algo.stack;

/**
 * Created by cipri on 7/30/16.
 */
import java.util.*;

public class Task4StackMachine {

    public int solution(String S) {
        // write your code in Java SE 8

        //assume valid input with [0..9]chars and + *
        //do not check for strange characters
        if(S == null)
            return -1;
        if(S.isEmpty())
            return -1;

        Stack<Long> stack = new Stack<>();
        char[] input = S.toCharArray();

        for(char c : input){

            if(c == '+'){
                if (stack.size() >= 2) {
                    long a = stack.pop();
                    long b = stack.pop();
                    stack.push(a + b);
                }
                else {
                    //invalid input string
                    return -1;
                }

            }
            else if (c == '*'){
                if (stack.size() >= 2) {
                    long a = stack.pop();
                    long b = stack.pop();
                    stack.push(a * b);
                }
                else {
                    //invalid input string
                    return -1;
                }
            }
            else {
                //is number
                try {
                    int number = Integer.parseInt("" + c);
                    stack.push((long)number);
                }
                catch (NumberFormatException e){
                    //invalid input
                    return -1;
                }
            }

        }

        if(stack.size() == 1)
            return stack.pop().intValue();
        else
            return -1;
    }



    public static void main (String[] args){

        Task4StackMachine algo = new Task4StackMachine();

        validate(algo, "13+62*7+*", 76);
//        validate(algo, "13+62*7*", -1);


//        validate(algo, 0, 4, 3);
//        validate(algo, -1, 4, 3);
//        validate(algo, -5, -4, 0);
//        validate(algo, -5, 17, 5);

//        validate(algo, 529, 4);
//        validate(algo, 20, 1);
//        validate(algo, 15, 0);
//        validate(algo, 9, 2);

    }


    private static void validate(Task4StackMachine algo, String input, int result){
        System.out.println("==========");

        int res = algo.solution(input);
        if( result == res)
            System.out.println("PASS " + input + " res=" + res);
        else
            System.out.println("FAIL " + input + " res=" + res);

    }

}
