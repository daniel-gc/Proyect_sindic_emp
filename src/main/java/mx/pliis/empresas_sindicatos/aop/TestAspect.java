package mx.pliis.empresas_sindicatos.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
public class TestAspect {

	@Before("@within(org.springframework.web.bind.annotation.RestController)")
	void printBefore(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();

		log.info("AOP. Antes del rest controller: " + request.getRequestURL().toString());
		log.info(
				"AOP. Nos llaman desde:" + request.getRemoteAddr() + " " + request.getRemoteHost() + " "
						+ request.getRemotePort());
	}

	@After("@within(org.springframework.web.bind.annotation.RestController)")
	void printAfter(JoinPoint joinPoint) {
		log.info("AOP. Después del rest controller");
	}


}
