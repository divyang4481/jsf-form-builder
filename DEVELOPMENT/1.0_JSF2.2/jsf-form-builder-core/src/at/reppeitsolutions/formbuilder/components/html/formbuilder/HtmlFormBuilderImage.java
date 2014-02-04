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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputFile;
import javax.faces.component.html.HtmlOutputText;
import at.reppeitsolutions.formbuilder.messages.Messages;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
public class HtmlFormBuilderImage extends HtmlFormBuilderItem {

    @Override
    public void renderView() {
        HtmlOutputText output = new HtmlOutputText();
        output.setValue(Messages.getStringJSF("image.label.default"));

        if (properties.getFile() == null || properties.getFile().getFilesize() == 0) {
            HtmlInputFile input = new HtmlInputFile();
            input.setId("image" + getItemUuid());
            addLabeledComponent(output, input);
            HtmlCommandButton submit = new HtmlCommandButton();
            submit.setValue(Messages.getStringJSF("image.submit"));
            getChildren().add(submit);
        } else {
            try {
                File tempFile = File.createTempFile(properties.getFile().getFilename(), "");
                try (FileOutputStream out = new FileOutputStream(tempFile)) {
                    out.write(properties.getFile().getFile());
                    out.flush();
                    out.close();
                }
                HtmlGraphicImage image = new HtmlGraphicImage();
                image.setStyle("border:0px; width: " + properties.getWidthproperty() + "%;");
                image.setUrl("/images/" + tempFile.getName());
                getChildren().add(image);
            } catch (IOException ex) {
                Logger.getLogger(HtmlFormBuilderImage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
