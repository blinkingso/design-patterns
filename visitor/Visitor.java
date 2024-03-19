package visitor;

import visitor.user.Student;
import visitor.user.Teacher;

public interface Visitor {

    void visit(Teacher teacher);
    void visit(Student student);
}
