package mybatis.generator.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @ApiModel 注解用于实体类，表示对类进行说明，用于参数用实体类接收。
 * @ApiModelProperty 注解用于类中属性，表示对 model 属性的说明或者数据操作更改。
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
