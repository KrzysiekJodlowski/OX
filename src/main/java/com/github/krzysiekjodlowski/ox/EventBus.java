package com.github.krzysiekjodlowski.ox;

import java.util.List;

/**
 * Description of the contract of a generic EventBus implementation.
 *
 * @author KrzysiekJodlowski
 */
interface EventBus {
    /**
     * registers a new subscribable to this EventBus instance
     */
    void register(Subscribable subscribable);
    /**
     * send the given event in this EventBus implementation to be consumed by interested subscribers
     */
    void dispatch(Event<?> event);
    /**
     * get the list of all the subscribers associated with this EventBus instance
     */
    List<Subscribable> getSubscribers();
}
