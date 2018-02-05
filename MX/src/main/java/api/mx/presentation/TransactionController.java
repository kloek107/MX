package api.mx.presentation;

import api.mx.data.*;
import api.mx.service.TransactionService;
import api.mx.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController(value = "/transaction")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @Autowired
  private ValidationService validationService;

  @GetMapping(value = "/transaction/exchange")
  @ResponseBody
  public Response exchangeCurrency(Context context, AccountVO accountVO, TransactionVO transactionVO, CurrencyRequestVO currencyRequestVO) {
    try {
      validationService.validate(context);
    } catch (Exception e) {
      return Response.status(403).build();
    }

    try{
      transactionService.exchangeCurrency(accountVO, transactionVO, currencyRequestVO);
      return Response.ok().build();
    } catch (Exception e) {
      return Response.status(403).build();
    }
  }
}
