package dmtools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Christopher Stewart (ZolonGames Software Development)
 * @version 0.4.0
 */
public class DMToolsController extends Application
{
	//FXML Nodes	
	
	//Shop Generator Tab
	@FXML private static TextArea itemOutputWindow;
	@FXML private static TextArea costOutputWindow;
	@FXML private static TextField magicChance;
	@FXML private static Button saveButton;
	@FXML private static Button genButton;
	@FXML private static Button loadButton;
	@FXML private static ChoiceBox<Shop> shopPicker;
	@FXML private static ChoiceBox<String> shopTypePicker;
	@FXML private static ChoiceBox<String> shopSizePicker;
	@FXML private static Label shopName;
	@FXML private static ToggleGroup shopControl;
	@FXML private static TextField nameField;
	@FXML private static RadioButton newShopRadio;
	@FXML private static RadioButton existingShopRadio;
	
	// Time Control Tab
	@FXML private static TextField dateField;
	@FXML private static Button addSecond;
	@FXML private static Button addRound;
	@FXML private static Button addMinute;
	@FXML private static Button addHour;
	@FXML private static Button addLongRest;
	@FXML private static Button addDay;
	@FXML private static Button addWeek;
	@FXML private static Button addMonth;
	@FXML private static Button saveDate;
	@FXML private static Button loadDate;
	@FXML private static Button newDate;
	
	//Access Variables
	protected static Stage mainStage;
	protected static DMDate currDate;
		
	/***** Main Program Methods *****/
	
	public static void main(String[] args) 
	{
		File saveDir = new File(System.getProperty("user.dir") + "/saves");
		if (!saveDir.exists())
		{
			saveDir.mkdir();
		}
		currDate = new DMDate();
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception 
	{
		Parent root = FXMLLoader.load(getClass().getResource("mainLayout.fxml"));
		addShopTypes();
		addShopSizes();
		// Set the stage to the fxml file
		stage.setScene(new Scene(root));
		mainStage = stage;
		// Disable resizing the window
		stage.setResizable(false);
		// Set window title
		stage.setTitle("D&D 1e Dungeon Master Tools");
		// Show window
		stage.show();
		setShopPickerEvent();
		updateDate();
		
	}
	
	/***** Shop Generator Methods *****/
	
	private void setShopPickerEvent() 
	{
		shopPicker.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
		{
			public void changed(@SuppressWarnings("rawtypes") ObservableValue ov, Number value, Number new_value)
			{
				Shop currShop = shopPicker.getItems().get((Integer) new_value);
				refreshStockList(currShop);
			}
		});
	}
	
	protected void refreshStockList(Shop currShop) 
	{
		itemOutputWindow.clear();
		costOutputWindow.clear();
		String[] results = new String[2];
		
		shopName.setText(currShop.name);
		
		results = currShop.getExistingData();
		
		if (results[0].equals(""))
		{
			itemOutputWindow.setText("No available items. Check back later.");	
		}
		else
		{
			itemOutputWindow.setText(results[0]);
			costOutputWindow.setText(results[1]);	
		}
		
	}

	private void addShopSizes() 
	{
		shopSizePicker.setItems(FXCollections.observableArrayList(Data1e.sizes));
		shopSizePicker.setValue(Data1e.sizes[2]);
	}

	private void addShopTypes() 
	{
		shopTypePicker.setItems(FXCollections.observableArrayList(Data1e.shopsTypes));
		shopTypePicker.setValue(Data1e.shopsTypes[7]);
	}

	private void generateStock() 
	{
		itemOutputWindow.clear();
		costOutputWindow.clear();	
		
		Shop currShop = shopPicker.getValue();
		String[] results = {"", ""};
		shopName.setText(currShop.name);
		results = currShop.generate();
		
		if (results[0].equals(""))
		{
			itemOutputWindow.setText("No available items. Check back later.");	
		}
		else
		{
			itemOutputWindow.setText(results[0]);
			costOutputWindow.setText(results[1]);	
		}		
	}

