

/*
 * Problem: Remove Nth Node From End of List
 *
 * Algorithm:
 * 1. Initialize a temporary pointer to the head.
 * 2. Traverse the linked list and calculate its total length.
 * 3. If n equals the total length, remove the first node
 *    by returning head.next.
 * 4. Otherwise, calculate the position of the node before
 *    the target node using (length - n).
 * 5. Traverse the list to reach that previous node.
 * 6. Update its next reference to skip the target node.
 * 7. Return the updated head.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveNthNodeFromEnd {
    int val;
    RemoveNthNodeFromEnd next;
    RemoveNthNodeFromEnd() {}
    RemoveNthNodeFromEnd(int val) {

        this.val = val;
    }
    RemoveNthNodeFromEnd(int val, RemoveNthNodeFromEnd next) {
        this.val = val; this.next = next;

    }


class Solution {

    public RemoveNthNodeFromEnd removeNthFromEnd(RemoveNthNodeFromEnd head, int n) {

        // Step 1: Calculate the length of the linked list
        int length = 0;
        RemoveNthNodeFromEnd temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: If the first node must be removed
        if (n == length) {
            return head.next;
        }

        // Step 3: Find the node before the target node
        temp = head;

        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }

        // Step 4: Remove the target node
        temp.next = temp.next.next;

        // Step 5: Return the updated head
        return head;
    }
}
}