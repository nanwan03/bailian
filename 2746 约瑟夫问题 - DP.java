import java.util.Arrays;   
import java.util.Scanner;   
public class Main {   
    public static void main(String[] args) {   
        Scanner in = new Scanner(System.in);   
        while (true) {
        	int n = in.nextInt();
        	int k = in.nextInt();
        	if (n == 0 && k == 0) {
        		System.exit(0);
        	}
        	System.out.println(joseph(n, k));
        }
    }   
    private static int joseph(int n, int k) {
    	int rst = 1;
    	for (int i = 1; i <= n; ++i) {
    		rst = (rst + k - 1) % i + 1;
    	}
    	return rst;
    }
}