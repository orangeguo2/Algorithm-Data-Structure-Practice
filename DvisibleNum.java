import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DvisibleNum {
	public static List<Integer> divisive(int n){
		List<Integer> div = new ArrayList<>();
		List<Integer> prime = new ArrayList<>(); //put all prime number
		boolean[] isPrime = new boolean[n + 1];
		Map<Integer, Integer> smallPF = new HashMap<>();
		
		for(int i = 2; i < n + 1; i++)
			isPrime[i] = true;
		
		div.add(0);
		div.add(1);
		
		for(int i = 2; i < n + 1; i++) {
			if(isPrime[i]) {
				prime.add(i);
				smallPF.put(i, i);
			}
			for(int j = 0; j < prime.size() && prime.get(j) * i < n && prime.get(j) <= smallPF.get(i); j++) {
				isPrime[i * prime.get(j)] = false;
				div.add(i * prime.get(j));
				smallPF.put(i * prime.get(j), prime.get(j));
			}
		}
		
		return div;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner reader = new Scanner(System.in); 
	        while(reader.hasNext()) {
			String inpu = reader.nextLine();
			int input = Integer.parseInt(inpu);
			System.out.println(divisive(input));
	        }
	}

}
