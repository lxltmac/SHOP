package com.wsh.config.service;

import com.wsh.common.base.PageQueryBean;
import com.wsh.domain.dto.CodecodeDto;

import java.util.List;

/**
 * 
 * 数据字典代码表服务接口
 *
 * @since 2018-06-13
 *
 * @version 1.0
 */
public interface CodecodeService{

	/**
	 * 根据主键查询数据字典代码表信息
	 *
	 * @param codecode
	 * @return
	 */
	public CodecodeDto findById(CodecodeDto codecode);
	
	/**
	 * 根据对象查询数据字典代码表信息
	 *
	 * @param codecode
	 * @return
	 */
	public CodecodeDto find(CodecodeDto codecode);
	
	
	/**
	 * 保存数据字典代码表信息
	 *
	 * @param codecode
	 * @return
	 */
	public void save(CodecodeDto codecode);
	
	/**
	 * 根据主键修改数据字典代码表信息
	 *
	 * @param codecode
	 */
	public void update(CodecodeDto codecode);
	
	/**
	 * 根据主键删除数据字典代码表信息
	 *
	 * @param codecode
	 */
	public void delete(CodecodeDto codecode);
	
	/**
	 * 查询所有数据字典代码表列表
	 *
	 * @param codecode
	 * @return
	 */
	public List<CodecodeDto> list(CodecodeDto codecode);
	
	/**
	 * 分页查询数据字典代码表信息
	 *
	 * @param codecode
	 */
	public PageQueryBean<CodecodeDto> pageQuery(PageQueryBean<CodecodeDto> page);


	/**
	 * 校验数据字典
	 * @param  type,code
	 * @return  boolean
	 * @author
	 * @date  2018/7/4
	 */
	public boolean checkCode(String type, String code);
}
