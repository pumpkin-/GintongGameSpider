package JavaBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BasPersonInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasPersonInfoExample() {
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

        public Criteria andEnnameIsNull() {
            addCriterion("enname is null");
            return (Criteria) this;
        }

        public Criteria andEnnameIsNotNull() {
            addCriterion("enname is not null");
            return (Criteria) this;
        }

        public Criteria andEnnameEqualTo(String value) {
            addCriterion("enname =", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotEqualTo(String value) {
            addCriterion("enname <>", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameGreaterThan(String value) {
            addCriterion("enname >", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameGreaterThanOrEqualTo(String value) {
            addCriterion("enname >=", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLessThan(String value) {
            addCriterion("enname <", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLessThanOrEqualTo(String value) {
            addCriterion("enname <=", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLike(String value) {
            addCriterion("enname like", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotLike(String value) {
            addCriterion("enname not like", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameIn(List<String> values) {
            addCriterion("enname in", values, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotIn(List<String> values) {
            addCriterion("enname not in", values, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameBetween(String value1, String value2) {
            addCriterion("enname between", value1, value2, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotBetween(String value1, String value2) {
            addCriterion("enname not between", value1, value2, "enname");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Short value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Short value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Short value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Short value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Short value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Short value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Short> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Short> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Short value1, Short value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Short value1, Short value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAliasIsNull() {
            addCriterion("alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("alias not between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andHometownIsNull() {
            addCriterion("hometown is null");
            return (Criteria) this;
        }

        public Criteria andHometownIsNotNull() {
            addCriterion("hometown is not null");
            return (Criteria) this;
        }

        public Criteria andHometownEqualTo(String value) {
            addCriterion("hometown =", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownNotEqualTo(String value) {
            addCriterion("hometown <>", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownGreaterThan(String value) {
            addCriterion("hometown >", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownGreaterThanOrEqualTo(String value) {
            addCriterion("hometown >=", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownLessThan(String value) {
            addCriterion("hometown <", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownLessThanOrEqualTo(String value) {
            addCriterion("hometown <=", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownLike(String value) {
            addCriterion("hometown like", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownNotLike(String value) {
            addCriterion("hometown not like", value, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownIn(List<String> values) {
            addCriterion("hometown in", values, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownNotIn(List<String> values) {
            addCriterion("hometown not in", values, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownBetween(String value1, String value2) {
            addCriterion("hometown between", value1, value2, "hometown");
            return (Criteria) this;
        }

        public Criteria andHometownNotBetween(String value1, String value2) {
            addCriterion("hometown not between", value1, value2, "hometown");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andConWayIsNull() {
            addCriterion("con_way is null");
            return (Criteria) this;
        }

        public Criteria andConWayIsNotNull() {
            addCriterion("con_way is not null");
            return (Criteria) this;
        }

        public Criteria andConWayEqualTo(String value) {
            addCriterion("con_way =", value, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayNotEqualTo(String value) {
            addCriterion("con_way <>", value, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayGreaterThan(String value) {
            addCriterion("con_way >", value, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayGreaterThanOrEqualTo(String value) {
            addCriterion("con_way >=", value, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayLessThan(String value) {
            addCriterion("con_way <", value, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayLessThanOrEqualTo(String value) {
            addCriterion("con_way <=", value, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayLike(String value) {
            addCriterion("con_way like", value, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayNotLike(String value) {
            addCriterion("con_way not like", value, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayIn(List<String> values) {
            addCriterion("con_way in", values, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayNotIn(List<String> values) {
            addCriterion("con_way not in", values, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayBetween(String value1, String value2) {
            addCriterion("con_way between", value1, value2, "conWay");
            return (Criteria) this;
        }

        public Criteria andConWayNotBetween(String value1, String value2) {
            addCriterion("con_way not between", value1, value2, "conWay");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterIsNull() {
            addCriterion("household_register is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterIsNotNull() {
            addCriterion("household_register is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterEqualTo(String value) {
            addCriterion("household_register =", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterNotEqualTo(String value) {
            addCriterion("household_register <>", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterGreaterThan(String value) {
            addCriterion("household_register >", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterGreaterThanOrEqualTo(String value) {
            addCriterion("household_register >=", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterLessThan(String value) {
            addCriterion("household_register <", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterLessThanOrEqualTo(String value) {
            addCriterion("household_register <=", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterLike(String value) {
            addCriterion("household_register like", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterNotLike(String value) {
            addCriterion("household_register not like", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterIn(List<String> values) {
            addCriterion("household_register in", values, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterNotIn(List<String> values) {
            addCriterion("household_register not in", values, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterBetween(String value1, String value2) {
            addCriterion("household_register between", value1, value2, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterNotBetween(String value1, String value2) {
            addCriterion("household_register not between", value1, value2, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andLiveplaceIsNull() {
            addCriterion("liveplace is null");
            return (Criteria) this;
        }

        public Criteria andLiveplaceIsNotNull() {
            addCriterion("liveplace is not null");
            return (Criteria) this;
        }

        public Criteria andLiveplaceEqualTo(String value) {
            addCriterion("liveplace =", value, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceNotEqualTo(String value) {
            addCriterion("liveplace <>", value, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceGreaterThan(String value) {
            addCriterion("liveplace >", value, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceGreaterThanOrEqualTo(String value) {
            addCriterion("liveplace >=", value, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceLessThan(String value) {
            addCriterion("liveplace <", value, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceLessThanOrEqualTo(String value) {
            addCriterion("liveplace <=", value, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceLike(String value) {
            addCriterion("liveplace like", value, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceNotLike(String value) {
            addCriterion("liveplace not like", value, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceIn(List<String> values) {
            addCriterion("liveplace in", values, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceNotIn(List<String> values) {
            addCriterion("liveplace not in", values, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceBetween(String value1, String value2) {
            addCriterion("liveplace between", value1, value2, "liveplace");
            return (Criteria) this;
        }

        public Criteria andLiveplaceNotBetween(String value1, String value2) {
            addCriterion("liveplace not between", value1, value2, "liveplace");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNull() {
            addCriterion("marital_status is null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNotNull() {
            addCriterion("marital_status is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusEqualTo(Byte value) {
            addCriterion("marital_status =", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotEqualTo(Byte value) {
            addCriterion("marital_status <>", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThan(Byte value) {
            addCriterion("marital_status >", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("marital_status >=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThan(Byte value) {
            addCriterion("marital_status <", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThanOrEqualTo(Byte value) {
            addCriterion("marital_status <=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIn(List<Byte> values) {
            addCriterion("marital_status in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotIn(List<Byte> values) {
            addCriterion("marital_status not in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusBetween(Byte value1, Byte value2) {
            addCriterion("marital_status between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("marital_status not between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmploymentIsNull() {
            addCriterion("employment is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentIsNotNull() {
            addCriterion("employment is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentEqualTo(Byte value) {
            addCriterion("employment =", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotEqualTo(Byte value) {
            addCriterion("employment <>", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentGreaterThan(Byte value) {
            addCriterion("employment >", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentGreaterThanOrEqualTo(Byte value) {
            addCriterion("employment >=", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentLessThan(Byte value) {
            addCriterion("employment <", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentLessThanOrEqualTo(Byte value) {
            addCriterion("employment <=", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentIn(List<Byte> values) {
            addCriterion("employment in", values, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotIn(List<Byte> values) {
            addCriterion("employment not in", values, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentBetween(Byte value1, Byte value2) {
            addCriterion("employment between", value1, value2, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotBetween(Byte value1, Byte value2) {
            addCriterion("employment not between", value1, value2, "employment");
            return (Criteria) this;
        }

        public Criteria andDiplomaIsNull() {
            addCriterion("diploma is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaIsNotNull() {
            addCriterion("diploma is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaEqualTo(String value) {
            addCriterion("diploma =", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotEqualTo(String value) {
            addCriterion("diploma <>", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaGreaterThan(String value) {
            addCriterion("diploma >", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("diploma >=", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaLessThan(String value) {
            addCriterion("diploma <", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaLessThanOrEqualTo(String value) {
            addCriterion("diploma <=", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaLike(String value) {
            addCriterion("diploma like", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotLike(String value) {
            addCriterion("diploma not like", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaIn(List<String> values) {
            addCriterion("diploma in", values, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotIn(List<String> values) {
            addCriterion("diploma not in", values, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaBetween(String value1, String value2) {
            addCriterion("diploma between", value1, value2, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotBetween(String value1, String value2) {
            addCriterion("diploma not between", value1, value2, "diploma");
            return (Criteria) this;
        }

        public Criteria andWorkYearsIsNull() {
            addCriterion("work_years is null");
            return (Criteria) this;
        }

        public Criteria andWorkYearsIsNotNull() {
            addCriterion("work_years is not null");
            return (Criteria) this;
        }

        public Criteria andWorkYearsEqualTo(String value) {
            addCriterion("work_years =", value, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsNotEqualTo(String value) {
            addCriterion("work_years <>", value, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsGreaterThan(String value) {
            addCriterion("work_years >", value, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsGreaterThanOrEqualTo(String value) {
            addCriterion("work_years >=", value, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsLessThan(String value) {
            addCriterion("work_years <", value, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsLessThanOrEqualTo(String value) {
            addCriterion("work_years <=", value, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsLike(String value) {
            addCriterion("work_years like", value, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsNotLike(String value) {
            addCriterion("work_years not like", value, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsIn(List<String> values) {
            addCriterion("work_years in", values, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsNotIn(List<String> values) {
            addCriterion("work_years not in", values, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsBetween(String value1, String value2) {
            addCriterion("work_years between", value1, value2, "workYears");
            return (Criteria) this;
        }

        public Criteria andWorkYearsNotBetween(String value1, String value2) {
            addCriterion("work_years not between", value1, value2, "workYears");
            return (Criteria) this;
        }

        public Criteria andChildStatusIsNull() {
            addCriterion("child_status is null");
            return (Criteria) this;
        }

        public Criteria andChildStatusIsNotNull() {
            addCriterion("child_status is not null");
            return (Criteria) this;
        }

        public Criteria andChildStatusEqualTo(Byte value) {
            addCriterion("child_status =", value, "childStatus");
            return (Criteria) this;
        }

        public Criteria andChildStatusNotEqualTo(Byte value) {
            addCriterion("child_status <>", value, "childStatus");
            return (Criteria) this;
        }

        public Criteria andChildStatusGreaterThan(Byte value) {
            addCriterion("child_status >", value, "childStatus");
            return (Criteria) this;
        }

        public Criteria andChildStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("child_status >=", value, "childStatus");
            return (Criteria) this;
        }

        public Criteria andChildStatusLessThan(Byte value) {
            addCriterion("child_status <", value, "childStatus");
            return (Criteria) this;
        }

        public Criteria andChildStatusLessThanOrEqualTo(Byte value) {
            addCriterion("child_status <=", value, "childStatus");
            return (Criteria) this;
        }

        public Criteria andChildStatusIn(List<Byte> values) {
            addCriterion("child_status in", values, "childStatus");
            return (Criteria) this;
        }

        public Criteria andChildStatusNotIn(List<Byte> values) {
            addCriterion("child_status not in", values, "childStatus");
            return (Criteria) this;
        }

        public Criteria andChildStatusBetween(Byte value1, Byte value2) {
            addCriterion("child_status between", value1, value2, "childStatus");
            return (Criteria) this;
        }

        public Criteria andChildStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("child_status not between", value1, value2, "childStatus");
            return (Criteria) this;
        }

        public Criteria andLivePhotoIsNull() {
            addCriterion("live_photo is null");
            return (Criteria) this;
        }

        public Criteria andLivePhotoIsNotNull() {
            addCriterion("live_photo is not null");
            return (Criteria) this;
        }

        public Criteria andLivePhotoEqualTo(String value) {
            addCriterion("live_photo =", value, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoNotEqualTo(String value) {
            addCriterion("live_photo <>", value, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoGreaterThan(String value) {
            addCriterion("live_photo >", value, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoGreaterThanOrEqualTo(String value) {
            addCriterion("live_photo >=", value, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoLessThan(String value) {
            addCriterion("live_photo <", value, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoLessThanOrEqualTo(String value) {
            addCriterion("live_photo <=", value, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoLike(String value) {
            addCriterion("live_photo like", value, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoNotLike(String value) {
            addCriterion("live_photo not like", value, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoIn(List<String> values) {
            addCriterion("live_photo in", values, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoNotIn(List<String> values) {
            addCriterion("live_photo not in", values, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoBetween(String value1, String value2) {
            addCriterion("live_photo between", value1, value2, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andLivePhotoNotBetween(String value1, String value2) {
            addCriterion("live_photo not between", value1, value2, "livePhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoIsNull() {
            addCriterion("occu_photo is null");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoIsNotNull() {
            addCriterion("occu_photo is not null");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoEqualTo(String value) {
            addCriterion("occu_photo =", value, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoNotEqualTo(String value) {
            addCriterion("occu_photo <>", value, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoGreaterThan(String value) {
            addCriterion("occu_photo >", value, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("occu_photo >=", value, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoLessThan(String value) {
            addCriterion("occu_photo <", value, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoLessThanOrEqualTo(String value) {
            addCriterion("occu_photo <=", value, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoLike(String value) {
            addCriterion("occu_photo like", value, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoNotLike(String value) {
            addCriterion("occu_photo not like", value, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoIn(List<String> values) {
            addCriterion("occu_photo in", values, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoNotIn(List<String> values) {
            addCriterion("occu_photo not in", values, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoBetween(String value1, String value2) {
            addCriterion("occu_photo between", value1, value2, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andOccuPhotoNotBetween(String value1, String value2) {
            addCriterion("occu_photo not between", value1, value2, "occuPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoIsNull() {
            addCriterion("art_photo is null");
            return (Criteria) this;
        }

        public Criteria andArtPhotoIsNotNull() {
            addCriterion("art_photo is not null");
            return (Criteria) this;
        }

        public Criteria andArtPhotoEqualTo(String value) {
            addCriterion("art_photo =", value, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoNotEqualTo(String value) {
            addCriterion("art_photo <>", value, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoGreaterThan(String value) {
            addCriterion("art_photo >", value, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("art_photo >=", value, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoLessThan(String value) {
            addCriterion("art_photo <", value, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoLessThanOrEqualTo(String value) {
            addCriterion("art_photo <=", value, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoLike(String value) {
            addCriterion("art_photo like", value, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoNotLike(String value) {
            addCriterion("art_photo not like", value, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoIn(List<String> values) {
            addCriterion("art_photo in", values, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoNotIn(List<String> values) {
            addCriterion("art_photo not in", values, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoBetween(String value1, String value2) {
            addCriterion("art_photo between", value1, value2, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andArtPhotoNotBetween(String value1, String value2) {
            addCriterion("art_photo not between", value1, value2, "artPhoto");
            return (Criteria) this;
        }

        public Criteria andPtagIsNull() {
            addCriterion("ptag is null");
            return (Criteria) this;
        }

        public Criteria andPtagIsNotNull() {
            addCriterion("ptag is not null");
            return (Criteria) this;
        }

        public Criteria andPtagEqualTo(String value) {
            addCriterion("ptag =", value, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagNotEqualTo(String value) {
            addCriterion("ptag <>", value, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagGreaterThan(String value) {
            addCriterion("ptag >", value, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagGreaterThanOrEqualTo(String value) {
            addCriterion("ptag >=", value, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagLessThan(String value) {
            addCriterion("ptag <", value, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagLessThanOrEqualTo(String value) {
            addCriterion("ptag <=", value, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagLike(String value) {
            addCriterion("ptag like", value, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagNotLike(String value) {
            addCriterion("ptag not like", value, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagIn(List<String> values) {
            addCriterion("ptag in", values, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagNotIn(List<String> values) {
            addCriterion("ptag not in", values, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagBetween(String value1, String value2) {
            addCriterion("ptag between", value1, value2, "ptag");
            return (Criteria) this;
        }

        public Criteria andPtagNotBetween(String value1, String value2) {
            addCriterion("ptag not between", value1, value2, "ptag");
            return (Criteria) this;
        }

        public Criteria andLastuptimeIsNull() {
            addCriterion("lastuptime is null");
            return (Criteria) this;
        }

        public Criteria andLastuptimeIsNotNull() {
            addCriterion("lastuptime is not null");
            return (Criteria) this;
        }

        public Criteria andLastuptimeEqualTo(Date value) {
            addCriterion("lastuptime =", value, "lastuptime");
            return (Criteria) this;
        }

        public Criteria andLastuptimeNotEqualTo(Date value) {
            addCriterion("lastuptime <>", value, "lastuptime");
            return (Criteria) this;
        }

        public Criteria andLastuptimeGreaterThan(Date value) {
            addCriterion("lastuptime >", value, "lastuptime");
            return (Criteria) this;
        }

        public Criteria andLastuptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastuptime >=", value, "lastuptime");
            return (Criteria) this;
        }

        public Criteria andLastuptimeLessThan(Date value) {
            addCriterion("lastuptime <", value, "lastuptime");
            return (Criteria) this;
        }

        public Criteria andLastuptimeLessThanOrEqualTo(Date value) {
            addCriterion("lastuptime <=", value, "lastuptime");
            return (Criteria) this;
        }

        public Criteria andLastuptimeIn(List<Date> values) {
            addCriterion("lastuptime in", values, "lastuptime");
            return (Criteria) this;
        }

        public Criteria andLastuptimeNotIn(List<Date> values) {
            addCriterion("lastuptime not in", values, "lastuptime");
            return (Criteria) this;
        }

        public Criteria andLastuptimeBetween(Date value1, Date value2) {
            addCriterion("lastuptime between", value1, value2, "lastuptime");
            return (Criteria) this;
        }

        public Criteria andLastuptimeNotBetween(Date value1, Date value2) {
            addCriterion("lastuptime not between", value1, value2, "lastuptime");
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

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
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