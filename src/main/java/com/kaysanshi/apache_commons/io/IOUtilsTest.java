package com.kaysanshi.apache_commons.io;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * commons-io
 */
public class IOUtilsTest {
    public static void main(String[] args) throws IOException {
        // 写文件
        String file = "IOUtilsTestFile.txt";
        List<String> lines= new ArrayList<>();
        lines.add("在这里");
        lines.add("在那里");
        lines.add("在你的心里");
        //进行写文件
        IOUtils.writeLines(lines,null,new FileOutputStream(file),StandardCharsets.UTF_8);

        // 读文件
        List<String> strings = IOUtils.readLines(new FileInputStream(file));
        strings.forEach(System.out::println);

        // copy文件

        InputStream inputStream = new FileInputStream(file);
        FileWriter fileWriter = new FileWriter("IOUtilsTestFileCopy.txt");
        IOUtils.copy(inputStream,fileWriter,StandardCharsets.UTF_8);
        fileWriter.close();
        inputStream.close();

        // InputStream读取网络路径的流
        InputStream in = new URL("https://top.baidu.com/board?tab=novel").openStream();
        String pageContent = IOUtils.toString(in, StandardCharsets.UTF_8);
        System.out.println(pageContent);


    }
}
