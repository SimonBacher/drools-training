package org.drools.examples.cashflow;

import java.util.Date;

public class AccountPeriod {
    private Date startPoint;
    private Date endPoint;

    public AccountPeriod(Date start, Date end) {
        this.startPoint = start;
        this.endPoint = end;
    }

    public Date getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Date startPoint) {
        this.startPoint = startPoint;
    }

    public Date getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Date endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        AccountPeriod that = (AccountPeriod) o;

        if (!endPoint.equals(that.endPoint)) { return false; }
        if (!startPoint.equals(that.startPoint)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        int result = startPoint.hashCode();
        result = 31 * result + endPoint.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AccountPeriod{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}
