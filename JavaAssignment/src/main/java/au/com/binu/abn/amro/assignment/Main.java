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
            List<Transaction> transactions = Util.extractTransactions(fileHandler, INPUT_FILE_NAME);
            Map<String, Long> dailySummaryReportMap = Util.createDailySummaryReportMap(transactions);
            fileHandler.writeToCsv(dailySummaryReportMap);
        }
        catch (Exception e) {
            LOG.log(Level.SEVERE,String.format("Failed to parse {} and generate {}", INPUT_FILE_NAME, OUTPUT_FILE_NAME),e);
        }
    }
}
