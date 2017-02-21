package mybatisGenerator.javaBean;

import java.util.ArrayList;
import java.util.List;

public class PerOrganizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PerOrganizeExample() {
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

        public Criteria andOnameIsNull() {
            addCriterion("oname is null");
            return (Criteria) this;
        }

        public Criteria andOnameIsNotNull() {
            addCriterion("oname is not null");
            return (Criteria) this;
        }

        public Criteria andOnameEqualTo(String value) {
            addCriterion("oname =", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotEqualTo(String value) {
            addCriterion("oname <>", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameGreaterThan(String value) {
            addCriterion("oname >", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameGreaterThanOrEqualTo(String value) {
            addCriterion("oname >=", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameLessThan(String value) {
            addCriterion("oname <", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameLessThanOrEqualTo(String value) {
            addCriterion("oname <=", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameLike(String value) {
            addCriterion("oname like", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotLike(String value) {
            addCriterion("oname not like", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameIn(List<String> values) {
            addCriterion("oname in", values, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotIn(List<String> values) {
            addCriterion("oname not in", values, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameBetween(String value1, String value2) {
            addCriterion("oname between", value1, value2, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotBetween(String value1, String value2) {
            addCriterion("oname not between", value1, value2, "oname");
            return (Criteria) this;
        }

        public Criteria andOrgDescIsNull() {
            addCriterion("org_desc is null");
            return (Criteria) this;
        }

        public Criteria andOrgDescIsNotNull() {
            addCriterion("org_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOrgDescEqualTo(String value) {
            addCriterion("org_desc =", value, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescNotEqualTo(String value) {
            addCriterion("org_desc <>", value, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescGreaterThan(String value) {
            addCriterion("org_desc >", value, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescGreaterThanOrEqualTo(String value) {
            addCriterion("org_desc >=", value, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescLessThan(String value) {
            addCriterion("org_desc <", value, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescLessThanOrEqualTo(String value) {
            addCriterion("org_desc <=", value, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescLike(String value) {
            addCriterion("org_desc like", value, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescNotLike(String value) {
            addCriterion("org_desc not like", value, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescIn(List<String> values) {
            addCriterion("org_desc in", values, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescNotIn(List<String> values) {
            addCriterion("org_desc not in", values, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescBetween(String value1, String value2) {
            addCriterion("org_desc between", value1, value2, "orgDesc");
            return (Criteria) this;
        }

        public Criteria andOrgDescNotBetween(String value1, String value2) {
            addCriterion("org_desc not between", value1, value2, "orgDesc");
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

        public Criteria andRgradeEqualTo(Short value) {
            addCriterion("rgrade =", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeNotEqualTo(Short value) {
            addCriterion("rgrade <>", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeGreaterThan(Short value) {
            addCriterion("rgrade >", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeGreaterThanOrEqualTo(Short value) {
            addCriterion("rgrade >=", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeLessThan(Short value) {
            addCriterion("rgrade <", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeLessThanOrEqualTo(Short value) {
            addCriterion("rgrade <=", value, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeIn(List<Short> values) {
            addCriterion("rgrade in", values, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeNotIn(List<Short> values) {
            addCriterion("rgrade not in", values, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeBetween(Short value1, Short value2) {
            addCriterion("rgrade between", value1, value2, "rgrade");
            return (Criteria) this;
        }

        public Criteria andRgradeNotBetween(Short value1, Short value2) {
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

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andPuuidIsNull() {
            addCriterion("puuid is null");
            return (Criteria) this;
        }

        public Criteria andPuuidIsNotNull() {
            addCriterion("puuid is not null");
            return (Criteria) this;
        }

        public Criteria andPuuidEqualTo(String value) {
            addCriterion("puuid =", value, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidNotEqualTo(String value) {
            addCriterion("puuid <>", value, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidGreaterThan(String value) {
            addCriterion("puuid >", value, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidGreaterThanOrEqualTo(String value) {
            addCriterion("puuid >=", value, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidLessThan(String value) {
            addCriterion("puuid <", value, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidLessThanOrEqualTo(String value) {
            addCriterion("puuid <=", value, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidLike(String value) {
            addCriterion("puuid like", value, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidNotLike(String value) {
            addCriterion("puuid not like", value, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidIn(List<String> values) {
            addCriterion("puuid in", values, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidNotIn(List<String> values) {
            addCriterion("puuid not in", values, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidBetween(String value1, String value2) {
            addCriterion("puuid between", value1, value2, "puuid");
            return (Criteria) this;
        }

        public Criteria andPuuidNotBetween(String value1, String value2) {
            addCriterion("puuid not between", value1, value2, "puuid");
            return (Criteria) this;
        }

        public Criteria andOuuidIsNull() {
            addCriterion("ouuid is null");
            return (Criteria) this;
        }

        public Criteria andOuuidIsNotNull() {
            addCriterion("ouuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuuidEqualTo(String value) {
            addCriterion("ouuid =", value, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidNotEqualTo(String value) {
            addCriterion("ouuid <>", value, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidGreaterThan(String value) {
            addCriterion("ouuid >", value, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidGreaterThanOrEqualTo(String value) {
            addCriterion("ouuid >=", value, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidLessThan(String value) {
            addCriterion("ouuid <", value, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidLessThanOrEqualTo(String value) {
            addCriterion("ouuid <=", value, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidLike(String value) {
            addCriterion("ouuid like", value, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidNotLike(String value) {
            addCriterion("ouuid not like", value, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidIn(List<String> values) {
            addCriterion("ouuid in", values, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidNotIn(List<String> values) {
            addCriterion("ouuid not in", values, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidBetween(String value1, String value2) {
            addCriterion("ouuid between", value1, value2, "ouuid");
            return (Criteria) this;
        }

        public Criteria andOuuidNotBetween(String value1, String value2) {
            addCriterion("ouuid not between", value1, value2, "ouuid");
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