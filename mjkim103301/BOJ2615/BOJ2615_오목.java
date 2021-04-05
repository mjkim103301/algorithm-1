package ssafy.algo.study.week03;

import java.util.*;
import java.io.*;

public class BOJ2615_오목 {
    static char[][]map;
    static int[][] dydx={
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
    };
    static int winner, startY,startX;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        map=new char[19][19];
        for(int y=0;y<19;y++){
            map[y]=br.readLine().replace(" ", "").toCharArray();
        }

        solution();
        System.out.println(winner);
        if(winner!=0){
            System.out.println(startY+" "+startX);
        }
    }

    static void solution(){
        for(int y=0;y<19;y++){
            for(int x=0;x<19;x++){
                if(map[y][x]=='0')continue;
                
                //map 이 1 또는 2일 때
                if(findWinner(y, x)){
                    return;
                }
                
            }
        }
    }

    static boolean findWinner(int y, int x){
        char target=map[y][x];

        for(int i=0;i<4;i++){
            int yy=y+dydx[i][0];
            int xx=x+dydx[i][1];
            if(!canGo(yy, xx) || map[yy][xx]!=target) continue;

            //반대방향 좌표의 값이 target인지 검사
            //target과 같다면 continue;
            int prevY=y-dydx[i][0];
            int prevX=x-dydx[i][1];
            if(canGo(prevY, prevX) &&map[prevY][prevX]==target) continue;

            //(yy, xx) 의 값이 target이고 오목의 시작 바둑알일 때-> 오목인지 검사
            if(isFinish(yy, xx, i, target)){
                //오목이면 답 저장
                winner=target-'0';
                startY=y+1;
                startX=x+1;
                return true;
            }

        }
        return false;
    }

    // 좌표 (y, x) 가 map의 범위를 벗어나는지 검사
    static boolean canGo(int yy, int xx){ 
        if(yy<0 ||xx<0||yy>=19 ||xx>=19){
            return false;
        }
        return true;
    }

    // 오목인지 검사
    // findWinner 메서드에서 바둑알 2개를 확인했으므로 여기서는 for문을 통해 3개만 확인
    static boolean isFinish(int y, int x, int direct, char target){
        for(int j=1;j<4;j++){
            y+=dydx[direct][0];
            x+=dydx[direct][1];

            if(!canGo(y, x)||map[y][x]!=target) return false;
        }

        //6목인지 검사
        y+=dydx[direct][0];
        x+=dydx[direct][1];
        if(canGo(y, x) && map[y][x]==target) return false;
        return true;
    }
}
