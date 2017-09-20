package com.sales.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.sales.exceptions.OrderException;

@ControllerAdvice
public class ExceptionController{
	@ExceptionHandler(OrderException.class)
	  public ModelAndView handleError(HttpServletRequest req, OrderException ex) {
	    System.out.println("Request: " + req.getRequestURL() + " raised " + ex);

	    ModelAndView mav = new ModelAndView("errorMessage");
	    mav.addObject("name", ex.getClass().getSimpleName());
	    mav.addObject("message", ex.getMessage());
	    mav.addObject("pid", ex.getPid());
	    mav.addObject("cid", ex.getCid());
	    mav.addObject("qty", ex.getQty());
	    
	    return mav;
	  }
}