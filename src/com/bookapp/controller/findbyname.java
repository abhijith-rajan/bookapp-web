package com.bookapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.model.*;
import com.bookapp.modelDAO.*;

@WebServlet("/findbyname")
public class findbyname extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		String name = request.getParameter("name");

		try {
			List<Books> books = dao.viewByName(name);
			RequestDispatcher rd = request.getRequestDispatcher("viewbyname.jsp");
			request.setAttribute("list", books);
			rd.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
