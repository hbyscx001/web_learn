package DAO;

import bean.HouseInfo;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xcheng at 2019/3/11
 */
public class HouseInfoDAO {
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection();
             Statement s = c.createStatement()) {
            String sql = "SELECT COUNT(DISTINCT  id) FROM house";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(HouseInfo bean){
        String sql = "INSERT  INTO house (`id`,`description`,`location`,`high`,`year`,`orient`,`meter`,`total_price`,`zone`,`area`,`unit_price`)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setLong(1, bean.getId());
            ps.setString(2, bean.getDescription());
            ps.setString(3,bean.getLocation());
            ps.setString(4,bean.getHigh());
            ps.setString(5,bean.getYear().toString());
            ps.setString(6,bean.getOrient());
            ps.setInt(7,bean.getMeter());
            ps.setString(8,bean.getTotalPrice());
            ps.setString(9,bean.getZone());
            ps.setString(10,bean.getArea());
            ps.setString(11,bean.getUnitPrice());
            ps.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void delete(long id) {
        String sql = "UPDATE house WHERE id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HouseInfo get(long id){
        HouseInfo bean = null;
        String sql = "select * from house where id=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                bean = getBean(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bean;
    }

    public List<HouseInfo> list(int start, int count) {
        String sql = "SELECT * FROM house.house  ORDER BY id DESC LIMIT ?,?";
        List<HouseInfo> houseInfoList = new ArrayList<HouseInfo>();
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                houseInfoList.add(getBean(rs));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return houseInfoList;
    }

    private HouseInfo getBean(ResultSet rs) throws SQLException {
        HouseInfo bean = new HouseInfo();
        bean.setId(rs.getLong("id"));
        bean.setDescription(rs.getString("descript"));
        bean.setLocation(rs.getString("location"));
        bean.setHigh(rs.getString("high"));
        bean.setYear(rs.getString("year"));
        bean.setOrient(rs.getString("orient"));
        bean.setMeter(rs.getInt("meters"));
        bean.setTotalPrice(rs.getString("total_price"));
        bean.setZone(rs.getString("zone"));
        bean.setUnitPrice(rs.getString("unit_price"));
        bean.setArea(rs.getString("xiaoqu_name"));
        return bean;
    }
}
