package edu.nju.express.presentation.financeui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

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

/**
 * 期初建账信息列表
 * @author Dora
 *
 */
public class AccountPanel extends MainPanel{
	private static Color fore = new Color(44, 62, 80);
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	
	private FinanceController controller;
	
	public AccountPanel(FinanceController controller, Accountvo vo) {
		this.controller = controller;
		FinanceGuide guide =new FinanceGuide(controller);
		guide.account.setIcon(null);
		this.add(guide);
		this.bg = new ImageIcon("ui/image/finance/建帐.png").getImage();

		
		ReturnButton jbtReturn = new ReturnButton();
		jbtReturn.setActionCommand("AccountUI");
		jbtReturn.addActionListener(controller);
		this.add(jbtReturn);
		
		String date = vo.getDate();
		JLabel dateLabel=new JLabel(date);
		dateLabel.setFont(font);
		dateLabel.setForeground(fore);
		dateLabel.setBounds(148, 78, 200, 35);
		this.add(dateLabel);
		
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		this.add(p);

		final JScrollPane s = new JScrollPane(p);
		s.setBounds(208, 112, 645, 420);
		s.setOpaque(false);
	//	s.setLayout(null);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.getViewport().setOpaque(false);
		s.getVerticalScrollBar().setOpaque(false);
		final MyScrollBarUI ui = new MyScrollBarUI();
		s.getVerticalScrollBar().setUI(ui);
		this.add(s);

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
		
		
		
		
		
		JLabel l1= new JLabel("银行账户:");
		l1.setName("title");
		p.add(l1);
		ArrayList<BankingAccountVO> bl = vo.getAccountList();
		for(BankingAccountVO b: bl){
			p.add(new JLabel(b.getName()+"    "+b.getMoney()+"元"));
		}
		
		
		ArrayList<StationVO> sl = vo.getStationList();
		JLabel l2= new JLabel("中转站:");
		l2.setName("title");
		p.add(l2);
		for(StationVO svo: sl){
			p.add(new JLabel(svo.getName()+"    "+svo.getId()));
		}
		
		
		ArrayList<HallVO> hl=vo.getHallList();
		JLabel l3= new JLabel("营业厅:");
		l3.setName("title");
		p.add(l3);
		for(HallVO h: hl){
			p.add(new JLabel(h.getName()+"    "+h.getId()));
		}
	
		
		ArrayList<EmployeeVO> el = vo.getUserList();
		JLabel l4= new JLabel("人员:");
		l4.setName("title");
		p.add(l4);
		for(EmployeeVO e:el)
			p.add(new JLabel(e.getId()+"    "+e.getName()));
		
		
		ArrayList<Carvo> cl = vo.getCarList();
		JLabel l5= new JLabel("车辆:");
		l5.setName("title");
		p.add(l5);
		for(Carvo c:cl)
			p.add(new JLabel(c.getId()+"    "+c.getCar()+"    "+c.getPurchase()));
		
		
		ArrayList<ComGoodsVO> cgl = vo.getCommodity();
		JLabel l6= new JLabel("库存:");
		l6.setName("title");
		p.add(l6);
		//快递编号、入库日期、目的地、区号、排号、架号、位号
		for(ComGoodsVO cg:cgl){
			System.out.println(cg.getOrder().getID()+"    "+cg.getType()+"    "+cg.getLine()+"排"+cg.getShelf()+"架"+cg.getCell()+"位");
			p.add(new JLabel(cg.getOrder().getID()+"    "+cg.getType()+"    "+cg.getLine()+"排"+cg.getShelf()+"架"+cg.getCell()+"位"));
		}
		
		for(Component c: p.getComponents()){
			JLabel l = (JLabel) c;
			l.setOpaque(false);
			l.setForeground(fore);
			l.setFont(font);
			
			if(c.getName()!=null){
				c.setFont(new Font("微软雅黑",font.BOLD,19));
				c.setPreferredSize(new Dimension(200,60));
			}else{
				c.setPreferredSize(new Dimension(400,30));
			}
		}
	}

}