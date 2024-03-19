package visitor.visitor;

import visitor.Visitor;
import visitor.user.Student;
import visitor.user.Teacher;

public class Principle implements Visitor {
    @Override
    public void visit(Teacher teacher) {
        System.out.println("校长关注教师所在班级的升学率： " + teacher.entranceRatio());
    }

    @Override
    public void visit(Student student) {
        System.out.println("校长关注学生姓名： " + student.getName());
    }
}
