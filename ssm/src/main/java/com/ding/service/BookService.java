package com.ding.service;

import com.ding.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    // 增加
    int addBook(Books books);

    // 删除
    int deleteBookById(int id);

    // 更新
    int updateBook(Books books);

    // 查询
    Books queryBookById(int id);

    // 查询全部
    List<Books> queryAllBook();

    Books queryBookByName(String bookName);
}
