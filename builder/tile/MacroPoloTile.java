package builder.tile;

import builder.IMatter;

import java.math.BigDecimal;

public class MacroPoloTile implements IMatter {
    /**
     * 场景： 地板，地砖，涂料，吊顶等。
     *
     * @return 场景信息
     */
    @Override
    public String scene() {
        return "地砖";
    }

    /**
     * 品牌
     *
     * @return 品牌名称
     */
    @Override
    public String brand() {
        return "马可波罗";
    }

    /**
     * 型号
     *
     * @return 型号
     */
    @Override
    public String model() {
        return "C-";
    }

    /**
     * 价格
     *
     * @return 价格
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal(120);
    }

    /**
     * 描述
     *
     * @return 描述信息
     */
    @Override
    public String desc() {
        return "马可波罗地砖又贵又不好用";
    }
}
