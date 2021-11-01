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
}