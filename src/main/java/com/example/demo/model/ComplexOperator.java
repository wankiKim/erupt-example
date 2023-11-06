package com.example.demo.model;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.jpa.model.BaseModel;

import java.util.Date;


@Erupt(name = "Operator Dialog")
public class ComplexOperator extends BaseModel {

    @EruptField(
            edit = @Edit(title = "Text parameters", notNull = true)
    )
    private String text;

    @EruptField(
            edit = @Edit(title = "time parameter", notNull = true)
    )
    private Date date;
}
