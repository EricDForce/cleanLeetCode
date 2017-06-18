/**
 * Created by eric-d on 2017/1/26.
 */
import java.util.*;
public class Wordladder2 {
    public static void main(String[] args)
    {
        String begin = "hot";
        String end = "dog";
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
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
        Map<String, String> preString = new HashMap<>();
        preString.put(beginWord, "start");
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
        while (!queue.isEmpty())
        {
            char[] current = queue.poll().toCharArray();
            String tt = new String(current);
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
                        preString.put(str, tt);
                        System.out.println("str: "+ str);
                        if (str.equals(endWord))
                        {
                            List<String> ret = new ArrayList<>();
                            ret.add(0, endWord);
                            minLength = false;
                            String st = tt;
                            ret.add(0, st);
                            while (true){
                                System.out.println("st: "+st);
                                st = preString.get(st);
                                if (st.equals("start"))
                                    break;
                                ret.add(0, st);
                            }
                            res.add(ret);
                        }
                        if (!str.equals(endWord)){
                            wordList.remove(str);
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
                last = lasttmp;
            }
        }
        return res;
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
