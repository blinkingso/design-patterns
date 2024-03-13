import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 设计模式原则：
 * 1. 单一职责： 比如定一个验证数据类型的接口， 具体的实现类包含了邮箱验证类，手机号码， 身份证验证类等多个类。 每个类实现独立的功能，易于扩展。
 * 2. 开闭原则： 对扩展开放，对修改关闭。
 * 3. 里氏替换： 子类不复写父类的方法实现， 以实现更好的扩展。
 * 4. 迪米特法则： 两个类之间减少关联性，实现松耦合。
 * 5. 接口隔离原则： 将接口拆分， 不是每一个类都需要实现接口中所有的方法。 包含太多方法的接口不易于扩展。
 * 6. 依赖倒置原则：DI
 */
public class DesignPatternPrinciples {

    public static void main(String[] args) {
        System.out.println(new EmailValidator().validate("7142@qq.com"));
        System.out.println(new MobileValidator().validate("182"));
        System.out.println(new NotEmptyValidator().validate(null));
        double area = new DefaultCalculationArea().circular(1.1);
        System.out.println(area);
        double area2 = new DefaultCalculationAreaExt().circular(1.1);
        System.out.println(area2);
        Principal principal = new Principal();
        Map<String, Object> info = principal.queryClazzInfo("高三1班");
        System.out.println(info);

        List<BetUser> users = Stream.of(
                new BetUser("u0", 0),
                new BetUser("u3", 3),
                new BetUser("u4", 4),
                new BetUser("u01", 1),
                new BetUser("u8", 8),
                new BetUser("u2", 2),
                new BetUser("u1", 1))
                .collect(Collectors.toList());
        DrawController control = new DrawController();
        List<BetUser> user1 = control.draw(new RandomDrawUsers(), users, 3);
        System.out.println(user1);
        List<BetUser> user2 = control.draw(new WeightRandomUsers(), users, 3);
        System.out.println(user2);
    }
}

/**
 * 单一职责： Validator
 * 1. EmailValidator
 * 2. MobileValidator
 * 3. NotEmptyValidator
 * ...
 */
@FunctionalInterface
interface Validator<T> {
    /**
     * 验证数据的有效性，并返回错误信息
     * 
     * @return
     */
    String validate(T value);
}

class EmailValidator implements Validator<String> {
    @Override
    public String validate(String value) {
        return "your email is not valid: " + value;
    }
}

class MobileValidator implements Validator<String> {
    @Override
    public String validate(String value) {
        return null;
    }
}

class NotEmptyValidator implements Validator<String> {
    @Override
    public String validate(String value) {
        if (null == value || value.isBlank()) {
            return "cannot be empty";
        } else {
            return null;
        }
    }
}

/**
 * 开闭原则， 对修改关闭， 对扩展开放。通过继承父类需要扩展的方法，同时保留了原方法。
 * 这里计算圆形的面积，如果修改了PI的精度， 那么结果会有所不同， 所以当需要降低精度
 * 进行计算时，可以继承原有的父类，修改PI值完成精度修改需求， 而不是修改父类中PI的值，
 * 这样可以保证使用原精度计算的逻辑不会出现精度问题，又可以实现新的需求。
 */
interface ICalculationArea {

    double rectangle(double x, double y);

    /**
     * 三角形面积
     * 
     * @param x 边长x
     * @param y 边长y
     * @param z 边长z
     * @return
     */
    double triangle(double x, double y, double z);

    /**
     * 圆形面积
     * 
     * @param r
     * @return
     */
    double circular(double r);
}

class DefaultCalculationArea implements ICalculationArea {

    @Override
    public double rectangle(double x, double y) {
        return x * y;
    }

    @Override
    public double triangle(double x, double y, double z) {
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    @Override
    public double circular(double r) {
        return Math.PI * r * r;
    }
}

/**
 * 扩展圆形面积计算方法， 修改PI的值为3.14
 */
class DefaultCalculationAreaExt extends DefaultCalculationArea {
    private static final double PI = 3.14D;

