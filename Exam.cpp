#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> score(3);
    vector<vector<int>> gue = { {1, 2, 3, 4, 5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5} };

    for (int i = 0; i < answers.size(); i++) {
        //수포자1
        if (answers[i] == gue[0][i % gue[0].size()])    score[0]++;
        //수포자2
        if (answers[i] == gue[1][i % gue[1].size()])    score[1]++;
        //수포자3
        if (answers[i] == gue[2][i % gue[2].size()])    score[2]++;
    }

    int max = *max_element(score.begin(), score.end());
    for (int i = 0; i < 3; i++) {
        if (max == score[i])   answer.push_back(i + 1);
    }
    return answer;
}

// 처음 답안
// vector<int> solution(vector<int> answers) {
//     vector<int> answer;
//     vector<int> score(3);
//     int t;
//     for(int i=0;i<answers.size();i++){
//         //수포자1
//         if(answers[i]==i%5+1)    score[0]++;

//         //수포자2
//         if(i%2==0)  //짝수번째
//            if(answers[i]==2)     score[1]++;
//         else{       //홀수번째
//             t=i%8;
//             switch(t){
//                 case 1:
//                     if(answers[i]==1)    score[1]++;
//                 case 3:
//                     if(answers[i]==3)    score[1]++;
//                 case 5:
//                     if(answers[i]==4)    score[1]++;
//                 case 7:
//                     if(answers[i]==5)    score[1]++;  
//             }
//         }
//         switch(i%10){  
//             case 0:
//                 if(answers[i]==3)    score[2]++;
//                 break;
//             case 1:
//                 if(answers[i]==3)    score[2]++;
//                 break;
//             case 2:
//                 if(answers[i]==1)    score[2]++;
//                 break;
//             case 3:
//                 if(answers[i]==1)    score[2]++;
//                 break;
//             case 4:
//                 if(answers[i]==2)    score[2]++;
//                 break;
//             case 5:
//                 if(answers[i]==2)    score[2]++;
//                 break;
//             case 6:
//                 if(answers[i]==4)    score[2]++;
//                 break;
//             case 7:
//                 if(answers[i]==4)    score[2]++;
//                 break;
//             case 8:
//                 if(answers[i]==5)    score[2]++;
//                 break;
//             case 9:
//                 if(answers[i]==5)    score[2]++;
//                 break;
//         }
//     }

//     int max = *max_element(score.begin(), score.end());
//     for(int i=0;i<3;i++){
//         if(max==score[i])   answer.push_back(i+1);
//     }
//     return answer;
// }
