import java.util.Arrays;   
import java.util.Scanner;   
public class Main {   
    public static void main(String[] args) {   
        Scanner in = new Scanner(System.in);   
        int testcase = Integer.parseInt(in.nextLine());
        while(testcase-- > 0) {
        	char[] chars = in.nextLine().toCharArray();
        	for (int i = 0; i < chars.length; ++i) {
        		if ((chars[i] <= 'z' && chars[i] >= 'a') || (chars[i] <= 'Z' && chars[i] >= 'A')) {
        			if (chars[i] == 'z' || chars[i] == 'Z') {
        				chars[i] -= 25;
        			} else {
        				++chars[i];
        			}
        		}
        	}
        	System.out.println(chars);
        }
    }
}