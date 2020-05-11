package EnergySupplier;

import java.util.ArrayList;

public class UsageList
{
    private ArrayList<Customer> customers;
    private ArrayList<EnergySupplier> energySuppliers;

    public UsageList()
    {
        this.customers = new ArrayList<>();
        this.energySuppliers = new ArrayList<>();
    }

    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
    }

    public void addEnergySupplier(EnergySupplier energySupplier)
    {
        this.energySuppliers.add(energySupplier);
    }

    public String getUsageListInformation()
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (Customer customer : customers)
        {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getIdNumber());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getName());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getAddress());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getElectricUsage());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getGasUsage());
        }

        return stringBuilder.toString();
    }
}
