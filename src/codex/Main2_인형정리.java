package codex;

//"미라콤아이앤씨 PRO등급 2차 모의고사" 4월17일(월) 18:00 ~ 4월18일(화) 06:00 , 정답 코드 공개, 4월18일(화) 09:00~24:00
//문제 번호 A: [SOL] 인형 정리
//시간 제한: 1 Sec  메모리 제한: 128 MB
//제출: 6  해결 문제 수: 5
//[제출]
//문제 설명
//나정돈은 장난감 가게에서 일하고 있다. 오늘은 가게 안에 있는 인형 코너의 정리를 하게 되었다.
//인형 코너 선반에는 N개의 인형이 왼쪽에서 오른쪽으로 한 줄로 진열되어 있다. 선반은 N개의 칸으로 구분되어 있으며, 1개의 칸에는 1개의 인형을 놓는다. 이 장난감 가게는 총 M종류의 인형을 팔고 있으며, 각각 1부터 M까지 번호가 매겨져 있다. 선반에 진열된 N개의 인형은 M종류 중 하나이다. 또한 각 종류의 인형은 적어도 1개는 존재한다.
//나정돈은 보기 좋게 하기 위해 같은 종류의 인형이 모두 연속으로 놓이도록 정렬하고 싶어서 다음과 같은 방법으로 인형을 정렬하려고 한다.
//1.    N개의 인형 중 일부를 선택하고 선반에서 꺼낸다. 안 꺼낸 인형의 위치는 움직이지 않는다.
//2.    꺼낸 인형을 좋아하는 순서대로 선반의 빈 구획에 넣는다.
//정렬한 후, 같은 종류의 인형이 모두 연속해서 놓여 있어야 한다. 정렬하기 위해서 꺼낸 인형의 개수가 최소가 되도록 정렬할 때 최소값을 구하는 프로그램을 작성하라. 
//* C/C++ 솔루션은 다음 코드를 참조하시오.
////꺼내는개수구하기
//#include <stdio.h>
//int N;//인형개수
//int M;//종류
//int sum[20][100001];//각종류별위치별누적개수
//int total[20];//종류별총개수
//int dp[1 << 20];//최소비용
//int pos[1 << 20];//인형개수
//void input_data(void){
//      register int i, j;
//      int d;
//      scanf("%d %d", &N, &M);
//      for (i = 1; i <= N; i++){//위치
//            scanf("%d", &d);
//            total[d - 1]++;//종류별총개수파악
//            sum[d - 1][i] = 1;
//      }
//      for (i = 0; i < M; i++){//인형종류
//            for (j = 2; j <= N; j++){
//                  sum[i][j] += sum[i][j - 1];//누적합구하기
//            }
//      }
//}
//int Dynamic(void){
//      register int i, j, end = 1 << M, cost;
//      for (i = 0; i < M; i++){
//            pos[1 << i] = total[i];
//      }
//      for (i = 1; i < end; i++){
//            pos[i] = pos[i & (i - 1)] + pos[i & -i];
//                  dp[i] = 1 << 30;
//            for (j = 0; j < M; j++){
//                  if (i & (1 << j)){
//                        cost = dp[i ^ (1 << j)] + total[j] -
//                             (sum[j][pos[i]] - sum[j][pos[i ^ (1 << j)]]);
//                        if (dp[i] > cost) dp[i] = cost;
//                  }
//            }
//      }
//      return dp[end - 1];
//}
//int main(void){
//      input_data();
//      int ans = Dynamic();
//      printf("%d\n", ans);
//      return 0;
//}
////안꺼내도 되는 개수 구하기
//#include <stdio.h>
//int N;//인형개수
//int M;//종류
//int sum[20][100001];//각종류별위치별누적개수
//int total[20];//종류별총개수
//int dp[1 << 20];//최소비용
//int pos[1 << 20];//인형개수
//void input_data(void){
//      register int i, j;
//      int d;
//      scanf("%d %d", &N, &M);
//      for (i = 1; i <= N; i++){//위치
//            scanf("%d", &d);
//            total[d - 1]++;//종류별총개수파악
//            sum[d - 1][i] = 1;
//      }
//      for (i = 0; i < M; i++){//인형종류
//            for (j = 2; j <= N; j++){
//                  sum[i][j] += sum[i][j - 1];//누적합구하기
//            }
//      }
//}
//int Dynamic(void){
//      register int i, j, end = 1 << M, cost;
//      for (i = 0; i < M; i++){
//            pos[1 << i] = total[i];
//      }
//      for (i = 1; i < end; i++){
//            pos[i] = pos[i & (i - 1)] + pos[i & -i];
//            for (j = 0; j < M; j++){
//                  if (i & (1 << j)){
//                        cost = dp[i ^ (1 << j)] +
//                             sum[j][pos[i]] - sum[j][pos[i ^ (1 << j)]];
//                        if (dp[i] < cost) dp[i] = cost;
//                  }
//            }
//      }
//      return N - dp[end - 1];
//}
//int main(void){
//      input_data();
//      int ans = Dynamic();
//      printf("%d\n", ans);
//      return 0;
//}
//* JAVA 솔루션은 다음 코드를 참조하시오.
////안꺼내도 되는 개수 구하기
import java.util.Scanner;
 