	private void addShop() 
	{
		Shop newShop = null;
		String type = shopTypePicker.getValue();
		String currSize = shopSizePicker.getValue();
		String name = nameField.getText();
		
		int size = 0;
		int magicChance = 0;
		int[] types = null;
		
		for (int i = 0; i < Data1e.sizes.length; i++)
		{
			if (Data1e.sizes[i].equals(currSize))
			{
				if (type.equals("Docks"))
				{
					size = Data1e.docksSizes[i];
					magicChance = Data1e.docksMChance[i];
					types = Data1e.docksTypes;
				}
				else if (type.equals("Black Market"))
				{
					size = Data1e.bmarketSizes[i];
					magicChance = Data1e.bmarketMChance[i];
					types = Data1e.bmarketTypes;
				}
				else if (type.equals("Stables"))
				{
					size = Data1e.stablesSizes[i];
					magicChance = Data1e.stablesMChance[i];
					types = Data1e.stablesTypes;
				}
				else if (type.equals("Armorer"))
				{
					size = Data1e.armorerSizes[i];
					magicChance = Data1e.armorerMChance[i];
					types = Data1e.armorerTypes;
				}
				else if (type.equals("Leatherworker"))
				{
					size = Data1e.lwerSizes[i];
					magicChance = Data1e.lwerMChance[i];
					types = Data1e.lwerTypes;
				}
				else if (type.equals("Blacksmith"))
				{
					size = Data1e.bsmithSizes[i];
					magicChance = Data1e.bsmithMChance[i];
					types = Data1e.bsmithTypes;
				}
				else if (type.equals("Jeweler"))
				{
					size = Data1e.jewelerSizes[i];
					magicChance = Data1e.jewelerMChance[i];
					types = Data1e.jewelerTypes;
				}
				else if (type.equals("General Store"))
				{
					size = Data1e.gstoreSizes[i];
					magicChance = Data1e.gstoreMChance[i];
					types = Data1e.gstoreTypes;
				}
				else if (type.equals("Alchemist"))
				{
					size = Data1e.alchemistSizes[i];
					magicChance = Data1e.alchemistMChance[i];
					types = Data1e.alchemistTypes;
				}
				else if (type.equals("Sage"))
				{
					size = Data1e.sageSizes[i];
					magicChance = Data1e.sageMChance[i];
					types = Data1e.sageTypes;
				}
				else if (type.equals("Fletcher"))
				{
					size = Data1e.fletcherSizes[i];
					magicChance = Data1e.fletcherMChance[i];
					types = Data1e.fletcherTypes;
				}
				else if (type.equals("Trader"))
				{
					size = Data1e.traderSizes[i];
					magicChance = Data1e.traderMChance[i];
					types = Data1e.traderTypes;
				}
			}
		}
		
		if (name.equals(""))
		{
			newShop = new Shop(types, size, magicChance, type);
		}
		else
		{
			newShop = new Shop(name, types, size, magicChance, type);
		}
		
		// Update list
		newShop.generate();
		shopPicker.getItems().add(newShop);
		shopPicker.setValue(shopPicker.getItems().get(shopPicker.getItems().size() - 1));
		refreshStockList(newShop);
		if (existingShopRadio.isDisabled())
		{
			existingShopRadio.setDisable(false);
			saveButton.setDisable(false);
		}
	}
	
	/***** Shop Generator Event Handlers *****/
	
	@FXML
	public void generateShop(ActionEvent ae)
	{
		if (newShopRadio.isSelected())
		{
			addShop();
		}
		else if (existingShopRadio.isSelected())
		{
			generateStock();
		}
	}
	
	// DEPRECATED: REMOVE
	@FXML
	public void changeMagicCheck(ActionEvent ae)
	{
		//outputWindow.appendText("Generate!");
		
	}
	
	@FXML
	public void newShopClicked(ActionEvent ae)
	{
		genButton.setText("Create Shop");	
	}
	
	@FXML
	public void existingShopClicked(ActionEvent ae)
	{
		genButton.setText("Refresh Stock");
	}
	
