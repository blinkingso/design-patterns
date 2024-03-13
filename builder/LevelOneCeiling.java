package builder;

import java.math.BigDecimal;

public class LevelOneCeiling implements IMatter{
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
        return "一级顶";
    }

    /**
     * 价格
     *
     * @return 价格
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal(260);
    }

    /**
     * 描述
     *
     * @return 描述信息
     */
    @Override
    public String desc() {
        return "造型制作低一级，只有一个层次的吊顶，一般离顶120～150cm";
    }
}
