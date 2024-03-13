package builder;

public interface IMenu {

    IMenu appendCeiling(IMatter matter);

    IMenu appendFloor(IMatter matter);

    IMenu appendCoat(IMatter matter);

    IMenu appendTile(IMatter matter);

    String getDetail();
}
