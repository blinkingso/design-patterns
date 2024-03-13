package builder;

import builder.coat.DuluxCoat;
import builder.floor.DerFloor;
import builder.tile.DongPengTile;

import java.math.BigDecimal;

public class BuilderPattern {
    public static void main(String[] args) {
        String detail = new DecorationPackageMenu(new BigDecimal("20.0"), "顶级")
                .appendCeiling(new LevelOneCeiling())
                .appendFloor(new DerFloor())
                .appendCoat(new DuluxCoat())
                .appendTile(new DongPengTile())
                .getDetail();
        System.out.println(detail);
    }
}