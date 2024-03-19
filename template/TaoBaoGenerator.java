package template;

import java.util.Map;

public class TaoBaoGenerator extends GoodsPosterGenerator {
    public TaoBaoGenerator(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected boolean login(String uId, String uPwd) {
        return false;
    }

    @Override
    protected Map<String, String> pa(String skuUrl) {
        return null;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        return null;
    }
}
