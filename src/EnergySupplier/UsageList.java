package EnergySupplier;

import java.util.ArrayList;

public class UsageList
{
    private final ArrayList<Customer> customers;
    private final ArrayList<EnergySupplier> energySuppliers;

    public UsageList()
    {
        this.customers = new ArrayList<>();
        this.energySuppliers = new ArrayList<>();
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

    // Returns the amount of customers in the list
    public int getCustomerListAmount()
    {
        return this.customers.size();
    }

    // Returns customer usage information
    public String getUsageListInformation()
    {
        int i = -1;
        StringBuilder stringBuilder = new StringBuilder();

        for (Customer customer : customers)
        {
            i++;
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
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
