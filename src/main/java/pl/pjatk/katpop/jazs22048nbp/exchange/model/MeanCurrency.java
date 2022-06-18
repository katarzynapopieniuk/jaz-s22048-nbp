package pl.pjatk.katpop.jazs22048nbp.exchange.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ApiModel
public class MeanCurrency {

    @ApiModelProperty(value = "unique id of the mean currency")
    private Integer id;
    @ApiModelProperty(value = "currency code")
    private String currencyCode;
    @ApiModelProperty(value = "date of the first day the mean was calculated for")
    private String startDate;
    @ApiModelProperty(value = "date of the last day the mean was calculated for")
    private String endDate;
    @ApiModelProperty(value = "time of request")
    private String timeStamp;
    @ApiModelProperty(value = "calculated mean")
    private Double mean;
}
