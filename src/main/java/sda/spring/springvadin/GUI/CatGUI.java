package sda.spring.springvadin.GUI;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import sda.spring.springvadin.CatFactClient;
import sda.spring.springvadin.CatPicClient;
import sda.spring.springvadin.CatPicClientObjectImplementation;
import sda.spring.springvadin.models.CatFact;

@Route("cat")
public class CatGUI extends VerticalLayout {

    @Autowired
    public CatGUI(CatFactClient catFactClient, CatPicClient catPicClient,
                  CatPicClientObjectImplementation catPicClientObjectImplementation) {

        String catPic = catPicClient.getCatPicFromApi();
        CatFact catFact = catFactClient.getCatFactFromApi();
        String catPicClientObjectImplementation1 = catPicClientObjectImplementation.getCatPicFromApi();

        Image catImage = new Image(catPic, "No image");
        Image catJpeg = new Image(catPicClientObjectImplementation1, "Nima kota");
        Label label = new Label(catFact.getText());
        add(catImage, label, catJpeg);
    }
}