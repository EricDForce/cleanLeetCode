import java.util.*;

public class silunbeixie {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m=sc.nextInt();
        int[] dp = new int[n+1];
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int i=0; i<m; i++){
            int t1 = sc.nextInt(), t2 = sc.nextInt();
            if (!map1.containsKey(t1)){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(t2);
                map1.put(t1, tmp);
            }else{
                map1.get(t1).add(t2);
            }
            if (!map1.containsKey(t2)){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(t1);
                map1.put(t2, tmp);
            }else{
                map1.get(t2).add(t1);
            }
        }
        int max = -1;
        for (int i=1; i<=n; i++) {
            Map<Integer, List<Integer>> map = new HashMap<>(map1);
            int[] dp1 = new int[1];
            dp1[0] = 1;
            getNumber(map, i, dp1);
            max = Math.max(max, dp1[0]);
        }
        System.out.println(max);
    }

    public static void getNumber(Map<Integer, List<Integer>> map, int t, int[] dp){
            for (int iter2 : map.get(t)) {
                if (map.get(iter2).size() == 1) {
                    dp[0]++;
                }else if (map.get(iter2).size() == 2){
                    dp[0]++;
                    if (map.get(iter2).get(0) != t){
                        getNumber(map, map.get(iter2).get(0), dp);
                    }
                    if (map.get(iter2).get(1) != t){
                        getNumber(map, map.get(iter2).get(0), dp);
                    }
                }
            }
        }
    }
