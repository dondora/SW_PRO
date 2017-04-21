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

