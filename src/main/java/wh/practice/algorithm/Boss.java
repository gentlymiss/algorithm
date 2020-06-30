package wh.practice.algorithm;

import java.util.*;

/**
 * boss的收入
 * @author wanghuan
 */
public class Boss {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        Map<String, Node> map = new HashMap<>();
        int i1 = Integer.parseInt(in.nextLine());
        for (int a = 0; a < i1; a++) {
            String[] strings = in.nextLine().split(" ");
            String id = strings[0];
            String id1 = strings[1];
            int i = Integer.parseInt(strings[2]);
            Node node = new Node(id, i);
            map.put(id, node);
            if (map.get(id1) == null) {
                node.father= new Node(id1, 0);
                map.put(node.father.id, node.father);
            } else {
                node.father=map.get(id1);
            }
            set.add(id1);
        }
        for (String s : set) {
            map.remove(s);
        }
        while (map.size() > 1) {
            Map<String, Node> map1 = new HashMap<>();
            for (Map.Entry<String, Node> entry : map.entrySet()) {
                Node value = entry.getValue();
                value.father.i += (value.i / 100) * 15;
                map1.computeIfAbsent(value.father.id, k -> value.father);
            }
            map = map1;
        }
        for (Map.Entry<String, Node> entry : map.entrySet()) {
            System.out.println(entry.getValue().id+" "+entry.getValue().i);
        }
    }

    static class Node {
        String id;
        int i;
        Node father;
        Node(String id, int i) {
            this.id = id;
            this.i = i;
        }

        @Override
        public int hashCode() {
            return Integer.parseInt(id);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                return this.hashCode() == obj.hashCode();
            } else {
                return false;
            }
        }
    }
}
