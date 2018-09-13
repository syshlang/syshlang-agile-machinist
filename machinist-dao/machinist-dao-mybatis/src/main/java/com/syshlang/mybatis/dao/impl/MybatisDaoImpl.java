/*
 * Copyright (c) 2018. syshlang
 * @File: MybatisDaoImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午12:53
 * @since:
 */

package com.syshlang.mybatis.dao.impl;

import com.syshlang.common.base.BaseDaoImpl;
import com.syshlang.common.base.BaseModel;
import com.syshlang.mybatis.dao.MybatisDao;
import com.syshlang.mybatis.mapper.MybatisMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * 使用mybatis实现持久层
 * @author sunys
 */
public abstract class MybatisDaoImpl<M extends MybatisMapper, U extends BaseModel, I extends Serializable> extends BaseDaoImpl<U,I> implements MybatisDao<U,I> {

    @Autowired
    private M mybatisMapper;

    @Override
    public int selectCount(U baseModel) {
        return mybatisMapper.selectCount(baseModel);
    }

    @Override
    public int countByExample(U baseModel) {
        return 0;
    }

    @Override
    public int deleteByExample(U baseModel) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(U baseModel) {
        return mybatisMapper.deleteByPrimaryKey(baseModel);
    }

    @Override
    public int insert(U baseModel) {
        return mybatisMapper.insert(baseModel);
    }

    @Override
    public int insertSelective(U baseModel) {
        return 0;
    }

    @Override
    public List<U> selectByExampleWithBLOBs(U baseModel) {
        return null;
    }

    @Override
    public List<U> selectByExample(U baseModel) {
        return null;
    }

    @Override
    public List<U> selectByExampleWithBLOBsForStartPage(U baseModel, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<U> selectByExampleForStartPage(U baseModel, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<U> selectByExampleWithBLOBsForOffsetPage(U baseModel, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public List<U> selectByExampleForOffsetPage(U baseModel, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public U selectFirstByExample(U baseModele) {
        return null;
    }

    @Override
    public U selectFirstByExampleWithBLOBs(U baseModel) {
        return null;
    }

    @Override
    public BaseModel selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(U baseModel, Integer id) {
        return 0;
    }

    @Override
    public int updateByExampleWithBLOBs(U baseModel, Integer id) {
        return 0;
    }

    @Override
    public int updateByExample(U baseModel, Integer id) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(U baseModel) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(U baseModel) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(U baseModel) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(String ids) {
        return 0;
    }

    @Override
    public void testMybatisDao(U baseModel) {
        System.out.println("Test:U:"+baseModel);
    }
}
