package org.ums.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @desc: Entry
 * @author: Leif
 * @date: 2024/4/24 08:32
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}
        , scanBasePackages = {
        "org.ums.framework",
        "org.ums.admin",
        "org.ums.common",
        "org.ums.api",
        }
)
public class ApiBoot {
    public static void main(String[] args){ SpringApplication.run(ApiBoot.class, args);}
}