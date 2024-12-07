package com.dkd.manage.domain.Vo;

import com.dkd.manage.domain.Node;
import com.dkd.manage.domain.Partner;
import com.dkd.manage.domain.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@Builder
@EqualsAndHashCode(callSuper = true)//继承父类 equals 和 hashCode 方法
public class NodeVO extends Node {
    //设备数量
    private int vmCount;
    //区域信息
    private Region region;
    //合作商信息
    private Partner partner;
}
