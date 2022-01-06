package com.tesla.entity;

import java.util.ArrayList;
import java.util.List;

public class TeslaCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeslaCarExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarTitleIsNull() {
            addCriterion("car_title is null");
            return (Criteria) this;
        }

        public Criteria andCarTitleIsNotNull() {
            addCriterion("car_title is not null");
            return (Criteria) this;
        }

        public Criteria andCarTitleEqualTo(String value) {
            addCriterion("car_title =", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleNotEqualTo(String value) {
            addCriterion("car_title <>", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleGreaterThan(String value) {
            addCriterion("car_title >", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleGreaterThanOrEqualTo(String value) {
            addCriterion("car_title >=", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleLessThan(String value) {
            addCriterion("car_title <", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleLessThanOrEqualTo(String value) {
            addCriterion("car_title <=", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleLike(String value) {
            addCriterion("car_title like", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleNotLike(String value) {
            addCriterion("car_title not like", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleIn(List<String> values) {
            addCriterion("car_title in", values, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleNotIn(List<String> values) {
            addCriterion("car_title not in", values, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleBetween(String value1, String value2) {
            addCriterion("car_title between", value1, value2, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleNotBetween(String value1, String value2) {
            addCriterion("car_title not between", value1, value2, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarImgurlIsNull() {
            addCriterion("car_imgurl is null");
            return (Criteria) this;
        }

        public Criteria andCarImgurlIsNotNull() {
            addCriterion("car_imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andCarImgurlEqualTo(String value) {
            addCriterion("car_imgurl =", value, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlNotEqualTo(String value) {
            addCriterion("car_imgurl <>", value, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlGreaterThan(String value) {
            addCriterion("car_imgurl >", value, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("car_imgurl >=", value, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlLessThan(String value) {
            addCriterion("car_imgurl <", value, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlLessThanOrEqualTo(String value) {
            addCriterion("car_imgurl <=", value, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlLike(String value) {
            addCriterion("car_imgurl like", value, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlNotLike(String value) {
            addCriterion("car_imgurl not like", value, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlIn(List<String> values) {
            addCriterion("car_imgurl in", values, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlNotIn(List<String> values) {
            addCriterion("car_imgurl not in", values, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlBetween(String value1, String value2) {
            addCriterion("car_imgurl between", value1, value2, "carImgurl");
            return (Criteria) this;
        }

        public Criteria andCarImgurlNotBetween(String value1, String value2) {
            addCriterion("car_imgurl not between", value1, value2, "carImgurl");
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
