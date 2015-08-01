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
		for (int i = 0; i < length; ++i) {
			for (int j = i + 1; j < length; ++j) {
				if (input[j] > input[i]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
					rst = Math.max(rst, dp[j]);
				}
			}
		}
		System.out.println(rst);
	}
}