import java.util.*;
import java.io.*;

public class Main {
	private static int root[];
	private static boolean isSameGroupToRoot[];
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(in.readLine());
		while (testcase-- > 0) {
			String[] strs = in.readLine().split("\\s+");
			int number = Integer.parseInt(strs[0]);
			int lines = Integer.parseInt(strs[1]);
			root = new int[number + 1];
			isSameGroupToRoot = new boolean[number + 1];
			Arrays.fill(isSameGroupToRoot, true);
			for (int i = 0; i <= number; ++i) {
				root[i] = i;
			}
			for (int i = 0; i < lines; ++i) {
				strs = in.readLine().split("\\s+");
				int a = Integer.parseInt(strs[1]);
				int b = Integer.parseInt(strs[2]);
				if (strs[0].equals("A")) {
					if (find(a) == find(b)) {
						if (isSameGroupToRoot[a] != isSameGroupToRoot[b]) {
							System.out.println("In different gangs.");
						} else {
							System.out.println("In the same gang.");
						}
					} else {
						System.out.println("Not sure yet.");
					}
				} else {
					union(a, b);
				}
			}
		}
	}
	private static int find(int node) {
		if (node == root[node]) {
			return node;
		}
		int tmp = root[node];
		root[node] = find(root[node]);
		isSameGroupToRoot[node] = !(isSameGroupToRoot[tmp] ^ isSameGroupToRoot[node]); //�����ӽڵ��븸�׽ڵ�Ĺ�ϵ�͸��ڵ���үү�ڵ�Ĺ�ϵ���Ƶ��ӽڵ���үү�ڵ�Ĺ�ϵ ��� a �� b �Ĺ�ϵ�� r1, b �� c �Ĺ�ϵ�� r2, ��ô a �� c �Ĺ�ϵ���� (r1+r2)%2
		return root[node];
	}
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) {
			return;
		}
		root[rootA] = rootB;
		isSameGroupToRoot[rootA] = isSameGroupToRoot[a] ^ isSameGroupToRoot[b]; //����ʱ��ʹ�� p[fx] = fy; ͬʱҲҪѰ�� fx �� fy �Ĺ�ϵ����ϵΪ����r[x]+r[y]+1��%2. fx �� x �Ĺ�ϵ�� r[x], x �� y �Ĺ�ϵ�� 1 ����Ϊȷ���ǲ�ͬ�࣬�����ϵģ�, y �� fy ��ϵ�� r[y],ģ 2 ����Ϊֻ�����ֹ�ϵ
	}
}