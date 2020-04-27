package cn.ustc.edu.springboot.config;

import cn.ustc.edu.springboot.component.filter.MyFilter;
import cn.ustc.edu.springboot.component.listener.MyListener;
import cn.ustc.edu.springboot.interceptor.LoginInterceptor;
import cn.ustc.edu.springboot.component.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //注册servlet
    @Bean
    public ServletRegistrationBean servletServletRegistrationBean() {
        ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        return servletServletRegistrationBean;
    }

    //注册filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    //注册listener
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }

//    @Bean  //一定要将这个server定制器加入到容器中
//    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
//        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
//            @Override
//            public void customize(ConfigurableServletWebServerFactory factory) {
//                factory.setPort(9000);
//                factory.setContextPath("/cccc");
//            }
//
//        };
//    }

//    //第一种导入组件的方式
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/config").setViewName("success");
//    }



    //第二种导入组件的方式
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/error").setViewName("404");
            }
        };
        return configurer;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/login");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
