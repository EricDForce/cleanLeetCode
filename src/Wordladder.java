import java.util.*;

/**
 * Created by eric-d on 2017/1/18.
 */
public class Wordladder {
    public static void main(String[] args)
    {
        String str1 = "hot";
        String str2 = "dog";
        Set<String>  wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("cog");
        wordList.add("dog");
        wordList.add("tot");
        wordList.add("hog");
        wordList.add("hop");
        wordList.add("pot");
        wordList.add("dot");

        System.out.println(new Wordladder().getLadderLength(str1, str2, wordList));
    }


    public int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {

        if (beginWord == null || endWord == null || beginWord.equals(endWord)
                || beginWord.length() != endWord.length())
            return 0;

        if (getDis(beginWord, endWord) == 1)
            return 2;

        Queue<String> queue=new LinkedList<String>();
        HashMap<String,Integer> dist=new HashMap<>();

        queue.add(beginWord);
        dist.put(beginWord, 1);

        while(!queue.isEmpty())
        {
            char[] head=queue.poll().toCharArray();

            int headDist = dist.get(new String(head));
            //从每一个位置开始替换成a~z
            for(int i=0;i<head.length;i++)
            {
                char tmp = head[i];
                for(char j='a';j<='z';j++)
                {
                    if(head[i]==j) continue;

                    head[i] = j;

                    String str = new String(head);
                    if(str.equals(endWord)) return headDist+1;

                    if(wordList.contains(str)&&!dist.containsKey(str))
                    {
                        queue.add(str);
                        dist.put(str, headDist+1);
                    }
                }
                head[i] = tmp;
            }
        }

        return 0;

    }

    public int getLadderLength(String beginWord, String endWord, Set<String> wordList)
    {
        if(getDis(beginWord, endWord) == 1)
        {
            return 2;
        }
        int len = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        String last = beginWord;
        String lasttmp = beginWord;
        int cnt = 1;
        while (!queue.isEmpty())
        {
            char[] current = queue.poll().toCharArray();

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
                        if (str.equals(endWord))
                        {
                            cnt++;
                            return cnt;
                        }
                        queue.offer(str);
                        wordList.remove(str);
                        lasttmp = str;
                    }
                }
                current[i] = tmp;
            }

            if (new String(current).equals(last))
            {
                cnt++;
                last = lasttmp;
            }
        }
        return 0;
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
