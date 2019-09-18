package au.com.binu.abn.amro.assignment.model;

import au.com.binu.abn.amro.assignment.Util;

import java.util.Objects;

/**
 * Bean class holding Client Information
 */
public class ClientInformation {

    private final String clientType;
    private final String clientNumber;
    private final String accountNumber;
    private final String subAccountNumber;

    public ClientInformation(String clientType, String clientNumber, String accountNumber, String subAccountNumber) {
        this.clientType = clientType;
        this.clientNumber = clientNumber;
        this.accountNumber = accountNumber;
        this.subAccountNumber = subAccountNumber;
    }

    public String getClientType() {
        return clientType;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSubAccountNumber() {
        return subAccountNumber;
    }

    public static class Builder {
        private String line;
        private String clientType;
        private String clientNumber;
        private String accountNumber;
        private String subAccountNumber;

        public static Builder newInstance(String line) {
            return new Builder(line);
        }

        private Builder(String line) {
            this.line = line;
        }

        public Builder withClientType() {
            this. clientType = Util.getValueAsString(line,Fields.CLIENT_TYPE);
            return this;
        }

        public Builder withClientNumber() {
            this.clientNumber = Util.getValueAsString(line, Fields.CLIENT_NUMNER);
            return this;
        }
        public Builder withSubAccountNumber() {
            this.subAccountNumber = Util.getValueAsString(line,Fields.SUB_ACCOUNT_NUMBER);
            return this;
        }
        public Builder withAccountNumber() {
            this.accountNumber = Util.getValueAsString(line,Fields.ACCOUNT_NUMBER);
            return this;
        }

        public ClientInformation build() {
            return new ClientInformation(clientType, clientNumber, accountNumber, subAccountNumber);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInformation that = (ClientInformation) o;
        return Objects.equals(clientType, that.clientType) &&
                Objects.equals(clientNumber, that.clientNumber) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(subAccountNumber, that.subAccountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientType, clientNumber, accountNumber, subAccountNumber);
    }

    @Override
    public String toString() {
        return "ClientInformation{" +
                "clientType='" + clientType + '\'' +
                ", clientNumber='" + clientNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", subAccountNumber='" + subAccountNumber + '\'' +
                '}';
    }

    public String getValueAsCsvString()  {
        return clientType+clientNumber+accountNumber+subAccountNumber;
    }

}
