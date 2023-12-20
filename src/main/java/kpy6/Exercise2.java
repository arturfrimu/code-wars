package kpy6;

/**
 * Given an array of integers, find the one that appears an odd number of times. <br>
 * There will always be only one integer that appears an odd number of times.  <br>
 * Examples  <br>
 * [7] should return 7, because it occurs 1 time (which is odd).  <br>
 * [0] should return 0, because it occurs 1 time (which is odd).  <br>
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).  <br>
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).  <br>
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).  <br>
 */
public class Exercise2 {
    public static int findIt(int[] a) {
        int xor = 0;
        for (int num : a) {
            xor ^= num;
        }
        return xor;
    }
}
