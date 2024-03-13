package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式： 类似发布订阅模式, 或者监听器模式
 */
public class ObserverPattern {
    public static void main(String[] args) {
        // var observer1 = new Observer();
        // var observer2 = new Observer();
        var observer1 = new ObserverA();
        var observer2 = new ObserverB();

        var subject = new Subject();
        subject.register(observer1);
        subject.register(observer2);
        subject.setFlag(0);
        System.out.println("================================");
        subject.setFlag(2);

        System.out.println("================================");
        var broadcast = new DefaultBroadcast();
        var tagListener = new TagAListener();
        var buttonClickListener = new ButtonClickListener();
        broadcast.addListener(tagListener);
        broadcast.addListener(buttonClickListener);

        broadcast.publish(new TagAClickEvent("http://localhost"));
        broadcast.publish(new ButtonClickEvent("ButtonA"));
    }
}

interface IObserver {
    void update(int flag);
}

class ObserverA implements IObserver {

    @Override
    public void update(int flag) {
        System.out.println("ObserverA got update value: " + flag);
    }
}

class ObserverB implements IObserver {
    @Override
    public void update(int flag) {
        System.out.println("ObserverB got now value: " + flag);
    }
}

class Subject implements ISubject {

    private final List<IObserver> observers = new ArrayList();

    private int flag;

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int flag) {
        if (this.flag != flag) {
            this.flag = flag;
            this.notifyAllObservers();
        }
    }

    @Override
    public void register(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        this.observers.forEach(s -> s.update(flag));
    }

}

interface ISubject {
    // 注册到观察者
    void register(IObserver observer);

    // 取消订阅
    void unregister(IObserver observer);

    // 通知观察者进行更新
    void notifyAllObservers();
}

class Observer {

    public void update() {
        System.out.println("subject flag has been changed.");
    }
}

abstract class ApplicationEvent {
    private Object source;

    public ApplicationEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return this.source;
    }
}

interface Listener {
    void onEvent(ApplicationEvent event);
}

interface Broadcast {
    void addListener(Listener listener);

    void removeListener(Listener listener);

    void notifyListeners();
}

class DefaultBroadcast implements Broadcast {
    private final List<Listener> listeners = new ArrayList<>();

    private ApplicationEvent event;

    public void publish(ApplicationEvent event) {
        this.event = event;
        this.notifyListeners();
    }

    @Override
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void notifyListeners() {
        this.listeners.forEach(listener -> listener.onEvent(this.event));
    }
}

class ButtonClickEvent extends ApplicationEvent {
    public ButtonClickEvent(String buttonName) {
        super(buttonName);
    }
}

class TagAClickEvent extends ApplicationEvent {

    public TagAClickEvent(String href) {
        super(href);
    }
}

class TagAListener implements Listener {

    @Override
    public void onEvent(ApplicationEvent event) {
        if (event instanceof TagAClickEvent) {
            System.out.println("Href a has been click with: " + event.getSource());
        }
    }
}

class ButtonClickListener implements Listener {
    @Override
    public void onEvent(ApplicationEvent event) {
        if (event instanceof ButtonClickEvent) {
            System.out.println("Button has been clicked with: " + event.getSource());
        }
    }
}