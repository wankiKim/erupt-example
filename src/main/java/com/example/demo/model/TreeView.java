package com.example.demo.model;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author yuepeng
 * @date 12/7/18.
 */

@Entity
@Table(name = "demo_tree")
@Erupt(
        name = "Tree Ex",
        orderBy = "TreeView.sort",
        tree = @Tree(pid = "parent.id")
)
public class TreeView extends BaseModel {

    @EruptField(
            views = @View(title = "이름"),
            edit = @Edit(title = "이름", notNull = true)
    )
    private String name;

    @EruptField(
            views = @View(title = "표시 순서"),
            edit = @Edit(title = "표시 순서")
    )
    private Integer sort;

    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "Tree Node",
                    type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            )
    )
    private TreeView parent;


}
