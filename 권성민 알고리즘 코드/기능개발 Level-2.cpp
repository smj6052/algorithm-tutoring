#include <string>
#include <vector>
#include <stack>

using namespace std;

int day = 1;
int num = 0;
vector<int> solution(vector<int> progresses, vector<int> speeds) {

	vector<int> result;
	stack<int> array;
	for (int i = progresses.size() - 1; i > -1; i--)
	{
		array.push(progresses[i]);
	}
	for (int i = 0; i < speeds.size(); i++)
	{
		while ((speeds[i] * day) + array.top() < 100)
		{
			if (num != 0)
			{
				result.push_back(num);
			}
			num = 0;
			day++;
		}
		num++;
		array.pop();
	}
	result.push_back(num);
	return result;
}
//나의 알고리즘
/*100퍼센트가 되면 그날 배포가된다. 날은 그대로 계속 가기때문에 day를 진행상황에 따라 계속 ++를 해주되, 
원래의 진행시간+속도*날짜가 100이상이되면 그날 배포를 해야된다. 
그렇게 100이 넘었을때 배포를 해준 수를 num에 저장한다. vector를 그대로 사용할수 있었지만, 
stack관련 문제라고 생각하여 stack의 문법을 사용하였다.*/