package com.cos.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.project.config.auth.PrincipalDetail;
import com.cos.project.config.auth.PrincipalDetailService;
//빈등록: 스프링 컨테이너에서 객체를 관리할수있게해준다
@Configuration //빈등록 loc관리
@EnableWebSecurity //시큐리티 필터가 등록 설정을 여기서
@EnableGlobalMethodSecurity(prePostEnabled =true) //특정주소로접근
public class Securityconfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean //ioC가 된다.
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()//csrf 토큰 비활성화 (테스트시 걸어두는게 좋음)
			.authorizeRequests()
			.antMatchers("/","/auth/**/","/js/**","/css/**","/image/**" )
			.permitAll()
			
			.anyRequest() //이게 아닌 다른 모든 요청은
			.authenticated() //인증이 필요
		.and()
			.formLogin()
			.loginPage("/auth/loginForm")
			.loginProcessingUrl("/auth/loginProc") //실제 페이지은 없으나 해당 url을 중간에 가로채서 실행한다.
			//스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 한다.
			//가로채서 로그인 할때 그때 만들어야할 클래스가있다
			//userdetails타입의 user오브젝트를 만들어 줘야한다
			//user 오브젝트 타입을 맞춰줘야 가로챌수있다.
		
		.defaultSuccessUrl("/");
	
		//로그인 성공후에 요청되는 페이지
		//.failureUrl("로그인 실패 후 요청페이지")


         
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
		//패스워드 인코더가 encodePWD라는 것을 null자리의 오브젝트에게 알려줘야한다.
	}

}
