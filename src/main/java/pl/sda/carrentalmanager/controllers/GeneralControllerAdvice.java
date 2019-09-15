package pl.sda.carrentalmanager.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carrentalmanager.exceptions.ItemNotFoundException;

@ControllerAdvice
public class GeneralControllerAdvice {
    @ExceptionHandler(value = ItemNotFoundException.class)
    public ModelAndView handleException(ItemNotFoundException exception) {
        ModelAndView exceptionModelAndView = new ModelAndView("exception");
        exceptionModelAndView.addObject("message", exception.getMessage());
        return exceptionModelAndView;
    }
}
