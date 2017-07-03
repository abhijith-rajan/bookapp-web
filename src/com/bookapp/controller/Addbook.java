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


@WebServlet("/Addbook")
public class Addbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("BOOK ADDED SUCCESSFULLY.. ");
		 * response.se
		 */
		PrintWriter out = response.getWriter();

		String s = request.getParameter("author");
		//int id = Integer.parseInt(s);
		String name = request.getParameter("name");
		String p = request.getParameter("price");
		int price = Integer.parseInt(p);
		Books book = new Books();
		book.setAuthor(s);
		//book.setBookid(id);
		book.setName(name);
		book.setPrice(price);
		BookDAO dao = new BookDAO();
		try {
			dao.add(book);
			request.getRequestDispatcher("home.jsp").include(request, response);
			out.print("You are successfully Added a book!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("Failure.jsp");

			e.printStackTrace();
		}

	}

}
