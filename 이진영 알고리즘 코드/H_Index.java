package programmers_tutoring;

import java.util.Arrays;

class H_Index {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5}; // 0 1 3 5 6
        int answer = solution1(citations);
        System.out.println(answer);
    }
    static int solution1(int[] citations) {  //citations: 논문의 인용횟수 배열 => citations.length=논문의 수
        int answer = 0;     //해당 과학자의 H-index
        //h번 이상 인용된 논문이 h편 이상   쨌든 h<=citations.length
        int countNum;   //해당 h번 이상 인용된 논문의 개수
        for(int h=1;h<=citations.length;h++){
            countNum=0;
            for(int n=0;n<citations.length;n++){    //논문의 개수인 n번 반복
                if(citations[n]>=h)                 //h편 이상 인용된 경우 -> 1증가
                    countNum++;
            }
            if(countNum>=h)
                answer=h;
        }
        return answer;
    }


    //solution2는 정렬을 이용하여, 시간복잡성 줄임
    public int solution2(int[] citations) {
        int answer = 0;     //해당 과학자의 H-index
        Arrays.sort(citations);

        int countNum;
        for(int h=citations.length;h>=1;h--){
            countNum=0; //해당 h번 이상 인용된 논문의 개수
            for(int n=0;n<citations.length;n++){    //논문의 개수인 n번 반복
                if(citations[n]>=h)                 //h편 이상 인용된 경우 -> 1증가
                    countNum++;
            }
            if(countNum>=h){
                answer=h;
                break;
            }
        }
        return answer;
    }
}

//착각한 부분
//h번 이상 인용된 논문이 h편 이상이라고 하여, countNum==h가 동일할 때만 H-index가 될 수 있다고 생각함
//if(countNum==h)
//     answer=h;

//수정
//h번 인용된 논문이 h편 이상 => countNum>=h
//3번 이상 인용된 논문의 개수 = 4
//3번 이상 인용된 논문의 개수 = 3
// 두 case 모두 가능 (3편 이상이므로)

