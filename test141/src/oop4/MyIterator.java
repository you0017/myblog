package oop4;

public interface MyIterator {
    /**
     * 每调用一次next()就能获得一个元素
     * @return
     */
    public Object next();

    /**
     * 判断是否有下一个元素
     */
    public boolean hasNext();
}
