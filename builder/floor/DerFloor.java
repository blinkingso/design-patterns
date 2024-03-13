package builder.floor;

import builder.IMatter;

import java.math.BigDecimal;

public class DerFloor implements IMatter {
    /**
     * 场景： 地板，地砖，涂料，吊顶等。
     *
     * @return 场景信息
     */
    @Override
    public String scene() {
        return "地板";
    }

    /**
     * 品牌
     *
     * @return 品牌名称
     */
    @Override
    public String brand() {
        return "立德";
    }

    /**
     * 型号
     *
     * @return 型号
     */
    @Override
    public String model() {
        return "默认"                                                                                                                                                                                                                                                                                                                                                                                                                                                               ;
    }

    /**
     * 价格
     *
     * @return 价格
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal(440);
    }

    /**
     * 描述
     *
     * @return 描述信息
     */
    @Override
    public String desc() {
        return "立德默认地板";
    }
}
