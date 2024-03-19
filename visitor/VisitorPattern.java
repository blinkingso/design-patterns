package visitor;

import visitor.user.Student;
import visitor.user.Teacher;
import visitor.visitor.Parent;
import visitor.visitor.Principle;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式: 在一个稳定的数据结构下，如何增加易变的
 * 业务访问逻辑。
 */
public class VisitorPattern {
    public static void main(String[] args) {
        final List<User> users = new ArrayList<>();
        users.add(new Student("ya", "实验班", "高三一班"));
        users.add(new Teacher("goo", "特级教师", "高三一班"));

        show(users, new Parent());
        System.out.println("-------------------");
        show(users, new Principle());
    }

    static void show(List<User> users, Visitor visitor) {
        users.forEach(u -> u.accept(visitor));
    }
}
