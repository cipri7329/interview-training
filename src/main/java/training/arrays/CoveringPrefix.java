package training.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by cipri on 7/29/16.
 *
 * A non-empty zero-indexed array A consisting of N integers is given.
 * The first covering prefix of array A is the smallest integer P such that 0≤P<N and
 * such that every value that occurs in array A also occurs in sequence A[0], A[1], ..., A[P].
 *
 *
 *  For example, the first covering prefix of the following 5−element array A:
 *  A[0] = 2
 *  A[1] = 2
 *  A[2] = 1
 *  A[3] = 0
 *  A[4] = 1
 *  is 3, because sequence [ A[0], A[1], A[2], A[3] ] equal to [2, 2, 1, 0], contains all values that occur in array A.
 *
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
public class CoveringPrefix {


    public int solution(int[] A) {
        // write your code in Java SE 8

        if(A==null)
            return -1;
        if(A.length == 0)
            return -1;
        if(A.length == 1)
            return 0;

        // O(1) lookup
        // O(n) space
        HashSet<Integer> unique = new HashSet<>();

        int lastIndex = 0;
        //O(n)
        for(int index = 0; index<A.length; index++){

            if(unique.add(A[index])){
                lastIndex = index;
            }

        }

        return lastIndex;
    }


    public static void main(String[] args){

        CoveringPrefix algo = new CoveringPrefix();


        validate(algo, new int[]{2, 2, 1, 0, 1}, 3);
        validate(algo, new int[]{-1, 3, -4, 5, 1, -6, 2, 1}, 6);

    }


    private static void validate(CoveringPrefix algo, int[] A, int result){
        System.out.println("==========");

        if( result == algo.solution(A))
            System.out.println(String.format("PASS %s %d",  Arrays.toString(A), result));
        else
            System.out.println(String.format("FAIL %s %d", Arrays.toString(A), result));

    }



}
