package com.umbrella.worker.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WWorkerTaskExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public WWorkerTaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
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
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWWSupplierIsNull() {
            addCriterion("W_W_SUPPLIER is null");
            return (Criteria) this;
        }

        public Criteria andWWSupplierIsNotNull() {
            addCriterion("W_W_SUPPLIER is not null");
            return (Criteria) this;
        }

        public Criteria andWWSupplierEqualTo(Integer value) {
            addCriterion("W_W_SUPPLIER =", value, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWSupplierNotEqualTo(Integer value) {
            addCriterion("W_W_SUPPLIER <>", value, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWSupplierGreaterThan(Integer value) {
            addCriterion("W_W_SUPPLIER >", value, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWSupplierGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_W_SUPPLIER >=", value, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWSupplierLessThan(Integer value) {
            addCriterion("W_W_SUPPLIER <", value, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWSupplierLessThanOrEqualTo(Integer value) {
            addCriterion("W_W_SUPPLIER <=", value, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWSupplierIn(List<Integer> values) {
            addCriterion("W_W_SUPPLIER in", values, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWSupplierNotIn(List<Integer> values) {
            addCriterion("W_W_SUPPLIER not in", values, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWSupplierBetween(Integer value1, Integer value2) {
            addCriterion("W_W_SUPPLIER between", value1, value2, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWSupplierNotBetween(Integer value1, Integer value2) {
            addCriterion("W_W_SUPPLIER not between", value1, value2, "wWSupplier");
            return (Criteria) this;
        }

        public Criteria andWWNameIsNull() {
            addCriterion("W_W_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWWNameIsNotNull() {
            addCriterion("W_W_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWWNameEqualTo(String value) {
            addCriterion("W_W_NAME =", value, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameNotEqualTo(String value) {
            addCriterion("W_W_NAME <>", value, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameGreaterThan(String value) {
            addCriterion("W_W_NAME >", value, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameGreaterThanOrEqualTo(String value) {
            addCriterion("W_W_NAME >=", value, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameLessThan(String value) {
            addCriterion("W_W_NAME <", value, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameLessThanOrEqualTo(String value) {
            addCriterion("W_W_NAME <=", value, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameLike(String value) {
            addCriterion("W_W_NAME like", value, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameNotLike(String value) {
            addCriterion("W_W_NAME not like", value, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameIn(List<String> values) {
            addCriterion("W_W_NAME in", values, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameNotIn(List<String> values) {
            addCriterion("W_W_NAME not in", values, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameBetween(String value1, String value2) {
            addCriterion("W_W_NAME between", value1, value2, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWNameNotBetween(String value1, String value2) {
            addCriterion("W_W_NAME not between", value1, value2, "wWName");
            return (Criteria) this;
        }

        public Criteria andWWPriceIsNull() {
            addCriterion("W_W_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andWWPriceIsNotNull() {
            addCriterion("W_W_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andWWPriceEqualTo(Integer value) {
            addCriterion("W_W_PRICE =", value, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceNotEqualTo(Integer value) {
            addCriterion("W_W_PRICE <>", value, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceGreaterThan(Integer value) {
            addCriterion("W_W_PRICE >", value, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_W_PRICE >=", value, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceLessThan(Integer value) {
            addCriterion("W_W_PRICE <", value, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceLessThanOrEqualTo(Integer value) {
            addCriterion("W_W_PRICE <=", value, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceIn(List<Integer> values) {
            addCriterion("W_W_PRICE in", values, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceNotIn(List<Integer> values) {
            addCriterion("W_W_PRICE not in", values, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceBetween(Integer value1, Integer value2) {
            addCriterion("W_W_PRICE between", value1, value2, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("W_W_PRICE not between", value1, value2, "wWPrice");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitIsNull() {
            addCriterion("W_W_PRICE_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitIsNotNull() {
            addCriterion("W_W_PRICE_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitEqualTo(Integer value) {
            addCriterion("W_W_PRICE_UNIT =", value, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitNotEqualTo(Integer value) {
            addCriterion("W_W_PRICE_UNIT <>", value, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitGreaterThan(Integer value) {
            addCriterion("W_W_PRICE_UNIT >", value, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_W_PRICE_UNIT >=", value, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitLessThan(Integer value) {
            addCriterion("W_W_PRICE_UNIT <", value, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitLessThanOrEqualTo(Integer value) {
            addCriterion("W_W_PRICE_UNIT <=", value, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitIn(List<Integer> values) {
            addCriterion("W_W_PRICE_UNIT in", values, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitNotIn(List<Integer> values) {
            addCriterion("W_W_PRICE_UNIT not in", values, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitBetween(Integer value1, Integer value2) {
            addCriterion("W_W_PRICE_UNIT between", value1, value2, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWPriceUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("W_W_PRICE_UNIT not between", value1, value2, "wWPriceUnit");
            return (Criteria) this;
        }

        public Criteria andWWTypeIsNull() {
            addCriterion("W_W_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWWTypeIsNotNull() {
            addCriterion("W_W_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWWTypeEqualTo(Integer value) {
            addCriterion("W_W_TYPE =", value, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWTypeNotEqualTo(Integer value) {
            addCriterion("W_W_TYPE <>", value, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWTypeGreaterThan(Integer value) {
            addCriterion("W_W_TYPE >", value, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_W_TYPE >=", value, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWTypeLessThan(Integer value) {
            addCriterion("W_W_TYPE <", value, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWTypeLessThanOrEqualTo(Integer value) {
            addCriterion("W_W_TYPE <=", value, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWTypeIn(List<Integer> values) {
            addCriterion("W_W_TYPE in", values, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWTypeNotIn(List<Integer> values) {
            addCriterion("W_W_TYPE not in", values, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWTypeBetween(Integer value1, Integer value2) {
            addCriterion("W_W_TYPE between", value1, value2, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("W_W_TYPE not between", value1, value2, "wWType");
            return (Criteria) this;
        }

        public Criteria andWWDescIsNull() {
            addCriterion("W_W_DESC is null");
            return (Criteria) this;
        }

        public Criteria andWWDescIsNotNull() {
            addCriterion("W_W_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andWWDescEqualTo(String value) {
            addCriterion("W_W_DESC =", value, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescNotEqualTo(String value) {
            addCriterion("W_W_DESC <>", value, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescGreaterThan(String value) {
            addCriterion("W_W_DESC >", value, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescGreaterThanOrEqualTo(String value) {
            addCriterion("W_W_DESC >=", value, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescLessThan(String value) {
            addCriterion("W_W_DESC <", value, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescLessThanOrEqualTo(String value) {
            addCriterion("W_W_DESC <=", value, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescLike(String value) {
            addCriterion("W_W_DESC like", value, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescNotLike(String value) {
            addCriterion("W_W_DESC not like", value, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescIn(List<String> values) {
            addCriterion("W_W_DESC in", values, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescNotIn(List<String> values) {
            addCriterion("W_W_DESC not in", values, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescBetween(String value1, String value2) {
            addCriterion("W_W_DESC between", value1, value2, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andWWDescNotBetween(String value1, String value2) {
            addCriterion("W_W_DESC not between", value1, value2, "wWDesc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorIsNull() {
            addCriterion("CREATE_AUTHOR is null");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorIsNotNull() {
            addCriterion("CREATE_AUTHOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorEqualTo(String value) {
            addCriterion("CREATE_AUTHOR =", value, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorNotEqualTo(String value) {
            addCriterion("CREATE_AUTHOR <>", value, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorGreaterThan(String value) {
            addCriterion("CREATE_AUTHOR >", value, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_AUTHOR >=", value, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorLessThan(String value) {
            addCriterion("CREATE_AUTHOR <", value, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorLessThanOrEqualTo(String value) {
            addCriterion("CREATE_AUTHOR <=", value, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorLike(String value) {
            addCriterion("CREATE_AUTHOR like", value, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorNotLike(String value) {
            addCriterion("CREATE_AUTHOR not like", value, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorIn(List<String> values) {
            addCriterion("CREATE_AUTHOR in", values, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorNotIn(List<String> values) {
            addCriterion("CREATE_AUTHOR not in", values, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorBetween(String value1, String value2) {
            addCriterion("CREATE_AUTHOR between", value1, value2, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andCreateAuthorNotBetween(String value1, String value2) {
            addCriterion("CREATE_AUTHOR not between", value1, value2, "createAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiTimeIsNull() {
            addCriterion("MODIFI_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifiTimeIsNotNull() {
            addCriterion("MODIFI_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifiTimeEqualTo(Date value) {
            addCriterion("MODIFI_TIME =", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeNotEqualTo(Date value) {
            addCriterion("MODIFI_TIME <>", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeGreaterThan(Date value) {
            addCriterion("MODIFI_TIME >", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFI_TIME >=", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeLessThan(Date value) {
            addCriterion("MODIFI_TIME <", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFI_TIME <=", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeIn(List<Date> values) {
            addCriterion("MODIFI_TIME in", values, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeNotIn(List<Date> values) {
            addCriterion("MODIFI_TIME not in", values, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFI_TIME between", value1, value2, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFI_TIME not between", value1, value2, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorIsNull() {
            addCriterion("MODIFI_AUTHOR is null");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorIsNotNull() {
            addCriterion("MODIFI_AUTHOR is not null");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorEqualTo(String value) {
            addCriterion("MODIFI_AUTHOR =", value, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorNotEqualTo(String value) {
            addCriterion("MODIFI_AUTHOR <>", value, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorGreaterThan(String value) {
            addCriterion("MODIFI_AUTHOR >", value, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFI_AUTHOR >=", value, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorLessThan(String value) {
            addCriterion("MODIFI_AUTHOR <", value, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorLessThanOrEqualTo(String value) {
            addCriterion("MODIFI_AUTHOR <=", value, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorLike(String value) {
            addCriterion("MODIFI_AUTHOR like", value, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorNotLike(String value) {
            addCriterion("MODIFI_AUTHOR not like", value, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorIn(List<String> values) {
            addCriterion("MODIFI_AUTHOR in", values, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorNotIn(List<String> values) {
            addCriterion("MODIFI_AUTHOR not in", values, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorBetween(String value1, String value2) {
            addCriterion("MODIFI_AUTHOR between", value1, value2, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andModifiAuthorNotBetween(String value1, String value2) {
            addCriterion("MODIFI_AUTHOR not between", value1, value2, "modifiAuthor");
            return (Criteria) this;
        }

        public Criteria andDatalevelIsNull() {
            addCriterion("DATALEVEL is null");
            return (Criteria) this;
        }

        public Criteria andDatalevelIsNotNull() {
            addCriterion("DATALEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andDatalevelEqualTo(Integer value) {
            addCriterion("DATALEVEL =", value, "datalevel");
            return (Criteria) this;
        }

        public Criteria andDatalevelNotEqualTo(Integer value) {
            addCriterion("DATALEVEL <>", value, "datalevel");
            return (Criteria) this;
        }

        public Criteria andDatalevelGreaterThan(Integer value) {
            addCriterion("DATALEVEL >", value, "datalevel");
            return (Criteria) this;
        }

        public Criteria andDatalevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("DATALEVEL >=", value, "datalevel");
            return (Criteria) this;
        }

        public Criteria andDatalevelLessThan(Integer value) {
            addCriterion("DATALEVEL <", value, "datalevel");
            return (Criteria) this;
        }

        public Criteria andDatalevelLessThanOrEqualTo(Integer value) {
            addCriterion("DATALEVEL <=", value, "datalevel");
            return (Criteria) this;
        }

        public Criteria andDatalevelIn(List<Integer> values) {
            addCriterion("DATALEVEL in", values, "datalevel");
            return (Criteria) this;
        }

        public Criteria andDatalevelNotIn(List<Integer> values) {
            addCriterion("DATALEVEL not in", values, "datalevel");
            return (Criteria) this;
        }

        public Criteria andDatalevelBetween(Integer value1, Integer value2) {
            addCriterion("DATALEVEL between", value1, value2, "datalevel");
            return (Criteria) this;
        }

        public Criteria andDatalevelNotBetween(Integer value1, Integer value2) {
            addCriterion("DATALEVEL not between", value1, value2, "datalevel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_worker_task
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 03 14:05:33 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_worker_task
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
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