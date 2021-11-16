#include <string>
#include <vector>
using namespace std;
vector<int> student;
int solution(int n, vector<int> lost, vector<int> reserve) {
	int answer = 0;
	//index를 1부터 셀것이다.
	for (int i = 0; i <= n; i++)student.push_back(1); //처음 학생들의 옷개수는 1개이다.
	for (int i = 0; i < lost.size(); i++)student[lost[i]]--; //잃어버린 친구는 0개
	for (int i = 0; i < reserve.size(); i++)student[reserve[i]]++; //여분이 있는 친구는 2개
	for (int i = 1; i <= n; i++)
	{
		if (student[i] == 2)
		{
			if (i > 1 && student[i - 1] == 0) //왼쪽
				student[i] = student[i - 1] = 1;
			else if (i < n && student[i + 1] == 0) //오른쪽
				student[i] = student[i + 1] = 1;
		}
	}
	for (int i = 1; i <= n; i++)if (student[i] != 0)answer++;
	return answer;
}