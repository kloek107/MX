package api.mx.presentation;

import api.mx.data.CurrencyRequestVO;
import api.mx.data.ExchangeGraphInfo;
import api.mx.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/exchange")
public class ExchangeController {

  @Autowired
  private ExchangeService exchangeService;

  @GetMapping(
          value = "/s"
  )
  @ResponseBody
  public ExchangeGraphInfo getExchangeGraph(CurrencyRequestVO currencyRequestVO){
    return exchangeService.getExchangeGraphInfo(currencyRequestVO);
  }

}
