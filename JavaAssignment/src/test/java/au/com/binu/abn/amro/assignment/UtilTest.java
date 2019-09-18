package au.com.binu.abn.amro.assignment;

import au.com.binu.abn.amro.assignment.file.FileHandler;
import au.com.binu.abn.amro.assignment.model.Fields;
import au.com.binu.abn.amro.assignment.model.Transaction;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UtilTest {
    public static final String LINE ="315CL  432100020001SGXDC FUSGX NK    20100910JPY01B 0000000001 0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380     688032000092500000000             O";
    @Test
    public void writeToCsv() {

    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void handleNullInputToBuildTransaction() {
        Transaction transaction = Util.buildTransaction(null);
        assertEquals(null, transaction);
    }

    @Test
    public void handleEmptyInputToBuildTransaction() {
        Transaction transaction = Util.buildTransaction(null);
        assertEquals(null, transaction);
    }

    @Test
    public void handleInvalidLengthArgument() {
        Transaction transaction = Util.buildTransaction("  ");
        assertThat(transaction, isA(Transaction.class));
    }

    @Test
    public void shouldReturnZeroIfInvalidString() {
        long actual = Util.getValueAsLong("hello", Fields.TRANSACTION_PRICE);
        assertEquals(0L,actual);
    }

    @Test
    public void shouldReturnTranasctionPrice() {
        long actual = Util.getValueAsLong(LINE,Fields.TRANSACTION_PRICE);
        long expected = 92500000000L;
        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnNullForInvalidInput() {
        String actual = Util.getValueAsString("hello", Fields.TRADER_INITIALS);
        assertNull(actual);
    }


    @Test
    public void shouldReturnParsedValueForValidOutput() {
        String actual = Util.getValueAsString(LINE, Fields.OPPOSITE_PARTY_CODE);
        String expected = "SGXDC ";
        assertEquals(expected,actual);
    }

    @Test
    public void readFiles() throws IOException {
        FileHandler fileHandler = spy(new FileHandler());
        Stream<String> lines = mock(Stream.class);
        doReturn(lines).when(fileHandler).readFileAsStream(anyString());
        ArrayList<Transaction> transactions = spy(Util.extractTransactions(fileHandler,"some path"));
        verify(fileHandler).readFileAsStream(anyString());
        assertThat(transactions, isA(ArrayList.class));
    }
}