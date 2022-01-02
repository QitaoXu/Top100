package practice01;

import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
 }
 
public class  MergeKSortedListsDivideConquer {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0)
            return null;
        return mergeKListsHelper(0, lists.size() - 1, lists);
    }

    private ListNode mergeKListsHelper(int start, int end, List<ListNode> lists) {
        if (start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(start, mid, lists);
        ListNode right = mergeKListsHelper(mid + 1, end, lists);
        return mergeTwoSortedLists(left, right);
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); 
        ListNode tail = dummy; 

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } 
            else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            tail.next = l1;
            tail = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            tail.next = l2;
            tail = l2;
            l2 = l2.next;
        }

        return dummy.next;
    }
}
