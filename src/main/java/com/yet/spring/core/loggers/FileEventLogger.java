package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String filePath;
    private File file;

    public FileEventLogger(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }
    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), (String) null, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        if (file.exists() && !file.canWrite()){
            throw new IllegalArgumentException("Can't write to file" + filePath);
        } else if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new IllegalArgumentException("Can't create file", e);
            }
        }
    }
}
