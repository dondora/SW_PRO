/// 동전 교환


public class day4_e_1 {

	public static int C[] = new int [21];
	public static int D[] = { 1, 5, 10, 16 };
	
	public static int f(int n)
	{
		if (C[n] > 0) return C[n];

		int m = 100000, t;
		for (int i = 0; i < 4; i++)
			if (n - D[i] > 0)
			{
				t = f(n - D[i]);
				if (t < m) m = t;
			}

		return C[n] = m + 1;
	}
	
	public static void main(String[] args) {
		C[1] = C[5] = C[10] = C[16] = 1;

		System.out.printf("%d coins\n", f(17)); 
		
		for (int i = 0; i < 21; i++) System.out.printf("C[%2d] : %d \n", i, C[i]);  

	}

}
