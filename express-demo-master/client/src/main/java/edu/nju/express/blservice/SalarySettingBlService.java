package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.SalaryVO;

/**
 * 处理总经理工资制定界面的操作
 * @author Dora
 * @version 2015-12-9 21:22:49
 */

public interface SalarySettingBlService {
	/**
	 * 设置业务员月薪
	 * @author Dora
	 * @param salary
	 * @return	操作是否有效
	 */
	public ResultMessage setClerkSalary(double salary);
	
	/**
	 * 设置司机提成
	 * @author Dora
	 * @param wage
	 * @return 操作是否有效
	 */
	public ResultMessage setDriverWage(double wage);
	
	/**
	 * 设置人员工资
	 * @author Dora
	 * @param wage
	 * @return 操作是否有效
	 */
	public ResultMessage setPostmanWage(double wage);
	
	/**
	 * 获得工资信息
	 * @author Dora
	 * @return	所有工资信息的vo
	 */
	public SalaryVO getSalary();
}
