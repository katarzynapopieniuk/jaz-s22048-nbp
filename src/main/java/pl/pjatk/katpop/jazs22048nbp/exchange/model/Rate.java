package pl.pjatk.katpop.jazs22048nbp.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Rate{
    private String no;
    private String effectiveDate;
    private double mid;
}
