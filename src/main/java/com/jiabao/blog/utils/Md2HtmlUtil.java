package com.jiabao.blog.utils;

import org.commonmark.Extension;
import org.commonmark.ext.autolink.AutolinkExtension;
import org.commonmark.ext.front.matter.YamlFrontMatterExtension;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.image.attributes.ImageAttributesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: JiabaoLi
 * @Email: 905001136@qq.com
 * @CreatedDate: 2021/12/23
 */
public class Md2HtmlUtil {

    /**
     * 将一个md字符串解析为html字符串
     * @param markdown 传入的md字符串行
     * @return 解析出来的html
     */
    public static String mdToHtmlString(String markdown) {
        // 构建一个解析器
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        // 新建一个html代码渲染器
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        // 将解析出来的document进行渲染得到渲染后的字符串
        return renderer.render(document);
    }

    /**
     * 使用带扩展器的解析器和渲染器来进行md到html的渲染
     * @param markdown 传入的一行md字符串
     * @return 渲染后的html字符串
     */
    public static String mdToHtmlStringExtension(String markdown) {
        // 创建一个扩展器的列表
        List<Extension> extensions = Arrays.asList(
                // 连接的扩展器，优化链接的html渲染
                AutolinkExtension.create(),
                // 图片的扩展器，优化图片的转换渲染
                ImageAttributesExtension.create(),
                // 优化表格的渲染
                TablesExtension.create(),
                YamlFrontMatterExtension.create(),
                StrikethroughExtension.create()
        );
        // 将扩展器传入解析器并得到一个解析器
        Parser parser = Parser.builder().extensions(extensions).build();
        // 解析字符串为Node
        Node document = parser.parse(markdown);
        // 创建渲染器
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
        return renderer.render(document);
    }
}
