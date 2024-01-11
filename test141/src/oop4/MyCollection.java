package oop4;

/**
 * 设计一个集合的接口：存数据（按索引，不按索引(hash   有的可以重复，有的不能
 */
public interface MyCollection extends MyIterable{

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


    /**
     * 删除一个元素：核心判断集合中是否存在这个元素   equals() + hashcode()
     */
    public boolean remove(Object obj);
}
