import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcase = in.nextInt();
		while (testcase-- > 0) {
			int target = in.nextInt();
			int numberA = in.nextInt();
			int[] a = new int[numberA];
			for (int i = 0; i < numberA; ++i) {
				a[i] = in.nextInt();
			}
			Arrays.sort(a);
			int numberB = in.nextInt();
			int[] b = new int[numberB];
			for (int i = 0; i < numberB; ++i) {
				b[i] = in.nextInt();
			}
			Arrays.sort(b);
			int rst = 0;
			for (int i : a) {
				for (int j : b) {
					rst += (i + j == target) ? 1 : 0;
				}
			}
			System.out.println(rst);
		}
	}
}