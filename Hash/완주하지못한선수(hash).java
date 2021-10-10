import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> hm=new HashMap();
        //참가자 명단에 있는 이름을 key 로 넣기
        //key의 값은 모두 1
		for (String p : participant){
            //hm.put("leo",1); 레오는 완주X
            hm.put(p,hm.getOrDefault(p,0)+1);//키(참가자이름)의 값은 모두 1
        }
        for(String c: completion){
            //containsKey : 키가 들어있는지 확인 
            if(hm.containsKey(c)){
                Integer count = hm.get(c); //키(완주자이름)의 값(1) 출력값을 count에 삽입
                hm.put(c,count-1); //있으면 덮어쓰지 않는다.(완주할 경우,1->0)
            }
        }
        //keySet : 키와 값 모두 순회
        for(String key : hm.keySet()) {
            //완주X하여 아직 값이 1인 경우
            if(hm.get(key) != 0) {
                //answer에 키(참가자이름에서 완주자이름 뺀 참가자이름)를 삽입
                answer += key;
            }
        }        
		
        return answer;
    }
}
