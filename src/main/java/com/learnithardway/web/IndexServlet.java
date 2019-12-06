package com.learnithardway.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.h2.command.ddl.DeallocateProcedure;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private WineDao dao = new WineDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> wines = new ArrayList<>();
		List<WineDetail> listOfWines = dao.getListOfWines();
		request.setAttribute("wines", listOfWines);
		request.getRequestDispatcher("wines.jsp").forward(request, response);
	}

}
