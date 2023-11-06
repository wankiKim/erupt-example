package com.example.demo.model;
/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Erupt(name = "학생 관리")
@Table(name = "t_student")
@Entity
public class Student extends BaseModel {

    @EruptField(
            views = @View(
                    title = "이름", sortable = true
            ),
            edit = @Edit(
                    title = "이름",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

    @EruptField(
            views = @View(
                    title = "나이", sortable = true
            ),
            edit = @Edit(
                    title = "나이",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer age;

    @EruptField(
            views = @View(
                    title = "지도"
            ),
            edit = @Edit(
                    title = "지도",
                    type = EditType.MAP, search = @Search, notNull = true
            )
    )
    private String map;

    @EruptField(
            views = @View(
                    title = "생일", sortable = true
            ),
            edit = @Edit(
                    title = "생일",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType
            )
    )
    private Date birthday;

    @EruptField(
            views = @View(
                    title = "성별", sortable = true
            ),
            edit = @Edit(
                    title = "성별",
                    type = EditType.BOOLEAN, search = @Search, notNull = true,
                    boolType = @BoolType
            )
    )
    private Boolean gender;

}