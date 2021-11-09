#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> answers) {
	vector<int> winner;
	vector<int> firstarray = { 1,2,3,4,5 };
	vector<int> secondarray = { 2,1,2,3,2,4,2,5 };
	vector<int> thirdarray = { 3,3,1,1,2,2,4,4,5,5 };
	int firstcount = 0; int secondcount = 0; int thirdcount = 0;
	for (int i = 0; i < answers.size(); i++)
	{
		if (answers[i] == firstarray[i % 5])
			firstcount++;
		if (answers[i] == secondarray[i % 8])
			secondcount++;
		if (answers[i] == thirdarray[i % 10])
			thirdcount++;
	}
	if (firstcount >= secondcount && firstcount >= thirdcount)
	{
		winner.push_back(1);
	}
	if (secondcount >= firstcount && secondcount >= thirdcount)
	{
		winner.push_back(2);
	}
	if (thirdcount >= firstcount && thirdcount >= secondcount)
	{
		winner.push_back(3);
	}
	return winner;
}