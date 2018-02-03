package api.mx.service;

import api.mx.data.AccountVO;
import api.mx.data.BalanceVO;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {

  @Autowired
  private DataService dataService;

  public BalanceVO getBalance(AccountVO accountVO) {

    // get balance from DB

    return dataService.getBalanceInfo(accountVO);
  }

}
