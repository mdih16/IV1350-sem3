package se.kth.iv1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Represents a log handler.
 */
public class LogHandler {
    private PrintWriter logFile;

    /**
     * Creates a new <code>LogHandler</code> instance.
     * @throws IOException When unable to write to the file.
     */
    public LogHandler() throws IOException 
    {
        logFile = new PrintWriter(new FileWriter("pos-log.txt"), true);
    }

    /**
     * Writes a log entry describing a thrown exception.
     *
     * @param exception The exception that shall be logged.
     */
    public void logException(Exception exception) 
    {
        String logMsg = createTime() + ", Exception was thrown: " + exception.getMessage();
        logFile.println(logMsg);
        exception.printStackTrace(logFile);
    }

    private String createTime() 
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
