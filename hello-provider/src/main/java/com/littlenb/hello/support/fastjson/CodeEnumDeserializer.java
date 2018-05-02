package com.littlenb.hello.support.fastjson;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.littlenb.hello.support.CodeEnumAdapter;
import com.littlenb.hello.type.ICodeEnum;
import java.lang.reflect.Type;

/**
 * @author svili
 **/
public class CodeEnumDeserializer implements ObjectDeserializer {


  @Override
  public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {

    Class<T> clazz = (Class<T>) type;

    if (!ICodeEnum.class.isAssignableFrom(clazz)) {
      throw new JSONException("parse enum " + clazz.getSimpleName()
          + " error, type is not the sub class by ICodeEnum. ");
    }

    try {
      final JSONLexer lexer = parser.lexer;
      final int token = lexer.token();
      if (token == JSONToken.LITERAL_INT) {
        int intValue = lexer.intValue();
        lexer.nextToken(JSONToken.COMMA);

        return CodeEnumAdapter.toCodeEnum(intValue, clazz);
      } else if (token == JSONToken.LITERAL_FLOAT) {
        Float floatVal = lexer.floatValue();
        lexer.nextToken(JSONToken.COMMA);

        return CodeEnumAdapter.toCodeEnum(floatVal, clazz);
      } else if (token == JSONToken.LITERAL_STRING) {
        String strVal = lexer.stringVal();
        lexer.nextToken(JSONToken.COMMA);

        if (strVal.length() == 0) {
          return (T) null;
        }

        return CodeEnumAdapter.toCodeEnum(strVal, clazz);
      } else if (token == JSONToken.NULL) {
        lexer.nextToken(JSONToken.COMMA);

        return null;
      } else {
        Object value = parser.parse();
        throw new JSONException("parse enum " + clazz.getSimpleName() + " error, code : " + value);
      }

    } catch (JSONException e) {
      throw e;
    } catch (Exception e) {
      throw new JSONException(e.getMessage(), e);
    }

  }

  @Override
  public int getFastMatchToken() {
    return JSONToken.LITERAL_INT;
  }
}
