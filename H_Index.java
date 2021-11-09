package programmers_tutoring.이진영;

import java.util.Arrays;

class H_Index {
    public int solution(int[] citations) {  //citations: 논문의 인용횟수 배열 => citations.length=논문의 수
        int answer = 0;     //해당 과학자의 H-index

        //h번 이상 인용된 논문이 h편 이상   쨌든 h<=citations.length
        int countNum;   //h편 이상 인용된 논문의 개수
        for(int h=0;h<citations.length+1;h++){
            countNum=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=h) //h편 이상 인용된 경우 -> 1증가
                    countNum++;
            }
            if(h==countNum) //인용된 횟수(h번 이상) = h번 이상 인용된 논문의 개수
                answer=h;
        }
        return answer;
    }   // 테스트 11: 실패 (4.15ms, 73.9MB)
}



//    public int solution2(int[] citations) {  //citations: 논문의 인용횟수 배열 => citations.length=논문의 수
//        int answer = 0;     //해당 과학자의 H-index
//
//        //h번 이상 인용된 논문이 h편 이상이고 나머지가 h번 이하인 h의 최댓값을 구하므로
//        //정렬 후 앞에서부터 검사하여 처음 h-index가 성립한 순간을 리턴
//        Arrays.sort(citations);
//
//        // 0 0 0 0 일 때 고려해보기
//        //6 5 3 1 0
//        for(int i=0;i<citations.length;i++){
//            //h를 줄여가면서 검사
//            int h = citations.length-i;     //Q. int h=i;로 하면 안 되나?
//            if(citations[i] >=h ){
//                answer=h;
//                break;
//            }
//        }
//        return answer;
//    }


