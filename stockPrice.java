
public class stockPrice {
	public static String[] stringFormattedWeeklyPrices(int[] dailyPrice) {
		if(dailyPrice == null || dailyPrice.length == 0) return new String[0];
		
		int len = dailyPrice.length;
		float sum = 0;
		int i = 0;
		for(; i <len && i < 7; i++) {
			sum+=dailyPrice[i];
		}
		if(i==len) return new String[] {String.format("%.2f",sum/len)};
		
		String[] res = new String[len -7+1];
		res[0] = String.format("%.2f",sum/7.0f);
		int before = 0;
		for(int j = 7; j < len; j++) {
			sum-=dailyPrice[before++];
			sum+=dailyPrice[j];
			res[before] = String.format("%.2f",sum/7.0f);
		}
		
		
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] re = stringFormattedWeeklyPrices(new int[] {2,2,2,2,2,2,2,2,2,2});
				for(String s :re)
		System.out.println(s);
	}

}
