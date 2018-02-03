package api.mx.data;

import lombok.Data;

@Data
public class CurrencyRequestVO {

  private String fromCurrency;
  private String toCurrency;
}
