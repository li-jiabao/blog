package com.jiabao.blog;

import com.jiabao.blog.dao.ArticleTagDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    ArticleTagDao articleTagDao;
    @Test
    void getTags() {
        System.out.println(articleTagDao.getTagsByArticleId(1L));
    }
}
