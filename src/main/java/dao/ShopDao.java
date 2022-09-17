package dao;

import beans.Shop;
import java.sql.*;
import java.util.HashMap;

public class ShopDao {
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    public HashMap<String, Shop> getAllShopper()
    {
        HashMap<String,Shop> hm = new HashMap<>();
        String sql = "select * from tb_shoper";
        try
        {
            conn = DataSourceUtil.initConn();//获取数据库连接
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next())
            {
                Shop shop = new Shop();
                shop.setId(rs.getInt("id"));
                shop.setName(rs.getString("name"));
                shop.setAddress(rs.getString("address"));
                shop.setPhone(rs.getInt("phone"));
                hm.put(rs.getInt("id") + "", shop);
            }
            rs.close();
            stm.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DataSourceUtil.closeConn();
        }
        return hm;
    }
    //插入一本图书信息
    public void insertRecord(Shop shop, String sql)
    {
        try
        {
            conn = DataSourceUtil.initConn();
            ps = conn.prepareStatement(sql);
            System.out.println(conn);
            System.out.println(ps);
            ps.setInt(1,shop.getId());
            ps.setString(2,shop.getName());
            ps.setString(4,shop.getAddress());
            ps.setInt(3,shop.getPhone());
            int insertCount = ps.executeUpdate();
            if (insertCount != 0)
            {
                System.out.println("插入" + insertCount + "条数据");
            }
            else
            {
                System.out.println("插入失败！");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (ps != null)
            {
                try
                {
                    ps.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            DataSourceUtil.closeConn();
        }
    }
    public void updateAndDelete(String sql)
    {
        try
        {
            conn = DataSourceUtil.initConn();
            stm = conn.createStatement();
            int num = stm.executeUpdate(sql);
            if (num == 1)
            {
                System.out.println("一条记录删除/更新成功！");
            }
            else
            {
                System.out.println("一条记录删除/更新失败！");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeStatement(stm);
            DataSourceUtil.closeConn();
        }
    }
    public void deleteId(String id)
    {
        try
        {
            conn = DataSourceUtil.initConn();
            String sql = "delete from tb_shoper where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int insertCount = ps.executeUpdate();
            if (insertCount != 0)
            {
                System.out.println("删除" + insertCount + "条数据");
            }
            else
            {
                System.out.println("删除失败！");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }finally
        {
            if (ps != null)
            {
                try
                {
                    ps.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            DataSourceUtil.closeConn();
        }
    }
    private static void closeStatement(Statement statement)
    {
        try
        {
            if (null != statement)
            {
                statement.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
