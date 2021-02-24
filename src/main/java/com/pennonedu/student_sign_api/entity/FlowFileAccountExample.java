package com.pennonedu.student_sign_api.entity;

import java.util.ArrayList;
import java.util.List;

public class FlowFileAccountExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public FlowFileAccountExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNull() {
            addCriterion("flow_id is null");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNotNull() {
            addCriterion("flow_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlowIdEqualTo(Integer value) {
            addCriterion("flow_id =", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotEqualTo(Integer value) {
            addCriterion("flow_id <>", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThan(Integer value) {
            addCriterion("flow_id >", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_id >=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThan(Integer value) {
            addCriterion("flow_id <", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThanOrEqualTo(Integer value) {
            addCriterion("flow_id <=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdIn(List<Integer> values) {
            addCriterion("flow_id in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotIn(List<Integer> values) {
            addCriterion("flow_id not in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdBetween(Integer value1, Integer value2) {
            addCriterion("flow_id between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_id not between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andSealPathIsNull() {
            addCriterion("seal_path is null");
            return (Criteria) this;
        }

        public Criteria andSealPathIsNotNull() {
            addCriterion("seal_path is not null");
            return (Criteria) this;
        }

        public Criteria andSealPathEqualTo(String value) {
            addCriterion("seal_path =", value, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathNotEqualTo(String value) {
            addCriterion("seal_path <>", value, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathGreaterThan(String value) {
            addCriterion("seal_path >", value, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathGreaterThanOrEqualTo(String value) {
            addCriterion("seal_path >=", value, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathLessThan(String value) {
            addCriterion("seal_path <", value, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathLessThanOrEqualTo(String value) {
            addCriterion("seal_path <=", value, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathLike(String value) {
            addCriterion("seal_path like", value, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathNotLike(String value) {
            addCriterion("seal_path not like", value, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathIn(List<String> values) {
            addCriterion("seal_path in", values, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathNotIn(List<String> values) {
            addCriterion("seal_path not in", values, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathBetween(String value1, String value2) {
            addCriterion("seal_path between", value1, value2, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPathNotBetween(String value1, String value2) {
            addCriterion("seal_path not between", value1, value2, "sealPath");
            return (Criteria) this;
        }

        public Criteria andSealPositionIsNull() {
            addCriterion("seal_position is null");
            return (Criteria) this;
        }

        public Criteria andSealPositionIsNotNull() {
            addCriterion("seal_position is not null");
            return (Criteria) this;
        }

        public Criteria andSealPositionEqualTo(String value) {
            addCriterion("seal_position =", value, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionNotEqualTo(String value) {
            addCriterion("seal_position <>", value, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionGreaterThan(String value) {
            addCriterion("seal_position >", value, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionGreaterThanOrEqualTo(String value) {
            addCriterion("seal_position >=", value, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionLessThan(String value) {
            addCriterion("seal_position <", value, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionLessThanOrEqualTo(String value) {
            addCriterion("seal_position <=", value, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionLike(String value) {
            addCriterion("seal_position like", value, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionNotLike(String value) {
            addCriterion("seal_position not like", value, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionIn(List<String> values) {
            addCriterion("seal_position in", values, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionNotIn(List<String> values) {
            addCriterion("seal_position not in", values, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionBetween(String value1, String value2) {
            addCriterion("seal_position between", value1, value2, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andSealPositionNotBetween(String value1, String value2) {
            addCriterion("seal_position not between", value1, value2, "sealPosition");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Integer value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Integer value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Integer value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Integer value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Integer value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Integer value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Integer> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Integer> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Integer value1, Integer value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Integer value1, Integer value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Integer value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Integer value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Integer value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Integer value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Integer value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Integer value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Integer> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Integer> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Integer value1, Integer value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Integer value1, Integer value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andSealPageIsNull() {
            addCriterion("seal_page is null");
            return (Criteria) this;
        }

        public Criteria andSealPageIsNotNull() {
            addCriterion("seal_page is not null");
            return (Criteria) this;
        }

        public Criteria andSealPageEqualTo(Byte value) {
            addCriterion("seal_page =", value, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealPageNotEqualTo(Byte value) {
            addCriterion("seal_page <>", value, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealPageGreaterThan(Byte value) {
            addCriterion("seal_page >", value, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealPageGreaterThanOrEqualTo(Byte value) {
            addCriterion("seal_page >=", value, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealPageLessThan(Byte value) {
            addCriterion("seal_page <", value, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealPageLessThanOrEqualTo(Byte value) {
            addCriterion("seal_page <=", value, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealPageIn(List<Byte> values) {
            addCriterion("seal_page in", values, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealPageNotIn(List<Byte> values) {
            addCriterion("seal_page not in", values, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealPageBetween(Byte value1, Byte value2) {
            addCriterion("seal_page between", value1, value2, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealPageNotBetween(Byte value1, Byte value2) {
            addCriterion("seal_page not between", value1, value2, "sealPage");
            return (Criteria) this;
        }

        public Criteria andSealWidthIsNull() {
            addCriterion("seal_width is null");
            return (Criteria) this;
        }

        public Criteria andSealWidthIsNotNull() {
            addCriterion("seal_width is not null");
            return (Criteria) this;
        }

        public Criteria andSealWidthEqualTo(Short value) {
            addCriterion("seal_width =", value, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealWidthNotEqualTo(Short value) {
            addCriterion("seal_width <>", value, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealWidthGreaterThan(Short value) {
            addCriterion("seal_width >", value, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealWidthGreaterThanOrEqualTo(Short value) {
            addCriterion("seal_width >=", value, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealWidthLessThan(Short value) {
            addCriterion("seal_width <", value, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealWidthLessThanOrEqualTo(Short value) {
            addCriterion("seal_width <=", value, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealWidthIn(List<Short> values) {
            addCriterion("seal_width in", values, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealWidthNotIn(List<Short> values) {
            addCriterion("seal_width not in", values, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealWidthBetween(Short value1, Short value2) {
            addCriterion("seal_width between", value1, value2, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealWidthNotBetween(Short value1, Short value2) {
            addCriterion("seal_width not between", value1, value2, "sealWidth");
            return (Criteria) this;
        }

        public Criteria andSealHeightIsNull() {
            addCriterion("seal_height is null");
            return (Criteria) this;
        }

        public Criteria andSealHeightIsNotNull() {
            addCriterion("seal_height is not null");
            return (Criteria) this;
        }

        public Criteria andSealHeightEqualTo(Short value) {
            addCriterion("seal_height =", value, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealHeightNotEqualTo(Short value) {
            addCriterion("seal_height <>", value, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealHeightGreaterThan(Short value) {
            addCriterion("seal_height >", value, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealHeightGreaterThanOrEqualTo(Short value) {
            addCriterion("seal_height >=", value, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealHeightLessThan(Short value) {
            addCriterion("seal_height <", value, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealHeightLessThanOrEqualTo(Short value) {
            addCriterion("seal_height <=", value, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealHeightIn(List<Short> values) {
            addCriterion("seal_height in", values, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealHeightNotIn(List<Short> values) {
            addCriterion("seal_height not in", values, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealHeightBetween(Short value1, Short value2) {
            addCriterion("seal_height between", value1, value2, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealHeightNotBetween(Short value1, Short value2) {
            addCriterion("seal_height not between", value1, value2, "sealHeight");
            return (Criteria) this;
        }

        public Criteria andSealLlxIsNull() {
            addCriterion("seal_llx is null");
            return (Criteria) this;
        }

        public Criteria andSealLlxIsNotNull() {
            addCriterion("seal_llx is not null");
            return (Criteria) this;
        }

        public Criteria andSealLlxEqualTo(Float value) {
            addCriterion("seal_llx =", value, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlxNotEqualTo(Float value) {
            addCriterion("seal_llx <>", value, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlxGreaterThan(Float value) {
            addCriterion("seal_llx >", value, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlxGreaterThanOrEqualTo(Float value) {
            addCriterion("seal_llx >=", value, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlxLessThan(Float value) {
            addCriterion("seal_llx <", value, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlxLessThanOrEqualTo(Float value) {
            addCriterion("seal_llx <=", value, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlxIn(List<Float> values) {
            addCriterion("seal_llx in", values, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlxNotIn(List<Float> values) {
            addCriterion("seal_llx not in", values, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlxBetween(Float value1, Float value2) {
            addCriterion("seal_llx between", value1, value2, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlxNotBetween(Float value1, Float value2) {
            addCriterion("seal_llx not between", value1, value2, "sealLlx");
            return (Criteria) this;
        }

        public Criteria andSealLlyIsNull() {
            addCriterion("seal_lly is null");
            return (Criteria) this;
        }

        public Criteria andSealLlyIsNotNull() {
            addCriterion("seal_lly is not null");
            return (Criteria) this;
        }

        public Criteria andSealLlyEqualTo(Float value) {
            addCriterion("seal_lly =", value, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealLlyNotEqualTo(Float value) {
            addCriterion("seal_lly <>", value, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealLlyGreaterThan(Float value) {
            addCriterion("seal_lly >", value, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealLlyGreaterThanOrEqualTo(Float value) {
            addCriterion("seal_lly >=", value, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealLlyLessThan(Float value) {
            addCriterion("seal_lly <", value, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealLlyLessThanOrEqualTo(Float value) {
            addCriterion("seal_lly <=", value, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealLlyIn(List<Float> values) {
            addCriterion("seal_lly in", values, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealLlyNotIn(List<Float> values) {
            addCriterion("seal_lly not in", values, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealLlyBetween(Float value1, Float value2) {
            addCriterion("seal_lly between", value1, value2, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealLlyNotBetween(Float value1, Float value2) {
            addCriterion("seal_lly not between", value1, value2, "sealLly");
            return (Criteria) this;
        }

        public Criteria andSealUrxIsNull() {
            addCriterion("seal_urx is null");
            return (Criteria) this;
        }

        public Criteria andSealUrxIsNotNull() {
            addCriterion("seal_urx is not null");
            return (Criteria) this;
        }

        public Criteria andSealUrxEqualTo(Float value) {
            addCriterion("seal_urx =", value, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUrxNotEqualTo(Float value) {
            addCriterion("seal_urx <>", value, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUrxGreaterThan(Float value) {
            addCriterion("seal_urx >", value, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUrxGreaterThanOrEqualTo(Float value) {
            addCriterion("seal_urx >=", value, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUrxLessThan(Float value) {
            addCriterion("seal_urx <", value, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUrxLessThanOrEqualTo(Float value) {
            addCriterion("seal_urx <=", value, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUrxIn(List<Float> values) {
            addCriterion("seal_urx in", values, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUrxNotIn(List<Float> values) {
            addCriterion("seal_urx not in", values, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUrxBetween(Float value1, Float value2) {
            addCriterion("seal_urx between", value1, value2, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUrxNotBetween(Float value1, Float value2) {
            addCriterion("seal_urx not between", value1, value2, "sealUrx");
            return (Criteria) this;
        }

        public Criteria andSealUryIsNull() {
            addCriterion("seal_ury is null");
            return (Criteria) this;
        }

        public Criteria andSealUryIsNotNull() {
            addCriterion("seal_ury is not null");
            return (Criteria) this;
        }

        public Criteria andSealUryEqualTo(Float value) {
            addCriterion("seal_ury =", value, "sealUry");
            return (Criteria) this;
        }

        public Criteria andSealUryNotEqualTo(Float value) {
            addCriterion("seal_ury <>", value, "sealUry");
            return (Criteria) this;
        }

        public Criteria andSealUryGreaterThan(Float value) {
            addCriterion("seal_ury >", value, "sealUry");
            return (Criteria) this;
        }

        public Criteria andSealUryGreaterThanOrEqualTo(Float value) {
            addCriterion("seal_ury >=", value, "sealUry");
            return (Criteria) this;
        }

        public Criteria andSealUryLessThan(Float value) {
            addCriterion("seal_ury <", value, "sealUry");
            return (Criteria) this;
        }

        public Criteria andSealUryLessThanOrEqualTo(Float value) {
            addCriterion("seal_ury <=", value, "sealUry");
            return (Criteria) this;
        }

        public Criteria andSealUryIn(List<Float> values) {
            addCriterion("seal_ury in", values, "sealUry");
            return (Criteria) this;
        }

        public Criteria andSealUryNotIn(List<Float> values) {
            addCriterion("seal_ury not in", values, "sealUry");
            return (Criteria) this;
        }

        public Criteria andSealUryBetween(Float value1, Float value2) {
            addCriterion("seal_ury between", value1, value2, "sealUry");
            return (Criteria) this;
        }

        public Criteria andSealUryNotBetween(Float value1, Float value2) {
            addCriterion("seal_ury not between", value1, value2, "sealUry");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table flow_file_account
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table flow_file_account
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}