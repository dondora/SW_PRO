
처음 화면	문제 모음	순위	채점 상황 열람
"미라콤아이앤씨 PRO등급 5차 모의고사" 5월22일(월) 18:00 ~ 5월23일(화) 06:00 , 정답 코드 공개, 5월23일(화) 09:00~24:00
문제 번호 B: [SOL] 보물지도
시간 제한: 1 Sec  메모리 제한: 128 MB
제출: 5  해결 문제 수: 3
[제출]
문제 설명
당신은 보물 지도를 얻었다. 보물 지도는 N*M 크기이고 1*1크기의 정사각형으로 나누어져 있다. 보물 지도의 각 칸은 바다이거나 섬의 일부이다. 그리고, 지도에는 보물과 바이킹의 위치도 있다. 마지막으로 당신의 위치를 지도에 표시했다.
이제 당신은 보물을 가지기 위한 경로를 정해야 한다. 경로는 현재 당신 위치에서 시작되어야 하고, 보물의 위치에서 끝나야 한다. 매번 당신이 이동할 때는 상하좌우 중 한 방향으로 이동해야 하고, 섬으로 들어가면 안 된다. 하지만, 바이킹도 당신과 같은 방식으로 이동할 것이므로, 바이킹을 조심해야 한다. 매번 당신이 이동한 후에, 바이킹은 당신의 이동에 대해서 이동할 지 멈춰있을지 결정할 수 있다. 당신의 움직임과 바이킹의 반응을 턴이라 부르면, 매 턴이 지난 후에 다음과 같이 2가지 방법으로 확인할 수 있다.
1.    만약, 당신이 바이킹을 바라보고 있다면(바이킹과 수직선, 수평선상에 당신이 있고, 오직 그 사이에 바다만 있을 때) 당신은 죽는다.
2.    만약, 당신이 아직 죽지 않았고, 보물 위치에 있다며 당신은 보물을 얻은 것이다.
 
바이킹이 어떻게 움직이건 관계없이 당신이 죽지 않고 보물을 얻을 수 있는 경로를 정하는 프로그램을 작성하시오.
* C 솔루션은 다음 코드를 참조하시오.
 
