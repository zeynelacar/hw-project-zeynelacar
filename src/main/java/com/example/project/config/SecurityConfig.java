package com.example.project.config;

import com.example.project.security.TokenFilterConfig;
import com.example.project.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile("secured")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenProvider tokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Important, for cross-site forgery.
        http.csrf().disable();

        // No session will be created or used by spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Authorizations of entry points.
        http.authorizeRequests()
                .antMatchers("/api/user/signin").permitAll()
                .antMatchers("/api/user/signup").permitAll()
                .antMatchers("/api/user/delete/{}username").hasRole("ADMIN")
                .antMatchers("/api/user/get-by-username").hasRole("ADMIN")
                .antMatchers("/api/fee/add").hasRole("ADMIN")
                .antMatchers("/api/flat/add").hasRole("ADMIN")
                .antMatchers("/api/block/add").hasRole("ADMIN")
                .antMatchers("/api/payment/delete").hasRole("ADMIN")
                .anyRequest().authenticated();

        // Apply JWT
        http.apply(new TokenFilterConfig(tokenProvider));

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(6);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
