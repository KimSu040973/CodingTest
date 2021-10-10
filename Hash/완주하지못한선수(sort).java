import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);//elk
        Arrays.sort(completion);//ek
        int i;
        for ( i=0; i<completion.length; i++){

            if (!participant[i].equals(completion[i])) break;
        }
        return participant[i];
    }//amms =! ams
}
