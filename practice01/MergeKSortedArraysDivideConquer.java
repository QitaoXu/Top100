package practice01;

public class MergeKSortedArraysDivideConquer {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if (arrays == null || arrays.length == 0) 
            return null;
        
        return mergeSortedArraysHelper(arrays, 0, arrays.length - 1);
    }

    private int[] mergeSortedArraysHelper(int[][] arrays, int start, int end) {
        if (start == end) 
            return arrays[start];
        
        int mid = start + (end - start) / 2; 
        int[] left = mergeSortedArraysHelper(arrays, start, mid);
        int[] right = mergeSortedArraysHelper(arrays, mid + 1, end); 
        return mergeTwoSortedArrays(left, right);
    }

    private int[] mergeTwoSortedArrays(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int index = 0;
        int i = 0, j = 0; 

        while (i < left.length && j < right.length) {

            if (left[i] < right[j]) {
                res[index] = left[i];
                index++;
                i++;
            } else {
                res[index] = right[j];
                index++;
                j++;
            }
        }

        while (i < left.length) {
            res[index++] = left[i++];
        }

        while (j < right.length) {
            res[index++] = right[j++];
        }

        return res;
    }
}