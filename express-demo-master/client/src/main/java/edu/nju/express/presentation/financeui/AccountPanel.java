package edu.nju.express.presentation.financeui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.Accountvo;
import edu.nju.express.vo.BankingAccountVO;
import edu.nju.express.vo.Carvo;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.EmployeeVO;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;

public class AccountPanel extends MainPanel{
	private static Color fore = new Color(44, 62, 80);
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	
	private FinanceController controller;
	
	public AccountPanel(FinanceController controller, Accountvo vo) {
		this.controller = controller;
		this.add(new FinanceGuide(controller));
		
		this.add(new ReturnButton());
		
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.setBounds(94, 112, 900 - 175, 600 - 180);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		this.add(p);

		final JScrollPane s = new JScrollPane(p);
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.getVerticalScrollBar().setOpaque(false);

		final MyScrollBarUI ui = new MyScrollBarUI();
		s.getVerticalScrollBar().setUI(ui);

		s.getVerticalScrollBar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				s.getVerticalScrollBar().repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				s.getVerticalScrollBar().repaint();
				;

			}
		});
		
		
		String date = vo.getDate();
		p.add(new JLabel(date));
		
		
		JLabel l1= new JLabel("银行账户");
		l1.setName("title");
		ArrayList<BankingAccountVO> bl = vo.getAccountList();
		for(BankingAccountVO b: bl){
			p.add(new JLabel(""+b.getName()+":   "+b.getMoney()+"元"));
		}
		
		
		ArrayList<StationVO> sl = vo.getStationList();
		JLabel l2= new JLabel("中转站");
		l2.setName("title");
		for(StationVO svo: sl){
			p.add(new JLabel(svo.getName()+" "+svo.getId()));
		}
		
		
		ArrayList<HallVO> hl=vo.getHallList();
		JLabel l3= new JLabel("营业厅");
		l3.setName("title");
		for(HallVO h: hl){
			p.add(new JLabel(h.getName()+" "+h.getId()+" "));
		}
	
		
		ArrayList<EmployeeVO> el = vo.getUserList();
		JLabel l4= new JLabel("人员");
		l4.setName("title");
		for(EmployeeVO e:el)
			p.add(new JLabel(e.getId()+" "+e.getName()));
		
		
		ArrayList<Carvo> cl = vo.getCarList();
		JLabel l5= new JLabel("车辆");
		l5.setName("title");
		for(Carvo c:cl)
			p.add(new JLabel(c.getId()+" "+c.getCar()+" "+c.getPurchase()));
		
		
		ArrayList<ComGoodsVO> cgl = vo.getCommodity();
		JLabel l6= new JLabel("库存");
		l6.setName("title");
		//快递编号、入库日期、目的地、区号、排号、架号、位号
		for(ComGoodsVO cg:cgl)
			p.add(new JLabel(cg.getOrder().getID()));
		
		
		for(Component c: p.getComponents()){
			JLabel l = (JLabel) c;
			l.setOpaque(false);
			l.setForeground(fore);
			l.setFont(font);
		}
	}

}