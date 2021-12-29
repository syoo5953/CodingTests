    package Programmers;

public class RoomDoorLength {
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        Solution35 solution35 = new Solution35();
        int answer = solution35.solution(dirs);
        System.out.println(answer);
    }
}

class Solution35 {
    // U,D,R,L - 위,아래,오른쪽,왼쪽 순
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};
    // 맵의 크기 = -5 ~ 5까지이므로 11x11
    public static boolean[][][][] visit = new boolean[11][11][11][11];

    public int solution(String dirs) {
        int answer = 0;

        /* x,y = 캐릭터가 이동하기 전 위치, nextX, nextY = 캐릭터가 이동한 후 위치 */
        int x = 0;
        int y = 0;
        // 문제의 범위는 -5~5이고, 배열의크기는0~10이므로 시작 위치를 +5로 잡아준다.
        int nextX = 5;
        int nextY = 5;

        int index = 0;

        for(int i=0; i<dirs.length(); i++){
            // 캐릭터의 현재 위치 저장
            x = nextX;
            y = nextY;
            if(dirs.charAt(i) == 'U')
                index = 0;
            else if(dirs.charAt(i) == 'D')
                index = 1;
            else if(dirs.charAt(i) == 'R')
                index = 2;
            else if(dirs.charAt(i) == 'L')
                index = 3;

            // U, D, R, L에 맞는 캐릭터 위치 이동
            nextX += dx[index];
            nextY += dy[index];
            System.out.println("nextX = " + nextX + " nextY = " + nextY);

            // 이전에 움직인 범위에 의해 캐릭터의 위치가 지도를 벗어났을 경우
            if(nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10){
                // 다시 캐릭터를 전의 위치로 이동
                nextX -= dx[index];
                nextY -= dy[index];
                continue;
            }
            // 캐릭터가 처음 걸어본 길일경우
            if(!visit[x][y][nextX][nextY] && !visit[nextX][nextY][x][y]){
                // 걸어온 길 체크(점이 아닌 길이기 때문에 양방향으로 체크한다.)
                visit[x][y][nextX][nextY] = true;
                visit[nextX][nextY][x][y] = true;
                System.out.println("visited = " + visit[x][y][nextX][nextY]);
                System.out.println("visited ViceVersa= " + visit[nextX][nextY][x][y]);
                answer ++;
            }
        }
        return answer;
    }
}