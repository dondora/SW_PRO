package T0417;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A02 {

	public static int N;
	public static int C;
	public static int visited[];
	public static char NUM[];
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src\\T0417\\day1\\day1_2.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int t=0;t<N;t++)
		{
			String s = sc.next();
			NUM = new char[s.length()];
			NUM = s.toCharArray();
			
			C = sc.nextInt();
			visited = new int[s.length()];
			
			String tmp = "";
			for(int i=0;i<C;i++)
				combine(tmp, s.length(), 2);
			
			System.out.println(NUM);
		}
		sc.close();

		System.out.println("END");
	}
	
	public static void swap(int a, int b)
	{		
		char c = NUM[b];
		NUM[b] = NUM[a];
		NUM[a] = c;		
	}
	public static int max = Integer.MIN_VALUE;
	public static void combine(String s, int n, int r)
	{

		if(s.length()>1 && r==0)
		{
			swap( Integer.parseInt(s.substring(0, 0)), Integer.parseInt(s.substring(1, 1)));			
			String out = NUM.toString();
			if(max >= Integer.parseInt(out))
				return;
			if(max < Integer.parseInt(out))
				max = Integer.parseInt(out);			
			return;
		}
		
		int tmp = s.length()>0 ? Integer.parseInt(s.substring(s.length()-1)) : 0;
		for(int i=tmp;i<n;i++)
		{
			if(visited[i]!=1)
			{
				visited[i]=1;
				combine(s+i, n, r-1);
				visited[i]=0;
			}
		}
	}

}
