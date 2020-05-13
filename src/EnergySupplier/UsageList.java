package EnergySupplier;

import java.util.ArrayList;

public class UsageList
{
    private final ArrayList<Customer> customers;

    public UsageList()
    {
        this.customers = new ArrayList<>();
    }

    // Adds a customer to the customers list
    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
    }

    // Returns the amount of customers in the list
    public int getCustomerListAmount()
    {
        return this.customers.size();
    }

    // Returns customer usage information
    public String getUsageListInformation()
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (Customer customer : customers)
        {
            stringBuilder.append(customer.getAddress());
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(customer.getSupplierName());
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
