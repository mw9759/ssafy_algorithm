package algorithm.daily.ws0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class D3_5215_햄버거다이어트_손민우 {
 
    static int n,l; // 재료의 개수와 , 최대 허용 칼로리
    static int taste[]; // 재료의 맛점수 담을 배열
    static int cal[]; // 재료의 칼로리를 담을 배열
    static int dp[][]; // n개의 재료를 썼을때 무게별 최대 맛점수
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            taste = new int[n+1];
            cal = new int[n+1];
            dp = new int[n+1][l+1];
             
            // n개의 재료의 맛점수와 칼로리 받기.
            for(int i = 1; i<=n; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
             
            //dp초기화: [n][l]: 1~n개가 담겼을때의 칼로리별 최대 맛점수 넣기.
            for(int i = 1; i<=n; i++) {//1번부터 1개 n번까지 n개 넣기 반복문.
                 
                for(int j = 1; j<=l; j++) {//: 1부터 l까지의 칼로리에 대해 모두 확인.
                    if(j-cal[i]>=0) {//만약 현재 j칼로리-재료의 칼로리>=0일때 : 재료 선택이 가능할 떼
                        //1.dp[i-1][j] : 현재 재료를 선택안할때(+못할때)의 값: 같은칼로리일때 이전 재료까지의 맛점수
                        //2.dp[i-1][j-cal[i]]+taste[i]
                        //ㄴ>현재 재료를 선택할때: 현재재료가 들어가고 남는 칼로리일때의 만족도 + 현재재료의 맛점수
                        // 둘중의 더 큰값을 넣는다.: i번째 재료까지 쓰면서 j만큼의 칼로리 제한도 만족하는 최대 맛점수.
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cal[i]]+taste[i]);
                    }
                    else dp[i][j] = dp[i-1][j]; // 해당 제한일때는 못들어가니 이전 값을 가져온다.
                }
            }
            //출력
            System.out.println("#"+tc+" "+dp[n][l]);
        }
    }
    
}