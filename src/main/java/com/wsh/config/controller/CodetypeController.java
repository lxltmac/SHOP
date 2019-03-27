package com.wsh.config.controller;

import com.wsh.common.base.PageQueryBean;
import com.wsh.common.base.ResponseResult;
import com.wsh.config.service.CodetypeService;
import com.wsh.domain.dto.CodetypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * 数据字典表控制层
 *
 * @since 2018-06-13
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/config/codetype")
public class CodetypeController {

	@Autowired
	private CodetypeService codetypeService;
	
	/**
	 * 查询数据字典表对象
	 *
	 * @param codetype
	 * @return
	 */
	@RequestMapping(value="find",method=RequestMethod.POST)
	public ResponseResult<CodetypeDto> find(@RequestBody CodetypeDto codetype) {
		
		CodetypeDto result = codetypeService.find( codetype );
		
		return new ResponseResult<CodetypeDto>(result);
	}
	
	/**
	 * 保存数据字典表对象
	 *
	 * @param codetype
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ResponseResult<CodetypeDto> save(@RequestBody CodetypeDto codetype){
		
		codetypeService.save(codetype);
		
		return new ResponseResult<CodetypeDto>(codetype);
	}
	
	
	/**
	 * 根据主键删除数据字典表对象
	 * 
	 * @param codetype
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ResponseResult<CodetypeDto> delete(@RequestBody CodetypeDto codetype){
		
		codetypeService.delete(codetype);
		
		return new ResponseResult<CodetypeDto>();
	}
	
	/**
	 * 根据主键修改数据字典表
	 *
	 * @param codetype
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ResponseResult<CodetypeDto> update(@RequestBody CodetypeDto codetype){
		
		codetypeService.update(codetype);
		
		return new ResponseResult<CodetypeDto>();
	}
	
	/**
	 * 查询数据字典表列表
	 *
	 * @param codetype
	 * @return
	 */
	@RequestMapping(value="list",method=RequestMethod.POST)
	public ResponseResult<List<CodetypeDto>> list(@RequestBody CodetypeDto codetype) {
		
		List<CodetypeDto> result = codetypeService.list( codetype );
		
		return  new ResponseResult<List<CodetypeDto>>(result);
	}
	
	/**
	 * 分页查询数据字典表对象
	 *
	 * @param codetype
	 */
	@RequestMapping(value="pageQuery",method=RequestMethod.POST)
	public ResponseResult<PageQueryBean<CodetypeDto>> pageQuery(@RequestBody PageQueryBean<CodetypeDto> page){
		
		PageQueryBean<CodetypeDto> result = codetypeService.pageQuery( page );
		
		return new ResponseResult<PageQueryBean<CodetypeDto>>(result);
	}
}
