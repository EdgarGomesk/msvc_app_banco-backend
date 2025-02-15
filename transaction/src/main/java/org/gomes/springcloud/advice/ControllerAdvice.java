package org.gomes.springcloud.advice;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice(annotations = RestController.class)
public class ControllerAdvice {


}
