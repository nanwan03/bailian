import java.util.*;
import java.io.*;

class Node {
	int val;
	Node left;
	Node right;
	Node(int val) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class NodeComparator implements Comparator<Node> {
	public int compare(Node a, Node b) {
		return a.val - b.val;
	}
}
public class Main {
	private static int rst = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] input = new int[num];
		for (int i = 0; i < num; ++i) {
			input[i] = in.nextInt();
		}
		if (num <= 2) {
			System.out.println((num == 1) ? input[0] : (input[0] + input[1]));
		} else {
			Node root = buildTree(input);
			preTravel(root, 0);
			System.out.println(rst);
		}
	}
	private static Node buildTree(int[] input) {
		Queue<Node> heap = new PriorityQueue<Node>(input.length, new NodeComparator());
		for (int i = 0; i < input.length; ++i) {
			heap.offer(new Node(input[i]));
		}
		while (heap.size() > 1) {
			Node left = heap.poll();
			Node right = heap.poll();
			Node root = new Node(left.val + right.val);
			root.left = left;
			root.right = right;
			heap.offer(root);
		}
		return heap.poll();
	}
	private static void preTravel(Node root, int level) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			rst += level * root.val;
			return;
		}
		preTravel(root.left, level + 1);
		preTravel(root.right, level + 1);
	}
}