package EnergySupplier;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Pane
{
    private UsageList usageList;
    private Label labelKilowattHour, labelGas;
    private ComboBox<String> comboBoxEnergySupplier;
    private TextField textFieldIdNumber, textFieldName, textFieldAddress, textFieldElectricUsage, textFieldGasUsage;
    private Button buttonAdd, buttonSend, buttonConfirm;
    private ArrayList<String> energySupplierNames;
    private Stage confirmPanelStage;
    private GridPane confirmGridPane;
    private TextArea textAreaConfirmUsage;

    public Pane(GridPane p)
    {
        usageList = new UsageList();

        this.setGridPaneSettings(p);
        this.createFXComponents();
        this.addToGridPane(p);
        this.buttonAddEvent();
        this.buttonSendEvent();
        this.setComboBoxValues();
        this.setButtonConfirmEvent();
        this.setFXSettings();
    }

    // Set the GridPane settings
    private void setGridPaneSettings(GridPane p)
    {
        p.setPadding(new Insets(10, 10, 100, 10));
    }

    // Set the Confirm pane settings
    private void setConfirmPaneSettings()
    {
        confirmGridPane.setPadding(new Insets(10, 10, 100, 10));
    }

    // Set settings for the FX components
    private void setFXSettings()
    {
        textAreaConfirmUsage.setEditable(false);
    }

    // Creates the FX components
    private void createFXComponents()
    {
        labelKilowattHour = new Label("kwh");
        labelGas = new Label("m3");

        comboBoxEnergySupplier = new ComboBox<>();

        textFieldIdNumber = new TextField("id number");
        textFieldName = new TextField("Name");
        textFieldAddress = new TextField("Address");
        textFieldElectricUsage = new TextField("Electric");
        textFieldGasUsage = new TextField("Gas");

        buttonAdd = new Button("Add");
        buttonSend = new Button("Send");
        buttonConfirm = new Button("Confirm");

        textAreaConfirmUsage = new TextArea();
    }

    // Adds the FX components to the GridPane
    private void addToGridPane(GridPane p)
    {
        p.add(comboBoxEnergySupplier, 0, 0);

        p.add(textFieldIdNumber,0, 1);
        p.add(textFieldName,0, 2);
        p.add(textFieldAddress,0, 3);
        p.add(textFieldElectricUsage,0, 4);
        p.add(textFieldGasUsage,0, 5);

        p.add(labelKilowattHour, 1, 4);
        p.add(labelGas, 1, 5);

        p.add(buttonAdd, 0, 6);
        p.add(buttonSend, 1, 6);
    }

    // Sets the combo box values
    private void setComboBoxValues()
    {
        energySupplierNames = new ArrayList<>();
        energySupplierNames.add("Eneco");
        energySupplierNames.add("Energiedirect");
        energySupplierNames.add("Oxxio");

        comboBoxEnergySupplier.setPromptText("Energy Supplier");

        for (String supplierNames : energySupplierNames)
        {
            comboBoxEnergySupplier.getItems().addAll(supplierNames);
        }
    }

    // Adds the data to the usage list
    private void addToUsageList()
    {
        try
        {
            String customerIdNumber = textFieldIdNumber.getText();
            String customerName = textFieldName.getText();
            String customerAddress = textFieldAddress.getText();
            int electricUsage = Integer.parseInt(textFieldElectricUsage.getText());
            int gasUsage = Integer.parseInt(textFieldGasUsage.getText());
            String selectedSupplierName = comboBoxEnergySupplier.getValue();

            Customer customer = new Customer(customerIdNumber, customerName, customerAddress, electricUsage, gasUsage);
            EnergySupplier energySupplier = new EnergySupplier(selectedSupplierName);

            usageList.addCustomer(customer);
            usageList.addEnergySupplier(energySupplier);

            System.out.println("Energy usage data added");
            textFieldElectricUsage.setStyle("-fx-background-color: white;");
            textFieldGasUsage.setStyle("-fx-background-color: white;");
        }
        catch(NumberFormatException e)
        {
            System.out.println(e);
            textFieldElectricUsage.setStyle("-fx-background-color: red;");
            textFieldGasUsage.setStyle("-fx-background-color: red;");
        }

    }

    // Creates a new confirm pane
    private void createConfirmPane()
    {
        confirmGridPane = new GridPane();
        confirmPanelStage = new Stage();
        confirmPanelStage.setTitle("Confirm Usage");
        confirmPanelStage.setScene(new Scene(confirmGridPane, 400, 400));
        confirmPanelStage.show();
    }

    // Adds FX components to the confirm pane
    private void addToConfirmPane()
    {
        confirmGridPane.add(textAreaConfirmUsage, 0, 0);
        confirmGridPane.add(buttonConfirm, 0 ,1);
    }

    // Event handler for the add button
    private void buttonAddEvent()
    {
        buttonAdd.setOnAction(event -> {
            this.addToUsageList();
        });
    }

    // Event handler for the send button
    private void buttonSendEvent()
    {
        buttonSend.setOnAction(event -> {
            if(usageList.getCustomerListAmount() == 0)
            {
                System.out.println("You haven't submitted any energy usage yet");
            }
            else
            {
                this.createConfirmPane();
                this.addToConfirmPane();
                this.setConfirmPaneSettings();

                textAreaConfirmUsage.setText(usageList.getUsageListInformation());
            }
        });
    }

    // Event handler for the confirm button
    private void setButtonConfirmEvent()
    {
        buttonConfirm.setOnAction(event -> {
            System.out.println(usageList.getUsageListInformation());

            confirmPanelStage.close();
            usageList = new UsageList();
        });
    }
}
