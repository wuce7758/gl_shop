package com.appabc.common.base;

import com.appabc.common.base.bean.BaseBean;
import com.appabc.common.utils.SystemConstant;
import com.appabc.common.utils.pagination.PageModel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description : 查询上下文
 * @Copyright : GL. All Rights Reserved
 * @Company : 江苏国立网络技术有限公司
 * @author : 黄建华
 * @version : 1.0 Create Date : 2014年8月22日 下午5:49:28
 */

public class QueryContext<T extends BaseBean> {

	/*
	 * the sql order : desc or asc
	 * */
	private String order = SystemConstant.OrderEnum.ORDERDESC.getText();
	/*
	 * the sql order by column name;
	 * */
	private String orderColumn;
	
	/*
	 * client query parameter
	 */
	private T beanParameter;
	
	/*
	 * parameter array
	 */
	private List<?> paramList;
	/*
	 * client query parameters
	 */
	private Map<String, Object> parameters = new HashMap<>();
	
	/*page Model*/
	private PageModel page = new PageModel();
	/*query result*/
	
	private QueryResult<T> queryResult = new QueryResult<>();

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		if (parameters != null){
			this.parameters = parameters;
		}else{ // map clear
			this.parameters.clear();
		}
	}

	public void addParameter(String key, Object value) {
		this.parameters.put(key, value);
	}

    public void addParameters(Map<String, Object> params) {
		if (params != null)
            this.parameters.putAll(params);
	}

	public T getBeanParameter() {
		return beanParameter;
	}

	public void setBeanParameter(T beanParameter) {
		this.beanParameter = beanParameter;
		if (beanParameter != null) {
			BeanWrapper wrapper = new BeanWrapperImpl(beanParameter);
			PropertyDescriptor[] descriptors = wrapper.getPropertyDescriptors();
			Map<String, Object> properties = new HashMap<>();
			for (PropertyDescriptor pd : descriptors) {
				Object propValue = wrapper.getPropertyValue(pd.getName());
				// 映射时枚举类型的值未填充到beanParameter中，这里排除掉枚举类型，避免parameters中同名参数无辜被设为空
				if(!pd.getPropertyType().isEnum()){
					properties.put(pd.getName(), propValue);
				}
			}
			this.parameters.putAll(properties);
		}
	}

	public QueryResult<T> getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(QueryResult<T> queryResult) {
		this.queryResult = queryResult;
	}
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	
	/**  
	 * page  
	 *  
	 * @return  the page  
	 * @since   1.0.0  
	*/  
	
	public PageModel getPage() {
		return page;
	}

	/**  
	 * @param page the page to set  
	 */
	public void setPage(PageModel page) {
		this.page = page;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	/**  
	 * paramList  
	 *  
	 * @return  the paramList  
	 * @since   1.0.0  
	*/  
	
	public List<?> getParamList() {
		return paramList;
	}

	/**  
	 * @param paramList the paramList to set  
	 */
	public void setParamList(List<?> paramList) {
		this.paramList = paramList;
	}
	
	public Object getParameter(Object key){
		return this.parameters.get(key);
	}
	
	public static class DateQueryEntry {
		
		public DateQueryEntry(){}
		
		public DateQueryEntry(String propertyName,Date startDate,Date endDate){
			this.propertyName = propertyName;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		
		public DateQueryEntry(String propertyName,String dbColumnName,Date startDate,Date endDate){
			this.propertyName = propertyName;
			this.dbColumnName = dbColumnName;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		
		/**
		 * need to do date query property name
		 * */
		private String propertyName;
		/**
		 * need to do date query database column name
		 * */
		private String dbColumnName;
		/**
		 * the date query start date
		 * */
		private Date startDate;
		/**
		 * the date query end date
		 * */
		private Date endDate;
		/**  
		 * propertyName  
		 *  
		 * @return  the propertyName  
		 * @since   1.0.0  
		 */
		
		public String getPropertyName() {
			return propertyName;
		}
		/**  
		 * @param propertyName the propertyName to set  
		 */
		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}
		/**  
		 * startDate  
		 *  
		 * @return  the startDate  
		 * @since   1.0.0  
		 */
		
		public Date getStartDate() {
			return startDate;
		}
		/**  
		 * @param startDate the startDate to set  
		 */
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		/**  
		 * endDate  
		 *  
		 * @return  the endDate  
		 * @since   1.0.0  
		 */
		
		public Date getEndDate() {
			Calendar c = Calendar.getInstance();
			c.setTime(endDate);
			int h = c.get(Calendar.HOUR_OF_DAY);
			int m = c.get(Calendar.MINUTE);
			int s = c.get(Calendar.SECOND);
			if(h==0&&m==0&&s==0){
				c.set(Calendar.HOUR_OF_DAY, 23);
				c.set(Calendar.MINUTE, 59);
				c.set(Calendar.SECOND, 59);
				return c.getTime();
			} else {				
				return endDate;
			}
		}
		/**  
		 * @param endDate the endDate to set  
		 */
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		/**  
		 * dbColumnName  
		 *  
		 * @return  the dbColumnName  
		 * @since   1.0.0  
		 */
		
		public String getDbColumnName() {
			return dbColumnName;
		}

		/**  
		 * @param dbColumnName the dbColumnName to set  
		 */
		public void setDbColumnName(String dbColumnName) {
			this.dbColumnName = dbColumnName;
		}
		
	}
}
