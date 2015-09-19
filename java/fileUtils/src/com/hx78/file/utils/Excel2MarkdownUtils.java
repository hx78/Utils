package com.hx78.file.utils;

import java.io.*;

/**
 * Created by linming on 2015/9/19 0019.
 */
public class Excel2MarkdownUtils {
    public static void main(String[] args) throws IOException {

        File in = new File("in.txt");
        // 构建FileInputStream对象
        FileInputStream fip = new FileInputStream(in);
        // 创建 BufferedReader
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(fip, "UTF-8"));

        File out = new File("out.txt");
        // 构建FileOutputStream对象,文件不存在会自动新建
        FileOutputStream fop = new FileOutputStream(out);
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");


        String s1 = null;
        String s2 = null;
        String [] ss = null;
        StringBuilder stringBuilder = new StringBuilder();
        while (/*reader.ready() && */(s1 = reader.readLine()) != null) {

            if (s1.split("\t") != null) {
                ss = s1.split("\t");
            }
            else{
                ss = s1.split(" ");
            }


            s2 = "";
            for (int i = 0; i < ss.length - 1; i++) {
                s2 = s2 + ss[i] + " | ";
            }
            s2 = s2 + ss[ss.length -1];
            System.out.println(s2.toString());
            // 写入到缓冲区
            writer.append(s2);
            //换行
            writer.append("\r\n");
        }

        //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
        writer.close();
        // 关闭输出流,释放系统资源
        fop.close();


        // 关闭读取流
        reader.close();
        // 关闭输入流,释放系统资源
        fip.close();
    }
}
