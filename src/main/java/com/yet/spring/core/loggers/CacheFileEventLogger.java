package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filePath, int cacheSize) {
        super(filePath);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>(cacheSize);
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize){
            writeEventFromCache();
            cache.clear();
        }
    }

    private void writeEventFromCache() {
        for (Event event: cache){
            super.logEvent(event);
        }
    }

    private void destroy() {
        if (!cache.isEmpty()) {
            writeEventFromCache();
        }
    }
}
