package visitor.user;

import visitor.User;
import visitor.Visitor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Teacher extends User {
    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
