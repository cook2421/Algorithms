import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list = list.subList(1, list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));
    }
}
