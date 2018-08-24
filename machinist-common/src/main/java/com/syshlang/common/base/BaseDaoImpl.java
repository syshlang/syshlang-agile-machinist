/*
 * Copyright (c) 2018. syshlang
 * @File: BaseDaoImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-18 下午11:35
 * @since:
 */

package com.syshlang.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


public abstract class BaseDaoImpl<M extends BaseMapper, B extends BaseModel, PK extends Serializable> implements BaseDao<B, PK>{
    
    private M baseMapper;

    @Override
    public int countByExample(B baseModel) {
        return 0;
    }

    @Override
    public int deleteByExample(B baseModel) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(B baseModel) {

        return 0;
    }

    @Override
    public int insertSelective(B baseModel) {
        return 0;
    }

    @Override
    public List<B> selectByExampleWithBLOBs(B baseModel) {
        return null;
    }

    @Override
    public List<B> selectByExample(B baseModel) {
        return null;
    }

    @Override
    public List<B> selectByExampleWithBLOBsForStartPage(B baseModel, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<B> selectByExampleForStartPage(B baseModel, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<B> selectByExampleWithBLOBsForOffsetPage(B baseModel, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public List<B> selectByExampleForOffsetPage(B baseModel, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public B selectFirstByExample(B baseModele) {
        return null;
    }

    @Override
    public B selectFirstByExampleWithBLOBs(B baseModel) {
        return null;
    }

    @Override
    public B selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(B baseModel, Integer id) {
        return 0;
    }

    @Override
    public int updateByExampleWithBLOBs(B baseModel, Integer id) {
        return 0;
    }

    @Override
    public int updateByExample(B baseModel, Integer id) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(B baseModel) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(B baseModel) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(B baseModel) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(String ids) {

        return 0;
    }
}