#include <stdio.h>
int N;//세로크기
int M;//가로크기
char map[710][710];//보물지도
int visit[710][710];
int limith[710][710];
int limitc[710][710];
struct st{
      int r, c;
};
struct st queue[710 * 710];
int wp, rp;
int tr, tc;//보물위치
int rr[] = { -1, 1, 0, 0 };
int cc[] = { 0, 0, -1, 1 };
int MIN(int a, int b){
      return (a < b) ? a : b;
}
void enqueue(int r, int c){
      queue[wp].r = r; queue[wp++].c = c;
}
void input_data(void){
      scanf("%d %d", &N, &M);
      for (int i = 1; i <= N; i++){
            scanf("%s", &map[i][1]);
      }
}
void BFS_Viking(int vr, int vc){
      for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                  visit[i][j] = 1 << 30;
            }
      }
      wp = rp = 0;
      enqueue(vr, vc);
      visit[vr][vc] = 0;
      while (rp < wp){
            struct st d = queue[rp++];
            for (int i = 0; i < 4; i++){
                  vr = d.r + rr[i]; vc = d.c + cc[i];
                  if (map[vr][vc] != '.') continue;
                  if (visit[vr][vc] <= visit[d.r][d.c] + 1) continue;
                  enqueue(vr, vc);
                  visit[vr][vc] = visit[d.r][d.c] + 1;
            }
      }
}
void update_limit(void){
      for (int i = 1; i <= N; i++){
            limith[i][1] = visit[i][1];
            for (int j = 2; j <= M; j++){
                  if (map[i][j] == 'I') limith[i][j] = 1 << 30;
                  else limith[i][j] = MIN(visit[i][j], limith[i][j - 1]);
            }
            for (int j = M - 1; j > 0; j--){
                  if (map[i][j] != 'I') limith[i][j] = MIN(limith[i][j], limith[i][j + 1]);
            }
      }
      for (int j = 1; j <= M; j++){
            limitc[1][j] = visit[1][j];
            for (int i = 2; i <= N; i++){
                  if (map[i][j] == 'I') limitc[i][j] = 1 << 30;
                  else limitc[i][j] = MIN(visit[i][j], limitc[i - 1][j]);
            }
            for (int i = N - 1; i > 0; i--){
                  if (map[i][j] != 'I') limitc[i][j] = MIN(limitc[i][j], limitc[i + 1][j]);
            }
      }
      for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                  if (limith[i][j] > limitc[i][j]) limith[i][j] = limitc[i][j];
            }
      }
}
int BFS(int sr, int sc){
      for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                  visit[i][j] = 1 << 30;
            }
      }
      wp = rp = 0;
      enqueue(sr, sc);
      visit[sr][sc] = 0;
      while (rp < wp){
            struct st d = queue[rp++];
            for (int i = 0; i < 4; i++){
                  sr = d.r + rr[i]; sc = d.c + cc[i];
                  if (map[sr][sc] != '.') continue;
                  if (limith[sr][sc] <= visit[d.r][d.c] + 1) continue;
                  if (visit[sr][sc] <= visit[d.r][d.c] + 1) continue;
                  if ((sr == tr) && (sc == tc)) return 1;//성공
                  enqueue(sr, sc);
                  visit[sr][sc] = visit[d.r][d.c] + 1;
            }
      }
      return -1;//실패
}
int solve(void){
      int vr = 0, vc = 0, sr = 0, sc = 0;
      for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                  if (map[i][j] == 'Y'){//내위치
                        sr = i; sc = j;
                        map[i][j] = '.';
                  }
                  else if (map[i][j] == 'V'){//바이킹위치
                        vr = i; vc = j;
                        map[i][j] = '.';
                  }
                  else if (map[i][j] == 'T'){//보물위치
                        tr = i; tc = j;
                        map[i][j] = '.';
                  }
            }
      }
      BFS_Viking(vr, vc);
      update_limit();
      return BFS(sr, sc);
}
int main(void){
      input_data();
      int ans = solve();
      if (ans == 1) printf("YES\n");
      else printf("NO\n");
      return 0;
}
입력
첫 번째 줄에는 N과 M이 공백으로 구분되어 입력된다.
두 번째 줄부터 N개의 줄에 보물 지도가 입력된다. 각 줄은 M개의 문자로 구성되어 있는데, ‘.’은 바다이고 ‘I’는 섬이고, ‘V’는 바이킹의 위치이고, ‘Y’는 현재 당신의 위치이고, ‘T’는 보물의 위치이다. ‘V’, ‘Y’, ‘T’는 모두 한 번씩만 등장한다. (1≤N,M≤700)
출력
당신이 보물을 얻을 수 있으면 “YES”를 출력하고, 그렇지 않으면 “NO”를 출력한다.

입력 예시
5 7
Y.....V
..I....
..IIIII
.......
...T...
출력 예시
YES
도움말
* JAVA 솔루션은 다음 코드를 참조하시오.
 
