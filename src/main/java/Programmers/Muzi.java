package Programmers;

import java.util.*;

public class Muzi   {
    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        //String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] id_list = {"con", "ryan"};
        //String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
        int[] answer = solution36.solution(id_list,report,k);
        for(int i : answer)
            System.out.println(i);
    }
}

class Solution36{
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String id : id_list)
        {
            map.put(id, 0);
        }
        Set<String> set = new HashSet<>(Arrays.asList(report));
        int m = 0;
        String[] newReport = new String[report.length];
        for(String st: set) {
            newReport[m++] = st;
        }
        for (String rep : newReport) {
            if(rep != null)
            map.put(rep.split(" ")[1], map.get(rep.split(" ")[1]) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("map = " + map);

        Map<String, List<String>> map_com = new HashMap<String, List<String>>();
        for(String str : id_list) {
            List<String> val = new ArrayList<>();
            for(String rep : newReport) {
                if(rep == null){
                    break;
                }
                    if(rep.split(" ")[0].equals(str)) {
                        val.add(rep.split(" ")[1]);
                    }
            }
            map_com.put(str, val);
        }

        for(String st: map_com.keySet()) {
            int count = 0;
            for(String lis : map_com.get(st)) {
                if(map.get(lis) == k) {
                    count++;
                }
            }
            list.add(count);
        }
        Collections.sort(list, Collections.reverseOrder());
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}