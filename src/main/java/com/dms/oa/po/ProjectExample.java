package com.dms.oa.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProjectnameIsNull() {
            addCriterion("projectname is null");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNotNull() {
            addCriterion("projectname is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnameEqualTo(String value) {
            addCriterion("projectname =", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotEqualTo(String value) {
            addCriterion("projectname <>", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThan(String value) {
            addCriterion("projectname >", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("projectname >=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThan(String value) {
            addCriterion("projectname <", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThanOrEqualTo(String value) {
            addCriterion("projectname <=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLike(String value) {
            addCriterion("projectname like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotLike(String value) {
            addCriterion("projectname not like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameIn(List<String> values) {
            addCriterion("projectname in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotIn(List<String> values) {
            addCriterion("projectname not in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameBetween(String value1, String value2) {
            addCriterion("projectname between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotBetween(String value1, String value2) {
            addCriterion("projectname not between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonIsNull() {
            addCriterion("projectdescripton is null");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonIsNotNull() {
            addCriterion("projectdescripton is not null");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonEqualTo(String value) {
            addCriterion("projectdescripton =", value, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonNotEqualTo(String value) {
            addCriterion("projectdescripton <>", value, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonGreaterThan(String value) {
            addCriterion("projectdescripton >", value, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonGreaterThanOrEqualTo(String value) {
            addCriterion("projectdescripton >=", value, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonLessThan(String value) {
            addCriterion("projectdescripton <", value, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonLessThanOrEqualTo(String value) {
            addCriterion("projectdescripton <=", value, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonLike(String value) {
            addCriterion("projectdescripton like", value, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonNotLike(String value) {
            addCriterion("projectdescripton not like", value, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonIn(List<String> values) {
            addCriterion("projectdescripton in", values, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonNotIn(List<String> values) {
            addCriterion("projectdescripton not in", values, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonBetween(String value1, String value2) {
            addCriterion("projectdescripton between", value1, value2, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectdescriptonNotBetween(String value1, String value2) {
            addCriterion("projectdescripton not between", value1, value2, "projectdescripton");
            return (Criteria) this;
        }

        public Criteria andProjectstateIsNull() {
            addCriterion("projectstate is null");
            return (Criteria) this;
        }

        public Criteria andProjectstateIsNotNull() {
            addCriterion("projectstate is not null");
            return (Criteria) this;
        }

        public Criteria andProjectstateEqualTo(Integer value) {
            addCriterion("projectstate =", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateNotEqualTo(Integer value) {
            addCriterion("projectstate <>", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateGreaterThan(Integer value) {
            addCriterion("projectstate >", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("projectstate >=", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateLessThan(Integer value) {
            addCriterion("projectstate <", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateLessThanOrEqualTo(Integer value) {
            addCriterion("projectstate <=", value, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateIn(List<Integer> values) {
            addCriterion("projectstate in", values, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateNotIn(List<Integer> values) {
            addCriterion("projectstate not in", values, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateBetween(Integer value1, Integer value2) {
            addCriterion("projectstate between", value1, value2, "projectstate");
            return (Criteria) this;
        }

        public Criteria andProjectstateNotBetween(Integer value1, Integer value2) {
            addCriterion("projectstate not between", value1, value2, "projectstate");
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

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("num like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("num not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andMainclassIsNull() {
            addCriterion("mainclass is null");
            return (Criteria) this;
        }

        public Criteria andMainclassIsNotNull() {
            addCriterion("mainclass is not null");
            return (Criteria) this;
        }

        public Criteria andMainclassEqualTo(Integer value) {
            addCriterion("mainclass =", value, "mainclass");
            return (Criteria) this;
        }

        public Criteria andMainclassNotEqualTo(Integer value) {
            addCriterion("mainclass <>", value, "mainclass");
            return (Criteria) this;
        }

        public Criteria andMainclassGreaterThan(Integer value) {
            addCriterion("mainclass >", value, "mainclass");
            return (Criteria) this;
        }

        public Criteria andMainclassGreaterThanOrEqualTo(Integer value) {
            addCriterion("mainclass >=", value, "mainclass");
            return (Criteria) this;
        }

        public Criteria andMainclassLessThan(Integer value) {
            addCriterion("mainclass <", value, "mainclass");
            return (Criteria) this;
        }

        public Criteria andMainclassLessThanOrEqualTo(Integer value) {
            addCriterion("mainclass <=", value, "mainclass");
            return (Criteria) this;
        }

        public Criteria andMainclassIn(List<Integer> values) {
            addCriterion("mainclass in", values, "mainclass");
            return (Criteria) this;
        }

        public Criteria andMainclassNotIn(List<Integer> values) {
            addCriterion("mainclass not in", values, "mainclass");
            return (Criteria) this;
        }

        public Criteria andMainclassBetween(Integer value1, Integer value2) {
            addCriterion("mainclass between", value1, value2, "mainclass");
            return (Criteria) this;
        }

        public Criteria andMainclassNotBetween(Integer value1, Integer value2) {
            addCriterion("mainclass not between", value1, value2, "mainclass");
            return (Criteria) this;
        }

        public Criteria andSubclassIsNull() {
            addCriterion("subclass is null");
            return (Criteria) this;
        }

        public Criteria andSubclassIsNotNull() {
            addCriterion("subclass is not null");
            return (Criteria) this;
        }

        public Criteria andSubclassEqualTo(Integer value) {
            addCriterion("subclass =", value, "subclass");
            return (Criteria) this;
        }

        public Criteria andSubclassNotEqualTo(Integer value) {
            addCriterion("subclass <>", value, "subclass");
            return (Criteria) this;
        }

        public Criteria andSubclassGreaterThan(Integer value) {
            addCriterion("subclass >", value, "subclass");
            return (Criteria) this;
        }

        public Criteria andSubclassGreaterThanOrEqualTo(Integer value) {
            addCriterion("subclass >=", value, "subclass");
            return (Criteria) this;
        }

        public Criteria andSubclassLessThan(Integer value) {
            addCriterion("subclass <", value, "subclass");
            return (Criteria) this;
        }

        public Criteria andSubclassLessThanOrEqualTo(Integer value) {
            addCriterion("subclass <=", value, "subclass");
            return (Criteria) this;
        }

        public Criteria andSubclassIn(List<Integer> values) {
            addCriterion("subclass in", values, "subclass");
            return (Criteria) this;
        }

        public Criteria andSubclassNotIn(List<Integer> values) {
            addCriterion("subclass not in", values, "subclass");
            return (Criteria) this;
        }

        public Criteria andSubclassBetween(Integer value1, Integer value2) {
            addCriterion("subclass between", value1, value2, "subclass");
            return (Criteria) this;
        }

        public Criteria andSubclassNotBetween(Integer value1, Integer value2) {
            addCriterion("subclass not between", value1, value2, "subclass");
            return (Criteria) this;
        }

        public Criteria andProjectsourceIsNull() {
            addCriterion("projectsource is null");
            return (Criteria) this;
        }

        public Criteria andProjectsourceIsNotNull() {
            addCriterion("projectsource is not null");
            return (Criteria) this;
        }

        public Criteria andProjectsourceEqualTo(Integer value) {
            addCriterion("projectsource =", value, "projectsource");
            return (Criteria) this;
        }

        public Criteria andProjectsourceNotEqualTo(Integer value) {
            addCriterion("projectsource <>", value, "projectsource");
            return (Criteria) this;
        }

        public Criteria andProjectsourceGreaterThan(Integer value) {
            addCriterion("projectsource >", value, "projectsource");
            return (Criteria) this;
        }

        public Criteria andProjectsourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("projectsource >=", value, "projectsource");
            return (Criteria) this;
        }

        public Criteria andProjectsourceLessThan(Integer value) {
            addCriterion("projectsource <", value, "projectsource");
            return (Criteria) this;
        }

        public Criteria andProjectsourceLessThanOrEqualTo(Integer value) {
            addCriterion("projectsource <=", value, "projectsource");
            return (Criteria) this;
        }

        public Criteria andProjectsourceIn(List<Integer> values) {
            addCriterion("projectsource in", values, "projectsource");
            return (Criteria) this;
        }

        public Criteria andProjectsourceNotIn(List<Integer> values) {
            addCriterion("projectsource not in", values, "projectsource");
            return (Criteria) this;
        }

        public Criteria andProjectsourceBetween(Integer value1, Integer value2) {
            addCriterion("projectsource between", value1, value2, "projectsource");
            return (Criteria) this;
        }

        public Criteria andProjectsourceNotBetween(Integer value1, Integer value2) {
            addCriterion("projectsource not between", value1, value2, "projectsource");
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