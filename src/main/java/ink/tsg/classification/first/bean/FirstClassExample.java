package ink.tsg.classification.first.bean;

import java.util.ArrayList;
import java.util.List;

public class FirstClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FirstClassExample() {
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

        public Criteria andFclassificationIdIsNull() {
            addCriterion("fclassification_id is null");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdIsNotNull() {
            addCriterion("fclassification_id is not null");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdEqualTo(Integer value) {
            addCriterion("fclassification_id =", value, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdNotEqualTo(Integer value) {
            addCriterion("fclassification_id <>", value, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdGreaterThan(Integer value) {
            addCriterion("fclassification_id >", value, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fclassification_id >=", value, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdLessThan(Integer value) {
            addCriterion("fclassification_id <", value, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdLessThanOrEqualTo(Integer value) {
            addCriterion("fclassification_id <=", value, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdIn(List<Integer> values) {
            addCriterion("fclassification_id in", values, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdNotIn(List<Integer> values) {
            addCriterion("fclassification_id not in", values, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdBetween(Integer value1, Integer value2) {
            addCriterion("fclassification_id between", value1, value2, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fclassification_id not between", value1, value2, "fclassificationId");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameIsNull() {
            addCriterion("fclassification_name is null");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameIsNotNull() {
            addCriterion("fclassification_name is not null");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameEqualTo(String value) {
            addCriterion("fclassification_name =", value, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameNotEqualTo(String value) {
            addCriterion("fclassification_name <>", value, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameGreaterThan(String value) {
            addCriterion("fclassification_name >", value, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameGreaterThanOrEqualTo(String value) {
            addCriterion("fclassification_name >=", value, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameLessThan(String value) {
            addCriterion("fclassification_name <", value, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameLessThanOrEqualTo(String value) {
            addCriterion("fclassification_name <=", value, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameLike(String value) {
            addCriterion("fclassification_name like", value, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameNotLike(String value) {
            addCriterion("fclassification_name not like", value, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameIn(List<String> values) {
            addCriterion("fclassification_name in", values, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameNotIn(List<String> values) {
            addCriterion("fclassification_name not in", values, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameBetween(String value1, String value2) {
            addCriterion("fclassification_name between", value1, value2, "fclassificationName");
            return (Criteria) this;
        }

        public Criteria andFclassificationNameNotBetween(String value1, String value2) {
            addCriterion("fclassification_name not between", value1, value2, "fclassificationName");
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