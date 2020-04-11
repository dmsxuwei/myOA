package com.dms.oa.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskidIsNull() {
            addCriterion("taskid is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(Integer value) {
            addCriterion("taskid =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(Integer value) {
            addCriterion("taskid <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(Integer value) {
            addCriterion("taskid >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskid >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(Integer value) {
            addCriterion("taskid <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(Integer value) {
            addCriterion("taskid <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<Integer> values) {
            addCriterion("taskid in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<Integer> values) {
            addCriterion("taskid not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(Integer value1, Integer value2) {
            addCriterion("taskid between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(Integer value1, Integer value2) {
            addCriterion("taskid not between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNull() {
            addCriterion("projectid is null");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNotNull() {
            addCriterion("projectid is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidEqualTo(Integer value) {
            addCriterion("projectid =", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotEqualTo(Integer value) {
            addCriterion("projectid <>", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThan(Integer value) {
            addCriterion("projectid >", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThanOrEqualTo(Integer value) {
            addCriterion("projectid >=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThan(Integer value) {
            addCriterion("projectid <", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThanOrEqualTo(Integer value) {
            addCriterion("projectid <=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidIn(List<Integer> values) {
            addCriterion("projectid in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotIn(List<Integer> values) {
            addCriterion("projectid not in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidBetween(Integer value1, Integer value2) {
            addCriterion("projectid between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotBetween(Integer value1, Integer value2) {
            addCriterion("projectid not between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNull() {
            addCriterion("taskname is null");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNotNull() {
            addCriterion("taskname is not null");
            return (Criteria) this;
        }

        public Criteria andTasknameEqualTo(String value) {
            addCriterion("taskname =", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotEqualTo(String value) {
            addCriterion("taskname <>", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThan(String value) {
            addCriterion("taskname >", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThanOrEqualTo(String value) {
            addCriterion("taskname >=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThan(String value) {
            addCriterion("taskname <", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThanOrEqualTo(String value) {
            addCriterion("taskname <=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLike(String value) {
            addCriterion("taskname like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotLike(String value) {
            addCriterion("taskname not like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameIn(List<String> values) {
            addCriterion("taskname in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotIn(List<String> values) {
            addCriterion("taskname not in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameBetween(String value1, String value2) {
            addCriterion("taskname between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotBetween(String value1, String value2) {
            addCriterion("taskname not between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionIsNull() {
            addCriterion("taskdescription is null");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionIsNotNull() {
            addCriterion("taskdescription is not null");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionEqualTo(String value) {
            addCriterion("taskdescription =", value, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionNotEqualTo(String value) {
            addCriterion("taskdescription <>", value, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionGreaterThan(String value) {
            addCriterion("taskdescription >", value, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("taskdescription >=", value, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionLessThan(String value) {
            addCriterion("taskdescription <", value, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionLessThanOrEqualTo(String value) {
            addCriterion("taskdescription <=", value, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionLike(String value) {
            addCriterion("taskdescription like", value, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionNotLike(String value) {
            addCriterion("taskdescription not like", value, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionIn(List<String> values) {
            addCriterion("taskdescription in", values, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionNotIn(List<String> values) {
            addCriterion("taskdescription not in", values, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionBetween(String value1, String value2) {
            addCriterion("taskdescription between", value1, value2, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andTaskdescriptionNotBetween(String value1, String value2) {
            addCriterion("taskdescription not between", value1, value2, "taskdescription");
            return (Criteria) this;
        }

        public Criteria andAlltimeIsNull() {
            addCriterion("alltime is null");
            return (Criteria) this;
        }

        public Criteria andAlltimeIsNotNull() {
            addCriterion("alltime is not null");
            return (Criteria) this;
        }

        public Criteria andAlltimeEqualTo(Float value) {
            addCriterion("alltime =", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeNotEqualTo(Float value) {
            addCriterion("alltime <>", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeGreaterThan(Float value) {
            addCriterion("alltime >", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeGreaterThanOrEqualTo(Float value) {
            addCriterion("alltime >=", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeLessThan(Float value) {
            addCriterion("alltime <", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeLessThanOrEqualTo(Float value) {
            addCriterion("alltime <=", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeIn(List<Float> values) {
            addCriterion("alltime in", values, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeNotIn(List<Float> values) {
            addCriterion("alltime not in", values, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeBetween(Float value1, Float value2) {
            addCriterion("alltime between", value1, value2, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeNotBetween(Float value1, Float value2) {
            addCriterion("alltime not between", value1, value2, "alltime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeIsNull() {
            addCriterion("currenttime is null");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeIsNotNull() {
            addCriterion("currenttime is not null");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeEqualTo(Float value) {
            addCriterion("currenttime =", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeNotEqualTo(Float value) {
            addCriterion("currenttime <>", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeGreaterThan(Float value) {
            addCriterion("currenttime >", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeGreaterThanOrEqualTo(Float value) {
            addCriterion("currenttime >=", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeLessThan(Float value) {
            addCriterion("currenttime <", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeLessThanOrEqualTo(Float value) {
            addCriterion("currenttime <=", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeIn(List<Float> values) {
            addCriterion("currenttime in", values, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeNotIn(List<Float> values) {
            addCriterion("currenttime not in", values, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeBetween(Float value1, Float value2) {
            addCriterion("currenttime between", value1, value2, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeNotBetween(Float value1, Float value2) {
            addCriterion("currenttime not between", value1, value2, "currenttime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNull() {
            addCriterion("begintime is null");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNotNull() {
            addCriterion("begintime is not null");
            return (Criteria) this;
        }

        public Criteria andBegintimeEqualTo(Date value) {
            addCriterion("begintime =", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotEqualTo(Date value) {
            addCriterion("begintime <>", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThan(Date value) {
            addCriterion("begintime >", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begintime >=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThan(Date value) {
            addCriterion("begintime <", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThanOrEqualTo(Date value) {
            addCriterion("begintime <=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeIn(List<Date> values) {
            addCriterion("begintime in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotIn(List<Date> values) {
            addCriterion("begintime not in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeBetween(Date value1, Date value2) {
            addCriterion("begintime between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotBetween(Date value1, Date value2) {
            addCriterion("begintime not between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andAllocateidIsNull() {
            addCriterion("allocateid is null");
            return (Criteria) this;
        }

        public Criteria andAllocateidIsNotNull() {
            addCriterion("allocateid is not null");
            return (Criteria) this;
        }

        public Criteria andAllocateidEqualTo(Integer value) {
            addCriterion("allocateid =", value, "allocateid");
            return (Criteria) this;
        }

        public Criteria andAllocateidNotEqualTo(Integer value) {
            addCriterion("allocateid <>", value, "allocateid");
            return (Criteria) this;
        }

        public Criteria andAllocateidGreaterThan(Integer value) {
            addCriterion("allocateid >", value, "allocateid");
            return (Criteria) this;
        }

        public Criteria andAllocateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("allocateid >=", value, "allocateid");
            return (Criteria) this;
        }

        public Criteria andAllocateidLessThan(Integer value) {
            addCriterion("allocateid <", value, "allocateid");
            return (Criteria) this;
        }

        public Criteria andAllocateidLessThanOrEqualTo(Integer value) {
            addCriterion("allocateid <=", value, "allocateid");
            return (Criteria) this;
        }

        public Criteria andAllocateidIn(List<Integer> values) {
            addCriterion("allocateid in", values, "allocateid");
            return (Criteria) this;
        }

        public Criteria andAllocateidNotIn(List<Integer> values) {
            addCriterion("allocateid not in", values, "allocateid");
            return (Criteria) this;
        }

        public Criteria andAllocateidBetween(Integer value1, Integer value2) {
            addCriterion("allocateid between", value1, value2, "allocateid");
            return (Criteria) this;
        }

        public Criteria andAllocateidNotBetween(Integer value1, Integer value2) {
            addCriterion("allocateid not between", value1, value2, "allocateid");
            return (Criteria) this;
        }

        public Criteria andIsvalidityIsNull() {
            addCriterion("isvalidity is null");
            return (Criteria) this;
        }

        public Criteria andIsvalidityIsNotNull() {
            addCriterion("isvalidity is not null");
            return (Criteria) this;
        }

        public Criteria andIsvalidityEqualTo(Integer value) {
            addCriterion("isvalidity =", value, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andIsvalidityNotEqualTo(Integer value) {
            addCriterion("isvalidity <>", value, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andIsvalidityGreaterThan(Integer value) {
            addCriterion("isvalidity >", value, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andIsvalidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("isvalidity >=", value, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andIsvalidityLessThan(Integer value) {
            addCriterion("isvalidity <", value, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andIsvalidityLessThanOrEqualTo(Integer value) {
            addCriterion("isvalidity <=", value, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andIsvalidityIn(List<Integer> values) {
            addCriterion("isvalidity in", values, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andIsvalidityNotIn(List<Integer> values) {
            addCriterion("isvalidity not in", values, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andIsvalidityBetween(Integer value1, Integer value2) {
            addCriterion("isvalidity between", value1, value2, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andIsvalidityNotBetween(Integer value1, Integer value2) {
            addCriterion("isvalidity not between", value1, value2, "isvalidity");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(Integer value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(Integer value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(Integer value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(Integer value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(Integer value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(Integer value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<Integer> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<Integer> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(Integer value1, Integer value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(Integer value1, Integer value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeIsNull() {
            addCriterion("emergencydegree is null");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeIsNotNull() {
            addCriterion("emergencydegree is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeEqualTo(Integer value) {
            addCriterion("emergencydegree =", value, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeNotEqualTo(Integer value) {
            addCriterion("emergencydegree <>", value, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeGreaterThan(Integer value) {
            addCriterion("emergencydegree >", value, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("emergencydegree >=", value, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeLessThan(Integer value) {
            addCriterion("emergencydegree <", value, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeLessThanOrEqualTo(Integer value) {
            addCriterion("emergencydegree <=", value, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeIn(List<Integer> values) {
            addCriterion("emergencydegree in", values, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeNotIn(List<Integer> values) {
            addCriterion("emergencydegree not in", values, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeBetween(Integer value1, Integer value2) {
            addCriterion("emergencydegree between", value1, value2, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andEmergencydegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("emergencydegree not between", value1, value2, "emergencydegree");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(String value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("week like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("week not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andCompletionIsNull() {
            addCriterion("Completion is null");
            return (Criteria) this;
        }

        public Criteria andCompletionIsNotNull() {
            addCriterion("Completion is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionEqualTo(Integer value) {
            addCriterion("Completion =", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotEqualTo(Integer value) {
            addCriterion("Completion <>", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionGreaterThan(Integer value) {
            addCriterion("Completion >", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionGreaterThanOrEqualTo(Integer value) {
            addCriterion("Completion >=", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionLessThan(Integer value) {
            addCriterion("Completion <", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionLessThanOrEqualTo(Integer value) {
            addCriterion("Completion <=", value, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionIn(List<Integer> values) {
            addCriterion("Completion in", values, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotIn(List<Integer> values) {
            addCriterion("Completion not in", values, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionBetween(Integer value1, Integer value2) {
            addCriterion("Completion between", value1, value2, "completion");
            return (Criteria) this;
        }

        public Criteria andCompletionNotBetween(Integer value1, Integer value2) {
            addCriterion("Completion not between", value1, value2, "completion");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNull() {
            addCriterion("departmentid is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("departmentid is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(Integer value) {
            addCriterion("departmentid =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(Integer value) {
            addCriterion("departmentid <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(Integer value) {
            addCriterion("departmentid >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentid >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(Integer value) {
            addCriterion("departmentid <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(Integer value) {
            addCriterion("departmentid <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<Integer> values) {
            addCriterion("departmentid in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<Integer> values) {
            addCriterion("departmentid not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(Integer value1, Integer value2) {
            addCriterion("departmentid between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentid not between", value1, value2, "departmentid");
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