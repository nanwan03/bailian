import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	int s;
	int time;
	Point(int x, int y, int s, int time) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.time = time;
	}
}

class Door {
	int x;
	int y;
	Door(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	private static int r,c,k;  
	private static int[] dirX = new int[]{1, -1, 0, 0};  
	private static int[] dirY = new int[]{0, 0, 1, -1};  
	private static int minTime = 0;  
	private static char[][] map = new char[210][210]; 
	private static boolean[][][] visited = new boolean[210][210][1 << 5];
	private static List<Door> doors = new ArrayList<Door>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(in.readLine());
		while (testcase-- > 0) {
			init();
			int startX = 0;
			int startY = 0;
			int endX = 0;
			int endY = 0;
			String[] strs = in.readLine().split("\\s+");
			r = Integer.parseInt(strs[0]);
			c = Integer.parseInt(strs[1]);
			k = Integer.parseInt(strs[2]);
			for (int i = 0; i < r; ++i) {
				char[] chars = in.readLine().toCharArray();
				map[i] = chars;
				for (int j = 0; j < c; ++j) {
					if (map[i][j] == '$') {
						doors.add(new Door(i, j));
					} else if (map[i][j] == 'S') {
						startX = i;
						startY = j;
						map[i][j] = '.';
					} else if (map[i][j] == 'E') {
						endX = i;
						endY = j;
						map[i][j] = '.';
					}
				}
			}
			if (bfs(startX, startY, endX, endY)) {
				System.out.println(minTime);
			} else {
				System.out.println("oop!");
			}
		}
	}
	private static void init() {
		doors.clear();
		for (int i = 0; i < 210; ++i) {
			for (int j = 0; j < 210; ++j) {
				for (int k = 0; k < (1 << 5); ++k) {
					visited[i][j][k] = false;
				}
			}
		}
	}
	private static boolean check(int s, int k)  
	{//s为宝石发现情况；  
	    int cnt = 0;//记录已发现宝石的个数；  
	    for (int i = 0; i <= 4; i++)  
	    {  
	        if (((s >> i) & 1) == 1)  
	            cnt++;  
	    }  
	    return (cnt >= k);//集齐全部宝石；  
	}
	private static boolean bfs(int startX, int startY, int endX, int endY) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(startX, startY, 0, 0));
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.x == endX && p.y == endY && check(p.s, k)) {
				minTime = p.time;
				return true;
			}
			if (map[p.x][p.y] == '.' || (map[p.x][p.y] >= '0' && map[p.x][p.y] <= '4')) {
				int s = p.s;
				if (map[p.x][p.y] != '.') {
					s = p.s | (1 << (map[p.x][p.y] - '0'));
				}
				List<Point> neighbors = getNeighbor(p.x, p.y, s, p.time);
				queue.addAll(neighbors);
			} else if (map[p.x][p.y] == '$') {
				for (int i = 0; i < doors.size(); ++i) {
					List<Point> neighbors = getNeighbor(doors.get(i).x, doors.get(i).y, p.s, p.time);
					queue.addAll(neighbors);
	            }  
	        }
		}
		return false;
	}
	private static List<Point> getNeighbor(int x, int y, int status, int level) {
		List<Point> lists = new ArrayList<Point>();
		for (int i = 0; i < 4; ++i) {
			int dx = x + dirX[i];
			int dy = y + dirY[i];
			if (dx >= 0 && dx < r && dy >= 0 && dy < c && map[dx][dy] != '#' && !visited[dx][dy][status]) {
				visited[dx][dy][status] = true;
				lists.add(new Point(dx, dy, status, level + 1));
			}
		}
		return lists;
	}
}