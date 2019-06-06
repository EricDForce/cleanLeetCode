import java.util.Scanner;
import java.util.regex.Pattern;

public class huawei3 {
    static  int N = 222222;
    char[] s = new char[N];

    public static boolean check(char c) {
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        if (c >= '0' && c <= '9') return true;
        if (c == '&') return true;
        if (c == '=') return true;
        if (c == '+') return true;
        if (c == ',' || c == '/') return true;
        if (c == ';' || c == '?') return true;
        if (c == '-' || c == '_') return true;
        if (c == '.' || c == '!') return true;
        if (c == '~' || c == '*' || c == '\'') return true;
        if (c == '(' || c == ')') return true;
        if (c == '#' || c == '$') return true;
        return false;
    }

    public static boolean check_domain(char c) {
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        if (c >= '0' && c <= '9') return true;
        if (c == '-') return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        int last = -1, start = -1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '@') {
                start = i;
            } else if (s.charAt(i) == '.') {
                if (start != -1 && i - start - 1 <= 119) {
                    boolean domain_ok = false;
                    for (int j = start + 1; j < i; j++) {
                        if (!check_domain((char)i)) {
                            domain_ok = true;
                            break;
                        }
                    }
                    if (domain_ok && check(s.charAt(start - 1)) && check(s.charAt(start - 2)) && check(s.charAt(start - 3))) {
                        s = s.substring(0, start-3) + "***" + s.substring(start);
                        last = i;
                        start = -1;
                    }
                }
            }
        }
    }
}