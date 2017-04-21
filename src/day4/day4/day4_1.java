
// 색종이 이어 붙이기
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4_1 {
	public static long memo[] = new long [101]; 
	
	
	public static long  f(int n) 
	{
		if(n > 2 && memo[n] == 0)
			memo[n] = 2*f(n-1) + f(n-2);
		
		return memo[n];
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		long start = System.currentTimeMillis();

		Scanner sc = new Scanner(new File("day4_1.txt"));

		memo[1] = 2;
		memo[2] = 5;
		
		int n;
		
		for(int tc = 1; tc <= 2; tc++)
		{
			n = sc.nextInt();
			
			System.out.printf("%d\n", f(n) );
		}
		sc.close();

		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 ); 
	}
}

