#include <string>
#include <vector>
#include <cstdio>
using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int a[3][10] = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
    int ac[3] = {5,8,10};
    vector<int> cnt(3, 0);
    int max = 0;
    for(int i = 0; i < answers.size(); i++){
        for(int j = 0; j < 3; j++){
            if(a[j][i%ac[j]] == answers[i]){
                cnt[j]++;
                if(cnt[j] > max)max = cnt[j];
            }
        }
    }
    for(int i = 0; i < 3; i++){
        if(cnt[i] == max)answer.push_back(i+1);
    }
     return answer;
}