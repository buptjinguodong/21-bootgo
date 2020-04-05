package com.example.demo1.urule;

import com.bstek.urule.Utils;
import com.bstek.urule.model.GeneralEntity;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.example.demo1.model.MessageRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jinguodong
 * @date 2020/2/5 8:44 PM
 */
public class UruleClient {
  public void doTest() throws Exception{
    //从Spring中获取KnowledgeService接口实例
    KnowledgeService service=(KnowledgeService)Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
    //通过KnowledgeService接口获取指定的资源包"test123"
    KnowledgePackage knowledgePackage=service.getKnowledge("messageGo/messageMng");
    //通过取到的KnowledgePackage对象创建KnowledgeSession对象
    KnowledgeSession session=KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

    MessageRule mr = new MessageRule();
    mr.setFlowType("01");
    mr.setFlowNode("01");
    mr.setNodeResult("01");
    mr.setAction("01");
    //将业务数据对象Employee插入到KnowledgeSession中
    session.insert(mr);
    //执行所有满足条件的规则

//    Map<String,Object> parameter=new HashMap<String,Object>();
//    parameter.put("count", 10);
//    parameter.put("result", true);
    //触发规则时并设置参数
    List mrList = session.fireRules().getMatchedRules();
    System.out.println(mrList.size());
//    System.out.println(mrList.get(0).toString());
    session.writeLogFile();

    //获取计算后的result值，要通过KnowledgeSession,而不能通过原来的parameter对象
//    boolean result=(Boolean)session.getParameter("result");
    System.out.println(mr.getAction());
  }
}
