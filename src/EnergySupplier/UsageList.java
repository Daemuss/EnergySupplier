package EnergySupplier;

import java.util.ArrayList;

public class UsageList
{
    private ArrayList<Customer> customers;
    private ArrayList<EnergySupplier> energySuppliers;
    private ArrayList<String> usageList;

    public UsageList()
    {
        this.customers = new ArrayList<>();
        this.energySuppliers = new ArrayList<>();
        this.usageList = new ArrayList<>();
    }

    // Adds a customer to the customers list
    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
    }

    // Adds an energy supplier to the energySuppliers list
    public void addEnergySupplier(EnergySupplier energySupplier)
    {
        this.energySuppliers.add(energySupplier);
    }

    // Returns customer usage information
    public String getUsageListInformation()
    {
        int i = -1;
        StringBuilder stringBuilder = new StringBuilder();

        for (Customer customer : customers)
        {
            i++;
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getAddress());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(energySuppliers.get(i).getSupplierName());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getIdNumber());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getName());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getElectricUsage());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getGasUsage());
        }

        return stringBuilder.toString();
    }
}
