package training.arrays;

import java.util.Arrays;

/**
 * Created by cipri on 7/29/16.
 *
 * The equilibrium index of a sequence is an index such that
 * the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 *
 */
public class EquilibriumIndex {

    public int solution(int[] A) {
        // write your code in Java SE 8

        long headSum = 0;
        long tailSum = 0;

        long sum = 0;

        // O(n)
        for(int index=0; index<A.length; index++){
            sum += A[index];
        }

        // O(n)
        for(int index=0; index<A.length; index++){

            tailSum = sum - headSum - A[index];

            if(headSum == tailSum)
                return index;

            headSum += A[index];

        }

        return -1;
    }



    public static void main(String[] args){

        EquilibriumIndex algo = new EquilibriumIndex();


        validate(algo, new int[]{-1, 3, -4, 5, 1, -6, 2, 1}, 1);

    }


    private static void validate(EquilibriumIndex algo, int[] A, int result){
        System.out.println("==========");

        if( result == algo.solution(A))
            System.out.println(String.format("PASS %s %d",  Arrays.toString(A), result));
        else
            System.out.println(String.format("FAIL %s %d", Arrays.toString(A), result));

    }

}
