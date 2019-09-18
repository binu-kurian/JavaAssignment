package au.com.binu.abn.amro.assignment;


import au.com.binu.abn.amro.assignment.file.FileHandler;
import au.com.binu.abn.amro.assignment.model.Fields;
import au.com.binu.abn.amro.assignment.model.Transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static au.com.binu.abn.amro.assignment.file.FileHandler.INPUT_FILE_NAME;
import static au.com.binu.abn.amro.assignment.file.FileHandler.OUTPUT_FILE_NAME;

/**
 * General util class that handles parsing and building model objects
 */
public class Util {
    private static final Logger LOG = Logger.getLogger(Util.class.getName());

    /**
     * Parse a value from the input
     * @param line Line from Input.txt
     * @param field Corresponding field
     * @return String value
     */
    public static String getValueAsString(String line, Fields field) {
        try {
            return line.substring(field.getStartIndex()-1, field.getStartIndex()+field.getLength()-1);
        }
        catch(StringIndexOutOfBoundsException siobe) {
            LOG.log(Level.INFO,String.format("Failed to parse {}", field.name()),siobe);
            return null;
        }
    }

    /**
     * Parse a value from the input and convert it to Long
     * @param line Line from Input.txt
     * @param field Corresponding field
     * @return Long value
     */
    public static Long getValueAsLong(String line, Fields field) {
        try {
            return Long.parseLong(line.substring(field.getStartIndex()-1, field.getStartIndex()+field.getLength()-1));
        } catch (StringIndexOutOfBoundsException  | ArithmeticException e) {
            LOG.log(Level.INFO,String.format("Failed to parse {}", field.name()),e);
            return 0L;
        }
    }

    /**
     * Build a transaction from each line of Input.txt
     * @param line
     * @return
     */
    public static Transaction buildTransaction(String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }
       return Transaction.Builder.newInstance(line)
                .withBuySellCode()
                .withClearingFee()
                .withClearingFeeCurrencyCode()
                .withClearingFeeDC()
                .withCommission()
                .withCommissionCurrencyCode()
                .withCommissionDC()
                .withCurrencyCode()
                .withExchangeBrokerFee()
                .withExchangeBrokerFeeCurrencyCode()
                .withExchangeBrokerFeeDC()
                .withExternalNumber()
                .withFutureReference()
                .withMovementCode()
                .withOppositePartyCode()
                .withOppositeTraderId()
                .withQuantityLong()
                .withQuantityLongSign()
                .withQuantityShort()
                .withRecordCode()
                .withQuantityShortSign()
                .withTicketNumber()
                .withTraderInitials()
                .withTransactionDate()
                .withTransactionPrice()
                .withClientInformation()
                .withProductInformation()
                .build();
    }

    /**
     * Calculate the transaction amount for each transaction using the formula
     * (QUANTITY LONG)*TRANSACTION_PRICE - (QUANTITY SHORT)*TRANSACTION_PRICE
     *
     * @param transaction
     * @return TRANSACTION_AMOUNT
     */
    public static Long calculateTransactionAmount(Transaction transaction) {
        return transaction.getQuqntityLong()*transaction.getTransactionPrice()-transaction.getQuantityShort()*transaction.getTransactionPrice();
    }

    /**
     * Format the transaction price to show decimal decimal symbol before last 7 digits
     * @param value
     * @return
     */
    public static String processValue(Long value) {
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        nf.setMinimumFractionDigits(7);
        nf.setGroupingUsed(false);
        return " "+nf.format(value);
    }

    /**
     * Converts each line extracted from Input.txt and convert it to Transaction Bean
     * @param fileHandler
     * @param filePath
     * @return
     */
    public static ArrayList<Transaction> extractTransactions(FileHandler fileHandler, String filePath) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (Stream<String> lines = fileHandler.readFileAsStream(filePath)) {
            lines.forEach(line -> transactions.add(buildTransaction(line)));
        }
        catch (IOException e) {
            LOG.log(Level.INFO,String.format("Failed to read {}", filePath),e);
        }
        return transactions;
    }

    /**
     * Converts the list of transactions of <Key,Value> pair
     * Key will be of format CLIENT TYPE+CLIENT NUMBER+ACCOUNT NUMBER+SUBACCOUNT NUMBER,EXCHANGE CODE+PRODUCT GROUP CODE+SYMBOL+EXPIRATION DATE,CURRENCY_CODE
     * Value will sum of Transaction price
     * @param transactions
     * @return
     */
    public static Map<String, Long> createDailySummaryReportMap(List<Transaction> transactions) {
        Map<String, Long> transactionMap = new HashMap<>();
        transactions.forEach(transaction -> {
            String clientToProductMapping = transaction.getClientInformation().getValueAsCsvString()+
                    ","+transaction.getProductInformation().getValueAsCsvString()+
                    ","+transaction.getCurrencyCode();
            Long value  = transactionMap.getOrDefault(clientToProductMapping, 0L);
            transactionMap.put(clientToProductMapping,value+Util.calculateTransactionAmount(transaction));
        });
        return transactionMap;
    }
}
