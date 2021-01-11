package com.thinkmate.smart.util;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guying
 * @date 2020/12/31/09:46
 */
@Data
@ExcelTarget("settlementLogExcel")
public class SettlementListExcel implements Serializable {

    @Excel(name = "结算单号", height = 10, width = 20, isImportField = "true_st")
    private Long settlementId;

    @Excel(name = "结算金额", width = 20, isImportField = "true_st",type = 10)
    private BigDecimal settlementAmount;

    @Excel(name = "提现状态", width = 20, isImportField = "true_st")
    private String withdrawStatusText;

    @Excel(name = "提现成功时间", format = "yyyy-MM-dd HH:mm:ss", width = 20, isImportField = "true_st")
    private Date withdrawSuccessTime;

    @Excel(name = "结算时间", format = "yyyy-MM-dd HH:mm:ss", width = 20, isImportField = "true_st")
    private Date settlementTime;
}
