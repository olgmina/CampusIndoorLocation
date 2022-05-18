package AuthorizationPool.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http
                .authorizeRequests()
                        .antMatchers("/", "/login", "/userPage", "/edit1", "/edit2", "/edit3", "/edit4", "/edit5").permitAll()
                .antMatchers("/admin").access("hasRole('Admin')")
                        .anyRequest().authenticated()
                        .and()
                .formLogin()
                        .loginPage("/login")
                        .permitAll()
                        .and()
                .logout()
                        .logoutSuccessUrl("/")
                        .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("123")
                        .roles("Admin")
                        .build();

        UserDetails user1 = User.withDefaultPasswordEncoder().username("Хмельнин А.С.").password("123").roles("User").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("Захаева А.А.").password("123").roles("User").build();
        UserDetails user3 = User.withDefaultPasswordEncoder().username("Вахаев Б.П.").password("123").roles("User").build();
        UserDetails user4 = User.withDefaultPasswordEncoder().username("Лучикова Н.Г.").password("123").roles("User").build();
        UserDetails user5 = User.withDefaultPasswordEncoder().username("Красаев Н.Е.").password("123").roles("User").build();

        return new InMemoryUserDetailsManager(admin, user1, user2, user3, user4, user5);

    }
}
