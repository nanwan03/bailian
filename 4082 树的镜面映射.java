import java.util.*;
import java.io.*;

class Node {
	char val;
	Node left;
	Node right;
	Node(char val) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Main {
	private static int index = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = Integer.parseInt(in.nextLine());
		String[] strs = in.nextLine().split("\\s+");
		Node root = buildTree(strs);
		printTree(root);
		System.out.println("");
	}
	private static Node buildTree(String[] strs) {
		if (index == strs.length) {
			return null;
		}
		String temp = strs[index++];
		char val = temp.charAt(0);
		int type = temp.charAt(1);
		Node newNode = new Node(val);
		if (type == '1') {
			return newNode;
		} else {
			newNode.left = buildTree(strs);
			newNode.right = buildTree(strs);
			return newNode;
		}
	}
	private static void printTree(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		List<Character> list = new ArrayList<Character>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			list.clear();
			for (int i = 0; i < size; ++i) {
				Node node = queue.poll();
				list.add(node.val);
				if (node.left != null && node.left.val != '$') {
					Node temp = node.left;
					while (temp != null && temp.val != '$') {
						queue.offer(temp);
						temp = temp.right;
					}
				}
			}
			Collections.reverse(list);
			for (char c : list) {
				System.out.print(c + " ");
			}
		}
	}
}