////����, �ߺ� ����, �ߺ� ����  ����

public class day3_counting {
	public static int t[] = new int[3];
	public static int a[] = {1, 2, 3};
	public static int cnt_r, N = 3, R = 2;


	public static void print_arr()
	{
		System.out.printf("[%d] : ", cnt_r++);

		for (int i = 0; i < R; i++)
			System.out.printf("%d ", t[i]);
		System.out.printf("\n");
	}

	public static void SWAP(int i, int j)
	{
		int t = a[i]; 	a[i] = a[j];	a[j] = t;
	}


	public static void reset()
	{
		System.out.printf(" ----------------------------\n");
		cnt_r = 1;
	}


	public static void comb_i() // �ݺ��� ����
	{
		int cnt = 1;
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				System.out.printf("[%d] : %d %d\n", cnt++, a[i], a[j]);
	}

	public static void pi_i()  // �ݺ��� �ߺ� ����
	{
		int cnt = 1;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				System.out.printf("[%d] : %d %d\n", cnt++, a[i], a[j]);
	}

	public static void H_i()  // �ݺ��� �ߺ� ����
	{
		int cnt = 1;
		for (int i = 0; i < N; i++)
			for (int j = i; j < N; j++)
				System.out.printf("[%d] : %d %d\n", cnt++, a[i], a[j]);
	}

	public static void comb_r_1(int n, int r) //  ���� ���� ����� �˰���1
	{
		if (r == 0) print_arr();
		else if (n < r) return;
		else
		{
			t[r - 1] = a[n - 1];
			comb_r_1(n - 1, r - 1);
			comb_r_1(n - 1, r);
		}
	}

	public static void comb_r_2(int k, int s) // ����, ���ۼ��� // ���� ���� ����� �˰���2
	{
		if (k == R) print_arr();
		else
		{
			for (int i = s; i <= N + (k - R); i++)
			{
				t[k] = a[i];
				comb_r_2(k + 1, i + 1);
			}
		}
	}


	public static void pi_r_1(int n, int r)	// �ߺ� ���� ���� ����� �˰���1
	{
		if (r == 0) print_arr();
		else
		{
			for (int i = n - 1; i >= 0; i--)
			{
				SWAP(i, n - 1);
				t[r - 1] = a[n - 1];
				pi_r_1(n, r - 1);
				SWAP(i, n - 1);
			}
		}
	}

	public static void pi_r_2(int k) // ����  // �ߺ� ���� ���� ����� �˰���2
	{
		if (k == R) print_arr();
		else
		{
			for (int i = 0; i < N; i++)
			{
				t[k] = a[i];
				pi_r_2(k + 1);
			}
		}
	}



	public static void H_r_1(int n, int r)	//  �ߺ����� ���� ����� �˰���1
	{
		if (r == 0) print_arr();
		else if (n == 0) return; // ����!!!
		else
		{
			t[r - 1] = a[n - 1];
			H_r_1(n, r - 1);
			H_r_1(n - 1, r);
		}
	}


	public static void H_r_2(int k, int s) // ����, ���ۼ��� // �ߺ����� ���� ����� �˰���2
	{
		if (k == R) print_arr();
		else
		{
			for (int i = s; i < N; i++)
			{
				t[k] = a[i];
				H_r_2(k + 1, i);
			}
		}
	}



	public static void main(String[] args) 
	{
		System.out.printf("����\n");
		comb_i();  // �ݺ���
		reset();
		comb_r_1(N, R);
		reset();
		comb_r_2(0, 0);
		

		System.out.printf("\n�ߺ� ����\n");
		pi_i();  // �ݺ���
		reset();
		pi_r_1(N, R);
		reset();
		pi_r_2(0);


		System.out.printf("\n�ߺ� ����\n");
		H_i();  // �ݺ���
		reset();
		H_r_1(N, R);
		reset();
		H_r_2(0, 0); 
	}
}




