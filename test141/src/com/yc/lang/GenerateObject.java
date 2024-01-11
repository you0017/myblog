package com.yc.lang;

import java.lang.reflect.Method;
import java.util.*;

public class GenerateObject {

    /**
     * 根据输入动态生成对象
     * @param values    对象中各种属性的值
     * @param names     属性名（按values一一排序
     * @param c         要生成的对象的反射对象（基因
     * @return          生成好的对象
     */
    public static Object parseObject(String[] values,String[] names,Class c) throws Exception {
        //1.根据c生成对象
        Object o = c.newInstance();

        //2.取出c中所有的方法
        Method[] methods = c.getDeclaredMethods();  //所有的get(),所有的set(),toString()...
        //筛选出set方法即可
        List setMethods = allSetMethods(methods);

        //3.循环values所有的值，通过set方法注入到o对象
        for (int i = 0; i < values.length; i++) {
            //System.out.println("1");
            String value = values[i];   //取值
            String name = names[i]; //取对应的属性名

            //根据name 取setXxx方法
            Method setMethod = findSetMethod(name,setMethods);

            //要针对不同的参数类型进行强转
            //激活这个对象
            //解决方法：获取setMethod中参数的类型，判断类型是什么
            Class parameterTypeClass = setMethod.getParameterTypes()[0];
            String parameterTypeName = parameterTypeClass.getName();
            if (parameterTypeName.equals("int") || parameterTypeName.equals("java.lang.Integer")){
                setMethod.invoke(o,Integer.parseInt(value));
            } else if (parameterTypeName.equals("short") || parameterTypeName.equals("java.lang.Short")){
                setMethod.invoke(o,Short.parseShort(value));
            }else if (parameterTypeName.equals("double") || parameterTypeName.equals("java.lang.Double")){
                setMethod.invoke(o,Double.parseDouble(value));
            }else if (parameterTypeName.equals("float") || parameterTypeName.equals("java.lang.Float")){
                setMethod.invoke(o,Float.parseFloat(value));
            }else if (parameterTypeName.equals("long") || parameterTypeName.equals("java.lang.Long")){
                setMethod.invoke(o,Integer.parseInt(value));
            }else if (parameterTypeName.equals("byte") || parameterTypeName.equals("java.lang.Byte")){
                setMethod.invoke(o,Byte.parseByte(value));
            }else if (parameterTypeName.equals("boolean") || parameterTypeName.equals("java.lang.Boolean")){
                setMethod.invoke(o,Boolean.parseBoolean(value));
            }else {
                setMethod.invoke(o,value);
            }
        }

        return o;
    }

    /**
     * 在所有待查找的setMethods中查出名字叫 setXxx
     * @param name  属性名
     * @param setMethods    待查找的方法
     * @return
     */
    private static Method findSetMethod(String name, List setMethods) {
        for (int i = 0; i < setMethods.size(); i++) {
            Method m = (Method) setMethods.get(i);
            if (m.getName().equals("set" + name.substring(0,1).toUpperCase()+name.substring(1))){
                return m;
            }
        }
        return null;
    }


    /**
     * 从methods数组中去除所有的set方法
     *
     * @param methods
     * @return
     */
    private static List allSetMethods(Method[] methods){
        List setMethods = new ArrayList(); //存set方法
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("set")){
                setMethods.add(methods[i]);
            }
        }
        return setMethods;
    }
}
