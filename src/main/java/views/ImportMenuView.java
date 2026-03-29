package views;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImportMenuView extends BaseView{

	private static final Logger logger = LogManager.getLogger(ImportMenuView.class);
	private ColumnConstraints column;
	private RowConstraints row;
	public ImportMenuView() {
		view = createView();
	}

	@Override
	public Parent createView() {
		GridPane grid = new GridPane();
		grid.getStyleClass().add("grid");
		grid.setPrefSize(800, 600);
		grid.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

		for (int i = 0; i < 12; i++) {
			row = new RowConstraints();
			if (i < 2) {
				row.setPercentHeight(5); // 5 x 2 = 10
			} else {
				row.setPercentHeight(9); // 9 x 10 = 90
			}
			grid.getRowConstraints().add(row);
		}


		for (int i = 0; i < 12; i++) {
			column = new ColumnConstraints();
			if (i < 3) {
				column.setPercentWidth(5);
			} else if (i == 5){
				column.setPercentWidth(3);
			} else {
				column.setPercentWidth(10.25);
			}
			grid.getColumnConstraints().add(column);
		}

		VBox navBar = new VBox();  // create a new VBox
		navBar.getStyleClass().add("navBar");
		GridPane.setConstraints(navBar, 0, 0, 3, GridPane.REMAINING);
		// add the VBox to the GridPane

		HBox topBar = new HBox();
		topBar.getStyleClass().add("topBar");
		GridPane.setConstraints(topBar, 3, 0, GridPane.REMAINING, 2);

		HBox logo = new HBox();
		logo.setPrefWidth((column.getPercentWidth()-1)*3);
		logo.getStyleClass().add("logo");


		ImageView logoImage = new ImageView();
		logoImage.setImage(new Image(getClass().getResourceAsStream(
				"/stylesheets/Design/purple sphere.png")));
		logoImage.setPreserveRatio(true);
		logoImage.setFitWidth(70);
		logoImage.setFitHeight(90);


		VBox logoText = new VBox();
		logoText.setAlignment(Pos.CENTER);
		Text name = new Text("Nebula");
		name.getStyleClass().add("logoName");
		Text tagline = new Text("Dashboard");
		tagline.getStyleClass().add("logoTagline");
		logoText.getChildren().addAll(name, tagline);

		logo.getChildren().addAll(logoImage, logoText);
		logo.setAlignment(Pos.TOP_LEFT);
		logo.setSpacing(2);

		VBox instructionsBox = new VBox();
		Text instructions = new Text("Upload via button to create the respective charts for Impressions, Clicks and Server ");
		instructions.getStyleClass().add("instructions");
		instructionsBox.getChildren().addAll(instructions);
		instructionsBox.setAlignment(Pos.CENTER_RIGHT);

//        VBox logsBox = new VBox();
//        Label impressionsText = new Label("1. Impressions Log");
//        Button importCSV1 = new Button("Import CSV");
//        Button importCSV2 = new Button("Import CSV");
//        Button importCSV3 = new Button("Import CSV");
//        Label clicksText = new Label("2. Clicks Log");
//        Label serverText = new Label("3. Server Log");
//        logsBox.getChildren().addAll(impressionsText, importCSV1, clicksText, importCSV2, serverText, importCSV3);

		ImageView chartImage = new ImageView();
		chartImage.setImage(new Image(getClass().getResourceAsStream(
				"/stylesheets/Design/graph.png")));
		chartImage.setPreserveRatio(true);
		chartImage.setFitWidth(300);
		chartImage.setFitHeight(200);

		ImageView chartImage2 = new ImageView();
		chartImage2.setImage(new Image(getClass().getResourceAsStream(
				"/stylesheets/Design/graph.png")));
		chartImage2.setPreserveRatio(true);
		chartImage2.setFitWidth(300);
		chartImage2.setFitHeight(200);

		ImageView chartImage3 = new ImageView();
		chartImage3.setImage(new Image(getClass().getResourceAsStream(
				"/stylesheets/Design/graph.png")));
		chartImage3.setPreserveRatio(true);
		chartImage3.setFitWidth(300);
		chartImage3.setFitHeight(200);

		HBox impressionsLog = new HBox();
		Text impressionsText = new Text("1. Impressions Log");
		impressionsText.getStyleClass().add("instructions");
		Button importCSV1 = new Button("Import CSV");
		importCSV1.getStyleClass().add("btn");
		VBox textAndButton = new VBox();
		textAndButton.getChildren().addAll(impressionsText, importCSV1);
		textAndButton.setAlignment(Pos.TOP_CENTER);
		textAndButton.setSpacing(15);
		impressionsLog.getChildren().addAll(chartImage, textAndButton);

		HBox clicksLog = new HBox();
		Text clicksText = new Text("2. Clicks Log");
		clicksText.getStyleClass().add("instructions");
		Button importCSV2 = new Button("Import CSV");
		importCSV2.getStyleClass().add("btn");
		VBox textAndButton2 = new VBox();
		textAndButton2.getChildren().addAll(clicksText, importCSV2);
		textAndButton2.setAlignment(Pos.TOP_CENTER);
		textAndButton2.setSpacing(15);
		clicksLog.getChildren().addAll(chartImage2, textAndButton2);

		HBox serverLog = new HBox();
		Text serverText = new Text("3. Server Log");
		serverText.getStyleClass().add("instructions");
		Button importCSV3 = new Button("Import CSV");
		importCSV3.getStyleClass().add("btn");
		VBox textAndButton3 = new VBox();
		textAndButton3.getChildren().addAll(serverText, importCSV3);
		textAndButton3.setAlignment(Pos.TOP_CENTER);
		textAndButton3.setSpacing(15);
		serverLog.getChildren().addAll(chartImage3, textAndButton3);

		home = new ImportMenuView.NavButton("home", "Home");
		statistics = new ImportMenuView.NavButton("stats", "Statistics");
		load = new ImportMenuView.NavButton("import", "Import");
		help = new ImportMenuView.NavButton("help", "Help");
		print = new ImportMenuView.NavButton("print", "Print");

		VBox buttonBox = new VBox();
		buttonBox.setPrefWidth((column.getPercentWidth()-1)*3);
		buttonBox.getStyleClass().add("buttonBox");
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(35);
		buttonBox.getChildren().addAll(home,statistics, load,help, print);

		//Creating settings
		settings = new ImportMenuView.NavButton("settings", "Settings");
		VBox settingsBox = new VBox();
		settingsBox.setPrefWidth((column.getPercentWidth()-1)*3);
		settingsBox.getStyleClass().add("buttonBox");
		settingsBox.setAlignment(Pos.BOTTOM_CENTER);
		settingsBox.getChildren().addAll(settings);

		home.setPadding(new Insets(80, 0, 0, 20));
		settings.setPadding(new Insets(170, 0, 0, 20));

		navBar.getChildren().addAll(logo,buttonBox, settingsBox);
		grid.getChildren().addAll(topBar, navBar);
		//grid.setGridLinesVisible(true);
		//Add the centre box to the correct co-ordinates on the gridpane
		grid.add(instructionsBox, 4, 3);
		grid.add (impressionsLog, 3, 5);
		grid.add (clicksLog, 3, 8);
		GridPane.setConstraints(impressionsLog, 3, 5, 3,1);
		GridPane.setMargin(impressionsLog, new Insets(0, 0, 0, 50));
		GridPane.setConstraints(clicksLog, 3, 8, 3,1);
		GridPane.setMargin(clicksLog, new Insets(0, 0, 0, 50));

		grid.add (serverLog, 8, 5);
		grid.setAlignment(Pos.CENTER);
		//grid.add(logsBox, 9, 4);

		return grid;
	}
}

