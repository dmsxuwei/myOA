package com.dms.oa.po;

import java.util.ArrayList;
import java.util.List;

public class ResourcesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourcesExample() {
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

        public Criteria andResourceidIsNull() {
            addCriterion("resourceid is null");
            return (Criteria) this;
        }

        public Criteria andResourceidIsNotNull() {
            addCriterion("resourceid is not null");
            return (Criteria) this;
        }

        public Criteria andResourceidEqualTo(Integer value) {
            addCriterion("resourceid =", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotEqualTo(Integer value) {
            addCriterion("resourceid <>", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThan(Integer value) {
            addCriterion("resourceid >", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("resourceid >=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThan(Integer value) {
            addCriterion("resourceid <", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThanOrEqualTo(Integer value) {
            addCriterion("resourceid <=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidIn(List<Integer> values) {
            addCriterion("resourceid in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotIn(List<Integer> values) {
            addCriterion("resourceid not in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidBetween(Integer value1, Integer value2) {
            addCriterion("resourceid between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotBetween(Integer value1, Integer value2) {
            addCriterion("resourceid not between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andRosoucenameIsNull() {
            addCriterion("rosoucename is null");
            return (Criteria) this;
        }

        public Criteria andRosoucenameIsNotNull() {
            addCriterion("rosoucename is not null");
            return (Criteria) this;
        }

        public Criteria andRosoucenameEqualTo(String value) {
            addCriterion("rosoucename =", value, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameNotEqualTo(String value) {
            addCriterion("rosoucename <>", value, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameGreaterThan(String value) {
            addCriterion("rosoucename >", value, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameGreaterThanOrEqualTo(String value) {
            addCriterion("rosoucename >=", value, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameLessThan(String value) {
            addCriterion("rosoucename <", value, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameLessThanOrEqualTo(String value) {
            addCriterion("rosoucename <=", value, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameLike(String value) {
            addCriterion("rosoucename like", value, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameNotLike(String value) {
            addCriterion("rosoucename not like", value, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameIn(List<String> values) {
            addCriterion("rosoucename in", values, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameNotIn(List<String> values) {
            addCriterion("rosoucename not in", values, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameBetween(String value1, String value2) {
            addCriterion("rosoucename between", value1, value2, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andRosoucenameNotBetween(String value1, String value2) {
            addCriterion("rosoucename not between", value1, value2, "rosoucename");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andIsendIsNull() {
            addCriterion("isend is null");
            return (Criteria) this;
        }

        public Criteria andIsendIsNotNull() {
            addCriterion("isend is not null");
            return (Criteria) this;
        }

        public Criteria andIsendEqualTo(Integer value) {
            addCriterion("isend =", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendNotEqualTo(Integer value) {
            addCriterion("isend <>", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendGreaterThan(Integer value) {
            addCriterion("isend >", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendGreaterThanOrEqualTo(Integer value) {
            addCriterion("isend >=", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendLessThan(Integer value) {
            addCriterion("isend <", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendLessThanOrEqualTo(Integer value) {
            addCriterion("isend <=", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendIn(List<Integer> values) {
            addCriterion("isend in", values, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendNotIn(List<Integer> values) {
            addCriterion("isend not in", values, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendBetween(Integer value1, Integer value2) {
            addCriterion("isend between", value1, value2, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendNotBetween(Integer value1, Integer value2) {
            addCriterion("isend not between", value1, value2, "isend");
            return (Criteria) this;
        }

        public Criteria andCatagoryIsNull() {
            addCriterion("catagory is null");
            return (Criteria) this;
        }

        public Criteria andCatagoryIsNotNull() {
            addCriterion("catagory is not null");
            return (Criteria) this;
        }

        public Criteria andCatagoryEqualTo(Integer value) {
            addCriterion("catagory =", value, "catagory");
            return (Criteria) this;
        }

        public Criteria andCatagoryNotEqualTo(Integer value) {
            addCriterion("catagory <>", value, "catagory");
            return (Criteria) this;
        }

        public Criteria andCatagoryGreaterThan(Integer value) {
            addCriterion("catagory >", value, "catagory");
            return (Criteria) this;
        }

        public Criteria andCatagoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("catagory >=", value, "catagory");
            return (Criteria) this;
        }

        public Criteria andCatagoryLessThan(Integer value) {
            addCriterion("catagory <", value, "catagory");
            return (Criteria) this;
        }

        public Criteria andCatagoryLessThanOrEqualTo(Integer value) {
            addCriterion("catagory <=", value, "catagory");
            return (Criteria) this;
        }

        public Criteria andCatagoryIn(List<Integer> values) {
            addCriterion("catagory in", values, "catagory");
            return (Criteria) this;
        }

        public Criteria andCatagoryNotIn(List<Integer> values) {
            addCriterion("catagory not in", values, "catagory");
            return (Criteria) this;
        }

        public Criteria andCatagoryBetween(Integer value1, Integer value2) {
            addCriterion("catagory between", value1, value2, "catagory");
            return (Criteria) this;
        }

        public Criteria andCatagoryNotBetween(Integer value1, Integer value2) {
            addCriterion("catagory not between", value1, value2, "catagory");
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