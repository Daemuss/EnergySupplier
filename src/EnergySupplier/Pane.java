package EnergySupplier;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Pane
{
    private UsageList usageList;
    private Label labelKilowattHour, labelGas;
    private ComboBox<String> comboBoxEnergySupplier;
    private TextField textFieldIdNumber, textFieldName, textFieldAddress, textFieldElectricUsage, textFieldGasUsage;
    private Button buttonAdd, buttonSend, buttonConfirm;
    private ArrayList<String> energySupplierNames;

    public Pane(GridPane p)
    {
        usageList = new UsageList();

        this.createFXComponents();
        this.addToGridPane(p);
        this.buttonAddEvent();
        this.buttonSendEvent();
        this.setComboBoxValues();
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
            System.out.println(usageList.getUsageListInformation());

            usageList = new UsageList();
        });
    }
}
