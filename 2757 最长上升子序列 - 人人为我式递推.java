import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int[] input = new int[length];
		int[] dp = new int[length];
		for (int i = 0; i < length; ++i) {
			input[i] = in.nextInt();
			dp[i] = 1;
		}
		int rst = 1;
		for (int i = 1; i < length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (input[i] > input[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					rst = Math.max(rst, dp[i]);
				}
			}
		}
		System.out.println(rst);
	}
}