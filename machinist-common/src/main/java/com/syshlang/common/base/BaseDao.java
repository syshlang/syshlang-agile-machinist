/*
 * Copyright (c) 2018. syshlang
 * @File: BaseDao.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-18 下午11:14
 * @since:
 */

package com.syshlang.common.base;


import java.io.Serializable;
import java.util.List;



/**
 *  Dao层基础接口定义，只提供接口，不关心持久层的实现
 * @author sunys
 */
public interface BaseDao<B extends BaseModel, PK extends Serializable> {

    /**
     * 根据条件查询记录数量
     * @param baseModel
     * @return
     */
    int countByExample(B baseModel);

    /**
     * 根据条件删除记录
     * @param baseModel
     * @return
     */
    int deleteByExample(B baseModel);

    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入记录
     * @param baseModel
     * @return
     */
    int insert(B baseModel);

    /**
     * 插入记录有效字段
     * @param baseModel
     * @return
     */
    int insertSelective(B baseModel);

    /**
     * 根据条件查询记录，附带BLOB字段
     * @param baseModel
     * @return
     */
    List<B> selectByExampleWithBLOBs(B baseModel);

    /**
     * 根据条件查询记录
     * @param baseModel
     * @return
     */
    List<B> selectByExample(B baseModel);

    /**
     * 根据条件查询记录并按页码分页，附带BLOB字段
     * @param baseModel 条件
     * @param pageNum 页数
     * @param pageSize 每页记录数
     * @return
     */
    List<B> selectByExampleWithBLOBsForStartPage(B baseModel, Integer pageNum, Integer pageSize);

    /**
     * 根据条件查询记录并按页码分页
     * @param baseModel 条件
     * @param pageNum 页数
     * @param pageSize 每页记录数
     * @return
     */
    List<B> selectByExampleForStartPage(B baseModel, Integer pageNum, Integer pageSize);

    /**
     * 根据条件查询记录并按最后记录数分页，附带BLOB字段
     * @param baseModel 条件
     * @param offset 跳过数量
     * @param limit 查询数量
     * @return
     */
    List<B> selectByExampleWithBLOBsForOffsetPage(B baseModel, Integer offset, Integer limit);

    /**
     * 根据条件查询记录并按最后记录数分页
     * @param baseModel 条件
     * @param offset 跳过数量
     * @param limit 查询数量
     * @return
     */
    List<B> selectByExampleForOffsetPage(B baseModel, Integer offset, Integer limit);

    /**
     * 根据条件查询第一条记录
     * @param baseModele
     * @return
     */
    B selectFirstByExample(B baseModele);

    /**
     * 根据条件查询第一条记录，附带BLOB字段
     * @param baseModel
     * @return
     */
    B selectFirstByExampleWithBLOBs(B baseModel);

    /**
     * 根据主键查询记录
     * @param id
     * @return
     */
    BaseModel selectByPrimaryKey(Integer id);

    /**
     * 根据条件更新有效字段
     * @param baseModel
     * @param id
     * @return
     */
    int updateByExampleSelective(B baseModel,Integer id);

    /**
     * 根据条件更新记录有效字段，附带BLOB字段
     * @param baseModel
     * @param id
     * @return
     */
    int updateByExampleWithBLOBs(B baseModel,Integer id);

    /**
     * 根据条件更新记录
     * @param baseModel
     * @param id
     * @return
     */
    int updateByExample(B baseModel,Integer id);

    /**
     * 根据主键更新记录有效字段
     * @param baseModel
     * @return
     */
    int updateByPrimaryKeySelective(B baseModel);

    /**
     * 根据主键更新记录，附带BLOB字段
     * @param baseModel
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(B baseModel);

    /**
     * 根据主键更新记录
     * @param baseModel
     * @return
     */
    int updateByPrimaryKey(B baseModel);

    /**
     * 根据主键批量删除记录
     * @param ids
     * @return
     */
    int deleteByPrimaryKeys(String ids);
}
