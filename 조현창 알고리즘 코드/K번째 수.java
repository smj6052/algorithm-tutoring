
//import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

class Solution {
    /*
     * 기본 배열 사용 코드 public int[] solution(int[] array, int[][] commands) {
     * 
     * int[] answer = new int[commands.length];
     * 
     * for(int ci = 0; ci < commands.length; ci++){ int[] slice = new
     * int[commands[ci][1]-commands[ci][0]+1]; for(int i = commands[ci][0]-1, si =
     * 0; i < commands[ci][1]; i++, si++){ slice[si] = array[i]; }
     * Arrays.sort(slice); answer[ci] = slice[commands[ci][2]-1]; } return answer;
     */
    public Vector<Integer> solution(int[] array, int[][] commands) {
        Vector<Integer> answer = new Vector<Integer>();
        for (int[] c : commands) {
            Vector<Integer> slice = new Vector<Integer>();
            for (int i = c[0] - 1, si = 0; i < c[1]; i++, si++) {
                slice.add(array[i]);
            }
            Collections.sort(slice);
            answer.add(slice.get(c[2] - 1));
        }
        return answer;
    }
}