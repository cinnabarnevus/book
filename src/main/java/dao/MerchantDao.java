package dao;
import beans.Merchant;
import java.sql.*;
import java.util.HashMap;

public class MerchantDao {
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    public HashMap<String, Merchant> getAllMerchant() throws SQLException {
        HashMap <String,Merchant> hm= new HashMap<>();
        String sql = "select * from tb_merchant";
        conn = ConnectionPool.getConn();
        stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        while (rs.next()){
            Merchant merchant = new Merchant();
            merchant.setName(rs.getString("name"));
            merchant.setPassword(rs.getString("password"));
            hm.put(rs.getString("name") + "",merchant);
        }
        rs.close();
        return hm;
    }
    public void insertMerchant(Merchant merchant, String sql)
    {
        try
        {
            conn = ConnectionPool.getConn();
            ps = conn.prepareStatement(sql);
            System.out.println(conn);
            System.out.println(ps);
            ps.setString(1, merchant.getName());
            ps.setString(2, merchant.getPassword());
            int insertCount = ps.executeUpdate();
            if (insertCount == 0)
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
}
