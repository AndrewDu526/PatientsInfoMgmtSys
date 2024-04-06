package com.diy.pojo;

public class Brand {
    // id ��?
    private Integer id;

    // �i�v����
    private String brandName;
    // ��?����
    private String companyName;
    // �r�����i
    private Integer ordered;
    // �`�q�M��
    private String description;
    // ��?�F0�F�֗p  1�F?�p
    private Integer status;

    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }
    //????
    public String getStatusStr(){
        if (status == null){
            return "unknown";
        }
        return status == 0 ? "Disable":"Enable";
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}

