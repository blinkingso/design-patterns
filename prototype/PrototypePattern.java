package prototype;

import java.util.HashMap;

/**
 * 原型模式： clone, 针对大量重复对象的克隆，减少db查询次数的。 不常用。
 */
public class PrototypePattern {
    public static void main(String[] args) {
        final HashMap<Select, String> whyRust = new HashMap<>();
        whyRust.put(Select.A, "good");
        whyRust.put(Select.B, "Easy to use");
        whyRust.put(Select.C, "Amazing using");
        whyRust.put(Select.D, "easy to learn");
        final HashMap<Select, String> math = new HashMap<>();
        math.put(Select.A, "三角形不具有稳定性");
        math.put(Select.B, "圆周率最早是中国发明的");
        math.put(Select.C, "多边形具有稳定性");
        math.put(Select.D, "关系型数学是趋势");
        QuestionBank a1 = new QuestionBank("Yaphets", "A123")
                .append(new AnswerQuestion("why rust?", "Because of rust"))
                .append(new AnswerQuestion("Why spring?", "maybe generic using in china"))
                .append(new ChoiceQuestion("Why using rust?", whyRust, Select.A))
                .append(new ChoiceQuestion("有关数学的说法正确的是?", math, Select.B));
        System.out.println(a1.toString());
        System.out.println("==================================================");
        final QuestionBank a2 = a1.clone();
        a2.setCandidate("mu");
        a2.setNumber("Bc123123");
        System.out.println(a2.toString());
        System.out.println("==================================================");
        final QuestionBank a3 = a1.clone();
        a3.setNumber("cj000");
        a3.setCandidate("huahua");
        System.out.println(a3.toString());

    }
}
