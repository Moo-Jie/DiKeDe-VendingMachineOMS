package com.dkd.manage.domain.Vo;

import com.dkd.manage.domain.Partner;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)//继承父类 equals 和 hashCode 方法
public class PartnerVO extends Partner {
    private Integer nodeCount;
}