	@FXML
	public void loadShopFile(ActionEvent ae)
	{
		try {
			FileChooser newFile = new FileChooser();
			newFile.setInitialDirectory(new File(System.getProperty("user.dir") + "/saves"));
			newFile.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Shop Files (.shop)",
							"*.shop")); 
			File file = newFile.showOpenDialog(mainStage);
			String path = file.getAbsolutePath();

			if (!path.contains(".shop")) 
			{
				JOptionPane.showMessageDialog(null, "Invalid File Type. Please load"
						+ " a shop file!");
			}
			else 
			{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(
						new File(path)));
				Shop currShop = (Shop) in.readObject();
				shopPicker.getItems().add(currShop);
				shopPicker.setValue(shopPicker.getItems().get(shopPicker.getItems().size() - 1));
				refreshStockList(currShop);
				in.close();
				
				if (existingShopRadio.isDisabled())
				{
					existingShopRadio.setDisable(false);
					saveButton.setDisable(false);
				}
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void saveShopFile(ActionEvent ae)
	{
		Shop currShop = shopPicker.getValue();
		FileChooser newFile = new FileChooser();
		newFile.setInitialDirectory(new File(System.getProperty("user.dir") + "/saves"));

		newFile.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Shop Files (.shop)", "*.shop"));
		
		File file = newFile.showSaveDialog(mainStage);
		String path = file.getAbsolutePath();
		
		if (!path.contains(".shop")) 
		{
			path += ".shop";
		}
		
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
					new File(path)));
			out.writeObject(currShop);
			out.close();
		} catch (IOException e) 
		{
			//
		}
		
	}
	/***** Time Control Methods *****/
	
	private void updateDate()
	{
		dateField.setText(currDate.getDateString());
	}
	
	/***** Time Control Event Handlers *****/
	
	@FXML
	public void addSecond (ActionEvent ae)
	{
		currDate.addSecond(1);
		updateDate();
	}
	
	@FXML
	public void addRound (ActionEvent ae)
	{
		currDate.addSecond(6);
		updateDate();
	}
	
	@FXML
	public void addMinute (ActionEvent ae)
	{
		currDate.addMinute(1);	
		updateDate();
	}
	
	@FXML
	public void addHour (ActionEvent ae)
	{
		currDate.addHour(1);	
		updateDate();
	}
	
	@FXML
	public void addLongRest (ActionEvent ae)
	{
		currDate.addHour(8);	
		updateDate();
	}
	
	@FXML
	public void addDay (ActionEvent ae)
	{
		currDate.addDay(1);
		updateDate();
	}
	
	@FXML
	public void addWeek (ActionEvent ae)
	{
		currDate.addDay(DMDate.DAYS_IN_WEEK);
		updateDate();
	}
	
	@FXML
	public void addMonth (ActionEvent ae)
	{
		currDate.addMonth(1);
		updateDate();
	}
	
	@FXML
	public void saveDate  (ActionEvent ae)
	{
		FileChooser newFile = new FileChooser();
		newFile.setInitialDirectory(new File(System.getProperty("user.dir") + "/saves"));

		newFile.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Date Files (.date)", "*.date"));
		
		File file = newFile.showSaveDialog(mainStage);
		String path = file.getAbsolutePath();
		
		if (!path.contains(".date")) 
		{
			path += ".date";
		}
		
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
					new File(path)));
			out.writeObject(currDate);
			out.close();
		} catch (IOException e) 
		{
			//
		}
	}
	
	@FXML
	public void loadDate(ActionEvent ae)
	{
		try {
			FileChooser newFile = new FileChooser();
			newFile.setInitialDirectory(new File(System.getProperty("user.dir") + "/saves"));
			newFile.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Date Files (.date)",
							"*.date")); 
			File file = newFile.showOpenDialog(mainStage);
			String path = file.getAbsolutePath();

			if (!path.contains(".date")) 
			{
				JOptionPane.showMessageDialog(null, "Invalid File Type. Please load"
						+ " a date file!");
			}
			else 
			{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(
						new File(path)));
				currDate = (DMDate) in.readObject();
				updateDate();
				in.close();
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void newDate (ActionEvent ae)
	{
		currDate = new DMDate();
		updateDate();
	}
}
