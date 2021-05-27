package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 老师对象 sys_tea
 * 
 * @author ruoyi
 * @date 2021-05-14
 */
public class SysTea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long tid;

    /** 老师姓名 */
    @Excel(name = "老师姓名")
    private String tname;

    public void setTid(Long tid) 
    {
        this.tid = tid;
    }

    public Long getTid() 
    {
        return tid;
    }
    public void setTname(String tname) 
    {
        this.tname = tname;
    }

    public String getTname() 
    {
        return tname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tid", getTid())
            .append("tname", getTname())
            .toString();
    }
}
