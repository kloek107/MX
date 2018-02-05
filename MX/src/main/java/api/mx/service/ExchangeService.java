package api.mx.service;

import api.mx.data.CurrencyRequestVO;
import api.mx.data.ExchangeGraphInfo;
import api.mx.data.ExchangeInfoVO;
import org.springframework.beans.factory.annotation.Autowired;

public class ExchangeService {

  @Autowired
  private DataService dataService;

  public ExchangeGraphInfo getExchangeGraphInfo(CurrencyRequestVO currencyRequestVO) {
    return dataService.getExchangeGraphInfo(currencyRequestVO);
  }

  public ExchangeInfoVO getCurrentExchangeRate(CurrencyRequestVO currencyRequestVO) {
    return dataService.getExchangeInfo(currencyRequestVO);
  }
}
