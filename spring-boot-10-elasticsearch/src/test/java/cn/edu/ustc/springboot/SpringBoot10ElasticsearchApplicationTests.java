package cn.edu.ustc.springboot;


import cn.edu.ustc.springboot.bean.Book;
import cn.edu.ustc.springboot.repository.BookRepository;
import com.sun.scenario.effect.impl.prism.PrImage;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SpringBoot10ElasticsearchApplicationTests {

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    RestHighLevelClient highLevelClient;



    @Autowired
    private BookRepository bookRepository;


    /**
     * RestHighLevelClient的Index测试
     */
    @Test
    void testIndex() {
        IndexRequest request = new IndexRequest("ustc", "book",
                UUID.randomUUID().toString())
                .source(Collections.singletonMap("feature", "high-level-rest-client"))
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        try {
            IndexResponse index = highLevelClient.index(request, RequestOptions.DEFAULT);
            System.out.println(index.getIndex());
            System.out.println(index.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * RestHighLevelClient的get index
     * @throws IOException
     */
    @Test
    void getIndex() throws IOException {
        GetRequest getRequest = new GetRequest("ustc","book","0dc9f47a-7913-481d-a36d-e8f034a6a3ac");
        GetResponse documentFields = highLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(documentFields);
    }

    /**
     * ElasticsearchOperations保存索引
     */
    @Test
    void save() {
        Book book = new Book();
        book.setAuthor("吴承恩");
        book.setBookName("西游记");
        book.setId(2);
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(book.getId().toString())
                .withObject(book)
                .build();
        String index = elasticsearchOperations.index(indexQuery);
        System.out.println(index);
    }

    /**
     * ElasticsearchOperations查询索引
     */
    @Test
    void findId() {
        Book book = elasticsearchOperations.queryForObject(GetQuery.getById("1"), Book.class);
        System.out.println(book);
    }


    @Test
    void TestBookRepository() {
        List<Book> books = bookRepository.findByBookNameAndAuthor("的世界", "遥");
        books.forEach(System.out::println);
    }
}
