import java.util.HashSet;
import java.util.Set;

public class BestTourPath {
	//backtracking
	int max = 0;
	int n, m , maxt;
	int[] beauty, u,v,t;
	
	public int findBestPath(int n, int m, int maxt, int[] beauty, int[] u, int[] v, int t[]){

		this.n = n;
		this.m = m;
		this.maxt = maxt;
		this.u = u;
		this.v = v;
		this.t = t;
		this.beauty = beauty;
		Set<Integer> visited = new HashSet<>();
		backtracking(5,0,this.maxt,visited);
		
		return max;
	} 
	//current beauty, i is current square, leftt
	public void backtracking(int curb, int curs, int leftt, Set<Integer> visited) {

		for(int i = 0; i < u.length; i++) {
			if(u[i] == curs && t[i] <= leftt && !visited.contains(v[i])) {
				//v[i] is the end
				visited.add(v[i]);
				backtracking(curb+beauty[v[i]], v[i], leftt - 2 * t[i],visited);
				visited.remove(v[i]);
			}
		}
		max = Math.max(curb, max);
	}
	
	
	public static void main (String[] args) 
    { 
		int n = 4, m = 3, maxt = 36;
		int[] u = {0,1,0};
		int[] v = {1,2,3};
		int[] beauty = {5,10,15,20};
		int[] t = {6,7,10};
		BestTourPath test = new BestTourPath();
		int res = test.findBestPath(n, m, maxt, beauty, u, v, t);
		System.out.println(res);
    } 
}
