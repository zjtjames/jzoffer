/**
 * Created by Zheng Jiateng on 2019/3/9.
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符: 注意 HashMap不保持key的顺序 而LinkedHashMap保持key的顺序
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        LinkedHashMap<Character, Integer> map1 = new LinkedHashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map1.containsKey(chars[i])) {
                map1.put(chars[i], map1.get(chars[i]) + 1);
            } else {
                map1.put(chars[i], 1);
                map2.put(chars[i], i);
            }
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1) {
                return map2.get(entry.getKey());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('g', 1);
        map.put('o', 1);
        map.put('o', 2);
        map.put('g', 2);
        map.put('l', 1);
        map.put('e', 1);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
