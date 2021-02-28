package com.hanzoy.xueta.domain;

import java.util.ArrayList;
import java.util.List;

public class DialogueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DialogueExample() {
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andIscontinueIsNull() {
            addCriterion("isContinue is null");
            return (Criteria) this;
        }

        public Criteria andIscontinueIsNotNull() {
            addCriterion("isContinue is not null");
            return (Criteria) this;
        }

        public Criteria andIscontinueEqualTo(Boolean value) {
            addCriterion("isContinue =", value, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andIscontinueNotEqualTo(Boolean value) {
            addCriterion("isContinue <>", value, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andIscontinueGreaterThan(Boolean value) {
            addCriterion("isContinue >", value, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andIscontinueGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isContinue >=", value, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andIscontinueLessThan(Boolean value) {
            addCriterion("isContinue <", value, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andIscontinueLessThanOrEqualTo(Boolean value) {
            addCriterion("isContinue <=", value, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andIscontinueIn(List<Boolean> values) {
            addCriterion("isContinue in", values, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andIscontinueNotIn(List<Boolean> values) {
            addCriterion("isContinue not in", values, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andIscontinueBetween(Boolean value1, Boolean value2) {
            addCriterion("isContinue between", value1, value2, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andIscontinueNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isContinue not between", value1, value2, "iscontinue");
            return (Criteria) this;
        }

        public Criteria andNextidIsNull() {
            addCriterion("nextid is null");
            return (Criteria) this;
        }

        public Criteria andNextidIsNotNull() {
            addCriterion("nextid is not null");
            return (Criteria) this;
        }

        public Criteria andNextidEqualTo(Integer value) {
            addCriterion("nextid =", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidNotEqualTo(Integer value) {
            addCriterion("nextid <>", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidGreaterThan(Integer value) {
            addCriterion("nextid >", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidGreaterThanOrEqualTo(Integer value) {
            addCriterion("nextid >=", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidLessThan(Integer value) {
            addCriterion("nextid <", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidLessThanOrEqualTo(Integer value) {
            addCriterion("nextid <=", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidIn(List<Integer> values) {
            addCriterion("nextid in", values, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidNotIn(List<Integer> values) {
            addCriterion("nextid not in", values, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidBetween(Integer value1, Integer value2) {
            addCriterion("nextid between", value1, value2, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidNotBetween(Integer value1, Integer value2) {
            addCriterion("nextid not between", value1, value2, "nextid");
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