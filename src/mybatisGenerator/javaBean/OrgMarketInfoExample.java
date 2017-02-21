package mybatisGenerator.javaBean;

import java.util.ArrayList;
import java.util.List;

public class OrgMarketInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrgMarketInfoExample() {
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

        public Criteria andIssueIdIsNull() {
            addCriterion("issue_id is null");
            return (Criteria) this;
        }

        public Criteria andIssueIdIsNotNull() {
            addCriterion("issue_id is not null");
            return (Criteria) this;
        }

        public Criteria andIssueIdEqualTo(Long value) {
            addCriterion("issue_id =", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotEqualTo(Long value) {
            addCriterion("issue_id <>", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdGreaterThan(Long value) {
            addCriterion("issue_id >", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("issue_id >=", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdLessThan(Long value) {
            addCriterion("issue_id <", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdLessThanOrEqualTo(Long value) {
            addCriterion("issue_id <=", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdIn(List<Long> values) {
            addCriterion("issue_id in", values, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotIn(List<Long> values) {
            addCriterion("issue_id not in", values, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdBetween(Long value1, Long value2) {
            addCriterion("issue_id between", value1, value2, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotBetween(Long value1, Long value2) {
            addCriterion("issue_id not between", value1, value2, "issueId");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(String value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(String value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(String value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(String value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(String value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(String value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLike(String value) {
            addCriterion("stock like", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotLike(String value) {
            addCriterion("stock not like", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<String> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<String> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(String value1, String value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(String value1, String value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andListeMarketIsNull() {
            addCriterion("liste_market is null");
            return (Criteria) this;
        }

        public Criteria andListeMarketIsNotNull() {
            addCriterion("liste_market is not null");
            return (Criteria) this;
        }

        public Criteria andListeMarketEqualTo(String value) {
            addCriterion("liste_market =", value, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketNotEqualTo(String value) {
            addCriterion("liste_market <>", value, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketGreaterThan(String value) {
            addCriterion("liste_market >", value, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketGreaterThanOrEqualTo(String value) {
            addCriterion("liste_market >=", value, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketLessThan(String value) {
            addCriterion("liste_market <", value, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketLessThanOrEqualTo(String value) {
            addCriterion("liste_market <=", value, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketLike(String value) {
            addCriterion("liste_market like", value, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketNotLike(String value) {
            addCriterion("liste_market not like", value, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketIn(List<String> values) {
            addCriterion("liste_market in", values, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketNotIn(List<String> values) {
            addCriterion("liste_market not in", values, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketBetween(String value1, String value2) {
            addCriterion("liste_market between", value1, value2, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andListeMarketNotBetween(String value1, String value2) {
            addCriterion("liste_market not between", value1, value2, "listeMarket");
            return (Criteria) this;
        }

        public Criteria andCapitalStructIsNull() {
            addCriterion("capital_struct is null");
            return (Criteria) this;
        }

        public Criteria andCapitalStructIsNotNull() {
            addCriterion("capital_struct is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalStructEqualTo(String value) {
            addCriterion("capital_struct =", value, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructNotEqualTo(String value) {
            addCriterion("capital_struct <>", value, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructGreaterThan(String value) {
            addCriterion("capital_struct >", value, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructGreaterThanOrEqualTo(String value) {
            addCriterion("capital_struct >=", value, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructLessThan(String value) {
            addCriterion("capital_struct <", value, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructLessThanOrEqualTo(String value) {
            addCriterion("capital_struct <=", value, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructLike(String value) {
            addCriterion("capital_struct like", value, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructNotLike(String value) {
            addCriterion("capital_struct not like", value, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructIn(List<String> values) {
            addCriterion("capital_struct in", values, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructNotIn(List<String> values) {
            addCriterion("capital_struct not in", values, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructBetween(String value1, String value2) {
            addCriterion("capital_struct between", value1, value2, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andCapitalStructNotBetween(String value1, String value2) {
            addCriterion("capital_struct not between", value1, value2, "capitalStruct");
            return (Criteria) this;
        }

        public Criteria andStockTypeIsNull() {
            addCriterion("stock_type is null");
            return (Criteria) this;
        }

        public Criteria andStockTypeIsNotNull() {
            addCriterion("stock_type is not null");
            return (Criteria) this;
        }

        public Criteria andStockTypeEqualTo(String value) {
            addCriterion("stock_type =", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotEqualTo(String value) {
            addCriterion("stock_type <>", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeGreaterThan(String value) {
            addCriterion("stock_type >", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_type >=", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeLessThan(String value) {
            addCriterion("stock_type <", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeLessThanOrEqualTo(String value) {
            addCriterion("stock_type <=", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeLike(String value) {
            addCriterion("stock_type like", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotLike(String value) {
            addCriterion("stock_type not like", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeIn(List<String> values) {
            addCriterion("stock_type in", values, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotIn(List<String> values) {
            addCriterion("stock_type not in", values, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeBetween(String value1, String value2) {
            addCriterion("stock_type between", value1, value2, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotBetween(String value1, String value2) {
            addCriterion("stock_type not between", value1, value2, "stockType");
            return (Criteria) this;
        }

        public Criteria andMarketDataIsNull() {
            addCriterion("market_data is null");
            return (Criteria) this;
        }

        public Criteria andMarketDataIsNotNull() {
            addCriterion("market_data is not null");
            return (Criteria) this;
        }

        public Criteria andMarketDataEqualTo(String value) {
            addCriterion("market_data =", value, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataNotEqualTo(String value) {
            addCriterion("market_data <>", value, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataGreaterThan(String value) {
            addCriterion("market_data >", value, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataGreaterThanOrEqualTo(String value) {
            addCriterion("market_data >=", value, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataLessThan(String value) {
            addCriterion("market_data <", value, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataLessThanOrEqualTo(String value) {
            addCriterion("market_data <=", value, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataLike(String value) {
            addCriterion("market_data like", value, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataNotLike(String value) {
            addCriterion("market_data not like", value, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataIn(List<String> values) {
            addCriterion("market_data in", values, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataNotIn(List<String> values) {
            addCriterion("market_data not in", values, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataBetween(String value1, String value2) {
            addCriterion("market_data between", value1, value2, "marketData");
            return (Criteria) this;
        }

        public Criteria andMarketDataNotBetween(String value1, String value2) {
            addCriterion("market_data not between", value1, value2, "marketData");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateIsNull() {
            addCriterion("institution_rate is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateIsNotNull() {
            addCriterion("institution_rate is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateEqualTo(String value) {
            addCriterion("institution_rate =", value, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateNotEqualTo(String value) {
            addCriterion("institution_rate <>", value, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateGreaterThan(String value) {
            addCriterion("institution_rate >", value, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateGreaterThanOrEqualTo(String value) {
            addCriterion("institution_rate >=", value, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateLessThan(String value) {
            addCriterion("institution_rate <", value, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateLessThanOrEqualTo(String value) {
            addCriterion("institution_rate <=", value, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateLike(String value) {
            addCriterion("institution_rate like", value, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateNotLike(String value) {
            addCriterion("institution_rate not like", value, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateIn(List<String> values) {
            addCriterion("institution_rate in", values, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateNotIn(List<String> values) {
            addCriterion("institution_rate not in", values, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateBetween(String value1, String value2) {
            addCriterion("institution_rate between", value1, value2, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andInstitutionRateNotBetween(String value1, String value2) {
            addCriterion("institution_rate not between", value1, value2, "institutionRate");
            return (Criteria) this;
        }

        public Criteria andBonusInfoIsNull() {
            addCriterion("bonus_info is null");
            return (Criteria) this;
        }

        public Criteria andBonusInfoIsNotNull() {
            addCriterion("bonus_info is not null");
            return (Criteria) this;
        }

        public Criteria andBonusInfoEqualTo(String value) {
            addCriterion("bonus_info =", value, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoNotEqualTo(String value) {
            addCriterion("bonus_info <>", value, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoGreaterThan(String value) {
            addCriterion("bonus_info >", value, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoGreaterThanOrEqualTo(String value) {
            addCriterion("bonus_info >=", value, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoLessThan(String value) {
            addCriterion("bonus_info <", value, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoLessThanOrEqualTo(String value) {
            addCriterion("bonus_info <=", value, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoLike(String value) {
            addCriterion("bonus_info like", value, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoNotLike(String value) {
            addCriterion("bonus_info not like", value, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoIn(List<String> values) {
            addCriterion("bonus_info in", values, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoNotIn(List<String> values) {
            addCriterion("bonus_info not in", values, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoBetween(String value1, String value2) {
            addCriterion("bonus_info between", value1, value2, "bonusInfo");
            return (Criteria) this;
        }

        public Criteria andBonusInfoNotBetween(String value1, String value2) {
            addCriterion("bonus_info not between", value1, value2, "bonusInfo");
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