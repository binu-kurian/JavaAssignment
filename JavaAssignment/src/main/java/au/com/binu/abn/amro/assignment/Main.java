package au.com.binu.abn.amro.assignment;

import au.com.binu.abn.amro.assignment.file.FileHandler;
import au.com.binu.abn.amro.assignment.model.Transaction;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static au.com.binu.abn.amro.assignment.file.FileHandler.INPUT_FILE_NAME;
import static au.com.binu.abn.amro.assignment.file.FileHandler.OUTPUT_FILE_NAME;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler();
            LOG.log(Level.INFO,String.format("Initializing parsing of %s", INPUT_FILE_NAME));
            List<Transaction> transactions = Util.extractTransactions(fileHandler, INPUT_FILE_NAME);
            LOG.log(Level.INFO,"Extraction of transactions completed");
            Map<String, Long> dailySummaryReportMap = Util.createDailySummaryReportMap(transactions);
            LOG.log(Level.INFO,"Creation of daily summary report completed");
            fileHandler.writeToCsv(dailySummaryReportMap);
            LOG.log(Level.INFO,String.format("Wrote daily summary report to %s", OUTPUT_FILE_NAME));
        }
        catch (Exception e) {
            LOG.log(Level.SEVERE,String.format("Failed to parse {} and generate {}", INPUT_FILE_NAME, OUTPUT_FILE_NAME),e);
        }
    }
}
