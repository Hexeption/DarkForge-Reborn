package uk.co.hexeption.darkforgereborn.event;

import me.zero.alpine.event.EventState;

/**
 * Event
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 12/11/2019 - 11:38 am
 */
public class Event {

    private EventState eventState;

    public Event(EventState eventState) {
        this.eventState = eventState;
    }

    public EventState getEventState() {
        return eventState;
    }

    public void setEventState(EventState eventState) {
        this.eventState = eventState;
    }
}
