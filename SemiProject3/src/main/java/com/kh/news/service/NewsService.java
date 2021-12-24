package com.kh.news.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.common.util.PageInfo;
import com.kh.semi.DAO.NewsDAO;
import com.kh.semi.vo.news;


public class NewsService {

	private NewsDAO dao = new NewsDAO();
	
	public List<news> getAllNewsList(PageInfo pageInfo){
		Connection conn = getConnection();
		List<news> newsList = dao.sellectAll(conn, pageInfo, null);
		close(conn);
		return newsList;
	}

	public List<news> searchNews(PageInfo pageInfo, String keyword){
		Connection conn = getConnection();
		List<news> newsList = dao.sellectAll(conn, pageInfo, keyword);
		close(conn);
		return newsList;
	}
	public int newsCount(){
		Connection conn = getConnection();
		int result = dao.newsCount(conn);
		close(conn);
		return result;
	}
		
}

