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

import at.reppeitsolutions.formbuilder.components.Constants;
import at.reppeitsolutions.formbuilder.components.annotations.IgnoreProperty;
import at.reppeitsolutions.formbuilder.components.annotations.IgnorePropertyInDialog;
import at.reppeitsolutions.formbuilder.components.html.renderer.multipart.File;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
@Embeddable
public class FormBuilderItemProperties implements Serializable {
    
    @Column(columnDefinition = "text")
    private String label;
    @Column(columnDefinition = "text")
    private String values;
    private Integer size;
    private Integer rows;
    private Integer cols;
    private Integer widthproperty;
    private String layout;
    @Transient
    private boolean renderDescription = false;
    @Transient
    private int labelLength = -1;
    @Embedded
    private File file;
    private String brother;
    private String formatareauuid;
    private Boolean onelinedescription;
        
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

        public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

        public boolean getRenderDescription() {
        return renderDescription;
    }

    public void setRenderDescription(boolean renderDescription) {
        this.renderDescription = renderDescription;
    }

        public int getLabelLength() {
        if(labelLength > Constants.MAXLABELLENGTH) {
            return Constants.MAXLABELLENGTH;
        } else if(labelLength < Constants.MINLABELLENGTH) {
            return Constants.MINLABELLENGTH;
        }
        return labelLength + Constants.LABELLENGTHPADDING;
    }

    public void setLabelLength(int labelLength) {
        this.labelLength = labelLength;
    }

    @IgnoreProperty
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Integer getWidthproperty() {
        return widthproperty;
    }

    public void setWidthproperty(Integer widthProperty) {
        if(widthProperty != null && widthProperty > 100) {
            this.widthproperty = new Integer(100);
        } else if(widthProperty != null && widthProperty < 0) {
            this.widthproperty = new Integer(0);
        } else {
            this.widthproperty = widthProperty;
        }
    }

    @IgnorePropertyInDialog
    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    @IgnorePropertyInDialog
    public String getFormatareauuid() {
        return formatareauuid;
    }

    public void setFormatareauuid(String formatareauuid) {
        this.formatareauuid = formatareauuid;
    }

    public Boolean getOnelinedescription() {
        return onelinedescription;
    }

    public void setOnelinedescription(Boolean onelinedescription) {
        this.onelinedescription = onelinedescription;
    }
}
