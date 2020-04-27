package cn.edu.ustc.springboot.repository;


import cn.edu.ustc.springboot.bean.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    List<Book> findByBookNameAndAuthor(String bookName, String author);
    
}
