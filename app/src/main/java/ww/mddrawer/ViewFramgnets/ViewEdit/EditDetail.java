package ww.mddrawer.ViewFramgnets.ViewEdit;

public class EditDetail {

    String date;
    String dName;
    String Status;
    String Amount;

    public EditDetail(String dName, String date, String Status, String Amount) {
        this.date = date;
        this.dName = dName;
        this.Status = Status;
        this.Amount = Amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }


}
