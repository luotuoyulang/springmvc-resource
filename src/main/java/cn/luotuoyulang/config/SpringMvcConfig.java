package cn.luotuoyulang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 相当于 xml 配置
 */
@Configuration
/**
 * 启用spring mvc 注解, 默认的注解映射的支持
 * <mvc:annotation-driven/>
 */
@EnableWebMvc
/**
 * 扫包范围
 * <context:component-scan base-package="lm.solution"/>
 */
@ComponentScan("cn.luotuoyulang")
public class SpringMvcConfig {

}
