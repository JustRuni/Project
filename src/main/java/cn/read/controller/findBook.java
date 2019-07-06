package cn.read.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import cn.read.dao.Book;
import cn.read.dao.Page;
import cn.read.mapper.FindBookMapper;
import cn.read.service.impl.FindBookServiceImpl;

@Controller
@RequestMapping("/findbook")
public class findBook {
	@Autowired
	private FindBookServiceImpl findBookServiceImpl;

	/*
	 * @RequestMapping("/byserch") public ModelAndView findBookBySerch(String
	 * tablename) { ModelAndView mav = new ModelAndView(); List<Book> book =
	 * findBookServiceImpl.findBook(tablename); mav.addObject("book", book);
	 * mav.setViewName("index"); System.out.println(book); return mav; }
	 */
	@RequestMapping("/list")
	public ModelAndView getBookList(@RequestParam(name = "biaoqian", required = true) String biaoqian) {/* Integer page,Integer rows, */
		ModelAndView modelAndView = new ModelAndView();
		List<Book> booklist = findBookServiceImpl.Booklist(biaoqian);
		PageInfo pageInfo = new PageInfo(booklist);
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.setViewName("list-book");
		return modelAndView;
	}

	@RequestMapping("/show/{id}/{tname}") 
	public ModelAndView getBookList(@PathVariable int id,@PathVariable String biaoqian){  
		
	ModelAndView modelAndView = new ModelAndView(); 
	Page result = findBookServiceImpl.getItemListAndShow(id, 10,biaoqian);
	  modelAndView.addObject("result",result); 
	  modelAndView.setViewName("index");
	  return modelAndView; 
	  }
	
	//通过书名获取图书信息
	@RequestMapping("/findbookbyname")
	public ModelAndView findbookBy(@RequestParam(name="title",required=true)String title) {
		ModelAndView mv = new ModelAndView();
		List<Book> booklist = findBookServiceImpl.findBookByTitle(title);
		
		mv.addObject("booklist", booklist);
		mv.setViewName("list-book");
		return mv;
	}
	@RequestMapping("/findbookedit")
	public ModelAndView Findbookedit(Integer id) {
		ModelAndView mv = new ModelAndView();
		Book book = findBookServiceImpl.findBookByid(id);
		mv.addObject("book", book);
		mv.setViewName("book-edit");
		return mv;
	}
	
	
	
	//只有tom有权限操作
	//根据id修改图书信息
	@RequestMapping("/editbook")
	@PreAuthorize("authentication.principal.username=='方宾'")
	public ModelAndView editBook(Book book) {
		ModelAndView mv = new ModelAndView();
		Book book2=new Book();
		Integer id = book.getId();
		if(findBookServiceImpl.editBookByid(book))
		{	book2 = findBookServiceImpl.findBookByid(id);
			mv.addObject("book", book2);
			mv.setViewName("abook");
		}
		else {
			String str = "增添信息失误";
			mv.addObject("error",str );
			mv.setViewName("book-list");
		}
		return mv;
	}
	//查找某本书籍的详情
	@RequestMapping("/findBookById")
	public ModelAndView FindBookByid(Integer id){
		ModelAndView mv = new ModelAndView();
		Book book =findBookServiceImpl.findBookByid(id);
		findBookServiceImpl.saveActionByid(id);
		mv.addObject("book", book);
		mv.setViewName("abook");
		return mv;
	}
	@RequestMapping("/allbook")
	public ModelAndView Allbook(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
		ModelAndView mv = new ModelAndView();
		List<Book> allbook =findBookServiceImpl.findAllbook(page,size);
		PageInfo pageInfo = new PageInfo(allbook);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("list-book");
		return mv;
	}
	
	//只有管理员才能访问
	@RequestMapping("/deleteBookByid")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String DeleteBookByid(@RequestParam(name="id",required=true)Integer id){
		
		if(findBookServiceImpl.deleteBook(id)) {
			return "main";
		}
		else 
			return "error";
	}
	@RequestMapping("/findbookGrade")
	public ModelAndView FindbookGrade(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
		ModelAndView mv = new ModelAndView();
		List<Book> allbook=findBookServiceImpl.findBookGrade(page,size);
		PageInfo pageInfo = new PageInfo(allbook);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("list-book-grade");
		return mv;
	}
	@RequestMapping("/recom")
	public ModelAndView Recom() {
		ModelAndView mv = new ModelAndView();
		List<Book> listBook = findBookServiceImpl.RecommendBook();
		PageInfo pageInfo = new PageInfo(listBook);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("list-reco");
		return mv;
	}
		
}
