package ssafy.algo.study.week03;

import java.util.*;

public class BOJ2370_시장선거포스터 {
    static int N;

    static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static LinkedList<Node> list = new LinkedList<>();
    static Node[] poster;
    static int cnt;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        poster = new Node[N];
        for (int i = 0; i < N; i++) {
            poster[i] = new Node(scan.nextInt(), scan.nextInt());
        }
        solution();

    }

    static void solution() {
        list.add(poster[N - 1]);
        cnt++;

        for (int i = N - 2; i >= 0; i--) {
            int size = list.size();
            Node p = poster[i];
            if (p.right > list.get(0).left) {//포스터 옆에 부모
                list.addFirst(p);
                cnt++;
                continue;

            } else if (p.right == list.get(0).left) {
                if (p.left == list.get(0).left) {
                    continue;
                }

                list.get(0).left = p.left;
                cnt++;
                continue;

            } else {

                for (int j = 0; j < size; j++) {//리스트 인덱스
                    Node l=list.get(j);
                    if(p.left<=l.left && p.right>=l.right){ //포함 관계
                        break;
                    }
                    if (p.left <= l.left) {
                        cnt++;
                        list.get(j).left = p.left;
                        if (p.right > l.right) {
                            list.get(j).right = p.right;
                        }
                        break;

                    } else if (p.left > l.left) {
                        for(int k=j+1;k<size;k++){
                            Node temp=list.get(k);
                            if(temp.left<p.right){
                                list.get(j).right = p.right;
                            }else{

                            }
                        }
                    }else if(p.left<l.right){

                    }
                }
            }


        }
    }
}
