package wh.practice.algorithm;

import java.util.*;

/**
 * 服务失效判断
 * @author wanghuan
 */
public class BadService {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String services = in.nextLine();
        String badServices = in.nextLine();
        Map<String, Node> all = new HashMap<>();
        for (String s : services.split(",")) {
            String[] service = s.split("-");
            String service0 = service[0];
            String service1 = service[1];
            Node node0 = all.get(service0);
            Node node1 = all.get(service1);
            if (node1 == null) {
                node1 = new Node(service1);
                all.put(service1, node1);
            }
            if (node0 == null) {
                node0 = new Node(service0);
                all.put(service0, node0);
            }
            node1.next.add(node0);

        }

        for (String bad : badServices.split(",")) {
            if (all.get(bad) != null && all.get(bad).name != null) {
                all.get(bad).destroy();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Node> entry : all.entrySet()) {
            if (entry.getValue() != null && entry.getValue().name != null) {
                sb.append(entry.getValue().name);
                sb.append(",");
            }
        }
        if (sb.length() >= 1) {
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }else {
            System.out.println(",");
        }
    }

    /**
     * 借助树形结构
     */
    static class Node {
        String name;
        List<Node> next;
        Node (String name) {
            this.name = name;
            this.next = new ArrayList<>();
        }
        void destroy() {
            if (this.name != null) {
                this.name = null;
                for (Node node : this.next) {
                    node.destroy();
                }
            }
        }
    }
}
