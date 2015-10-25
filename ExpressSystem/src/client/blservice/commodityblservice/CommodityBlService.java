package client.blservice.commodityblservice;

import java.util.ArrayList;

import client.ResultMessage;
import client.vo.commodityvo.ComGoodsVO;
import client.vo.commodityvo.ComZoneVO;
import client.vo.commodityvo.EnterReceiptVO;
import client.vo.commodityvo.ExitReceiptVO;
import client.vo.stationvo.*;

public interface CommodityBlService {

	public void remindEnter(ArriveReceiptVO vo);
	public void remindExit(TransferReceiptVO vo);
	
	//��������
	public ArrayList<ArriveReceiptVO> showArriveReceiptList();
	public EnterReceiptVO showEnterReceipt(ArriveReceiptVO vo);
	public ResultMessage editEnterReceipt(EnterReceiptVO vo, String orderID, String location);
	public void subEnterReceipt(EnterReceiptVO vo);
	
	//���������
	public ArrayList<TransferReceiptVO> showTransferReceipt();
	public ExitReceiptVO showExitReceipt(TransferReceiptVO vo);
	public void subExitReceipt(ExitReceiptVO vo);
	
	//����̵���鿴����
	public ArrayList<ComGoodsVO> showInventory();
	public void outputInventory(ArrayList<ComGoodsVO> list);
	public int[] showCheck(String start, String end);
	
    //����ʼ�����������
	public ComZoneVO showZone();
	public ResultMessage editZone(ComZoneVO vo, int[] space);
	public void subZone(ComZoneVO vo);
	
}
