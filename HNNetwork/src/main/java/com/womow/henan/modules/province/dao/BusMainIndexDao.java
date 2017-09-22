package com.womow.henan.modules.province.dao;

import java.util.List;
import java.util.Map;

import com.womow.henan.commons.dao.BaseDao;
import com.womow.henan.modules.province.bean.dto.BusDataManageEntityDo;
import com.womow.henan.modules.province.bean.po.BusDataManageEntity;
import com.womow.henan.modules.province.bean.po.BusSortEntity;

/**
 * @Description 鍥界綉鏁版嵁绠＄悊DAO
 * @author CAI modules@163.com
 * @data 2017骞�8鏈�12鏃ヤ笂鍗�6:55:48
 * @version V1.0
 */
public interface BusMainIndexDao extends BaseDao<BusDataManageEntity>{

	/**
	 * 鏌ヨ瑙嗗浘涓墍鏈夌殑閮ㄩ棬鍚嶇О
	 * @param map
	 * @return
	 */
	List<String> findAllHeadDept();

	/**
	 * 鑾峰彇娌冲崡鐪佺殑鎵�鏈塂娈靛嚭鐜版鏁�
	 * @param i
	 * @return
	 */
	List<BusDataManageEntityDo> findHenanDGrade();
	
	/**
	 * 鑾峰彇娌冲崡鐪佺殑鎵�鏈塃娈靛嚭鐜版鏁�
	 * @param i
	 * @return
	 */
	List<BusDataManageEntityDo> findHenanEGrade();
	
	/**
	 * 鑾峰彇2016骞村叏骞存渤鍗楃渷鐨勬墍鏈夋浣嶅嚭鐜版鏁�
	 * @param i
	 * @return
	 */
	List<BusDataManageEntityDo> findHenanGradeBy2016wholeYear();
	
	/**
	 * 鑾峰彇2017骞翠笂鍗婂勾娌冲崡鐪佺殑鎵�鏈夋浣嶅嚭鐜版鏁�
	 * @param i
	 * @return
	 */
	List<BusDataManageEntityDo> findHenanGradeBy2017firsthalfYear();
	
	/**
	 * 鑾峰彇2017骞寸涓�瀛ｅ害娌冲崡鐪佺殑鎵�鏈夋浣嶅嚭鐜版鏁�
	 * @param i
	 * @return
	 */
	List<BusDataManageEntityDo> findHenanGradeBy2017season1Year();
	
	/**
	 * 鑾峰彇鍚勫勾搴︽渤鍗楃渷鐨勬墍鏈夋浣嶅嚭鐜版鏁�
	 * @param i
	 * @return
	 */
	List<BusDataManageEntityDo> countHenanGradeByYear();
	
	/**
	 * 鑾峰彇娌冲崡鐪佺殑鍚勯儴闂ㄦ墍鏈夋浣嶅嚭鐜版鏁�
	 * @param i
	 * @return
	 */
	List<BusDataManageEntityDo> countHenanGrade(String henanGrade);
	
	/**
	 * 鑾峰彇娌冲崡鐪佸悇骞村害鎵�鏈夋浣嶅嚭鐜版鏁�
	 * @param i
	 * @return
	 */
	List<BusDataManageEntityDo> getHenanTargetGrade(String henanGrade);
	
	/**
	 * 鑾峰緱娌冲崡鐪佽繎10骞寸患鍚堟帓鍚�
	 * @param map
	 * @return
	 */
	List<BusSortEntity> findHenanPai();
	
	
}
