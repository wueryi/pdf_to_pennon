package com.pennonedu.student_sign_api.entity;

import java.io.Serializable;

public class AccountCert implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_cert.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_cert.account_id
     *
     * @mbg.generated
     */
    private Integer accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_cert.path
     *
     * @mbg.generated
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_cert.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_cert.expire_at
     *
     * @mbg.generated
     */
    private Integer expireAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_cert.created_at
     *
     * @mbg.generated
     */
    private Integer createdAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table account_cert
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_cert.id
     *
     * @return the value of account_cert.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_cert
     *
     * @mbg.generated
     */
    public AccountCert withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_cert.id
     *
     * @param id the value for account_cert.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_cert.account_id
     *
     * @return the value of account_cert.account_id
     *
     * @mbg.generated
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_cert
     *
     * @mbg.generated
     */
    public AccountCert withAccountId(Integer accountId) {
        this.setAccountId(accountId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_cert.account_id
     *
     * @param accountId the value for account_cert.account_id
     *
     * @mbg.generated
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_cert.path
     *
     * @return the value of account_cert.path
     *
     * @mbg.generated
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_cert
     *
     * @mbg.generated
     */
    public AccountCert withPath(String path) {
        this.setPath(path);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_cert.path
     *
     * @param path the value for account_cert.path
     *
     * @mbg.generated
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_cert.password
     *
     * @return the value of account_cert.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_cert
     *
     * @mbg.generated
     */
    public AccountCert withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_cert.password
     *
     * @param password the value for account_cert.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_cert.expire_at
     *
     * @return the value of account_cert.expire_at
     *
     * @mbg.generated
     */
    public Integer getExpireAt() {
        return expireAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_cert
     *
     * @mbg.generated
     */
    public AccountCert withExpireAt(Integer expireAt) {
        this.setExpireAt(expireAt);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_cert.expire_at
     *
     * @param expireAt the value for account_cert.expire_at
     *
     * @mbg.generated
     */
    public void setExpireAt(Integer expireAt) {
        this.expireAt = expireAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_cert.created_at
     *
     * @return the value of account_cert.created_at
     *
     * @mbg.generated
     */
    public Integer getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_cert
     *
     * @mbg.generated
     */
    public AccountCert withCreatedAt(Integer createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_cert.created_at
     *
     * @param createdAt the value for account_cert.created_at
     *
     * @mbg.generated
     */
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_cert
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", path=").append(path);
        sb.append(", password=").append(password);
        sb.append(", expireAt=").append(expireAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}