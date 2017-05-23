
처음 화면	문제 모음	순위	채점 상황 열람
"미라콤아이앤씨 PRO등급 5차 모의고사" 5월22일(월) 18:00 ~ 5월23일(화) 06:00 , 정답 코드 공개, 5월23일(화) 09:00~24:00
문제 번호 A: [SOL] 로봇부품 세일
시간 제한: 1 Sec  메모리 제한: 128 MB
제출: 12  해결 문제 수: 3
[제출]
문제 설명
OO이는 알파고의 등장 이후 부쩍 로봇에 관심이 많아졌다. 오늘도 로봇 매장에 들어와 본 OO이는 오늘 새로 진열된 3단 합체 로봇이 눈에 들어왔다. 이 로봇만 있으면 그동안 닦은 프로그램 실력을 발휘하여 다양한 형태의 변신 로봇으로 흥미있는 많은 작업을 할 수 있을 것 같았다.
흥분된 마음으로 가격표를 보고는 현재의 주머니 사정으로 이 로봇을 구매할 수 없다는 사실을 알게 되었다.
 
그런데 마침 이 매장에서는 로봇을 사용하다가 문제가 생길 경우에 대비해서 각종 부품을 별도로 판매하는 코너가 있었다. 더군다나 여러개의 부품을 한 번에 살 경우 몇 개의 부품을 덤으로 주는 다양한 이벤트도 진행을 하고 있었다.
이벤트의 내용은 서로 다른 여러 개의 부품을 한 번에 살 경우 가격이 낮은 일부 부품에 대한 금액을 면제해 주는 것이다.
예를 들어 3개의 부품을 살 경우 한 개 값을 면제해 주는 이벤트가 있을 때 부품의 가격이 각각 300원, 200원, 100원인 세 개의 부품을 사게 되면 가장 가격이 낮은 100원짜리는 덤으로 하여 면제하고 나머지 두 개의 값 500원만 지불하면 되는 것이다.
 
OO이는 그동안 많은 로봇을 조립해 보았기 때문에 3단 합체 로봇에 들어가는 부품만 모두 구할 수 있다면 직접 로봇을 조립할 수 있을거 같은 생각에 부품의 가격들을 조심스럽게 살펴보았다.
 
그 결과 3단 합체 로봇에 들어가는 모든 부품을 낱개로 한 개씩 구매를 하면 현재 판매되는 로봇의 가격보다 비싸지만 진행되고 있는 이벤트를 잘 활용하면 현재 가진 돈만으로도 필요한 부품을 모두 구매할 수 있을지도 모른다는 생각을 하게 되었다.
하지만 부품의 종류가 너무 많을 뿐 아니라 이벤트의 종류도 다양하다보니 어떤 부품을 어떤 이벤트로 사는 것이 유리한지 판단하기가 너무 어려웠다.
주머니 사정이 넉넉지 않은 OO이가 필요한 모든 부품을 가장 적은 가격으로 살수 있도록 프로그램을 작성해 주자.
* C 솔루션은 다음 코드를 참조하시오.
 
#include <stdio.h>
int N;//부품종류
int M;//이벤트종류
int A[50010];//부품가격
int tmp[50010];
int sum[50010];//부품가격누적합
int ET[11];//이벤트개수
int EF[11];//할인개수
int dp[50010];
void mergesort(int s, int e){
      register int i, j, k, m;
      if(s>=e) return;
      m=(s+e)/2; i=k=s; j=m+1;
      mergesort(s, m); mergesort(j, e);
      while((i<=m) || (j<=e)){
            if((i>m) || ((j<=e) && (A[i]<A[j]))) tmp[k++]=A[j++];
            else tmp[k++] = A[i++];
      }
      for(i=s;i<=e;i++) A[i]=tmp[i];
}
int Dynamic(void){
      register int i, j, temp;
      mergesort(1, N);
      for(i=1;i<=N;i++){
            sum[i] = sum[i-1]+A[i];
      }
      for(i=1;i<=N;i++){//부품인덱스
            dp[i] = dp[i-1]+A[i];//그냥사는경우
            for(j=1;j<=M;j++){//이벤트인덱스
                  if(ET[j] <= i){//이벤트가능
                        temp = dp[i-ET[j]] + sum[i-EF[j]] - sum[i-ET[j]];
                        if(dp[i] > temp) dp[i] = temp;
                  }
            }
      }
      return dp[N];
}
int main(void){
      register int i, ans;
      scanf("%d %d", &N, &M);
      for(i=1;i<=N;i++){
            scanf("%d", &A[i]);
      }
      for(i=1;i<=M;i++){
            scanf("%d %d", &ET[i], &EF[i]);
      }
      ans = Dynamic();
      printf("%d\n", ans);
      return 0;
}
* JAVA 솔루션은 다음 코드를 참조하시오.
 
