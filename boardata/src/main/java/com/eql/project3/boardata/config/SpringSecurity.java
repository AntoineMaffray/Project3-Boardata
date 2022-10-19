package com.eql.project3.boardata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public static PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/connectedIndex").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/register/**").permitAll()
//                .antMatchers("/login").permitAll()

                .antMatchers("/friends").hasAnyRole("ADMIN", "USER")
                .antMatchers("/addFriends").hasAnyRole("ADMIN", "USER")
                .antMatchers("/addFriend/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/pendingFriends").hasAnyRole("ADMIN", "USER")
                .antMatchers("/askedFriends").hasAnyRole("ADMIN", "USER")
                .antMatchers("/acceptFriend/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/friends").hasAnyRole("ADMIN", "USER")

                .antMatchers("/chooseGame").hasAnyRole("ADMIN", "USER")
                .antMatchers("/showNewGameForm").hasAnyRole("ADMIN", "USER")
                .antMatchers("/saveGame").hasAnyRole("ADMIN", "USER")
                .antMatchers("/addRound/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/addPlayers").hasAnyRole("ADMIN", "USER")
                .antMatchers("/addPlayer/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/showNewResultSWForm").hasAnyRole("ADMIN", "USER")
                .antMatchers("/saveNature").hasAnyRole("ADMIN", "USER")
                .antMatchers("/showNewResultRGForm").hasAnyRole("ADMIN", "USER")
                .antMatchers("/saveSimpleScore").hasAnyRole("ADMIN", "USER")
                .antMatchers("/showResult").hasAnyRole("ADMIN", "USER")

                .antMatchers("/myStats").hasAnyRole("ADMIN", "USER")
                .antMatchers("/friendsData").hasAnyRole("ADMIN", "USER")
                .antMatchers("/friendData/**").hasAnyRole("ADMIN", "USER")

                .and()
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/connectedIndex")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/**");
    }

}
