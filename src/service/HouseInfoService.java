package service;

import DAO.HouseInfoDAO;
import bean.HouseInfo;

import java.util.List;

/**
 * Created by xcheng at 2019/3/12
 */
public class HouseInfoService {
    private HouseInfoDAO dao = new HouseInfoDAO();

    public int getTotal() { return dao.getTotal();}
    public void add(HouseInfo bean) { dao.add(bean);}
    public void delete(long id) { dao.delete(id);}

    public List<HouseInfo> list(int start, int count) {return dao.list(start, count);}
    public List<HouseInfo> list() { return this.list(0, Short.MAX_VALUE);}
    public List<HouseInfo> listInHome() {
        return this.list();
    }
}
