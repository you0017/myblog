package com.yc.lang;

public class Test10 {
    public static void main(String[] args) throws Exception{
        String s = "1,apple,20;2,pear,30;3,banana,40;4,grep,50";
        String names[] = new String[]{"id","name","price"};

        //利用反射机制，将s截取，生成四个Product对象，并将以上信息存到产品对象中
        String[] pros = s.split(";");

        //对象数组
        Product products[] = new Product[pros.length];

        for (int i=0 ; i<pros.length ; i++) {
            String[] values = pros[i].split(",");
            Object o = GenerateObject.parseObject(values, names, Product.class);
            if (o instanceof Product){
                products[i] = (Product) o;
            }
        }


        //输出对象数组的值
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
