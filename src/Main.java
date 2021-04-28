import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        for(int i=1; i<=10; i++){
            list.add(i);
        }

        list.remove(0);


        System.out.println(list.toString());
        System.out.println(list.indexOf(2));
    }
}
