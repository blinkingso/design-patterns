package factory;

import java.util.logging.Logger;

/**
 * 简单工厂模式， 又称之为工厂方法模式
 * 根据传入的class类型或者业务类型实例化相应的bean.
 * 通过抽象业务接口， 将复杂的逻辑拆分成符合单一职责原则，松耦合的实现。
 */
public class SimpleFactoryPattern {
    public static void main(String[] args) {
        Validator validator = SimpleFactory.getValidator(EmailValidator.class);
        validator.validate("test@gmai.com");
        Validator v = SimpleFactory.getValidator(ValidateType.MOBILE);
        v.validate("182");
    }
}

enum ValidateType {
    EMAIL,
    MOBILE,
    NOT_EMPTY,
}

interface Validator {
    boolean validate(String message);
}

class EmailValidator implements Validator {

    public EmailValidator() {
    }

    private final Logger logger = Logger.getLogger(EmailValidator.class.getName());

    @Override
    public boolean validate(String message) {
        logger.info(() -> "Email validate failed with message: " + message);
        return false;
    }
}

class MobileValidator implements Validator {

    public MobileValidator() {
    }

    private final Logger logger = Logger.getLogger(MobileValidator.class.getName());

    @Override
    public boolean validate(String message) {
        logger.info(() -> "Failed to validate mobile with message: " + message);
        return false;
    }
}

class NotEmptyValidator implements Validator {

    private final Logger logger = Logger.getLogger(NotEmptyValidator.class.getName());

    public NotEmptyValidator() {
    }

    @Override
    public boolean validate(String message) {
        logger.info("value must not be empty");
        return false;
    }
}

class SimpleFactory {
    private SimpleFactory() {
    }

    public static Validator getValidator(ValidateType type) {
        switch (type) {
            case EMAIL:
                return new EmailValidator();
            case NOT_EMPTY:
                return new NotEmptyValidator();
            case MOBILE:
                return new MobileValidator();
            default:
                throw new IllegalArgumentException();
        }
    }

    public static Validator getValidator(Class<? extends Validator> clazz) {
        if (clazz != null) {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException();
    }
}