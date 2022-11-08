package com.kaysanshi.apache_commons.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        // 写文件
        String file = "IOUtilsTestFile.txt";
        List<String> lines= new ArrayList<>();
        lines.add("在这里");
        lines.add("在那里");
        lines.add("在你的心里");
        //进行写文件
        FileUtils.writeLines(new File(file), StandardCharsets.UTF_8.name(),lines);

        // 读文件
        List<String> strings = FileUtils.readLines(new File(file),StandardCharsets.UTF_8);
        strings.forEach(System.out::println);

        // copy文件

        File oriFile = new File(file);
        File destFile = new File("IOUtilsTestFileCopy.txt");
        FileUtils.copyFile(oriFile,destFile);

        // InputStream读取网络路径的流
        URL url = new URL("https://top.baidu.com/board?tab=novel");
        File page = new File("file.html");
        FileUtils.copyURLToFile(url,page);
        List<String> html = FileUtils.readLines(page,StandardCharsets.UTF_8);
        html.forEach(System.out::println);
    }
}
