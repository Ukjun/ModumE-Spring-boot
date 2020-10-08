package com.amolrang.modume.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.amolrang.modume.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("권한접근승인여부");
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] guest = { "/", "/main", "/login", "/join" };
		String loginPage = "/login";
		String loginProcessingUrl = "/loginAction";
		String mainPage = "/";

		http.authorizeRequests().antMatchers(guest).permitAll() // 게스트 접근 페이지
				.and().formLogin().loginPage(loginPage).loginProcessingUrl(loginProcessingUrl).permitAll() // 로그인페이지
				.and().logout().logoutSuccessUrl(mainPage).invalidateHttpSession(true).permitAll() // 로그아웃 후 돌아가는 페이지
				.and().authorizeRequests().antMatchers("/admin").hasRole("ADMIN") // 권한 접근 페이지
				.and().exceptionHandling().accessDeniedPage(mainPage)// 기타 애러시 메인페이지로 보내버림
				.and().csrf().disable();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
