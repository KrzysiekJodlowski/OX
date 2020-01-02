package com.github.krzysiekjodlowski.ox;

/**
 * Describs generic event, and it's associated meta data which get
 * sent in the bus to be dispatched to intrested Subscribers.
 *
 * @author KrzysiekJodlowski
 */
interface Event<T> {
    /**
     * @returns the stored data associated with the event
     */
    T getData();
}
