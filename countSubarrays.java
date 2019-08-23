class countSubarrays
{ 
  
    // function that returns the count of 
    // subarrays with m odd numbers  
    public static int countSubarrays(int a[], 
                                     int n, int m) 
    { 
        int count = 0; 
        int oven[] = new int[n]; 
        int odd = 0; 
      
        // traverse in the array 
        for (int i = 0; i < n; i++) 
        { 
           
            // if array element is odd 
            if ((a[i] & 1) == 1) 
                odd++; 
            else oven[odd]++; 
  
            // when number of odd  
            // elements >= M 
            if (odd >= m) {
                count += oven[odd - m]+1;
            }
            } 
      
        return count; 
    } 
      
    // Driver code 
    public static void main (String[] args) 
    { 
        int a[] = { 2, 2, 2, 5,7,2}; 
        int n = a.length; 
        int m = 1; 
          
        System.out.println(countSubarrays(a, n, m)); 
    } 
} 