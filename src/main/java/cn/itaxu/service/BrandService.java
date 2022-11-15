package cn.itaxu.service;

import cn.itaxu.domain.Brand;
import cn.itaxu.domain.PageBean;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: cn.itaxu.service
 * @author: Axu
 * @date:2022/11/13 22:15
 */
@Transactional
public interface BrandService {

    /**
     * 添加数据
     * @param brand
     * @return
     */
    public boolean save(Brand brand);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public boolean deleteById(Integer id);

    /**
     * 根据ids批量删除
     * @param ids
     * @return
     */
    public boolean deleteMultiply(@Param("ids") int[] ids);

    /**
     * 修改数据
     * @param brand
     * @return
     */
    public boolean update(Brand brand);

    /**
     * 查询单条
     * @param id
     * @return
     */
    public Brand getById(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<Brand> getAll();

    /**
     * 分页查询
      * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);
}
