package com.mfh.action;
import com.mfh.table.Row;
import com.mfh.table.utils.DataFactory;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

/**
 * @Author: mfh
 * @Date: 2019-03-01 10:10
 **/
public class PeriodAction extends BaseAction {
    public String firstLoad() {
        return "period";
    }

    public String show() {
//        List<Row> rows = DataFactory.rows();
        List<Row> rows = DataFactory.billRow();
        DataFactory.shuffle(rows);
        DataFactory.processRemove(rows);
        ActionContext.getContext().put("table", rows);
        return "showTable";
    }
}
