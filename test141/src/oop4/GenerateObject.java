package oop4;

import java.lang.reflect.Method;
import java.util.*;

public class GenerateObject {

    public static Object parseObject(String[] values,String[] names,Class c) throws Exception {
        Object o = c.newInstance();
        Method[] methods = c.getDeclaredMethods();

        List setMethods = allSetMethods(methods);

        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            String name = names[i];

            Method m = findSetMethod(name,setMethods);

            Class parameterTypeClass = m.getParameterTypes()[0];
            String parameterTypeName = parameterTypeClass.getName();
            if (parameterTypeName.equals("int") || parameterTypeName.equals("java.lang.Integer")){
                m.invoke(o,Integer.parseInt(value));
            } else if (parameterTypeName.equals("short") || parameterTypeName.equals("java.lang.Short")){
                m.invoke(o,Short.parseShort(value));
            }else if (parameterTypeName.equals("double") || parameterTypeName.equals("java.lang.Double")){
                m.invoke(o,Double.parseDouble(value));
            }else if (parameterTypeName.equals("float") || parameterTypeName.equals("java.lang.Float")){
                m.invoke(o,Float.parseFloat(value));
            }else if (parameterTypeName.equals("long") || parameterTypeName.equals("java.lang.Long")){
                m.invoke(o,Integer.parseInt(value));
            }else if (parameterTypeName.equals("byte") || parameterTypeName.equals("java.lang.Byte")){
                m.invoke(o,Byte.parseByte(value));
            }else if (parameterTypeName.equals("boolean") || parameterTypeName.equals("java.lang.Boolean")){
                m.invoke(o,Boolean.parseBoolean(value));
            }else {
                m.invoke(o,value);
            }
        }
        return o;
    }

    private static Method findSetMethod(String name,List setMethods) {
        for (int i = 0; i < setMethods.size(); i++) {
            if (setMethods.get(i).equals("set"+name.substring(0,1).toUpperCase()+name.substring(1))){
                return (Method) setMethods.get(i);
            }
        }
        return null;
    }

    private static List allSetMethods(Method[] methods) {
        List setMethods = new ArrayList();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("set")){
                setMethods.add(methods[i]);
            }
        }
        return setMethods;
    }
}