    @Override
    public double circular(double r) {
        return PI * r * r;
    }
}

/**
 * 里氏替换原则： 不常用。 满足开闭原则的条件。
 * 同时，保障子类不能复写父类的方法，如果重载的化，那么入参要宽松，而返回值要
 * 限制的更严格或者和父类保持一致。
 * 一般尽量减少类的继承。
 */
abstract class BankCard {
    private static final Logger logger = Logger.getLogger(BankCard.class.getName());
    private String cardNo;
    private String cardDate;

    protected BankCard(String cardNo, String cardDate) {
        this.cardNo = cardNo;
        this.cardDate = cardDate;
    }

    abstract boolean rule(BigDecimal amount);

    public int increment(String orderId, BigDecimal amount) {
        logger.info(() -> "卡号： " + cardNo + "入账成功， 订单号： " + orderId + ", 金额： " + amount + "元");
        return 0;
    }

    public int decrement(String orderId, BigDecimal amount) {
        logger.info(() -> "卡号： " + cardNo + "出款成功， 订单号: " + orderId + ", 金额： " + amount + "元");
        return 0;
    }

    // 交易流水
    public List<String> getTradeFlow() {
        return Stream.of("10001,100.0", "10002,1000.1", "10002,78.9")
                .collect(Collectors.toList());
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public String getCardDate() {
        return this.cardDate;
    }
}

/**
 * 里氏替换原则： 子类实现抽象类，并实现抽象方法。
 * 但不覆写父类的普通方法
 */
class CashCard extends BankCard {

    private static final Logger logger = Logger.getLogger(CashCard.class.getName());

    public CashCard(String cardNo, String cardDate) {
        super(cardNo, cardDate);
    }

    @Override
    boolean rule(BigDecimal amount) {
        return true;
    }

    public int withdraw(String orderId, BigDecimal amount) {
        logger.info(() -> "提现成功， 单号： " + orderId + ", 金额" + amount);
        return super.decrement(orderId, amount);
    }

    public int recharge(String orderId, BigDecimal amount) {
        logger.info(() -> "存款成功， 单号： " + orderId + ", 金额" + amount);
        return super.increment(orderId, amount);
    }

    /**
     * 模拟风控校验
     * 
     * @param cardNo
     * @param orderId
     * @param amount
     * @return
     */
    public boolean checkRisk(String cardNo, String orderId, BigDecimal amount) {
        logger.info(() -> "风控验证： 卡号： " + cardNo + ", 订单号: " + orderId + ", 金额: " + amount);
        return true;
    }
}

/**
 * 里氏替换原则：
 * 信用卡模拟: 可以继承BankCard抽象类也可以继承CashCard储蓄卡类。
 * 但都不能变更原父类的相关方法
 */
class CreditCard extends CashCard {

    public CreditCard(String cardNo, String cardDate) {
        super(cardNo, cardDate);
    }

    /**
     * 贷款金额限制, 这里不覆写CashCard的rule方法，保证CreditCard类可以完成
     * BankCard类的所有功能正常。
     * 
     * @param amount
     * @return
     */
    public boolean rule2(BigDecimal amount) {
        return amount.compareTo(new BigDecimal(1000)) <= 0;
    }
}

/**
 * 迪米特法则： 类之间保持最少的关联， 也就是松耦合。
 */
class Student {
    private String name;
    private double score;
    private int rank;

    public Student(String name, double score, int rank) {
        this.name = name;
        this.score = score;
        this.rank = rank;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", score=" + score + ", rank=" + rank + "]";
    }
}

class Teacher {
    private String name;
    private String clazz;
    private static final List<Student> students = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    static {
        students.add(new Student("yz", 100.0, 1));
        students.add(new Student("yz1", 99.0, 3));
        students.add(new Student("yz2", 99.1, 2));
        students.add(new Student("yz3", 98.0, 4));
        students.add(new Student("yz4", 90.0, 8));
    }

