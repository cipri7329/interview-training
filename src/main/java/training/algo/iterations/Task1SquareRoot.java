package training.algo.iterations;

/**
 * Created by cipri on 7/30/16.
 *
 *
 *
 */
public class Task1SquareRoot {

    public int solution(int A, int B) {
        // write your code in Java SE 8

        if(A <= 0 && B <= 0){
            return 0;
        }
        else if(A <= 0 && B >= 0){
            A = 0;
        }

        int left = (int) (Math.sqrt(A));
        int right = (int) Math.sqrt(B);
//        System.out.println("left " + left + " right " + right);

        return right - left + 1;
    }


    public static void main (String[] args){

        Task1SquareRoot algo = new Task1SquareRoot();

        validate(algo, 4, 17, 3);

        validate(algo, 0, 4, 3);
        validate(algo, -1, 4, 3);
        validate(algo, -5, -4, 0);
        validate(algo, -5, 17, 5);

//        validate(algo, 529, 4);
//        validate(algo, 20, 1);
//        validate(algo, 15, 0);
//        validate(algo, 9, 2);

    }


    private static void validate(Task1SquareRoot algo, int A, int B, int result){
        System.out.println("==========");

        int res = algo.solution(A, B);
        if( result == res)
            System.out.println("PASS " + A + " "+ B + " res=" + res);
        else
            System.out.println("FAIL " + A + " "+ B+ " res=" + res);

    }

}
