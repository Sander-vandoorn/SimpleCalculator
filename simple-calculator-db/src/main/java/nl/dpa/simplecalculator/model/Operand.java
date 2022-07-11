package nl.dpa.simplecalculator.model;

import java.math.BigInteger;

public enum Operand {
    ADD(BigInteger.ONE),
    SUBTRACT(BigInteger.valueOf(2)),
    MULTIPLY(BigInteger.valueOf(3)),
    DIVIDE(BigInteger.valueOf(4));

    private BigInteger index;

    public BigInteger getIndex() {
        return this.index;
    }

    Operand(BigInteger index) {
        this.index = index;
    }

}
