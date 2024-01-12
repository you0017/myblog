1.Student   ->  替换成更通用的类  让MyList可以存各种数据
2。修改MyList
3.增加更多的数据结构

从MyList扩展栈  MyStack：
    特点：后进先出
    多增加功能：push（Object   压到栈顶
              Object pop()  从栈顶拿出元素，长度减一
              Object peek() 返回栈顶元素

从MyList扩展队列  MyQueue：
    特点：先进先出
    多增加功能：enque(Object) 队尾
              Object deque() 队头
    增加：队头head  和  队尾指针tail