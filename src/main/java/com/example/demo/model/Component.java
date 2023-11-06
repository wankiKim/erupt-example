package com.example.demo.model;

import com.example.demo.handler.AutoCompleteHandlerImpl;
import com.example.demo.handler.ComponentDataProxy;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author liyuepeng
 * @date 2020-02-29
 */
@Erupt(
        name = "구성요소 예",
        dataProxy = ComponentDataProxy.class //事件代理，非常有用的功能 ！
)
@Table(name = "demo_component")
@Entity
public class Component extends BaseModel {

    @EruptField(
            views = @View(title = "본문"),
            edit = @Edit(title = "본문", search = @Search(vague = true))
    )
    private String input;

    @EruptField(
            views = @View(title = "숫자"),
            edit = @Edit(title = "숫자", search = @Search(vague = true))
    )
    private Double number1;

    @EruptField(
            views = @View(title = "숫자 슬라이더"),
            edit = @Edit(title = "숫자 슬라이더", type = EditType.SLIDER)
    )
    private Integer slider;

    @EruptField(
            views = @View(title = "부울"),
            edit = @Edit(title = "부울", search = @Search)
    )
    private Boolean bool;

    @EruptField(
            views = @View(title = "자동 완성"),
            edit = @Edit(title = "자동 완성", search = @Search(vague = true), type = EditType.AUTO_COMPLETE,
                    autoCompleteType = @AutoCompleteType(handler = AutoCompleteHandlerImpl.class))
    )
    private String autoComplete;

    @EruptField(
            views = @View(title = "색상 선택"),
            edit = @Edit(title = "색상 선택", search = @Search(vague = true), inputType = @InputType(type = "color"))
    )
    private String color;

    @EruptField(
            views = @View(title = "주 선택기"),
            edit = @Edit(title = "주 선택기", search = @Search(vague = true), inputType = @InputType(type = "week"))
    )
    private String weekInput;

    @ManyToOne
    @EruptField(
            edit = @Edit(title = "기사 선택", type = EditType.REFERENCE_TABLE,
                    referenceTableType = @ReferenceTableType(label = "title"))
    )
    private Article article;

    @ManyToOne
    @EruptField(
            edit = @Edit(title = "many to one ", search = @Search, type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name", pid = "parent.id"))
    )
    private TreeView tree;

    @EruptField(
            views = @View(title = "Tag selection"),
            edit = @Edit(title = "Tag selection", search = @Search, type = EditType.TAGS)
    )
    private String tags;

    @Transient
    @EruptField(
            edit = @Edit(title = "Time selection", type = EditType.DIVIDE)
    )
    private String dateDiv;

    @EruptField(
            views = @View(title = "date"),
            edit = @Edit(title = "date", type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE), search = @Search(vague = true))
    )
    private Date date1;

    @EruptField(
            views = @View(title = "time date"),
            edit = @Edit(title = "time date", type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE_TIME), search = @Search(vague = true))
    )
    private Date dateTime;

    @EruptField(
            views = @View(title = "time"),
            edit = @Edit(title = "time", type = EditType.DATE, dateType = @DateType(type = DateType.Type.TIME), search = @Search)
    )
    private String time;

    @EruptField(
            views = @View(title = "week"),
            edit = @Edit(title = "week", type = EditType.DATE, dateType = @DateType(type = DateType.Type.WEEK), search = @Search)
    )
    private String week;

    @EruptField(
            views = @View(title = "month"),
            edit = @Edit(title = "month", type = EditType.DATE, dateType = @DateType(type = DateType.Type.MONTH), search = @Search)
    )
    private String month;

    @EruptField(
            views = @View(title = "year"),
            edit = @Edit(title = "year", type = EditType.DATE, dateType = @DateType(type = DateType.Type.YEAR), search = @Search)
    )
    private String year;

    @EruptField(
            views = @View(title = "past time"),
            edit = @Edit(title = "past time", type = EditType.DATE, dateType = @DateType(pickerMode = DateType.PickerMode.HISTORY), search = @Search)
    )
    private String history;

    @EruptField(
            views = @View(title = "future time"),
            edit = @Edit(title = "future time", type = EditType.DATE, dateType = @DateType(pickerMode = DateType.PickerMode.FUTURE), search = @Search)
    )
    private String feature;

    public void setInput(String input) {
        this.input = input;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
