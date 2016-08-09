package training.algo.iterations;

/**
 * Created by cipri on 7/30/16.
 *
 * Give two integers A and B,
 * write a function that returns the number of whole squares within
 * the interval [A..B] (both ends included).
 *
 * assume A<=B
 * assume A and B within the range of [-10,000 .. 10,000]
 */
public class SquareRootWithinInterval {

    public int solution(int A, int B) {
        // write your code in Java SE 8

        if(A > B)
            return -1;

        if(A <= 0 && B <= 0){
            return 0;
        }
        else if(A <= 0 && B >= 0){
            A = 0;
        }

        int left = (int) (Math.sqrt(A));
        int right = (int) Math.sqrt(B);

        int numOfSqrt = (int) (Math.floor(Math.sqrt(B)) - Math.ceil(Math.sqrt(A)) + 1);
//        System.out.println("left " + left + " right " + right);
        int number = right - left + 1;

        if(numOfSqrt != number){
            throw new NumberFormatException(String.format("low: %d high %d stackOverflow: %d proposed: %d", A, B, numOfSqrt, number));
        }

        return number;
    }


    public static void main (String[] args){

        SquareRootWithinInterval algo = new SquareRootWithinInterval();

        validate(algo, 17, 4, -1);

        validate(algo, 4, 17, 3);

        validate(algo, 0, 4, 3);
        validate(algo, 1, 10, 3);

        validate(algo, 0, 9, 4);
        validate(algo, 1, 9, 3);
        validate(algo, 1, 8, 2);

        validate(algo, -1, 4, 3);
        validate(algo, -5, -4, 0);
        validate(algo, -5, 17, 5);
        validate(algo, -5, 16, 5);

    }


    private static void validate(SquareRootWithinInterval algo, int A, int B, int result){
        System.out.println("==========");

        int res = algo.solution(A, B);
        if( result == res)
            System.out.println("PASS " + A + " "+ B + " res=" + res);
        else
            System.out.println("FAIL " + A + " "+ B+ " res=" + res);

    }

}
