package kpy6;

import java.util.Arrays;

/**
 * Task
 * Sum all the numbers of a given array ( cq. list ), except the highest and the lowest element ( by value, not by index! ). <br>
 * The highest or lowest element respectively is a single element at each edge, even if there are more than one with the same value.  <br>
 * Mind the input validation.  <br>
 * Example  <br>
 * { 6, 2, 1, 8, 10 } => 16   <br>
 * { 1, 1, 11, 2, 3 } => 6    <br>
 * Input validation    <br>
 * If an empty value ( null, None, Nothing etc. ) is given instead of an array, or the given array is an empty list or a list with only 1 element, return 0.    <br>
 */
public class Exercise3 {

    private Exercise3() {}

    public static int sum(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        int sum = Arrays.stream(arr).sum();
        return sum - min - max;

//        if (arr == null || arr.length < 3) {
//            return 0;
//        }
//        Arrays.sort(arr);
//        int sum = 0;
//        for (int i = 1; i < arr.length - 1; i++) {
//            sum += arr[i];
//        }
    }
}
