import java.io.*;
import java.util.*;

class Main_14501
{
  static int N;
  static int[] T, P;

  public static void main(String[] args) throws IOException
  {
    init();
    process();
  }

  // 입력
  static void init() throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    T = new int[N + 1];
    P = new int[N + 1];

    for(int i = 1; i <= N; i++)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());

      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }
  }

  // 문제 풀이
  static void process()
  {
    int[] dp = new int[N + 1];

    for(int i = 1; i < N; i++)
    {
      if(i + T[i] <= N)
        dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);

      dp[i + 1] = Math.max(dp[i + 1], dp[i]);
    }

    System.out.println(dp[N]);
  }
}