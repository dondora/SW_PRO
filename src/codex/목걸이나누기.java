package codex;

처음 화면	문제 모음	순위	채점 상황 열람
"미라콤아이앤씨 PRO등급 4차 모의고사" 5월15일(월) 18:00 ~ 5월16일(화) 06:00 , 정답 코드 공개, 5월16일(화) 09:00~24:00
문제 번호 B: [SOL] 목걸이 나누기
시간 제한: 1 Sec  메모리 제한: 128 MB
제출: 7  해결 문제 수: 3
[제출]
문제 설명
정올 나라의 황후가 승하하셔서 온 나라가 슬픔에 잠겼다. 황후께서는 여러개의 M개의 다이아몬드로 엮어서 만든 목걸이를 소중하게 간직하고 계시다가 이 목걸이를 N명의 공주들에게 공평하게 나누어 주도록 아래와 같이 유언을 남기셨다.
 
1. 다이아몬드를 낱개로 나누지 말고 연속된 것끼리 묶어서 나누어 주어야 한다.
2. 다이아몬드는 각각의 가치가 서로 다르기 때문에 똑같은 가치로 나누어 줄 수는 없지만 공주끼리 싸움이 나지 않도록 나누어 준 다이아몬드의 가치가 최대인 것과 최소인 것의 차가 최소가 되도록 한다.
 
예를 들어 아래와 같이 가치가 다른 네 개의 다이아몬드로 만든 목걸이를 두명의 공주에게 나누어 주려고 할 때
첫째 공주에게 15와 7을 둘째 공주에게 4와 10을 나누어 주면 각각의 가치가 22와 14이므로 차가 8이 되지만
첫째 공주에게 15를 두 번째 공주에게 나머지 7과 4와 10을 주면 각각 15와 21로 차가 6이 되므로 더 좋은 방법이다.
10과 7 또는 15와 4는 연속하여 연결되지 않았기 때문에 선택할 수 없다.
 
 
 
공주와 목걸이에 대한 자료를 입력받아 공주에게 나누어주는 가치의 최대와 최소의 차가 최소가 되도록 나누었을 때 그 차를 출력하는 프로그램을 작성하시오. 
* C 솔루션은 다음 코드를 참조하시오.
 
#include <stdio.h>
int N;//공주의수
int M;//다이아몬드의수
int P[60];
int sum[60];
struct st{
    int max, min;
};
struct st D[60][60];//i개의다이아몬드를j명의공주가나눠가질때최대최소차가최소인값
#define INF (0x3FFFFFFF)
int Dynamic(void)
{
    register int i, j, k, end;
    struct st temp;
    for(i=2 ; i<=M ; i++){
        end = (i<N) ? i : N;
        for(j=2 ; j<=end ; j++){
            D[i][j].max = INF; D[i][j].min=0;
            for(k=i-1 ; k>=j-1 ; k--){
                temp = D[k][j-1];
                if(temp.max<sum[i]-sum[k]) temp.max = sum[i]-sum[k];
                else if(temp.min>sum[i]-sum[k]) temp.min = sum[i]-sum[k];
                if((D[i][j].max-D[i][j].min) > (temp.max-temp.min)) D[i][j] = temp;
            }
        }
    }
    return D[M][N].max-D[M][N].min;
}
int solve(void)
{
    register int i, k, min=INF, d;
    for(k=0 ; k<M ; k++){
        for(i=1 ; i<=M ; i++){
            d = P[(k+i-1)%M];
            sum[i] = sum[i-1] + d;
            D[i][1].max=D[i][1].min = sum[i];
        }
        d = Dynamic();
        if(min > d) min = d;
    }
    return min;
}
int main(void)
{
    register int i, ans;
    scanf("%d %d", &N, &M);
    for(i=0 ; i<M ; i++) scanf("%d", &P[i]);
  
    ans = solve();
    printf("%d\n", ans);
    return 0;
}
* JAVA 솔루션은 다음 코드를 참조하시오.
 
import java.util.Scanner;
 
 
public class Main {
      static int N;//공주의수
      static int M;//다이아몬드의수
      static int [] P;//다이아몬드의가치
      static int [] sum;//다이아몬드의가치누적합
      static class st{
            int max, min;
            st(){}
            st(int a, int b) {
                  max=a; min=b;
            }
      }
      static st [][] D;//i개의다이아몬드를j명의공주가나눠가질때최대최소차가최소인값
      static int INF = 0x3FFFFFFF;
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            M = sc.nextInt();
            P = new int [M+1];
            sum = new int [M+1];
            D = new st [M+1][N+1];
            for(int i=0 ; i<M ; i++) P[i]=sc.nextInt();
            int ans = solve();
            System.out.println(ans);
            sc.close();
      }
      static int solve(){
            int i, k, min=INF, d;
            for(k=0 ; k<M ; k++){
              for(i=1 ; i<=M ; i++){
                  d = P[(k+i-1)%M];
                  sum[i] = sum[i-1] + d;
                  D[i][1] = new st(sum[i], sum[i]);
              }
              d = Dynamic();
              if(min > d) min = d;
          }
          return min;
      }
      static int Dynamic()
      {
          int i, j, k, end;
          st temp;
          for(i=2 ; i<=M ; i++){
              end = (i<N) ? i : N;
              for(j=2 ; j<=end ; j++){
                  D[i][j] = new st(INF, 0);
                  for(k=i-1 ; k>=j-1 ; k--){
                      temp = new st(D[k][j-1].max, D[k][j-1].min);
                      if(temp.max<sum[i]-sum[k]) temp.max = sum[i]-sum[k];
                      else if(temp.min>sum[i]-sum[k]) temp.min = sum[i]-sum[k];
                      if((D[i][j].max-D[i][j].min) > (temp.max-temp.min)) D[i][j] = temp;
                  }
              }
          }
          return D[M][N].max-D[M][N].min;
      }
}
입력
첫 번째 줄에 공주의 수 N과 다이아몬드의 개수 M을 입력받는다. (2 <= N <= M <= 50)
두 번째 줄에는 M개의 다이아몬드에 대한 가치가 시계방향으로 100만 이하의 정수로 차례대로 입력된다.
출력
최대값과 최소값의 차가 최소가 되도록 N명의 공주에게 나누어 주었을 때 최대값과 최소값의 차이를 출력하시오.
입력 예시
2 4
10 15 7 4
출력 예시
6
도움말
[제출]


장애 및 패스워드 초기화 요청
(주)윌텍 (010-3342-9323, keyseek@naver.com)