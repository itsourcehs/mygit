package com.evan.wj.controller;

import com.evan.wj.pojo.Book;
import com.evan.wj.service.BookService;
import com.evan.wj.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Classname LibraryController
 * @Description TODO
 * @Date 2021/7/1 11:06
 * @Created by 123456
 */
@Controller
public class LibraryController {
    @Resource
    BookService service;

    @GetMapping("/api/books")
    @ResponseBody
    public List<Book> list() throws Exception{
        return service.list();
    }

    @PostMapping("/api/books")
    @ResponseBody
    public Book addOrUpdate(@RequestBody Book book) throws Exception{
        service.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    @ResponseBody
    public void delete(@RequestBody Book book) throws Exception{
        service.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    @ResponseBody
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception{
        if(0 != cid){
            return service.listByCategory(cid);
        }else {
            return list();
        }
    }

    @GetMapping("/api/search")
    @ResponseBody
    public List<Book> searchResult(@RequestParam("keywords") String keywords){
        //关键字为空时查询出所有书籍
        if("".equals(keywords)){
            return service.list();
        }else {
            return service.Search(keywords);
        }
    }

    @PostMapping("/api/covers")
    @CrossOrigin
    @ResponseBody
    public String coversUpload(MultipartFile file) throws Exception{
        File imageFolder = new File("D:/workspace/img");
        //获取的是文件的完整名称，包括文件名称+文件拓展名
        String f1 = file.getOriginalFilename();
        String str = StringUtils.getRandomString(6);
        File f = new File(imageFolder,str +
                f1.substring(f1.length() - 4));
        if(!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }
}
