package au.com.binu.abn.amro.assignment.model;

import au.com.binu.abn.amro.assignment.Util;

import java.util.Objects;

/**
 * Bean class holding product information
 */
public class ProductInformation {

    private final String exchangeCode;
    private final String productGroupCode;
    private final String symbol;
    private final String expirationDate;

    public ProductInformation(String exchangeCode, String productGroupCode, String symbol, String expirationDate) {
        this.exchangeCode = exchangeCode;
        this.productGroupCode = productGroupCode;
        this.symbol = symbol;
        this.expirationDate = expirationDate;
    }

    public static class Builder {
        private String line;
        private String exchangeCode;
        private String productGroupCode;
        private String symbol;
        private String expirationDate;

        public static Builder newInstance(String line) {
            return new Builder(line);
        }

        private Builder(String line) {
            this.line = line;
        }

        public Builder withExpirationDate() {
            this. expirationDate = Util.getValueAsString(line,Fields.EXPIRATION);
            return this;
        }

        public Builder withSymbol() {
            this.symbol = Util.getValueAsString(line, Fields.SYMBOL);
            return this;
        }
        public Builder withProductGroupCode() {
            this.productGroupCode = Util.getValueAsString(line,Fields.PRODUCT_GROUP_CODE);
            return this;
        }
        public Builder withExchangeCode() {
            this.exchangeCode = Util.getValueAsString(line,Fields.EXCHANGE_CODE);
            return this;
        }

        public ProductInformation build() {
            return new ProductInformation(exchangeCode, productGroupCode, symbol, expirationDate);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInformation that = (ProductInformation) o;
        return Objects.equals(exchangeCode, that.exchangeCode) &&
                Objects.equals(productGroupCode, that.productGroupCode) &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchangeCode, productGroupCode, symbol, expirationDate);
    }

    @Override
    public String toString() {
        return "ProductInformation{" +
                "exchangeCode='" + exchangeCode + '\'' +
                ", productGroupCode='" + productGroupCode + '\'' +
                ", symbol='" + symbol + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }

    public String getValueAsCsvString()  {
        return exchangeCode+productGroupCode+symbol+expirationDate;
    }
}
