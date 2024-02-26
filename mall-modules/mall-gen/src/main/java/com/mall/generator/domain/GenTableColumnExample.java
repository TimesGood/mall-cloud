package com.mall.generator.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenTableColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public GenTableColumnExample() {
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

        public Criteria andColumn_idIsNull() {
            addCriterion("gen_table_column.column_id is null");
            return (Criteria) this;
        }

        public Criteria andColumn_idIsNotNull() {
            addCriterion("gen_table_column.column_id is not null");
            return (Criteria) this;
        }

        public Criteria andColumn_idEqualTo(Long value) {
            addCriterion("gen_table_column.column_id =", value, "column_id");
            return (Criteria) this;
        }

        public Criteria andColumn_idNotEqualTo(Long value) {
            addCriterion("gen_table_column.column_id <>", value, "column_id");
            return (Criteria) this;
        }

        public Criteria andColumn_idGreaterThan(Long value) {
            addCriterion("gen_table_column.column_id >", value, "column_id");
            return (Criteria) this;
        }

        public Criteria andColumn_idGreaterThanOrEqualTo(Long value) {
            addCriterion("gen_table_column.column_id >=", value, "column_id");
            return (Criteria) this;
        }

        public Criteria andColumn_idLessThan(Long value) {
            addCriterion("gen_table_column.column_id <", value, "column_id");
            return (Criteria) this;
        }

        public Criteria andColumn_idLessThanOrEqualTo(Long value) {
            addCriterion("gen_table_column.column_id <=", value, "column_id");
            return (Criteria) this;
        }

        public Criteria andColumn_idIn(List<Long> values) {
            addCriterion("gen_table_column.column_id in", values, "column_id");
            return (Criteria) this;
        }

        public Criteria andColumn_idNotIn(List<Long> values) {
            addCriterion("gen_table_column.column_id not in", values, "column_id");
            return (Criteria) this;
        }

        public Criteria andColumn_idBetween(Long value1, Long value2) {
            addCriterion("gen_table_column.column_id between", value1, value2, "column_id");
            return (Criteria) this;
        }

        public Criteria andColumn_idNotBetween(Long value1, Long value2) {
            addCriterion("gen_table_column.column_id not between", value1, value2, "column_id");
            return (Criteria) this;
        }

        public Criteria andTable_idIsNull() {
            addCriterion("gen_table_column.table_id is null");
            return (Criteria) this;
        }

        public Criteria andTable_idIsNotNull() {
            addCriterion("gen_table_column.table_id is not null");
            return (Criteria) this;
        }

        public Criteria andTable_idEqualTo(Long value) {
            addCriterion("gen_table_column.table_id =", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idNotEqualTo(Long value) {
            addCriterion("gen_table_column.table_id <>", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idGreaterThan(Long value) {
            addCriterion("gen_table_column.table_id >", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idGreaterThanOrEqualTo(Long value) {
            addCriterion("gen_table_column.table_id >=", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idLessThan(Long value) {
            addCriterion("gen_table_column.table_id <", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idLessThanOrEqualTo(Long value) {
            addCriterion("gen_table_column.table_id <=", value, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idIn(List<Long> values) {
            addCriterion("gen_table_column.table_id in", values, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idNotIn(List<Long> values) {
            addCriterion("gen_table_column.table_id not in", values, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idBetween(Long value1, Long value2) {
            addCriterion("gen_table_column.table_id between", value1, value2, "table_id");
            return (Criteria) this;
        }

        public Criteria andTable_idNotBetween(Long value1, Long value2) {
            addCriterion("gen_table_column.table_id not between", value1, value2, "table_id");
            return (Criteria) this;
        }

        public Criteria andColumn_nameIsNull() {
            addCriterion("gen_table_column.`column_name` is null");
            return (Criteria) this;
        }

        public Criteria andColumn_nameIsNotNull() {
            addCriterion("gen_table_column.`column_name` is not null");
            return (Criteria) this;
        }

        public Criteria andColumn_nameEqualTo(String value) {
            addCriterion("gen_table_column.`column_name` =", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameNotEqualTo(String value) {
            addCriterion("gen_table_column.`column_name` <>", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameGreaterThan(String value) {
            addCriterion("gen_table_column.`column_name` >", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.`column_name` >=", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameLessThan(String value) {
            addCriterion("gen_table_column.`column_name` <", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.`column_name` <=", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameLike(String value) {
            addCriterion("gen_table_column.`column_name` like", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameNotLike(String value) {
            addCriterion("gen_table_column.`column_name` not like", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameIn(List<String> values) {
            addCriterion("gen_table_column.`column_name` in", values, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameNotIn(List<String> values) {
            addCriterion("gen_table_column.`column_name` not in", values, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameBetween(String value1, String value2) {
            addCriterion("gen_table_column.`column_name` between", value1, value2, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.`column_name` not between", value1, value2, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_commentIsNull() {
            addCriterion("gen_table_column.column_comment is null");
            return (Criteria) this;
        }

        public Criteria andColumn_commentIsNotNull() {
            addCriterion("gen_table_column.column_comment is not null");
            return (Criteria) this;
        }

        public Criteria andColumn_commentEqualTo(String value) {
            addCriterion("gen_table_column.column_comment =", value, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentNotEqualTo(String value) {
            addCriterion("gen_table_column.column_comment <>", value, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentGreaterThan(String value) {
            addCriterion("gen_table_column.column_comment >", value, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.column_comment >=", value, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentLessThan(String value) {
            addCriterion("gen_table_column.column_comment <", value, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.column_comment <=", value, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentLike(String value) {
            addCriterion("gen_table_column.column_comment like", value, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentNotLike(String value) {
            addCriterion("gen_table_column.column_comment not like", value, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentIn(List<String> values) {
            addCriterion("gen_table_column.column_comment in", values, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentNotIn(List<String> values) {
            addCriterion("gen_table_column.column_comment not in", values, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentBetween(String value1, String value2) {
            addCriterion("gen_table_column.column_comment between", value1, value2, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_commentNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.column_comment not between", value1, value2, "column_comment");
            return (Criteria) this;
        }

        public Criteria andColumn_typeIsNull() {
            addCriterion("gen_table_column.column_type is null");
            return (Criteria) this;
        }

        public Criteria andColumn_typeIsNotNull() {
            addCriterion("gen_table_column.column_type is not null");
            return (Criteria) this;
        }

        public Criteria andColumn_typeEqualTo(String value) {
            addCriterion("gen_table_column.column_type =", value, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeNotEqualTo(String value) {
            addCriterion("gen_table_column.column_type <>", value, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeGreaterThan(String value) {
            addCriterion("gen_table_column.column_type >", value, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.column_type >=", value, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeLessThan(String value) {
            addCriterion("gen_table_column.column_type <", value, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.column_type <=", value, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeLike(String value) {
            addCriterion("gen_table_column.column_type like", value, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeNotLike(String value) {
            addCriterion("gen_table_column.column_type not like", value, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeIn(List<String> values) {
            addCriterion("gen_table_column.column_type in", values, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeNotIn(List<String> values) {
            addCriterion("gen_table_column.column_type not in", values, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeBetween(String value1, String value2) {
            addCriterion("gen_table_column.column_type between", value1, value2, "column_type");
            return (Criteria) this;
        }

        public Criteria andColumn_typeNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.column_type not between", value1, value2, "column_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeIsNull() {
            addCriterion("gen_table_column.java_type is null");
            return (Criteria) this;
        }

        public Criteria andJava_typeIsNotNull() {
            addCriterion("gen_table_column.java_type is not null");
            return (Criteria) this;
        }

        public Criteria andJava_typeEqualTo(String value) {
            addCriterion("gen_table_column.java_type =", value, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeNotEqualTo(String value) {
            addCriterion("gen_table_column.java_type <>", value, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeGreaterThan(String value) {
            addCriterion("gen_table_column.java_type >", value, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.java_type >=", value, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeLessThan(String value) {
            addCriterion("gen_table_column.java_type <", value, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.java_type <=", value, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeLike(String value) {
            addCriterion("gen_table_column.java_type like", value, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeNotLike(String value) {
            addCriterion("gen_table_column.java_type not like", value, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeIn(List<String> values) {
            addCriterion("gen_table_column.java_type in", values, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeNotIn(List<String> values) {
            addCriterion("gen_table_column.java_type not in", values, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeBetween(String value1, String value2) {
            addCriterion("gen_table_column.java_type between", value1, value2, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_typeNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.java_type not between", value1, value2, "java_type");
            return (Criteria) this;
        }

        public Criteria andJava_fieldIsNull() {
            addCriterion("gen_table_column.java_field is null");
            return (Criteria) this;
        }

        public Criteria andJava_fieldIsNotNull() {
            addCriterion("gen_table_column.java_field is not null");
            return (Criteria) this;
        }

        public Criteria andJava_fieldEqualTo(String value) {
            addCriterion("gen_table_column.java_field =", value, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldNotEqualTo(String value) {
            addCriterion("gen_table_column.java_field <>", value, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldGreaterThan(String value) {
            addCriterion("gen_table_column.java_field >", value, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.java_field >=", value, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldLessThan(String value) {
            addCriterion("gen_table_column.java_field <", value, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.java_field <=", value, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldLike(String value) {
            addCriterion("gen_table_column.java_field like", value, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldNotLike(String value) {
            addCriterion("gen_table_column.java_field not like", value, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldIn(List<String> values) {
            addCriterion("gen_table_column.java_field in", values, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldNotIn(List<String> values) {
            addCriterion("gen_table_column.java_field not in", values, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldBetween(String value1, String value2) {
            addCriterion("gen_table_column.java_field between", value1, value2, "java_field");
            return (Criteria) this;
        }

        public Criteria andJava_fieldNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.java_field not between", value1, value2, "java_field");
            return (Criteria) this;
        }

        public Criteria andIs_pkIsNull() {
            addCriterion("gen_table_column.is_pk is null");
            return (Criteria) this;
        }

        public Criteria andIs_pkIsNotNull() {
            addCriterion("gen_table_column.is_pk is not null");
            return (Criteria) this;
        }

        public Criteria andIs_pkEqualTo(String value) {
            addCriterion("gen_table_column.is_pk =", value, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkNotEqualTo(String value) {
            addCriterion("gen_table_column.is_pk <>", value, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkGreaterThan(String value) {
            addCriterion("gen_table_column.is_pk >", value, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_pk >=", value, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkLessThan(String value) {
            addCriterion("gen_table_column.is_pk <", value, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_pk <=", value, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkLike(String value) {
            addCriterion("gen_table_column.is_pk like", value, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkNotLike(String value) {
            addCriterion("gen_table_column.is_pk not like", value, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkIn(List<String> values) {
            addCriterion("gen_table_column.is_pk in", values, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkNotIn(List<String> values) {
            addCriterion("gen_table_column.is_pk not in", values, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_pk between", value1, value2, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_pkNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_pk not between", value1, value2, "is_pk");
            return (Criteria) this;
        }

        public Criteria andIs_incrementIsNull() {
            addCriterion("gen_table_column.is_increment is null");
            return (Criteria) this;
        }

        public Criteria andIs_incrementIsNotNull() {
            addCriterion("gen_table_column.is_increment is not null");
            return (Criteria) this;
        }

        public Criteria andIs_incrementEqualTo(String value) {
            addCriterion("gen_table_column.is_increment =", value, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementNotEqualTo(String value) {
            addCriterion("gen_table_column.is_increment <>", value, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementGreaterThan(String value) {
            addCriterion("gen_table_column.is_increment >", value, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_increment >=", value, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementLessThan(String value) {
            addCriterion("gen_table_column.is_increment <", value, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_increment <=", value, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementLike(String value) {
            addCriterion("gen_table_column.is_increment like", value, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementNotLike(String value) {
            addCriterion("gen_table_column.is_increment not like", value, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementIn(List<String> values) {
            addCriterion("gen_table_column.is_increment in", values, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementNotIn(List<String> values) {
            addCriterion("gen_table_column.is_increment not in", values, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_increment between", value1, value2, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_incrementNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_increment not between", value1, value2, "is_increment");
            return (Criteria) this;
        }

        public Criteria andIs_requiredIsNull() {
            addCriterion("gen_table_column.is_required is null");
            return (Criteria) this;
        }

        public Criteria andIs_requiredIsNotNull() {
            addCriterion("gen_table_column.is_required is not null");
            return (Criteria) this;
        }

        public Criteria andIs_requiredEqualTo(String value) {
            addCriterion("gen_table_column.is_required =", value, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredNotEqualTo(String value) {
            addCriterion("gen_table_column.is_required <>", value, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredGreaterThan(String value) {
            addCriterion("gen_table_column.is_required >", value, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_required >=", value, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredLessThan(String value) {
            addCriterion("gen_table_column.is_required <", value, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_required <=", value, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredLike(String value) {
            addCriterion("gen_table_column.is_required like", value, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredNotLike(String value) {
            addCriterion("gen_table_column.is_required not like", value, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredIn(List<String> values) {
            addCriterion("gen_table_column.is_required in", values, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredNotIn(List<String> values) {
            addCriterion("gen_table_column.is_required not in", values, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_required between", value1, value2, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_requiredNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_required not between", value1, value2, "is_required");
            return (Criteria) this;
        }

        public Criteria andIs_insertIsNull() {
            addCriterion("gen_table_column.is_insert is null");
            return (Criteria) this;
        }

        public Criteria andIs_insertIsNotNull() {
            addCriterion("gen_table_column.is_insert is not null");
            return (Criteria) this;
        }

        public Criteria andIs_insertEqualTo(String value) {
            addCriterion("gen_table_column.is_insert =", value, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertNotEqualTo(String value) {
            addCriterion("gen_table_column.is_insert <>", value, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertGreaterThan(String value) {
            addCriterion("gen_table_column.is_insert >", value, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_insert >=", value, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertLessThan(String value) {
            addCriterion("gen_table_column.is_insert <", value, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_insert <=", value, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertLike(String value) {
            addCriterion("gen_table_column.is_insert like", value, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertNotLike(String value) {
            addCriterion("gen_table_column.is_insert not like", value, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertIn(List<String> values) {
            addCriterion("gen_table_column.is_insert in", values, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertNotIn(List<String> values) {
            addCriterion("gen_table_column.is_insert not in", values, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_insert between", value1, value2, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_insertNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_insert not between", value1, value2, "is_insert");
            return (Criteria) this;
        }

        public Criteria andIs_editIsNull() {
            addCriterion("gen_table_column.is_edit is null");
            return (Criteria) this;
        }

        public Criteria andIs_editIsNotNull() {
            addCriterion("gen_table_column.is_edit is not null");
            return (Criteria) this;
        }

        public Criteria andIs_editEqualTo(String value) {
            addCriterion("gen_table_column.is_edit =", value, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editNotEqualTo(String value) {
            addCriterion("gen_table_column.is_edit <>", value, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editGreaterThan(String value) {
            addCriterion("gen_table_column.is_edit >", value, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_edit >=", value, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editLessThan(String value) {
            addCriterion("gen_table_column.is_edit <", value, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_edit <=", value, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editLike(String value) {
            addCriterion("gen_table_column.is_edit like", value, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editNotLike(String value) {
            addCriterion("gen_table_column.is_edit not like", value, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editIn(List<String> values) {
            addCriterion("gen_table_column.is_edit in", values, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editNotIn(List<String> values) {
            addCriterion("gen_table_column.is_edit not in", values, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_edit between", value1, value2, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_editNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_edit not between", value1, value2, "is_edit");
            return (Criteria) this;
        }

        public Criteria andIs_listIsNull() {
            addCriterion("gen_table_column.is_list is null");
            return (Criteria) this;
        }

        public Criteria andIs_listIsNotNull() {
            addCriterion("gen_table_column.is_list is not null");
            return (Criteria) this;
        }

        public Criteria andIs_listEqualTo(String value) {
            addCriterion("gen_table_column.is_list =", value, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listNotEqualTo(String value) {
            addCriterion("gen_table_column.is_list <>", value, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listGreaterThan(String value) {
            addCriterion("gen_table_column.is_list >", value, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_list >=", value, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listLessThan(String value) {
            addCriterion("gen_table_column.is_list <", value, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_list <=", value, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listLike(String value) {
            addCriterion("gen_table_column.is_list like", value, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listNotLike(String value) {
            addCriterion("gen_table_column.is_list not like", value, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listIn(List<String> values) {
            addCriterion("gen_table_column.is_list in", values, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listNotIn(List<String> values) {
            addCriterion("gen_table_column.is_list not in", values, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_list between", value1, value2, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_listNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_list not between", value1, value2, "is_list");
            return (Criteria) this;
        }

        public Criteria andIs_queryIsNull() {
            addCriterion("gen_table_column.is_query is null");
            return (Criteria) this;
        }

        public Criteria andIs_queryIsNotNull() {
            addCriterion("gen_table_column.is_query is not null");
            return (Criteria) this;
        }

        public Criteria andIs_queryEqualTo(String value) {
            addCriterion("gen_table_column.is_query =", value, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryNotEqualTo(String value) {
            addCriterion("gen_table_column.is_query <>", value, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryGreaterThan(String value) {
            addCriterion("gen_table_column.is_query >", value, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_query >=", value, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryLessThan(String value) {
            addCriterion("gen_table_column.is_query <", value, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.is_query <=", value, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryLike(String value) {
            addCriterion("gen_table_column.is_query like", value, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryNotLike(String value) {
            addCriterion("gen_table_column.is_query not like", value, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryIn(List<String> values) {
            addCriterion("gen_table_column.is_query in", values, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryNotIn(List<String> values) {
            addCriterion("gen_table_column.is_query not in", values, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_query between", value1, value2, "is_query");
            return (Criteria) this;
        }

        public Criteria andIs_queryNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.is_query not between", value1, value2, "is_query");
            return (Criteria) this;
        }

        public Criteria andQuery_typeIsNull() {
            addCriterion("gen_table_column.query_type is null");
            return (Criteria) this;
        }

        public Criteria andQuery_typeIsNotNull() {
            addCriterion("gen_table_column.query_type is not null");
            return (Criteria) this;
        }

        public Criteria andQuery_typeEqualTo(String value) {
            addCriterion("gen_table_column.query_type =", value, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeNotEqualTo(String value) {
            addCriterion("gen_table_column.query_type <>", value, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeGreaterThan(String value) {
            addCriterion("gen_table_column.query_type >", value, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.query_type >=", value, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeLessThan(String value) {
            addCriterion("gen_table_column.query_type <", value, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.query_type <=", value, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeLike(String value) {
            addCriterion("gen_table_column.query_type like", value, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeNotLike(String value) {
            addCriterion("gen_table_column.query_type not like", value, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeIn(List<String> values) {
            addCriterion("gen_table_column.query_type in", values, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeNotIn(List<String> values) {
            addCriterion("gen_table_column.query_type not in", values, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeBetween(String value1, String value2) {
            addCriterion("gen_table_column.query_type between", value1, value2, "query_type");
            return (Criteria) this;
        }

        public Criteria andQuery_typeNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.query_type not between", value1, value2, "query_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeIsNull() {
            addCriterion("gen_table_column.html_type is null");
            return (Criteria) this;
        }

        public Criteria andHtml_typeIsNotNull() {
            addCriterion("gen_table_column.html_type is not null");
            return (Criteria) this;
        }

        public Criteria andHtml_typeEqualTo(String value) {
            addCriterion("gen_table_column.html_type =", value, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeNotEqualTo(String value) {
            addCriterion("gen_table_column.html_type <>", value, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeGreaterThan(String value) {
            addCriterion("gen_table_column.html_type >", value, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.html_type >=", value, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeLessThan(String value) {
            addCriterion("gen_table_column.html_type <", value, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.html_type <=", value, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeLike(String value) {
            addCriterion("gen_table_column.html_type like", value, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeNotLike(String value) {
            addCriterion("gen_table_column.html_type not like", value, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeIn(List<String> values) {
            addCriterion("gen_table_column.html_type in", values, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeNotIn(List<String> values) {
            addCriterion("gen_table_column.html_type not in", values, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeBetween(String value1, String value2) {
            addCriterion("gen_table_column.html_type between", value1, value2, "html_type");
            return (Criteria) this;
        }

        public Criteria andHtml_typeNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.html_type not between", value1, value2, "html_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeIsNull() {
            addCriterion("gen_table_column.dict_type is null");
            return (Criteria) this;
        }

        public Criteria andDict_typeIsNotNull() {
            addCriterion("gen_table_column.dict_type is not null");
            return (Criteria) this;
        }

        public Criteria andDict_typeEqualTo(String value) {
            addCriterion("gen_table_column.dict_type =", value, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeNotEqualTo(String value) {
            addCriterion("gen_table_column.dict_type <>", value, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeGreaterThan(String value) {
            addCriterion("gen_table_column.dict_type >", value, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.dict_type >=", value, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeLessThan(String value) {
            addCriterion("gen_table_column.dict_type <", value, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.dict_type <=", value, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeLike(String value) {
            addCriterion("gen_table_column.dict_type like", value, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeNotLike(String value) {
            addCriterion("gen_table_column.dict_type not like", value, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeIn(List<String> values) {
            addCriterion("gen_table_column.dict_type in", values, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeNotIn(List<String> values) {
            addCriterion("gen_table_column.dict_type not in", values, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeBetween(String value1, String value2) {
            addCriterion("gen_table_column.dict_type between", value1, value2, "dict_type");
            return (Criteria) this;
        }

        public Criteria andDict_typeNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.dict_type not between", value1, value2, "dict_type");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("gen_table_column.sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("gen_table_column.sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("gen_table_column.sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("gen_table_column.sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("gen_table_column.sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("gen_table_column.sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("gen_table_column.sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("gen_table_column.sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("gen_table_column.sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("gen_table_column.sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("gen_table_column.sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("gen_table_column.sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andCreate_byIsNull() {
            addCriterion("gen_table_column.create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreate_byIsNotNull() {
            addCriterion("gen_table_column.create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_byEqualTo(String value) {
            addCriterion("gen_table_column.create_by =", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotEqualTo(String value) {
            addCriterion("gen_table_column.create_by <>", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byGreaterThan(String value) {
            addCriterion("gen_table_column.create_by >", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.create_by >=", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLessThan(String value) {
            addCriterion("gen_table_column.create_by <", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.create_by <=", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLike(String value) {
            addCriterion("gen_table_column.create_by like", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotLike(String value) {
            addCriterion("gen_table_column.create_by not like", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byIn(List<String> values) {
            addCriterion("gen_table_column.create_by in", values, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotIn(List<String> values) {
            addCriterion("gen_table_column.create_by not in", values, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byBetween(String value1, String value2) {
            addCriterion("gen_table_column.create_by between", value1, value2, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.create_by not between", value1, value2, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("gen_table_column.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("gen_table_column.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(LocalDateTime value) {
            addCriterion("gen_table_column.create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(LocalDateTime value) {
            addCriterion("gen_table_column.create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(LocalDateTime value) {
            addCriterion("gen_table_column.create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("gen_table_column.create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(LocalDateTime value) {
            addCriterion("gen_table_column.create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("gen_table_column.create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<LocalDateTime> values) {
            addCriterion("gen_table_column.create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<LocalDateTime> values) {
            addCriterion("gen_table_column.create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("gen_table_column.create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("gen_table_column.create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_byIsNull() {
            addCriterion("gen_table_column.update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_byIsNotNull() {
            addCriterion("gen_table_column.update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_byEqualTo(String value) {
            addCriterion("gen_table_column.update_by =", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotEqualTo(String value) {
            addCriterion("gen_table_column.update_by <>", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byGreaterThan(String value) {
            addCriterion("gen_table_column.update_by >", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_column.update_by >=", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byLessThan(String value) {
            addCriterion("gen_table_column.update_by <", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byLessThanOrEqualTo(String value) {
            addCriterion("gen_table_column.update_by <=", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byLike(String value) {
            addCriterion("gen_table_column.update_by like", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotLike(String value) {
            addCriterion("gen_table_column.update_by not like", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byIn(List<String> values) {
            addCriterion("gen_table_column.update_by in", values, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotIn(List<String> values) {
            addCriterion("gen_table_column.update_by not in", values, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byBetween(String value1, String value2) {
            addCriterion("gen_table_column.update_by between", value1, value2, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotBetween(String value1, String value2) {
            addCriterion("gen_table_column.update_by not between", value1, value2, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("gen_table_column.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("gen_table_column.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(LocalDateTime value) {
            addCriterion("gen_table_column.update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(LocalDateTime value) {
            addCriterion("gen_table_column.update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(LocalDateTime value) {
            addCriterion("gen_table_column.update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("gen_table_column.update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(LocalDateTime value) {
            addCriterion("gen_table_column.update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("gen_table_column.update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<LocalDateTime> values) {
            addCriterion("gen_table_column.update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<LocalDateTime> values) {
            addCriterion("gen_table_column.update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("gen_table_column.update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("gen_table_column.update_time not between", value1, value2, "update_time");
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
