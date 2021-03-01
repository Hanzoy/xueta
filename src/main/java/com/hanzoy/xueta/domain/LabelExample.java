package com.hanzoy.xueta.domain;

import java.util.ArrayList;
import java.util.List;

public class LabelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LabelExample() {
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

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("label like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("label not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("label not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andWeektimeIsNull() {
            addCriterion("weekTime is null");
            return (Criteria) this;
        }

        public Criteria andWeektimeIsNotNull() {
            addCriterion("weekTime is not null");
            return (Criteria) this;
        }

        public Criteria andWeektimeEqualTo(Integer value) {
            addCriterion("weekTime =", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeNotEqualTo(Integer value) {
            addCriterion("weekTime <>", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeGreaterThan(Integer value) {
            addCriterion("weekTime >", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("weekTime >=", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeLessThan(Integer value) {
            addCriterion("weekTime <", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeLessThanOrEqualTo(Integer value) {
            addCriterion("weekTime <=", value, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeIn(List<Integer> values) {
            addCriterion("weekTime in", values, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeNotIn(List<Integer> values) {
            addCriterion("weekTime not in", values, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeBetween(Integer value1, Integer value2) {
            addCriterion("weekTime between", value1, value2, "weektime");
            return (Criteria) this;
        }

        public Criteria andWeektimeNotBetween(Integer value1, Integer value2) {
            addCriterion("weekTime not between", value1, value2, "weektime");
            return (Criteria) this;
        }

        public Criteria andAlltimeIsNull() {
            addCriterion("allTime is null");
            return (Criteria) this;
        }

        public Criteria andAlltimeIsNotNull() {
            addCriterion("allTime is not null");
            return (Criteria) this;
        }

        public Criteria andAlltimeEqualTo(Integer value) {
            addCriterion("allTime =", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeNotEqualTo(Integer value) {
            addCriterion("allTime <>", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeGreaterThan(Integer value) {
            addCriterion("allTime >", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("allTime >=", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeLessThan(Integer value) {
            addCriterion("allTime <", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeLessThanOrEqualTo(Integer value) {
            addCriterion("allTime <=", value, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeIn(List<Integer> values) {
            addCriterion("allTime in", values, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeNotIn(List<Integer> values) {
            addCriterion("allTime not in", values, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeBetween(Integer value1, Integer value2) {
            addCriterion("allTime between", value1, value2, "alltime");
            return (Criteria) this;
        }

        public Criteria andAlltimeNotBetween(Integer value1, Integer value2) {
            addCriterion("allTime not between", value1, value2, "alltime");
            return (Criteria) this;
        }

        public Criteria andWeeknumberIsNull() {
            addCriterion("weekNumber is null");
            return (Criteria) this;
        }

        public Criteria andWeeknumberIsNotNull() {
            addCriterion("weekNumber is not null");
            return (Criteria) this;
        }

        public Criteria andWeeknumberEqualTo(Integer value) {
            addCriterion("weekNumber =", value, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andWeeknumberNotEqualTo(Integer value) {
            addCriterion("weekNumber <>", value, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andWeeknumberGreaterThan(Integer value) {
            addCriterion("weekNumber >", value, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andWeeknumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("weekNumber >=", value, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andWeeknumberLessThan(Integer value) {
            addCriterion("weekNumber <", value, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andWeeknumberLessThanOrEqualTo(Integer value) {
            addCriterion("weekNumber <=", value, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andWeeknumberIn(List<Integer> values) {
            addCriterion("weekNumber in", values, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andWeeknumberNotIn(List<Integer> values) {
            addCriterion("weekNumber not in", values, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andWeeknumberBetween(Integer value1, Integer value2) {
            addCriterion("weekNumber between", value1, value2, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andWeeknumberNotBetween(Integer value1, Integer value2) {
            addCriterion("weekNumber not between", value1, value2, "weeknumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberIsNull() {
            addCriterion("allNumber is null");
            return (Criteria) this;
        }

        public Criteria andAllnumberIsNotNull() {
            addCriterion("allNumber is not null");
            return (Criteria) this;
        }

        public Criteria andAllnumberEqualTo(Integer value) {
            addCriterion("allNumber =", value, "allnumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberNotEqualTo(Integer value) {
            addCriterion("allNumber <>", value, "allnumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberGreaterThan(Integer value) {
            addCriterion("allNumber >", value, "allnumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("allNumber >=", value, "allnumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberLessThan(Integer value) {
            addCriterion("allNumber <", value, "allnumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberLessThanOrEqualTo(Integer value) {
            addCriterion("allNumber <=", value, "allnumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberIn(List<Integer> values) {
            addCriterion("allNumber in", values, "allnumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberNotIn(List<Integer> values) {
            addCriterion("allNumber not in", values, "allnumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberBetween(Integer value1, Integer value2) {
            addCriterion("allNumber between", value1, value2, "allnumber");
            return (Criteria) this;
        }

        public Criteria andAllnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("allNumber not between", value1, value2, "allnumber");
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