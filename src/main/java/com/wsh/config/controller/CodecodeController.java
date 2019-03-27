package com.wsh.config.controller;

import com.wsh.common.base.PageQueryBean;
import com.wsh.common.base.ResponseResult;
import com.wsh.config.service.CodecodeService;
import com.wsh.domain.dto.CodecodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * 数据字典代码表控制层
 *
 * @since 2018-06-13
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/config/codecode")
public class CodecodeController {

	@Autowired
	private CodecodeService codecodeService;
	
	/**
	 * 查询数据字典代码表对象
	 *
	 * @param codecode
	 * @return
	 */
	@RequestMapping(value="find",method=RequestMethod.POST)
	public ResponseResult<CodecodeDto> find(@RequestBody CodecodeDto codecode) {
		
		CodecodeDto result = codecodeService.find( codecode );
		
		return new ResponseResult<CodecodeDto>(result);
	}
	
	/**
	 * 保存数据字典代码表对象
	 *
	 * @param codecode
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ResponseResult<CodecodeDto> save(@RequestBody CodecodeDto codecode){
		
		codecodeService.save(codecode);
		
		return new ResponseResult<CodecodeDto>(codecode);
	}
	
	
	/**
	 * 根据主键删除数据字典代码表对象
	 * 
	 * @param codecode
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ResponseResult<CodecodeDto> delete(@RequestBody CodecodeDto codecode){
		
		codecodeService.delete(codecode);
		
		return new ResponseResult<CodecodeDto>();
	}
	
	/**
	 * 根据主键修改数据字典代码表
	 *
	 * @param codecode
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ResponseResult<CodecodeDto> update(@RequestBody CodecodeDto codecode){
		
		codecodeService.update(codecode);
		
		return new ResponseResult<CodecodeDto>();
	}
	
	/**
	 * 查询数据字典代码表列表
	 *
	 * @param codecode
	 * @return
	 */
	@RequestMapping(value="list",method=RequestMethod.POST)
	public ResponseResult<List<CodecodeDto>> list(@RequestBody CodecodeDto codecode) {
		
		List<CodecodeDto> result = codecodeService.list( codecode );
		
		return  new ResponseResult<List<CodecodeDto>>(result);
	}
	
	/**
	 * 分页查询数据字典代码表对象
	 *
	 * @param codecode
	 */
	@RequestMapping(value="pageQuery",method=RequestMethod.POST)
	public ResponseResult<PageQueryBean<CodecodeDto>> pageQuery(@RequestBody PageQueryBean<CodecodeDto> page){
		
		PageQueryBean<CodecodeDto> result = codecodeService.pageQuery( page );
		
		return new ResponseResult<PageQueryBean<CodecodeDto>>(result);
	}
}
