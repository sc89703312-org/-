package client.blservice.hallblservice;

import java.util.ArrayList;

import client.ResultMessage;
import client.vo.hallvo.ArrivalReceiptVO;
import client.vo.hallvo.DeliverReceiptVO;
import client.vo.hallvo.TransferReceiptVO;

public interface HallBLService {

	public ResultMessage createArrivalReceipt(ArrivalReceiptVO vo);
	
	public ResultMessage createTransferReceipt(TransferReceiptVO vo);
	
	public ResultMessage createDeliverReceipt(DeliverReceiptVO vo);
	
	public ArrayList<ArrivalReceiptVO> viewAllArrival();
	
	public ArrayList<TransferReceiptVO> viewAllTransfer();
	
	public ArrayList<DeliverReceiptVO> viewAllDeliver();
	
}
