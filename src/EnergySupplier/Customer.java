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

    public String getIdNumber()
    {
        return idNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public int getElectricUsage()
    {
        return electricUsage;
    }

    public int getGasUsage()
    {
        return gasUsage;
    }
}
