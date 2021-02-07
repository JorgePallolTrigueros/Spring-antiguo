/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.config;

import com.pallol.novela.service.UsuarioPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioPersonaService usuarioPersonaService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/muestraNovela/**").permitAll()
                .antMatchers("/registro").permitAll()
                .antMatchers("/muestraNovelaPaginada/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/index", true)
                .failureUrl("/login?error=true")
                .usernameParameter("codigo")
                .passwordParameter("passwd")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
//        authorizeRequests()
//                .antMatchers("/muestraNovela/**").permitAll()
//                .antMatchers("/detalleNovela/**").permitAll()
//                .anyRequest().authenticated()
//                .and().csrf().disable()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/index", true)
//                .failureUrl("/login?error=true")
//                .usernameParameter("codigo")
//                .passwordParameter("passwd")
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/").and().exceptionHandling()
//                .accessDeniedPage("/access-denied");

    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/*.jpg", "/*.css", "/*.png", "/portada/*.jpg");
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("pallol").password("1").roles("BASICO");
        auth.userDetailsService(usuarioPersonaService);
    }
}
