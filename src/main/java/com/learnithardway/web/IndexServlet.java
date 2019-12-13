package com.learnithardway.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.h2.command.ddl.DeallocateProcedure;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ApplicationContext applicationContext;

	@Override
	public void init() throws ServletException {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WineService wineService = applicationContext.getBean(WineService.class);
		List<String> wines = new ArrayList<>();
		List<WineDetail> listOfWines = wineService.getListOfWines();
		request.setAttribute("wines", listOfWines);
		request.getRequestDispatcher("wines.jsp").forward(request, response);
	}

}
