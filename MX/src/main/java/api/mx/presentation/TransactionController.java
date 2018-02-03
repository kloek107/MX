package api.mx.presentation;

import api.mx.data.*;
import api.mx.service.TransactionService;
import api.mx.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/transaction")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @Autowired
  private ValidationService validationService;

  @GetMapping(value = "/exchange")
  @ResponseBody
  public void exchangeCurrency(Context context, AccountVO accountVO, TransactionVO transactionVO, CurrencyRequestVO currencyRequestVO) {
    validationService.validate(context);
    transactionService.exchangeCurrency(accountVO, transactionVO, currencyRequestVO);
  }
}
