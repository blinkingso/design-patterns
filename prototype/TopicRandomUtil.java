package prototype;

import java.util.*;

public class TopicRandomUtil {

    public static Topic random(Map<Select, String> option, Select key) {
        final Set<Select> keys = option.keySet();
        Map<Select, String> optionNew = new HashMap<>(option.size());
        final List<Select> keyList = new ArrayList<>(keys);
        Collections.shuffle(keyList);
        int idx = 0;
        Select newKey = null;
        for (Select currentKey : keys) {
            Select randomKey = keyList.get(idx);
            idx++;
            if (key.equals(currentKey)) {
                // 答案
                newKey = randomKey;
            }
            // 选项对应的内容
            optionNew.put(randomKey, option.get(currentKey));
        }
        return new Topic(optionNew, newKey);
    }

    public static void main(String[] args) {
        Map<Select, String> option = new HashMap<>();
        option.put(Select.A, "Java");
        option.put(Select.B, "Python");
        option.put(Select.C, "Rust");
        option.put(Select.D, "Javascript");
        Topic topic = TopicRandomUtil.random(option, Select.C);
        System.out.println(topic);
    }
}
