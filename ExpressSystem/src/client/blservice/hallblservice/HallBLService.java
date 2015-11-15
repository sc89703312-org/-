package client.blservice.hallblservice;

import client.ResultMessage;
import client.vo.logisticsvo.ArrivalReceiptVO;
import client.vo.logisticsvo.DeliverReceiptVO;
import client.vo.logisticsvo.TransferReceiptVO;

public interface HallBLService {

	public ResultMessage createArrivalReceipt(ArrivalReceiptVO vo);
	
	public ResultMessage createTransferReceipt(TransferReceiptVO vo);
	
	public ResultMessage createDeliverReceipt(DeliverReceiptVO vo);
}
