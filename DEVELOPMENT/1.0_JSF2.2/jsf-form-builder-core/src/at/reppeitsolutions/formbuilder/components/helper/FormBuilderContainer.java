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
package at.reppeitsolutions.formbuilder.components.helper;

import at.reppeitsolutions.formbuilder.components.formbuilderitem.FormBuilderItem;
import at.reppeitsolutions.formbuilder.components.html.formbuilder.HtmlFormBuilderItem;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
public class FormBuilderContainer {
    
    FormBuilderItem fbitem;
    HtmlFormBuilderItem htmlfbitem;

    public FormBuilderContainer(FormBuilderItem fbitem, HtmlFormBuilderItem htmlfbitem) {
        this.fbitem = fbitem;
        this.htmlfbitem = htmlfbitem;
    }
    
    public FormBuilderItem getFbitem() {
        return fbitem;
    }

    public void setFbitem(FormBuilderItem fbitem) {
        this.fbitem = fbitem;
    }

    public HtmlFormBuilderItem getHtmlfbitem() {
        return htmlfbitem;
    }

    public void setHtmlfbitem(HtmlFormBuilderItem htmlfbitem) {
        this.htmlfbitem = htmlfbitem;
    }
}
