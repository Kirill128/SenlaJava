package com.it.academy.configuration;

import com.it.academy.accessdeniedhandler.CustomAccessDeniedHandler;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private DataSource dataSource;

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/signup/**","/login/**","/","/css/**","/js/**").permitAll()
                .antMatchers("/users/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .and().logout().invalidateHttpSession(true).clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").permitAll()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);

    }
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("SELECT users.name as username, role.role as role FROM users " +
                        "INNER JOIN user_role ON users.id = user_role.user_id " +
                        "INNER JOIN role ON user_role.role_id = role.id " +
                        "WHERE users.name = ?")
                .usersByUsernameQuery("SELECT name ,password from users where name=?");
    }

}
