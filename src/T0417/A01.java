package T0417;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//프로젝트 배분
public class A01 {
	
	public static int N;
	public static int[][] ary;
	public static int visited[];
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("src\\T0417\\day1\\day1_1.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ary = new int[N][N];
		visited = new int[N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				ary[i][j] = sc.nextInt();
			}
		}
			
		check(0, 0);
		System.out.println(min);
		System.out.println("End");
	}
	
	public static int min = Integer.MAX_VALUE;
	public static void check(int i, int sum)
	{
		if(min <=sum)
			return;
		
		if(i==N)
		{
			if(min > sum)
				min = sum;
			return;
		}
		
		for(int n=0;n<N;n++)
		{
			if(1!=visited[n])
			{
				visited[n] = 1;
				check(i+1, sum+ary[i][n]);
				visited[n] = 0;
			}
		}
	}

}
