package com.mall.generator.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public GenTableExample() {
        oredCriteria = new ArrayList<>();
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        public void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        public void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTable_idIsNull() {
            addCriterion("gen_table.table_id is null");
            return (Criteria) this;
        }

        public Criteria andTable_idIsNotNull() {
            addCriterion("gen_table.table_id is not null");
            return (Criteria) this;
        }

        public Criteria andTable_idEqualTo(Long value) {
            addCriterion("gen_table.table_id =", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idNotEqualTo(Long value) {
            addCriterion("gen_table.table_id <>", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idGreaterThan(Long value) {
            addCriterion("gen_table.table_id >", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idGreaterThanOrEqualTo(Long value) {
            addCriterion("gen_table.table_id >=", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idLessThan(Long value) {
            addCriterion("gen_table.table_id <", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idLessThanOrEqualTo(Long value) {
            addCriterion("gen_table.table_id <=", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idIn(List<Long> values) {
            addCriterion("gen_table.table_id in", values, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idNotIn(List<Long> values) {
            addCriterion("gen_table.table_id not in", values, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idBetween(Long value1, Long value2) {
            addCriterion("gen_table.table_id between", value1, value2, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idNotBetween(Long value1, Long value2) {
            addCriterion("gen_table.table_id not between", value1, value2, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_nameIsNull() {
            addCriterion("gen_table.`table_name` is null");
            return (Criteria) this;
        }

        public Criteria andTable_nameIsNotNull() {
            addCriterion("gen_table.`table_name` is not null");
            return (Criteria) this;
        }

        public Criteria andTable_nameEqualTo(String value) {
            addCriterion("gen_table.`table_name` =", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotEqualTo(String value) {
            addCriterion("gen_table.`table_name` <>", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameGreaterThan(String value) {
            addCriterion("gen_table.`table_name` >", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.`table_name` >=", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLessThan(String value) {
            addCriterion("gen_table.`table_name` <", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLessThanOrEqualTo(String value) {
            addCriterion("gen_table.`table_name` <=", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLike(String value) {
            addCriterion("gen_table.`table_name` like", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotLike(String value) {
            addCriterion("gen_table.`table_name` not like", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameIn(List<String> values) {
            addCriterion("gen_table.`table_name` in", values, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotIn(List<String> values) {
            addCriterion("gen_table.`table_name` not in", values, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameBetween(String value1, String value2) {
            addCriterion("gen_table.`table_name` between", value1, value2, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotBetween(String value1, String value2) {
            addCriterion("gen_table.`table_name` not between", value1, value2, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_commentIsNull() {
            addCriterion("gen_table.table_comment is null");
            return (Criteria) this;
        }

        public Criteria andTable_commentIsNotNull() {
            addCriterion("gen_table.table_comment is not null");
            return (Criteria) this;
        }

        public Criteria andTable_commentEqualTo(String value) {
            addCriterion("gen_table.table_comment =", value, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentNotEqualTo(String value) {
            addCriterion("gen_table.table_comment <>", value, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentGreaterThan(String value) {
            addCriterion("gen_table.table_comment >", value, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.table_comment >=", value, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentLessThan(String value) {
            addCriterion("gen_table.table_comment <", value, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentLessThanOrEqualTo(String value) {
            addCriterion("gen_table.table_comment <=", value, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentLike(String value) {
            addCriterion("gen_table.table_comment like", value, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentNotLike(String value) {
            addCriterion("gen_table.table_comment not like", value, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentIn(List<String> values) {
            addCriterion("gen_table.table_comment in", values, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentNotIn(List<String> values) {
            addCriterion("gen_table.table_comment not in", values, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentBetween(String value1, String value2) {
            addCriterion("gen_table.table_comment between", value1, value2, "table_comment");
            return (Criteria) this;
        }

        public Criteria andTable_commentNotBetween(String value1, String value2) {
            addCriterion("gen_table.table_comment not between", value1, value2, "table_comment");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameIsNull() {
            addCriterion("gen_table.sub_table_name is null");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameIsNotNull() {
            addCriterion("gen_table.sub_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameEqualTo(String value) {
            addCriterion("gen_table.sub_table_name =", value, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameNotEqualTo(String value) {
            addCriterion("gen_table.sub_table_name <>", value, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameGreaterThan(String value) {
            addCriterion("gen_table.sub_table_name >", value, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.sub_table_name >=", value, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameLessThan(String value) {
            addCriterion("gen_table.sub_table_name <", value, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameLessThanOrEqualTo(String value) {
            addCriterion("gen_table.sub_table_name <=", value, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameLike(String value) {
            addCriterion("gen_table.sub_table_name like", value, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameNotLike(String value) {
            addCriterion("gen_table.sub_table_name not like", value, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameIn(List<String> values) {
            addCriterion("gen_table.sub_table_name in", values, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameNotIn(List<String> values) {
            addCriterion("gen_table.sub_table_name not in", values, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameBetween(String value1, String value2) {
            addCriterion("gen_table.sub_table_name between", value1, value2, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_nameNotBetween(String value1, String value2) {
            addCriterion("gen_table.sub_table_name not between", value1, value2, "sub_table_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameIsNull() {
            addCriterion("gen_table.sub_table_fk_name is null");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameIsNotNull() {
            addCriterion("gen_table.sub_table_fk_name is not null");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameEqualTo(String value) {
            addCriterion("gen_table.sub_table_fk_name =", value, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameNotEqualTo(String value) {
            addCriterion("gen_table.sub_table_fk_name <>", value, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameGreaterThan(String value) {
            addCriterion("gen_table.sub_table_fk_name >", value, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.sub_table_fk_name >=", value, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameLessThan(String value) {
            addCriterion("gen_table.sub_table_fk_name <", value, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameLessThanOrEqualTo(String value) {
            addCriterion("gen_table.sub_table_fk_name <=", value, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameLike(String value) {
            addCriterion("gen_table.sub_table_fk_name like", value, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameNotLike(String value) {
            addCriterion("gen_table.sub_table_fk_name not like", value, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameIn(List<String> values) {
            addCriterion("gen_table.sub_table_fk_name in", values, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameNotIn(List<String> values) {
            addCriterion("gen_table.sub_table_fk_name not in", values, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameBetween(String value1, String value2) {
            addCriterion("gen_table.sub_table_fk_name between", value1, value2, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andSub_table_fk_nameNotBetween(String value1, String value2) {
            addCriterion("gen_table.sub_table_fk_name not between", value1, value2, "sub_table_fk_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameIsNull() {
            addCriterion("gen_table.class_name is null");
            return (Criteria) this;
        }

        public Criteria andClass_nameIsNotNull() {
            addCriterion("gen_table.class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClass_nameEqualTo(String value) {
            addCriterion("gen_table.class_name =", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameNotEqualTo(String value) {
            addCriterion("gen_table.class_name <>", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameGreaterThan(String value) {
            addCriterion("gen_table.class_name >", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.class_name >=", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameLessThan(String value) {
            addCriterion("gen_table.class_name <", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameLessThanOrEqualTo(String value) {
            addCriterion("gen_table.class_name <=", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameLike(String value) {
            addCriterion("gen_table.class_name like", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameNotLike(String value) {
            addCriterion("gen_table.class_name not like", value, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameIn(List<String> values) {
            addCriterion("gen_table.class_name in", values, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameNotIn(List<String> values) {
            addCriterion("gen_table.class_name not in", values, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameBetween(String value1, String value2) {
            addCriterion("gen_table.class_name between", value1, value2, "class_name");
            return (Criteria) this;
        }

        public Criteria andClass_nameNotBetween(String value1, String value2) {
            addCriterion("gen_table.class_name not between", value1, value2, "class_name");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryIsNull() {
            addCriterion("gen_table.tpl_category is null");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryIsNotNull() {
            addCriterion("gen_table.tpl_category is not null");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryEqualTo(String value) {
            addCriterion("gen_table.tpl_category =", value, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryNotEqualTo(String value) {
            addCriterion("gen_table.tpl_category <>", value, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryGreaterThan(String value) {
            addCriterion("gen_table.tpl_category >", value, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.tpl_category >=", value, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryLessThan(String value) {
            addCriterion("gen_table.tpl_category <", value, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryLessThanOrEqualTo(String value) {
            addCriterion("gen_table.tpl_category <=", value, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryLike(String value) {
            addCriterion("gen_table.tpl_category like", value, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryNotLike(String value) {
            addCriterion("gen_table.tpl_category not like", value, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryIn(List<String> values) {
            addCriterion("gen_table.tpl_category in", values, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryNotIn(List<String> values) {
            addCriterion("gen_table.tpl_category not in", values, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryBetween(String value1, String value2) {
            addCriterion("gen_table.tpl_category between", value1, value2, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andTpl_categoryNotBetween(String value1, String value2) {
            addCriterion("gen_table.tpl_category not between", value1, value2, "tpl_category");
            return (Criteria) this;
        }

        public Criteria andPackage_nameIsNull() {
            addCriterion("gen_table.package_name is null");
            return (Criteria) this;
        }

        public Criteria andPackage_nameIsNotNull() {
            addCriterion("gen_table.package_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackage_nameEqualTo(String value) {
            addCriterion("gen_table.package_name =", value, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameNotEqualTo(String value) {
            addCriterion("gen_table.package_name <>", value, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameGreaterThan(String value) {
            addCriterion("gen_table.package_name >", value, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.package_name >=", value, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameLessThan(String value) {
            addCriterion("gen_table.package_name <", value, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameLessThanOrEqualTo(String value) {
            addCriterion("gen_table.package_name <=", value, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameLike(String value) {
            addCriterion("gen_table.package_name like", value, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameNotLike(String value) {
            addCriterion("gen_table.package_name not like", value, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameIn(List<String> values) {
            addCriterion("gen_table.package_name in", values, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameNotIn(List<String> values) {
            addCriterion("gen_table.package_name not in", values, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameBetween(String value1, String value2) {
            addCriterion("gen_table.package_name between", value1, value2, "package_name");
            return (Criteria) this;
        }

        public Criteria andPackage_nameNotBetween(String value1, String value2) {
            addCriterion("gen_table.package_name not between", value1, value2, "package_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameIsNull() {
            addCriterion("gen_table.module_name is null");
            return (Criteria) this;
        }

        public Criteria andModule_nameIsNotNull() {
            addCriterion("gen_table.module_name is not null");
            return (Criteria) this;
        }

        public Criteria andModule_nameEqualTo(String value) {
            addCriterion("gen_table.module_name =", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameNotEqualTo(String value) {
            addCriterion("gen_table.module_name <>", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameGreaterThan(String value) {
            addCriterion("gen_table.module_name >", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.module_name >=", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameLessThan(String value) {
            addCriterion("gen_table.module_name <", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameLessThanOrEqualTo(String value) {
            addCriterion("gen_table.module_name <=", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameLike(String value) {
            addCriterion("gen_table.module_name like", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameNotLike(String value) {
            addCriterion("gen_table.module_name not like", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameIn(List<String> values) {
            addCriterion("gen_table.module_name in", values, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameNotIn(List<String> values) {
            addCriterion("gen_table.module_name not in", values, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameBetween(String value1, String value2) {
            addCriterion("gen_table.module_name between", value1, value2, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameNotBetween(String value1, String value2) {
            addCriterion("gen_table.module_name not between", value1, value2, "module_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameIsNull() {
            addCriterion("gen_table.business_name is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameIsNotNull() {
            addCriterion("gen_table.business_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameEqualTo(String value) {
            addCriterion("gen_table.business_name =", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotEqualTo(String value) {
            addCriterion("gen_table.business_name <>", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameGreaterThan(String value) {
            addCriterion("gen_table.business_name >", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.business_name >=", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameLessThan(String value) {
            addCriterion("gen_table.business_name <", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameLessThanOrEqualTo(String value) {
            addCriterion("gen_table.business_name <=", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameLike(String value) {
            addCriterion("gen_table.business_name like", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotLike(String value) {
            addCriterion("gen_table.business_name not like", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameIn(List<String> values) {
            addCriterion("gen_table.business_name in", values, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotIn(List<String> values) {
            addCriterion("gen_table.business_name not in", values, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameBetween(String value1, String value2) {
            addCriterion("gen_table.business_name between", value1, value2, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotBetween(String value1, String value2) {
            addCriterion("gen_table.business_name not between", value1, value2, "business_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameIsNull() {
            addCriterion("gen_table.function_name is null");
            return (Criteria) this;
        }

        public Criteria andFunction_nameIsNotNull() {
            addCriterion("gen_table.function_name is not null");
            return (Criteria) this;
        }

        public Criteria andFunction_nameEqualTo(String value) {
            addCriterion("gen_table.function_name =", value, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameNotEqualTo(String value) {
            addCriterion("gen_table.function_name <>", value, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameGreaterThan(String value) {
            addCriterion("gen_table.function_name >", value, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.function_name >=", value, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameLessThan(String value) {
            addCriterion("gen_table.function_name <", value, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameLessThanOrEqualTo(String value) {
            addCriterion("gen_table.function_name <=", value, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameLike(String value) {
            addCriterion("gen_table.function_name like", value, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameNotLike(String value) {
            addCriterion("gen_table.function_name not like", value, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameIn(List<String> values) {
            addCriterion("gen_table.function_name in", values, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameNotIn(List<String> values) {
            addCriterion("gen_table.function_name not in", values, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameBetween(String value1, String value2) {
            addCriterion("gen_table.function_name between", value1, value2, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_nameNotBetween(String value1, String value2) {
            addCriterion("gen_table.function_name not between", value1, value2, "function_name");
            return (Criteria) this;
        }

        public Criteria andFunction_authorIsNull() {
            addCriterion("gen_table.function_author is null");
            return (Criteria) this;
        }

        public Criteria andFunction_authorIsNotNull() {
            addCriterion("gen_table.function_author is not null");
            return (Criteria) this;
        }

        public Criteria andFunction_authorEqualTo(String value) {
            addCriterion("gen_table.function_author =", value, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorNotEqualTo(String value) {
            addCriterion("gen_table.function_author <>", value, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorGreaterThan(String value) {
            addCriterion("gen_table.function_author >", value, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.function_author >=", value, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorLessThan(String value) {
            addCriterion("gen_table.function_author <", value, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorLessThanOrEqualTo(String value) {
            addCriterion("gen_table.function_author <=", value, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorLike(String value) {
            addCriterion("gen_table.function_author like", value, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorNotLike(String value) {
            addCriterion("gen_table.function_author not like", value, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorIn(List<String> values) {
            addCriterion("gen_table.function_author in", values, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorNotIn(List<String> values) {
            addCriterion("gen_table.function_author not in", values, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorBetween(String value1, String value2) {
            addCriterion("gen_table.function_author between", value1, value2, "function_author");
            return (Criteria) this;
        }

        public Criteria andFunction_authorNotBetween(String value1, String value2) {
            addCriterion("gen_table.function_author not between", value1, value2, "function_author");
            return (Criteria) this;
        }

        public Criteria andGen_typeIsNull() {
            addCriterion("gen_table.gen_type is null");
            return (Criteria) this;
        }

        public Criteria andGen_typeIsNotNull() {
            addCriterion("gen_table.gen_type is not null");
            return (Criteria) this;
        }

        public Criteria andGen_typeEqualTo(String value) {
            addCriterion("gen_table.gen_type =", value, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeNotEqualTo(String value) {
            addCriterion("gen_table.gen_type <>", value, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeGreaterThan(String value) {
            addCriterion("gen_table.gen_type >", value, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.gen_type >=", value, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeLessThan(String value) {
            addCriterion("gen_table.gen_type <", value, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeLessThanOrEqualTo(String value) {
            addCriterion("gen_table.gen_type <=", value, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeLike(String value) {
            addCriterion("gen_table.gen_type like", value, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeNotLike(String value) {
            addCriterion("gen_table.gen_type not like", value, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeIn(List<String> values) {
            addCriterion("gen_table.gen_type in", values, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeNotIn(List<String> values) {
            addCriterion("gen_table.gen_type not in", values, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeBetween(String value1, String value2) {
            addCriterion("gen_table.gen_type between", value1, value2, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_typeNotBetween(String value1, String value2) {
            addCriterion("gen_table.gen_type not between", value1, value2, "gen_type");
            return (Criteria) this;
        }

        public Criteria andGen_pathIsNull() {
            addCriterion("gen_table.gen_path is null");
            return (Criteria) this;
        }

        public Criteria andGen_pathIsNotNull() {
            addCriterion("gen_table.gen_path is not null");
            return (Criteria) this;
        }

        public Criteria andGen_pathEqualTo(String value) {
            addCriterion("gen_table.gen_path =", value, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathNotEqualTo(String value) {
            addCriterion("gen_table.gen_path <>", value, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathGreaterThan(String value) {
            addCriterion("gen_table.gen_path >", value, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.gen_path >=", value, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathLessThan(String value) {
            addCriterion("gen_table.gen_path <", value, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathLessThanOrEqualTo(String value) {
            addCriterion("gen_table.gen_path <=", value, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathLike(String value) {
            addCriterion("gen_table.gen_path like", value, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathNotLike(String value) {
            addCriterion("gen_table.gen_path not like", value, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathIn(List<String> values) {
            addCriterion("gen_table.gen_path in", values, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathNotIn(List<String> values) {
            addCriterion("gen_table.gen_path not in", values, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathBetween(String value1, String value2) {
            addCriterion("gen_table.gen_path between", value1, value2, "gen_path");
            return (Criteria) this;
        }

        public Criteria andGen_pathNotBetween(String value1, String value2) {
            addCriterion("gen_table.gen_path not between", value1, value2, "gen_path");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNull() {
            addCriterion("gen_table.`options` is null");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNotNull() {
            addCriterion("gen_table.`options` is not null");
            return (Criteria) this;
        }

        public Criteria andOptionsEqualTo(String value) {
            addCriterion("gen_table.`options` =", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotEqualTo(String value) {
            addCriterion("gen_table.`options` <>", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThan(String value) {
            addCriterion("gen_table.`options` >", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.`options` >=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThan(String value) {
            addCriterion("gen_table.`options` <", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThanOrEqualTo(String value) {
            addCriterion("gen_table.`options` <=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLike(String value) {
            addCriterion("gen_table.`options` like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotLike(String value) {
            addCriterion("gen_table.`options` not like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsIn(List<String> values) {
            addCriterion("gen_table.`options` in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotIn(List<String> values) {
            addCriterion("gen_table.`options` not in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsBetween(String value1, String value2) {
            addCriterion("gen_table.`options` between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotBetween(String value1, String value2) {
            addCriterion("gen_table.`options` not between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andCreate_byIsNull() {
            addCriterion("gen_table.create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreate_byIsNotNull() {
            addCriterion("gen_table.create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_byEqualTo(String value) {
            addCriterion("gen_table.create_by =", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotEqualTo(String value) {
            addCriterion("gen_table.create_by <>", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byGreaterThan(String value) {
            addCriterion("gen_table.create_by >", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.create_by >=", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLessThan(String value) {
            addCriterion("gen_table.create_by <", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLessThanOrEqualTo(String value) {
            addCriterion("gen_table.create_by <=", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLike(String value) {
            addCriterion("gen_table.create_by like", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotLike(String value) {
            addCriterion("gen_table.create_by not like", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byIn(List<String> values) {
            addCriterion("gen_table.create_by in", values, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotIn(List<String> values) {
            addCriterion("gen_table.create_by not in", values, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byBetween(String value1, String value2) {
            addCriterion("gen_table.create_by between", value1, value2, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotBetween(String value1, String value2) {
            addCriterion("gen_table.create_by not between", value1, value2, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("gen_table.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("gen_table.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(LocalDateTime value) {
            addCriterion("gen_table.create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(LocalDateTime value) {
            addCriterion("gen_table.create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(LocalDateTime value) {
            addCriterion("gen_table.create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("gen_table.create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(LocalDateTime value) {
            addCriterion("gen_table.create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("gen_table.create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<LocalDateTime> values) {
            addCriterion("gen_table.create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<LocalDateTime> values) {
            addCriterion("gen_table.create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("gen_table.create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("gen_table.create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_byIsNull() {
            addCriterion("gen_table.update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_byIsNotNull() {
            addCriterion("gen_table.update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_byEqualTo(String value) {
            addCriterion("gen_table.update_by =", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotEqualTo(String value) {
            addCriterion("gen_table.update_by <>", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byGreaterThan(String value) {
            addCriterion("gen_table.update_by >", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.update_by >=", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byLessThan(String value) {
            addCriterion("gen_table.update_by <", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byLessThanOrEqualTo(String value) {
            addCriterion("gen_table.update_by <=", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byLike(String value) {
            addCriterion("gen_table.update_by like", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotLike(String value) {
            addCriterion("gen_table.update_by not like", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byIn(List<String> values) {
            addCriterion("gen_table.update_by in", values, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotIn(List<String> values) {
            addCriterion("gen_table.update_by not in", values, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byBetween(String value1, String value2) {
            addCriterion("gen_table.update_by between", value1, value2, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotBetween(String value1, String value2) {
            addCriterion("gen_table.update_by not between", value1, value2, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("gen_table.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("gen_table.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(LocalDateTime value) {
            addCriterion("gen_table.update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(LocalDateTime value) {
            addCriterion("gen_table.update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(LocalDateTime value) {
            addCriterion("gen_table.update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("gen_table.update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(LocalDateTime value) {
            addCriterion("gen_table.update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("gen_table.update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<LocalDateTime> values) {
            addCriterion("gen_table.update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<LocalDateTime> values) {
            addCriterion("gen_table.update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("gen_table.update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("gen_table.update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("gen_table.remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("gen_table.remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("gen_table.remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("gen_table.remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("gen_table.remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table.remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("gen_table.remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("gen_table.remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("gen_table.remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("gen_table.remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("gen_table.remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("gen_table.remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("gen_table.remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("gen_table.remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     */
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
