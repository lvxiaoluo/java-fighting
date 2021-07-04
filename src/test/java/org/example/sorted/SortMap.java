package org.example.sorted;

/**
 * @author lvle
 * @date 2021-06-25 00:28
 */
import java.util.*;
import java.util.Map.Entry;

public class SortMap {
    public static void main(String[] args) {
        Map map=new TreeMap ();
        map.put("图书" , 4);
        map.put("音像" , 6);
        map.put("素材" , 9);
        map.put("音乐" , 8);
        map.put("影视" , 7);
        map.put("动漫" , 4);
        map.put("歌曲" , 3);
        map.put("图片" , 2);
        map.put("图标" , 6);
        ArrayList<Map.Entry<String,Integer>> entries= sortMap(map);
        for( int i=0;i<5;i++){
            System. out.print(entries.get(i).getKey()+":" +entries.get(i).getValue());
        }
    }
    public static ArrayList<Map.Entry<String,Integer>> sortMap(Map map){
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        ArrayList<Entry<String, Integer>> entries1 = new ArrayList<>(set);
        for (Entry<String, Integer> stringIntegerEntry : set) {
            System.out.println(stringIntegerEntry.getKey());
            System.out.println(stringIntegerEntry.getValue());
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
//        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
//            public int compare(Map.Entry<String, Integer> obj1 , Map.Entry<String, Integer> obj2) {
//                return obj2.getValue() - obj1.getValue();
//            }
//        });
        Collections.sort(entries, (obj1, obj2) -> obj2.getValue() - obj1.getValue());
        return (ArrayList<Entry<String, Integer>>) entries;
    }
}