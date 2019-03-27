package com.wsh.config.service.impl;

import com.wsh.common.base.PageQueryBean;
import com.wsh.config.dao.CodetypeDao;
import com.wsh.domain.dto.CodetypeDto;
import com.wsh.config.service.CodetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 
 * 数据字典表服务实现
 *
 * @since 2018-06-13
 *
 * @version 1.0
 */
@Service
@Transactional
public class CodetypeServiceImpl implements CodetypeService {

	@Autowired
	private CodetypeDao codetypeDao;
	
	/**
	 * 根据主键查询数据字典表信息
	 *
	 * @param codetype
	 * @return
	 */
	public CodetypeDto findById(CodetypeDto codetype){
		return codetypeDao.findById(codetype);
	}
	
	/**
	 * 根据对象查询数据字典表信息
	 *
	 * @param codetype
	 * @return
	 */
	public CodetypeDto find(CodetypeDto codetype){
		return codetypeDao.find(codetype);
	}
	
	/**
	 * 保存数据字典表信息
	 *
	 * @param codetype
	 * @return
	 */
	public void save(CodetypeDto codetype){
		codetypeDao.save(codetype);
	}
	
	/**
	 * 根据主键修改数据字典表信息
	 *
	 * @param codetype
	 */
	public void update(CodetypeDto codetype){
		codetypeDao.editById(codetype);
	}
	
	/**
	 * 根据主键删除数据字典表信息
	 * @param codetype
	 */
	public void delete(CodetypeDto codetype){
		codetypeDao.deleteById(codetype);
	}
	
	/**
	 * 查询数据字典表列表
	 *
	 * @param codetype
	 * @return
	 */
	public List<CodetypeDto> list(CodetypeDto codetype){
		return codetypeDao.list(codetype);
	}
	
	/**
	 * 分页查询数据字典表信息
	 * @param Codetype
	 */
	public PageQueryBean<CodetypeDto> pageQuery(PageQueryBean<CodetypeDto> page){
		return codetypeDao.page(page);
	}
}
