package cn.itaxu.service.impl;

import cn.itaxu.dao.BrandDao;
import cn.itaxu.domain.Brand;
import cn.itaxu.domain.PageBean;
import cn.itaxu.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: cn.itaxu.service.impl
 * @author: Axu
 * @date:2022/11/13 22:16
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;
    
    @Override
    public boolean save(Brand brand) {
        return  brandDao.save(brand);
    }

    @Override
    public boolean deleteById(Integer id) {
        return brandDao.deleteById(id);
    }

    @Override
    public boolean deleteMultiply(int[] ids) {
        return brandDao.deleteMultiply(ids);
    }

    @Override
    public boolean update(Brand brand) {
        return brandDao.update(brand);
    }

    @Override
    public Brand getById(Integer id) {
        return brandDao.getById(id);
    }

    @Override
    public List<Brand> getAll() {
        return brandDao.getAll();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        int begin = (currentPage-1) * pageSize;
        int size = pageSize;
        List<Brand> rows = brandDao.selectByPage(begin, size);
        int totalCount = brandDao.selectTotalCount();
        PageBean<Brand> pageBean = new PageBean<Brand>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        int begin = (currentPage-1) * pageSize;
        int size = pageSize;

        // 处理模糊查询
        String brandName = brand.getBrandName();
        if (brandName!=null&&brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if (companyName!=null&&companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }

        // 查询当前页数据
        List<Brand> brandList = brandDao.selectByPageAndCondition(begin, size, brand);
        // 查询当前页总记录条数
        int totalCount = brandDao.selectTotalCountByCondition(brand);

        // 封装PageBean
        PageBean<Brand> pageBean = new PageBean<>(brandList,totalCount);
        return pageBean;
    }

}
