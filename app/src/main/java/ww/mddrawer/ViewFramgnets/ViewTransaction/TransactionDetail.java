package ww.mddrawer.ViewFramgnets.ViewTransaction;

public class TransactionDetail {

    String orderid, paieddate, invoiceNo, transtype, createDate, dateInvoiceCreated, payDate, refId, chargeBy;

    public TransactionDetail(String orderid, String paieddate, String invoiceNo, String transtype, String createDate, String dateInvoiceCreated, String payDate, String refId, String chargeBy) {
        this.orderid = orderid;
        this.paieddate = paieddate;
        this.invoiceNo = invoiceNo;
        this.transtype = transtype;
        this.createDate = createDate;
        this.dateInvoiceCreated = dateInvoiceCreated;
        this.payDate = payDate;
        this.refId = refId;
        this.chargeBy = chargeBy;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getPaieddate() {
        return paieddate;
    }

    public void setPaieddate(String paieddate) {
        this.paieddate = paieddate;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDateInvoiceCreated() {
        return dateInvoiceCreated;
    }

    public void setDateInvoiceCreated(String dateInvoiceCreated) {
        this.dateInvoiceCreated = dateInvoiceCreated;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getChargeBy() {
        return chargeBy;
    }

    public void setChargeBy(String chargeBy) {
        this.chargeBy = chargeBy;
    }
}
