package com.bookapp.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.model.*;
import com.bookapp.modelDAO.*;


@WebServlet("/findbyprice")
public class findbyprice extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		String a = request.getParameter("min");
		String b = request.getParameter("max");
		int min = Integer.parseInt(a);
		int max = Integer.parseInt(b);
		try {
			List<Books> books = dao.viewByPrice(min, max);

			RequestDispatcher rd = request.getRequestDispatcher("viewbyprice.jsp");
			request.setAttribute("list", books);

			rd.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
