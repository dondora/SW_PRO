// 행동패턴유사성
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4_2 {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		long start = System.currentTimeMillis();

		Scanner sc = new Scanner(new File("day4_2.txt"));

		int[][] C = new int[501][501];
		char[] strA = new char[500];
		char[] strB = new char[500];

		int n;
		for(n = 1; n <= 5; n++)
		{
			int slen, i, j;

			slen = sc.nextInt();
			sc.nextLine();
			strA = sc.nextLine().toCharArray();
			strB = sc.nextLine().toCharArray();

			for(i = 0; i <= slen; i++)
				C[i][0] = C[0][i] = 0;

			for (i = 1; i <= slen; i++)
				for (j = 1; j <= slen; j++)
				{

					if (strA[i - 1] == strB[j - 1])
						C[i][j] = C[i - 1][j - 1] + 1;
					else
						C[i][j] = Math.max(C[i - 1][j], C[i][j - 1]);
				}  

			System.out.printf("#%d %.2f\n", n, (float)C[slen][slen] / slen * 100 );
		}
		sc.close();

		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 ); 
	}
}





