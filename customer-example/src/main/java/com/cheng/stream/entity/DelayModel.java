package com.cheng.stream.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DelayModel {
    /**
     * 延迟投递的时长. 单位: ms
     */
    private long delay;
}