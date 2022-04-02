package mybatis.generator.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @ApiModel 注解用于实体类，表示对类进行说明，用于参数用实体类接收。
 * @ApiModelProperty 注解用于类中属性，表示对 model 属性的说明或者数据操作更改。
 */

@Data
@ApiModel(value = "car实体类")
public class Teslacar {
    @Id
    @ApiModelProperty(value = "car的id")
    private Integer carid;

    @ApiModelProperty(value = "car的名称")
    private String cartitle;

    @ApiModelProperty(value = "car的链接图片地址")
    private String carimgurl;

    @ApiModelProperty(value = "car的配置信息")
    private String carconfig;

    public Teslacar() {
    }

    public Teslacar(Integer carid, String cartitle, String carimgurl, String carconfig) {
        this.carid = carid;
        this.cartitle = cartitle;
        this.carimgurl = carimgurl;
        this.carconfig = carconfig;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCartitle() {
        return cartitle;
    }

    public void setCartitle(String cartitle) {
        this.cartitle = cartitle == null ? null : cartitle.trim();
    }

    public String getCarimgurl() {
        return carimgurl;
    }

    public void setCarimgurl(String carimgurl) {
        this.carimgurl = carimgurl == null ? null : carimgurl.trim();
    }

    public String getCarconfig() {
        return carconfig;
    }

    public void setCarconfig(String carconfig) {
        this.carconfig = carconfig == null ? null : carconfig.trim();
    }
}
