
package cn.read.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.read.dao.Book;
import cn.read.dao.Page;
import cn.read.mapper.FindBookMapper;
import cn.read.service.FindBookService;
import cn.read.util.CommonUtil;

@Service
public class FindBookServiceImpl /* implements FindBookService */ {

	@Autowired
	private FindBookMapper findBookMapper;

	/*
	 * public List<Book> findBook(String tableName) { List<Book> book = new
	 * ArrayList<Book>(); if (!CommonUtil.isEmpty(tableName)) { book =
	 * findBookMapper.findBook2(tableName); return book; } return book; }
	 */

	public Page getItemList(String biaoqian, Integer commentNums,double ratingNums) {
		int page = 1;
		int rows =10;
		PageHelper.startPage(page,rows);
		List<Book> book = findBookMapper.findBook(biaoqian,commentNums,ratingNums);
		/*
		 * session = request.getSession(); session.setAttribute("book", book);
		 */
		Page result = new Page();
		result.setRows(book);
		PageInfo<Book> pageInfo = new PageInfo<Book>(book);
		result.setTatal(pageInfo.getTotal());
		return result;
	}
	
	//根据标签筛选图书
	public Page getItemListAndShow(int page, int rows,String biaoqian) {
		
		  PageHelper.startPage(page,rows);
		  List<Book> booklist = findBookMapper.findBook2(biaoqian); 
		
		  System.out.println(booklist.get(0));
		  Page result = new Page();
		  result.setRows(booklist); 
		  PageInfo<Book> pageInfo = new PageInfo<Book>(booklist); 
		  result.setTatal(pageInfo.getTotal()); 
		return  result;
		
	}

	public List<Book> Booklist(String biaoqian){
		PageHelper.startPage(1, 10);
		return findBookMapper.findBook2(biaoqian);
	}

	public List<Book> findBookByTitle(String title) {
		List<Book> list = findBookMapper.findBookByTitle(title);
		return list;
	}

	public boolean editBookByid(Book book) {
		if(findBookMapper.updateBookById(book)==1) {
			return true;
		}
		else 
			return false;
		
	}

	public Book findBookByid(Integer id) {
		
		Book book = findBookMapper.findBookById(id);
		return book;
	}

	public boolean deleteBook(Integer id) {
		if(1==findBookMapper.deleteByid(id))
		return true;
		else return false;
	}

	public List<Book> findAllbook(int page,int size) {
		PageHelper.startPage(page,size);
		List<Book> list = findBookMapper.findAllBook();
		return list;
	}

	public List<Book> findBookGrade(int page, int size) {
		PageHelper.startPage(page,size);
		List<Book> list = findBookMapper.findAllGrade();
		return list;
	}

	
	  public void saveAction(String title) { 
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		  String username = authentication.getName(); 
		  Date date = new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  String time = sdf.format(date);
		  findBookMapper.saveUseAction(title,username,time);
	 }

	public void saveActionByid(Integer id) {
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		  String username = authentication.getName(); 
		  Date date = new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  String time = sdf.format(date);
		  findBookMapper.saveUseActionByid(id,username,time);
	}
	
	//图书推荐
	//根据数量进行推荐
	public List<Book> RecommendBook() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		String username = authentication.getName(); 
		double sum = 0;
		List<Book> listBook = new ArrayList<Book>();
		//将图书类型和访问次数形成键值对存入map里面
		HashMap<String, Integer> userHistory = new HashMap<String, Integer>();
		List<String> listBQ = new ArrayList<String>();
		//获取所有的图书类型
		listBQ = findBookMapper.getListOfBQ(username);
		for(int i =0;i < listBQ.size();i++) {
			userHistory.put(listBQ.get(i),findBookMapper.getNumOfBq(listBQ.get(i),username));
		}
		for(int j = 0 ;j < userHistory.size();j++) {
			sum = sum+userHistory.get(listBQ.get(j));
		}
		
		for(int i= 0 ;i<listBQ.size();i++) {
			double x= userHistory.get(listBQ.get(i));
			double  s = x/sum;
			int ts = (int) (s*10);
			listBook.addAll((findBookMapper.recomBoo(listBQ.get(i),ts)));
		}
		return listBook;
		
	}

	
	
}
