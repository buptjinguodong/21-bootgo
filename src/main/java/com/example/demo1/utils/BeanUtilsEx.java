package com.example.demo1.utils;

import java.lang.reflect.InvocationTargetException;

import com.example.demo1.convert.DateConvert;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jinguodong
 * @date 2019/6/18 8:37 AM
 */
public class BeanUtilsEx extends BeanUtils {
  private static Logger logger = LoggerFactory.getLogger(BeanUtilsEx.class);

  static {
    ConvertUtils.register(new DateConvert(), java.util.Date.class);
    ConvertUtils.register(new DateConvert(), String.class);
  }

  public static void copyProperties(Object target, Object source) {
    // 支持对日期copy
    try {
      org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
    } catch (IllegalAccessException | InvocationTargetException e) {
      logger.error("扩展BeanUtils.copyProperties支持data类型:" + e.getMessage());
      e.printStackTrace();
    }
  }
}
