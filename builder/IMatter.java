package builder;

import java.math.BigDecimal;

public interface IMatter {
    /**
     * 场景： 地板，地砖，涂料，吊顶等。
     *
     * @return 场景信息
     */
    String scene();

    /**
     * 品牌
     *
     * @return 品牌名称
     */
    String brand();

    /**
     * 型号
     *
     * @return 型号
     */
    String model();

    /**
     * 价格
     *
     * @return 价格
     */
    BigDecimal price();

    /**
     * 描述
     *
     * @return 描述信息
     */
    String desc();
}
