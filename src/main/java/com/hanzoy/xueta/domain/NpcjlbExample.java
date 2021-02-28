package com.hanzoy.xueta.domain;

import java.util.ArrayList;
import java.util.List;

public class NpcjlbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NpcjlbExample() {
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

        public Criteria andNpcidIsNull() {
            addCriterion("npcid is null");
            return (Criteria) this;
        }

        public Criteria andNpcidIsNotNull() {
            addCriterion("npcid is not null");
            return (Criteria) this;
        }

        public Criteria andNpcidEqualTo(Integer value) {
            addCriterion("npcid =", value, "npcid");
            return (Criteria) this;
        }

        public Criteria andNpcidNotEqualTo(Integer value) {
            addCriterion("npcid <>", value, "npcid");
            return (Criteria) this;
        }

        public Criteria andNpcidGreaterThan(Integer value) {
            addCriterion("npcid >", value, "npcid");
            return (Criteria) this;
        }

        public Criteria andNpcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("npcid >=", value, "npcid");
            return (Criteria) this;
        }

        public Criteria andNpcidLessThan(Integer value) {
            addCriterion("npcid <", value, "npcid");
            return (Criteria) this;
        }

        public Criteria andNpcidLessThanOrEqualTo(Integer value) {
            addCriterion("npcid <=", value, "npcid");
            return (Criteria) this;
        }

        public Criteria andNpcidIn(List<Integer> values) {
            addCriterion("npcid in", values, "npcid");
            return (Criteria) this;
        }

        public Criteria andNpcidNotIn(List<Integer> values) {
            addCriterion("npcid not in", values, "npcid");
            return (Criteria) this;
        }

        public Criteria andNpcidBetween(Integer value1, Integer value2) {
            addCriterion("npcid between", value1, value2, "npcid");
            return (Criteria) this;
        }

        public Criteria andNpcidNotBetween(Integer value1, Integer value2) {
            addCriterion("npcid not between", value1, value2, "npcid");
            return (Criteria) this;
        }

        public Criteria andIshavingIsNull() {
            addCriterion("isHaving is null");
            return (Criteria) this;
        }

        public Criteria andIshavingIsNotNull() {
            addCriterion("isHaving is not null");
            return (Criteria) this;
        }

        public Criteria andIshavingEqualTo(Boolean value) {
            addCriterion("isHaving =", value, "ishaving");
            return (Criteria) this;
        }

        public Criteria andIshavingNotEqualTo(Boolean value) {
            addCriterion("isHaving <>", value, "ishaving");
            return (Criteria) this;
        }

        public Criteria andIshavingGreaterThan(Boolean value) {
            addCriterion("isHaving >", value, "ishaving");
            return (Criteria) this;
        }

        public Criteria andIshavingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isHaving >=", value, "ishaving");
            return (Criteria) this;
        }

        public Criteria andIshavingLessThan(Boolean value) {
            addCriterion("isHaving <", value, "ishaving");
            return (Criteria) this;
        }

        public Criteria andIshavingLessThanOrEqualTo(Boolean value) {
            addCriterion("isHaving <=", value, "ishaving");
            return (Criteria) this;
        }

        public Criteria andIshavingIn(List<Boolean> values) {
            addCriterion("isHaving in", values, "ishaving");
            return (Criteria) this;
        }

        public Criteria andIshavingNotIn(List<Boolean> values) {
            addCriterion("isHaving not in", values, "ishaving");
            return (Criteria) this;
        }

        public Criteria andIshavingBetween(Boolean value1, Boolean value2) {
            addCriterion("isHaving between", value1, value2, "ishaving");
            return (Criteria) this;
        }

        public Criteria andIshavingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isHaving not between", value1, value2, "ishaving");
            return (Criteria) this;
        }

        public Criteria andFavorIsNull() {
            addCriterion("favor is null");
            return (Criteria) this;
        }

        public Criteria andFavorIsNotNull() {
            addCriterion("favor is not null");
            return (Criteria) this;
        }

        public Criteria andFavorEqualTo(Integer value) {
            addCriterion("favor =", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorNotEqualTo(Integer value) {
            addCriterion("favor <>", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorGreaterThan(Integer value) {
            addCriterion("favor >", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorGreaterThanOrEqualTo(Integer value) {
            addCriterion("favor >=", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorLessThan(Integer value) {
            addCriterion("favor <", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorLessThanOrEqualTo(Integer value) {
            addCriterion("favor <=", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorIn(List<Integer> values) {
            addCriterion("favor in", values, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorNotIn(List<Integer> values) {
            addCriterion("favor not in", values, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorBetween(Integer value1, Integer value2) {
            addCriterion("favor between", value1, value2, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorNotBetween(Integer value1, Integer value2) {
            addCriterion("favor not between", value1, value2, "favor");
            return (Criteria) this;
        }

        public Criteria andReidIsNull() {
            addCriterion("Reid is null");
            return (Criteria) this;
        }

        public Criteria andReidIsNotNull() {
            addCriterion("Reid is not null");
            return (Criteria) this;
        }

        public Criteria andReidEqualTo(Integer value) {
            addCriterion("Reid =", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidNotEqualTo(Integer value) {
            addCriterion("Reid <>", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidGreaterThan(Integer value) {
            addCriterion("Reid >", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Reid >=", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidLessThan(Integer value) {
            addCriterion("Reid <", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidLessThanOrEqualTo(Integer value) {
            addCriterion("Reid <=", value, "reid");
            return (Criteria) this;
        }

        public Criteria andReidIn(List<Integer> values) {
            addCriterion("Reid in", values, "reid");
            return (Criteria) this;
        }

        public Criteria andReidNotIn(List<Integer> values) {
            addCriterion("Reid not in", values, "reid");
            return (Criteria) this;
        }

        public Criteria andReidBetween(Integer value1, Integer value2) {
            addCriterion("Reid between", value1, value2, "reid");
            return (Criteria) this;
        }

        public Criteria andReidNotBetween(Integer value1, Integer value2) {
            addCriterion("Reid not between", value1, value2, "reid");
            return (Criteria) this;
        }

        public Criteria andIsdialogueIsNull() {
            addCriterion("isDialogue is null");
            return (Criteria) this;
        }

        public Criteria andIsdialogueIsNotNull() {
            addCriterion("isDialogue is not null");
            return (Criteria) this;
        }

        public Criteria andIsdialogueEqualTo(Boolean value) {
            addCriterion("isDialogue =", value, "isdialogue");
            return (Criteria) this;
        }

        public Criteria andIsdialogueNotEqualTo(Boolean value) {
            addCriterion("isDialogue <>", value, "isdialogue");
            return (Criteria) this;
        }

        public Criteria andIsdialogueGreaterThan(Boolean value) {
            addCriterion("isDialogue >", value, "isdialogue");
            return (Criteria) this;
        }

        public Criteria andIsdialogueGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isDialogue >=", value, "isdialogue");
            return (Criteria) this;
        }

        public Criteria andIsdialogueLessThan(Boolean value) {
            addCriterion("isDialogue <", value, "isdialogue");
            return (Criteria) this;
        }

        public Criteria andIsdialogueLessThanOrEqualTo(Boolean value) {
            addCriterion("isDialogue <=", value, "isdialogue");
            return (Criteria) this;
        }

        public Criteria andIsdialogueIn(List<Boolean> values) {
            addCriterion("isDialogue in", values, "isdialogue");
            return (Criteria) this;
        }

        public Criteria andIsdialogueNotIn(List<Boolean> values) {
            addCriterion("isDialogue not in", values, "isdialogue");
            return (Criteria) this;
        }

        public Criteria andIsdialogueBetween(Boolean value1, Boolean value2) {
            addCriterion("isDialogue between", value1, value2, "isdialogue");
            return (Criteria) this;
        }

        public Criteria andIsdialogueNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isDialogue not between", value1, value2, "isdialogue");
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