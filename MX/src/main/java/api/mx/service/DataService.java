package api.mx.service;

import api.mx.data.*;

public class DataService {

  public BalanceVO getBalanceInfo(AccountVO accountVO) {
    return new BalanceVO();
  }

  public BalanceVO getAccountInfo(AccountVO accountVO) {
    return new BalanceVO();
  }

  public ExchangeInfoVO getExchangeInfo(CurrencyRequestVO currencyRequestVO) {
    return new ExchangeInfoVO();
  }

  public ExchangeGraphInfo getExchangeGraphInfo(CurrencyRequestVO currencyRequestVO){
    return new ExchangeGraphInfo();
  }

}