public class Main {
      static Scanner sc;
      static int N;//인형개수
      static int M;//종류
      static int sum[][] = new int [20][100001];//각종류별위치별누적개수
      static int total[] = new int [20];//종류별총개수
      static int dp[] = new int [1 << 20];//최소비용
      static int pos[] = new int [1 << 20];//인형개수
      static void input_data(){
            int i, j;
            int d;
            N = sc.nextInt(); M = sc.nextInt();
            for (i = 1; i <= N; i++){//위치
                  d = sc.nextInt() - 1;
                  total[d]++;//종류별총개수파악
                  sum[d][i] = 1;
            }
            for (i = 0; i < M; i++){//인형종류
                  for (j = 2; j <= N; j++){
                        sum[i][j] += sum[i][j - 1];//누적합구하기
                  }
            }
      }
      static int Dynamic(){
            int i, j, end = 1 << M, cost;
            for (i = 0; i < M; i++){
                  pos[1 << i] = total[i];
            }
            for (i = 1; i < end; i++){
                  pos[i] = pos[i & (i - 1)] + pos[i & -i];
                  for (j = 0; j < M; j++){
                        if ((i & (1 << j)) != 0){
                             cost = dp[i ^ (1 << j)] +
                                   sum[j][pos[i]] - sum[j][pos[i ^ (1 << j)]];
                             if (dp[i] < cost) dp[i] = cost;
                        }
                  }
            }
            return N - dp[end - 1];
      }
      public static void main(String[] args) {
            sc = new Scanner(System.in);
            input_data();
            int ans = Dynamic();
            System.out.println(ans);
            sc.close();
      }
}
//입력
//첫 번째 줄에는 2개의 정수 N, M이 공백으로 구분되어 입력된다. N은 인형의 개수이고, M은 종류 개수 이다. (1≤N≤100,000) (1≤M≤20)
//두 번째 줄부터 N줄에 걸쳐서 1이상 M이하의 정수가 한 개씩 입력된다. N행 중 i행 째(1≤i≤N)에 적힌 정수는 선반 왼쪽에서 i번째 칸에 놓인 인형의 종류를 나타낸다. 각 종류마다 적어도 1개의 인형은 존재하고 있음을 보장한다.
//출력
//정렬하기 위해서 꺼낸 인형의 최소 개수를 출력한다.
//입력 예시
//7 2
//1
//2
//2
//2
//1
//2
//1
//출력 예시
//2
//도움말
//입력예시에서는 처음에 놓인 인형의 종류는 왼쪽부터 순서대로 1, 2, 2, 2, 1, 2, 1이다. 정렬하기 위해서 꺼낸 인형의 개수를 최소화하려면, 왼쪽에서 1번째와 6번째 인형을 꺼내서 왼쪽부터 1번째 칸에 종류 2인형을 넣고, 왼쪽에서 6번째 칸에 종류 1 인형을 넣으면 된다. 이 때, 꺼낸 인형의 개수는 2개이다.
