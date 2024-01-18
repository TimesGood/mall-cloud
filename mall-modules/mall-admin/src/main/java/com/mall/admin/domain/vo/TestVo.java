package com.mall.admin.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestVo implements Serializable {
    private Long id;

    private Long subjectId;

    private String subjectName;

    private Integer recommendStatus;
}
