
// �̹��� ���絵 �˻�
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4_3 {

	public static int matrix[][] = new int [20][2];	
	public static int M[][] = new int [20][20];			// ��� ���� ���� ��ȹ������ ������ �迭
	public static int d[] = new int [21];				// 2*3, 3*4, 4*5�� 3���� ���� �迭�� ���ؼ� d�迭�� 2, 3, 4, 5�� �����Ѵ�.
	public static int mcnt;				// ����� ����

	public static int solve(int i, int j)
	{
		int min = Integer.MAX_VALUE;
		if (M[i][j] >= 0) return M[i][j];
		for (int k = i; k <= j - 1; k++)
		{
			int t = solve(i, k) + solve(k + 1, j) + d[i] * d[k + 1] * d[j + 1];
			if (min > t) min = t;
		}
		return M[i][j] = min;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		long start = System.currentTimeMillis();

		Scanner sc = new Scanner(new File("day4_3.txt"));

		int n;

		for(n = 1; n <= 5; n++)
		{
			int i, j;

			mcnt = sc.nextInt();
			
			for(i = 0; i < mcnt; i++)
			{
				matrix[i][0] = sc.nextInt();
				matrix[i][1] = sc.nextInt();
			}
			// ���� ����� ���� ã��
			int spos;
			for (spos = 0; spos < mcnt; spos++)
			{
				for (j = 0; j < mcnt; j++)
				if (matrix[spos][0] == matrix[j][1])  break;

				if (j == mcnt) break;
			}

			// ���� ��ķ� ���� d�� ����
			d[0] = matrix[spos][0];

			for (i = 0; i < mcnt; i++)
				for (j = 0; j < mcnt; j++)
					if (matrix[j][0] == d[i])
					{
						d[i + 1] = matrix[j][1];
						break;
					}

			// ���� ��ȹ���� ����� �迭 �ʱ�ȭ
			for (i = 0; i <mcnt; i++)
				for (j = i + 1; j < mcnt; j++)
					M[i][j] = -1;

			for (i = 0; i < mcnt; i++)
				M[i][i] = 0;
			
			System.out.printf("#%d %d\n", n, solve(0, mcnt - 1) );
		}
		sc.close();

		long end = System.currentTimeMillis();
		System.out.println( "���� �ð� : " + ( end - start )/1000.0 ); 
	}
}


