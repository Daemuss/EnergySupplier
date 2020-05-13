package EnergySupplier;

public class Customer
{
    private final String supplierName, idNumber, name, address;
    private final int  electricUsage, gasUsage;

    public Customer(String supplierName, String idNumber, String name, String address, int electricUsage, int gasUsage)
    {
        this.supplierName = supplierName;
        this.idNumber = idNumber;
        this.name = name;
        this.address = address;
        this.electricUsage = electricUsage;
        this.gasUsage = gasUsage;
    }

    // Returns customer energy supplier name
    public String getSupplierName()
    {
        return supplierName;
    }

    // Returns customer id number
    public String getIdNumber()
    {
        return idNumber;
    }

    // Returns customer name
    public String getName()
    {
        return name;
    }

    // Returns customer address
    public String getAddress()
    {
        return address;
    }

    // Returns customer electric usage
    public int getElectricUsage()
    {
        return electricUsage;
    }

    // Returns customer gas usage
    public int getGasUsage()
    {
        return gasUsage;
    }
}
