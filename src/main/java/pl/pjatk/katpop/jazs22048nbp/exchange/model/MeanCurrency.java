package pl.pjatk.katpop.jazs22048nbp.exchange.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ApiModel
@Entity(name = "mean_currency")
public class MeanCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "unique id of the mean currency", example = "1")
    private Integer id;
    @ApiModelProperty(value = "currency code", example = "gbp")
    private String currencyCode;
    @ApiModelProperty(value = "date of the first day the mean was calculated for, format: yyyy-MM-dd", example = "2022-06-15")
    private String startDate;
    @ApiModelProperty(value = "date of the last day the mean was calculated for, format: yyyy-MM-dd", example = "2022-06-20")
    private String endDate;
    @ApiModelProperty(value = "date and time of request, format: yyy-MM-dd HH:mm:ss", example = "2022-06-18 11:00:00")
    private String timeStamp;
    @ApiModelProperty(value = "calculated mean", example = "5.44")
    private Double mean;
}
