package com.dms.oa.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UnittestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnittestExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andUnittestidIsNull() {
            addCriterion("unittestid is null");
            return (Criteria) this;
        }

        public Criteria andUnittestidIsNotNull() {
            addCriterion("unittestid is not null");
            return (Criteria) this;
        }

        public Criteria andUnittestidEqualTo(Integer value) {
            addCriterion("unittestid =", value, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUnittestidNotEqualTo(Integer value) {
            addCriterion("unittestid <>", value, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUnittestidGreaterThan(Integer value) {
            addCriterion("unittestid >", value, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUnittestidGreaterThanOrEqualTo(Integer value) {
            addCriterion("unittestid >=", value, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUnittestidLessThan(Integer value) {
            addCriterion("unittestid <", value, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUnittestidLessThanOrEqualTo(Integer value) {
            addCriterion("unittestid <=", value, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUnittestidIn(List<Integer> values) {
            addCriterion("unittestid in", values, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUnittestidNotIn(List<Integer> values) {
            addCriterion("unittestid not in", values, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUnittestidBetween(Integer value1, Integer value2) {
            addCriterion("unittestid between", value1, value2, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUnittestidNotBetween(Integer value1, Integer value2) {
            addCriterion("unittestid not between", value1, value2, "unittestid");
            return (Criteria) this;
        }

        public Criteria andUsridIsNull() {
            addCriterion("usrid is null");
            return (Criteria) this;
        }

        public Criteria andUsridIsNotNull() {
            addCriterion("usrid is not null");
            return (Criteria) this;
        }

        public Criteria andUsridEqualTo(Integer value) {
            addCriterion("usrid =", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotEqualTo(Integer value) {
            addCriterion("usrid <>", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridGreaterThan(Integer value) {
            addCriterion("usrid >", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridGreaterThanOrEqualTo(Integer value) {
            addCriterion("usrid >=", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridLessThan(Integer value) {
            addCriterion("usrid <", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridLessThanOrEqualTo(Integer value) {
            addCriterion("usrid <=", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridIn(List<Integer> values) {
            addCriterion("usrid in", values, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotIn(List<Integer> values) {
            addCriterion("usrid not in", values, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridBetween(Integer value1, Integer value2) {
            addCriterion("usrid between", value1, value2, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotBetween(Integer value1, Integer value2) {
            addCriterion("usrid not between", value1, value2, "usrid");
            return (Criteria) this;
        }

        public Criteria andTestprojectIsNull() {
            addCriterion("testproject is null");
            return (Criteria) this;
        }

        public Criteria andTestprojectIsNotNull() {
            addCriterion("testproject is not null");
            return (Criteria) this;
        }

        public Criteria andTestprojectEqualTo(String value) {
            addCriterion("testproject =", value, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectNotEqualTo(String value) {
            addCriterion("testproject <>", value, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectGreaterThan(String value) {
            addCriterion("testproject >", value, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectGreaterThanOrEqualTo(String value) {
            addCriterion("testproject >=", value, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectLessThan(String value) {
            addCriterion("testproject <", value, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectLessThanOrEqualTo(String value) {
            addCriterion("testproject <=", value, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectLike(String value) {
            addCriterion("testproject like", value, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectNotLike(String value) {
            addCriterion("testproject not like", value, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectIn(List<String> values) {
            addCriterion("testproject in", values, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectNotIn(List<String> values) {
            addCriterion("testproject not in", values, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectBetween(String value1, String value2) {
            addCriterion("testproject between", value1, value2, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestprojectNotBetween(String value1, String value2) {
            addCriterion("testproject not between", value1, value2, "testproject");
            return (Criteria) this;
        }

        public Criteria andTestunitIsNull() {
            addCriterion("testunit is null");
            return (Criteria) this;
        }

        public Criteria andTestunitIsNotNull() {
            addCriterion("testunit is not null");
            return (Criteria) this;
        }

        public Criteria andTestunitEqualTo(String value) {
            addCriterion("testunit =", value, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitNotEqualTo(String value) {
            addCriterion("testunit <>", value, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitGreaterThan(String value) {
            addCriterion("testunit >", value, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitGreaterThanOrEqualTo(String value) {
            addCriterion("testunit >=", value, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitLessThan(String value) {
            addCriterion("testunit <", value, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitLessThanOrEqualTo(String value) {
            addCriterion("testunit <=", value, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitLike(String value) {
            addCriterion("testunit like", value, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitNotLike(String value) {
            addCriterion("testunit not like", value, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitIn(List<String> values) {
            addCriterion("testunit in", values, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitNotIn(List<String> values) {
            addCriterion("testunit not in", values, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitBetween(String value1, String value2) {
            addCriterion("testunit between", value1, value2, "testunit");
            return (Criteria) this;
        }

        public Criteria andTestunitNotBetween(String value1, String value2) {
            addCriterion("testunit not between", value1, value2, "testunit");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(Integer value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Integer value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Integer value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Integer value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Integer value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<Integer> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<Integer> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Integer value1, Integer value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Integer value1, Integer value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andTesttimeIsNull() {
            addCriterion("testtime is null");
            return (Criteria) this;
        }

        public Criteria andTesttimeIsNotNull() {
            addCriterion("testtime is not null");
            return (Criteria) this;
        }

        public Criteria andTesttimeEqualTo(Date value) {
            addCriterion("testtime =", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotEqualTo(Date value) {
            addCriterion("testtime <>", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeGreaterThan(Date value) {
            addCriterion("testtime >", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("testtime >=", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeLessThan(Date value) {
            addCriterion("testtime <", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeLessThanOrEqualTo(Date value) {
            addCriterion("testtime <=", value, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeIn(List<Date> values) {
            addCriterion("testtime in", values, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotIn(List<Date> values) {
            addCriterion("testtime not in", values, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeBetween(Date value1, Date value2) {
            addCriterion("testtime between", value1, value2, "testtime");
            return (Criteria) this;
        }

        public Criteria andTesttimeNotBetween(Date value1, Date value2) {
            addCriterion("testtime not between", value1, value2, "testtime");
            return (Criteria) this;
        }

        public Criteria andBakIsNull() {
            addCriterion("bak is null");
            return (Criteria) this;
        }

        public Criteria andBakIsNotNull() {
            addCriterion("bak is not null");
            return (Criteria) this;
        }

        public Criteria andBakEqualTo(String value) {
            addCriterion("bak =", value, "bak");
            return (Criteria) this;
        }

        public Criteria andBakNotEqualTo(String value) {
            addCriterion("bak <>", value, "bak");
            return (Criteria) this;
        }

        public Criteria andBakGreaterThan(String value) {
            addCriterion("bak >", value, "bak");
            return (Criteria) this;
        }

        public Criteria andBakGreaterThanOrEqualTo(String value) {
            addCriterion("bak >=", value, "bak");
            return (Criteria) this;
        }

        public Criteria andBakLessThan(String value) {
            addCriterion("bak <", value, "bak");
            return (Criteria) this;
        }

        public Criteria andBakLessThanOrEqualTo(String value) {
            addCriterion("bak <=", value, "bak");
            return (Criteria) this;
        }

        public Criteria andBakLike(String value) {
            addCriterion("bak like", value, "bak");
            return (Criteria) this;
        }

        public Criteria andBakNotLike(String value) {
            addCriterion("bak not like", value, "bak");
            return (Criteria) this;
        }

        public Criteria andBakIn(List<String> values) {
            addCriterion("bak in", values, "bak");
            return (Criteria) this;
        }

        public Criteria andBakNotIn(List<String> values) {
            addCriterion("bak not in", values, "bak");
            return (Criteria) this;
        }

        public Criteria andBakBetween(String value1, String value2) {
            addCriterion("bak between", value1, value2, "bak");
            return (Criteria) this;
        }

        public Criteria andBakNotBetween(String value1, String value2) {
            addCriterion("bak not between", value1, value2, "bak");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCTime("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCTime("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCTime("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCTime("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("createtime not between", value1, value2, "createtime");
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