package builder;

import java.math.BigDecimal;

public class LevelTwoCeiling implements IMatter{
    /**
     * 场景： 地板，地砖，涂料，吊顶等。
     *
     * @return 场景信息
     */
    @Override
    public String scene() {
        return "吊顶";
    }

    /**
     * 品牌
     *
     * @return 品牌名称
     */
    @Override
    public String brand() {
        return "装修公司自带";
    }

    /**
     * 型号
     *
     * @return 型号
     */
    @Override
    public String model() {
        return "二级顶";
    }

    /**
     * 价格
     *
     * @return 价格
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal(850);
    }

    /**
     * 描述
     *
     * @return 描述信息
     */
    @Override
    public String desc() {
        return "两个层次的吊顶，二级吊顶高度一般在下吊20cm, 如果层高很高，则可以增加每级的厚度";
    }
}
