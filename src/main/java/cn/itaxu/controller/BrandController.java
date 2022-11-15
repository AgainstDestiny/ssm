package cn.itaxu.controller;

import cn.itaxu.domain.Brand;
import cn.itaxu.domain.PageBean;
import cn.itaxu.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

/**
 * @Description: cn.itaxu.controller
 * @author: Axu
 * @date:2022/11/13 22:16
 */
@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public Result save(@RequestBody Brand brand){
        boolean flag = brandService.save(brand);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean flag = brandService.deleteById(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @DeleteMapping
    public Result deleteMultiply(@RequestBody int[] ids){
        boolean flag = brandService.deleteMultiply(ids);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody Brand brand){
        System.out.println(brand);
        boolean flag = brandService.update(brand);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Brand brand = brandService.getById(id);
        Integer code =brand != null ? Code.GET_OK:Code.GET_ERR;
        String msg = brand != null ? "success":"fail";
        return new Result(code,brand,msg);
    }

    @GetMapping
    public Result getAll(){
        List<Brand> brandList = brandService.getAll();
        Integer code = brandList != null ? Code.GET_OK:Code.GET_ERR;
        String msg = brandList != null ? "success":"fail";
        return new Result(code,brandList,msg);
    }

//    @GetMapping("/{currentPage}/{pageSize}")
//    public Result selectByPage(@PathVariable int currentPage,@PathVariable int pageSize) {
//        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
//        Integer code = pageBean != null ? Code.GET_OK:Code.GET_ERR;
//        String msg = pageBean != null ? "success":"fail";
//        return new Result(code,pageBean,msg);
//    }

    @PostMapping("/{currentPage}/{pageSize}")
    public Result selectByPageAndCondition(@PathVariable int currentPage,@PathVariable int pageSize,
                                           @RequestBody Brand brand) {
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);
        Integer code = pageBean != null ? Code.GET_OK:Code.GET_ERR;
        String msg = pageBean != null ? "success":"fail";
        return new Result(code,pageBean,msg);
    }


}
