package pl.sda.carrentalmanager.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ClientControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView handleException(RuntimeException exception) {
        ModelAndView exceptionModelAndView = new ModelAndView("exception");
        exceptionModelAndView.addObject("message", exception.getMessage());
        return exceptionModelAndView;
    }
}