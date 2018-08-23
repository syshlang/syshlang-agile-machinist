/*
 * Copyright (c) 2018. syshlang
 * @File: BaseService.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-18 下午10:34
 * @since:
 */

package com.syshlang.common.base;


import java.io.Serializable;
import java.util.List;


/**
 * @author sunys
 */
public interface BaseService<M extends BaseModel, PK extends Serializable> {
    /**
     * 根据条件查询记录数量
     * @param baseModel
     * @return
     */
    int countByExample(M baseModel);

    /**
     * 根据条件删除记录
     * @param baseModel
     * @return
     */
    int deleteByExample(M baseModel);

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
    int insert(M baseModel);

    /**
     * 插入记录有效字段
     * @param baseModel
     * @return
     */
    int insertSelective(M baseModel);

    /**
     * 根据条件查询记录，附带BLOB字段
     * @param baseModel
     * @return
     */
    List<M> selectByExampleWithBLOBs(M baseModel);

    /**
     * 根据条件查询记录
     * @param baseModel
     * @return
     */
    List<M> selectByExample(M baseModel);

    /**
     * 根据条件查询记录并按页码分页，附带BLOB字段
     * @param baseModel 条件
     * @param pageNum 页数
     * @param pageSize 每页记录数
     * @return
     */
    List<M> selectByExampleWithBLOBsForStartPage(M baseModel, Integer pageNum, Integer pageSize);

    /**
     * 根据条件查询记录并按页码分页
     * @param baseModel 条件
     * @param pageNum 页数
     * @param pageSize 每页记录数
     * @return
     */
    List<M> selectByExampleForStartPage(M baseModel, Integer pageNum, Integer pageSize);

    /**
     * 根据条件查询记录并按最后记录数分页，附带BLOB字段
     * @param baseModel 条件
     * @param offset 跳过数量
     * @param limit 查询数量
     * @return
     */
    List<M> selectByExampleWithBLOBsForOffsetPage(M baseModel, Integer offset, Integer limit);

    /**
     * 根据条件查询记录并按最后记录数分页
     * @param baseModel 条件
     * @param offset 跳过数量
     * @param limit 查询数量
     * @return
     */
    List<M> selectByExampleForOffsetPage(M baseModel, Integer offset, Integer limit);

    /**
     * 根据条件查询第一条记录
     * @param baseModele
     * @return
     */
    M selectFirstByExample(M baseModele);

    /**
     * 根据条件查询第一条记录，附带BLOB字段
     * @param baseModel
     * @return
     */
    M selectFirstByExampleWithBLOBs(M baseModel);

    /**
     * 根据主键查询记录
     * @param id
     * @return
     */
    M selectByPrimaryKey(Integer id);

    /**
     * 根据条件更新有效字段
     * @param baseModel
     * @param id
     * @return
     */
    int updateByExampleSelective(M baseModel, Integer id);

    /**
     * 根据条件更新记录有效字段，附带BLOB字段
     * @param baseModel
     * @param id
     * @return
     */
    int updateByExampleWithBLOBs(M baseModel,Integer id);

    /**
     * 根据条件更新记录
     * @param baseModel
     * @param id
     * @return
     */
    int updateByExample(M baseModel,Integer id);

    /**
     * 根据主键更新记录有效字段
     * @param baseModel
     * @return
     */
    int updateByPrimaryKeySelective(M baseModel);

    /**
     * 根据主键更新记录，附带BLOB字段
     * @param baseModel
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(M baseModel);

    /**
     * 根据主键更新记录
     * @param baseModel
     * @return
     */
    int updateByPrimaryKey(M baseModel);

    /**
     * 根据主键批量删除记录
     * @param ids
     * @return
     */
    int deleteByPrimaryKeys(String ids);

    /**
     * 初始化mapper
     */
    void initMapper();

}
