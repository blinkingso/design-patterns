package decorator;

/**
 * 装饰器模式： 在不改变原有类的功能的前提下，进行功能扩展。通过持有原功能的实例，进行扩展。
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        // false
        boolean success = new LoginSSODecorator(new SSOInterceptor()).preHandle("asuccesshuahuxa", "response", new Object());
        System.out.println(success ? "验证通过" : "验证失败");
        // true
        boolean s = new LoginSSODecorator(new SSOInterceptor()).preHandle("asuccesshuahua", "response", new Object());
        System.out.println(s ? "验证通过" : "验证失败");
    }
}
