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
package at.reppeitsolutions.formbuilder.components.formbuilderitem;

import java.util.Map;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
public interface FormBuilderItem {

    String getFormbuildertype();

    void setFormbuildertype(String formbuildertype);

    int getPosition();

    void setPosition(int position);
    
    public String getClassname();
    
    public void setClassname(String classname);
    
    public String getId();
    
    public void setId(String uuid);
    
    public String getDiagid();
    
    public void setDiagid(String diagid);
    
    public String getWidth();

    public void setWidth(String width);
    
    public FormBuilderItemProperties getProperties();

    public void setProperties(FormBuilderItemProperties properties);
    
    public Map<String, Map> getValueTranslations();
    
    public Map<String, String> getPropertyTranslations();
    
    public Map<String, FormBuilderItemBase.SPECIALPROPERTY> getSpecialProperties();
    
    public boolean getSkipRendering();
    
}