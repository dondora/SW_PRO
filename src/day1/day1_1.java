package day1;
//프로젝트배분1
//프로젝트와 회사가 N개 있다. 각 회사는 각 프로젝트의 입찰가를 제출한다.
//프로젝트를 한 회사에 하나씩 골고루 나누어 주고 싶다.
//총합이 최가 되도록 나누어 주고 싶다. 최소 총합은 얼마가 되는가?
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
//출력
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

