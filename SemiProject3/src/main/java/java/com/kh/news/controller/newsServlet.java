package com.kh.news.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.util.PageInfo;
import com.kh.news.service.NewsService;
import com.kh.semi.vo.news;

@WebServlet("/view/news")
public class newsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsService service = new NewsService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 1;
		PageInfo pageInfo = null;
		List<news> list = null;

		try {
			if (req.getParameter("page") != null) {
				page = Integer.parseInt(req.getParameter("page"));
			}
			int listCount = service.newsCount();
			pageInfo = new PageInfo(page, 10, listCount, 10);
			String newsSearchText = req.getParameter("search_text");
			if (newsSearchText != null && newsSearchText.length() > 0) {
				
				list = service.searchNews(pageInfo, newsSearchText);
				req.setAttribute("newsSearchText", newsSearchText);
				
			} else {
				
				list = service.getAllNewsList(pageInfo);
				req.setAttribute("newsSearchText", "");
			}
			req.setAttribute("pageInfo", pageInfo);
			req.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/view/news.jsp").forward(req, resp);
	}

}
