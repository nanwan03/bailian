import java.util.Arrays;   
import java.util.Scanner;   
public class Main {
	private static int[][] dp = new int[16][16];
    public static void main(String[] args) {   
        Scanner in = new Scanner(System.in);   
        int input = in.nextInt();
        for (int i = 0; i < 16; ++i) {
        	for (int j = 0; j < 16; ++j) {
        		dp[i][j] = -1;
        	}
        }
        dp[1][1] = 2;
        System.out.println(helper(0, input));
    }
    private static int helper(int stack, int remain) {
    	if (dp[stack][remain] != -1) {
    		return dp[stack][remain];
    	}
    	if (remain == 0) {
    		return 1;
    	} else if (stack == 0) {
    		return helper(stack + 1, remain - 1);
    	} else {
    		return helper(stack + 1, remain - 1) + helper(stack - 1, remain);
    	}
    }
}