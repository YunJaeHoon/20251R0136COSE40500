import java.io.*;
import java.util.*;

class Main_20922
{
  static int N, K;
  static int[] arr;

  public static void main(String[] args) throws IOException
  {
    init();
    process();
  }

  // 입력
  static void init() throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N];

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }

  // 문제 풀이
  static void process()
  {
    int[] count = new int[100005];
    int answer = 0, left = 0, right = 0;
    
    while(right < N)
    {
      count[arr[right]]++;

      if(count[arr[right]] == K + 1)
      {
        answer = Math.max(answer, right - left);

        while(left < N)
        {
          if(arr[left] == arr[right])
          {
            left++;
            count[arr[right]]--;
            break;
          }

          count[arr[left]]--;
          left++;
        }
      }

      right++;
    }

    answer = Math.max(answer, right - left);

    System.out.println(answer);
  }
}