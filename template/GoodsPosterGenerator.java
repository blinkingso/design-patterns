package template;

import java.util.Map;

public abstract class GoodsPosterGenerator {
    String uId;
    String uPwd;

    public GoodsPosterGenerator(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    /**
     * 生成商品推广海报
     *
     * @param skuUrl 商品地址
     * @return 海报图片信息base64
     */
    public String generateGoodsPoster(String skuUrl) {
        if (!login(uId, uPwd)) return null;
        Map<String, String> pc = pa(skuUrl);
        return createBase64(pc);
    }


    protected abstract boolean login(String uId, String uPwd);

    protected abstract Map<String, String> pa(String skuUrl);

    protected abstract String createBase64(Map<String, String> goodsInfo);

}