    public static List<Student> getStudent() {
        return students;
    }

    public String getName() {
        return this.name;
    }

    public String getClazz() {
        return this.clazz;
    }

    public double totalScore() {
        return students.stream().map(Student::getScore)
                .reduce(0.0, (acc, score) -> acc + score);
    }

    public double averageScore() {
        double totalScore = totalScore();
        return totalScore / students.size();
    }

    public int clazzStudentCount() {
        return students.size();
    }

}

class Principal {
    private final Teacher teacher = new Teacher("hh", "高三1班");

    public Map<String, Object> queryClazzInfo(String clazz) {
        System.out.println("要查询的班级为： " + clazz);
        int studentsCount = teacher.clazzStudentCount();
        double totalScore = teacher.totalScore();
        double averageScore = teacher.averageScore();

        Map<String, Object> info = new HashMap<>();
        info.put("班级", teacher.getClazz());
        info.put("老师姓名", teacher.getName());
        info.put("学生人数", studentsCount);
        info.put("班级总分数", totalScore);
        info.put("平均分数", averageScore);

        return info;
    }
}

/**
 * 接口隔离原则： 最典型的例子， 针对支付接口上的查询和下单进行分开抽象。
 * 将接口拆分为多个独立的接口实现不同的功能，这样可以为实现类提供定制化的服务。
 * 按需实现对应的接口，而不需要实现一些无用的功能。
 */
interface DotaSkills {

    /**
     * 喷火技能
     */
    void fire();

    /**
     * 眩晕技能
     */
    void vertigo();

    /**
     * 标记
     */
    void biao();

    /**
     * 被动技能
     */
    void bd();
}

/**
 * Pa这个英雄只有标记和被动 没有眩晕和喷火技能。这样导致实现无用的接口
 */
class Pa implements DotaSkills {

    @Override
    public void fire() {
        throw new UnsupportedOperationException("Unimplemented method 'fire'");
    }

    @Override
    public void vertigo() {
        throw new UnsupportedOperationException("Unimplemented method 'vertigo'");
    }

    @Override
    public void biao() {
        throw new UnsupportedOperationException("Unimplemented method 'biao'");
    }

    @Override
    public void bd() {
        throw new UnsupportedOperationException("Unimplemented method 'bd'");
    }
}

/**
 * 接口隔离原则： 按功能拆分单一功能的接口, 或者共性接口
 */
interface IFire {
    void fire();
}

interface IBiao {
    void biao();
}

/**
 * 通过这种接口拆分， 防止子类实现无用的功能。
 */
class Pa2 implements IFire, IBiao {

    @Override
    public void biao() {
        System.out.println("Pa 的标记技能");
    }

    @Override
    public void fire() {
        System.out.println("Pa 的被动技能");
    }

}

/**
 * DI: 依赖倒置
 */
class BetUser {
    private String username;
    private int weight;

    public BetUser(String username, int weight) {
        this.username = username;
        this.weight = weight;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BetUser [username=" + username + ", weight=" + weight + "]";
    }
}

interface IDraw {

    List<BetUser> randomUsers(List<BetUser> userList, int count);
}

class RandomDrawUsers implements IDraw {

    @Override
    public List<BetUser> randomUsers(List<BetUser> users, int count) {
        Collections.shuffle(users);
        return users.stream().limit(count)
                .toList();
    }
}

class WeightRandomUsers implements IDraw {
    @Override
    public List<BetUser> randomUsers(List<BetUser> userList, int count) {
        Collections.sort(userList, (u1, u2) -> u2.getWeight() - u1.getWeight());
        return userList.stream().limit(count).toList();
    }
}

class DrawController {

    public List<BetUser> draw(IDraw draw, List<BetUser> users, int count) {
        return draw.randomUsers(users, count);
    }
}