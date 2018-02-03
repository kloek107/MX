package api.mx.data;

import lombok.Data;

@Data
public class TransactionVO {

  private double value;
  private double transactionID;
  private String from;
  private String to;

}
