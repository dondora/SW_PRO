package T0420;

public class ColorPaper {

	public static int L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		dp[1] = 2;
		dp[2] = 5;		
		System.out.println(calc(49));
//		L = 4;
//		backtrack(0, 0);
//		System.out.println(total);
	
	}
	
	public static long total=0;
	public static long dp[] = new long[100];

	public static void backtrack(int color, int l)
	{
		if(l>L) return;
		if(l==L)
		{
			total++;
			return;
		}
		
		backtrack(1, l+1);
		backtrack(2, l+1);
		backtrack(3, l+2);		
	}
	
	public static long calc(int n)
	{
		if(dp[n]>0) return dp[n];
		dp[n] = 2*calc(n-1) + calc(n-2);
		return dp[n];
	}


}
