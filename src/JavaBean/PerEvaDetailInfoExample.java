package JavaBean;

import java.util.ArrayList;
import java.util.List;

public class PerEvaDetailInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PerEvaDetailInfoExample() {
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

        public Criteria andEvaIdIsNull() {
            addCriterion("eva_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaIdIsNotNull() {
            addCriterion("eva_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaIdEqualTo(Long value) {
            addCriterion("eva_id =", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdNotEqualTo(Long value) {
            addCriterion("eva_id <>", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdGreaterThan(Long value) {
            addCriterion("eva_id >", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("eva_id >=", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdLessThan(Long value) {
            addCriterion("eva_id <", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdLessThanOrEqualTo(Long value) {
            addCriterion("eva_id <=", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdIn(List<Long> values) {
            addCriterion("eva_id in", values, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdNotIn(List<Long> values) {
            addCriterion("eva_id not in", values, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdBetween(Long value1, Long value2) {
            addCriterion("eva_id between", value1, value2, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdNotBetween(Long value1, Long value2) {
            addCriterion("eva_id not between", value1, value2, "evaId");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNull() {
            addCriterion("hobby is null");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNotNull() {
            addCriterion("hobby is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyEqualTo(String value) {
            addCriterion("hobby =", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotEqualTo(String value) {
            addCriterion("hobby <>", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThan(String value) {
            addCriterion("hobby >", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("hobby >=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThan(String value) {
            addCriterion("hobby <", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThanOrEqualTo(String value) {
            addCriterion("hobby <=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLike(String value) {
            addCriterion("hobby like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotLike(String value) {
            addCriterion("hobby not like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyIn(List<String> values) {
            addCriterion("hobby in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotIn(List<String> values) {
            addCriterion("hobby not in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyBetween(String value1, String value2) {
            addCriterion("hobby between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotBetween(String value1, String value2) {
            addCriterion("hobby not between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andPsychologyIsNull() {
            addCriterion("psychology is null");
            return (Criteria) this;
        }

        public Criteria andPsychologyIsNotNull() {
            addCriterion("psychology is not null");
            return (Criteria) this;
        }

        public Criteria andPsychologyEqualTo(String value) {
            addCriterion("psychology =", value, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyNotEqualTo(String value) {
            addCriterion("psychology <>", value, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyGreaterThan(String value) {
            addCriterion("psychology >", value, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyGreaterThanOrEqualTo(String value) {
            addCriterion("psychology >=", value, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyLessThan(String value) {
            addCriterion("psychology <", value, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyLessThanOrEqualTo(String value) {
            addCriterion("psychology <=", value, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyLike(String value) {
            addCriterion("psychology like", value, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyNotLike(String value) {
            addCriterion("psychology not like", value, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyIn(List<String> values) {
            addCriterion("psychology in", values, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyNotIn(List<String> values) {
            addCriterion("psychology not in", values, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyBetween(String value1, String value2) {
            addCriterion("psychology between", value1, value2, "psychology");
            return (Criteria) this;
        }

        public Criteria andPsychologyNotBetween(String value1, String value2) {
            addCriterion("psychology not between", value1, value2, "psychology");
            return (Criteria) this;
        }

        public Criteria andMandIsNull() {
            addCriterion("mand is null");
            return (Criteria) this;
        }

        public Criteria andMandIsNotNull() {
            addCriterion("mand is not null");
            return (Criteria) this;
        }

        public Criteria andMandEqualTo(String value) {
            addCriterion("mand =", value, "mand");
            return (Criteria) this;
        }

        public Criteria andMandNotEqualTo(String value) {
            addCriterion("mand <>", value, "mand");
            return (Criteria) this;
        }

        public Criteria andMandGreaterThan(String value) {
            addCriterion("mand >", value, "mand");
            return (Criteria) this;
        }

        public Criteria andMandGreaterThanOrEqualTo(String value) {
            addCriterion("mand >=", value, "mand");
            return (Criteria) this;
        }

        public Criteria andMandLessThan(String value) {
            addCriterion("mand <", value, "mand");
            return (Criteria) this;
        }

        public Criteria andMandLessThanOrEqualTo(String value) {
            addCriterion("mand <=", value, "mand");
            return (Criteria) this;
        }

        public Criteria andMandLike(String value) {
            addCriterion("mand like", value, "mand");
            return (Criteria) this;
        }

        public Criteria andMandNotLike(String value) {
            addCriterion("mand not like", value, "mand");
            return (Criteria) this;
        }

        public Criteria andMandIn(List<String> values) {
            addCriterion("mand in", values, "mand");
            return (Criteria) this;
        }

        public Criteria andMandNotIn(List<String> values) {
            addCriterion("mand not in", values, "mand");
            return (Criteria) this;
        }

        public Criteria andMandBetween(String value1, String value2) {
            addCriterion("mand between", value1, value2, "mand");
            return (Criteria) this;
        }

        public Criteria andMandNotBetween(String value1, String value2) {
            addCriterion("mand not between", value1, value2, "mand");
            return (Criteria) this;
        }

        public Criteria andCharactIsNull() {
            addCriterion("charact is null");
            return (Criteria) this;
        }

        public Criteria andCharactIsNotNull() {
            addCriterion("charact is not null");
            return (Criteria) this;
        }

        public Criteria andCharactEqualTo(String value) {
            addCriterion("charact =", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotEqualTo(String value) {
            addCriterion("charact <>", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactGreaterThan(String value) {
            addCriterion("charact >", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactGreaterThanOrEqualTo(String value) {
            addCriterion("charact >=", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLessThan(String value) {
            addCriterion("charact <", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLessThanOrEqualTo(String value) {
            addCriterion("charact <=", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLike(String value) {
            addCriterion("charact like", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotLike(String value) {
            addCriterion("charact not like", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactIn(List<String> values) {
            addCriterion("charact in", values, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotIn(List<String> values) {
            addCriterion("charact not in", values, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactBetween(String value1, String value2) {
            addCriterion("charact between", value1, value2, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotBetween(String value1, String value2) {
            addCriterion("charact not between", value1, value2, "charact");
            return (Criteria) this;
        }

        public Criteria andPfAbilityIsNull() {
            addCriterion("pf_ability is null");
            return (Criteria) this;
        }

        public Criteria andPfAbilityIsNotNull() {
            addCriterion("pf_ability is not null");
            return (Criteria) this;
        }

        public Criteria andPfAbilityEqualTo(String value) {
            addCriterion("pf_ability =", value, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityNotEqualTo(String value) {
            addCriterion("pf_ability <>", value, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityGreaterThan(String value) {
            addCriterion("pf_ability >", value, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityGreaterThanOrEqualTo(String value) {
            addCriterion("pf_ability >=", value, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityLessThan(String value) {
            addCriterion("pf_ability <", value, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityLessThanOrEqualTo(String value) {
            addCriterion("pf_ability <=", value, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityLike(String value) {
            addCriterion("pf_ability like", value, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityNotLike(String value) {
            addCriterion("pf_ability not like", value, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityIn(List<String> values) {
            addCriterion("pf_ability in", values, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityNotIn(List<String> values) {
            addCriterion("pf_ability not in", values, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityBetween(String value1, String value2) {
            addCriterion("pf_ability between", value1, value2, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andPfAbilityNotBetween(String value1, String value2) {
            addCriterion("pf_ability not between", value1, value2, "pfAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityIsNull() {
            addCriterion("mg_ability is null");
            return (Criteria) this;
        }

        public Criteria andMgAbilityIsNotNull() {
            addCriterion("mg_ability is not null");
            return (Criteria) this;
        }

        public Criteria andMgAbilityEqualTo(String value) {
            addCriterion("mg_ability =", value, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityNotEqualTo(String value) {
            addCriterion("mg_ability <>", value, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityGreaterThan(String value) {
            addCriterion("mg_ability >", value, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityGreaterThanOrEqualTo(String value) {
            addCriterion("mg_ability >=", value, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityLessThan(String value) {
            addCriterion("mg_ability <", value, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityLessThanOrEqualTo(String value) {
            addCriterion("mg_ability <=", value, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityLike(String value) {
            addCriterion("mg_ability like", value, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityNotLike(String value) {
            addCriterion("mg_ability not like", value, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityIn(List<String> values) {
            addCriterion("mg_ability in", values, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityNotIn(List<String> values) {
            addCriterion("mg_ability not in", values, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityBetween(String value1, String value2) {
            addCriterion("mg_ability between", value1, value2, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andMgAbilityNotBetween(String value1, String value2) {
            addCriterion("mg_ability not between", value1, value2, "mgAbility");
            return (Criteria) this;
        }

        public Criteria andItThinkIsNull() {
            addCriterion("it_think is null");
            return (Criteria) this;
        }

        public Criteria andItThinkIsNotNull() {
            addCriterion("it_think is not null");
            return (Criteria) this;
        }

        public Criteria andItThinkEqualTo(String value) {
            addCriterion("it_think =", value, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkNotEqualTo(String value) {
            addCriterion("it_think <>", value, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkGreaterThan(String value) {
            addCriterion("it_think >", value, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkGreaterThanOrEqualTo(String value) {
            addCriterion("it_think >=", value, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkLessThan(String value) {
            addCriterion("it_think <", value, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkLessThanOrEqualTo(String value) {
            addCriterion("it_think <=", value, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkLike(String value) {
            addCriterion("it_think like", value, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkNotLike(String value) {
            addCriterion("it_think not like", value, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkIn(List<String> values) {
            addCriterion("it_think in", values, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkNotIn(List<String> values) {
            addCriterion("it_think not in", values, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkBetween(String value1, String value2) {
            addCriterion("it_think between", value1, value2, "itThink");
            return (Criteria) this;
        }

        public Criteria andItThinkNotBetween(String value1, String value2) {
            addCriterion("it_think not between", value1, value2, "itThink");
            return (Criteria) this;
        }

        public Criteria andVirtueIsNull() {
            addCriterion("virtue is null");
            return (Criteria) this;
        }

        public Criteria andVirtueIsNotNull() {
            addCriterion("virtue is not null");
            return (Criteria) this;
        }

        public Criteria andVirtueEqualTo(String value) {
            addCriterion("virtue =", value, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueNotEqualTo(String value) {
            addCriterion("virtue <>", value, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueGreaterThan(String value) {
            addCriterion("virtue >", value, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueGreaterThanOrEqualTo(String value) {
            addCriterion("virtue >=", value, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueLessThan(String value) {
            addCriterion("virtue <", value, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueLessThanOrEqualTo(String value) {
            addCriterion("virtue <=", value, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueLike(String value) {
            addCriterion("virtue like", value, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueNotLike(String value) {
            addCriterion("virtue not like", value, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueIn(List<String> values) {
            addCriterion("virtue in", values, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueNotIn(List<String> values) {
            addCriterion("virtue not in", values, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueBetween(String value1, String value2) {
            addCriterion("virtue between", value1, value2, "virtue");
            return (Criteria) this;
        }

        public Criteria andVirtueNotBetween(String value1, String value2) {
            addCriterion("virtue not between", value1, value2, "virtue");
            return (Criteria) this;
        }

        public Criteria andFlawIsNull() {
            addCriterion("flaw is null");
            return (Criteria) this;
        }

        public Criteria andFlawIsNotNull() {
            addCriterion("flaw is not null");
            return (Criteria) this;
        }

        public Criteria andFlawEqualTo(String value) {
            addCriterion("flaw =", value, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawNotEqualTo(String value) {
            addCriterion("flaw <>", value, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawGreaterThan(String value) {
            addCriterion("flaw >", value, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawGreaterThanOrEqualTo(String value) {
            addCriterion("flaw >=", value, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawLessThan(String value) {
            addCriterion("flaw <", value, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawLessThanOrEqualTo(String value) {
            addCriterion("flaw <=", value, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawLike(String value) {
            addCriterion("flaw like", value, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawNotLike(String value) {
            addCriterion("flaw not like", value, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawIn(List<String> values) {
            addCriterion("flaw in", values, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawNotIn(List<String> values) {
            addCriterion("flaw not in", values, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawBetween(String value1, String value2) {
            addCriterion("flaw between", value1, value2, "flaw");
            return (Criteria) this;
        }

        public Criteria andFlawNotBetween(String value1, String value2) {
            addCriterion("flaw not between", value1, value2, "flaw");
            return (Criteria) this;
        }

        public Criteria andBosomIsNull() {
            addCriterion("bosom is null");
            return (Criteria) this;
        }

        public Criteria andBosomIsNotNull() {
            addCriterion("bosom is not null");
            return (Criteria) this;
        }

        public Criteria andBosomEqualTo(String value) {
            addCriterion("bosom =", value, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomNotEqualTo(String value) {
            addCriterion("bosom <>", value, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomGreaterThan(String value) {
            addCriterion("bosom >", value, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomGreaterThanOrEqualTo(String value) {
            addCriterion("bosom >=", value, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomLessThan(String value) {
            addCriterion("bosom <", value, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomLessThanOrEqualTo(String value) {
            addCriterion("bosom <=", value, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomLike(String value) {
            addCriterion("bosom like", value, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomNotLike(String value) {
            addCriterion("bosom not like", value, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomIn(List<String> values) {
            addCriterion("bosom in", values, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomNotIn(List<String> values) {
            addCriterion("bosom not in", values, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomBetween(String value1, String value2) {
            addCriterion("bosom between", value1, value2, "bosom");
            return (Criteria) this;
        }

        public Criteria andBosomNotBetween(String value1, String value2) {
            addCriterion("bosom not between", value1, value2, "bosom");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusIsNull() {
            addCriterion("family_status is null");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusIsNotNull() {
            addCriterion("family_status is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusEqualTo(String value) {
            addCriterion("family_status =", value, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusNotEqualTo(String value) {
            addCriterion("family_status <>", value, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusGreaterThan(String value) {
            addCriterion("family_status >", value, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("family_status >=", value, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusLessThan(String value) {
            addCriterion("family_status <", value, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusLessThanOrEqualTo(String value) {
            addCriterion("family_status <=", value, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusLike(String value) {
            addCriterion("family_status like", value, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusNotLike(String value) {
            addCriterion("family_status not like", value, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusIn(List<String> values) {
            addCriterion("family_status in", values, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusNotIn(List<String> values) {
            addCriterion("family_status not in", values, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusBetween(String value1, String value2) {
            addCriterion("family_status between", value1, value2, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andFamilyStatusNotBetween(String value1, String value2) {
            addCriterion("family_status not between", value1, value2, "familyStatus");
            return (Criteria) this;
        }

        public Criteria andEthicsIsNull() {
            addCriterion("ethics is null");
            return (Criteria) this;
        }

        public Criteria andEthicsIsNotNull() {
            addCriterion("ethics is not null");
            return (Criteria) this;
        }

        public Criteria andEthicsEqualTo(String value) {
            addCriterion("ethics =", value, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsNotEqualTo(String value) {
            addCriterion("ethics <>", value, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsGreaterThan(String value) {
            addCriterion("ethics >", value, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsGreaterThanOrEqualTo(String value) {
            addCriterion("ethics >=", value, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsLessThan(String value) {
            addCriterion("ethics <", value, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsLessThanOrEqualTo(String value) {
            addCriterion("ethics <=", value, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsLike(String value) {
            addCriterion("ethics like", value, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsNotLike(String value) {
            addCriterion("ethics not like", value, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsIn(List<String> values) {
            addCriterion("ethics in", values, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsNotIn(List<String> values) {
            addCriterion("ethics not in", values, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsBetween(String value1, String value2) {
            addCriterion("ethics between", value1, value2, "ethics");
            return (Criteria) this;
        }

        public Criteria andEthicsNotBetween(String value1, String value2) {
            addCriterion("ethics not between", value1, value2, "ethics");
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