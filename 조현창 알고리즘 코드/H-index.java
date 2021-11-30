/*
import java.util.Arrays;
//정렬 후 이분탐색을 이용한다. 
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int right = citations.length - 1;
        int left = 0;
        while(right > left){
            int mid = (right + left + 1) / 2;
            if(citations.length - mid >= citations[mid]){
                left = mid;
            }else right = mid-1;
        }
        return citations[left];
    }
}*/

import java.util.Arrays;
//매개변수를 인덱스가 아닌 h로 변경  *인덱스일 때 중복데이터 있을 경우 개수를 명확하게 구분 못함
class Solution {
    public int solution(int[] citations) {
        int right = 10000;
        int left = 0;
        while(right > left){
            int mid = (right + left + 1) / 2;
            int cnt = 0;
            for(int c: citations){
                if(c >= mid)cnt++;
            }
            if(cnt >= mid){
                left = mid;
            }else
                right = mid -1;
        }
        return left;
    }
}