package practice01;

import java.util.*;
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

public class MergeKSortedListsHeap {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here

        if (lists == null || lists.size() == 0)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy; 

        Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a.val != b.val) {
                    return a.val - b.val;
                } else {
                    return -1;
                }
            }
        }); 

        for (int i = 0; i < lists.size(); i++) {
            ListNode node = lists.get(i);
            if (node == null)
                continue;
            queue.offer(node);
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
            tail = tail.next;
        }

        return dummy.next;
    }
}