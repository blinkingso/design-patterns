package prototype;

import java.util.Map;

public class Topic {
    public Topic(Map<Select, String> option, Select key) {
        this.option = option;
        this.key = key;
    }

    private Map<Select, String> option;
    private Select key;

    public Map<Select, String> getOption() {
        return option;
    }

    public void setOption(Map<Select, String> option) {
        this.option = option;
    }

    public Select getKey() {
        return key;
    }

    public void setKey(Select key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "option=" + option +
                ", key=" + key +
                '}';
    }
}
