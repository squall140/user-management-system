package org.ums.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @desc: Undertow config for multiple listening ports
 * @author: Leif
 * @date: 2022/9/14 上午10:00
 */
@Configuration
public class UndertowConfig {
    @Value("${server.additionalPort}")
    private String additionalPort;

    @Bean
    public UndertowServletWebServerFactory getApplicationcontext() {
        UndertowServletWebServerFactory undertow = new UndertowServletWebServerFactory();
        if (additionalPort != null && additionalPort.length() > 0) {
            int[] ports =  Arrays.stream(this.additionalPort.split(",")).mapToInt(Integer::parseInt).toArray();
            IntStream.of(ports).forEach( port ->{
                undertow.addBuilderCustomizers(builder -> builder.addHttpListener(port, "0.0.0.0"));
            });
        }
        return undertow;
    }

}
