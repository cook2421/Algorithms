import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};

        int[] result = solution(answers);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] answers) {

        int[] A = {1,2,3,4,5};
        int[] B = {2,1,2,3,2,4,2,5};
        int[] C = {3,3,1,1,2,2,4,4,5,5};

        Map<Integer, Integer> point = new HashMap<>();
        point.put(1, 0);
        point.put(2, 0);
        point.put(3, 0);

        for(int i=0; i<answers.length; i++){
            if(answers[i] == A[i%5]) point.put(1, point.get(1)+1);
            if(answers[i] == B[i%8]) point.put(2, point.get(2)+1);
            if(answers[i] == C[i%10]) point.put(3, point.get(3)+1);
        }

        List<Map.Entry<Integer, Integer>> ordered = new ArrayList<>(point.entrySet());
        ordered.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        List<Integer> tempRes = new ArrayList();
        int max = ordered.get(0).getValue();
        for(int i=0; i<ordered.size(); i++){
            Map.Entry<Integer, Integer> map = ordered.get(i);
            if(tempRes.size() == 0) {
                tempRes.add(map.getKey());
            } else if(max == map.getValue()){
                tempRes.add(map.getKey());
            }
        }

        int[] result = new int[tempRes.size()];
        for(int i=0; i<tempRes.size(); i++){
            result[i] = tempRes.get(i);
        }

        return result;
    }
}

