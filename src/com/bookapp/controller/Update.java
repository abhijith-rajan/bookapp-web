package com.bookapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.model.*;
import com.bookapp.modelDAO.*;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		String pri = request.getParameter("price");
		int price = Integer.parseInt(pri);
		Books book = new Books();
		book.setBookid(id);
		book.setPrice(price);
		BookDAO dao = new BookDAO();
		try {
			dao.changePrice(book);
			request.getRequestDispatcher("home.jsp").include(request, response);
			out.print("You are successfully updated price!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
