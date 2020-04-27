package cn.ustc.edu.springboot02config.config;

import cn.ustc.edu.springboot02config.service.ConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用@Configuration 和 @Bean 替代配置文件
 * 将Service组件导入到容器中
 */
@Configuration
public class MyConfiguration {
    @Bean
    public ConfigService createService() {
        System.out.println("配置类给容器中添加组件了");
        return new ConfigService();
    }
}
