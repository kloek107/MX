package api.mx.configuration;

import api.mx.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MXAPIServiceConfiguration {

  @Bean(name = "AccountService")
  AccountService getAccountService(){
    return new AccountService();
  }

  @Bean(name = "TransactionService")
  TransactionService getTransactionService(){
    return new TransactionService();
  }

  @Bean(name = "ValidationService")
  ValidationService getValidationService(){
    return new ValidationService();
  }

  @Bean(name = "ExchangeService")
  ExchangeService getExchangeService(){
    return new ExchangeService();
  }

  @Bean(name = "dataService")
  DataService getDataService(){
    return new DataService();
  }
}
