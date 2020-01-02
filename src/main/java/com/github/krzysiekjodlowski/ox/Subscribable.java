package com.github.krzysiekjodlowski.ox;

/**
 * Subscriber contract for EventBus.
 *
 * @author KrzysiekJodlowski
 */
interface Subscribable {
    /**
     * Consume the events dispatched by the bus
     */
    void handle(Event<?> event);
}

