package edu.nju.express.presentation.commodityui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import edu.nju.express.blservice.CommodityBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.presentation.UIController;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;

public class CommodityController implements UIController{
	
	JPanel currentPanel;
	JFrame frame;
	
	CommodityBlService service;
	
	public CommodityController(JFrame frame){
		this.frame = frame;
		service = DataFactory.createCommodityBlInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println(e.getActionCommand());
		
		if(e.getActionCommand().equals("EnterManageUI")){
			
			ArrayList<ArriveReceiptVO> volist = service.showArriveReceiptList();
			
			frame.getContentPane().removeAll();
			currentPanel = new EnterManageUI(this,volist);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("ExitManageUI")){
			
			ArrayList<TransferReceiptVO> volist = service.showTransferReceiptList();
			
			frame.getContentPane().removeAll();
			currentPanel = new ExitManageUI(this,volist);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("ComInventoryUI")){
			
			ArrayList<ComGoodsVO> volist = service.showInventory();
			
			frame.getContentPane().removeAll();
			currentPanel = new ShowInventoryUI(this,volist);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("ComCheckUI")){
			
			frame.getContentPane().removeAll();
			currentPanel = new ShowCheckUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("ComAdjustUI")){
			
			frame.getContentPane().removeAll();
			currentPanel = new AdjustUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("createnter")){
			
			EnterManageUI ui = (EnterManageUI)((JButton)e.getSource()).getParent();
			ArriveReceiptVO vo = ui.getSelectReceipt();
			EnterReceiptVO enter = null;
			try {
				enter = service.showEnterReceipt(vo);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			frame.getContentPane().removeAll();
			currentPanel = new EnterSubUI(this,enter);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("createxit")){
			
			ExitManageUI ui = (ExitManageUI)((JButton)e.getSource()).getParent();
			TransferReceiptVO vo = ui.getSelectReceipt();
			ExitReceiptVO exit = null;
			try {
				exit = service.showExitReceipt(vo);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			frame.getContentPane().removeAll();
			currentPanel = new ExitSubUI(this,exit);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("subenter")){
			
			EnterSubUI ui = (EnterSubUI)(((JButton)e.getSource()).getParent());
			EnterReceiptVO vo = ui.getEnterReceipt();
			service.subEnterReceipt(vo);
			
			frame.getContentPane().removeAll();
			currentPanel = new EnterManageUI(this,service.showArriveReceiptList());
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("subexit")){
			
			ExitSubUI ui = (ExitSubUI)(((JButton)e.getSource()).getParent());
			ExitReceiptVO vo = ui.getExitReceipt();
			service.subExitReceipt(vo);
			
			frame.getContentPane().removeAll();
			currentPanel = new ExitManageUI(this,service.showTransferReceiptList());
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("movegoods")){
			
			ShowInventoryUI ui = (ShowInventoryUI)(((JButton)e.getSource()).getParent());
			ArrayList<ComGoodsVO> voList = ui.getList();
			
			frame.getContentPane().removeAll();
			currentPanel = new MoveGoodsUI(this,voList);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("confirmmove")){
			
			MoveGoodsUI ui = (MoveGoodsUI)(((JButton)e.getSource()).getParent());
			Object[][] data = ui.getTableObjects();
			service.moveGoods(data);
			ArrayList<ComGoodsVO> voList = service.showInventory();
			
			frame.getContentPane().removeAll();
			currentPanel = new ShowInventoryUI(this,voList);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("confirmdate")){
			
			ShowCheckUI ui = (ShowCheckUI)(((JButton)e.getSource()).getParent());
			String start = ui.getStartDate();
			String end = ui.getEndDate();
			
			ArrayList<EnterReceiptVO> enterList = service.showCheckEnter(start, end);
			ArrayList<ExitReceiptVO> exitList = service.showCheckExit(start, end);
			
			frame.getContentPane().removeAll();
			currentPanel = new ShowCheckUI(this,enterList,exitList);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("showreceipt")){
			
			ShowCheckUI ui = (ShowCheckUI)(((JButton)e.getSource()).getParent());
			String type = ui.getSelectType();
			if(type.equals("入库单")){
				EnterReceiptVO vo = ui.getEnter();
				currentPanel = new ShowReceiptUI(this,vo,ui);
			}
			else if(type.equals("出库单")){
				ExitReceiptVO vo = ui.getExit();
				currentPanel = new ShowReceiptUI(this,vo,ui);
			}
			
			frame.getContentPane().removeAll();
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		else if(e.getActionCommand().equals("back")){
			
			ShowReceiptUI ui = (ShowReceiptUI)(((JButton)e.getSource()).getParent());
			currentPanel = ui.getSaveUI();
			frame.getContentPane().removeAll();
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		
		
	}

}
