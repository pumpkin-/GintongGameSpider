package mybatisGenerator.javaBean;

import java.util.ArrayList;
import java.util.List;

public class OrgFrameworkInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrgFrameworkInfoExample() {
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

        public Criteria andFrameworkIsNull() {
            addCriterion("framework is null");
            return (Criteria) this;
        }

        public Criteria andFrameworkIsNotNull() {
            addCriterion("framework is not null");
            return (Criteria) this;
        }

        public Criteria andFrameworkEqualTo(String value) {
            addCriterion("framework =", value, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkNotEqualTo(String value) {
            addCriterion("framework <>", value, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkGreaterThan(String value) {
            addCriterion("framework >", value, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkGreaterThanOrEqualTo(String value) {
            addCriterion("framework >=", value, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkLessThan(String value) {
            addCriterion("framework <", value, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkLessThanOrEqualTo(String value) {
            addCriterion("framework <=", value, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkLike(String value) {
            addCriterion("framework like", value, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkNotLike(String value) {
            addCriterion("framework not like", value, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkIn(List<String> values) {
            addCriterion("framework in", values, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkNotIn(List<String> values) {
            addCriterion("framework not in", values, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkBetween(String value1, String value2) {
            addCriterion("framework between", value1, value2, "framework");
            return (Criteria) this;
        }

        public Criteria andFrameworkNotBetween(String value1, String value2) {
            addCriterion("framework not between", value1, value2, "framework");
            return (Criteria) this;
        }

        public Criteria andMemberIsNull() {
            addCriterion("member is null");
            return (Criteria) this;
        }

        public Criteria andMemberIsNotNull() {
            addCriterion("member is not null");
            return (Criteria) this;
        }

        public Criteria andMemberEqualTo(Integer value) {
            addCriterion("member =", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotEqualTo(Integer value) {
            addCriterion("member <>", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberGreaterThan(Integer value) {
            addCriterion("member >", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberGreaterThanOrEqualTo(Integer value) {
            addCriterion("member >=", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberLessThan(Integer value) {
            addCriterion("member <", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberLessThanOrEqualTo(Integer value) {
            addCriterion("member <=", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberIn(List<Integer> values) {
            addCriterion("member in", values, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotIn(List<Integer> values) {
            addCriterion("member not in", values, "member");
            return (Criteria) this;
        }

        public Criteria andMemberBetween(Integer value1, Integer value2) {
            addCriterion("member between", value1, value2, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotBetween(Integer value1, Integer value2) {
            addCriterion("member not between", value1, value2, "member");
            return (Criteria) this;
        }

        public Criteria andRecruitIsNull() {
            addCriterion("recruit is null");
            return (Criteria) this;
        }

        public Criteria andRecruitIsNotNull() {
            addCriterion("recruit is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitEqualTo(String value) {
            addCriterion("recruit =", value, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitNotEqualTo(String value) {
            addCriterion("recruit <>", value, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitGreaterThan(String value) {
            addCriterion("recruit >", value, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitGreaterThanOrEqualTo(String value) {
            addCriterion("recruit >=", value, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitLessThan(String value) {
            addCriterion("recruit <", value, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitLessThanOrEqualTo(String value) {
            addCriterion("recruit <=", value, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitLike(String value) {
            addCriterion("recruit like", value, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitNotLike(String value) {
            addCriterion("recruit not like", value, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitIn(List<String> values) {
            addCriterion("recruit in", values, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitNotIn(List<String> values) {
            addCriterion("recruit not in", values, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitBetween(String value1, String value2) {
            addCriterion("recruit between", value1, value2, "recruit");
            return (Criteria) this;
        }

        public Criteria andRecruitNotBetween(String value1, String value2) {
            addCriterion("recruit not between", value1, value2, "recruit");
            return (Criteria) this;
        }

        public Criteria andConSystemIsNull() {
            addCriterion("con_system is null");
            return (Criteria) this;
        }

        public Criteria andConSystemIsNotNull() {
            addCriterion("con_system is not null");
            return (Criteria) this;
        }

        public Criteria andConSystemEqualTo(String value) {
            addCriterion("con_system =", value, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemNotEqualTo(String value) {
            addCriterion("con_system <>", value, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemGreaterThan(String value) {
            addCriterion("con_system >", value, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemGreaterThanOrEqualTo(String value) {
            addCriterion("con_system >=", value, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemLessThan(String value) {
            addCriterion("con_system <", value, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemLessThanOrEqualTo(String value) {
            addCriterion("con_system <=", value, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemLike(String value) {
            addCriterion("con_system like", value, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemNotLike(String value) {
            addCriterion("con_system not like", value, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemIn(List<String> values) {
            addCriterion("con_system in", values, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemNotIn(List<String> values) {
            addCriterion("con_system not in", values, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemBetween(String value1, String value2) {
            addCriterion("con_system between", value1, value2, "conSystem");
            return (Criteria) this;
        }

        public Criteria andConSystemNotBetween(String value1, String value2) {
            addCriterion("con_system not between", value1, value2, "conSystem");
            return (Criteria) this;
        }

        public Criteria andWelfareIsNull() {
            addCriterion("welfare is null");
            return (Criteria) this;
        }

        public Criteria andWelfareIsNotNull() {
            addCriterion("welfare is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareEqualTo(String value) {
            addCriterion("welfare =", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotEqualTo(String value) {
            addCriterion("welfare <>", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareGreaterThan(String value) {
            addCriterion("welfare >", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareGreaterThanOrEqualTo(String value) {
            addCriterion("welfare >=", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLessThan(String value) {
            addCriterion("welfare <", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLessThanOrEqualTo(String value) {
            addCriterion("welfare <=", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLike(String value) {
            addCriterion("welfare like", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotLike(String value) {
            addCriterion("welfare not like", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareIn(List<String> values) {
            addCriterion("welfare in", values, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotIn(List<String> values) {
            addCriterion("welfare not in", values, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareBetween(String value1, String value2) {
            addCriterion("welfare between", value1, value2, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotBetween(String value1, String value2) {
            addCriterion("welfare not between", value1, value2, "welfare");
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