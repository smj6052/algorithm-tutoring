package programmers_tutoring;

import java.util.Arrays;
import java.util.Comparator;

// 정수를 이어 붙여 만들 수 있는 가장 큰 수
// 문자열 내림차순
class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = ""; //가장 큰 수를 문자열로 바꾸기

        /** 1 **/
        String[] str_numbers = new String[numbers.length];

        /** 2 **/
        for(int i=0; i< str_numbers.length;i++){
            str_numbers[i] = String.valueOf(numbers[i]);
        }

        /** 3 **/
        //배열 정렬, 정렬 규칙으로는 2개를 더하여 더 큰 쪽이 우선순위가 있도록 정렬
        Arrays.sort(str_numbers, new Comparator<String>() { //익명클래스로 구현
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });


        /** 4 **/

        if(str_numbers[0].startsWith("0")){         //비교대상문자열.startsWith("체크할 문자열") >>> str1.startsWith("자바")
            answer+="0";
        }else{
            for(int j=0;j< str_numbers.length;j++){
                answer+=str_numbers[j];
            }
        }
        return answer;
    }
}


/** 1 **/
// int형 배열인 numbers를 String형 배열로 변환하기 위해 String형 배열을 선언한다.

/** 2 **/
// int형 배열을 String 배열로 변환하는 작업

/** 3 **/
// String 배열을 내림차순으로 정렬한다.
// 인터페이스 Comparator를 사용하기 위해 메소드 재정의를 한다.
// 재정의 과정에서 내림차순으로 수정한다.
// 내림차순 : return (o2+o1).compareTo(o1+o2);
// 오름차순 : return (o1+o2).compareTo(o2+o1);

/** 4 **/
// 이 문제의 함정은 같은 수가 중복될 수도 있다는 점이다.
// 즉, 0이 여러 번 중복되면 답은 "0"이어야 하는데, "0000" 이런 수가 나오게 된다.
// 그러므로 배열에 가장 큰 수가 "0"으로 시작하는 경우에는 "0"을 입력하고 종료한다.
// 그 외에 정렬이 잘 된 수라면 반복문을 돌려 출력을 위한 변수 answer에 순차적으로 담는다.

//https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=yongyos&logNo=221580402785


// Comparator를 잘 사용하면,
// 숫자의 내림차순 정렬, 단어의 정렬도 손쉽게 할 수 있고,
// 객체를 value로 갖고 있는 Array나 List의 정렬, 다차원 배열 정렬도 손쉽게 할 수 있다.
