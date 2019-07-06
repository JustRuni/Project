
package cn.read.service;

import java.util.List;

import cn.read.dao.Book;
import cn.read.dao.Page;

/*查找数据： 通过关键字搜索并对查询到的数据按照评分进行排序*/

public interface FindBookService {
	
	List<Book> findBook(String tableName);
	Page getItemList(String tableName, Integer commentNums,double ratingNums);
	
	Page getItemListAndShow(int page, int rows,String biaoqian);
}
