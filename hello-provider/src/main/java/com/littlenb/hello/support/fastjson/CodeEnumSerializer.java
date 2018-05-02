package com.littlenb.hello.support.fastjson;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.littlenb.hello.type.ICodeEnum;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author svili
 **/
public class CodeEnumSerializer implements ObjectSerializer {

  public static CodeEnumSerializer instance = new CodeEnumSerializer();

  @Override
  public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
      int features) throws IOException {
    SerializeWriter out = serializer.out;

    if (object == null) {
      out.writeNull();
      return;
    }

    if (!(object instanceof ICodeEnum)) {
      throw new JSONException("write ICodeEnum " + fieldName + " error, the field \"" + fieldName
          + "\" is not the sub class by ICodeEnum.");
    }

    ICodeEnum codeEnum = (ICodeEnum) object;
    Object code = codeEnum.getCode();
    if (code instanceof Integer) {
      out.writeInt((Integer) code);
    } else if (code instanceof Float) {
      out.writeFloat((Float) code, true);
    } else if (code instanceof String) {
      out.writeString((String) code);
    } else {
      throw new JSONException("write ICodeEnum " + fieldName
          + " error, code type is not in (Integer,Float,String).");
    }

  }
}
