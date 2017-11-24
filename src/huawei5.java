import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class huawei5 {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            String ss=sc.nextLine();
            Stack<String> stack=new Stack<String>();
            StringBuilder temp1=new StringBuilder();  //字符串缓存，用来判断累积读入的字符是否构成一个操作数/操作符
            List<String> temp2=new ArrayList<String>(); //用于存储栈弹出来的操作数
            char[] chars=ss.toCharArray();
            int n=chars.length;
        /*从左往右扫描字符数组*/
            for(int i=0;i<n;i++){
            /*如果是 ( ，要判断是否实在操作数中，是的话加入缓存字符串，不是的话直接入栈*/
                if(chars[i]=='('){
                    if(temp1.indexOf("\"")==-1){
                        stack.push("(");
                    }else{
                        temp1.append('(');
                    }
                }
            /*如果是 ) ，要判断是否实在操作数中，是的话加入缓存字符串，不是的话出栈至遇到一个 ( */
                else if(chars[i]==')'){
                /*根据缓存字符串中有没有 " 来判断是否在一个操作数中*/
                    if(temp1.indexOf("\"")!=-1){
                        temp1.append(')');
                    }else{
                        String back=stack.pop();
                        while(!back.equals("(")){
                            temp2.add(back);
                            back=stack.pop();
                        }
                        String operator=temp2.get(temp2.size()-1);
                        switch(operator){
                            case "quote":
                                stack.push("\""+(temp2.get(0)).replaceAll("\"","")+"\"");
                                break;
                            case "search":
                                stack.push(search(temp2.get(1),temp2.get(0)));
                                break;
                            case "reverse":
                                stack.push(reverse(temp2.get(0)));
                                break;
                            case "combine":
                                String stringComb=combine(temp2.subList(0,temp2.size()-1));
                                stack.push(stringComb);
                                break;
                        }
                        temp2.clear();
                    }
                }
            /*如果是空格，判断空格是否在操作数字符串中，不是的话原先的字符串缓存已经构成一个操作数/符，压入栈。
              是的话加入到字符串缓存中*/
                else if(chars[i]==' '){
                    if(temp1.indexOf("\"")!=-1){
                        temp1.append(chars[i]);
                    }else{
                        if(temp1.length()>0){
                            String tempString=temp1.toString();
                            stack.push(tempString);
                            temp1.setLength(0);
                        }
                    }
                }
            /*如果遇到成对的 " ，表明缓存的是一个操作符/数，将其压入栈*/
                else if((chars[i]=='\"')&&(temp1.indexOf("\"")!=-1)){
                    if(temp1.length()>0){
                        temp1.append('\"');
                        String tempString=temp1.toString();
                        stack.push(tempString);
                        temp1.setLength(0);
                    }
                }
            /*字母或者数字的情况直接加入到字符串缓存*/
                else{
                    temp1.append(chars[i]);
                }
            }
            for(int i=0;i<stack.size();i++){
                System.out.print(stack.pop());
            }
        }

    static String search(String s1,String s2){
        s1=s1.replaceAll("\"","");
        s2=s2.replaceAll("\"","");
        if(s1.indexOf(s2)!=-1){
            return "\""+s1.substring(s1.indexOf(s2))+"\"";
        }else{
            return  "\""+ "\"";
        }
    }

    static String reverse(String s){
        s=s.replaceAll("\"","");
        StringBuilder sb=new StringBuilder();
        char[] chars=s.toCharArray();
        for(int i=chars.length-1;i>=0;i--){
            sb.append(chars[i]);
        }
        return "\""+sb.toString()+"\"";
    }

    static String combine(List<String> l){
        StringBuilder sb=new StringBuilder();
        for(int i=l.size()-1;i>=0;i--){
            String s=(l.get(i)).replaceAll("\"","");
            sb.append(s);
        }
        return "\""+sb.toString()+"\"";
    }
}

