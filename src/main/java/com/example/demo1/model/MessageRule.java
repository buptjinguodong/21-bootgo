package com.example.demo1.model;

import com.bstek.urule.model.Label;

/**
 * @author jinguodong
 * @date 2020/2/5 8:56 PM
 */
public class MessageRule {
  @Label("流程类型")
  private String flowType;
  @Label("流程环节")
  private String flowNode;
  @Label("审批结论")
  private String nodeResult;
  @Label("交易")
  private String relateTrans;
  @Label("产品")
  private String relateProd;
  @Label("执行动作")
  private String action;

  public String getFlowType() {
    return flowType;
  }

  public void setFlowType(String flowType) {
    this.flowType = flowType;
  }

  public String getFlowNode() {
    return flowNode;
  }

  public void setFlowNode(String flowNode) {
    this.flowNode = flowNode;
  }

  public String getNodeResult() {
    return nodeResult;
  }

  public void setNodeResult(String nodeResult) {
    this.nodeResult = nodeResult;
  }

  public String getRelateTrans() {
    return relateTrans;
  }

  public void setRelateTrans(String relateTrans) {
    this.relateTrans = relateTrans;
  }

  public String getRelateProd() {
    return relateProd;
  }

  public void setRelateProd(String relateProd) {
    this.relateProd = relateProd;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }
}
