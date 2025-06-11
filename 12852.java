import java.io.*;
import java.util.*;

class Main
{
  static StringBuilder sb = new StringBuilder();

  public static void main2(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    process(Integer.parseInt(br.readLine()));

    System.out.println(sb);
  }

  // 문제 풀이
  static void process(int N)
  {
    ArrayList<Integer>[] dp = new ArrayList[N + 1];

    for(int i = 1; i <= N; i++) {
      dp[i] = new ArrayList<>();
    }

    dp[1].add(1);

    for(int i = 2; i <= N; i++)
    {
      int target = i - 1;

      if(i % 3 == 0 && dp[i / 3].size() <= dp[target].size())
      {
        target = i / 3;
      }

      if(i % 2 == 0 && dp[i / 2].size() <= dp[target].size())
      {
        target = i / 2;
      }

      for(int n : dp[target]) {
        dp[i].add(n);
      }

      dp[i].add(i);
    }

    sb.append(dp[N].size() - 1).append('\n');

    for(int i = dp[N].size() - 1; i >= 0; i--) {
      sb.append(dp[N].get(i)).append(' ');
    }
  }
}