package com.kaysanshi.apache_commons.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class FileNameUtilsTest {
    public static void main(String[] args) throws IOException {
        // concat(String basePath, String fullFilenameToAdd)  合并目录和文件名作为文件的全路径

        String BASE_PATH = "E:/java";
        String concat = FilenameUtils.concat(BASE_PATH, "1.txt");
        System.out.println(concat);
        // E:\java\1.txt
        // 创建一个文件
        File file = new File(concat);
        FileUtils.write(file, "1233333", StandardCharsets.UTF_8);
        // 去根目录和文件后缀的文件名
        System.out.println(FilenameUtils.getFullPath(concat));
        // 获取盘符
        System.out.println(FilenameUtils.getPrefix(concat));
        // 获取名称
        System.out.println(FilenameUtils.getName(concat));
        // 获取当前系统格式话路径
        System.out.println(FilenameUtils.normalize(concat));


        // 判断文件扩展名是否和指定规则匹配
        // FilenameUtils.wildcardMatch(String filename, String wildcardMatcher)


        // 判断文件扩展名是否包含在指定集合(数组、字符串)中
        // FilenameUtils.isExtension(String filename, String extension)

        // 转换分隔符为当前系统分隔符
        // FilenameUtils.separatorsToSystem(String path)


    }
}
