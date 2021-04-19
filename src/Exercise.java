import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        int[] answers = {1,3,2,3,2};

        List list = new ArrayList();
        for(int i : answers){
            list.add(i);
        }

        System.out.println(list.indexOf(Collections.max(list)));
    }
}

