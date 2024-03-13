package builder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class DecorationPackageMenu implements IMenu {
    DecorationPackageMenu(BigDecimal area, String grade) {
        this.area = area;
        this.grade = grade;
    }

    // 装修材料
    private final List<IMatter> matters = new ArrayList<>();
    // 装修价格
    private BigDecimal price = BigDecimal.ZERO;
    // 装修面积
    private BigDecimal area;
    // 装修等级
    private String grade;

    @Override
    public IMenu appendCeiling(IMatter matter) {
        this.matters.add(matter);
        this.price = this.price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendFloor(IMatter matter) {
        this.matters.add(matter);
        this.price = this.price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendCoat(IMatter matter) {
        this.matters.add(matter);
        this.price = price.add(new BigDecimal("1.4").multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendTile(IMatter matter) {
        this.matters.add(matter);
        this.price = this.price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public String getDetail() {
        StringBuilder detail = new StringBuilder("=======================\r\n");
        detail.append("装修清单: \r\n");
        detail.append("装修等级: ");
        detail.append(grade);
        detail.append("\r\n");
        detail.append("装修价格: ");
        detail.append(price.setScale(2, RoundingMode.HALF_UP));
        detail.append("\r\n");
        detail.append("房屋面积: ");
        detail.append(area);
        detail.append("平方米\r\n");

        this.matters.forEach(matter -> {
            detail.append(matter.scene()).append(": ").append(matter.brand()).append("， ").append(matter.model()).append("每平方米价格: ").append(matter.price()).append("元。\r\n");
        });

        return detail.toString();
    }
}
