package ww.mddrawer.ViewFramgnets.ViewTransaction;

public class TransactionDetail {

    String invoice;

    String dnt;
    String type;
    String status1;
    String amount;

    public TransactionDetail(String invoice, String dnt, String type, String status1, String amount) {
        this.invoice = invoice;
        this.dnt = dnt;
        this.type = type;
        this.status1 = status1;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDnt() {
        return dnt;
    }

    public void setDnt(String dnt) {
        this.dnt = dnt;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

}
