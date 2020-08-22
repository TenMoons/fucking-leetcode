import java.util.HashMap;

/**
 * 面试题 17.07. 婴儿名字
 */

public class Solution_1707 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        HashMap<String, String> ufMap = new HashMap<>();
        for (String name : names) {
            int index1 = name.indexOf('(');
            int index2 = name.length() - 1;
            int freq = Integer.parseInt(name.substring(index1 + 1, index2));
            freqMap.put(name.substring(0, index1), freq);  // 统计频率
        }
        for (String synonym : synonyms) {
            int index = synonym.indexOf(',');
            String name1 = synonym.substring(1, index);
            String name2 = synonym.substring(index + 1, synonym.length() - 1);
            // 找name1的祖先
            while (ufMap.containsKey(name1))
                name1 = ufMap.get(name1);
            // 找name2的祖先
            while (ufMap.containsKey(name2))
                name2 = ufMap.get(name2);
            if (!name1.equals(name2)) {
                // 更新频率
                int freq = freqMap.getOrDefault(name1, 0) + freqMap.getOrDefault(name2, 0);
                // name1的字典序更小
                if (name1.compareTo(name2) < 0) {
                    ufMap.put(name2, name1);
                    freqMap.remove(name2);
                    freqMap.put(name1, freq);
                } else {
                    ufMap.put(name1, name2);
                    freqMap.remove(name1);
                    freqMap.put(name2, freq);
                }
            }
        }
        String[] res = new String[freqMap.size()];
        int index = 0;
        for (String name : freqMap.keySet()) {
            StringBuilder sb = new StringBuilder(name);
            sb.append('(').append(freqMap.get(name)).append(')');
            res[index++] = sb.toString();
        }
        return res;
    }
}
