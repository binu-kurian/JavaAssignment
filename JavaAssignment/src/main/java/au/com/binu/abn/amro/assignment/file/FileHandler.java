package au.com.binu.abn.amro.assignment.file;

import au.com.binu.abn.amro.assignment.Main;
import au.com.binu.abn.amro.assignment.Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Wrapper Class that handles file operations
 */
public class FileHandler {
    private static final Logger LOG = Logger.getLogger(FileHandler.class.getName());
    public static final String INPUT_FILE_NAME = "Input.txt";
    public static final String OUTPUT_FILE_NAME = "Output.csv";

    /**
     * Write Daily Summary Report to CSV
     * @param dailySummaryReport
     */
    public  void writeToCsv(Map<String, Long> dailySummaryReport) {
        try {
            File output = new File(OUTPUT_FILE_NAME);
            if (output.exists()) {output.delete();}
            FileWriter csvWriter = new FileWriter(OUTPUT_FILE_NAME);
            csvWriter.append("Client_Information");
            csvWriter.append(",");
            csvWriter.append("Product_Information");
            csvWriter.append(",");
            csvWriter.append("Total_Transaction_Amount");
            csvWriter.append("\n");
            dailySummaryReport.forEach((clientToProductMapping, value)->  {
                        try {
                            csvWriter.append( clientToProductMapping+ Util.processValue(value));
                            csvWriter.append("\n");
                        } catch (IOException e) {
                            LOG.log(Level.SEVERE,String.format("Failed to generate {}",  OUTPUT_FILE_NAME),e);
                        }
            });
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException ioe) {
            LOG.log(Level.SEVERE,String.format("Failed to generate {}",  OUTPUT_FILE_NAME),ioe);
        }
    }

    public Stream<String> readFileAsStream(String filePath) throws IOException {
       return Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
    }
}
