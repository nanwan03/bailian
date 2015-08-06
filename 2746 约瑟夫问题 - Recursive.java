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
    	if (n == 1) {
    		return 1;
    	}
    	return (joseph(n - 1, k) + k - 1) % n + 1;
    }
}