/*
 * Copyright (c) 2018. syshlang
 * @File: UserServiceImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-17 上午3:06
 * @since:
 */

package com.syshlang.serviceImpl.user;

import com.syshlang.api.common.ApiResultBean;
import com.syshlang.api.common.ApiResultListData;
import com.syshlang.api.common.service.UserService;
import com.syshlang.common.base.BaseException;
import com.syshlang.common.base.BaseResult;
import com.syshlang.common.base.BaseResultCode;
import com.syshlang.common.model.user.User;
import com.syshlang.dao.user.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;



    @Override
    public BaseResult add(User user,Integer h)  {
        BaseResult result = new  BaseResult(BaseResultCode.SUCCESS);
        try{
            log.info("UserRestServiceImpl:add");

          /*  Gson gson = new Gson();
            String str = gson.toJson(user);
            log.info(str);*/
            return result;
        }catch(BaseException e){
            result = new  BaseResult(BaseResultCode.EXCEPTION.getCode(),e.getMessage());
        }catch(Exception e){
            result = new  BaseResult(BaseResultCode.EXCEPTION.getCode(),e.getMessage());
        }finally{
        }
        return result;
    }


    @Override
    public ApiResultListData<?> selectAll(Map map, String db)
    {
        Map<String,String> param = new HashMap<String,String>();
        ApiResultListData resultData = new ApiResultListData(BaseResultCode.SUCCESS);
        try{
            log.info("XtbXtcsRestServiceImpl:selectXtcs");
            //List<User> alist = userDaoJdbc.getUsers(db);
            List<User> alist = userDao.selecttest(map);
            resultData.setRows(alist);
            log.info("size:" + alist.size());

            return resultData;

        }catch(BaseException e){
            resultData = new ApiResultListData(BaseResultCode.EXCEPTION);
        }finally{
        }

        return resultData;
    }


    @Override
    public ApiResultBean<User> selectByPrimaryKey(User t)  {
        // TODO Auto-generated method stub
        ApiResultBean<User> result = new  ApiResultBean<User>(BaseResultCode.SUCCESS);
        try{
            User u = userDao.selectByPrimaryKey(t);
            result.setRow(u);
            return result;
        }catch(BaseException e){
            result = new  ApiResultBean<User>(BaseResultCode.EXCEPTION);
        }finally{
        }
        return result;
    }


    @Override
    public ApiResultBean<User> selectByName(String name){
        // TODO Auto-generated method stub
        ApiResultBean<User> result = new  ApiResultBean<User>(BaseResultCode.SUCCESS);
        try{
            User u = userDao.selectByName(name);
            result.setRow(u);
            return result;
        }catch(BaseException e){
            result = new  ApiResultBean<User>(BaseResultCode.EXCEPTION);
        }finally{
        }
        return result;
    }
}
