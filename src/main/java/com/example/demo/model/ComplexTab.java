package com.example.demo.model;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author liyuepeng
 * @date 2021-01-02.
 */
@Erupt(name = "One-to-many")
@Table(name = "demo_complex_tab")
@Entity
public class ComplexTab extends BaseModel {

    @EruptField(
            views = @View(title = "text"),
            edit = @Edit(title = "text", notNull = true)
    )
    private String input;

    @EruptField(
            views = @View(title = "numerical value", sortable = true),
            edit = @Edit(title = "numerical value")
    )
    private Float number;

}
