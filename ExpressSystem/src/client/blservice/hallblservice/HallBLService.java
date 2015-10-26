package client.blservice.hallblservice;

import client.ResultMessage;
import client.vo.arrivalreceiptvo.ArrivalReceiptVO;
import client.vo.deliverreceiptvo.DeliverReceiptVO;
import client.vo.transferreceiptvo.TransferReceiptVO;

public interface HallBLService {

	public ResultMessage createArrivalReceipt(ArrivalReceiptVO vo);
	
	public ResultMessage createTransferReceipt(TransferReceiptVO vo);
	
	public ResultMessage createDeliverReceipt(DeliverReceiptVO vo);
}
