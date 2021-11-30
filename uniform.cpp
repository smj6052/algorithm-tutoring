#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n;
    //�׽�Ʈ ��� ��� ������ �� >> �л����� ��ȣ�� ������������ �شٴ� ������ ������
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());

    for (int i = 0; i < lost.size(); i++) {
        for (int j = 0; j < reserve.size(); j++) {
            if (lost.at(i) == reserve[j]) {    //�������� ����� ������ ������ ���
                reserve.erase(reserve.begin() + j);   //ü���� ����
                lost[i] = 0;   //ü���� ����
                break;
            }
        }
    }

    //�������� ü������ŭ �ݺ�
    for (int i = 0; i < lost.size(); i++) {
        if (lost[i] == 0)  continue;   //�������� ����� ���� ü������ �ִ� ���
        if (reserve.empty()) {    //������ ü������ ���� ��� �ݺ��� ����
            answer--;
            continue;
        }
        //���� ü������ŭ �ݺ�
        for (int j = 0; j < reserve.size(); j++) {
            if (lost[i] - 1 == reserve[j]) {      //�������� �ջ������ ������
                reserve.erase(reserve.begin() + j);
                break;
            }
            else if (lost[i] + 1 == reserve[j]) {     //�������� �޻������ ������
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