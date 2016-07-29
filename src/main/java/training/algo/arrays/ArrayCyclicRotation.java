package training.algo.arrays;

import java.util.Arrays;

/**
 * Created by cipri on 7/28/16.
 *
 * A zero-indexed array A consisting of N integers is given.
 * Rotation of the array means that each element is shifted right by one index,
 * and the last element of the array is also moved to the first place.

 For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7].
 The goal is to rotate array A K times;
 that is, each element of A will be shifted to the right by K indexes.
 *
 */
public class ArrayCyclicRotation {


    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        int arrayLength = A.length;
        if(arrayLength < 2)
            return A;

        if(K < 1)
            return A;

        int[] newArray = new int[arrayLength];

        for(int pos=0; pos<arrayLength; pos++){

            int first = A[pos];

            int newPos = (pos + K) % arrayLength;

            newArray[newPos] = first;
        }


        return newArray;
    }

    public static void main(String[] args){


        ArrayCyclicRotation algo = new ArrayCyclicRotation();

        validateSolution(algo, new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8});

        validateSolution(algo, new int[]{3, 4, 3}, 3, new int[]{9, 7, 6, 3, 8});

    }


    private static void validateSolution(ArrayCyclicRotation algo, int[] input, int position, int[] output){

        int[] modified = algo.solution(input, position);
        for(int i = 0; i< modified.length; i++){
            if(output[i] != modified[i] ){
                System.out.println(String.format("FAIL mod= %s pos= %d  expected= %s",
                        Arrays.toString(modified),
                        position,
                        Arrays.toString(output)
                ));
                return;
            }
        }

        System.out.println(String.format("PASS mod= %s pos= %d  expected= %s",
                Arrays.toString(modified),
                position,
                Arrays.toString(output)
        ));
    }
}
