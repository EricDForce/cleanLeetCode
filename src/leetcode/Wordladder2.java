/**
 * Created by eric-d on 2017/1/26.
 */
import java.util.*;
public class Wordladder2 {
    public class Node {
        public int dist;
        public String str;
        public LinkedList<Node> prev;

        public Node(int dist, String str) {
            this.dist = dist;
            this.str = str;
            this.prev = new LinkedList<Node>();
        }

        public void addPrev(Node pNode) {
            prev.add(pNode);
        }
    }
    public static void main(String[] args)
    {
        String[] tt ={"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        String begin = "qa";
        String end = "sq";
        Set<String> wordList = new HashSet<>();
        for (String str : tt){
            wordList.add(str);
        }
        List<List<String>> it = new Wordladder2().findLadders(begin, end, wordList);
        Collections.sort(it, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                for (int i=0;i<o1.size();i++){
                    if (o1.get(i).equals(o2.get(i))){
                        continue;
                    }else{
                        return o1.get(i).compareTo(o2.get(i));
                    }
                }
                return 0;
            }
        });
        System.out.println(it);
    }
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<String> result = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<String>> preString = new HashMap<>();
        Set<String> start = new HashSet<>();
        start.add("start");
        preString.put(beginWord, start);

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
            if (tt.equals(endWord))
            {
                List<String> ret = new ArrayList<>();
                ret.add(0, tt);
                getPemutation(preString, res, ret, tt);
                return res;
            }
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
                            Set<String> strList = new HashSet<>();
                            strList.add(tt);
                            preString.put(str, strList);
                        }
                        stay.add(str);
                        queue.offer(str);

                        lasttmp = str;
                    }
                }
                current[i] = tmp;
            }

            if (new String(current).equals(last))
            {
                for (String str : stay){
                    wordList.remove(str);
                }
                stay.clear();
                last = lasttmp;
            }
        }
        return res;
    }

    public void getPemutation(Map<String, Set<String>> preString, List<List<String>> list, List<String> tmp, String begin){
        for (String str : preString.get(begin)){
//            System.out.println("------------str : " + str);
            if (str.equals("start"))
            {
                List<String> strList = new ArrayList<>();
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
