package com.glshop.platform.api.buy.data;

import java.util.List;

import com.glshop.platform.api.base.CommonResult;
import com.glshop.platform.api.buy.data.model.BuySummaryInfoModel;

/**
 * @Description : 获取找买找卖列表结果
 * @Copyright   : GL. All Rights Reserved
 * @Company     : 深圳市国立数码动画有限公司
 * @author      : 叶跃丰
 * @version     : 1.0
 * Create Date  : 2014-7-24 上午9:44:05
 */
public class GetBuysResult extends CommonResult {

	/**
	 * 买卖信息概要列表
	 */
	public List<BuySummaryInfoModel> datas;

	/**
	 * 平台找卖找卖总数
	 */
	public int totalCount;
	
	@Override
	public String toString() {
		return super.toString() + ", TotalCount = " + totalCount + ", " + datas;
	}

}
