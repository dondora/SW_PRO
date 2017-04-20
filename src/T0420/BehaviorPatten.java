package T0420;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BehaviorPatten {

	static int N;
	static char[] A,B;
	static int match[][];
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src\\day4\\day4_2.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = new char[N+1];
		B = new char[N+1];
		match = new int[N+1][N+1];
		A = sc.next().toCharArray();
		B = sc.next().toCharArray();
		
		
		
		sc.close();
	}

	public static float check()
	{
		return 0f;
	}
}
