package programmers_tutoring;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {

    }

    class Solution1 {
        public int[] solution(int[] answers) {  //문제 정답 배열
            int[] answer = {};  //가장 많이 맞힌 사람

            //1번 수포자가 찍는 방식: 1, 2, 3, 4, 5
            //2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5
            //3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5

            int[] p1 = {1, 2, 3, 4, 5};
            int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int[] cnt = {0,0,0};

            for(int i=0;i< answers.length;i++){
                if(p1[i%5]==answers[i])
                    cnt[0]++;
                if(p2[i%8]==answers[i])
                    cnt[1]++;
                if(p3[i%10]==answers[i])
                    cnt[2]++;
            }

            //가장 많이 맞힌 사람 찾기
            int max = cnt[0];
            for(int i=1;i<cnt.length;i++){
                if(max<cnt[i])
                    max=cnt[i];
            }

            //가장 많이 맞힌 사람의 인원 수 찾기
            int num=0;
            for(int i=0;i<cnt.length;i++){
                if(max==cnt[i])
                    num++;
            }
            answer = new int[num];

            //answer에 삽입
            int idx=-1;
            for(int i=0;i<cnt.length;i++){
                if(max==cnt[i]){
                    answer[++idx]=i+1;
                }
            }
            return answer;
        }
    }


    class Solution2 {
        public int[] solution(int[] answers) {  //문제 정답 배열
            List<Integer> answer = new ArrayList<>();  //가장 많이 맞힌 사람

            //1번 수포자가 찍는 방식: 1, 2, 3, 4, 5
            //2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5
            //3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5

            int[] p1 = {1, 2, 3, 4, 5};
            int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int c1=0,c2=0,c3=0;

            for(int i=0;i< answers.length;i++){
                if(p1[i%5]==answers[i])
                    c1++;
                if(p2[i%8]==answers[i])
                    c2++;
                if(p3[i%10]==answers[i])
                    c3++;
            }

            //가장 많이 맞힌 사람 찾기
//            int max = cnt[0];
//            for(int i=1;i<cnt.length;i++){
//                if(max<cnt[i])
//                    max=cnt[i];
//            }
            int max = Math.max(c1,Math.max(c2,c3));

            //가장 많이 맞힌 사람의 인원 수 찾기 + 동시에 answer에 삽입하기
            if(c1==max)
                answer.add(1);
            if(c2==max)
                answer.add(2);
            if(c3==max)
                answer.add(3);

            // Integer형인 List answer를 int형인 배열로 바꾸기
            return answer.stream().mapToInt(i->i.intValue()).toArray();
        }
    }
}
