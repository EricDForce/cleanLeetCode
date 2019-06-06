import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        for (String str : res){
            System.out.println(str);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateOneByOne("", result, n, n);
        return result;
    }
    public static void generateOneByOne(String sublist, List<String> list, int left, int right){
        if (left > right)
            return;
        if (left > 0){
            generateOneByOne(sublist + "(", list, left -1, right);
        }
        if (right > 0){
            generateOneByOne(sublist + ")", list, left, right-1);
        }
        if (left==0 && right==0){
            list.add(sublist);
            return;
        }
    }
}
