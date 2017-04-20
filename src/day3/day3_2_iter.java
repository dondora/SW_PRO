//방배정
//주어진 명수의 사람을 4개의 방에 배정하려고 한다. 
//그리고 주어진 2차 행렬에 i번째 사람과 j번째 사람이 아는 사이일 경우 1을 모르는 사이일 경우 0의 값으로 표시하고 있다. 
//아는 사람끼리 같은 방에 배정되지 않도록 할 경우 총 경우의 수는 어떻게 되는가? 
//이 경우 중 가장 적은 방을 이용하여 배정한다면 최소 몇 개의 방이 필요한가?
//9
//0 0 0 0 0 0 1 1 1
//0 0 0 1 0 0 0 1 1
//0 0 0 0 0 0 0 0 1
//0 1 0 0 1 1 0 0 0
//0 0 0 1 0 0 0 0 0
//0 0 0 1 0 0 0 0 0
//1 0 0 0 0 0 0 0 0
//1 1 0 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//
//출력
// 2



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3_2_iter {

	public static int person_RNum[] = new int [10];   	// 각 사람한테 배정된 방 번호
	public static int relation[][] = new int [10][10];  // 사람 간의 관계
	public static int needed_room = 0x12345678; 		// 배정하기 위해 필요한 방의 개수
	public static int N, cnt;

	public static void process_solution()
	{
		int person_cnt_in_room[] = new int [5];   // 각 방에 몇 명이 배정됬나.
		int t = 0, i;
		
		for (int kth_person = 2; kth_person < 10; kth_person++)
			for ( i = 1; i < kth_person; i++) // kth_person번째 이전 사람 중에....
				if (relation[kth_person][i] > 0 && person_RNum[i] == person_RNum[kth_person]) // 아는 사이인데 지금 배정하려는 방에 배정되어 있는지...
					return;
		
		for (i = 1; i <= 9; i++) person_cnt_in_room[person_RNum[i]]++;   // 각 방에 몇 명이 있는지 카운트

		for (i = 1; i <= 4; i++) if (person_cnt_in_room[i] > 0) t++;  // 한 사람 이상 들어가 있는 방 카운트

		if (t < needed_room) needed_room = t;

	}

	public static void solve()
	{
		for (int x1 = 1; x1 <= 4; x1++)
		for (int x2 = 1; x2 <= 4; x2++)
		for (int x3 = 1; x3 <= 4; x3++)
		for (int x4 = 1; x4 <= 4; x4++)
		for (int x5 = 1; x5 <= 4; x5++)
		for (int x6 = 1; x6 <= 4; x6++)
		for (int x7 = 1; x7 <= 4; x7++)
		for (int x8 = 1; x8 <= 4; x8++)
		for (int x9 = 1; x9 <= 4; x9++)
		{
			person_RNum[1] = x1;
			person_RNum[2] = x2;
			person_RNum[3] = x3;
			person_RNum[4] = x4;
			person_RNum[5] = x5;
			person_RNum[6] = x6;
			person_RNum[7] = x7;
			person_RNum[8] = x8;
			person_RNum[9] = x9;
			process_solution();
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day3_2.txt"));

		N = sc.nextInt();

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				relation[i][j] = sc.nextInt();

		solve();
		System.out.printf("%d\n", needed_room);

		sc.close();
	}
}
