import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        //숫자로 이뤄진 문자열 정렬
        //["119", "97674223", "1195524421"]-->["119", "1195524421", "97674223"]
        //["12","111","123"]-->["111","12","123"]
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            //phoneBook[i+1](1195524421)에 phone_book[i](119)로 시작하는 것이 있는가
            if (phoneBook[i+1].startsWith(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
/*
//다른 풀이법
//효율성 실패(Due to 이중 루프문)_근데 이렇게도 풀이 가능
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        //숫자로 이뤄진 문자열 정렬
        //["119", "97674223", "1195524421"]-->["119", "1195524421", "97674223"]
        //["12","111","123"]-->["111","12","123"]
        Arrays.sort(phone_book);
        String [] str = phone_book ;
        for (int j=0 ; j<str.length; j++){
               for (int i=j+1; i<phone_book.length;i++){
	      //str[i](1195524421)에 phone_book[j](119)가 있는가
                   if( str[i].matches(phone_book[j] + ".*") ){
                       return false; 
                   }
                   else{
                       answer= true;
                   }    
               }             
        }
        return answer;
    }
}*/