import java.util.*;

class HuffmanNode {
    int data;
    char c;
    HuffmanNode left, right;

    public HuffmanNode(int data, char c) {
        this.data = data;
        this.c = c;
        this.left = this.right = null;
    }
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

public class HuffmanCoding {
    static void printCodes(HuffmanNode root, String s, HashMap<Character, String> codes) {
        if (root == null) return;
        
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            codes.put(root.c, s);
            return;
        }
        printCodes(root.left, s + "0", codes);
        printCodes(root.right, s + "1", codes);
    }

    static void buildHuffmanTree(int n, Scanner sc) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter character " + (i + 1) + ":");
            char c = sc.next().charAt(0);
            System.out.println("Enter frequency for " + c + ":");
            int f = sc.nextInt();
            freq.put(c, f);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new MyComparator());
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new HuffmanNode(entry.getValue(), entry.getKey()));
        }

        while (pq.size() > 1) {
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();
            HuffmanNode newNode = new HuffmanNode(x.data + y.data, '-');
            newNode.left = x;
            newNode.right = y;
            pq.add(newNode);
        }

        HuffmanNode root = pq.peek();
        HashMap<Character, String> codes = new HashMap<>();
        printCodes(root, "", codes);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of characters:");
        int n = sc.nextInt();
        buildHuffmanTree(n, sc);
        sc.close();
    }
}
