package mx.com.sira.front.util;


import feign.codec.Decoder;
import feign.gson.GsonDecoder;
import mx.com.sira.front.exception.MyErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gerry on 14/10/18.
 */
@Configuration
public class FeignApiServiceConfig {

    @Bean
    public MyErrorDecoder myErrorDecoder() {
        Decoder decoder = new GsonDecoder();
        return new MyErrorDecoder(decoder);
    }

}