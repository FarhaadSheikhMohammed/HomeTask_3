import java.util.ArrayList;
class Engine
{
    int HP;
    int manufacture;
    String type;
    public Engine(int HP,int manufacture, String type) {
    this.HP = HP;
    this.manufacture= manufacture;
    this.type= type; 
    }

    public void getEngParameter()
    {
        System.out.println("Engine HP: "+HP+" Engine Manufacture Date:"+ manufacture+" Engine type: "+type);
        System.out.println("--------------------------------------------------------------------");
    }
}

class CombustionEngine extends Engine
{
    public CombustionEngine(int HP,int manufacture,String type) {
       super(HP,manufacture,type);  
    }  
}

class ElectricEngine extends Engine
{
    public ElectricEngine(int HP,int manufacture,String type) {
       super(HP,manufacture,type);  
    }  
}
class HybridEngine extends Engine
{
    public HybridEngine(int HP,int manufacture,String type) {
       super(HP,manufacture,type);  
    }  
}
class Manufacture
{
	private double Manufacture_version;
    private int Manufacture_cost;
	private String Manufacture_name;
    public void setManufacture_properties(String Manufacture_name,double Manufacture_version,int Manufacture_cost) 
    {
    	this.Manufacture_name = Manufacture_name;
        this.Manufacture_version = Manufacture_version;
        this.Manufacture_cost = Manufacture_cost;
    }
    public String getManufacture_properties() 
    {
        return Manufacture_name+" "+Manufacture_version+" "+Manufacture_cost;
    }    
}
abstract class Vehicle
{
    abstract void ShowCharacteristics();
}
class HybridV extends Vehicle
{
    Manufacture manufacture;
    Engine engine;
    public HybridV(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }
    public void ShowCharacteristics()
    {
    	String[] t=this.manufacture.getManufacture_properties().split(" ");
        System.out.println("Manufacture_Name: "+t[0]+" Manufacture_Version: "+t[1]+" Manufacture_Cost: "+t[2]);
        System.out.println("Vehicle type: HybridV");
        engine.getEngParameter();
    }
}
class ICEV extends Vehicle
{
    Manufacture manufacture;
    Engine engine; 
    public ICEV(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }
    public void ShowCharacteristics()
    {
    	String[] t=this.manufacture.getManufacture_properties().split(" ");
    	System.out.println("Manufacture_Name: "+t[0]+" Manufacture_Version: "+t[1]+" Manufacture_Cost: "+t[2]);
        System.out.println("Vehicle type: ICEV");
        engine.getEngParameter();
    }
}
class BEV extends Vehicle
{
    Manufacture manufacture;
    Engine engine;
    public BEV(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }
    public void ShowCharacteristics()
    {
    	String[] t=this.manufacture.getManufacture_properties().split(" ");
    	System.out.println("Manufacture_Name: "+t[0]+" Manufacture_Version: "+t[1]+" Manufacture_Cost: "+t[2]);
        System.out.println("Vehicle type: BEV");
        engine.getEngParameter();
    }
}
public class Main
{
    public static void main(String[] args) 
    {
       Engine engine1=new ElectricEngine(40,2010,"Electric Engine");
       Manufacture manufacture1=new Manufacture();
       manufacture1.setManufacture_properties("Opel", 2.0, 4000);
       Vehicle Vehicle1=new BEV(manufacture1, engine1);
       
       Engine engine2=new CombustionEngine(30,1990,"Combustion Engine");
       Manufacture manufacture2=new Manufacture();
       manufacture2.setManufacture_properties("Audi", 1.0, 1000);
       Vehicle Vehicle2=new ICEV(manufacture2, engine2);
       
       Engine engine3=new HybridEngine(20,2010,"Hybrid Engine");
       Manufacture manufacture3=new Manufacture();
       manufacture3.setManufacture_properties("Ford", 1.0, 3000);
       Vehicle Vehicle3=new HybridV(manufacture3, engine3);

       Engine engine4=new CombustionEngine(50,2021,"Combustion Engine");
       Manufacture manufacture4=new Manufacture();
       manufacture4.setManufacture_properties("Mercedes", 1.0, 2000);
       Vehicle Vehicle4=new ICEV(manufacture4, engine4);
       
       Engine engine5=new ElectricEngine(35,2000,"Electric Engine");
       Manufacture manufacture5=new Manufacture();
       manufacture5.setManufacture_properties("Hyundai", 2.0, 3000);
       Vehicle Vehicle5=new ICEV(manufacture5, engine5);
       
       Engine engine6=new CombustionEngine(25,1992,"Combustion Engine");
       Manufacture manufacture6=new Manufacture();
       manufacture6.setManufacture_properties("Citroen", 2.0, 1500);
       Vehicle Vehicle6=new ICEV(manufacture6, engine6);
       
       
       Vehicle[] vehicles={Vehicle1,Vehicle2,Vehicle3,Vehicle4,Vehicle5,Vehicle6};

       for(Vehicle i:vehicles)
       {
        i.ShowCharacteristics();
       }
    
    }
}