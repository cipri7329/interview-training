package training.algo.dynamic; /**
 * Created by cipri on 7/28/16.
 */

import java.util.Arrays;

/**
 *
 * https://codility.com/programmers/task/binary_gap/
Complexity:
        expected worst-case time complexity is O(log(N));
        expected worst-case space complexity is O(1).


 Of course there is a logarithmic solution if you choose your base properly. NN is an integer.
 Its binary representation is log(N)log(N) bits long. So the solution is linear in respect
 to the number of bits while still being logarithmic in respect to the integer.
 The confusion comes from not reading the problem statement closely.
 It requires that the solution be logarithmic in respect to the value of the integer, not its size in bits.
*/


public class LongestIncreasingSequence {


    /**
     * worst-case time complexity is O(log(N));
     * @param A
     * @return the begining of a maximal slice
     */
    public int solution(int[] A) {
        // write your code in Java SE 8

        if(A == null)
            return -1;
        if(A.length == 0)
            return -1;
        if(A.length == 1)
            return 0;

        int currentLength = 0;

        int startIndex = 0;

        int maxLength = 0;
        int maxStartIndex = 0;

        int lastElement = A[0];


        for(int index = 0; index < A.length; index++){

            int element = A[index];

            if(element > lastElement){
                currentLength ++;

                if(currentLength > maxLength){
                    maxLength = currentLength;
                    maxStartIndex = startIndex;
                }
            }
            else {
                currentLength = 0;
                startIndex = index;
            }

            lastElement = element;
        }

        return maxStartIndex;
    }






    public static void main (String[] args){

        LongestIncreasingSequence algo = new LongestIncreasingSequence();

        validate(algo, new int[]{2, 2, 3}, 1);
        validate(algo, new int[]{2, 2, 3, 1}, 1);

        validate(algo, new int[]{2, 2, 3, 1, 3, 4}, 3);

//        validate(algo, new int[]{2, 2, 2}, 0);

//        validate(algo, 8, 0);
//        validate(algo, 529, 4);
//        validate(algo, 20, 1);
//        validate(algo, 15, 0);
//        validate(algo, 9, 2);

    }


    private static void validate(LongestIncreasingSequence algo, int[] N, int sequenceLength){
        System.out.println("==========");
        System.out.println("input: " + Arrays.toString(N));

        int res = algo.solution(N);
        if( sequenceLength == res)
            System.out.println("PASS " + res);
        else
            System.out.println("FAIL " + res);

    }

}
