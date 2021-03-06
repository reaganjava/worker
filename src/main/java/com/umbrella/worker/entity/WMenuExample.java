package com.umbrella.worker.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WMenuExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    protected boolean distinct;
    protected String pageByClause;

    public String getPageByClause() {
		return pageByClause;
	}

	public void setPageByClause(String pageByClause) {
		this.pageByClause = pageByClause;
	}
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    public WMenuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
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
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
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

        public Criteria andWMItemIsNull() {
            addCriterion("W_M_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andWMItemIsNotNull() {
            addCriterion("W_M_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andWMItemEqualTo(String value) {
            addCriterion("W_M_ITEM =", value, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemNotEqualTo(String value) {
            addCriterion("W_M_ITEM <>", value, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemGreaterThan(String value) {
            addCriterion("W_M_ITEM >", value, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemGreaterThanOrEqualTo(String value) {
            addCriterion("W_M_ITEM >=", value, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemLessThan(String value) {
            addCriterion("W_M_ITEM <", value, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemLessThanOrEqualTo(String value) {
            addCriterion("W_M_ITEM <=", value, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemLike(String value) {
            addCriterion("W_M_ITEM like", value, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemNotLike(String value) {
            addCriterion("W_M_ITEM not like", value, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemIn(List<String> values) {
            addCriterion("W_M_ITEM in", values, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemNotIn(List<String> values) {
            addCriterion("W_M_ITEM not in", values, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemBetween(String value1, String value2) {
            addCriterion("W_M_ITEM between", value1, value2, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMItemNotBetween(String value1, String value2) {
            addCriterion("W_M_ITEM not between", value1, value2, "wMItem");
            return (Criteria) this;
        }

        public Criteria andWMUrlIsNull() {
            addCriterion("W_M_URL is null");
            return (Criteria) this;
        }

        public Criteria andWMUrlIsNotNull() {
            addCriterion("W_M_URL is not null");
            return (Criteria) this;
        }

        public Criteria andWMUrlEqualTo(String value) {
            addCriterion("W_M_URL =", value, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlNotEqualTo(String value) {
            addCriterion("W_M_URL <>", value, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlGreaterThan(String value) {
            addCriterion("W_M_URL >", value, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlGreaterThanOrEqualTo(String value) {
            addCriterion("W_M_URL >=", value, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlLessThan(String value) {
            addCriterion("W_M_URL <", value, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlLessThanOrEqualTo(String value) {
            addCriterion("W_M_URL <=", value, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlLike(String value) {
            addCriterion("W_M_URL like", value, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlNotLike(String value) {
            addCriterion("W_M_URL not like", value, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlIn(List<String> values) {
            addCriterion("W_M_URL in", values, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlNotIn(List<String> values) {
            addCriterion("W_M_URL not in", values, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlBetween(String value1, String value2) {
            addCriterion("W_M_URL between", value1, value2, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMUrlNotBetween(String value1, String value2) {
            addCriterion("W_M_URL not between", value1, value2, "wMUrl");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdIsNull() {
            addCriterion("W_M_ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdIsNotNull() {
            addCriterion("W_M_ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdEqualTo(Integer value) {
            addCriterion("W_M_ROLE_ID =", value, "wMRoleId");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdNotEqualTo(Integer value) {
            addCriterion("W_M_ROLE_ID <>", value, "wMRoleId");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdGreaterThan(Integer value) {
            addCriterion("W_M_ROLE_ID >", value, "wMRoleId");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_M_ROLE_ID >=", value, "wMRoleId");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdLessThan(Integer value) {
            addCriterion("W_M_ROLE_ID <", value, "wMRoleId");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("W_M_ROLE_ID <=", value, "wMRoleId");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdIn(List<Integer> values) {
            addCriterion("W_M_ROLE_ID in", values, "wMRoleId");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdNotIn(List<Integer> values) {
            addCriterion("W_M_ROLE_ID not in", values, "wMRoleId");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("W_M_ROLE_ID between", value1, value2, "wMRoleId");
            return (Criteria) this;
        }

        public Criteria andWMRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("W_M_ROLE_ID not between", value1, value2, "wMRoleId");
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
     * This class corresponds to the database table w_menu
     *
     * @mbggenerated do_not_delete_during_merge Sun Aug 07 17:15:37 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_menu
     *
     * @mbggenerated Sun Aug 07 17:15:37 CST 2016
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