package D_BaekJoon.Recursion;

import java.util.Scanner;

public class 재귀함수가_뭔가요_17478 {

    static String indentation = "----";

    static String first = "\"재귀함수가 뭔가요?\"";
    static String second = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String third = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String forth = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

    static String fifth = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String sixth = "라고 답변하였지.";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        sb = tellingStory(loop, 0, sb);
        System.out.println(sb);
    }

    public static StringBuilder tellingStory(int loop, int depth, StringBuilder sb){
        if(loop == depth){
            sb = makeStory(loop, sb, true);
        } else {
            sb = makeStory(depth, sb, false);
            sb = tellingStory(loop, ++depth, sb);
            sb = indent(--depth, sb);
            sb.append(sixth); sb.append("\n");
        }
        return sb;
    }

    public static StringBuilder makeStory(int depth, StringBuilder sb, boolean isEnd){
        if(isEnd){
            sb = indent(depth, sb);
            sb.append(first); sb.append("\n");
            sb = indent(depth, sb);
            sb.append(fifth); sb.append("\n");
            sb = indent(depth, sb);
            sb.append(sixth); sb.append("\n");
        } else {
            sb = indent(depth, sb);
            sb.append(first); sb.append("\n");
            sb = indent(depth, sb);
            sb.append(second); sb.append("\n");
            sb = indent(depth, sb);
            sb.append(third); sb.append("\n");
            sb = indent(depth, sb);
            sb.append(forth); sb.append("\n");
        }
        return sb;
    }

    public static StringBuilder indent(int depth, StringBuilder sb){
        for(int i=0; i<depth; i++){
            sb.append(indentation);
        }
        return sb;
    }
}
