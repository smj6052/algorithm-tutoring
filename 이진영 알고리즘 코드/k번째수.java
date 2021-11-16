package programmers_tutoring;

import java.util.Arrays;

//주의사항: 배열이 1부터 시작하여 헷갈림
class k번째수 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];    //배열 객체를 생성해줘야 함.
        //int[] answer={};는 참조변수만 생성한 것!

        //배열 자르기 commands[][0]=i, commands[][1]=j,
        for(int i=0;i<commands.length;i++){
            int k = commands[i][2]-1;       //commands[][2]=k번째 인덱스 설정
            int[] tmp = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(tmp);               //배열 정렬
            answer[i]=tmp[k];               //commands[][2]=k번째에 있는 수 찾고, answer배열에 추가
        }
        return answer;
    }
}