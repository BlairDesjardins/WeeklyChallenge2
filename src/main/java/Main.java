import java.util.ArrayList;

public class Main {

    public static Node findIntersection(Node head1, Node head2) {
        Node cursor1 = head1;
        while (cursor1 != null) {
            Node cursor2 = head2;
            while (cursor2 != null) {
                if (cursor1 == cursor2)
                    return cursor2;
                cursor2 = cursor2.next;
            }
            cursor1 = cursor1.next;
        }
        return null;
    }

    public static Node findLoop(Node head) {
        ArrayList<Node> prevNodes = new ArrayList<>();
        Node cursor = head;
        while (cursor != null) {
            if (prevNodes.contains(cursor))
                return cursor;
            prevNodes.add(cursor);
            cursor = cursor.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node4);
        Node node1 = new Node(1, node2);

        Node inter = findIntersection(node1, node3);
        if (inter != null)
            System.out.println(inter.value);

        Node node9 = new Node(9, null);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        node9.next = node7;

        Node start = findLoop(node6);
        if (start != null)
            System.out.println(start.value);
    }
}
