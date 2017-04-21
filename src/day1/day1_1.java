package day1;
//������Ʈ���1
//������Ʈ�� ȸ�簡 N�� �ִ�. �� ȸ��� �� ������Ʈ�� �������� �����Ѵ�.
//������Ʈ�� �� ȸ�翡 �ϳ��� ���� ������ �ְ� �ʹ�.
//������ �ְ� �ǵ��� ������ �ְ� �ʹ�. �ּ� ������ �󸶰� �Ǵ°�?
//N < 11
//
//7
//88 51 24 88 94 50 60
//14 55 1 23 12 84 91
//26 44 81 97 33 82 30
//3 71 12 99 16 92 48
//87 5 14 93 28 92 56
//4 14 92 96 48 41 77
//94 32 43 16 1 52 51
//
//���
//122 


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1_1 {

	public static int m[][] = new int[11][11];
	public static int check[] = new int [11];
	public static int a[] = new int [11];
	public static int N, ans, cnt;
	
	
	public static void solve(int k)
	{
		cnt++;

		if (k == N)
		{
			int tsum = 0;
			for (int i = 1; i <= N; i++) tsum += m[i][a[i]];
			
			if (tsum < ans) ans = tsum;
		}
		else
		{
			k++;
			for (int i = 1; i <= N; i++)
			{
				if (check[i] == 0)
				{
					a[k] = i;
					check[i] = 1;
					solve(k);
					check[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day1_1.txt"));
		
		N = sc.nextInt();

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				m[i][j] = sc.nextInt();;

		ans = 0x7fffffff;
		cnt = 0;

		for (int i = 1; i < 11; i++) check[i] = 0;

		solve(0);
		System.out.printf("%d %d\n", ans, cnt);
		
		sc.close();
	}
}

