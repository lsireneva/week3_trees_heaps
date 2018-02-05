import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        if (a.size() == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(a.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != null)
                queue.add(a.get(i));
        }

        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            pointer.next = node;
            if (node.next != null)
                queue.add(node.next);
            pointer = pointer.next;
        }
        return head.next;
    }



    public static void main (String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(10);
        ListNode c = new ListNode(20);

        ListNode d = new ListNode(4);
        ListNode e = new ListNode(11);
        ListNode f = new ListNode(13);

        ListNode g = new ListNode(3);
        ListNode k = new ListNode(8);
        ListNode l = new ListNode(9);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;

        g.next = k;
        k.next = l;
        ArrayList<ListNode> list = new ArrayList();
        list.add(a);
        list.add(d);
        list.add(g);

        ListNode res = mergeKLists(list);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println(" ");



    }
}
