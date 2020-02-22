package cn.luotuoyulang.config;

import cn.luotuoyulang.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * @Description 配置类  WebMvcConfigurationSupport 不生效
 *                     WebMvcConfigurationSupport 可以配置  SpringMvc 一些web 视图层一些相关内容
 *                     @EnableWebMvc 里得 WebMvcConfigurationSupport 会覆盖
 * @author liuyuhu
 * @date 2020/2/21 11:08
 */

@Configuration // 相当于 xml 配置
@EnableWebMvc // 启用spring mvc 注解, 默认的注解映射的支持 <mvc:annotation-driven/>
@ComponentScan("cn.luotuoyulang") // 扫包范围 <context:component-scan base-package="lm.solution"/>
@EnableAsync  // 开启springmvc 异步注解
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * @Description 配置视图解析器
     * @param
     * @return {@link {@link InternalResourceViewResolver}}
     * @throws
     * @author liuyuhu
     * @date 2020/2/21 11:10
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        // 配置逻辑视图的前缀
        irvr.setPrefix("/WEB-INF/view/");
        // 配置逻辑视图的后缀
        irvr.setSuffix(".jsp");
        return  irvr;
    }

    /**
     * @Description 配置拦截器
     * @param
     * @return {@link {@link TokenInterceptor}}
     * @throws
     * @author liuyuhu
     * @date 2020/2/21 11:26
     */
    @Bean
    public TokenInterceptor tokenInterceptor(){
        return new TokenInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor())

//                .excludePathPatterns("/payIndex");
        .addPathPatterns("/**");
    }
}
