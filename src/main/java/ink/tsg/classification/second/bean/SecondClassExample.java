package ink.tsg.classification.second.bean;

import java.util.ArrayList;
import java.util.List;

public class SecondClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecondClassExample() {
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

        public Criteria andSclassificationIdIsNull() {
            addCriterion("sclassification_id is null");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdIsNotNull() {
            addCriterion("sclassification_id is not null");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdEqualTo(Integer value) {
            addCriterion("sclassification_id =", value, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdNotEqualTo(Integer value) {
            addCriterion("sclassification_id <>", value, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdGreaterThan(Integer value) {
            addCriterion("sclassification_id >", value, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sclassification_id >=", value, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdLessThan(Integer value) {
            addCriterion("sclassification_id <", value, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdLessThanOrEqualTo(Integer value) {
            addCriterion("sclassification_id <=", value, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdIn(List<Integer> values) {
            addCriterion("sclassification_id in", values, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdNotIn(List<Integer> values) {
            addCriterion("sclassification_id not in", values, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdBetween(Integer value1, Integer value2) {
            addCriterion("sclassification_id between", value1, value2, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sclassification_id not between", value1, value2, "sclassificationId");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameIsNull() {
            addCriterion("sclassification_name is null");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameIsNotNull() {
            addCriterion("sclassification_name is not null");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameEqualTo(String value) {
            addCriterion("sclassification_name =", value, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameNotEqualTo(String value) {
            addCriterion("sclassification_name <>", value, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameGreaterThan(String value) {
            addCriterion("sclassification_name >", value, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameGreaterThanOrEqualTo(String value) {
            addCriterion("sclassification_name >=", value, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameLessThan(String value) {
            addCriterion("sclassification_name <", value, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameLessThanOrEqualTo(String value) {
            addCriterion("sclassification_name <=", value, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameLike(String value) {
            addCriterion("sclassification_name like", value, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameNotLike(String value) {
            addCriterion("sclassification_name not like", value, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameIn(List<String> values) {
            addCriterion("sclassification_name in", values, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameNotIn(List<String> values) {
            addCriterion("sclassification_name not in", values, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameBetween(String value1, String value2) {
            addCriterion("sclassification_name between", value1, value2, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andSclassificationNameNotBetween(String value1, String value2) {
            addCriterion("sclassification_name not between", value1, value2, "sclassificationName");
            return (Criteria) this;
        }

        public Criteria andScFcIdIsNull() {
            addCriterion("sc_fc_id is null");
            return (Criteria) this;
        }

        public Criteria andScFcIdIsNotNull() {
            addCriterion("sc_fc_id is not null");
            return (Criteria) this;
        }

        public Criteria andScFcIdEqualTo(Integer value) {
            addCriterion("sc_fc_id =", value, "scFcId");
            return (Criteria) this;
        }

        public Criteria andScFcIdNotEqualTo(Integer value) {
            addCriterion("sc_fc_id <>", value, "scFcId");
            return (Criteria) this;
        }

        public Criteria andScFcIdGreaterThan(Integer value) {
            addCriterion("sc_fc_id >", value, "scFcId");
            return (Criteria) this;
        }

        public Criteria andScFcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sc_fc_id >=", value, "scFcId");
            return (Criteria) this;
        }

        public Criteria andScFcIdLessThan(Integer value) {
            addCriterion("sc_fc_id <", value, "scFcId");
            return (Criteria) this;
        }

        public Criteria andScFcIdLessThanOrEqualTo(Integer value) {
            addCriterion("sc_fc_id <=", value, "scFcId");
            return (Criteria) this;
        }

        public Criteria andScFcIdIn(List<Integer> values) {
            addCriterion("sc_fc_id in", values, "scFcId");
            return (Criteria) this;
        }

        public Criteria andScFcIdNotIn(List<Integer> values) {
            addCriterion("sc_fc_id not in", values, "scFcId");
            return (Criteria) this;
        }

        public Criteria andScFcIdBetween(Integer value1, Integer value2) {
            addCriterion("sc_fc_id between", value1, value2, "scFcId");
            return (Criteria) this;
        }

        public Criteria andScFcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sc_fc_id not between", value1, value2, "scFcId");
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