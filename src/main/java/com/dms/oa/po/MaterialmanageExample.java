package com.dms.oa.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterialmanageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialmanageExample() {
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

        public Criteria andMatIdIsNull() {
            addCriterion("mat_id is null");
            return (Criteria) this;
        }

        public Criteria andMatIdIsNotNull() {
            addCriterion("mat_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatIdEqualTo(Integer value) {
            addCriterion("mat_id =", value, "matId");
            return (Criteria) this;
        }

        public Criteria andMatIdNotEqualTo(Integer value) {
            addCriterion("mat_id <>", value, "matId");
            return (Criteria) this;
        }

        public Criteria andMatIdGreaterThan(Integer value) {
            addCriterion("mat_id >", value, "matId");
            return (Criteria) this;
        }

        public Criteria andMatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mat_id >=", value, "matId");
            return (Criteria) this;
        }

        public Criteria andMatIdLessThan(Integer value) {
            addCriterion("mat_id <", value, "matId");
            return (Criteria) this;
        }

        public Criteria andMatIdLessThanOrEqualTo(Integer value) {
            addCriterion("mat_id <=", value, "matId");
            return (Criteria) this;
        }

        public Criteria andMatIdIn(List<Integer> values) {
            addCriterion("mat_id in", values, "matId");
            return (Criteria) this;
        }

        public Criteria andMatIdNotIn(List<Integer> values) {
            addCriterion("mat_id not in", values, "matId");
            return (Criteria) this;
        }

        public Criteria andMatIdBetween(Integer value1, Integer value2) {
            addCriterion("mat_id between", value1, value2, "matId");
            return (Criteria) this;
        }

        public Criteria andMatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mat_id not between", value1, value2, "matId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
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

        public Criteria andManageIsNull() {
            addCriterion("manage is null");
            return (Criteria) this;
        }

        public Criteria andManageIsNotNull() {
            addCriterion("manage is not null");
            return (Criteria) this;
        }

        public Criteria andManageEqualTo(String value) {
            addCriterion("manage =", value, "manage");
            return (Criteria) this;
        }

        public Criteria andManageNotEqualTo(String value) {
            addCriterion("manage <>", value, "manage");
            return (Criteria) this;
        }

        public Criteria andManageGreaterThan(String value) {
            addCriterion("manage >", value, "manage");
            return (Criteria) this;
        }

        public Criteria andManageGreaterThanOrEqualTo(String value) {
            addCriterion("manage >=", value, "manage");
            return (Criteria) this;
        }

        public Criteria andManageLessThan(String value) {
            addCriterion("manage <", value, "manage");
            return (Criteria) this;
        }

        public Criteria andManageLessThanOrEqualTo(String value) {
            addCriterion("manage <=", value, "manage");
            return (Criteria) this;
        }

        public Criteria andManageLike(String value) {
            addCriterion("manage like", value, "manage");
            return (Criteria) this;
        }

        public Criteria andManageNotLike(String value) {
            addCriterion("manage not like", value, "manage");
            return (Criteria) this;
        }

        public Criteria andManageIn(List<String> values) {
            addCriterion("manage in", values, "manage");
            return (Criteria) this;
        }

        public Criteria andManageNotIn(List<String> values) {
            addCriterion("manage not in", values, "manage");
            return (Criteria) this;
        }

        public Criteria andManageBetween(String value1, String value2) {
            addCriterion("manage between", value1, value2, "manage");
            return (Criteria) this;
        }

        public Criteria andManageNotBetween(String value1, String value2) {
            addCriterion("manage not between", value1, value2, "manage");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeIsNull() {
            addCriterion("warehousingtime is null");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeIsNotNull() {
            addCriterion("warehousingtime is not null");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeEqualTo(Date value) {
            addCriterion("warehousingtime =", value, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeNotEqualTo(Date value) {
            addCriterion("warehousingtime <>", value, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeGreaterThan(Date value) {
            addCriterion("warehousingtime >", value, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("warehousingtime >=", value, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeLessThan(Date value) {
            addCriterion("warehousingtime <", value, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeLessThanOrEqualTo(Date value) {
            addCriterion("warehousingtime <=", value, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeIn(List<Date> values) {
            addCriterion("warehousingtime in", values, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeNotIn(List<Date> values) {
            addCriterion("warehousingtime not in", values, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeBetween(Date value1, Date value2) {
            addCriterion("warehousingtime between", value1, value2, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andWarehousingtimeNotBetween(Date value1, Date value2) {
            addCriterion("warehousingtime not between", value1, value2, "warehousingtime");
            return (Criteria) this;
        }

        public Criteria andIsoutIsNull() {
            addCriterion("isout is null");
            return (Criteria) this;
        }

        public Criteria andIsoutIsNotNull() {
            addCriterion("isout is not null");
            return (Criteria) this;
        }

        public Criteria andIsoutEqualTo(Integer value) {
            addCriterion("isout =", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotEqualTo(Integer value) {
            addCriterion("isout <>", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutGreaterThan(Integer value) {
            addCriterion("isout >", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("isout >=", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutLessThan(Integer value) {
            addCriterion("isout <", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutLessThanOrEqualTo(Integer value) {
            addCriterion("isout <=", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutIn(List<Integer> values) {
            addCriterion("isout in", values, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotIn(List<Integer> values) {
            addCriterion("isout not in", values, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutBetween(Integer value1, Integer value2) {
            addCriterion("isout between", value1, value2, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotBetween(Integer value1, Integer value2) {
            addCriterion("isout not between", value1, value2, "isout");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNull() {
            addCriterion("outtime is null");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNotNull() {
            addCriterion("outtime is not null");
            return (Criteria) this;
        }

        public Criteria andOuttimeEqualTo(Date value) {
            addCriterion("outtime =", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotEqualTo(Date value) {
            addCriterion("outtime <>", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThan(Date value) {
            addCriterion("outtime >", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("outtime >=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThan(Date value) {
            addCriterion("outtime <", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThanOrEqualTo(Date value) {
            addCriterion("outtime <=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIn(List<Date> values) {
            addCriterion("outtime in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotIn(List<Date> values) {
            addCriterion("outtime not in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeBetween(Date value1, Date value2) {
            addCriterion("outtime between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotBetween(Date value1, Date value2) {
            addCriterion("outtime not between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andIscomposeIsNull() {
            addCriterion("iscompose is null");
            return (Criteria) this;
        }

        public Criteria andIscomposeIsNotNull() {
            addCriterion("iscompose is not null");
            return (Criteria) this;
        }

        public Criteria andIscomposeEqualTo(Integer value) {
            addCriterion("iscompose =", value, "iscompose");
            return (Criteria) this;
        }

        public Criteria andIscomposeNotEqualTo(Integer value) {
            addCriterion("iscompose <>", value, "iscompose");
            return (Criteria) this;
        }

        public Criteria andIscomposeGreaterThan(Integer value) {
            addCriterion("iscompose >", value, "iscompose");
            return (Criteria) this;
        }

        public Criteria andIscomposeGreaterThanOrEqualTo(Integer value) {
            addCriterion("iscompose >=", value, "iscompose");
            return (Criteria) this;
        }

        public Criteria andIscomposeLessThan(Integer value) {
            addCriterion("iscompose <", value, "iscompose");
            return (Criteria) this;
        }

        public Criteria andIscomposeLessThanOrEqualTo(Integer value) {
            addCriterion("iscompose <=", value, "iscompose");
            return (Criteria) this;
        }

        public Criteria andIscomposeIn(List<Integer> values) {
            addCriterion("iscompose in", values, "iscompose");
            return (Criteria) this;
        }

        public Criteria andIscomposeNotIn(List<Integer> values) {
            addCriterion("iscompose not in", values, "iscompose");
            return (Criteria) this;
        }

        public Criteria andIscomposeBetween(Integer value1, Integer value2) {
            addCriterion("iscompose between", value1, value2, "iscompose");
            return (Criteria) this;
        }

        public Criteria andIscomposeNotBetween(Integer value1, Integer value2) {
            addCriterion("iscompose not between", value1, value2, "iscompose");
            return (Criteria) this;
        }

        public Criteria andComposeidIsNull() {
            addCriterion("composeid is null");
            return (Criteria) this;
        }

        public Criteria andComposeidIsNotNull() {
            addCriterion("composeid is not null");
            return (Criteria) this;
        }

        public Criteria andComposeidEqualTo(Integer value) {
            addCriterion("composeid =", value, "composeid");
            return (Criteria) this;
        }

        public Criteria andComposeidNotEqualTo(Integer value) {
            addCriterion("composeid <>", value, "composeid");
            return (Criteria) this;
        }

        public Criteria andComposeidGreaterThan(Integer value) {
            addCriterion("composeid >", value, "composeid");
            return (Criteria) this;
        }

        public Criteria andComposeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("composeid >=", value, "composeid");
            return (Criteria) this;
        }

        public Criteria andComposeidLessThan(Integer value) {
            addCriterion("composeid <", value, "composeid");
            return (Criteria) this;
        }

        public Criteria andComposeidLessThanOrEqualTo(Integer value) {
            addCriterion("composeid <=", value, "composeid");
            return (Criteria) this;
        }

        public Criteria andComposeidIn(List<Integer> values) {
            addCriterion("composeid in", values, "composeid");
            return (Criteria) this;
        }

        public Criteria andComposeidNotIn(List<Integer> values) {
            addCriterion("composeid not in", values, "composeid");
            return (Criteria) this;
        }

        public Criteria andComposeidBetween(Integer value1, Integer value2) {
            addCriterion("composeid between", value1, value2, "composeid");
            return (Criteria) this;
        }

        public Criteria andComposeidNotBetween(Integer value1, Integer value2) {
            addCriterion("composeid not between", value1, value2, "composeid");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
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