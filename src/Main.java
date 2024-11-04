//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ProgressBar;



public class Main extends Application {
    int numOfCookies = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mini Game: Cookie Clicker");

        MenuItem menuItem1 = new MenuItem("Learn More");
       menuItem1.setOnAction(actionEvent -> {
            TextArea textArea = new TextArea();
            TextField textField = new TextField();
            VBox vbox1 = new VBox(textArea,textField);
            System.out.println(vbox1);
        });

        MenuItem menuItem2 = new MenuItem("Help?");
        MenuItem menuItem3 = new MenuItem("Settings");
        menuItem3.setOnAction(actionEvent -> {
            System.out.println("not available :( ");
        });

        MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3);

        Label label1 = new Label("Click for Cookies!!!");
        label1.setFont(Font.font("Comic Sans", FontWeight.BOLD, 36));
        Text text1 = new Text("number of cookies:");

        FileInputStream input = new FileInputStream("src/cookie7.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        Button button1 = new Button("",imageView);


        FileInputStream input1 = new FileInputStream("src/milk4.jpg");
        Image image1 = new Image(input1);
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(100);
        imageView1.setFitWidth(100);
        Button button2 = new Button("", imageView1);

        FileInputStream input2 = new FileInputStream("src/chocolatemilk3.jpg");
        Image image2 = new Image(input2);

        FileInputStream input3 = new FileInputStream("src/strawmilk4.png");
        Image image3 = new Image(input3);

        CheckBox checkBox1 = new CheckBox("having fun?");
        checkBox1.setOnAction(actionEvent -> {
            System.out.println("Glad to hear :)");
        });

        ColorPicker colorPicker = new ColorPicker();

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.setOnAction(actionEvent -> {
           Object choice  = choiceBox.getValue();
           System.out.println(choice);
           if (choice.toString().equalsIgnoreCase("Milk")) {
                imageView1.setImage(image1);

            } else if (choice.toString().equalsIgnoreCase("Chocolate Milk")) {
               imageView1.setImage(image2);

           } else {
               imageView1.setImage(image3);

           }
        });

        choiceBox.getItems().add("Milk");
        choiceBox.getItems().add("Chocolate Milk");
        choiceBox.getItems().add("Strawberry Milk");

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setProgress(0.5);


        //bts work ;)
        button1.setOnAction(actionEvent -> {
            numOfCookies = numOfCookies + 1;
            text1.setText("number of cookies: "+ numOfCookies);

        });

            HBox hbox = new HBox(label1);
            HBox hbox2 = new HBox(menuButton,choiceBox,colorPicker,progressBar);
            VBox vbox = new VBox(button1);
            HBox hbox3 = new HBox(button2);
            VBox extra = new VBox(hbox2,hbox, vbox, text1,checkBox1,hbox3);

        colorPicker.setOnAction(actionEvent -> {
            Color value = colorPicker.getValue();
            // create a background fill
            BackgroundFill background_fill = new BackgroundFill(value,
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background = new Background(background_fill);

            // set background
            extra.setBackground(background);

        });

            Scene scene = new Scene(extra, 400, 300);
            //Scene scene2 = new Scene(menuItem1, 30,30);

            primaryStage.setScene(scene);

            primaryStage.show();


    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}