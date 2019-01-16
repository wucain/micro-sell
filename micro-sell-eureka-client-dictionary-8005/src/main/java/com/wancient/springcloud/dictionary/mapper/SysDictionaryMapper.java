package com.wancient.springcloud.dictionary.mapper;

import com.wancient.springcloud.api.entities.SysDictionary;

import java.util.List;

public interface SysDictionaryMapper {
    /**
     * 新增
     *
     * @param sysDictionary
     * @return
     */
    int insert(SysDictionary sysDictionary);

    /**
     * 新增部分字段
     *
     * @param sysDictionary
     * @return
     */
    int insertSelective(SysDictionary sysDictionary);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    SysDictionary selectByPrimaryKey(Integer id);

    /**
     * 查询全部
     *
     * @param sysDictionary
     * @return
     */
    List<SysDictionary> selectAll(SysDictionary sysDictionary);


    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键更新部分
     *
     * @param sysDictionary
     * @return
     */
    int updateByPrimaryKeySelective(SysDictionary sysDictionary);

    /**
     * 根据主键更新全部
     *
     * @param sysDictionary
     * @return
     */
    int updateByPrimaryKey(SysDictionary sysDictionary);
}