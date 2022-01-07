package ExamMidTermOOP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Laptop extends Accessory {
	
	private String IDLaptop;
	
	private String nameLaptop;
	
	private String priceLaptop;
	
	private String typesLaptop;
	
	Random random_generator = new Random();
	
	public Laptop(String cpu, String ram, String card, String IDLaptop, String typesLaptop, String nameLaptop, String priceLaptop) {
		this.IDLaptop = IDLaptop;
		this.nameLaptop = nameLaptop;
		this.typesLaptop = typesLaptop;
		this.priceLaptop = priceLaptop;
	}

	public Laptop() {
		// TODO Auto-generated constructor stub
//		count++;
	}

	public String getIDLaptop() {
		return IDLaptop;
	}

	public void setIDLaptop(String iDLaptop) {
		IDLaptop = iDLaptop;
	}

	public String getNameLaptop() {
		return nameLaptop;
	}

	public void setNameLaptop(String nameLaptop) {
		this.nameLaptop = nameLaptop;
	}
	
	public String getTypesLaptop() {
		return typesLaptop;
	}

	public void setTypesLaptop(String typesLaptop) {
		this.typesLaptop = typesLaptop;
	}
	
	public String getPriceLaptop() {
		return priceLaptop;
	}

	public void setPriceLaptop(String priceLaptop) {
		this.priceLaptop = priceLaptop;
	}
	
	@Override
	public void input() {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Input ID products: ");
			IDLaptop = sc.nextLine();
			
			System.out.println("Input name products: ");
			nameLaptop = sc.nextLine();
			
			System.out.println("Input neccessery (Nhu cầu): ");
			typesLaptop = sc.nextLine();
			
			System.out.println("Input CPU (Bộ vi xử lý): ");
			cpu = sc.nextLine();
			
			System.out.println("Input CARD (Card VGA): ");
			card = sc.nextLine();
			
			System.out.println("Input RAM (Bộ nhớ): ");
			ram = sc.nextLine();
			
			System.out.println("Input price (Giá tiền): ");
			priceLaptop = sc.nextLine();
	}

	@Override
	public void display() {
		System.out.println("+---------+--------------------+-----------+---------------+---------------+---------------+---------------+");
		System.out.printf("%10s %20s %10s %15s %15s %15s %15s\n"
				, "|ID Laptop|", "Name Laptop|", "Neccessery|"
				, "CPU|", "Card|", "RAM|", "Price|");
		System.out.println("+---------+--------------------+-----------+---------------+---------------+---------------+---------------+");
		System.out.printf("|%9s| %19s| %10s| %14s| %14s| %14s| %14s|\n"
                , getIDLaptop(), getNameLaptop()
                , getTypesLaptop(), getCpu()
                , getCard(), getRam()
                , getPriceLaptop()
        );
        System.out.println("------------------------------------------------------------------------------------------------------------");
	}

	// BuferedWriter : ghi file với đối tượng out, .write dùng để ghi một kí tự duy nhất
	public void writeFile(BufferedWriter out) {
		try{
            out.write(this.IDLaptop + ",");
            out.write(this.nameLaptop + ",");
            out.write(this.typesLaptop + ",");
            out.write(this.getCpu() + ",");
            out.write(this.getCard() + ",");
            out.write(this.getRam() + ",");
            out.write(this.priceLaptop + ",");
            out.newLine();
        }
        catch(Exception e){
            System.out.println("Lỗi, không thể viết File !!");
        }
		
	}

	// split : tách chuỗi theo biểu thức chính quy
	public boolean readFile(String s) {
		if(s!=null){
            String[] inp= s.split("\\,");	// tách theo dấu ,
            this.setIDLaptop(inp [0]);
            this.setNameLaptop(inp [1]);	// lấy từ đầu tiên theo vị trí index 0
            this.setTypesLaptop(inp [2]);
            this.setCpu(inp [3]);
            this.setCard(inp [4]);
            this.setRam(inp [5]);
            this.setPriceLaptop(inp [6]);
            return true;
        }
        return false;
	}
	
	public static void main(String[] args) throws IOException {
		LaptopList lt = new LaptopList();
		lt.add();
		lt.readFile();
		lt.writeFile();
	}
}
