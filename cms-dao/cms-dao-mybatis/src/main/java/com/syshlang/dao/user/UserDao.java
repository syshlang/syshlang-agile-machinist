/*
 * Copyright (c) 2018. syshlang
 * @File: UserDao.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-17 上午1:34
 * @since:
 */

package com.syshlang.dao.user;

import com.syshlang.common.base.BaseException;
import com.syshlang.common.model.user.User;
import com.syshlang.mapper.user.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    private static final Logger log = Logger.getLogger(UserDao.class);

    @Autowired
    private UserMapper userMapper;

    public int insert(User t) {
        try{
            return userMapper.insert_test(t);
        }catch(DataAccessException e){
            log.error(e.getMessage());
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        } catch(Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

    public List<User> selectall(){
        try{
            return userMapper.selectAll();
        }catch(DataAccessException e){
            throw new BaseException(e.getMessage());
        } catch(Exception e){
            throw new BaseException(e.getMessage());
        }
    }

    public List<User> selecttest(Map map){
        try{
            return userMapper.select_test(map);
        }catch(DataAccessException e){
            log.error("error", e);
            throw new BaseException(e.getMessage());
        } catch(Exception e){
            log.error("error", e);
            throw new BaseException(e.getMessage());
        }
    }

    public User selectByPrimaryKey(User user) {
        return null;
    }

    public User selectByName(String name) {
        return null;
    }
}
