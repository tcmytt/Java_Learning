package Spring.SpringCrudApi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserConfiguration {
    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails hiep = User.withDefaultPasswordEncoder()
//                .username("hiep")
//                .password("1")
//                .roles("admin")
//                .build();
//        UserDetails tung = User.withUsername("tung")
//                .password("{noop}2")
//                .roles("teacher")
//                .build();
//        UserDetails duc = User.withUsername("duc")
//                .password("{noop}3")
//                .roles("manager")
//                .build();
//        return new InMemoryUserDetailsManager(hiep,tung,duc);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers (HttpMethod. GET, "/api/students/**").hasAnyRole ( "TEACHER", "ADMIN")
                        .requestMatchers (HttpMethod. POST, "/api/students").hasAnyRole ("MANAGER", "ADMIN")
                        .requestMatchers (HttpMethod. PUT, "/api/students").hasAnyRole ( "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("ADMIN")
                );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        //cross site request forgery : Kiem tra xem co phai la dung trang web gui len khong, ko can thiet trong restAPI
        return http.build();
    }
}
