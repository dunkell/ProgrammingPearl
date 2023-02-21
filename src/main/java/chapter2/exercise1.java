package chapter2;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考虑查找给定输入单词的所有变位词问题。
 * 仅给定单词和字典的情况下，如何解决该问题？
 * 如果有一些时间和空间可以在响应任何查询之前预先处理字典，又会如何？
 */

public class exercise1 {
    public static void main(String[] args) {
        //生成数据
        List<String> wordList = util.wordsGenerate();

        Map<String, List<String>> map = new HashMap<>();

        //遍历数据，放入map中
        for (String s : wordList) {
            String label = labelGenerate(s);
            List<String> list = map.get(label);
            if(list == null){
                list = new ArrayList<>();
                map.put(label,list);
            }
            list.add(s);
        }

        //打印结果
        for (Map.Entry<String,List<String>> entry : map.entrySet()){
            System.out.println("key: " + entry.getKey() + ",value: " + entry.getValue());
        }

    }

    /**
     * 生成标签
     * @param str
     * @return
     */
    public static String labelGenerate(String str){
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        String label = "";
        for (int i = 0; i < 26; i++) {
            if(arr[i] == 0){
            }else{
                label += "" + (char)(i+97) + arr[i];
            }
        }

        return label;
    }

}
