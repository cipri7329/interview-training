package training.algo.arrays;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Created by cipri on 7/29/16.
 *
 * We draw N discs on a plane.
 * The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers,
 * specifying the radiuses of the discs, is given.
 * The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th
 * and K-th discs have at least one common point (assuming that the discs contain their borders).
 *
 *
 */
public class DiscsIntersecion {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A == null)
            return -1;
        if(A.length < 2)
            return 0;

        int l = A.length;

        long[] A1 = new long[l];
        long[] A2 = new long[l];

        for(int i = 0; i < l; i++){
            A1[i] = (long)A[i] + i;
            A2[i] = -((long)A[i]-i);
        }

        PriorityQueue<Integer> leftEdges = new PriorityQueue<Integer>();

        Arrays.sort(A1);
        Arrays.sort(A2);

        long cnt = 0;

        for(int i = A.length - 1; i >= 0; i--){
            int pos = Arrays.binarySearch(A2, A1[i]);
            if(pos >= 0){
                while(pos < A.length && A2[pos] == A1[i]){
                    pos++;
                }
                cnt += pos;
            } else{ // element not there
                int insertionPoint = -(pos+1);
                cnt += insertionPoint;
            }

        }

        long sub = (long)l*((long)l+1)/2;
        cnt = cnt - sub;

        if(cnt > 1e7) return -1;

        return (int)cnt;
    }


    public int number_of_disc_intersections ( int[] A ) {
        int overlaps = 0;
        if (A.length<2) return 0;
        PriorityQueue<Integer> leftEdges = new PriorityQueue<Integer>();
        PriorityQueue<Long> rightEdges = new PriorityQueue<Long>();
        for (int i=0; i<A.length; i++){
            leftEdges.add(i-A[i]);
            rightEdges.add((long)i+(long)(A[i]));
        }
        int otherCirclesAtThisEdgeNum = 0;

        while ( !rightEdges.isEmpty()) {
            try {
                //peek - method retrieves the value of the first element of the queue without removing it from the queue
                // If the queue is empty the peek() method returns null

                // element - behaves like peek
                //  if the list is empty element() throws a NoSuchElementException
                if (leftEdges.element() <= rightEdges.peek() ) {
                    overlaps += otherCirclesAtThisEdgeNum++;
                    if (overlaps > 10000000) return -1;

                    // retrieves the value of the first element of the queue by removing it from the queue
                    //if the list is already empty it returns null but does not throw any exception
                    leftEdges.poll();
                } else {
                    otherCirclesAtThisEdgeNum--;
                    rightEdges.poll();
                }
            }catch (NoSuchElementException e){
                break;
            }
        }
        return overlaps;
    }


    public static void main(String[] args){

        DiscsIntersecion algo = new DiscsIntersecion();


        validate(algo, new int[]{1, 5, 2, 1, 4, 0}, 11);
//        validate(algo, new int[]{-1, 3, -4, 5, 1, -6, 2, 1});

    }

    private static void validate(DiscsIntersecion algo, int[] A, int result){
        System.out.println("==========");

        if( result == algo.solution(A))
            System.out.println(String.format("PASS %s %d",  Arrays.toString(A), result));
        else
            System.out.println(String.format("FAIL %s %d", Arrays.toString(A), result));

    }



}