import java.util.Scanner;
 
 
public class Main {
      static int N;//세로크기
      static int M;//가로크기
      static char map[][];//보물지도
      static int visit[][];
      static int limith[][];
      static int limitc[][];
      static class Q{
            int r, c;
            Q(int r, int c){
                  this.r=r; this.c=c;
            }
      };
      static Q queue[];
      static int wp, rp;
      static int tr, tc;//보물위치
      static int rr[] = { -1, 1, 0, 0 };
      static int cc[] = { 0, 0, -1, 1 };
      public static void main(String[] args) {
            input_data();
            int ans = solve();
            if (ans == 1) System.out.println("YES");
            else System.out.println("NO\n");
      }
      static int solve(){
            int vr = 0, vc = 0, sr = 0, sc = 0;
            visit = new int [N+2][M+2];
            limith = new int [N+2][M+2];
            limitc = new int [N+2][M+2];
            queue = new Q [N*M];
            for (int i = 1; i <= N; i++){
                  for (int j = 1; j <= M; j++){
                        if (map[i][j] == 'Y'){//내위치
                             sr = i; sc = j;
                             map[i][j] = '.';
                        }
                        else if (map[i][j] == 'V'){//바이킹위치
                             vr = i; vc = j;
                             map[i][j] = '.';
                        }
                        else if (map[i][j] == 'T'){//보물위치
                             tr = i; tc = j;
                             map[i][j] = '.';
                        }
                  }
            }
            BFS_Viking(vr, vc);
            update_limit();
            return BFS(sr, sc);
      }
      static int MIN(int a, int b){
            return (a < b) ? a : b;
      }
      static void input_data(){
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt(); M = sc.nextInt();
            map = new char [N+2][M+2];
            for (int i = 1; i <= N; i++) map[i] = ("\0" + sc.next() + "\0").toCharArray();
            sc.close();
      }
      static void BFS_Viking(int vr, int vc){
            for (int i = 1; i <= N; i++){
                  for (int j = 1; j <= M; j++){
                        visit[i][j] = 1 << 30;
                  }
            }
            wp = rp = 0;
            queue[wp++] = new Q(vr, vc);
            visit[vr][vc] = 0;
            while (rp < wp){
                  Q d = queue[rp++];
                  for (int i = 0; i < 4; i++){
                        vr = d.r + rr[i]; vc = d.c + cc[i];
                        if (map[vr][vc] != '.') continue;
                        if (visit[vr][vc] <= visit[d.r][d.c] + 1) continue;
                        queue[wp++] = new Q(vr, vc);
                        visit[vr][vc] = visit[d.r][d.c] + 1;
                  }
            }
      }
      static void update_limit(){
            for (int i = 1; i <= N; i++){
                  limith[i][1] = visit[i][1];
                  for (int j = 2; j <= M; j++){
                        if (map[i][j] == 'I') limith[i][j] = 1 << 30;
                        else limith[i][j] = MIN(visit[i][j], limith[i][j - 1]);
                  }
                  for (int j = M - 1; j > 0; j--){
                        if (map[i][j] != 'I') limith[i][j] = MIN(limith[i][j], limith[i][j + 1]);
                  }
            }
            for (int j = 1; j <= M; j++){
                  limitc[1][j] = visit[1][j];
                  for (int i = 2; i <= N; i++){
                        if (map[i][j] == 'I') limitc[i][j] = 1 << 30;
                        else limitc[i][j] = MIN(visit[i][j], limitc[i - 1][j]);
                  }
                  for (int i = N - 1; i > 0; i--){
                        if (map[i][j] != 'I') limitc[i][j] = MIN(limitc[i][j], limitc[i + 1][j]);
                  }
            }
            for (int i = 1; i <= N; i++){
                  for (int j = 1; j <= M; j++){
                        if (limith[i][j] > limitc[i][j]) limith[i][j] = limitc[i][j];
                  }
            }
      }
      static int BFS(int sr, int sc){
            for (int i = 1; i <= N; i++){
                  for (int j = 1; j <= M; j++){
                        visit[i][j] = 1 << 30;
                  }
            }
            wp = rp = 0;
            queue[wp++] = new Q(sr, sc);
            visit[sr][sc] = 0;
            while (rp < wp){
                  Q d = queue[rp++];
                  for (int i = 0; i < 4; i++){
                        sr = d.r + rr[i]; sc = d.c + cc[i];
                        if (map[sr][sc] != '.') continue;
                        if (limith[sr][sc] <= visit[d.r][d.c] + 1) continue;
                        if (visit[sr][sc] <= visit[d.r][d.c] + 1) continue;
                        if ((sr == tr) && (sc == tc)) return 1;//성공
                        queue[wp++] = new Q(sr, sc);
                        visit[sr][sc] = visit[d.r][d.c] + 1;
                  }
            }
            return -1;//실패
      }
}
[제출]


장애 및 패스워드 초기화 요청
(주)윌텍 (010-3342-9323, keyseek@naver.com)