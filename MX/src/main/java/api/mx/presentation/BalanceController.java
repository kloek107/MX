package api.mx.presentation;

import api.mx.data.AccountVO;
import api.mx.data.BalanceVO;
import api.mx.data.Context;
import api.mx.service.AccountService;
import api.mx.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;


@RestController(value = "/account")
public class BalanceController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private ValidationService validationService;

  @GetMapping
          (
                  value = "/account/balance",
                  produces = "application/json"
          )
  @ResponseBody
  public Response getBalance(Context context, AccountVO accountVO) {
    try {
      validationService.validate(context);
    } catch (Exception e) {
      return Response.status(HttpStatus.FORBIDDEN.value()).entity(BalanceVO.class).build();
    }
    try {
      return Response.ok(accountService.getBalance(accountVO)).build();
    } catch (Exception e) {
      return Response.status(HttpStatus.FORBIDDEN.value()).entity(BalanceVO.class).build();
    }
  }
}
