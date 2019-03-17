package servlet;
/**
 * Created by xcheng at 2019/3/10
 */

import bean.HouseInfo;
import service.HouseInfoService;
import util.Pagination;
import util.PaginationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@SuppressWarnings("deprecation")
public class MainServlet extends DelegateServlet {
    public String home(HttpServletRequest request, HttpServletResponse response) {
        HouseInfoService service = new HouseInfoService();
        Pagination pagination = PaginationUtil.createPagination(request,service.getTotal());
        List<HouseInfo> houseInfoList = service.list(pagination.getStart(), pagination.getCount());
        request.setAttribute("houses", houseInfoList);
        request.setAttribute("pagination", pagination);
        return "jsp/index.jsp";
    }
}
