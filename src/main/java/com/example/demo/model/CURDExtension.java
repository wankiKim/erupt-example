package com.example.demo.model;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.core.exception.EruptApiErrorTip;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Map;

/**
 * @author YuePeng
 * date 2021/5/11 13:56
 * see <a href="https://www.yuque.com/erupts/erupt/nicqg3">link</a>
 */
@Erupt(
        name = "서비스 계층 로직은 @DataProxy를 확장합니다(CURD 확장).",
        desc = "기존 개발의 서비스 계층에 해당하는 추가, 삭제, 수정, 쿼리, 가져오기, 내보내기, 데이터 초기화 등의 이벤트 트리거 논리 인터페이스를 제공합니다.\n" +
                "캐시 쓰기, 데이터 확인, RPC 호출, 동적 할당 등과 같은 기능을 구현할 수 있습니다.！）",
        dataProxy = CURDExtension.class
)
@Entity
@Table(name = "demo_curd_extension")
public class CURDExtension extends BaseModel implements DataProxy<CURDExtension> {

    @EruptField(
            views = @View(title = "이름"),
            edit = @Edit(title = "이름", notNull = true, search = @Search(vague = true))
    )
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void beforeAdd(CURDExtension curdExtension) {
        //字段校验
        if ("ADMIN".equals(curdExtension.getName())) {
            throw new EruptApiErrorTip("이름이 ADMIN이 되는 것이 금지되어 있습니다!");
        }
    }

    @Override
    public void afterAdd(CURDExtension curdExtension) {
        //TODO 添加完成后处理逻辑
    }

    @Override
    public void beforeUpdate(CURDExtension curdExtension) {
        //动态写数据
        curdExtension.setName(curdExtension.getName() + "xxx");
    }

    @Override
    public void afterUpdate(CURDExtension curdExtension) {
        //TODO 修改完成后处理逻辑
    }

    @Override
    public void beforeDelete(CURDExtension curdExtension) {
        //TODO 删除前事件处理逻辑
    }

    @Override
    public void afterDelete(CURDExtension curdExtension) {
        //TODO 删除后事件处理逻辑
    }

    @Override
    public void afterFetch(Collection<Map<String, Object>> list) {
        //TODO 查询结果处理
    }

    @Override
    public void addBehavior(CURDExtension curdExtension) {
        //TODO 数据初始化逻辑
    }

    @Override
    public void editBehavior(CURDExtension curdExtension) {
        //TODO 编辑时数据处理逻辑
    }
}
