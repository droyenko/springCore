package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private File fileName;

    public FileEventLogger(File fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(fileName, event.toString(), (String) null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void init() {
//        this.file = new File(fileName);
//    }
}
