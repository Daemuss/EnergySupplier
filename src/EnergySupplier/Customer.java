package EnergySupplier;

public class Customer
{
    private String idNumber, name, address;
    private int  electricUsage, gasUsage;

    public Customer(String idNumber, String name, String address, int electricUsage, int gasUsage)
    {
        this.idNumber = idNumber;
        this.name = name;
        this.address = address;
        this.electricUsage = electricUsage;
        this.gasUsage = gasUsage;
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
