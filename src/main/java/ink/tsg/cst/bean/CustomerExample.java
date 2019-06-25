package ink.tsg.cst.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCstIdIsNull() {
            addCriterion("cst_id is null");
            return (Criteria) this;
        }

        public Criteria andCstIdIsNotNull() {
            addCriterion("cst_id is not null");
            return (Criteria) this;
        }

        public Criteria andCstIdEqualTo(Integer value) {
            addCriterion("cst_id =", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdNotEqualTo(Integer value) {
            addCriterion("cst_id <>", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdGreaterThan(Integer value) {
            addCriterion("cst_id >", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cst_id >=", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdLessThan(Integer value) {
            addCriterion("cst_id <", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdLessThanOrEqualTo(Integer value) {
            addCriterion("cst_id <=", value, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdIn(List<Integer> values) {
            addCriterion("cst_id in", values, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdNotIn(List<Integer> values) {
            addCriterion("cst_id not in", values, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdBetween(Integer value1, Integer value2) {
            addCriterion("cst_id between", value1, value2, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cst_id not between", value1, value2, "cstId");
            return (Criteria) this;
        }

        public Criteria andCstConIsNull() {
            addCriterion("cst_con is null");
            return (Criteria) this;
        }

        public Criteria andCstConIsNotNull() {
            addCriterion("cst_con is not null");
            return (Criteria) this;
        }

        public Criteria andCstConEqualTo(String value) {
            addCriterion("cst_con =", value, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConNotEqualTo(String value) {
            addCriterion("cst_con <>", value, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConGreaterThan(String value) {
            addCriterion("cst_con >", value, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConGreaterThanOrEqualTo(String value) {
            addCriterion("cst_con >=", value, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConLessThan(String value) {
            addCriterion("cst_con <", value, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConLessThanOrEqualTo(String value) {
            addCriterion("cst_con <=", value, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConLike(String value) {
            addCriterion("cst_con like", value, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConNotLike(String value) {
            addCriterion("cst_con not like", value, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConIn(List<String> values) {
            addCriterion("cst_con in", values, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConNotIn(List<String> values) {
            addCriterion("cst_con not in", values, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConBetween(String value1, String value2) {
            addCriterion("cst_con between", value1, value2, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstConNotBetween(String value1, String value2) {
            addCriterion("cst_con not between", value1, value2, "cstCon");
            return (Criteria) this;
        }

        public Criteria andCstScnIsNull() {
            addCriterion("cst_scn is null");
            return (Criteria) this;
        }

        public Criteria andCstScnIsNotNull() {
            addCriterion("cst_scn is not null");
            return (Criteria) this;
        }

        public Criteria andCstScnEqualTo(String value) {
            addCriterion("cst_scn =", value, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnNotEqualTo(String value) {
            addCriterion("cst_scn <>", value, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnGreaterThan(String value) {
            addCriterion("cst_scn >", value, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnGreaterThanOrEqualTo(String value) {
            addCriterion("cst_scn >=", value, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnLessThan(String value) {
            addCriterion("cst_scn <", value, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnLessThanOrEqualTo(String value) {
            addCriterion("cst_scn <=", value, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnLike(String value) {
            addCriterion("cst_scn like", value, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnNotLike(String value) {
            addCriterion("cst_scn not like", value, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnIn(List<String> values) {
            addCriterion("cst_scn in", values, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnNotIn(List<String> values) {
            addCriterion("cst_scn not in", values, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnBetween(String value1, String value2) {
            addCriterion("cst_scn between", value1, value2, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstScnNotBetween(String value1, String value2) {
            addCriterion("cst_scn not between", value1, value2, "cstScn");
            return (Criteria) this;
        }

        public Criteria andCstNumIsNull() {
            addCriterion("cst_num is null");
            return (Criteria) this;
        }

        public Criteria andCstNumIsNotNull() {
            addCriterion("cst_num is not null");
            return (Criteria) this;
        }

        public Criteria andCstNumEqualTo(String value) {
            addCriterion("cst_num =", value, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumNotEqualTo(String value) {
            addCriterion("cst_num <>", value, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumGreaterThan(String value) {
            addCriterion("cst_num >", value, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumGreaterThanOrEqualTo(String value) {
            addCriterion("cst_num >=", value, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumLessThan(String value) {
            addCriterion("cst_num <", value, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumLessThanOrEqualTo(String value) {
            addCriterion("cst_num <=", value, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumLike(String value) {
            addCriterion("cst_num like", value, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumNotLike(String value) {
            addCriterion("cst_num not like", value, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumIn(List<String> values) {
            addCriterion("cst_num in", values, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumNotIn(List<String> values) {
            addCriterion("cst_num not in", values, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumBetween(String value1, String value2) {
            addCriterion("cst_num between", value1, value2, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstNumNotBetween(String value1, String value2) {
            addCriterion("cst_num not between", value1, value2, "cstNum");
            return (Criteria) this;
        }

        public Criteria andCstPwdIsNull() {
            addCriterion("cst_pwd is null");
            return (Criteria) this;
        }

        public Criteria andCstPwdIsNotNull() {
            addCriterion("cst_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andCstPwdEqualTo(String value) {
            addCriterion("cst_pwd =", value, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdNotEqualTo(String value) {
            addCriterion("cst_pwd <>", value, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdGreaterThan(String value) {
            addCriterion("cst_pwd >", value, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdGreaterThanOrEqualTo(String value) {
            addCriterion("cst_pwd >=", value, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdLessThan(String value) {
            addCriterion("cst_pwd <", value, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdLessThanOrEqualTo(String value) {
            addCriterion("cst_pwd <=", value, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdLike(String value) {
            addCriterion("cst_pwd like", value, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdNotLike(String value) {
            addCriterion("cst_pwd not like", value, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdIn(List<String> values) {
            addCriterion("cst_pwd in", values, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdNotIn(List<String> values) {
            addCriterion("cst_pwd not in", values, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdBetween(String value1, String value2) {
            addCriterion("cst_pwd between", value1, value2, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstPwdNotBetween(String value1, String value2) {
            addCriterion("cst_pwd not between", value1, value2, "cstPwd");
            return (Criteria) this;
        }

        public Criteria andCstCurrIsNull() {
            addCriterion("cst_curr is null");
            return (Criteria) this;
        }

        public Criteria andCstCurrIsNotNull() {
            addCriterion("cst_curr is not null");
            return (Criteria) this;
        }

        public Criteria andCstCurrEqualTo(String value) {
            addCriterion("cst_curr =", value, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrNotEqualTo(String value) {
            addCriterion("cst_curr <>", value, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrGreaterThan(String value) {
            addCriterion("cst_curr >", value, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrGreaterThanOrEqualTo(String value) {
            addCriterion("cst_curr >=", value, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrLessThan(String value) {
            addCriterion("cst_curr <", value, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrLessThanOrEqualTo(String value) {
            addCriterion("cst_curr <=", value, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrLike(String value) {
            addCriterion("cst_curr like", value, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrNotLike(String value) {
            addCriterion("cst_curr not like", value, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrIn(List<String> values) {
            addCriterion("cst_curr in", values, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrNotIn(List<String> values) {
            addCriterion("cst_curr not in", values, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrBetween(String value1, String value2) {
            addCriterion("cst_curr between", value1, value2, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstCurrNotBetween(String value1, String value2) {
            addCriterion("cst_curr not between", value1, value2, "cstCurr");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdIsNull() {
            addCriterion("cst_pla_id is null");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdIsNotNull() {
            addCriterion("cst_pla_id is not null");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdEqualTo(Integer value) {
            addCriterion("cst_pla_id =", value, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdNotEqualTo(Integer value) {
            addCriterion("cst_pla_id <>", value, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdGreaterThan(Integer value) {
            addCriterion("cst_pla_id >", value, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cst_pla_id >=", value, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdLessThan(Integer value) {
            addCriterion("cst_pla_id <", value, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdLessThanOrEqualTo(Integer value) {
            addCriterion("cst_pla_id <=", value, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdIn(List<Integer> values) {
            addCriterion("cst_pla_id in", values, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdNotIn(List<Integer> values) {
            addCriterion("cst_pla_id not in", values, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdBetween(Integer value1, Integer value2) {
            addCriterion("cst_pla_id between", value1, value2, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andCstPlaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cst_pla_id not between", value1, value2, "cstPlaId");
            return (Criteria) this;
        }

        public Criteria andUpTimeIsNull() {
            addCriterion("up_time is null");
            return (Criteria) this;
        }

        public Criteria andUpTimeIsNotNull() {
            addCriterion("up_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpTimeEqualTo(Date value) {
            addCriterionForJDBCDate("up_time =", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("up_time <>", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("up_time >", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("up_time >=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThan(Date value) {
            addCriterionForJDBCDate("up_time <", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("up_time <=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeIn(List<Date> values) {
            addCriterionForJDBCDate("up_time in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("up_time not in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("up_time between", value1, value2, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("up_time not between", value1, value2, "upTime");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Boolean value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Boolean value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Boolean value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Boolean value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Boolean value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Boolean> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Boolean> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Boolean value1, Boolean value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del not between", value1, value2, "del");
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