import java.util.Scanner;
 
 
public class Main {
      static int N;//부품종류
      static int M;//이벤트종류
      static int A[];//부품가격
      static int tmp[];
      static int sum[];//부품가격누적합
      static int ET[];//이벤트개수
      static int EF[];//할인개수
      static int dp[];
      public static void main(String[] args) {
            input_data();
            int ans = Dynamic();
            System.out.println(ans);
      }
      static void input_data(){
            Scanner sc = new Scanner(System.in);
            int i;
            N = sc.nextInt();
            M = sc.nextInt();
            A = new int [N+1];
            tmp = new int [N+1];
            ET = new int [M+1];
            EF = new int [M+1];
            for(i=1;i<=N;i++){
                  A[i] = sc.nextInt();
            }
            for(i=1;i<=M;i++){
                  ET[i] = sc.nextInt();
                  EF[i] = sc.nextInt();
            }
            sc.close();
      }
      static void mergesort(int s, int e){
            int i, j, k, m;
            if(s>=e) return;
            m=(s+e)/2; i=k=s; j=m+1;
            mergesort(s, m); mergesort(j, e);
            while((i<=m) || (j<=e)){
                  if((i>m) || ((j<=e) && (A[i]<A[j]))) tmp[k++]=A[j++];
                  else tmp[k++] = A[i++];
            }
            for(i=s;i<=e;i++) A[i]=tmp[i];
      }
      static int Dynamic(){
            int i, j, temp;
            mergesort(1, N);
            sum = new int [N+1];
            dp = new int [N+1];
            for(i=1;i<=N;i++){
                  sum[i] = sum[i-1]+A[i];
            }
            for(i=1;i<=N;i++){//부품인덱스
                  dp[i] = dp[i-1]+A[i];//그냥사는경우
                  for(j=1;j<=M;j++){//이벤트인덱스
                        if(ET[j] <= i){//이벤트가능
                             temp = dp[i-ET[j]] + sum[i-EF[j]] - sum[i-ET[j]];
                             if(dp[i] > temp) dp[i] = temp;
                        }
                  }
            }
            return dp[N];
      }
}
입력
첫 행에는 OO이가 구입해야 하는 부품의 종류 N과 이벤트의 종류 M이 공백으로 구분하여 주어진다. (1 <= N <= 50000, 1 <= M <= 10)
다음 행에는 N개의 종류별 부품에 대한 가격이 공백으로 구분하여 하나씩 주어진다. 각 가격은 10000 이하의 정수이다.
다음 행부터 M개의 행에는 각각 두 개의 정수 Ti 와 Pi가 주어지는데 Ti개 종류의 부품을 사면 가격이 낮은 Pi개 부품에 대한 가격을 할인해 주는 것이다. (2 <= Ti <= N, 1 <= Pi < Ti)
 
부분문제의 제약 조건
• 부분문제 1: 전체 점수 100점 중 20점에 해당하며 M=1 이다.
• 부분문제 2: 전체 점수 100점 중 30점에 해당하며 N≤20 이다.
• 부분문제 3: 전체 점수 100점 중 50점에 해당하며 주어진 조건외에 특별한 제약이 없다.
출력
모든 종류의 부품을 한 개씩만 구입하기 위해 필요한 최소 금액을 출력한다.
입력 예시
9 2
500 400 700 300 600 900 350 200 750
5 3
4 1
출력 예시
2700

도움말
[제출]


장애 및 패스워드 초기화 요청
(주)윌텍 (010-3342-9323, keyseek@naver.com)