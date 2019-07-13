package sda.spring.springvadin.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
public class HalloTestGUI extends VerticalLayout {

    public HalloTestGUI() {

        TextField textFieldName = new TextField();
        Button buttonOk = new Button("All ok!", new Icon(VaadinIcon.BUG));
        Label helloLabel = new Label();

        buttonOk.addClickListener(click -> {
            helloLabel.setText("Hello cow " + textFieldName.getValue());
            Image image = new Image("https://media3.giphy.com/media/gJcvQpuy158Os/giphy.gif?cid=790b76115d29925c3039327a51be576c&rid=giphy.gif", "Cannot load gif");
            add(image);
        });

        add(textFieldName);
        add(buttonOk);
        add(helloLabel);
    }
}