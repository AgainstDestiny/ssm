package cn.itaxu.dao;

import cn.itaxu.domain.Brand;
import org.apache.ibatis.annotations.*;

import java.awt.print.Book;
import java.util.List;

/**
 * @Description: cn.itaxu.dao
 * @author: Axu
 * @date:2022/11/13 22:15
 */
public interface BrandDao {

    @Insert("insert into brand_test values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    public boolean save(Brand brand);

    @Delete("delete from brand_test where id = #{id}")
    public boolean deleteById(Integer id);

    @Delete("<script>delete from brand_test where id in <foreach collection='ids' item='id' " +
            "separator=',' open='(' close=')'>#{id}</foreach></script>")
    public boolean deleteMultiply(@Param("ids") int[] ids);

    @Update("update brand_test set brandName=#{brandName},companyName=#{companyName},ordered=#{ordered}," +
            "description=#{description},status=#{status} where id = #{id}")
    public boolean update(Brand brand);

    @Select("select * from brand_test where id = #{id}")
    public Brand getById(Integer id);

    @Select("select * from brand_test")
    public List<Brand> getAll();

    @Select("select * from brand_test limit #{begin} , #{size}")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    @Select("select count(*) from brand_test")
    int selectTotalCount();

    @Select("<script> select * from brand_test\n" +
            "        <where>\n" +
            "            <if test=\"brand.brandName != null and brand.brandName != ''\">\n" +
            "                and brandName like #{brand.brandName}\n" +
            "            </if>\n" +
            "            <if test=\"brand.companyName != null and brand.companyName != '' \">\n" +
            "                and companyName like #{brand.companyName}\n" +
            "            </if>\n" +
            "            <if test=\"brand.status != null\">\n" +
            "                and status=#{brand.status}\n" +
            "            </if>\n" +
            "        </where>\n" +
            "\n" +
            "        limit #{begin} , #{size}</script>")
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    @Select("<script>select count(*) from brand_test\n" +
            "        <where>\n" +
            "            <if test=\"brandName != null and brandName != ''\">\n" +
            "                and brandName like #{brandName}\n" +
            "            </if>\n" +
            "            <if test=\"companyName != null and companyName != '' \">\n" +
            "                and companyName like #{companyName}\n" +
            "            </if>\n" +
            "            <if test=\"status != null\">\n" +
            "                and status=#{status}\n" +
            "            </if>\n" +
            "        </where></script>")
    int selectTotalCountByCondition(Brand brand);

}
