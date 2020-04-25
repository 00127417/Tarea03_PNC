package com.uca.capas.tarea3.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/ingresar")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/resultado")
	public ModelAndView parametros4(@RequestParam String names, @RequestParam String lastnames, @RequestParam String date, @RequestParam String place, @RequestParam String school, @RequestParam String phone, @RequestParam String mobile) throws ParseException {
		ModelAndView mav = new ModelAndView();
		List<String> lista = new ArrayList<>();
		
		DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		Date convert = fecha.parse(date);
		Date auxDate = fecha.parse("2003-01-01");
		
		
		if(names.length() < 1 || names.length() > 25) {
			lista.add("Nombres: "+names);
		}
		if(lastnames.length() < 1 || lastnames.length() > 25) {
			lista.add("Apellidos: " + lastnames);
		}
		if(convert.before(auxDate)) {
			lista.add("Fecha de nacimiento: " + date);
		}
		
		if(place.length() < 1 || place.length() > 25) {
			lista.add("Lugar de nacimiento: " + place);
		}
		if(school.length() < 1 || school.length() > 100) {
			lista.add("Instituto o colegio de procedencia: " + school);
		}
		if(phone.length() != 8) {
			lista.add("Telefono fijo: " + phone);
		}
		if(mobile.length() != 8) {
			lista.add("Telefono movil: " + mobile);
		}
		
		if(lista.size() != 0) {
			mav.addObject("list", lista);
			mav.setViewName("/error");
			return mav;
		}
		
		mav.setViewName("/resultado");
		
		return mav;
	}
}
