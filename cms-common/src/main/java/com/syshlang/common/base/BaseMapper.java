/*
 * Copyright (c) 2018. syshlang
 * @File: BaseMapper.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-19 上午6:38
 * @since:
 */

package com.syshlang.common.base;


import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import java.io.Serializable;

/**
 * @author sunys
 */
@RegisterMapper
public interface BaseMapper<T extends BaseModel,PK extends Serializable> extends Mapper<T>, InsertListMapper<T> {
   /*  *//**
     * 根据条件查询记录数量
     * @param baseModel
     * @return
     *//*
    int countByExample(T baseModel);

    *//**
     * 根据条件删除记录
     * @param baseModel
     * @return
     *//*
    int deleteByExample(T baseModel);

    *//**
     * 根据主键删除记录
     * @param id
     * @return
     *//*
    int deleteByPrimaryKey(Integer id);

    *//**
     * 插入记录
     * @param baseModel
     * @return
     *//*
   // int insert(T baseModel);

    *//**
     * 插入记录有效字段
     * @param baseModel
     * @return
     *//*
    //int insertSelective(T baseModel);

    *//**
     * 根据条件查询记录，附带BLOB字段
     * @param baseModel
     * @return
     *//*
    List<T> selectByExampleWithBLOBs(T baseModel);

    *//**
     * 根据条件查询记录
     * @param baseModel
     * @return
     *//*
    List<T> selectByExample(T baseModel);

    *//**
     * 根据条件查询记录并按页码分页，附带BLOB字段
     * @param baseModel 条件
     * @param pageNum 页数
     * @param pageSize 每页记录数
     * @return
     *//*
    List<T> selectByExampleWithBLOBsForStartPage(T baseModel, Integer pageNum, Integer pageSize);

    *//**
     * 根据条件查询记录并按页码分页
     * @param baseModel 条件
     * @param pageNum 页数
     * @param pageSize 每页记录数
     * @return
     *//*
    List<T> selectByExampleForStartPage(T baseModel, Integer pageNum, Integer pageSize);

    *//**
     * 根据条件查询记录并按最后记录数分页，附带BLOB字段
     * @param baseModel 条件
     * @param offset 跳过数量
     * @param limit 查询数量
     * @return
     *//*
    List<T> selectByExampleWithBLOBsForOffsetPage(T baseModel, Integer offset, Integer limit);

    *//**
     * 根据条件查询记录并按最后记录数分页
     * @param baseModel 条件
     * @param offset 跳过数量
     * @param limit 查询数量
     * @return
     *//*
    List<T> selectByExampleForOffsetPage(T baseModel, Integer offset, Integer limit);

    *//**
     * 根据条件查询第一条记录
     * @param baseModele
     * @return
     *//*
    T selectFirstByExample(T baseModele);

    *//**
     * 根据条件查询第一条记录，附带BLOB字段
     * @param baseModel
     * @return
     *//*
    T selectFirstByExampleWithBLOBs(T baseModel);

    *//**
     * 根据主键查询记录
     * @param id
     * @return
     *//*
    T selectByPrimaryKey(Integer id);

    *//**
     * 根据条件更新有效字段
     * @param baseModel
     * @param id
     * @return
     *//*
    int updateByExampleSelective(T baseModel, Integer id);

    *//**
     * 根据条件更新记录有效字段，附带BLOB字段
     * @param baseModel
     * @param id
     * @return
     *//*
    int updateByExampleWithBLOBs(T baseModel,Integer id);

    *//**
     * 根据条件更新记录
     * @param baseModel
     * @param id
     * @return
     *//*
    int updateByExample(T baseModel,Integer id);

    *//**
     * 根据主键更新记录有效字段
     * @param baseModel
     * @return
     *//*
    //int updateByPrimaryKeySelective(T baseModel);

    *//**
     * 根据主键更新记录，附带BLOB字段
     * @param baseModel
     * @return
     *//*
    int updateByPrimaryKeyWithBLOBs(T baseModel);

    *//**
     * 根据主键更新记录
     * @param baseModel
     * @return
     *//*
    //int updateByPrimaryKey(T baseModel);

    *//**
     * 根据主键批量删除记录
     * @param ids
     * @return
     *//*
    int deleteByPrimaryKeys(String ids);*/
}
