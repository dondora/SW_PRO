
// 이미지 유사도 검사
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4_3 {

	public static int matrix[][] = new int [20][2];	
	public static int M[][] = new int [20][20];			// 행렬 곱을 동적 계획법으로 수행할 배열
	public static int d[] = new int [21];				// 2*3, 3*4, 4*5의 3개의 서브 배열에 대해서 d배열은 2, 3, 4, 5를 저장한다.
	public static int mcnt;				// 행렬의 개수

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
			// 연쇄 행렬의 시작 찾기
			int spos;
			for (spos = 0; spos < mcnt; spos++)
			{
				for (j = 0; j < mcnt; j++)
				if (matrix[spos][0] == matrix[j][1])  break;

				if (j == mcnt) break;
			}

			// 연쇄 행렬로 부터 d값 추출
			d[0] = matrix[spos][0];

			for (i = 0; i < mcnt; i++)
				for (j = 0; j < mcnt; j++)
					if (matrix[j][0] == d[i])
					{
						d[i + 1] = matrix[j][1];
						break;
					}

			// 동적 계획법에 사용할 배열 초기화
			for (i = 0; i <mcnt; i++)
				for (j = i + 1; j < mcnt; j++)
					M[i][j] = -1;

			for (i = 0; i < mcnt; i++)
				M[i][i] = 0;
			
			System.out.printf("#%d %d\n", n, solve(0, mcnt - 1) );
		}
		sc.close();

		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 ); 
	}
}


