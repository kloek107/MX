package api.mx.presentation;

import api.mx.data.AccountVO;
import api.mx.data.BalanceVO;
import api.mx.data.Context;
import api.mx.service.AccountService;
import api.mx.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/account")
public class BalanceController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private ValidationService validationService;

  @GetMapping(
          value = "/balance",
          produces = "application/json"
  )
  @ResponseBody
  public BalanceVO getBalance(Context context, AccountVO accountVO) {
    validationService.validate(context);
    return accountService.getBalance(accountVO);
  }
}
