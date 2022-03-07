package selfEditor;

import java.beans.PropertyEditorSupport;

/**
 * @author jiangyuanchu
 * @description 属性资源编辑器
 * @data 2022/2/23 9:33 上午
 */
public class AddressPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
         String[] s = text.split("_");
         Address address = new Address();
         address.setProvince(s[0]);
         address.setCity(s[1]);
         this.setValue(address);
    }
}
