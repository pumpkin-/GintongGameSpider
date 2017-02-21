package JavaBean;

import java.util.ArrayList;
import java.util.List;

public class PerDemandWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PerDemandWorkExample() {
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

        public Criteria andDplaceIsNull() {
            addCriterion("dplace is null");
            return (Criteria) this;
        }

        public Criteria andDplaceIsNotNull() {
            addCriterion("dplace is not null");
            return (Criteria) this;
        }

        public Criteria andDplaceEqualTo(String value) {
            addCriterion("dplace =", value, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceNotEqualTo(String value) {
            addCriterion("dplace <>", value, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceGreaterThan(String value) {
            addCriterion("dplace >", value, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceGreaterThanOrEqualTo(String value) {
            addCriterion("dplace >=", value, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceLessThan(String value) {
            addCriterion("dplace <", value, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceLessThanOrEqualTo(String value) {
            addCriterion("dplace <=", value, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceLike(String value) {
            addCriterion("dplace like", value, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceNotLike(String value) {
            addCriterion("dplace not like", value, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceIn(List<String> values) {
            addCriterion("dplace in", values, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceNotIn(List<String> values) {
            addCriterion("dplace not in", values, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceBetween(String value1, String value2) {
            addCriterion("dplace between", value1, value2, "dplace");
            return (Criteria) this;
        }

        public Criteria andDplaceNotBetween(String value1, String value2) {
            addCriterion("dplace not between", value1, value2, "dplace");
            return (Criteria) this;
        }

        public Criteria andJtypeIsNull() {
            addCriterion("jtype is null");
            return (Criteria) this;
        }

        public Criteria andJtypeIsNotNull() {
            addCriterion("jtype is not null");
            return (Criteria) this;
        }

        public Criteria andJtypeEqualTo(String value) {
            addCriterion("jtype =", value, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeNotEqualTo(String value) {
            addCriterion("jtype <>", value, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeGreaterThan(String value) {
            addCriterion("jtype >", value, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeGreaterThanOrEqualTo(String value) {
            addCriterion("jtype >=", value, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeLessThan(String value) {
            addCriterion("jtype <", value, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeLessThanOrEqualTo(String value) {
            addCriterion("jtype <=", value, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeLike(String value) {
            addCriterion("jtype like", value, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeNotLike(String value) {
            addCriterion("jtype not like", value, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeIn(List<String> values) {
            addCriterion("jtype in", values, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeNotIn(List<String> values) {
            addCriterion("jtype not in", values, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeBetween(String value1, String value2) {
            addCriterion("jtype between", value1, value2, "jtype");
            return (Criteria) this;
        }

        public Criteria andJtypeNotBetween(String value1, String value2) {
            addCriterion("jtype not between", value1, value2, "jtype");
            return (Criteria) this;
        }

        public Criteria andDpayIsNull() {
            addCriterion("dpay is null");
            return (Criteria) this;
        }

        public Criteria andDpayIsNotNull() {
            addCriterion("dpay is not null");
            return (Criteria) this;
        }

        public Criteria andDpayEqualTo(String value) {
            addCriterion("dpay =", value, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayNotEqualTo(String value) {
            addCriterion("dpay <>", value, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayGreaterThan(String value) {
            addCriterion("dpay >", value, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayGreaterThanOrEqualTo(String value) {
            addCriterion("dpay >=", value, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayLessThan(String value) {
            addCriterion("dpay <", value, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayLessThanOrEqualTo(String value) {
            addCriterion("dpay <=", value, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayLike(String value) {
            addCriterion("dpay like", value, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayNotLike(String value) {
            addCriterion("dpay not like", value, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayIn(List<String> values) {
            addCriterion("dpay in", values, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayNotIn(List<String> values) {
            addCriterion("dpay not in", values, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayBetween(String value1, String value2) {
            addCriterion("dpay between", value1, value2, "dpay");
            return (Criteria) this;
        }

        public Criteria andDpayNotBetween(String value1, String value2) {
            addCriterion("dpay not between", value1, value2, "dpay");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andDjobIsNull() {
            addCriterion("djob is null");
            return (Criteria) this;
        }

        public Criteria andDjobIsNotNull() {
            addCriterion("djob is not null");
            return (Criteria) this;
        }

        public Criteria andDjobEqualTo(String value) {
            addCriterion("djob =", value, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobNotEqualTo(String value) {
            addCriterion("djob <>", value, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobGreaterThan(String value) {
            addCriterion("djob >", value, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobGreaterThanOrEqualTo(String value) {
            addCriterion("djob >=", value, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobLessThan(String value) {
            addCriterion("djob <", value, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobLessThanOrEqualTo(String value) {
            addCriterion("djob <=", value, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobLike(String value) {
            addCriterion("djob like", value, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobNotLike(String value) {
            addCriterion("djob not like", value, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobIn(List<String> values) {
            addCriterion("djob in", values, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobNotIn(List<String> values) {
            addCriterion("djob not in", values, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobBetween(String value1, String value2) {
            addCriterion("djob between", value1, value2, "djob");
            return (Criteria) this;
        }

        public Criteria andDjobNotBetween(String value1, String value2) {
            addCriterion("djob not between", value1, value2, "djob");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
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