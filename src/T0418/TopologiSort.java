package T0418;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TopologiSort {

	static int V, E;
	static int G[][];
	static int visited[];
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src\\day2\\day2_3.txt"));
		Scanner sc = new Scanner(System.in);
		
		V=sc.nextInt();
		visited = new int[V+1];
		E=sc.nextInt();
		G = new int[V+1][V+1];
		int s=0;
		for(int i=0;i<E;i++)
		{
			int start= sc.nextInt();
			int end = sc.nextInt();
			G[end][start] = 1; //스택에서 나오면서 처리하기 위해 반대로 저장.
			s= end;
		}
		
//		for(int i=1;i<=V;i++)
//			check(i, V);
		
		check(2, V);
		check(3, V);
		check(1, V);
		check(4, V);
		check(5, V);
		
		System.out.println("End");
		sc.close();
	}
	
	
	public static void check(int s, int r)
	{
		if(r==0)
		{
			visited[s] = 1;
			System.out.print(s+" ");
			return;
		}
		if(visited[s]==1)
			return;
		
		for(int i=1;i<=V;i++)
		{
			if(G[s][i] ==1 && visited[i] != 1 )
			{
				check(i, r-1);
			}
		}
		visited[s] = 1;
		System.out.print(s+" ");
	}
}
