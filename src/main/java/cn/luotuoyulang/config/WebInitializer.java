package cn.luotuoyulang.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 用来替代 web.xml
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        // 1、启动SpringMvc 容器类 注入到 Spring 中
        AnnotationConfigWebApplicationContext anno = new AnnotationConfigWebApplicationContext();
        // 2、注入到我们的springmvc 得配置文件
        anno.register(SpringMvcConfig.class);
        // 3、将我们的 dispatcherServlet 注入到 servlet 容器中
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(anno));
        // 4、填写 url 路径映射
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setLoadOnStartup(1);
    }
}
