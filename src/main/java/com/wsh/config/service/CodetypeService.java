package com.wsh.config.service;

import com.wsh.common.base.PageQueryBean;
import com.wsh.domain.dto.CodetypeDto;

import java.util.List;

/**
 * 
 * 数据字典表服务接口
 *
 * @since 2018-06-13
 *
 * @version 1.0
 */
public interface CodetypeService{

	/**
	 * 根据主键查询数据字典表信息
	 *
	 * @param codetype
	 * @return
	 */
	public CodetypeDto findById(CodetypeDto codetype);
	
	/**
	 * 根据对象查询数据字典表信息
	 *
	 * @param codetype
	 * @return
	 */
	public CodetypeDto find(CodetypeDto codetype);
	
	
	/**
	 * 保存数据字典表信息
	 *
	 * @param codetype
	 * @return
	 */
	public void save(CodetypeDto codetype);
	
	/**
	 * 根据主键修改数据字典表信息
	 *
	 * @param codetype
	 */
	public void update(CodetypeDto codetype);
	
	/**
	 * 根据主键删除数据字典表信息
	 *
	 * @param codetype
	 */
	public void delete(CodetypeDto codetype);
	
	/**
	 * 查询所有数据字典表列表
	 *
	 * @param codetype
	 * @return
	 */
	public List<CodetypeDto> list(CodetypeDto codetype);
	
	/**
	 * 分页查询数据字典表信息
	 *
	 * @param codetype
	 */
	public PageQueryBean<CodetypeDto> pageQuery(PageQueryBean<CodetypeDto> page);
}
