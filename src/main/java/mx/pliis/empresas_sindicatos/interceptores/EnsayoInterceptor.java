package mx.pliis.empresas_sindicatos.interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class EnsayoInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		Código original: return HandlerInterceptor.super.preHandle(request, response, handler);

		log.info("Pre Handle:  " + request.getRequestURL().toString());
		log.info(request.getMethod());

		return true;// Si devuelvo false, no continúa la cadena de llamadas
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		log.info("Post Handle: " + request.getRequestURL().toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		log.info("Request and Response. After Completion: " + request.getRequestURL().toString());
	}

}
