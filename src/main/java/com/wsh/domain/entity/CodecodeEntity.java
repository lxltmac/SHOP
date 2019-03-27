package com.wsh.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 数据字典代码表 实体对象
 *
 * @since 2018-06-13
 *
 * @version 1.0
 */
public class CodecodeEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
   /**
    * 属性: 
    * 
    */
	private Integer id;
   /**
    * 属性: 字典类型
    * 
    */
	private String type;
   /**
    * 属性: 字典名称
    * 
    */
	private String typeName;
   /**
    * 属性: 代码项
    * 
    */
	private String code;
   /**
    * 属性: 代码项名称
    * 
    */
	private String codeName;
   /**
    * 属性: 是否有效
    * 
    */
	private String validInd;
   /**
    * 属性: 备注
    * 
    */
	private String remark;
   /**
    * 属性: 创建时间
    * 
    */
	private Date createTime;
   /**
    * 属性: 最后更新时间
    * 
    */
	private Date lastUpdate;
	
   /**
    * 获取: 
    * 
    */
	public Integer getId() {
	  return id;
    }

    /**
     * 设置: 
     * 
     */
    public void setId(Integer id) {
	   this.id = id;
    }
   /**
    * 获取: 字典类型
    * 
    */
	public String getType() {
	  return type;
    }

    /**
     * 设置: 字典类型
     * 
     */
    public void setType(String type) {
	   this.type = type;
    }
   /**
    * 获取: 字典名称
    * 
    */
	public String getTypeName() {
	  return typeName;
    }

    /**
     * 设置: 字典名称
     * 
     */
    public void setTypeName(String typeName) {
	   this.typeName = typeName;
    }
   /**
    * 获取: 代码项
    * 
    */
	public String getCode() {
	  return code;
    }

    /**
     * 设置: 代码项
     * 
     */
    public void setCode(String code) {
	   this.code = code;
    }
   /**
    * 获取: 代码项名称
    * 
    */
	public String getCodeName() {
	  return codeName;
    }

    /**
     * 设置: 代码项名称
     * 
     */
    public void setCodeName(String codeName) {
	   this.codeName = codeName;
    }
   /**
    * 获取: 是否有效
    * 
    */
	public String getValidInd() {
	  return validInd;
    }

    /**
     * 设置: 是否有效
     * 
     */
    public void setValidInd(String validInd) {
	   this.validInd = validInd;
    }
   /**
    * 获取: 备注
    * 
    */
	public String getRemark() {
	  return remark;
    }

    /**
     * 设置: 备注
     * 
     */
    public void setRemark(String remark) {
	   this.remark = remark;
    }
   /**
    * 获取: 创建时间
    * 
    */
	public Date getCreateTime() {
	  return createTime;
    }

    /**
     * 设置: 创建时间
     * 
     */
    public void setCreateTime(Date createTime) {
	   this.createTime = createTime;
    }
   /**
    * 获取: 最后更新时间
    * 
    */
	public Date getLastUpdate() {
	  return lastUpdate;
    }

    /**
     * 设置: 最后更新时间
     * 
     */
    public void setLastUpdate(Date lastUpdate) {
	   this.lastUpdate = lastUpdate;
    }
}
