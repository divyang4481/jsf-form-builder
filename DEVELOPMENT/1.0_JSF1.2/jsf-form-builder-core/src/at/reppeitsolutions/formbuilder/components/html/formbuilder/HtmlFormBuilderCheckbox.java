/* 
 * Copyright (C) 2014 Mathias Reppe <mathias.reppe@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package at.reppeitsolutions.formbuilder.components.html.formbuilder;

import javax.faces.component.UISelectItem;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectManyCheckbox;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
public class HtmlFormBuilderCheckbox extends HtmlFormBuilderItem {
    
    @Override
    public void renderView() {
        HtmlSelectManyCheckbox select = new HtmlSelectManyCheckbox();
        select.setLayout(properties.getLayout());
        String[] valueArray = properties.getValues().split(";");
        for(int i = 0; i < valueArray.length; ++i) {
            UISelectItem item = new UISelectItem();
            item.setItemValue(valueArray[i]);
            item.setItemLabel(valueArray[i]);
            select.getChildren().add(item);
        }
        
        if(value != null) {
            select.setSelectedValues(value.split(";"));
        }
        if(getDataUuid() != null) {
            select.setId(getDataUuid());
        }
        
        HtmlOutputText output = new HtmlOutputText();
        output.setValue(properties.getLabel());
        
        addLabeledComponent(output, select, "");
    }
    
}
