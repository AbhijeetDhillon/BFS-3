//Time Complexity : O(n+c) where n is the nodes and c is the connections;
//Space Complexity : O(2n) since set and queue both are used;
//Leetcode : Worked;



class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        HashMap<Integer, Node> map = new HashMap<>();
        Node copyNode = new Node(node.val);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node.val, copyNode);
        while(!q.isEmpty()){
            Node curr = q.poll();
                for(Node n : curr.neighbors){
                    if(!map.containsKey(n.val)){
                        Node copy = new Node(n.val);
                        map.put(n.val,copy);
                        q.add(n);
                }
                    
                    map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return copyNode;
    }
    
}