package ww.mddrawer.ViewFramgnets.ViewOrder;

public class OrderViewDetail {

    String id, orderid, orderedby, orderDate, designname, formtype, order_type, is_estimate, jobid, nocolors, namecolors, designsize_height,
            designsize_width, designsize_format, patch_qty, fabric, fabric_type, baking_material, qty, applique, numappliques, colorappliques,
            designformat, timeframe, sewsample, autothread, instructions, filename, state, payment, estimatedate, deliverydate, stiches,
            findus, amount, paiedstatus, originalfile, generatedfile, pdfFile, orderDetail, embFile, invoiceDate, eta, estimateDetail,
            assignto, digit_by, qc_by, modify_status;

    public OrderViewDetail(String orderid, String designname, String amount, String paiedstatus) {
        this.orderid = orderid;
        this.designname = designname;
        this.amount = amount;
        this.paiedstatus = paiedstatus;
    }

    public OrderViewDetail(String id, String orderid, String orderedby, String orderDate, String designname, String formtype, String order_type, String is_estimate, String jobid, String nocolors, String namecolors, String designsize_height, String designsize_width, String designsize_format, String patch_qty, String fabric, String fabric_type, String baking_material, String qty, String applique, String numappliques, String colorappliques, String designformat, String timeframe, String sewsample, String autothread, String instructions, String filename, String state, String payment, String estimatedate, String deliverydate, String stiches, String findus, String amount, String paiedstatus, String originalfile, String generatedfile, String pdfFile, String orderDetail, String embFile, String invoiceDate, String eta, String estimateDetail, String assignto, String digit_by, String qc_by, String modify_status) {
        this.id = id;
        this.orderid = orderid;
        this.orderedby = orderedby;

        this.orderDate = orderDate;
        this.designname = designname;
        this.formtype = formtype;

        this.order_type = order_type;
        this.is_estimate = is_estimate;
        this.jobid = jobid;

        this.nocolors = nocolors;
        this.namecolors = namecolors;
        this.designsize_height = designsize_height;

        this.designsize_width = designsize_width;
        this.designsize_format = designsize_format;
        this.patch_qty = patch_qty;

        this.fabric = fabric;
        this.fabric_type = fabric_type;
        this.baking_material = baking_material;

        this.qty = qty;
        this.applique = applique;
        this.numappliques = numappliques;

        this.colorappliques = colorappliques;
        this.designformat = designformat;
        this.timeframe = timeframe;

        this.sewsample = sewsample;
        this.autothread = autothread;
        this.instructions = instructions;

        this.filename = filename;
        this.state = state;
        this.payment = payment;

        this.estimatedate = estimatedate;
        this.deliverydate = deliverydate;
        this.stiches = stiches;

        this.findus = findus;
        this.amount = amount;
        this.paiedstatus = paiedstatus;

        this.originalfile = originalfile;
        this.generatedfile = generatedfile;
        this.pdfFile = pdfFile;

        this.orderDetail = orderDetail;
        this.embFile = embFile;
        this.invoiceDate = invoiceDate;

        this.eta = eta;
        this.estimateDetail = estimateDetail;
        this.assignto = assignto;

        this.digit_by = digit_by;
        this.qc_by = qc_by;
        this.modify_status = modify_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderedby() {
        return orderedby;
    }

    public void setOrderedby(String orderedby) {
        this.orderedby = orderedby;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDesignname() {
        return designname;
    }

    public void setDesignname(String designname) {
        this.designname = designname;
    }

    public String getFormtype() {
        return formtype;
    }

    public void setFormtype(String formtype) {
        this.formtype = formtype;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getIs_estimate() {
        return is_estimate;
    }

    public void setIs_estimate(String is_estimate) {
        this.is_estimate = is_estimate;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getNocolors() {
        return nocolors;
    }

    public void setNocolors(String nocolors) {
        this.nocolors = nocolors;
    }

    public String getNamecolors() {
        return namecolors;
    }

    public void setNamecolors(String namecolors) {
        this.namecolors = namecolors;
    }

    public String getDesignsize_height() {
        return designsize_height;
    }

    public void setDesignsize_height(String designsize_height) {
        this.designsize_height = designsize_height;
    }

    public String getDesignsize_width() {
        return designsize_width;
    }

    public void setDesignsize_width(String designsize_width) {
        this.designsize_width = designsize_width;
    }

    public String getDesignsize_format() {
        return designsize_format;
    }

    public void setDesignsize_format(String designsize_format) {
        this.designsize_format = designsize_format;
    }

    public String getPatch_qty() {
        return patch_qty;
    }

    public void setPatch_qty(String patch_qty) {
        this.patch_qty = patch_qty;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getFabric_type() {
        return fabric_type;
    }

    public void setFabric_type(String fabric_type) {
        this.fabric_type = fabric_type;
    }

    public String getBaking_material() {
        return baking_material;
    }

    public void setBaking_material(String baking_material) {
        this.baking_material = baking_material;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getApplique() {
        return applique;
    }

    public void setApplique(String applique) {
        this.applique = applique;
    }

    public String getNumappliques() {
        return numappliques;
    }

    public void setNumappliques(String numappliques) {
        this.numappliques = numappliques;
    }

    public String getColorappliques() {
        return colorappliques;
    }

    public void setColorappliques(String colorappliques) {
        this.colorappliques = colorappliques;
    }

    public String getDesignformat() {
        return designformat;
    }

    public void setDesignformat(String designformat) {
        this.designformat = designformat;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public String getSewsample() {
        return sewsample;
    }

    public void setSewsample(String sewsample) {
        this.sewsample = sewsample;
    }

    public String getAutothread() {
        return autothread;
    }

    public void setAutothread(String autothread) {
        this.autothread = autothread;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getEstimatedate() {
        return estimatedate;
    }

    public void setEstimatedate(String estimatedate) {
        this.estimatedate = estimatedate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getStiches() {
        return stiches;
    }

    public void setStiches(String stiches) {
        this.stiches = stiches;
    }

    public String getFindus() {
        return findus;
    }

    public void setFindus(String findus) {
        this.findus = findus;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaiedstatus() {
        return paiedstatus;
    }

    public void setPaiedstatus(String paiedstatus) {
        this.paiedstatus = paiedstatus;
    }

    public String getOriginalfile() {
        return originalfile;
    }

    public void setOriginalfile(String originalfile) {
        this.originalfile = originalfile;
    }

    public String getGeneratedfile() {
        return generatedfile;
    }

    public void setGeneratedfile(String generatedfile) {
        this.generatedfile = generatedfile;
    }

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String getEmbFile() {
        return embFile;
    }

    public void setEmbFile(String embFile) {
        this.embFile = embFile;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getEstimateDetail() {
        return estimateDetail;
    }

    public void setEstimateDetail(String estimateDetail) {
        this.estimateDetail = estimateDetail;
    }

    public String getAssignto() {
        return assignto;
    }

    public void setAssignto(String assignto) {
        this.assignto = assignto;
    }

    public String getDigit_by() {
        return digit_by;
    }

    public void setDigit_by(String digit_by) {
        this.digit_by = digit_by;
    }

    public String getQc_by() {
        return qc_by;
    }

    public void setQc_by(String qc_by) {
        this.qc_by = qc_by;
    }

    public String getModify_status() {
        return modify_status;
    }

    public void setModify_status(String modify_status) {
        this.modify_status = modify_status;
    }
}
