// 순열 재귀 여러 방법



//
//////순열 생성 재귀적 알고리즘1
public class day3_perm {
	public static int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	public static int tr[] = new int[10];
	public static int N = 3, R = 2;

	public static void SWAP(int i, int j)
	{
		int t = arr[i]; 	arr[i] = arr[j];	arr[j] = t;
	}

	public static void print_arr()
	{
		for (int i = 0; i < R; i++)
			System.out.printf("%d ", tr[i]);

		System.out.printf("\n");
	}

	public static void perm(int n, int r)
	{
		if (r == 0) print_arr();
		else
		{
			for (int i = n - 1; i >= 0; i--)
			{
				SWAP(i, n - 1);
				tr[r - 1] = arr[n - 1];
				perm(n - 1, r - 1);
				SWAP(i, n - 1);
			}
		}
	}

	public static void main(String[] args) 
	{
		perm(N, R);
	}
}

//////순열 생성 재귀적 알고리즘1-1
//public class day3_perm {
//	public static int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//	public static int N = 3, R = 2;
//
//	public static void SWAP(int i, int j)
//	{
//		int t = arr[i]; 	arr[i] = arr[j];	arr[j] = t;
//	}
//	
//	public static void print_arr()
//	{
//		for (int i = 0; i < R; i++)
//			System.out.printf("%d ", arr[i]);
//
//		System.out.printf("\n");
//	}
//	
//	public static void perm(int k)
//	{
//		if (k == R) print_arr();
//		else
//		{
//			for (int i = k; i < N; i++)
//			{
//				SWAP(k, i);
//				perm(k + 1);
//				SWAP(k, i);
//			}
//		}
//	}
//	
//	public static void main(String[] args) 
//	{
//		perm(0);
//	}
//}


//
//////순열 생성 재귀적 알고리즘2
//public class day3_perm {
//	public static int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//	public static int tr[] = new int[10];
//	public static boolean visited[] = new boolean [10];
//	public static int N = 3, R = 2;
//
//
//	public static void print_arr()
//	{
//		for (int i = 0; i < R; i++)
//			System.out.printf("%d ", tr[i]);
//
//		System.out.printf("\n");
//	}
//
//
//	public static void perm(int k)
//	{
//		if (k == R) print_arr();
//		else
//		{
//			for (int i = 0; i < N; i++)
//			{
//				if (visited[i]) continue;
//	
//				tr[k] = arr[i];
//				visited[i] = true;
//				perm(k + 1);
//				visited[i] = false;
//			}
//		}
//	}
//	
//	public static void main(String[] args) 
//	{
//		perm(0);
//	}
//}




