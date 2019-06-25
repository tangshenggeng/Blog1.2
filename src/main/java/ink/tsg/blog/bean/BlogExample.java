package ink.tsg.blog.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
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

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNull() {
            addCriterion("blog_title is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blog_title is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blog_title =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blog_title <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blog_title >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blog_title >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blog_title <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blog_title <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blog_title like", value, "blogTitle");
            return (Criteria) this;
        }
        //新加的用于文章内容的模糊搜索
        public Criteria andBlogArticleLike(String value) {
            addCriterion("blog_article like", value, "blogArticle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blog_title not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blog_title in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blog_title not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blog_title between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blog_title not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeIsNull() {
            addCriterion("blog_uptime is null");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeIsNotNull() {
            addCriterion("blog_uptime is not null");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeEqualTo(Date value) {
            addCriterionForJDBCDate("blog_uptime =", value, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("blog_uptime <>", value, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeGreaterThan(Date value) {
            addCriterionForJDBCDate("blog_uptime >", value, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("blog_uptime >=", value, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeLessThan(Date value) {
            addCriterionForJDBCDate("blog_uptime <", value, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("blog_uptime <=", value, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeIn(List<Date> values) {
            addCriterionForJDBCDate("blog_uptime in", values, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("blog_uptime not in", values, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("blog_uptime between", value1, value2, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogUptimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("blog_uptime not between", value1, value2, "blogUptime");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdIsNull() {
            addCriterion("blog_tc_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdIsNotNull() {
            addCriterion("blog_tc_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdEqualTo(Integer value) {
            addCriterion("blog_tc_id =", value, "blogTcId");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdNotEqualTo(Integer value) {
            addCriterion("blog_tc_id <>", value, "blogTcId");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdGreaterThan(Integer value) {
            addCriterion("blog_tc_id >", value, "blogTcId");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_tc_id >=", value, "blogTcId");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdLessThan(Integer value) {
            addCriterion("blog_tc_id <", value, "blogTcId");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_tc_id <=", value, "blogTcId");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdIn(List<Integer> values) {
            addCriterion("blog_tc_id in", values, "blogTcId");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdNotIn(List<Integer> values) {
            addCriterion("blog_tc_id not in", values, "blogTcId");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_tc_id between", value1, value2, "blogTcId");
            return (Criteria) this;
        }

        public Criteria andBlogTcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_tc_id not between", value1, value2, "blogTcId");
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