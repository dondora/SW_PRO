
처음 화면	문제 모음	순위	채점 상황 열람
"미라콤아이앤씨 PRO등급 4차 모의고사" 5월15일(월) 18:00 ~ 5월16일(화) 06:00 , 정답 코드 공개, 5월16일(화) 09:00~24:00
문제 번호 A: [SOL] 방물장수
시간 제한: 1 Sec  메모리 제한: 128 MB
제출: 6  해결 문제 수: 4
[제출]
문제 설명
조선 시대에는 방물장수가 있었는데 여자들의 일상생활에 필요한 화장품, 바느질 기구, 패물 등의 간단한 물건들을 팔러 다니는 사람이다. 방물장수가 다니는 길에는 N + 1 개의 마을이 있고, 서쪽부터 마을 0, 마을 1, ..., 마을 N이다. 마을 i - 1과 마을 i (1 ≦ i ≦ N) 사이의 거리는 Di이다.
방물장수 홍길동은 마을 0에서 출발하여 도시를 차례로 경유하여 마을 N까지 가려고 한다. 마을 0에서 마을 N까지 M일 이내에 이동해야 한다. 홍길동은 각각의 날에 다음 두 가지 중 하나를 선택한다.
1.    이동 : 현재의 마을에서 동쪽의 마을로 1 일에 걸쳐 이동한다. 현재 마을 i - 1 (1 ≦ i ≦ N)에 있다면, 마을 i로 이동합니다.
2.    대기 : 이동하지 않고 현재 마을에서 1 일 대기한다.
그러나, 이동 할 때마다 피로도가 쌓여 간다. 그 날 날씨와 이동거리에 따라 피로도가 다르다. 이동거리가 길고 날씨가 나쁜 날은 피로도가 더 쌓인다. 홍길동은 M 일 중 j 일째 (1 ≦ j ≦ M)의 날씨가 Cj임을 알고 있다. 마을 i - 1에서 마을 i (1 ≦ i ≦ N)에 j 일째 (1 ≦ j ≦ M)로 이동하는 경우, 피로도가 Di × Cj 만큼 쌓인다. 이동하지 않고 기다리는 날은 피로도가 쌓이지 않는다.
홍길동은 각각의 날에 행동을 잘 선택하여 가능한 피로도를 적게 해서 이동하고 싶다. 홍길동이 M일 이내에 마을 N으로 이동할 때의 피로도 총 합의 최소를 구해라. 
* C 솔루션은 다음 코드를 참조하시오.
 
#include <stdio.h>
int N;//도시수
int M;//기간
int A[1010];
int B[1010];
int dp[1010];//i날에j도시에갈때최소피로도
void input_data(void){
      register int i;
      scanf("%d %d", &N, &M);
      for (i = 1; i <= N; i++) scanf("%d", &A[i]);
      for (i = 1; i <= M; i++) scanf("%d", &B[i]);
}
int Dynamic(void){
      register int i, j, end;
      for (i = 1; i <= N; i++) dp[i] = 1 << 30;
      for (i = 1; i <= M; i++){
            j = N;
            if (j > i) j = i;
            for (; j >= 1; j--){
                  if (dp[j] > dp[j - 1] + A[j] * B[i]){
                        dp[j] = dp[j - 1] + A[j] * B[i];
                  }
            }
      }
      return dp[N];
}
int main(void){
      input_data();
      int ans = Dynamic();
      printf("%d\n", ans);
      return 0;
}
* JAVA 솔루션은 다음 코드를 참조하시오.
 
import java.util.Scanner;
 
public class Main {
      static int N;//도시수
      static int M;//기간
      static int A[];
      static int B[];
      static int dp[];//i날에j도시에갈때최소피로도
      public static void main(String[] args) {
            input_data();
            int ans = Dynamic();
            System.out.println(ans);
      }
      static void input_data(){
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            M = sc.nextInt();
            A = new int [N+10];
            B = new int [M+10];
            for (int i = 1; i <= N; i++){
                  A[i] = sc.nextInt();
            }
            for (int i = 1; i <= M; i++){
                  B[i] = sc.nextInt();
            }
            sc.close();
      }
      static int Dynamic(){
            int i, j, end;
            dp = new int [N+10];
            for (i = 1; i <= N; i++) dp[i] = 1 << 30;
            for (i = 1; i <= M; i++){
                  j = N;
                  if (j > i) j = i;
                  for (; j >= 1; j--){
                        if (dp[j] > dp[j - 1] + A[j] * B[i]){
                             dp[j] = dp[j - 1] + A[j] * B[i];
                        }
                  }
            }
            return dp[N];
      }
}
입력
첫 번째 줄에는 두 개의 정수 N, M (1 ≦ N ≦ M ≦ 1000)이 공백으로 구분되어 입력된다.
두 번째 줄부터 N줄에 걸쳐 i 번째 마을까지 (1 ≦ i ≦ N) 거리인 정수 Di (1 ≦ Di ≦ 1000)가 입력된다. 마을 i - 1과 마을 i 사이의 거리가 Di임을 나타낸다.
다음 줄부터 M줄에 걸쳐 j(1 ≦ j ≦ M)일에 날씨를 의미하는 정수 Cj (1 ≦ Cj ≦ 1000)가 입력된다. j 일째 날씨 나쁨 정도가 Cj임을 나타낸다.
출력
홍길동이 마을 0에서 출발해서 마을 N까지 이동할 때의 피로도 총 합의 최소를 출력한다.
입력 예시
3 5
10
25
15
50
30
15
40
30
출력 예시
1125
도움말
1일째는 대기한다
2일째는 마을 1로 이동한다. 피로도는 10*30 = 300이다
3일째는 마을 2로 이동한다. 피로도는 25*15 = 375이다
4일째는 대기한다
5일째에 마을 3으로 이동한다. 피로도는 15*30 = 450이다
총 합은 300+375+450=1125이다
[제출]


장애 및 패스워드 초기화 요청
(주)윌텍 (010-3342-9323, keyseek@naver.com)