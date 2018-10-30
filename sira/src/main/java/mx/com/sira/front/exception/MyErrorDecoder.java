package mx.com.sira.front.exception;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by gerry on 10/23/18.
 */
public class MyErrorDecoder implements ErrorDecoder {
    private static Logger LOG = LoggerFactory.getLogger(MyErrorDecoder.class);
    final Decoder decoder;
    final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    public MyErrorDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    public Exception decode(String key, Response response) {
        try {
            Exception mb = (Exception) decoder.decode(response, MyBadRequestException.class);
            LOG.info("excepcion decode {}", mb);
            LOG.info("response {}", this.defaultDecoder.decode(key, response).getMessage());
            return mb;
        } catch (IOException fallbackToDefault) {
            return defaultDecoder.decode(key, response);
        }

    }
}
