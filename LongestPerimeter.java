import java.util.Arrays;

public class LongestPerimeter {
	public int longestPerimeter(int[] edge){
		//int max = 0; do not need
		Arrays.sort(edge);
		for(int i = edge.length - 1; i -2 >=0; i--){
			if(edge[i] < edge[i - 1] + edge[i - 2])
				// max = Math.max(max, edge[i] + edge[i - 1] + edge[i - 2]); just return because when go to front, every number of 3 becomes less
				return edge[i] + edge[i - 1] + edge[i - 2];
				
	}
	return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
