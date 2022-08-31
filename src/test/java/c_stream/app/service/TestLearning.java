package c_stream.app.service;

import c_stream.app.repository.ProductRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLearning {

    private static Logger logger ;
    private static List<String> list;

    @BeforeEach
    void setUp() {
        logger.info("test başlıyor.");
        list = new ArrayList<>(Arrays.asList("ankara","izmir"));
    }

//    @AfterEach
//    @Disabled
//    void tearDown(){
//        logger.info("test sonlanıyor");
//        list.clear();
//    }

    @BeforeAll
    public static void setup() {
        logger = Logger.getAnonymousLogger();
        //list = new ArrayList<>(Arrays.asList("ankara","izmir"));
        logger.info("startup - creating DB connection");
    }
//
//    @AfterAll
//    public static void tearDown2() {
//        logger.info("closing DB connection");
//    }

    @Test
    public void simpleTest() {
        logger.info("simple test");
    }

    @Test
    public void anotherSimpleTest() {
        logger.info("another simple test");
    }

    @Test
    public void whenCheckingListSize_thenSizeEqualsToInit() {
        logger.info("eleman ekleniyor");
        assertEquals(2, list.size());

        list.add("another test-1");
//        assertEquals(3, list.size());
    }

    @Test
    public void whenCheckingListSizeAgain_thenSizeEqualsToInit() {
        logger.info("eklenen elemanın varlığı sorgulanıyor");
        assertEquals(2, list.size());

        list.add("yet another test-2");
    }
}
