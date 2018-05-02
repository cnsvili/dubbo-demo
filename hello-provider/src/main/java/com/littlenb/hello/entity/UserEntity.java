package com.littlenb.hello.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/***
 * @author svili
 */
@Table(name = "t_sys_user")
public class UserEntity {

  @Id
  private Long userId;

  /**
   * 用户识别码,唯一
   */
  private String uniCode;

  /**
   * 密码
   */
  @Column(name = "password_encrypt")
  private String password;

  /**
   * 是否授权
   */
  @Column(name = "is_granted")
  private Boolean granted;

  /**
   * 创建时间
   */
  @Column(name = "gmt_create")
  private Date createTime;

  /**
   * 更新时间
   */
  @Column(name = "gmt_modify")
  private Date modifyTime;

  @OneToOne(mappedBy = "user_id")
  private UserArchiveEntity archive;

  @OneToMany(mappedBy = "user_id")
  private List<UserRoleRelationEntity> roles;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUniCode() {
    return uniCode;
  }

  public void setUniCode(String uniCode) {
    this.uniCode = uniCode;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getGranted() {
    return granted;
  }

  public void setGranted(Boolean granted) {
    this.granted = granted;
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

  public UserArchiveEntity getArchive() {
    return archive;
  }

  public void setArchive(UserArchiveEntity archive) {
    this.archive = archive;
  }

  public List<UserRoleRelationEntity> getRoles() {
    return roles;
  }

  public void setRoles(List<UserRoleRelationEntity> roles) {
    this.roles = roles;
  }
}
