package oop3;

/**
 * 设计一个集合的接口：存数据（按索引，不按索引   有的可以重复，有的不能
 */
public interface Collection {

    /**
     *   求集合中元素个数方法
     */
    public int size();

    /**
     * 判断集合是否为空
     */
    public boolean isEmpty();

    /**
     * 添加元素
     */
    public void add(Object obj);

    /**
     * 清空
     */
    public void clear();
}
