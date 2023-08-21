package com.trybe.acc.java.iocdi.sistemapagamentos.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    final RestritoPagamento restritoPagamento =
        ((HandlerMethod) handler).getMethod().getAnnotation((RestritoPagamento.class));

    if (restritoPagamento != null) {
      response.addHeader("Interceptor", "Pagamento interceptado");
      return true;
    } else {
      return false;
    }

  }

}