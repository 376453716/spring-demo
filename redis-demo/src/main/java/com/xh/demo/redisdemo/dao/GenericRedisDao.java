package com.xh.demo.redisdemo.dao;

/**
 * @author Xiong Hao
 */
public interface GenericRedisDao {

    /**
     * 通过key删除
     *
     * @param keys
     */
    void del(String... keys);

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime 单位秒
     */
    void set(String key, String value, long liveTime);

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    boolean exists(String key);

}
