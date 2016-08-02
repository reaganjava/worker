package com.umbrella.worker.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WCommentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
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
     * This field corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public WCommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
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
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
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

        public Criteria andWMembersIdIsNull() {
            addCriterion("W_MEMBERS_ID is null");
            return (Criteria) this;
        }

        public Criteria andWMembersIdIsNotNull() {
            addCriterion("W_MEMBERS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWMembersIdEqualTo(Integer value) {
            addCriterion("W_MEMBERS_ID =", value, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWMembersIdNotEqualTo(Integer value) {
            addCriterion("W_MEMBERS_ID <>", value, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWMembersIdGreaterThan(Integer value) {
            addCriterion("W_MEMBERS_ID >", value, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWMembersIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_MEMBERS_ID >=", value, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWMembersIdLessThan(Integer value) {
            addCriterion("W_MEMBERS_ID <", value, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWMembersIdLessThanOrEqualTo(Integer value) {
            addCriterion("W_MEMBERS_ID <=", value, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWMembersIdIn(List<Integer> values) {
            addCriterion("W_MEMBERS_ID in", values, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWMembersIdNotIn(List<Integer> values) {
            addCriterion("W_MEMBERS_ID not in", values, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWMembersIdBetween(Integer value1, Integer value2) {
            addCriterion("W_MEMBERS_ID between", value1, value2, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWMembersIdNotBetween(Integer value1, Integer value2) {
            addCriterion("W_MEMBERS_ID not between", value1, value2, "wMembersId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdIsNull() {
            addCriterion("W_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andWStaffIdIsNotNull() {
            addCriterion("W_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWStaffIdEqualTo(Integer value) {
            addCriterion("W_STAFF_ID =", value, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdNotEqualTo(Integer value) {
            addCriterion("W_STAFF_ID <>", value, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdGreaterThan(Integer value) {
            addCriterion("W_STAFF_ID >", value, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("W_STAFF_ID >=", value, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdLessThan(Integer value) {
            addCriterion("W_STAFF_ID <", value, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("W_STAFF_ID <=", value, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdIn(List<Integer> values) {
            addCriterion("W_STAFF_ID in", values, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdNotIn(List<Integer> values) {
            addCriterion("W_STAFF_ID not in", values, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("W_STAFF_ID between", value1, value2, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("W_STAFF_ID not between", value1, value2, "wStaffId");
            return (Criteria) this;
        }

        public Criteria andWCTitleIsNull() {
            addCriterion("W_C_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andWCTitleIsNotNull() {
            addCriterion("W_C_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andWCTitleEqualTo(String value) {
            addCriterion("W_C_TITLE =", value, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleNotEqualTo(String value) {
            addCriterion("W_C_TITLE <>", value, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleGreaterThan(String value) {
            addCriterion("W_C_TITLE >", value, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleGreaterThanOrEqualTo(String value) {
            addCriterion("W_C_TITLE >=", value, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleLessThan(String value) {
            addCriterion("W_C_TITLE <", value, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleLessThanOrEqualTo(String value) {
            addCriterion("W_C_TITLE <=", value, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleLike(String value) {
            addCriterion("W_C_TITLE like", value, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleNotLike(String value) {
            addCriterion("W_C_TITLE not like", value, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleIn(List<String> values) {
            addCriterion("W_C_TITLE in", values, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleNotIn(List<String> values) {
            addCriterion("W_C_TITLE not in", values, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleBetween(String value1, String value2) {
            addCriterion("W_C_TITLE between", value1, value2, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCTitleNotBetween(String value1, String value2) {
            addCriterion("W_C_TITLE not between", value1, value2, "wCTitle");
            return (Criteria) this;
        }

        public Criteria andWCContentIsNull() {
            addCriterion("W_C_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andWCContentIsNotNull() {
            addCriterion("W_C_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andWCContentEqualTo(String value) {
            addCriterion("W_C_CONTENT =", value, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentNotEqualTo(String value) {
            addCriterion("W_C_CONTENT <>", value, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentGreaterThan(String value) {
            addCriterion("W_C_CONTENT >", value, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentGreaterThanOrEqualTo(String value) {
            addCriterion("W_C_CONTENT >=", value, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentLessThan(String value) {
            addCriterion("W_C_CONTENT <", value, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentLessThanOrEqualTo(String value) {
            addCriterion("W_C_CONTENT <=", value, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentLike(String value) {
            addCriterion("W_C_CONTENT like", value, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentNotLike(String value) {
            addCriterion("W_C_CONTENT not like", value, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentIn(List<String> values) {
            addCriterion("W_C_CONTENT in", values, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentNotIn(List<String> values) {
            addCriterion("W_C_CONTENT not in", values, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentBetween(String value1, String value2) {
            addCriterion("W_C_CONTENT between", value1, value2, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCContentNotBetween(String value1, String value2) {
            addCriterion("W_C_CONTENT not between", value1, value2, "wCContent");
            return (Criteria) this;
        }

        public Criteria andWCNicknameIsNull() {
            addCriterion("W_C_NICKNAME is null");
            return (Criteria) this;
        }

        public Criteria andWCNicknameIsNotNull() {
            addCriterion("W_C_NICKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andWCNicknameEqualTo(String value) {
            addCriterion("W_C_NICKNAME =", value, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameNotEqualTo(String value) {
            addCriterion("W_C_NICKNAME <>", value, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameGreaterThan(String value) {
            addCriterion("W_C_NICKNAME >", value, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("W_C_NICKNAME >=", value, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameLessThan(String value) {
            addCriterion("W_C_NICKNAME <", value, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameLessThanOrEqualTo(String value) {
            addCriterion("W_C_NICKNAME <=", value, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameLike(String value) {
            addCriterion("W_C_NICKNAME like", value, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameNotLike(String value) {
            addCriterion("W_C_NICKNAME not like", value, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameIn(List<String> values) {
            addCriterion("W_C_NICKNAME in", values, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameNotIn(List<String> values) {
            addCriterion("W_C_NICKNAME not in", values, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameBetween(String value1, String value2) {
            addCriterion("W_C_NICKNAME between", value1, value2, "wCNickname");
            return (Criteria) this;
        }

        public Criteria andWCNicknameNotBetween(String value1, String value2) {
            addCriterion("W_C_NICKNAME not between", value1, value2, "wCNickname");
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
     * This class corresponds to the database table w_comment
     *
     * @mbggenerated do_not_delete_during_merge Tue Aug 02 16:49:02 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table w_comment
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
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