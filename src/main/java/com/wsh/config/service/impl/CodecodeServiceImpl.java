package com.wsh.config.service.impl;

import com.wsh.common.base.PageQueryBean;
import com.wsh.common.util.StringUtils;
import com.wsh.config.dao.CodecodeDao;
import com.wsh.domain.dto.CodecodeDto;
import com.wsh.config.service.CodecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 
 * 数据字典代码表服务实现
 *
 * @since 2018-06-13
 *
 * @version 1.0
 */
@Service
@Transactional
public class CodecodeServiceImpl implements CodecodeService {

	@Autowired
	private CodecodeDao codecodeDao;
	
	/**
	 * 根据主键查询数据字典代码表信息
	 *
	 * @param codecode
	 * @return
	 */
	public CodecodeDto findById(CodecodeDto codecode){
		return codecodeDao.findById(codecode);
	}
	
	/**
	 * 根据对象查询数据字典代码表信息
	 *
	 * @param codecode
	 * @return
	 */
	public CodecodeDto find(CodecodeDto codecode){
		return codecodeDao.find(codecode);
	}
	
	/**
	 * 保存数据字典代码表信息
	 *
	 * @param codecode
	 * @return
	 */
	public void save(CodecodeDto codecode){
		codecodeDao.save(codecode);
	}
	
	/**
	 * 根据主键修改数据字典代码表信息
	 *
	 * @param codecode
	 */
	public void update(CodecodeDto codecode){
		codecodeDao.editById(codecode);
	}
	
	/**
	 * 根据主键删除数据字典代码表信息
	 * @param codecode
	 */
	public void delete(CodecodeDto codecode){
		codecodeDao.deleteById(codecode);
	}
	
	/**
	 * 查询数据字典代码表列表
	 *
	 * @param codecode
	 * @return
	 */
	public List<CodecodeDto> list(CodecodeDto codecode){
		return codecodeDao.list(codecode);
	}
	
	/**
	 * 分页查询数据字典代码表信息
	 * @param Codecode
	 */
	public PageQueryBean<CodecodeDto> pageQuery(PageQueryBean<CodecodeDto> page){
		return codecodeDao.page(page);
	}


	public boolean checkCode(String type, String code){
		if(StringUtils.isEmptyStr(type) || StringUtils.isEmptyStr(code) ){
			return  false;
		}

		CodecodeDto checkCodecode = new CodecodeDto();
		checkCodecode.setType(type);
		checkCodecode.setCode(code);
		List<CodecodeDto> queryCode = list(checkCodecode);
		if(queryCode != null && !queryCode.isEmpty()){
			return  true;
		}
		return  false;
	}
}
