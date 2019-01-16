package com.wancient.springcloud.dictionary.service.impl;


import com.wancient.springcloud.api.entities.SysDictionary;
import com.wancient.springcloud.dictionary.mapper.SysDictionaryMapper;
import com.wancient.springcloud.dictionary.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典表service
 *
 * @author: Wancient
 * @date: 2018/6/14
 * @time: 16:10
 */
@Service
public class SysDictionaryServiceImpl implements SysDictionaryService {

    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;


    /**
     * 新增全部
     *
     * @param sysDictionary
     * @return
     */
    @Override
    public int insert(SysDictionary sysDictionary) {
        return sysDictionaryMapper.insert(sysDictionary);
    }

    /**
     * 新增部分
     *
     * @param sysDictionary
     * @return
     */
    @Override
    public int insertSelective(SysDictionary sysDictionary) {
        return sysDictionaryMapper.insertSelective(sysDictionary);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public SysDictionary selectByPrimaryKey(Integer id) {
        return sysDictionaryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询全部
     *
     * @param sysDictionary
     * @return
     */
    @Override
    public List<SysDictionary> selectAll(SysDictionary sysDictionary) {
        return sysDictionaryMapper.selectAll(sysDictionary);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysDictionaryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新部分
     *
     * @param sysDictionary
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(SysDictionary sysDictionary) {
        return sysDictionaryMapper.updateByPrimaryKeySelective(sysDictionary);
    }

    /**
     * 更新全部
     *
     * @param sysDictionary
     * @return
     */
    @Override
    public int updateByPrimaryKey(SysDictionary sysDictionary) {
        return sysDictionaryMapper.updateByPrimaryKey(sysDictionary);
    }
}
