package com.example.demo1;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author jinguodong
 * @date 2020/2/23 2:33 PM
 */
public class JavaTest {
  public void log(Object s) {
    System.out.println(s);
  }
  @Test
  public void test4Date() throws ParseException {
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getInstance();
    date.setMonth(3);
    date.setDate(30);

    date.setMonth(date.getMonth() + 8 + 2);

    log(dateFormat.format(date));
  }
  @Test
  public void test4Calander(){
    Calendar calendar = Calendar.getInstance();
    calendar.set(2020,3,30);
    log(calendar.getTime());

    calendar.add(Calendar.MONTH, 10);
    log(calendar.getTime());

  }
}
