/**
 * Created by eric-d on 2017/1/26.
 */
import java.util.*;
public class Wordladder2 {
    public static void main(String[] args)
    {
        String[] tt = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String end = "cog";
        Set<String> wordList = new HashSet<>();
        for (String str : tt){
            wordList.add(str);
        }
        List<List<String>> it = new Wordladder2().findLadders(begin, end, wordList);
        for (List<String> iter : it)
        {
            for (String str : iter)
            {
                System.out.println(str);
            }
            System.out.println("---------------------");
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<String> result = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> preString = new HashMap<>();
        List<String> start = new ArrayList<>();
        start.add("start");
        preString.put(beginWord, start);
        if (wordList.contains(beginWord))
        {
            wordList.remove(beginWord);
        }
        boolean minLength = true;
        if(getDis(beginWord, endWord) == 1)
        {
            result.add(beginWord);
            result.add(endWord);
            res.add(result);
            return  res;
        }

        int len = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        String last = beginWord;
        String lasttmp = beginWord;
        List<String> stay = new ArrayList<>();
        while (!queue.isEmpty())
        {
            char[] current = queue.poll().toCharArray();
            String tt = new String(current);
            stay.add(tt);
            System.out.println("current:" + tt);
            for (int i=0;i<len;i++)
            {
                char tmp = current[i];
                for (char j='a';j<='z';j++)
                {
                    if (tmp == j)
                        continue;
                    current[i] = j;
                    String str = new String(current);

                    if (wordList.contains(str))
                    {
                        if (preString.containsKey(str)){
                            preString.get(str).add(tt);
                        }else{
                            List<String> strList = new ArrayList<>();
                            strList.add(tt);
                            preString.put(str, strList);
                        }
                        System.out.println("str: "+ str);
                        if (str.equals(endWord))
                        {
                            List<List<String>> ttt = new ArrayList<>();
                            List<String> ret = new ArrayList<>();
                            ret.add(0, endWord);
                            ret.add(0, tt);
                            minLength = false;
                            getPemutation(preString, ttt, ret, tt);
                            res.addAll(ttt);
                        }
                        if (!str.equals(endWord)){
//                            wordList.remove(str);
                            queue.offer(str);
                        }
                        lasttmp = str;
                    }
                }
                current[i] = tmp;
            }

            if (new String(current).equals(last))
            {
                if (!minLength){
                    break;
                }
                for (String str : stay){
                    wordList.remove(str);
                }
                stay.clear();
                last = lasttmp;
            }
        }
        return res;
    }

    public void getPemutation(Map<String, List<String>> preString, List<List<String>> list, List<String> tmp, String begin){
        for (String str : preString.get(begin)){
            System.out.println("------------str : " + str);
            if (str.equals("start"))
            {
                List<String> strList = new ArrayList<>();
                System.out.println("-------------"+ tmp + "--------------");
                strList.addAll(tmp);
                list.add(strList);
                return ;
            }else
            {
                tmp.add(0, str);
                getPemutation(preString, list, tmp, str);
                tmp.remove(str);
            }
        }
    }

    public int getDis(String str1, String str2)
    {
        int len = str1.length();
        int cnt = 0;

        for(int i=0;i<len;i++)
        {
            if(str1.charAt(i) != str2.charAt(i))
            {
                cnt++;
            }
        }
        return cnt;
    }
}
