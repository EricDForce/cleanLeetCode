import java.util.*;

/**
 * Created by eric-d on 2017/6/22.
 */
public class WordLadderII {
    public static void main(String[] args){
        String beginWord = "hot";
        String endWord = "dog";
//        String[] wordList = {"hot","dog","dot"};
        List<String> wordList = new ArrayList<>();

        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");
        if (wordList.contains(beginWord)){
            wordList.remove(beginWord);
        }
        System.out.println(new WordLadderII().findLadders(beginWord, endWord, wordList));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        List<String> res = new ArrayList<>();
//        res.add(beginWord);
        helper(beginWord, endWord, wordList, result);
        return result;
    }

    public void helper(String beginWord, String endWord, List<String> wordList, List<List<String>> result){
        Queue<String> queue = new LinkedList<>();
        HashMap<String, String> preMap = new HashMap<>();
        boolean minLength = true;
        preMap.put(beginWord, "start");
        int l1 = beginWord.length();
        queue.offer(beginWord);
        if (wordList.contains(beginWord)){
            wordList.remove(beginWord);
        }
        String last = beginWord, lastmp = beginWord;
        while (!queue.isEmpty()){
            String current = queue.poll();
            char[] t1 = current.toCharArray();
            for (int i=0;i<l1;i++){
                char t2 = t1[i];
                for (char c='a';c<='z';c++){
                    if (t1[i] != c){
                        t1[i] = c;
                        String tmp = new String(t1);
                        if (wordList.contains(tmp)){
                            preMap.put(tmp, current);
                            if (tmp.equals(endWord)){
                                minLength = false;
                                List<String> res = new ArrayList<>();
                                String iter = endWord;
                                while (true){
                                    res.add(0, iter);
                                    iter = preMap.get(iter);
                                    if (iter.equals("start"))
                                        break;
                                }
                                result.add(res);
                            }
                            if (!tmp.equals(endWord)){
                                wordList.remove(tmp);
                                queue.offer(tmp);
                            }
                            lastmp = tmp;
                        }
                    }
                }
                t1[i] = t2;
            }
            if (current.equals(last))
            {
                if (!minLength){   //说明已经找到最短的词语了
                    break;
                }
                last = lastmp;
            }
        }
    }
}
