package template;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JdGenerator extends GoodsPosterGenerator {
    public JdGenerator(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected boolean login(String uId, String uPwd) {
        System.out.println("模拟京东登陆");
        return true;
    }

    @Override
    protected Map<String, String> pa(String skuUrl) {
        Map<String, String> urls = new ConcurrentHashMap<>();
        urls.put("name", "手机");
        return urls;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        return "京东海报信息....";
    }
}
