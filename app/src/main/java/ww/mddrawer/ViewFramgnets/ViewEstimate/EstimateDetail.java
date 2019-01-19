package ww.mddrawer.ViewFramgnets.ViewEstimate;

public class EstimateDetail {

    String convert;
    String jobId;
    String designName;
    String status;
    String Amount;

    public EstimateDetail(String jobId, String designName, String amount, String status, String convert) {
        this.convert = convert;
        this.jobId = jobId;
        this.designName = designName;
        this.status = status;
        Amount = amount;
    }

    public String getConvert() {
        return convert;
    }

    public void setConvert(String convert) {
        this.convert = convert;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getDesignName() {
        return designName;
    }

    public void setDesignName(String designName) {
        this.designName = designName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

}
