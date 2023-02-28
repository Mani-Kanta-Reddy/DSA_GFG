package misc;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode head = mergeTwoLists(list1, list2);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //handle corner cases
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        //handle non-corner-cases
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode merged = null, lastNodeMerged = null;

        //compare the vals of temp1 and temp2 and build the mergedList
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                //build node
                ListNode node = new ListNode(temp1.val);
                //first ele
                if(merged == null && lastNodeMerged == null) {
                    merged = node;
                    lastNodeMerged = node;
                }
                //atleast one-ele
                else {
                    lastNodeMerged.next = node;
                    lastNodeMerged = node;
                }

                temp1 = temp1.next;
            } else {
                //build node
                ListNode node = new ListNode(temp2.val);
                //first ele
                if(merged == null && lastNodeMerged == null) {
                    merged = node;
                    lastNodeMerged = node;
                }
                //atleast one-ele
                else {
                    lastNodeMerged.next = node;
                    lastNodeMerged = node;
                }
                temp2 = temp2.next;
            }
        }
        //add the remaining nodes to the merged
        if(temp1 == null) {
            //traverse over remaining temp2
            while(temp2 != null) {
                //build node
                ListNode node = new ListNode(temp2.val);
                //first ele
                if(merged == null && lastNodeMerged == null) {
                    merged = node;
                    lastNodeMerged = node;
                }
                //atleast one-ele
                else {
                    lastNodeMerged.next = node;
                    lastNodeMerged = node;
                }
                temp2 = temp2.next;
            }
        } else {
            //traverse over the remaining temp1 nodes and add to merged
            while(temp1 != null) {
                //build node
                ListNode node = new ListNode(temp1.val);
                //first ele
                if(merged == null && lastNodeMerged == null) {
                    merged = node;
                    lastNodeMerged = node;
                }
                //atleast one-ele
                else {
                    lastNodeMerged.next = node;
                    lastNodeMerged = node;
                }
                temp1 = temp1.next;
            }
        }
        return merged;
    }
}
