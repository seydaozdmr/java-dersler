package c_stream.app.service;

import a_collections.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

public class AssertJExampleTest {


    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator=new Calculator();
    }

    @Test
    @Disabled
    void testAdding(){
        //given

        //when
        int result= calculator.sum(1,2);
        //then
        assertThat(result).isEqualTo(3);
    }

//    @Test
//    @Disabled
//    void verifyArea(){
//        Mockito.when(calculator.verifyArea(any(),any())).thenReturn(true);
//        boolean result = calculator.verifyArea(2,2);
//
//        assertThat(result).isTrue();
//
//        Mockito.verify(calculator).verifyArea(any(),any());
//    }

    @Test
    void assertThrown(){
        //int result = 10/0;
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(()->{
            int result=19/0;
        }).withMessageMatching("/ by zero");
    }

    @Test
    void catchThrowable2(){
        Throwable t= catchThrowable(()->{
            int a=10/0;
        });

        assertThat(t)
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("zero");

    }
}
