package com.jiabao.blog.vo;

import lombok.Data;
import lombok.ToString;

import java.time.YearMonth;
import java.util.Date;
import java.util.List;

/**
 * @Author: JiabaoLi
 * @Email: 905001136@qq.com
 * @CreatedDate: 2021/12/27
 */

@ToString
@Data
public class ArchiveVo {
    private List<YearMonthArchiveVo> allArchives;
}
