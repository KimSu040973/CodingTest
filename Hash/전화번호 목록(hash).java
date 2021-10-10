import java.util.*;

class Solution { 
    public boolean solution(String[] phoneBook) { 
        boolean answer = true; 
        // 1. HashMap 만들기
        HashMap<String, Integer> map = new HashMap<>(); 
        // 2. 모든 전화번호 Hashing 하기 (Hash Map에 추가하기) 
        //**사실 키값에만 의미있는 전번을 넣어 키의 벨류값은 쓸모X
        //**HashMap<Integer, String> map~/map.put(i, phoneBook[i]);/map.containsValue
        //로 키랑 벨류값 바꿔서 해도 풀이 가능
        for(int i = 0; i < phoneBook.length; i++) 
            map.put(phoneBook[i], i); 
       
       // 3. 다시 돌며 각 전화번호의 일부가 HashMap에 있는지 확인하기 (접두어가 존재하는지 확인하기) 
       for(int i = 0; i < phoneBook.length; i++) { 
            //j=1부터 phoneBook[i]의 수까지
            for(int j = 1; j < phoneBook[i].length(); j++) { 
                //전체 키 중에서 접두사 찾기 
                //phoneBook[i](전번)을 앞에서부터 한자리씩 자르기(0 ~ j-1)
                //EX>1195524421를 substring(0,3)으로 잘라 전체 키에서 119를 찾기
                if(map.containsKey(phoneBook[i].substring(0,j))) { 
                    //answer = false; 
                    return false; 
                } 
            } 
        } 
        return answer; 
    } 
}
/*
//다른풀이_hashset(value)_key & value 둘다 필요 없을때 
//**성능(정확,효율) 비슷
import java.util.*;

class Solution { 
    public boolean solution(String[] phoneBook) { 
        boolean answer = true; 
        // 1. HashSet만들기
        HashSet<String> map = new HashSet<>(); 
        // 2. 모든 전화번호 Hashing 하기 (Hash Set에 추가하기) 
        for(int i = 0; i < phoneBook.length; i++) 
            map.add(phoneBook[i]); 
       
       // 3. 다시 돌며 각 전화번호의 일부가 HashSet에 있는지 확인하기 (접두어가 존재 여부 확인하기) 
       for(int i = 0; i < phoneBook.length; i++) { 
            for(int j = 1; j < phoneBook[i].length(); j++) { 
	   //containsKey&containsValue 사용 X
                if(map.contains(phoneBook[i].substring(0,j))) { 
                    //answer = false; 
                    return false; 
                } 
            } 
        } 
        return answer; 
    } 
}
*/