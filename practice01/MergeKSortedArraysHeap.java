package practice01;

import java.util.*;

class Element {
    public int val;
    public int row;
    public int col;

    public Element(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

public class MergeKSortedArraysHeap {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here

        if (arrays == null || arrays.length == 0)
            return null;
        
        int total = 0;
        PriorityQueue<Element> priorityQueue = new PriorityQueue(arrays.length, new Comparator<Element>() {
            @Override
            public int compare(Element a, Element b) {
                if (a.val != b.val) {
                    return a.val - b.val;
                } else if (a.row != b.row) {
                    return a.row - b.row;
                } else {
                    return a.col - b.col;
                }
            }
        });

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == null || arrays[i].length == 0)
                continue; 
            Element e = new Element(arrays[i][0], i, 0);
            priorityQueue.offer(e);
            total += arrays[i].length;
        }

        int[] res = new int[total];
        int index = 0;

        while (!priorityQueue.isEmpty()) {
            Element e = priorityQueue.poll();
            res[index++] = e.val; 

            if (e.col + 1 < arrays[e.row].length) {
                e.col += 1;
                e.val = arrays[e.row][e.col];
                priorityQueue.offer(e);
            }
        }

        return res;
    }
}