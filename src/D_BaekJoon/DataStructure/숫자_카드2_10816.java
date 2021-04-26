package D_BaekJoon.DataStructure;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 숫자_카드2_10816 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> cards = new HashMap<>();

        int cardLoop = sc.nextInt();
        String[] cardArr = sc.nextLine().split(" ");
        Arrays.sort(cardArr);

        int candidateCnt = sc.nextInt();
        String[] cndidtArr = sc.nextLine().split(" ");

        for(int i=0; i<cardLoop; i++){
            int card = Integer.parseInt(cardArr[i]);
            if(cards.get(card) != null) cards.put(card, cards.get(card)+1);
            else cards.put(card, 1);
        }
    }
}
