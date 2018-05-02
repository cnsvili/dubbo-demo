package com.littlenb.hello.api.dto;

import java.util.Date;

/**
 * 接口层尽量不要返回<code>Entity</code>对象,封装为DTO
 *
 * @author svili
 **/
public class UserDto {

  /**
   * 用户唯一识别码
   */
  private Long uniCode;

  /**
   * 姓名
   */
  private String userName;

  /**
   * 昵称
   */
  private String nickName;

  /**
   * 性别 0-UnKnow,1-Male,2-Female
   */
  private Integer sex;

  /**
   * 民族
   */
  private String race;

  /**
   * 手机号码
   */
  private String mobilePhone;

  /**
   * 固定电话/办公电话
   */
  private String officePhone;

  /**
   * 电子邮箱
   */
  private String email;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 更新时间
   */
  private Date modifyTime;

  public Long getUniCode() {
    return uniCode;
  }

  public void setUniCode(Long uniCode) {
    this.uniCode = uniCode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getOfficePhone() {
    return officePhone;
  }

  public void setOfficePhone(String officePhone) {
    this.officePhone = officePhone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }
}
