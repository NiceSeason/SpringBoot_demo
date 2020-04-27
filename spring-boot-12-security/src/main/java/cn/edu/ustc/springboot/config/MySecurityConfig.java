package cn.edu.ustc.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
//        http.formLogin();
//
        //定制登录页
        http.formLogin()
                .usernameParameter("user")  //表单用户名name
                .passwordParameter("pwd")   //表单密码name
                .loginPage("/userlogin");   //定制登陆页路径

        http.logout().logoutSuccessUrl("/");


        //开启记住我
        http.rememberMe().rememberMeParameter("rem");



    }

//    //定义认证规则
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("zhangsan").password("123456").roles("VIP1","VIP2")
//                .and()
//                .withUser("lisi").password("123456").roles("VIP2","VIP3")
//                .and()
//                .withUser("wangwu").password("123456").roles("VIP1","VIP3");
//
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder builder = User.withDefaultPasswordEncoder();
        UserDetails user1 = builder.username("zhangsan")
                .password("123456")
                .roles("VIP1", "VIP2")
                .build();
        UserDetails user2 = builder.username("lisi")
                .password("123456")
                .roles("VIP3", "VIP2")
                .build();
        UserDetails user3 = builder.username("wangwu")
                .password("123456")
                .roles("VIP1", "VIP3")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }



}
