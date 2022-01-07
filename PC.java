package ExamMidTermOOP;

import java.io.BufferedWriter;
import java.util.Iterator;
import java.util.Scanner;

public class PC extends Accessory {
	static PCList pclist = new PCList();
	
	public String IDProducts;
	
	public String nameProducts;
	
	public String types;
	
	public String hardDrive;
	
	public String mass;
	
	public String price;
	
	public static int count = -1;
	
	public PC(String cpu, String ram, String card, String IDProducts, String types, String mass, String nameProducts, String price) {
		this.IDProducts = IDProducts;
		this.nameProducts = nameProducts;
		this.types = types;
		this.mass = mass;
		this.price = price;
	}

	public PC() {
		// TODO Auto-generated constructor stub
		count++;
	}

	public String getIDProducts() {
		return IDProducts;
	}

	public void setIDProducts(String iDProducts) {
		IDProducts = iDProducts;
	}

	public String getNameProducts() {
		return nameProducts;
	}

	public void setNameProducts(String nameProducts) {
		this.nameProducts = nameProducts;
	}
	
	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}
	
	public void setHardDrive(String hardDrive) {
		this.hardDrive = hardDrive;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		PC pc = new PC();
		
		System.out.println("Input ID products: ");
		IDProducts = sc.nextLine();
		
		System.out.println("Input name products: ");
		nameProducts = sc.nextLine();
		
		System.out.println("Input neccessery (Nhu cầu): ");
		types = sc.nextLine();
		
		System.out.println("Input CPU (Bộ vi xử lý): ");
		cpu = sc.nextLine();
		
		System.out.println("Input CARD (Card VGA): ");
		card = sc.nextLine();
		
		System.out.println("Input RAM (Bộ nhớ): ");
		ram = sc.nextLine();
		
		System.out.println("Input mass (Khối lượng): ");
		mass = sc.nextLine();

		System.out.println("Input price (Giá tiền): ");
		price = sc.nextLine();
	}


	public void display() {
		System.out.println("+-----------+--------------------+-----------+---------------+---------------+---------------+---------------+---------------+");
		System.out.printf("%10s %20s %10s %15s %15s %15s %15s %15s\n"
				, "|ID Computer|", "Name Computer|", "Neccessery|"
				, "CPU|", "Card|", "RAM|", "Mass|", "Price|");
		System.out.println("+-----------+--------------------+-----------+---------------+---------------+---------------+---------------+---------------+");
		System.out.printf("|%11s| %19s| %10s| %14s| %14s| %14s| %14s| %14s|\n"
                    , getIDProducts(), getNameProducts()
                    , getTypes(), getCpu()
                    , getCard(), getRam()
                    , getMass(), getPrice()
            );
	}


	public boolean readFile(String s) {
		if(s!=null){
            String[] inp= s.split("\\,");
            this.setIDProducts(inp [0]);
            this.setNameProducts(inp [1]);	
            this.setTypes(inp [2]);
            this.setCpu(inp [3]);
            this.setCard(inp [4]);
            this.setRam(inp [5]);
            this.setMass(inp [6]);
            this.setPrice(inp [7]);
            return true;
        }
        return false;
	}

	public void writeFile(BufferedWriter out) {
		try{
            out.write(this.IDProducts + ",");
            out.write(this.nameProducts + ",");
            out.write(this.types + ",");
            out.write(this.getCpu() + ",");
            out.write(this.getCard() + ",");
            out.write(this.getRam() + ",");
            out.write(this.getMass() + ",");
            out.write(this.price + ",");
            out.newLine();
        }
        catch(Exception e){
            System.out.println("Lỗi, không thể viết File !!");
        }
	}

}
