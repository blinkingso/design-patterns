package visitor.visitor;

import visitor.Visitor;
import visitor.user.Student;
import visitor.user.Teacher;

public class Parent implements Visitor {
    @Override
    public void visit(Teacher teacher) {
        System.out.println("家长关注老师的级别： " + teacher.getIdentity());
    }

    @Override
    public void visit(Student student) {
        System.out.println("家长关注学生的排名: " + student.ranking());
    }
}
