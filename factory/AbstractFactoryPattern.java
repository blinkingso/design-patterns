package factory;

import java.util.Collections;

/**
 * 抽象工厂模式： 主要是针对多个不同系列的产品信息进行扩展
 * <p>
 * 对产品和工厂进行抽象
 * <p>
 * 缺点： 系统庞大时 容易导致越来越复杂。
 * 与简单工厂模式的区别：
 * 可以创建不同的产品簇，而不再是简单模式的单一产品
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        String color = new AbstractFactory().getColorFactory(ColorFactory.class)
                .getColor(Blue.class)
                .color();
        System.out.println(color);
    }
}

class AbstractFactory implements IFactory {

    @Override
    public IColorFactory getColorFactory(Class<? extends IColorFactory> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IFrameFactory getFrameFactory(Class<? extends IFrameFactory> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

interface IFactory {
    IColorFactory getColorFactory(Class<? extends IColorFactory> clazz);

    IFrameFactory getFrameFactory(Class<? extends IFrameFactory> clazz);
}

interface IColorFactory {

    IColor getColor(Class<? extends IColor> clazz);
}

interface IFrameFactory {

    IFrame getFrame(Class<? extends IFrame> clazz);
}

interface IColor {
    String color();
}

interface IFrame {
    String frame();
}

class Green implements IColor {
    @Override
    public String color() {
        return "Green Color";
    }
}

class Blue implements IColor {
    @Override
    public String color() {
        return "Blue Color";
    }
}

class ColorFactory implements IColorFactory {
    @Override
    public IColor getColor(Class<? extends IColor> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

class FrameFactory implements IFrameFactory {
    @Override
    public IFrame getFrame(Class<? extends IFrame> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}