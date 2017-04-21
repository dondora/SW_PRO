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

public class day1_1_iter {

	public static int m[][] = new int[11][11];
	public static int ans, N;
	

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day1_1.txt"));
		
		N = sc.nextInt();

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				m[i][j] = sc.nextInt();

		ans = 0x12345678;
		for (int x1 = 0; x1 < 7; x1++)
		for (int x2 = 0; x2 < 7; x2++) if (x2 != x1)
		for (int x3 = 0; x3 < 7; x3++) if (x3 != x1 && x3 != x2)
		for (int x4 = 0; x4 < 7; x4++) if (x4 != x1 && x4 != x2 && x4 != x3)
		for (int x5 = 0; x5 < 7; x5++) if (x5 != x1 && x5 != x2 && x5 != x3 && x5 != x4)
		for (int x6 = 0; x6 < 7; x6++) if (x6 != x1 && x6 != x2 && x6 != x3 && x6 != x4 && x6 != x5)
		for (int x7 = 0; x7 < 7; x7++) if (x7 != x1 && x7 != x2 && x7 != x3 && x7 != x4 && x7 != x5 && x7 != x6)
		{
			int ts = m[0][x1] + m[1][x2] + m[2][x3] + m[3][x4] + m[4][x5] + m[5][x6] + m[6][x7];
			if (ts < ans)	ans = ts;

		}

		System.out.printf("%d\n", ans);
		
		sc.close();
	}
}

