// 부분집합 합 10

public class day3_e_1 {
	public static int count_ans = 1;
	public static int cnt;

	public static void process_solution(int a[], int k)
	{
		int sum = 0;

		for (int i = 0; i <= k; i++)
		if (a[i] == 1) sum += i;

		if (sum == 10)
		{
			System.out.printf("%d : (", count_ans++);
			for (int i = 0; i <= k; i++)
			if (a[i] == 1)
				System.out.printf(" %d", i);
			System.out.printf(")\n");
		}
	}

	public static void make_candidates(int a[], int k, int n, int c[], int ncandidates)
	{
		c[0] = 1;
		c[1] = 0;
		ncandidates = 2;
	}
	
	public static void backtrack(int a[], int k, int input)
	{
		int c[] = new int[10];
		int ncandidates = 0;
		//int sum = 0, j;
	
		cnt++;
	
		if (k == input)
		{
			process_solution(a, k);
		}
		else
		{
			k++;
			c[0] = 1;
			c[1] = 0;
			ncandidates = 2;
			
			for (int i = 0; i < ncandidates; i++)
			{
				a[k] = c[i];
				backtrack(a, k, input);
			}
		}
	}

	public static void main(String[] args) 
	{
		int a[] = new int[11];

		backtrack(a, 0, 10);

		System.out.printf("count : %d\n", cnt);
	}
}
