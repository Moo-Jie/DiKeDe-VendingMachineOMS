package com.dkd.manage.domain.Vo;

import com.dkd.manage.domain.Region;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@EqualsAndHashCode(callSuper = true)//继承父类 equals 和 hashCode 方法
@Data
@Builder
public class RegionVO extends Region {
        private Integer nodeCount;
        @Override
        public String toString() {
                return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                        .append("id", getId())
                        .append("regionName", getRegionName())
                        .append("createTime", getCreateTime())
                        .append("updateTime", getUpdateTime())
                        .append("createBy", getCreateBy())
                        .append("updateBy", getUpdateBy())
                        .append("remark", getRemark())
                        .append("nodeCount", getNodeCount())
                        .toString();
        }
}
