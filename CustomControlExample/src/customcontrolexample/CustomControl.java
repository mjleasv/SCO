/*
 * Copyright (c) 2011, 2014 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package customcontrolexample;

import java.io.IOException;
import java.net.URL;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Sample custom control hosting a text field and a button.
 */
//This custom control extends VBox, meaning it can be used where an fxml file's root is set to VBox.
public class CustomControl extends VBox {
    @FXML private TextField textField;

    //Instance variable to save the left value.
    private boolean isLeftOriented;

    public CustomControl(boolean left) {
        isLeftOriented = left;
        
        //Set the default fxml to load, to custom_control_left.fxml
        URL fxmlToLoad = getClass().getResource("custom_control_left.fxml");
        if(!left)
        {
            //If it's not left, set the default to custom_control_right.fxml
            fxmlToLoad = getClass().getResource("custom_control_right.fxml");
        }
        
        //Create the FXML Loader
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlToLoad);
        //Set this instance as the Root and the Controller for the fxml we're about to load.
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        //Try loading the FXML
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public String getText() {
        return textProperty().get();
    }
    
    public void setText(String value) {
        textProperty().set(value);
    }
    
    public StringProperty textProperty() {
        return textField.textProperty();                
    }
        
    @FXML
    protected void doSomething() {
        System.out.println("The "+(isLeftOriented?"left":"right")+" button was clicked!");
    }
}
