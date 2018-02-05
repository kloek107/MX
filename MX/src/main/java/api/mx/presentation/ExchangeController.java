package api.mx.presentation;

import api.mx.data.CurrencyRequestVO;
import api.mx.data.ExchangeGraphInfo;
import api.mx.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController(value = "/exchange")
public class ExchangeController {

  @Autowired
  private ExchangeService exchangeService;

  @GetMapping(
          value = "/exchange/graph"
  )
  @ResponseBody
  public Response getExchangeGraph(CurrencyRequestVO currencyRequestVO){
    return Response.ok(exchangeService.getExchangeGraphInfo(currencyRequestVO)).build();
  }

  @GetMapping(
          value = "/exchange/rate"
  )
  @ResponseBody
  public Response getExchangeRate(CurrencyRequestVO currencyRequestVO){
    return Response.ok(exchangeService.getCurrentExchangeRate(currencyRequestVO)).build();
  }


}
