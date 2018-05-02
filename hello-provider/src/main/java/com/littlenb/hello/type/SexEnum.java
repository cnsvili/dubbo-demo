package com.littlenb.hello.type;

/***
 *
 * @author svili
 */
public enum SexEnum implements ICodeEnum<Integer>{

  /**
   * 0-UNKNOW,1-Male,2-FEMALE
   */
  UNKNOW(0), MALE(1), FEMALE(2);

  private int code;

  SexEnum(int code){
    this.code = code;
  }

  @Override
  public Integer getCode() {
    return code;
  }
}
