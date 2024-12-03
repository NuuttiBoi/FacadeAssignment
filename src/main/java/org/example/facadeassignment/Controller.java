package org.example.facadeassignment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    @FXML
    public ImageView mainImage;
    @FXML
    private Label welcomeText;
    private Facade facade;
    private String joke;
    private String exchangeRate;

    public void initialize() {
        facade = new Facade();
        Image image = new Image("https://www.nydailynews.com/wp-content/uploads/migration/2017/05/07/LWPQIOVCN4ZZ7A7DXXTMOOUBVI.jpg?w=1200");
        mainImage.setImage(image);
        mainImage.setFitHeight(300);
        mainImage.setFitWidth(300);
    }

    public void makeApiCall(){
        // fetch joke from the chuck norris api
        try{
            joke = facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random",
                    "value");
            System.out.println(joke);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        // fetch an attribute from api fxrates
        try{
            exchangeRate = facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest?api_key=fxr_live_38375e3578153b3188720fdc74aa4b3b2759",
                    "base");
            System.out.println("Base: " + exchangeRate);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    protected void onButtonClick() {
        makeApiCall();
        welcomeText.setWrapText(true);
        welcomeText.setText(joke);
    }

}