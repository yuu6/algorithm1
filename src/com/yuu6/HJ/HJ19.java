package com.yuu6.HJ;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: yuu6
 * @Date: 2022/05/28/下午9:15
 */
public class HJ19 {
    public static void main(String[] args) {
        Scanner in=  new Scanner(System.in);
        Map<String, Integer> resMap = new HashMap<>();
        Map<String, Integer> rowMap = new HashMap<>();
        Map<String, Integer> presentMap = new HashMap<>();
        int i = 0;
        while (in.hasNext()){
            String nextStr = in.next();
            Integer num = in.nextInt();
            Integer index = nextStr.lastIndexOf('\\');
            String tempStr = nextStr.substring(index + 1);

            if (tempStr.length() > 16){
                tempStr = tempStr.substring(tempStr.length() - 16);
            }
            tempStr = tempStr +"_"+ num;
            if (resMap.containsKey(tempStr)){
                resMap.put(tempStr, resMap.get(tempStr) + 1);
            }else{
                resMap.put(tempStr, 1);
            }
            rowMap.put(tempStr, num);
            if (!presentMap.containsKey(tempStr)) {
                presentMap.put(tempStr, i);
            }
            i++;
        }

        List<Map.Entry> res = presentMap.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        }).collect(Collectors.toList());


        if (res.size() > 8){
            for (int j = res.size() - 8; j < res.size(); j++) {
                String key = (String) res.get(j).getKey();
                System.out.println(key.split("_")[0] +" "+ rowMap.get(key) +" "+ resMap.get(key));
            }
        }else{
            for (int j = 0; j < res.size(); j++) {
                String key = (String) res.get(j).getKey();
                System.out.println(key.split("_")[0] +" "+ rowMap.get(key) +" "+ resMap.get(key));
            }
        }
//        cqvvntsgt 629 1
//        ervybtevxbzg 643 1
//        ruyikv 633 1
//        mvymns 628 1
//        klxxlxwcfkxfzoww 633 1
//        mvymns 639 1
//        ruyikv 640 1
//        xgsgwlkrp 633 1

    }
}
