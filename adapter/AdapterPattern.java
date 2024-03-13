package adapter;

/**
 * 适配器模式： 将多个接口数据抽象成统一的参数暴露给上游系统
 * 火车票系统不同的接口参数进行重构。
 * 基于接口或抽象类进行抽离：
 * 可以是pojo之间的适配
 * 也可以是对外api之间的适配
 * 最终目标是为了针对不同的数据类型或接口类型进行统一处理，以此减少重复逻辑处理，并且对外呢实现了一套逻辑，保证内部实现的隐私行为。
 */
public class AdapterPattern {
    public static void main(String[] args) {
        final TicketResponse o1 = new JdServiceImpl().occupy();
        final TicketResponse o2 = new DaTuoServiceImpl().occupy();
        TicketResponse response;
        if ("success".equals(o1.getStatus())) {
            response = o1;
        } else {
            response = o2;
        }
        if (null == response.getStatus()) {
            System.out.println("Failed to occupy from 12306....");
        }
    }
}
