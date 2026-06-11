/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        map.put(null,null);
        Node cur = head;
        while(cur != null){
            Node newNode = new Node(cur.val);
            map.put(cur,newNode);
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            Node newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
