import java.io.*;
import java.util.*;

class Main
{
  static class Edge
  {
    int to;
    int usado;

    Edge(int to, int usado)
    {
      this.to = to;
      this.usado = usado;
    }
  }

  static StringBuilder sb = new StringBuilder();

  static int N, Q;

  static ArrayList<Edge>[] adj;
  static ArrayDeque<Integer> queue = new ArrayDeque<>();

  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    adj = new ArrayList[N + 1];

    for(int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }

    for(int i = 0; i < N - 1; i++)
    {
      st = new StringTokenizer(br.readLine());

      int p = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());

      adj[p].add(new Edge(q, r));
      adj[q].add(new Edge(p, r));
    }

    for(int i = 0; i < Q; i++)
    {
      st = new StringTokenizer(br.readLine());

      int k = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      process(k, v);
    }

    System.out.println(sb);
  }

  // 문제 풀이
  static void process(int k, int v)
  {
    int answer = -1;
    boolean[] visited = new boolean[N + 1];

    queue.clear();
    queue.add(v);
    queue.add(Integer.MAX_VALUE);

    visited[v] = true;

    while(!queue.isEmpty())
    {
      int node = queue.poll();
      int usado = queue.poll();

      if(usado >= k) {
        answer++;
      } else {
        continue;
      }

      for(Edge edge : adj[node])
      {
        if(visited[edge.to])
          continue;
        
        visited[edge.to] = true;

        queue.add(edge.to);
        queue.add(Math.min(usado, edge.usado));
      }
    }

    sb.append(answer).append('\n');
  }
}