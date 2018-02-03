package api.mx.data;

import lombok.Data;

@Data
public class ExchangeInfoVO {

  private String fromCurrency;
  private String toCurrency;

  private double fromOverToRate;
}
