package cn.itaxu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Description: cn.itaxu.config
 * @author: Axu
 * @date:2022/11/13 22:01
 */
@Configuration
@ComponentScan({"cn.itaxu.controller","cn.itaxu.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
