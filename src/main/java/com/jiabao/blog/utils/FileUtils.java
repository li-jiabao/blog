package com.jiabao.blog.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @Author: JiabaoLi
 * @Email: 905001136@qq.com
 * @CreatedDate: 2021/12/23
 */

@Slf4j
public class FileUtils {

    /**
     * 创建一个读取文件中所有行信息的方法
     * @param fileName 传入文件名
     * @return 返回文件中的所有字符串信息
     */
    public static String readFileLinesAsString(String fileName) {
        // 读取文件的输入流，读取文件为缓冲区读取输入流
        String content = null;
            // 创建一个缓冲区文件读取器，传入的输入流读取器传入UTF-8的编码，保证可以正确读取中文字符
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            StringBuilder builder =new StringBuilder();
            String tmp = null;
            while ((tmp = bufferedReader.readLine()) != null) {
                builder.append(tmp);
                builder.append("\n");
            }
            content = builder.toString();
        }catch (UnsupportedEncodingException e) {
            log.error("不支持的文件编码格式，错误信息：{}",e.getMessage());
        }catch (IOException e) {
            log.error("IO操作出现异常错误，错误信息：{}",e.getMessage());
        }
        return content;
    }
}
