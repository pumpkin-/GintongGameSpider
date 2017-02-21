package JavaBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PerGameInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PerGameInfoExample() {
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

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNull() {
            addCriterion("rolename is null");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNotNull() {
            addCriterion("rolename is not null");
            return (Criteria) this;
        }

        public Criteria andRolenameEqualTo(String value) {
            addCriterion("rolename =", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotEqualTo(String value) {
            addCriterion("rolename <>", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThan(String value) {
            addCriterion("rolename >", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThanOrEqualTo(String value) {
            addCriterion("rolename >=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThan(String value) {
            addCriterion("rolename <", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThanOrEqualTo(String value) {
            addCriterion("rolename <=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLike(String value) {
            addCriterion("rolename like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotLike(String value) {
            addCriterion("rolename not like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameIn(List<String> values) {
            addCriterion("rolename in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotIn(List<String> values) {
            addCriterion("rolename not in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameBetween(String value1, String value2) {
            addCriterion("rolename between", value1, value2, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotBetween(String value1, String value2) {
            addCriterion("rolename not between", value1, value2, "rolename");
            return (Criteria) this;
        }

        public Criteria andAchievementIsNull() {
            addCriterion("achievement is null");
            return (Criteria) this;
        }

        public Criteria andAchievementIsNotNull() {
            addCriterion("achievement is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementEqualTo(String value) {
            addCriterion("achievement =", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementNotEqualTo(String value) {
            addCriterion("achievement <>", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementGreaterThan(String value) {
            addCriterion("achievement >", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementGreaterThanOrEqualTo(String value) {
            addCriterion("achievement >=", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementLessThan(String value) {
            addCriterion("achievement <", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementLessThanOrEqualTo(String value) {
            addCriterion("achievement <=", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementLike(String value) {
            addCriterion("achievement like", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementNotLike(String value) {
            addCriterion("achievement not like", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementIn(List<String> values) {
            addCriterion("achievement in", values, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementNotIn(List<String> values) {
            addCriterion("achievement not in", values, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementBetween(String value1, String value2) {
            addCriterion("achievement between", value1, value2, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementNotBetween(String value1, String value2) {
            addCriterion("achievement not between", value1, value2, "achievement");
            return (Criteria) this;
        }

        public Criteria andLvlIsNull() {
            addCriterion("lvl is null");
            return (Criteria) this;
        }

        public Criteria andLvlIsNotNull() {
            addCriterion("lvl is not null");
            return (Criteria) this;
        }

        public Criteria andLvlEqualTo(String value) {
            addCriterion("lvl =", value, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlNotEqualTo(String value) {
            addCriterion("lvl <>", value, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlGreaterThan(String value) {
            addCriterion("lvl >", value, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlGreaterThanOrEqualTo(String value) {
            addCriterion("lvl >=", value, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlLessThan(String value) {
            addCriterion("lvl <", value, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlLessThanOrEqualTo(String value) {
            addCriterion("lvl <=", value, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlLike(String value) {
            addCriterion("lvl like", value, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlNotLike(String value) {
            addCriterion("lvl not like", value, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlIn(List<String> values) {
            addCriterion("lvl in", values, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlNotIn(List<String> values) {
            addCriterion("lvl not in", values, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlBetween(String value1, String value2) {
            addCriterion("lvl between", value1, value2, "lvl");
            return (Criteria) this;
        }

        public Criteria andLvlNotBetween(String value1, String value2) {
            addCriterion("lvl not between", value1, value2, "lvl");
            return (Criteria) this;
        }

        public Criteria andGangIsNull() {
            addCriterion("gang is null");
            return (Criteria) this;
        }

        public Criteria andGangIsNotNull() {
            addCriterion("gang is not null");
            return (Criteria) this;
        }

        public Criteria andGangEqualTo(String value) {
            addCriterion("gang =", value, "gang");
            return (Criteria) this;
        }

        public Criteria andGangNotEqualTo(String value) {
            addCriterion("gang <>", value, "gang");
            return (Criteria) this;
        }

        public Criteria andGangGreaterThan(String value) {
            addCriterion("gang >", value, "gang");
            return (Criteria) this;
        }

        public Criteria andGangGreaterThanOrEqualTo(String value) {
            addCriterion("gang >=", value, "gang");
            return (Criteria) this;
        }

        public Criteria andGangLessThan(String value) {
            addCriterion("gang <", value, "gang");
            return (Criteria) this;
        }

        public Criteria andGangLessThanOrEqualTo(String value) {
            addCriterion("gang <=", value, "gang");
            return (Criteria) this;
        }

        public Criteria andGangLike(String value) {
            addCriterion("gang like", value, "gang");
            return (Criteria) this;
        }

        public Criteria andGangNotLike(String value) {
            addCriterion("gang not like", value, "gang");
            return (Criteria) this;
        }

        public Criteria andGangIn(List<String> values) {
            addCriterion("gang in", values, "gang");
            return (Criteria) this;
        }

        public Criteria andGangNotIn(List<String> values) {
            addCriterion("gang not in", values, "gang");
            return (Criteria) this;
        }

        public Criteria andGangBetween(String value1, String value2) {
            addCriterion("gang between", value1, value2, "gang");
            return (Criteria) this;
        }

        public Criteria andGangNotBetween(String value1, String value2) {
            addCriterion("gang not between", value1, value2, "gang");
            return (Criteria) this;
        }

        public Criteria andSpeechIsNull() {
            addCriterion("speech is null");
            return (Criteria) this;
        }

        public Criteria andSpeechIsNotNull() {
            addCriterion("speech is not null");
            return (Criteria) this;
        }

        public Criteria andSpeechEqualTo(String value) {
            addCriterion("speech =", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechNotEqualTo(String value) {
            addCriterion("speech <>", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechGreaterThan(String value) {
            addCriterion("speech >", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechGreaterThanOrEqualTo(String value) {
            addCriterion("speech >=", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechLessThan(String value) {
            addCriterion("speech <", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechLessThanOrEqualTo(String value) {
            addCriterion("speech <=", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechLike(String value) {
            addCriterion("speech like", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechNotLike(String value) {
            addCriterion("speech not like", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechIn(List<String> values) {
            addCriterion("speech in", values, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechNotIn(List<String> values) {
            addCriterion("speech not in", values, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechBetween(String value1, String value2) {
            addCriterion("speech between", value1, value2, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechNotBetween(String value1, String value2) {
            addCriterion("speech not between", value1, value2, "speech");
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

        public Criteria andConsumeIsNull() {
            addCriterion("consume is null");
            return (Criteria) this;
        }

        public Criteria andConsumeIsNotNull() {
            addCriterion("consume is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeEqualTo(String value) {
            addCriterion("consume =", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotEqualTo(String value) {
            addCriterion("consume <>", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThan(String value) {
            addCriterion("consume >", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThanOrEqualTo(String value) {
            addCriterion("consume >=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThan(String value) {
            addCriterion("consume <", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThanOrEqualTo(String value) {
            addCriterion("consume <=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLike(String value) {
            addCriterion("consume like", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotLike(String value) {
            addCriterion("consume not like", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeIn(List<String> values) {
            addCriterion("consume in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotIn(List<String> values) {
            addCriterion("consume not in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeBetween(String value1, String value2) {
            addCriterion("consume between", value1, value2, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotBetween(String value1, String value2) {
            addCriterion("consume not between", value1, value2, "consume");
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