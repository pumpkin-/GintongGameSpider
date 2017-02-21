package mybatisGenerator.javaBean;

import java.util.ArrayList;
import java.util.List;

public class PerPersonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PerPersonExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRnameIsNull() {
            addCriterion("rname is null");
            return (Criteria) this;
        }

        public Criteria andRnameIsNotNull() {
            addCriterion("rname is not null");
            return (Criteria) this;
        }

        public Criteria andRnameEqualTo(String value) {
            addCriterion("rname =", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotEqualTo(String value) {
            addCriterion("rname <>", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThan(String value) {
            addCriterion("rname >", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThanOrEqualTo(String value) {
            addCriterion("rname >=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThan(String value) {
            addCriterion("rname <", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThanOrEqualTo(String value) {
            addCriterion("rname <=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLike(String value) {
            addCriterion("rname like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotLike(String value) {
            addCriterion("rname not like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameIn(List<String> values) {
            addCriterion("rname in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotIn(List<String> values) {
            addCriterion("rname not in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameBetween(String value1, String value2) {
            addCriterion("rname between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotBetween(String value1, String value2) {
            addCriterion("rname not between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andReventIsNull() {
            addCriterion("revent is null");
            return (Criteria) this;
        }

        public Criteria andReventIsNotNull() {
            addCriterion("revent is not null");
            return (Criteria) this;
        }

        public Criteria andReventEqualTo(String value) {
            addCriterion("revent =", value, "revent");
            return (Criteria) this;
        }

        public Criteria andReventNotEqualTo(String value) {
            addCriterion("revent <>", value, "revent");
            return (Criteria) this;
        }

        public Criteria andReventGreaterThan(String value) {
            addCriterion("revent >", value, "revent");
            return (Criteria) this;
        }

        public Criteria andReventGreaterThanOrEqualTo(String value) {
            addCriterion("revent >=", value, "revent");
            return (Criteria) this;
        }

        public Criteria andReventLessThan(String value) {
            addCriterion("revent <", value, "revent");
            return (Criteria) this;
        }

        public Criteria andReventLessThanOrEqualTo(String value) {
            addCriterion("revent <=", value, "revent");
            return (Criteria) this;
        }

        public Criteria andReventLike(String value) {
            addCriterion("revent like", value, "revent");
            return (Criteria) this;
        }

        public Criteria andReventNotLike(String value) {
            addCriterion("revent not like", value, "revent");
            return (Criteria) this;
        }

        public Criteria andReventIn(List<String> values) {
            addCriterion("revent in", values, "revent");
            return (Criteria) this;
        }

        public Criteria andReventNotIn(List<String> values) {
            addCriterion("revent not in", values, "revent");
            return (Criteria) this;
        }

        public Criteria andReventBetween(String value1, String value2) {
            addCriterion("revent between", value1, value2, "revent");
            return (Criteria) this;
        }

        public Criteria andReventNotBetween(String value1, String value2) {
            addCriterion("revent not between", value1, value2, "revent");
            return (Criteria) this;
        }

        public Criteria andRtypeIsNull() {
            addCriterion("rtype is null");
            return (Criteria) this;
        }

        public Criteria andRtypeIsNotNull() {
            addCriterion("rtype is not null");
            return (Criteria) this;
        }

        public Criteria andRtypeEqualTo(String value) {
            addCriterion("rtype =", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotEqualTo(String value) {
            addCriterion("rtype <>", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeGreaterThan(String value) {
            addCriterion("rtype >", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeGreaterThanOrEqualTo(String value) {
            addCriterion("rtype >=", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeLessThan(String value) {
            addCriterion("rtype <", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeLessThanOrEqualTo(String value) {
            addCriterion("rtype <=", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeLike(String value) {
            addCriterion("rtype like", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotLike(String value) {
            addCriterion("rtype not like", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeIn(List<String> values) {
            addCriterion("rtype in", values, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotIn(List<String> values) {
            addCriterion("rtype not in", values, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeBetween(String value1, String value2) {
            addCriterion("rtype between", value1, value2, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotBetween(String value1, String value2) {
            addCriterion("rtype not between", value1, value2, "rtype");
            return (Criteria) this;
        }

        public Criteria andRgradeIsNull() {
            addCriterion("rgrade is null");
            return (Criteria) this;
        }

        public Criteria andRgradeIsNotNull() {
            addCriterion("rgrade is not null");
            return (Criteria) this;
        }

        public Criteria andRgradeEqualTo(String value) {
            addCriterion("rgrade =", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeNotEqualTo(String value) {
            addCriterion("rgrade <>", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeGreaterThan(String value) {
            addCriterion("rgrade >", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeGreaterThanOrEqualTo(String value) {
            addCriterion("rgrade >=", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeLessThan(String value) {
            addCriterion("rgrade <", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeLessThanOrEqualTo(String value) {
            addCriterion("rgrade <=", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeLike(String value) {
            addCriterion("rgrade like", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeNotLike(String value) {
            addCriterion("rgrade not like", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeIn(List<String> values) {
            addCriterion("rgrade in", values, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeNotIn(List<String> values) {
            addCriterion("rgrade not in", values, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeBetween(String value1, String value2) {
            addCriterion("rgrade between", value1, value2, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeNotBetween(String value1, String value2) {
            addCriterion("rgrade not between", value1, value2, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgDescIsNull() {
            addCriterion("rg_desc is null");
            return (Criteria) this;
        }

        public Criteria andRgDescIsNotNull() {
            addCriterion("rg_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRgDescEqualTo(String value) {
            addCriterion("rg_desc =", value, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescNotEqualTo(String value) {
            addCriterion("rg_desc <>", value, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescGreaterThan(String value) {
            addCriterion("rg_desc >", value, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescGreaterThanOrEqualTo(String value) {
            addCriterion("rg_desc >=", value, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescLessThan(String value) {
            addCriterion("rg_desc <", value, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescLessThanOrEqualTo(String value) {
            addCriterion("rg_desc <=", value, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescLike(String value) {
            addCriterion("rg_desc like", value, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescNotLike(String value) {
            addCriterion("rg_desc not like", value, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescIn(List<String> values) {
            addCriterion("rg_desc in", values, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescNotIn(List<String> values) {
            addCriterion("rg_desc not in", values, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescBetween(String value1, String value2) {
            addCriterion("rg_desc between", value1, value2, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andRgDescNotBetween(String value1, String value2) {
            addCriterion("rg_desc not between", value1, value2, "rgDesc");
            return (Criteria) this;
        }

        public Criteria andUuid1IsNull() {
            addCriterion("uuid1 is null");
            return (Criteria) this;
        }

        public Criteria andUuid1IsNotNull() {
            addCriterion("uuid1 is not null");
            return (Criteria) this;
        }

        public Criteria andUuid1EqualTo(String value) {
            addCriterion("uuid1 =", value, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1NotEqualTo(String value) {
            addCriterion("uuid1 <>", value, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1GreaterThan(String value) {
            addCriterion("uuid1 >", value, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1GreaterThanOrEqualTo(String value) {
            addCriterion("uuid1 >=", value, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1LessThan(String value) {
            addCriterion("uuid1 <", value, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1LessThanOrEqualTo(String value) {
            addCriterion("uuid1 <=", value, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1Like(String value) {
            addCriterion("uuid1 like", value, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1NotLike(String value) {
            addCriterion("uuid1 not like", value, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1In(List<String> values) {
            addCriterion("uuid1 in", values, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1NotIn(List<String> values) {
            addCriterion("uuid1 not in", values, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1Between(String value1, String value2) {
            addCriterion("uuid1 between", value1, value2, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid1NotBetween(String value1, String value2) {
            addCriterion("uuid1 not between", value1, value2, "uuid1");
            return (Criteria) this;
        }

        public Criteria andUuid2IsNull() {
            addCriterion("uuid2 is null");
            return (Criteria) this;
        }

        public Criteria andUuid2IsNotNull() {
            addCriterion("uuid2 is not null");
            return (Criteria) this;
        }

        public Criteria andUuid2EqualTo(String value) {
            addCriterion("uuid2 =", value, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2NotEqualTo(String value) {
            addCriterion("uuid2 <>", value, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2GreaterThan(String value) {
            addCriterion("uuid2 >", value, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2GreaterThanOrEqualTo(String value) {
            addCriterion("uuid2 >=", value, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2LessThan(String value) {
            addCriterion("uuid2 <", value, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2LessThanOrEqualTo(String value) {
            addCriterion("uuid2 <=", value, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2Like(String value) {
            addCriterion("uuid2 like", value, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2NotLike(String value) {
            addCriterion("uuid2 not like", value, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2In(List<String> values) {
            addCriterion("uuid2 in", values, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2NotIn(List<String> values) {
            addCriterion("uuid2 not in", values, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2Between(String value1, String value2) {
            addCriterion("uuid2 between", value1, value2, "uuid2");
            return (Criteria) this;
        }

        public Criteria andUuid2NotBetween(String value1, String value2) {
            addCriterion("uuid2 not between", value1, value2, "uuid2");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
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