package au.com.binu.abn.amro.assignment.model;

import au.com.binu.abn.amro.assignment.Util;

import java.util.Objects;

/**
 * Bean class holding transaction details
 */
public class Transaction {
    private final String recordCode;
    private final String oppositePartyCode;
    private final String currencyCode;
    private final String movementCode;
    private final String buySellCode;
    private final String quantityLongSign;
    private final Long   quqntityLong;
    private final String quantityShortSign;
    private final Long   quantityShort;
    private final String exchangeBrokerFee;
    private final String exchangeBrokerFeeDC;
    private final String exchangeBrokerFeeCurrencyCode;
    private final String clearingFee;
    private final String clearingFeeDC;
    private final String clearingFeeCurrencyCode;
    private final String commision;
    private final String commisionDC;
    private final String commisionCurrencyCode;
    private final String transactionDate;
    private final String futureReference;
    private final String ticketNumber;
    private final String externalNumber;
    private final Long   transactionPrice;
    private final String traderInitials;
    private final String oppositeTraderId;
    private final ClientInformation clientInformation;
    private final ProductInformation productInformation;

    public Transaction(String recordCode, String oppositePartyCode, String currencyCode,
                       String movementCode, String buySellCode, String quantityLongSign,
                       Long quqntityLong, String quantityShortSign, Long quantityShort,
                       String exchangeBrokerFee, String exchangeBrokerFeeDC,
                       String exchangeBrokerFeeCurrencyCode, String clearingFee,
                       String clearingFeeDC, String clearingFeeCurrencyCode, String commision,
                       String commisionDC, String commisionCurrencyCode, String transactionDate,
                       String futureReference, String ticketNumber, String externalNumber,
                       Long transactionPrice, String traderInitials, String oppositeTraderId,
                       ClientInformation clientInformation, ProductInformation productInformation) {
        this.recordCode = recordCode;
        this.oppositePartyCode = oppositePartyCode;
        this.currencyCode = currencyCode;
        this.movementCode = movementCode;
        this.buySellCode = buySellCode;
        this.quantityLongSign = quantityLongSign;
        this.quqntityLong = quqntityLong;
        this.quantityShortSign = quantityShortSign;
        this.quantityShort = quantityShort;
        this.exchangeBrokerFee = exchangeBrokerFee;
        this.exchangeBrokerFeeDC = exchangeBrokerFeeDC;
        this.exchangeBrokerFeeCurrencyCode = exchangeBrokerFeeCurrencyCode;
        this.clearingFee = clearingFee;
        this.clearingFeeDC = clearingFeeDC;
        this.clearingFeeCurrencyCode = clearingFeeCurrencyCode;
        this.commision = commision;
        this.commisionDC = commisionDC;
        this.commisionCurrencyCode = commisionCurrencyCode;
        this.transactionDate = transactionDate;
        this.futureReference = futureReference;
        this.ticketNumber = ticketNumber;
        this.externalNumber = externalNumber;
        this.transactionPrice = transactionPrice;
        this.traderInitials = traderInitials;
        this.oppositeTraderId = oppositeTraderId;
        this.productInformation = productInformation;
        this.clientInformation = clientInformation;
    }

    public ClientInformation getClientInformation() {
        return clientInformation;
    }

