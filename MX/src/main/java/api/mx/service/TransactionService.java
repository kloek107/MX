package api.mx.service;

import api.mx.data.AccountVO;
import api.mx.data.CurrencyRequestVO;
import api.mx.data.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionService {

  @Autowired
  private AccountService accountService;

  @Autowired
  private ExchangeService exchangeService;

  @Autowired
  private DataService dataService;

  public void exchangeCurrency(AccountVO accountVO, TransactionVO transactionVO, CurrencyRequestVO currencyRequestVO) {
    processTransaction(accountVO, transactionVO, currencyRequestVO);
    }

  private void processTransaction(AccountVO accountVO, TransactionVO transactionVO, CurrencyRequestVO currencyRequestVO) {

    double rate = exchangeService.getCurrentExchangeRate(currencyRequestVO).getFromOverToRate();


    try {
      validateTransaction(accountVO, transactionVO, rate);

      //    DB to change the shizzle
    } catch (Exception e){
    }
  }

  private void validateTransaction(AccountVO accountVO, TransactionVO transactionVO, double rate) throws InvalidTransactionException {
    double balance = accountService.getBalance(accountVO).getBalance();
    double transaction = transactionVO.getValue();

    if (accountVO.getAccountNumber().equals(transactionVO.getFrom())){
      throw new InvalidTransactionException("temp");
    }

    AccountVO toAccountVO = new AccountVO();
    toAccountVO.setAccountNumber(transactionVO.getTo());

    if (!dataService.getAccountInfo(toAccountVO).getAccountNumber().equals(transactionVO.getTo())){
      throw new InvalidTransactionException("temp");
    }

    if (transaction*rate > balance){
      throw new InvalidTransactionException("Not enough balance");
    }

    // check if transactionVO.getFrom and transactionVO.getTo are valid -> from DB
  }

  private class InvalidTransactionException extends Exception {
    InvalidTransactionException() {
    }
    InvalidTransactionException(String message) {
      super(message);
    }
  }

}
