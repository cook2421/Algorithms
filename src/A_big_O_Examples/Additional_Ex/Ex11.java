package A_big_O_Examples.Additional_Ex;

/**
 * 정렬된 문자열 중 길이가 k인 모든 문자열을 출력하는 코드이다.
 * 길이가 k인 모든 문자열을 생성한 뒤 해당 문자열이 정렬되어 있는지 확인하는 과정을 거친다.
* */
public class Ex11 {

    int numChars = 26;

    void printSortedStrings(int remaining){
        printSortedStrings(remaining, "");
    }

    void printSortedStrings(int remaining, String prefix){
        if(remaining == 0){
            if(isInOrder(prefix)){
                System.out.println(prefix);
            }
        } else {
            for(int i=0; i<numChars; i++){
                char c = ithLetter(i);
                printSortedStrings(remaining-1, prefix+c);
            }
        }
    }

    boolean isInOrder(String s){
        for(int i=1; i<s.length(); i++){
            int prev = ithLetter(s.charAt(i-1));
            int curr = ithLetter(s.charAt(i));
            if(prev > curr){
                return false;
            }
        }
        return true;
    }

    char ithLetter(int i){
        return (char)(((int)'a')+i);
    }
}
