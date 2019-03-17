package bean;

import lombok.Data;

/**
 * Created by xcheng at 2019/3/11
 */
@Data
public class HouseInfo {
    private Long id;
    private String description;
    private String location;
    private String high;
    private String year;
    private String orient;
    private Integer meter;
    private String totalPrice;
    private String zone;
    private String area;
    private String unitPrice;
}
