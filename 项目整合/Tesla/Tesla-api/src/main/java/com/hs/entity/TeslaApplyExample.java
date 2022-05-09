package com.hs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeslaApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeslaApplyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Integer value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Integer value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Integer value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Integer value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<Integer> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<Integer> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameIsNull() {
            addCriterion("apply_firstName is null");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameIsNotNull() {
            addCriterion("apply_firstName is not null");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameEqualTo(String value) {
            addCriterion("apply_firstName =", value, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameNotEqualTo(String value) {
            addCriterion("apply_firstName <>", value, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameGreaterThan(String value) {
            addCriterion("apply_firstName >", value, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_firstName >=", value, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameLessThan(String value) {
            addCriterion("apply_firstName <", value, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameLessThanOrEqualTo(String value) {
            addCriterion("apply_firstName <=", value, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameLike(String value) {
            addCriterion("apply_firstName like", value, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameNotLike(String value) {
            addCriterion("apply_firstName not like", value, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameIn(List<String> values) {
            addCriterion("apply_firstName in", values, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameNotIn(List<String> values) {
            addCriterion("apply_firstName not in", values, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameBetween(String value1, String value2) {
            addCriterion("apply_firstName between", value1, value2, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyFirstnameNotBetween(String value1, String value2) {
            addCriterion("apply_firstName not between", value1, value2, "applyFirstname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameIsNull() {
            addCriterion("apply_lastName is null");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameIsNotNull() {
            addCriterion("apply_lastName is not null");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameEqualTo(String value) {
            addCriterion("apply_lastName =", value, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameNotEqualTo(String value) {
            addCriterion("apply_lastName <>", value, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameGreaterThan(String value) {
            addCriterion("apply_lastName >", value, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_lastName >=", value, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameLessThan(String value) {
            addCriterion("apply_lastName <", value, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameLessThanOrEqualTo(String value) {
            addCriterion("apply_lastName <=", value, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameLike(String value) {
            addCriterion("apply_lastName like", value, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameNotLike(String value) {
            addCriterion("apply_lastName not like", value, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameIn(List<String> values) {
            addCriterion("apply_lastName in", values, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameNotIn(List<String> values) {
            addCriterion("apply_lastName not in", values, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameBetween(String value1, String value2) {
            addCriterion("apply_lastName between", value1, value2, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyLastnameNotBetween(String value1, String value2) {
            addCriterion("apply_lastName not between", value1, value2, "applyLastname");
            return (Criteria) this;
        }

        public Criteria andApplyEmailIsNull() {
            addCriterion("apply_email is null");
            return (Criteria) this;
        }

        public Criteria andApplyEmailIsNotNull() {
            addCriterion("apply_email is not null");
            return (Criteria) this;
        }

        public Criteria andApplyEmailEqualTo(String value) {
            addCriterion("apply_email =", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailNotEqualTo(String value) {
            addCriterion("apply_email <>", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailGreaterThan(String value) {
            addCriterion("apply_email >", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailGreaterThanOrEqualTo(String value) {
            addCriterion("apply_email >=", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailLessThan(String value) {
            addCriterion("apply_email <", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailLessThanOrEqualTo(String value) {
            addCriterion("apply_email <=", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailLike(String value) {
            addCriterion("apply_email like", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailNotLike(String value) {
            addCriterion("apply_email not like", value, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailIn(List<String> values) {
            addCriterion("apply_email in", values, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailNotIn(List<String> values) {
            addCriterion("apply_email not in", values, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailBetween(String value1, String value2) {
            addCriterion("apply_email between", value1, value2, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyEmailNotBetween(String value1, String value2) {
            addCriterion("apply_email not between", value1, value2, "applyEmail");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneIsNull() {
            addCriterion("apply_phone is null");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneIsNotNull() {
            addCriterion("apply_phone is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneEqualTo(String value) {
            addCriterion("apply_phone =", value, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNotEqualTo(String value) {
            addCriterion("apply_phone <>", value, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneGreaterThan(String value) {
            addCriterion("apply_phone >", value, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("apply_phone >=", value, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneLessThan(String value) {
            addCriterion("apply_phone <", value, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneLessThanOrEqualTo(String value) {
            addCriterion("apply_phone <=", value, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneLike(String value) {
            addCriterion("apply_phone like", value, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNotLike(String value) {
            addCriterion("apply_phone not like", value, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneIn(List<String> values) {
            addCriterion("apply_phone in", values, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNotIn(List<String> values) {
            addCriterion("apply_phone not in", values, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneBetween(String value1, String value2) {
            addCriterion("apply_phone between", value1, value2, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNotBetween(String value1, String value2) {
            addCriterion("apply_phone not between", value1, value2, "applyPhone");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceIsNull() {
            addCriterion("apply_province is null");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceIsNotNull() {
            addCriterion("apply_province is not null");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceEqualTo(String value) {
            addCriterion("apply_province =", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotEqualTo(String value) {
            addCriterion("apply_province <>", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceGreaterThan(String value) {
            addCriterion("apply_province >", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("apply_province >=", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceLessThan(String value) {
            addCriterion("apply_province <", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceLessThanOrEqualTo(String value) {
            addCriterion("apply_province <=", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceLike(String value) {
            addCriterion("apply_province like", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotLike(String value) {
            addCriterion("apply_province not like", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceIn(List<String> values) {
            addCriterion("apply_province in", values, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotIn(List<String> values) {
            addCriterion("apply_province not in", values, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceBetween(String value1, String value2) {
            addCriterion("apply_province between", value1, value2, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotBetween(String value1, String value2) {
            addCriterion("apply_province not between", value1, value2, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyCityIsNull() {
            addCriterion("apply_city is null");
            return (Criteria) this;
        }

        public Criteria andApplyCityIsNotNull() {
            addCriterion("apply_city is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCityEqualTo(String value) {
            addCriterion("apply_city =", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotEqualTo(String value) {
            addCriterion("apply_city <>", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityGreaterThan(String value) {
            addCriterion("apply_city >", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityGreaterThanOrEqualTo(String value) {
            addCriterion("apply_city >=", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityLessThan(String value) {
            addCriterion("apply_city <", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityLessThanOrEqualTo(String value) {
            addCriterion("apply_city <=", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityLike(String value) {
            addCriterion("apply_city like", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotLike(String value) {
            addCriterion("apply_city not like", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityIn(List<String> values) {
            addCriterion("apply_city in", values, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotIn(List<String> values) {
            addCriterion("apply_city not in", values, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityBetween(String value1, String value2) {
            addCriterion("apply_city between", value1, value2, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotBetween(String value1, String value2) {
            addCriterion("apply_city not between", value1, value2, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNull() {
            addCriterion("apply_status is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNotNull() {
            addCriterion("apply_status is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusEqualTo(String value) {
            addCriterion("apply_status =", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotEqualTo(String value) {
            addCriterion("apply_status <>", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThan(String value) {
            addCriterion("apply_status >", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("apply_status >=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThan(String value) {
            addCriterion("apply_status <", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(String value) {
            addCriterion("apply_status <=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLike(String value) {
            addCriterion("apply_status like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotLike(String value) {
            addCriterion("apply_status not like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIn(List<String> values) {
            addCriterion("apply_status in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotIn(List<String> values) {
            addCriterion("apply_status not in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusBetween(String value1, String value2) {
            addCriterion("apply_status between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotBetween(String value1, String value2) {
            addCriterion("apply_status not between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyProductidIsNull() {
            addCriterion("apply_productId is null");
            return (Criteria) this;
        }

        public Criteria andApplyProductidIsNotNull() {
            addCriterion("apply_productId is not null");
            return (Criteria) this;
        }

        public Criteria andApplyProductidEqualTo(String value) {
            addCriterion("apply_productId =", value, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidNotEqualTo(String value) {
            addCriterion("apply_productId <>", value, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidGreaterThan(String value) {
            addCriterion("apply_productId >", value, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidGreaterThanOrEqualTo(String value) {
            addCriterion("apply_productId >=", value, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidLessThan(String value) {
            addCriterion("apply_productId <", value, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidLessThanOrEqualTo(String value) {
            addCriterion("apply_productId <=", value, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidLike(String value) {
            addCriterion("apply_productId like", value, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidNotLike(String value) {
            addCriterion("apply_productId not like", value, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidIn(List<String> values) {
            addCriterion("apply_productId in", values, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidNotIn(List<String> values) {
            addCriterion("apply_productId not in", values, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidBetween(String value1, String value2) {
            addCriterion("apply_productId between", value1, value2, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyProductidNotBetween(String value1, String value2) {
            addCriterion("apply_productId not between", value1, value2, "applyProductid");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeIsNull() {
            addCriterion("apply_createTime is null");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeIsNotNull() {
            addCriterion("apply_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeEqualTo(Date value) {
            addCriterion("apply_createTime =", value, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeNotEqualTo(Date value) {
            addCriterion("apply_createTime <>", value, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeGreaterThan(Date value) {
            addCriterion("apply_createTime >", value, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_createTime >=", value, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeLessThan(Date value) {
            addCriterion("apply_createTime <", value, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_createTime <=", value, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeIn(List<Date> values) {
            addCriterion("apply_createTime in", values, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeNotIn(List<Date> values) {
            addCriterion("apply_createTime not in", values, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeBetween(Date value1, Date value2) {
            addCriterion("apply_createTime between", value1, value2, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_createTime not between", value1, value2, "applyCreatetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeIsNull() {
            addCriterion("apply_updteTime is null");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeIsNotNull() {
            addCriterion("apply_updteTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeEqualTo(Date value) {
            addCriterion("apply_updteTime =", value, "applyUpdtetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeNotEqualTo(Date value) {
            addCriterion("apply_updteTime <>", value, "applyUpdtetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeGreaterThan(Date value) {
            addCriterion("apply_updteTime >", value, "applyUpdtetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_updteTime >=", value, "applyUpdtetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeLessThan(Date value) {
            addCriterion("apply_updteTime <", value, "applyUpdtetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_updteTime <=", value, "applyUpdtetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeIn(List<Date> values) {
            addCriterion("apply_updteTime in", values, "applyUpdtetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeNotIn(List<Date> values) {
            addCriterion("apply_updteTime not in", values, "applyUpdtetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeBetween(Date value1, Date value2) {
            addCriterion("apply_updteTime between", value1, value2, "applyUpdtetime");
            return (Criteria) this;
        }

        public Criteria andApplyUpdtetimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_updteTime not between", value1, value2, "applyUpdtetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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