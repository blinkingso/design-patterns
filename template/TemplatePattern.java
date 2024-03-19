package template;

/**
 * Spring中bean的初始化最典型的模式
 */
public class TemplatePattern {
    public static void main(String[] args) {
        GoodsPosterGenerator generator = new JdGenerator("a", "b");
        String post = generator.generateGoodsPoster("http://jd.com/item/a");
        if (null == post) {
            System.out.println("海报生成失败。。");
        } else {
            System.out.println("海报生成成功: " + post);
        }
    }
}
