package com.yc.lang;

/**
 * 将上一个例子中的字符串中的数据截取出来，用于创建Product对象
 */
public class Test8_GenerateObject {
    public static void main(String[] args) throws Exception {
        String s = "1,apple,20;2,pear,30;3,banana,40;4,grep,50";

        //利用反射机制，将s截取，生成四个Product对象，并将以上信息存到产品对象中
        String[] pros = s.split(";");

        //对象数组
        Product products[] = new Product[pros.length];

        for (int i=0 ; i<pros.length ; i++) {
            String[] values = pros[i].split(",");
            //products[i] = new Product(Integer.parseInt(values[0]),values[1],Double.parseDouble(values[2]));


            products[i] = new Product();
            products[i].setId(Integer.parseInt(values[0]));
            products[i].setName(values[1]);
            products[i].setPrice(Double.parseDouble(values[2]));
        }


        //输出对象数组的值
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
