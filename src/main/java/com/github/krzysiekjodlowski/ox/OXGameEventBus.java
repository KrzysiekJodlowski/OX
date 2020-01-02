package com.github.krzysiekjodlowski.ox;

import java.util.ArrayList;
import java.util.List;

class OXGameEventBus implements EventBus {
    private final List<Subscribable> subscribers = new ArrayList<>();

    @Override
    public void register(Subscribable subscribable) {
        this.subscribers.add(subscribable);
    }

    @Override
    public void dispatch(Event<?> event) {
        this.subscribers.stream().forEach(subscriber -> subscriber.handle(event));
    }

    @Override
    public List<Subscribable> getSubscribers() {
        return this.subscribers;
    }
}
