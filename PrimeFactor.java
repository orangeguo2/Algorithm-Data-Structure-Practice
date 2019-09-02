import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrimeFactor {
	// n not big, for each factor, try is prime: 0 to sprt(factor) each number d, factor % d == 0, false, otherwise prime factor
	// n big, generate all prime number smaller than sprt(n), try it 
	
	public static List<Integer> getPrimeFactorSmall(int a){
		if(a == 0) return getPrimeFactorSmall(Integer.MAX_VALUE);
		long n = a;
		List<Integer> primeFactor = new ArrayList<>();
		if(n == 1) return primeFactor;
		for(long i = 2; i <= n; i++) {
			if(n % i == 0 && isPrime((int)i) ) {
				primeFactor.add((int)i);
			}
		}
		return primeFactor;
	}
	public static boolean isPrime(int a) {
		long n = a;
		if(n == 2) return true;
		if(n % 2 == 0) return false;
		for(long i = 3; i * i <= n; i+=2) {
		
			if(n % i == 0) {	
				return false;
			}
		}
		
		return true;
	}
	
	public static List<Integer> getPrimeFactorBig(int a){
		long n = a;
		List<Integer> ls = new ArrayList<>();
		List<Long> prime = buildPrime(n);
		for(int i = 0; i< prime.size() && prime.get(i) < n; i++) {
			if(n % prime.get(i) == 0) {
				int factor = (int)(long)(prime.get(i));//cannot cast Long to int
				ls.add(factor);
			}
		}
		return ls;
	}
	public static List<Long> buildPrime(long n){
		//Euler linear method O(n)
		List<Long> prime = new ArrayList<>();
		int len = (int)(n + 1l);
		boolean[] isPrime = new boolean[len];
		//Long, Long
		Map<Long, Long> smallPrimeFactor = new HashMap<>();
		if(n < 2l) return prime;
		if(n == 2l) {
			prime.add(2l);
			return prime;
		}
		//default: is prime
		for(int i = 2; i < len; i++) {
			isPrime[i] = true;
		}
		
		for(int i = 2; i < len; i++) {
			if(isPrime[i]) {
				prime.add((long)i);
				smallPrimeFactor.put((long)i, (long)i);
			}
			for(int j = 0; j < prime.size() && (prime.get(j) * (long)i <= n) && prime.get(j) <= smallPrimeFactor.get((long)i);j++) {
				isPrime[(int)(long)prime.get(j) * i] = false;
				smallPrimeFactor.put(prime.get(j) * (long)i, prime.get(j));
			}
		}
		return prime;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner reader = new Scanner(System.in); 
	        while(reader.hasNext()) {
			String inpu = reader.nextLine();
			int input = Integer.parseInt(inpu);
			System.out.println(getPrimeFactorBig(input));
	        }
	}

}
