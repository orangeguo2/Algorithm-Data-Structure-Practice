import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class BoxFactor {
	/*Write a function that 
	 * returns true when number of things 
	 * (N) can be precisely divided into 
	 * boxes of 6, 9 and 20 => N = 6x + 9y + 20z  */
	public static boolean recusion(int n) {
		int[] factor = {3,14,11,6,9,20};
		int sign = n < 0? -1:1;
		boolean divisive = false;
		for(int i = 0; i < factor.length; i++) {
			if(n%factor[i] == 0) return true;
			if(Math.abs(n) > factor[i])
				divisive = divisive || recusion(n -  sign * factor[i]);
		}
		return divisive;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Scanner reader = new Scanner(System.in); 
        while(reader.hasNext()) {
		String inpu = reader.nextLine();
		int input = Integer.parseInt(inpu);
		System.out.println(recusion(input));
        }
	}

}
