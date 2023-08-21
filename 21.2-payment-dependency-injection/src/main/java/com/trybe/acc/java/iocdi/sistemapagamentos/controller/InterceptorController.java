package com.trybe.acc.java.iocdi.sistemapagamentos.controller;

import com.trybe.acc.java.iocdi.sistemapagamentos.interceptor.RestritoPagamento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Interceptor controller.
 */
@RequestMapping("/middleware")
@RestController
public class InterceptorController {

  /**
   * Com.
   */
  @RestritoPagamento
  @GetMapping("/com-interceptor")
  public void com() {
  }


  /**
   * Sem.
   */
  @GetMapping("/sem-interceptor")
  public void sem() {
  }
}
