//��������
//N���� ������ �ְ� ������ ������ ���� ����� �־�����.
//���η� ���� ����� �̿� �������� ���� ���Ḧ ���� �� �ִ�.
//���η� ����� �̿� ������ ���谡 �־�����.
//��� ������ ������� ���� ���Ḧ ���� �� �ֵ��� �ּ� ������� ������ ������ �Ҷ� �ּ� ����� ���ΰ�?
//�翬�� �ڱ� ������ ������ ������ �ڱ� �������� ���� ���Ḧ ���� �� �ִ�.

//
//�Է¿�
//5
//100 70 50 80 10
//0 1 0 1 0 
//1 0 1 0 1
//0 1 0 0 0
//1 0 0 0 0
//0 1 0 0 0
//��¿�
//140



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3_1_iter {
	
	public static int map[][] =  new int [21][21];
	public static int cost[] = new int[21];
	public static int a[] = new int [21];
	public static int N, ans = 12345678;

	
	public static void check()
	{
		int tcnt = 0, tsum = 0, i, j;
		int con[] = new int [21];

		for (i = 1; i <= N; i++)
		{
			if (a[i]==1)
			{
				con[i] = 1;
				for (j = 1; j <= N; j++)
					if (map[i][j] > 0) con[j] = 1;
				tsum += cost[i];
			}
		}

		for (i = 1; i <= N; i++) tcnt += con[i];

		if (tcnt == N && ans > tsum) ans = tsum;
	}



	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day3_1.txt"));

		int i, j;
		N = sc.nextInt();
		
		for (i = 1; i <= N; i++)
			cost[i] = sc.nextInt();

		for (i = 1; i <= N; i++)
			for (j = 1; j <= N; j++)
				map[i][j] = sc.nextInt();
				
		for (int x0 = 0; x0 < 2; x0++)
		{
			a[1] = x0;
			for (int x1 = 0; x1 < 2; x1++)
			{
				a[2] = x1;
				for (int x2 = 0; x2 < 2; x2++)
				{
					a[3] = x2;
					for (int x3 = 0; x3 < 2; x3++)
					{
						a[4] = x3;
						for (int x4 = 0; x4 < 2; x4++)
						{
							a[5] = x4;
							check();
						}}}}}

		System.out.println(ans);

		sc.close();
	}
}

