package com.umbrella.worker.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WOrderTaskExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    public WOrderTaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
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
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
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

        public Criteria andWOOrderIdIsNull() {
            addCriterion("W_O_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdIsNotNull() {
            addCriterion("W_O_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdEqualTo(Integer value) {
            addCriterion("W_O_ORDER_ID =", value, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdNotEqualTo(Integer value) {
            addCriterion("W_O_ORDER_ID <>", value, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdGreaterThan(Integer value) {
            addCriterion("W_O_ORDER_ID >", value, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_O_ORDER_ID >=", value, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdLessThan(Integer value) {
            addCriterion("W_O_ORDER_ID <", value, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("W_O_ORDER_ID <=", value, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdIn(List<Integer> values) {
            addCriterion("W_O_ORDER_ID in", values, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdNotIn(List<Integer> values) {
            addCriterion("W_O_ORDER_ID not in", values, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("W_O_ORDER_ID between", value1, value2, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("W_O_ORDER_ID not between", value1, value2, "wOOrderId");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameIsNull() {
            addCriterion("W_O_TASK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameIsNotNull() {
            addCriterion("W_O_TASK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameEqualTo(String value) {
            addCriterion("W_O_TASK_NAME =", value, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameNotEqualTo(String value) {
            addCriterion("W_O_TASK_NAME <>", value, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameGreaterThan(String value) {
            addCriterion("W_O_TASK_NAME >", value, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("W_O_TASK_NAME >=", value, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameLessThan(String value) {
            addCriterion("W_O_TASK_NAME <", value, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameLessThanOrEqualTo(String value) {
            addCriterion("W_O_TASK_NAME <=", value, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameLike(String value) {
            addCriterion("W_O_TASK_NAME like", value, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameNotLike(String value) {
            addCriterion("W_O_TASK_NAME not like", value, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameIn(List<String> values) {
            addCriterion("W_O_TASK_NAME in", values, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameNotIn(List<String> values) {
            addCriterion("W_O_TASK_NAME not in", values, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameBetween(String value1, String value2) {
            addCriterion("W_O_TASK_NAME between", value1, value2, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskNameNotBetween(String value1, String value2) {
            addCriterion("W_O_TASK_NAME not between", value1, value2, "wOTaskName");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceIsNull() {
            addCriterion("W_O_TASK_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceIsNotNull() {
            addCriterion("W_O_TASK_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceEqualTo(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE =", value, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceNotEqualTo(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE <>", value, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceGreaterThan(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE >", value, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE >=", value, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceLessThan(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE <", value, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE <=", value, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceIn(List<BigDecimal> values) {
            addCriterion("W_O_TASK_PRICE in", values, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceNotIn(List<BigDecimal> values) {
            addCriterion("W_O_TASK_PRICE not in", values, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("W_O_TASK_PRICE between", value1, value2, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("W_O_TASK_PRICE not between", value1, value2, "wOTaskPrice");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountIsNull() {
            addCriterion("W_O_TASK_PRICE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountIsNotNull() {
            addCriterion("W_O_TASK_PRICE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountEqualTo(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE_COUNT =", value, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountNotEqualTo(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE_COUNT <>", value, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountGreaterThan(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE_COUNT >", value, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE_COUNT >=", value, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountLessThan(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE_COUNT <", value, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("W_O_TASK_PRICE_COUNT <=", value, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountIn(List<BigDecimal> values) {
            addCriterion("W_O_TASK_PRICE_COUNT in", values, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountNotIn(List<BigDecimal> values) {
            addCriterion("W_O_TASK_PRICE_COUNT not in", values, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("W_O_TASK_PRICE_COUNT between", value1, value2, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskPriceCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("W_O_TASK_PRICE_COUNT not between", value1, value2, "wOTaskPriceCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemIsNull() {
            addCriterion("W_O_TASK_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemIsNotNull() {
            addCriterion("W_O_TASK_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemEqualTo(String value) {
            addCriterion("W_O_TASK_ITEM =", value, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemNotEqualTo(String value) {
            addCriterion("W_O_TASK_ITEM <>", value, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemGreaterThan(String value) {
            addCriterion("W_O_TASK_ITEM >", value, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemGreaterThanOrEqualTo(String value) {
            addCriterion("W_O_TASK_ITEM >=", value, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemLessThan(String value) {
            addCriterion("W_O_TASK_ITEM <", value, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemLessThanOrEqualTo(String value) {
            addCriterion("W_O_TASK_ITEM <=", value, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemLike(String value) {
            addCriterion("W_O_TASK_ITEM like", value, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemNotLike(String value) {
            addCriterion("W_O_TASK_ITEM not like", value, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemIn(List<String> values) {
            addCriterion("W_O_TASK_ITEM in", values, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemNotIn(List<String> values) {
            addCriterion("W_O_TASK_ITEM not in", values, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemBetween(String value1, String value2) {
            addCriterion("W_O_TASK_ITEM between", value1, value2, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskItemNotBetween(String value1, String value2) {
            addCriterion("W_O_TASK_ITEM not between", value1, value2, "wOTaskItem");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountIsNull() {
            addCriterion("W_O_TASK_STAFF_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountIsNotNull() {
            addCriterion("W_O_TASK_STAFF_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountEqualTo(Integer value) {
            addCriterion("W_O_TASK_STAFF_COUNT =", value, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountNotEqualTo(Integer value) {
            addCriterion("W_O_TASK_STAFF_COUNT <>", value, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountGreaterThan(Integer value) {
            addCriterion("W_O_TASK_STAFF_COUNT >", value, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_O_TASK_STAFF_COUNT >=", value, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountLessThan(Integer value) {
            addCriterion("W_O_TASK_STAFF_COUNT <", value, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountLessThanOrEqualTo(Integer value) {
            addCriterion("W_O_TASK_STAFF_COUNT <=", value, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountIn(List<Integer> values) {
            addCriterion("W_O_TASK_STAFF_COUNT in", values, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountNotIn(List<Integer> values) {
            addCriterion("W_O_TASK_STAFF_COUNT not in", values, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountBetween(Integer value1, Integer value2) {
            addCriterion("W_O_TASK_STAFF_COUNT between", value1, value2, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskStaffCountNotBetween(Integer value1, Integer value2) {
            addCriterion("W_O_TASK_STAFF_COUNT not between", value1, value2, "wOTaskStaffCount");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursIsNull() {
            addCriterion("W_O_TASK_HOURS is null");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursIsNotNull() {
            addCriterion("W_O_TASK_HOURS is not null");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursEqualTo(Integer value) {
            addCriterion("W_O_TASK_HOURS =", value, "wOTaskHours");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursNotEqualTo(Integer value) {
            addCriterion("W_O_TASK_HOURS <>", value, "wOTaskHours");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursGreaterThan(Integer value) {
            addCriterion("W_O_TASK_HOURS >", value, "wOTaskHours");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_O_TASK_HOURS >=", value, "wOTaskHours");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursLessThan(Integer value) {
            addCriterion("W_O_TASK_HOURS <", value, "wOTaskHours");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursLessThanOrEqualTo(Integer value) {
            addCriterion("W_O_TASK_HOURS <=", value, "wOTaskHours");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursIn(List<Integer> values) {
            addCriterion("W_O_TASK_HOURS in", values, "wOTaskHours");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursNotIn(List<Integer> values) {
            addCriterion("W_O_TASK_HOURS not in", values, "wOTaskHours");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursBetween(Integer value1, Integer value2) {
            addCriterion("W_O_TASK_HOURS between", value1, value2, "wOTaskHours");
            return (Criteria) this;
        }

        public Criteria andWOTaskHoursNotBetween(Integer value1, Integer value2) {
            addCriterion("W_O_TASK_HOURS not between", value1, value2, "wOTaskHours");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_order_task
     *
     * @mbggenerated do_not_delete_during_merge Sun Aug 14 17:09:54 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_order_task
     *
     * @mbggenerated Sun Aug 14 17:09:54 CST 2016
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