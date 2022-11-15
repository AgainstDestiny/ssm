package cn.itaxu.service;

import cn.itaxu.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description: cn.itaxu.service
 * @author: Axu
 * @date:2022/11/13 22:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = SpringConfig.class)
public class BookServiceTest {

    @Autowired
    private BrandService bookService;

    @Test
    public void testGetSingle(){
        Book book = bookService.getSingle(10);
        System.out.println(book);
    }

    @Test
    public void testGetAll(){
        List<Book> books = bookService.getAll();
        System.out.println(books);
    }

}
