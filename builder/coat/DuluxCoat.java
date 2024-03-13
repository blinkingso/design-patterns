package builder.coat;

import builder.IMatter;

import java.math.BigDecimal;

public class DuluxCoat implements IMatter {
    /**
     * 场景： 地板，地砖，涂料，吊顶等。
     *
     * @return 场景信息
     */
    @Override
    public String scene() {
        return "涂料";
    }

    /**
     * 品牌
     *
     * @return 品牌名称
     */
    @Override
    public String brand() {
        return "多乐士(Dulux))";
    }

    /**
     * 型号
     *
     * @return 型号
     */
    @Override
    public String model() {
        return "第二代";
    }

    /**
     * 价格
     *
     * @return 价格
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal(719);
    }

    /**
     * 描述
     *
     * @return 描述信息
     */
    @Override
    public String desc() {
        return "多乐士描述涂料描述信息";
    }
}
