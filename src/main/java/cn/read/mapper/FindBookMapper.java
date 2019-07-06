
  package cn.read.mapper;
  
  import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.read.dao.Book;
  
  public interface FindBookMapper { 
	  List<Book> findBook2(String biaoqian); 
	  List<Book> findBook(@Param("tableName")String tableName, @Param("comment_nums")Integer comment_nums,@Param("rating_nums")double rating_nums );
	  List<Book> findBookByTitle(String title);
	  int updateBookById(Book book);
	  Book findBookById(Integer id);
	  int deleteByid(Integer id);
	  List<Book> findAllBook();
	  List<Book> findAllGrade();
	  void saveUseAction(@Param("title")String title, @Param("username")String username,@Param("time") String time);
	  void saveUseActionByid(@Param("id")Integer id, @Param("username")String username,@Param("time") String time);
	  Integer getNumOfBq(@Param("biaoqian")String biaoqian,@Param("username")String username);
	  List<String> getListOfBQ(String username);
	  List<Book>recomBoo(@Param("biaoqian")String biaoqian, @Param("ts")int ts);
	  }
 