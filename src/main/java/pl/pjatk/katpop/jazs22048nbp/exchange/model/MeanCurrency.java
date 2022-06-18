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
    @ApiModelProperty(value = "unique id of the mean currency")
    private Integer id;
    @ApiModelProperty(value = "currency code")
    private String currencyCode;
    @ApiModelProperty(value = "date of the first day the mean was calculated for")
    private String startDate;
    @ApiModelProperty(value = "date of the last day the mean was calculated for")
    private String endDate;
    @ApiModelProperty(value = "date and time of request")
    private String timeStamp;
    @ApiModelProperty(value = "calculated mean")
    private Double mean;
}
