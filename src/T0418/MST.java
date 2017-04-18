package T0418;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MST {
	static int N;
	static int A[][];
	static int D[];
	static int visited[];

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src\\day2\\day2_1.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		D = new int[N + 1];
		visited = new int[N + 1];
		A = new int[N + 1][N + 1];
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				A[y][x] = sc.nextInt();
			}
		}
		for (int i = 1; i <= N; i++)
			D[i] = Integer.MAX_VALUE;
		
		D[1] = 0;
		check(1, N);
		int sum = 0;
		for (int i = 1; i <= N; i++) sum += D[i];
		
		sc.close();
		
		System.out.println(sum);
		System.out.println("End");
	}

	public static void check(int s, int r) {

		if(r==0)
			return;
		int start = s;
		if(visited[start]!=1) visited[start]=1;		
	
		int min = Integer.MAX_VALUE;
		int target = -1;
		for (int i = 1; i <= N; i++) {
			if (visited[i] != 1 && A[start][i] > 0) {
				D[i] = A[start][i];
				if (min > D[i]) {
					min = D[i];
					target = i;
				}
			}
		}
		check(target, r-1);
	}
}
