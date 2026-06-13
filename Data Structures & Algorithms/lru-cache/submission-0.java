
public class Node {
    int key;
    int val;
    Node prev;
    Node right;

    public Node(int key,int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.right = null;
    }
}

public class LRUCache {
    private Map<Integer,Node> hashMap;
    private int capacity;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.hashMap = new HashMap<>();
        this.capacity = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.right = this.right;
        this.right.prev = this.left;
    }
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.right;
        prev.right = next;
        next.prev = prev;
    }

    private void insert(Node node){
        Node prev = this.right.prev;
        prev.right = node;
        node.prev = prev;
        node.right = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        int value = -1;
        if(hashMap.containsKey(key)){
            Node node = hashMap.get(key);
            remove(node);
            insert(node);
            value = node.val;
        }
        return value;
    }
    
    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
            remove(hashMap.get(key));
        }
        Node newNode = new Node(key,value);
        hashMap.put(key,newNode);
        insert(newNode);
        if(hashMap.size() > this.capacity){
            Node left = this.left.right;
            remove(left);
            hashMap.remove(left.key);
        }
    }
}
