#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n;
    //테스트 결과 계속 오류가 뜸 >> 학생들의 번호를 오름차순으로 준다는 조건이 없었음
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());

    for (int i = 0; i < lost.size(); i++) {
        for (int j = 0; j < reserve.size(); j++) {
            if (lost.at(i) == reserve[j]) {    //도난당한 사람이 여벌이 존재할 경우
                reserve.erase(reserve.begin() + j);   //체육복 삭제
                lost[i] = 0;   //체육복 삭제
                break;
            }
        }
    }

    //도난당한 체육복만큼 반복
    for (int i = 0; i < lost.size(); i++) {
        if (lost[i] == 0)  continue;   //도난당한 사람이 여벌 체육복이 있는 경우
        if (reserve.empty()) {    //여벌의 체육복이 없을 경우 반복문 종료
            answer--;
            continue;
        }
        //여벌 체육복만큼 반복
        for (int j = 0; j < reserve.size(); j++) {
            if (lost[i] - 1 == reserve[j]) {      //도난당한 앞사람에게 빌리기
                reserve.erase(reserve.begin() + j);
                break;
            }
            else if (lost[i] + 1 == reserve[j]) {     //도난당한 뒷사람에게 빌리기
                reserve.erase(reserve.begin() + j);
                break;
            }
            else {
                answer--;
                break;
            }
        }
    }
    return answer;
}