package au.com.binu.abn.amro.assignment.model;

public enum Fields {
    RECORD_CODE(3, 1, 3),
    CLIENT_TYPE(4,4,7),
    CLIENT_NUMNER(4,8,11),
    ACCOUNT_NUMBER(4,12,15),
    SUB_ACCOUNT_NUMBER(4,16,19),
    OPPOSITE_PARTY_CODE(6,20,25),
    PRODUCT_GROUP_CODE(2,26,27),
    EXCHANGE_CODE(4,28,31),
    SYMBOL(6,32,37),
    EXPIRATION(8,38,45),
    CURRENCY_CODE(3,46,48),
    MOVEMENT_CODE(2,49,50),
    BUY_SELL_CODE(1,51,51),
    QUANTITY_LONG_SIGN(1,52,52),
    QUANTITY_LONG(10,53,62),
    QUANTITY_SHORT_SIGN(1,63,63),
    QUANTITY_SHORT(10,64,73),
    EXCH_BROKER_FEE(12,74,85),
    EXCH_BROKER_FEE_DC(1,86,86),
    EXCH_BROKER_FEE_CURRENCY_CODE(3,87,89),
    CLEARING_FEE(12,90,101),
    CLEARING_FEE_DC(1,102,102),
    CLEARING_FEE_CUR_CODE(3, 103,105),
    COMMISION(12,106,117),
    COMMISION_DC(1,118,118),
    COMMISSION_CUR_CODE(3,119,121),
    TRANSACTION_DATE(8,122,129),
    FUTURE_REFERENCE(6,130,135),
    TICKET_NUMBER(6,136,141),
    EXTERNAL_NUMBER(6,142,147),
    TRANSACTION_PRICE(15,148,162),
    TRADER_INITIALS(6,163,68),
    OPPOSITE_TRADER_ID(7,169,175),
    OPEN_CLOSE_CODE(1,176,176),
    FILLER(127,177,303);

    private final int length;
    private final int startIndex;
    private final int lastIndex;

    Fields(final int length, final int startIndex, final int lastIndex) {
        this.length = length;
        this.startIndex = startIndex;
        this.lastIndex = lastIndex;
    }

    public int getLength() {
        return length;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }
}
