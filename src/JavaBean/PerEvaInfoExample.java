package JavaBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PerEvaInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PerEvaInfoExample() {
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

        public Criteria andEvaluatorIsNull() {
            addCriterion("evaluator is null");
            return (Criteria) this;
        }

        public Criteria andEvaluatorIsNotNull() {
            addCriterion("evaluator is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluatorEqualTo(String value) {
            addCriterion("evaluator =", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorNotEqualTo(String value) {
            addCriterion("evaluator <>", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorGreaterThan(String value) {
            addCriterion("evaluator >", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorGreaterThanOrEqualTo(String value) {
            addCriterion("evaluator >=", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorLessThan(String value) {
            addCriterion("evaluator <", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorLessThanOrEqualTo(String value) {
            addCriterion("evaluator <=", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorLike(String value) {
            addCriterion("evaluator like", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorNotLike(String value) {
            addCriterion("evaluator not like", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorIn(List<String> values) {
            addCriterion("evaluator in", values, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorNotIn(List<String> values) {
            addCriterion("evaluator not in", values, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorBetween(String value1, String value2) {
            addCriterion("evaluator between", value1, value2, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorNotBetween(String value1, String value2) {
            addCriterion("evaluator not between", value1, value2, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEtypeIsNull() {
            addCriterion("etype is null");
            return (Criteria) this;
        }

        public Criteria andEtypeIsNotNull() {
            addCriterion("etype is not null");
            return (Criteria) this;
        }

        public Criteria andEtypeEqualTo(Byte value) {
            addCriterion("etype =", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotEqualTo(Byte value) {
            addCriterion("etype <>", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeGreaterThan(Byte value) {
            addCriterion("etype >", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("etype >=", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeLessThan(Byte value) {
            addCriterion("etype <", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeLessThanOrEqualTo(Byte value) {
            addCriterion("etype <=", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeIn(List<Byte> values) {
            addCriterion("etype in", values, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotIn(List<Byte> values) {
            addCriterion("etype not in", values, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeBetween(Byte value1, Byte value2) {
            addCriterion("etype between", value1, value2, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("etype not between", value1, value2, "etype");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescIsNull() {
            addCriterion("evaluator_desc is null");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescIsNotNull() {
            addCriterion("evaluator_desc is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescEqualTo(String value) {
            addCriterion("evaluator_desc =", value, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescNotEqualTo(String value) {
            addCriterion("evaluator_desc <>", value, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescGreaterThan(String value) {
            addCriterion("evaluator_desc >", value, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescGreaterThanOrEqualTo(String value) {
            addCriterion("evaluator_desc >=", value, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescLessThan(String value) {
            addCriterion("evaluator_desc <", value, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescLessThanOrEqualTo(String value) {
            addCriterion("evaluator_desc <=", value, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescLike(String value) {
            addCriterion("evaluator_desc like", value, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescNotLike(String value) {
            addCriterion("evaluator_desc not like", value, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescIn(List<String> values) {
            addCriterion("evaluator_desc in", values, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescNotIn(List<String> values) {
            addCriterion("evaluator_desc not in", values, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescBetween(String value1, String value2) {
            addCriterion("evaluator_desc between", value1, value2, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluatorDescNotBetween(String value1, String value2) {
            addCriterion("evaluator_desc not between", value1, value2, "evaluatorDesc");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNull() {
            addCriterion("detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Long value) {
            addCriterion("detail_id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Long value) {
            addCriterion("detail_id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Long value) {
            addCriterion("detail_id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("detail_id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Long value) {
            addCriterion("detail_id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("detail_id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Long> values) {
            addCriterion("detail_id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Long> values) {
            addCriterion("detail_id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Long value1, Long value2) {
            addCriterion("detail_id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("detail_id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNull() {
            addCriterion("etime is null");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNotNull() {
            addCriterion("etime is not null");
            return (Criteria) this;
        }

        public Criteria andEtimeEqualTo(Date value) {
            addCriterion("etime =", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotEqualTo(Date value) {
            addCriterion("etime <>", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThan(Date value) {
            addCriterion("etime >", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("etime >=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThan(Date value) {
            addCriterion("etime <", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThanOrEqualTo(Date value) {
            addCriterion("etime <=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeIn(List<Date> values) {
            addCriterion("etime in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotIn(List<Date> values) {
            addCriterion("etime not in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeBetween(Date value1, Date value2) {
            addCriterion("etime between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotBetween(Date value1, Date value2) {
            addCriterion("etime not between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andEplaceIsNull() {
            addCriterion("eplace is null");
            return (Criteria) this;
        }

        public Criteria andEplaceIsNotNull() {
            addCriterion("eplace is not null");
            return (Criteria) this;
        }

        public Criteria andEplaceEqualTo(String value) {
            addCriterion("eplace =", value, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceNotEqualTo(String value) {
            addCriterion("eplace <>", value, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceGreaterThan(String value) {
            addCriterion("eplace >", value, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceGreaterThanOrEqualTo(String value) {
            addCriterion("eplace >=", value, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceLessThan(String value) {
            addCriterion("eplace <", value, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceLessThanOrEqualTo(String value) {
            addCriterion("eplace <=", value, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceLike(String value) {
            addCriterion("eplace like", value, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceNotLike(String value) {
            addCriterion("eplace not like", value, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceIn(List<String> values) {
            addCriterion("eplace in", values, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceNotIn(List<String> values) {
            addCriterion("eplace not in", values, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceBetween(String value1, String value2) {
            addCriterion("eplace between", value1, value2, "eplace");
            return (Criteria) this;
        }

        public Criteria andEplaceNotBetween(String value1, String value2) {
            addCriterion("eplace not between", value1, value2, "eplace");
            return (Criteria) this;
        }

        public Criteria andEbackIsNull() {
            addCriterion("eback is null");
            return (Criteria) this;
        }

        public Criteria andEbackIsNotNull() {
            addCriterion("eback is not null");
            return (Criteria) this;
        }

        public Criteria andEbackEqualTo(String value) {
            addCriterion("eback =", value, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackNotEqualTo(String value) {
            addCriterion("eback <>", value, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackGreaterThan(String value) {
            addCriterion("eback >", value, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackGreaterThanOrEqualTo(String value) {
            addCriterion("eback >=", value, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackLessThan(String value) {
            addCriterion("eback <", value, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackLessThanOrEqualTo(String value) {
            addCriterion("eback <=", value, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackLike(String value) {
            addCriterion("eback like", value, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackNotLike(String value) {
            addCriterion("eback not like", value, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackIn(List<String> values) {
            addCriterion("eback in", values, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackNotIn(List<String> values) {
            addCriterion("eback not in", values, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackBetween(String value1, String value2) {
            addCriterion("eback between", value1, value2, "eback");
            return (Criteria) this;
        }

        public Criteria andEbackNotBetween(String value1, String value2) {
            addCriterion("eback not between", value1, value2, "eback");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
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