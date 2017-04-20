//병원짓기
//N개의 마을이 있고 마을에 병원을 짓는 비용이 주어진다.
//도로로 직접 연결된 이웃 마을에서 병원 진료를 받을 수 있다.
//도로로 연결된 이웃 마을의 관계가 주어진다.
//모든 마을의 사람들이 병원 진료를 받을 수 있도록 최소 비용으로 병원을 짓고자 할때 최소 비용이 얼마인가?
//당연히 자기 마을에 병원이 있으면 자기 마을에서 병원 진료를 받을 수 있다.

//
//입력예
//5
//100 70 50 80 10
//0 1 0 1 0 
//1 0 1 0 1
//0 1 0 0 0
//1 0 0 0 0
//0 1 0 0 0
//출력예
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

