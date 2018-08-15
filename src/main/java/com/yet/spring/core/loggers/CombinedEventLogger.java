package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {

   private final Collection<EventLogger> eventLoggers;

    public CombinedEventLogger(Collection<EventLogger> eventLoggers) {
        this.eventLoggers = eventLoggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger: eventLoggers) {
            eventLogger.logEvent(event);
        }
    }
}
