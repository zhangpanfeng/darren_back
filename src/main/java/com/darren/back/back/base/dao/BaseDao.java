package com.darren.back.back.base.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.darren.comm.base.po.BaseEntity;
import com.darren.comm.exception.BusinessException;
import com.darren.comm.exception.ErrorCode;
import com.darren.comm.exception.ErrorMessage;

public class BaseDao {
    /**
     * session 模板
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

    protected void saveEntity(String key, BaseEntity entity) throws BusinessException {
        try {
            this.sqlSession.insert(key, entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ErrorCode.CREATE_ERROR, ErrorMessage.CREATE_ERROR("saveEntity", entity));
        }
    }

    protected void updateEntity(String key, BaseEntity entity) throws BusinessException {
        try {
            this.sqlSession.update(key, entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ErrorCode.UPDATE_ERROR, ErrorMessage.UPDATE_ERROR("updateEntity", entity));
        }
    }

    protected BaseEntity findEntityById(String key, String id) throws BusinessException {
        BaseEntity result = null;
        try {
            result = this.sqlSession.selectOne(key, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ErrorCode.READ_ERROR, ErrorMessage.READ_ERROR("findEntityById", id));
        }

        return result;
    }

    protected BaseEntity findEntityByParams(String key, Map<String, Object> params) throws BusinessException {
        BaseEntity result = null;
        try {
            result = this.sqlSession.selectOne(key, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ErrorCode.READ_ERROR, ErrorMessage.READ_ERROR("findEntityByParams", params));
        }

        return result;
    }

    protected <T> List<T> findAllEntitys(String key) throws BusinessException {
        List<T> result = null;
        try {
            result = this.sqlSession.selectList(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ErrorCode.READ_ERROR, ErrorMessage.READ_ERROR("findAllEntitys", null));
        }

        return result;
    }

    protected <T> List<T> findEntitysByParams(String key, Map<String, Object> params) throws BusinessException {
        List<T> result = null;
        try {
            result = this.sqlSession.selectList(key, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ErrorCode.READ_ERROR, ErrorMessage.READ_ERROR("findEntitysByParams", params));
        }

        return result;
    }

    protected void deleteEntity(String key, String id) throws BusinessException {
        try {
            this.sqlSession.delete(key, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ErrorCode.DELETE_ERROR, ErrorMessage.DELETE_ERROR("deleteEntity", id));
        }
    }
}
