package com.vince.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import com.vince.bean.Clothes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsXMLUtils {

    //解析XML文件
    public static List<Clothes> parserProductFormXml(){

        List<Clothes> products = new ArrayList<>();
        XStream xStream = new XStream(new Xpp3DomDriver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");


        try {
            BufferedInputStream inputStream = new BufferedInputStream(
                    new FileInputStream("products.xml"));
            products = (List<Clothes>) xStream.fromXML(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return products;
    }

    public static  void  writeProducToXml(List<Clothes> products){

        XStream xStream = new XStream(new Xpp3DomDriver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");

        try{
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream("products.xml"));

            //单独把头写进去
            outputStream.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>".getBytes());
            xStream.toXML(products,outputStream);
            outputStream.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
