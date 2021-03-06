package com.greatmooc.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greatmooc.domain.fileUploadStatus;



@SuppressWarnings("serial")
public class ProgressBarServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		fileUploadStatus status = (fileUploadStatus) session.getAttribute("status");
		try {
			response.reset();
			response.getWriter().write(
					"{\"pBytesRead\":"
					+status.getPBytesRead()+",\"pContentLength\":"+status.getPContentLength()+"}");
		System.out.println("{\"pBytesRead\":"
				+status.getPBytesRead()+",\"pContentLength\":"+status.getPContentLength()+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.doPost(request,response);
	}
}
