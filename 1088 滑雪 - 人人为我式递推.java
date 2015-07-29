import java.util.*;
class Node {
	int x;
	int y;
	int h;
	int length;
	Node (int x, int y, int h) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.length = 1;
	}
}

class NodeComparator implements Comparator<Node> {
	public int compare(Node a, Node b) {
		return a.h - b.h;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int col = in.nextInt();
		Node[][] map = new Node[row][col];
		Node[] nodes = new Node[row * col];
		int index = 0;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				int height = in.nextInt();
				nodes[index] = new Node(i, j, height);
				map[i][j] = nodes[index];
				index++;
			}
		}
		Arrays.sort(nodes, new NodeComparator());
		int max = 1;
		for (Node node : nodes) {
			int nodeX = node.x;
			int nodeY = node.y;
			int height = node.h;
			List<Node> neighbors = getLowerNeighbors(map, nodes, nodeX, nodeY, height, row, col);
			if (neighbors.size() == 0) {
				node.length = 1;
			} else {
				int tempMax = 1;
				for (Node n : neighbors) {
					tempMax = Math.max(tempMax, n.length);
				}
				node.length = tempMax + 1;
				max = Math.max(max, node.length);
			}
		}
		System.out.println(max);
	}
	private static List<Node> getLowerNeighbors(Node[][] map, Node[] nodes, int nodeX, int nodeY, int height, int row, int col) {
		List<Node> list = new ArrayList<Node>();
		if (nodeX + 1 < row && map[nodeX + 1][nodeY].h < height) {
			list.add(map[nodeX + 1][nodeY]);
		}
		if (nodeX - 1 >= 0 && map[nodeX - 1][nodeY].h < height) {
			list.add(map[nodeX - 1][nodeY]);
		}
		if (nodeY + 1 < col && map[nodeX][nodeY + 1].h < height) {
			list.add(map[nodeX][nodeY + 1]);
		}
		if (nodeY - 1 >= 0 && map[nodeX][nodeY - 1].h < height) {
			list.add(map[nodeX][nodeY - 1]);
		}
		return list;
	}
}