    public ProductInformation getProductInformation() {
        return productInformation;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public String getOppositePartyCode() {
        return oppositePartyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getMovementCode() {
        return movementCode;
    }

    public String getBuySellCode() {
        return buySellCode;
    }

    public String getQuantityLongSign() {
        return quantityLongSign;
    }

    public Long getQuqntityLong() {
        return quqntityLong;
    }

    public String getQuantityShortSign() {
        return quantityShortSign;
    }

    public Long getQuantityShort() {
        return quantityShort;
    }

    public String getExchangeBrokerFeeCurrencyCode() {
        return exchangeBrokerFeeCurrencyCode;
    }

    public String getClearingFee() {
        return clearingFee;
    }

    public String getClearingFeeDC() {
        return clearingFeeDC;
    }

    public String getClearingFeeCurrencyCode() {
        return clearingFeeCurrencyCode;
    }

    public String getCommision() {
        return commision;
    }

    public String getCommisionDC() {
        return commisionDC;
    }

    public String getCommisionCurrencyCode() {
        return commisionCurrencyCode;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Long getTransactionPrice() {
        return transactionPrice;
    }

    public static class Builder {
        private String line;
        private String recordCode;
        private String oppositePartyCode;
        private String currencyCode;
        private String movementCode;
        private String buySellCode;
        private String quantityLongSign;
        private Long quantityLong;
        private String quantityShortSign;
        private Long   quantityShort;
        private String exchangeBrokerFee;
        private String exchangeBrokerFeeDC;
        private String exchangeBrokerFeeCurrencyCode;
        private String clearingFee;
        private String clearingFeeDC;
        private String clearingFeeCurrencyCode;
        private String commission;
        private String commissionDC;
        private String commisionCurrencyCode;
        private String transactionDate;
        private String futureReference;
        private String ticketNumber;
        private String externalNumber;
        private Long transactionPrice;
        private String traderInitials;
        private String oppositeTraderId;
        private ClientInformation clientInformation;
        private ProductInformation productInformation;

        public static Builder newInstance(String line) {
            return new Builder(line);
        }

        private Builder(String line) {
            this.line = line;
        }

        public Builder withRecordCode() {
            this. recordCode = Util.getValueAsString(line,Fields.RECORD_CODE);
            return this;
        }

        public Builder withOppositePartyCode() {
            this.oppositePartyCode = Util.getValueAsString(line, Fields.OPPOSITE_PARTY_CODE);
            return this;
        }
        public Builder withCurrencyCode() {
            this.currencyCode = Util.getValueAsString(line,Fields.CURRENCY_CODE);
            return this;
        }
        public Builder withMovementCode() {
            this.movementCode = Util.getValueAsString(line,Fields.MOVEMENT_CODE);
            return this;
        }

        public Builder withBuySellCode() {
            this.buySellCode = Util.getValueAsString(line,Fields.BUY_SELL_CODE);
            return this;
        }

        public Builder withQuantityLongSign() {
            this.quantityLongSign = Util.getValueAsString(line,Fields.QUANTITY_LONG_SIGN);
            return this;
        }

        public Builder withQuantityLong() {
            this.quantityLong = Util.getValueAsLong(line,Fields.QUANTITY_LONG);
            return this;
        }

        public Builder withQuantityShortSign() {
            this.quantityShortSign = Util.getValueAsString(line,Fields.QUANTITY_SHORT_SIGN);
            return this;
        }

        public Builder withQuantityShort() {
            this.quantityShort = Util.getValueAsLong(line,Fields.QUANTITY_SHORT);
            return this;
        }

        public Builder withExchangeBrokerFee() {
            this.exchangeBrokerFee = Util.getValueAsString(line,Fields.EXCH_BROKER_FEE);
            return this;
        }

        public Builder withExchangeBrokerFeeDC() {
            this.exchangeBrokerFeeDC = Util.getValueAsString(line,Fields.EXCH_BROKER_FEE_DC);
            return this;
        }

        public Builder withExchangeBrokerFeeCurrencyCode() {
            this.exchangeBrokerFeeCurrencyCode = Util.getValueAsString(line,Fields.EXCH_BROKER_FEE_CURRENCY_CODE);
            return this;
        }

        public Builder withClearingFee() {
            this.clearingFee = Util.getValueAsString(line,Fields.CLEARING_FEE);
            return this;
        }

        public Builder withClearingFeeDC() {
            this.clearingFeeDC = Util.getValueAsString(line,Fields.CLEARING_FEE_DC);
            return this;
        }

        public Builder withClearingFeeCurrencyCode() {
            this.clearingFeeCurrencyCode = Util.getValueAsString(line,Fields.CLEARING_FEE_CUR_CODE);
            return this;
        }

        public Builder withCommission() {
            this.commission = Util.getValueAsString(line,Fields.COMMISION);
            return this;
        }

        public Builder withCommissionDC() {
            this.commissionDC = Util.getValueAsString(line,Fields.COMMISION_DC);
            return this;
        }

        public Builder withCommissionCurrencyCode() {
            this.commisionCurrencyCode = Util.getValueAsString(line,Fields.COMMISSION_CUR_CODE);
            return this;
        }

        public Builder withTransactionDate() {
            this.transactionDate = Util.getValueAsString(line,Fields.TRANSACTION_DATE);
            return this;
        }

        public Builder withFutureReference() {
            this.futureReference = Util.getValueAsString(line,Fields.FUTURE_REFERENCE);
            return this;
        }

        public Builder withTicketNumber() {
            this.ticketNumber = Util.getValueAsString(line,Fields.TICKET_NUMBER);
            return this;
        }
        public Builder withExternalNumber() {
            this.externalNumber = Util.getValueAsString(line,Fields.EXTERNAL_NUMBER);
            return this;
        }
        public Builder withTransactionPrice() {
            this.transactionPrice = Util.getValueAsLong(line,Fields.TRANSACTION_PRICE);
            return this;
        }
        public Builder withTraderInitials() {
            this.traderInitials = Util.getValueAsString(line,Fields.TRADER_INITIALS);
            return this;
        }
        public Builder withOppositeTraderId() {
            this.oppositeTraderId = Util.getValueAsString(line,Fields.OPPOSITE_TRADER_ID);
            return this;
        }

        public Builder withClientInformation() {
            this.clientInformation = ClientInformation.Builder.newInstance(line)
                    .withAccountNumber()
                    .withClientNumber()
                    .withClientType()
                    .withSubAccountNumber().build();
            return this;
        }

        public Builder withProductInformation() {
            this.productInformation = ProductInformation.Builder.newInstance(line)
                    .withProductGroupCode()
                    .withExchangeCode()
                    .withExpirationDate()
                    .withSymbol()
                    .build();
            return this;
        }

        public Transaction build() {
            return new Transaction(recordCode,
                    oppositePartyCode,
                    currencyCode,
                    movementCode,
                    buySellCode,
                    quantityLongSign,
                    quantityLong,
                    quantityShortSign,
                    quantityShort,
                    exchangeBrokerFee,
                    exchangeBrokerFeeDC,
                    exchangeBrokerFeeCurrencyCode,
                    clearingFee,
                    clearingFeeDC,
                    clearingFeeCurrencyCode,
                    commission,
                    commissionDC,
                    commisionCurrencyCode,
                    transactionDate,
                    futureReference,
                    ticketNumber,
                    externalNumber,
                    transactionPrice,
                    traderInitials,
                    oppositeTraderId,
                    clientInformation,
                    productInformation);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(recordCode, that.recordCode) &&
                Objects.equals(oppositePartyCode, that.oppositePartyCode) &&
                Objects.equals(currencyCode, that.currencyCode) &&
                Objects.equals(movementCode, that.movementCode) &&
                Objects.equals(buySellCode, that.buySellCode) &&
                Objects.equals(quantityLongSign, that.quantityLongSign) &&
                Objects.equals(quqntityLong, that.quqntityLong) &&
                Objects.equals(quantityShortSign, that.quantityShortSign) &&
                Objects.equals(quantityShort, that.quantityShort) &&
                Objects.equals(exchangeBrokerFee, that.exchangeBrokerFee) &&
                Objects.equals(exchangeBrokerFeeDC, that.exchangeBrokerFeeDC) &&
                Objects.equals(exchangeBrokerFeeCurrencyCode, that.exchangeBrokerFeeCurrencyCode) &&
                Objects.equals(clearingFee, that.clearingFee) &&
                Objects.equals(clearingFeeDC, that.clearingFeeDC) &&
                Objects.equals(clearingFeeCurrencyCode, that.clearingFeeCurrencyCode) &&
                Objects.equals(commision, that.commision) &&
                Objects.equals(commisionDC, that.commisionDC) &&
                Objects.equals(commisionCurrencyCode, that.commisionCurrencyCode) &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(futureReference, that.futureReference) &&
                Objects.equals(ticketNumber, that.ticketNumber) &&
                Objects.equals(externalNumber, that.externalNumber) &&
                Objects.equals(transactionPrice, that.transactionPrice) &&
                Objects.equals(traderInitials, that.traderInitials) &&
                Objects.equals(oppositeTraderId, that.oppositeTraderId) &&
                Objects.equals(clientInformation, that.clientInformation) &&
                Objects.equals(productInformation, that.productInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordCode, oppositePartyCode, currencyCode, movementCode, buySellCode, quantityLongSign, quqntityLong, quantityShortSign, quantityShort, exchangeBrokerFee, exchangeBrokerFeeDC, exchangeBrokerFeeCurrencyCode, clearingFee, clearingFeeDC, clearingFeeCurrencyCode, commision, commisionDC, commisionCurrencyCode, transactionDate, futureReference, ticketNumber, externalNumber, transactionPrice, traderInitials, oppositeTraderId, clientInformation, productInformation);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "recordCode='" + recordCode + '\'' +
                ", oppositePartyCode='" + oppositePartyCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", movementCode='" + movementCode + '\'' +
                ", buySellCode='" + buySellCode + '\'' +
                ", quantityLongSign='" + quantityLongSign + '\'' +
                ", quqntityLong=" + quqntityLong +
                ", quantityShortSign='" + quantityShortSign + '\'' +
                ", quantityShort=" + quantityShort +
                ", exchangeBrokerFee='" + exchangeBrokerFee + '\'' +
                ", exchangeBrokerFeeDC='" + exchangeBrokerFeeDC + '\'' +
                ", exchangeBrokerFeeCurrencyCode='" + exchangeBrokerFeeCurrencyCode + '\'' +
                ", clearingFee='" + clearingFee + '\'' +
                ", clearingFeeDC='" + clearingFeeDC + '\'' +
                ", clearingFeeCurrencyCode='" + clearingFeeCurrencyCode + '\'' +
                ", commision='" + commision + '\'' +
                ", commisionDC='" + commisionDC + '\'' +
                ", commisionCurrencyCode='" + commisionCurrencyCode + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", futureReference='" + futureReference + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", externalNumber='" + externalNumber + '\'' +
                ", transactionPrice=" + transactionPrice +
                ", traderInitials='" + traderInitials + '\'' +
                ", oppositeTraderId='" + oppositeTraderId + '\'' +
                ", clientInformation=" + clientInformation +
                ", productInformation=" + productInformation +
                '}';
    }

}
