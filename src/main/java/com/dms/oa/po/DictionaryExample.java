package com.dms.oa.po;

import java.util.ArrayList;
import java.util.List;

public class DictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionaryExample() {
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

        public Criteria andDkeyIsNull() {
            addCriterion("dkey is null");
            return (Criteria) this;
        }

        public Criteria andDkeyIsNotNull() {
            addCriterion("dkey is not null");
            return (Criteria) this;
        }

        public Criteria andDkeyEqualTo(Integer value) {
            addCriterion("dkey =", value, "dkey");
            return (Criteria) this;
        }

        public Criteria andDkeyNotEqualTo(Integer value) {
            addCriterion("dkey <>", value, "dkey");
            return (Criteria) this;
        }

        public Criteria andDkeyGreaterThan(Integer value) {
            addCriterion("dkey >", value, "dkey");
            return (Criteria) this;
        }

        public Criteria andDkeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("dkey >=", value, "dkey");
            return (Criteria) this;
        }

        public Criteria andDkeyLessThan(Integer value) {
            addCriterion("dkey <", value, "dkey");
            return (Criteria) this;
        }

        public Criteria andDkeyLessThanOrEqualTo(Integer value) {
            addCriterion("dkey <=", value, "dkey");
            return (Criteria) this;
        }

        public Criteria andDkeyIn(List<Integer> values) {
            addCriterion("dkey in", values, "dkey");
            return (Criteria) this;
        }

        public Criteria andDkeyNotIn(List<Integer> values) {
            addCriterion("dkey not in", values, "dkey");
            return (Criteria) this;
        }

        public Criteria andDkeyBetween(Integer value1, Integer value2) {
            addCriterion("dkey between", value1, value2, "dkey");
            return (Criteria) this;
        }

        public Criteria andDkeyNotBetween(Integer value1, Integer value2) {
            addCriterion("dkey not between", value1, value2, "dkey");
            return (Criteria) this;
        }

        public Criteria andDvalueIsNull() {
            addCriterion("dvalue is null");
            return (Criteria) this;
        }

        public Criteria andDvalueIsNotNull() {
            addCriterion("dvalue is not null");
            return (Criteria) this;
        }

        public Criteria andDvalueEqualTo(String value) {
            addCriterion("dvalue =", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueNotEqualTo(String value) {
            addCriterion("dvalue <>", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueGreaterThan(String value) {
            addCriterion("dvalue >", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueGreaterThanOrEqualTo(String value) {
            addCriterion("dvalue >=", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueLessThan(String value) {
            addCriterion("dvalue <", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueLessThanOrEqualTo(String value) {
            addCriterion("dvalue <=", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueLike(String value) {
            addCriterion("dvalue like", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueNotLike(String value) {
            addCriterion("dvalue not like", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueIn(List<String> values) {
            addCriterion("dvalue in", values, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueNotIn(List<String> values) {
            addCriterion("dvalue not in", values, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueBetween(String value1, String value2) {
            addCriterion("dvalue between", value1, value2, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueNotBetween(String value1, String value2) {
            addCriterion("dvalue not between", value1, value2, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDtypeIsNull() {
            addCriterion("dtype is null");
            return (Criteria) this;
        }

        public Criteria andDtypeIsNotNull() {
            addCriterion("dtype is not null");
            return (Criteria) this;
        }

        public Criteria andDtypeEqualTo(Integer value) {
            addCriterion("dtype =", value, "dtype");
            return (Criteria) this;
        }

        public Criteria andDtypeNotEqualTo(Integer value) {
            addCriterion("dtype <>", value, "dtype");
            return (Criteria) this;
        }

        public Criteria andDtypeGreaterThan(Integer value) {
            addCriterion("dtype >", value, "dtype");
            return (Criteria) this;
        }

        public Criteria andDtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dtype >=", value, "dtype");
            return (Criteria) this;
        }

        public Criteria andDtypeLessThan(Integer value) {
            addCriterion("dtype <", value, "dtype");
            return (Criteria) this;
        }

        public Criteria andDtypeLessThanOrEqualTo(Integer value) {
            addCriterion("dtype <=", value, "dtype");
            return (Criteria) this;
        }

        public Criteria andDtypeIn(List<Integer> values) {
            addCriterion("dtype in", values, "dtype");
            return (Criteria) this;
        }

        public Criteria andDtypeNotIn(List<Integer> values) {
            addCriterion("dtype not in", values, "dtype");
            return (Criteria) this;
        }

        public Criteria andDtypeBetween(Integer value1, Integer value2) {
            addCriterion("dtype between", value1, value2, "dtype");
            return (Criteria) this;
        }

        public Criteria andDtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dtype not between", value1, value2, "dtype");
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