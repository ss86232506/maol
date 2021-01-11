package com.thinkmate.smart.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


@Data
public class ScoreIssueReqPOJO implements Serializable {
    /**
     * 用户手机号
     */
    @Excel(name = "个人用户手机号*",width = 14)
    private String mobile;
    /**
     * 企业用户税号
     */
    @Excel(name = "企业用户税号*",width = 20)
    private String taxNum;
    /**
     * 公司名称或者用户名
     */
    @Excel(name = "名称",width = 20)
    //@Length(max =50 ,message = "名称过长")
    private String realname;
    /**
     * 积分数量
     * isStatistics 自动统计数据
     */
    @Excel(name = "积分数量*")
    @NotNull(message = "积分数量不能为空")
    private String scoreNum;
    /**
     * 平台类型
     */
    @Excel(name = "业务代码")
    //@Length(max =2 ,message = "业务代码过长，最长2个字符（必须由诺诺网分配，请勿乱填）")
    private String platform;
    /**
     * 备注
     */
    @Excel(name = "备注")
    //@Length(max =120 ,message = "备注过长,最长120个字符")
    private String typeContent;

    /**
     * Email校验
     */
    @Excel(name = "Email", width = 25)
    private String email;
    /**
     * 最大
     */
    @Excel(name = "Max")
    //@Max(value = 15,message = "max 最大值不能超过15" ,groups = {ViliGroupOne.class})
    private int    max;
    /**
     * 最小
     */
    @Excel(name = "Min")
    //@Min(value = 3, groups = {ViliGroupTwo.class})
    private int    min;
    /**
     * 非空校验
     */
    @Excel(name = "NotNull")
    @NotNull
    private String notNull;
    /**
     * 正则校验
     */
    @Excel(name = "Regex")
    @Pattern(regexp = "[\u4E00-\u9FA5]*", message = "不是中文")
    private String regex;
}
