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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomControlExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox();
        
        HBox hbox = new HBox();
        vbox.getChildren().add(hbox);
        
        CustomControl customControlLeft = new CustomControl(true);
        customControlLeft.setText("Hello Lefties!");
        
        hbox.getChildren().add(customControlLeft);
        
        CustomControl customControlRight = new CustomControl(false);
        customControlRight.setText("Hello Rightoes!");
        
        hbox.getChildren().add(customControlRight);
        
        VeryDifferentCustomControl diffControl = new VeryDifferentCustomControl(4);
        vbox.getChildren().add(diffControl);
        
        //ControllerFactory Example: 
        //https://stackoverflow.com/questions/36780986/in-javafx-8-can-a-controller-be-dynamically-added-to-a-node-not-created-using-f
        
        stage.setScene(new Scene(vbox));
        stage.setTitle("Custom Control");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
