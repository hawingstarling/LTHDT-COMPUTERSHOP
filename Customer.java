package ExamMidTermOOP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Customer extends Person {
	
	private String IDCustomer;	// ID khách hàng
	
	Random random_generator = new Random();
	
	public Customer(String name, String address, String phone, String date, String sex) {
		super(name, address, phone, date, sex);
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getIDCustomer() {
		return IDCustomer;
	}

	public void setIDCustomer(String IDCustomer) {
		this.IDCustomer = IDCustomer;
	}

	
	// PhÆ°Æ¡ng thá»©c nháº­p cÃ¡c thuá»™c tÃ­nh cá»§a khÃ¡ch hÃ ng

	public void input() {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Nhập ID Customer: ");
//		IDCustomer = sc.nextLine();
		IDCustomer = "Customer_" + random_generator.nextInt(1000) + "_" + random_generator.nextInt(1000);
		
		super.input();
		
	}

	@Override
	public void display() {
		System.out.println("+----------+--------------------+-----------------------------+-----------+----------+------+");
		System.out.printf("%10s %20s %30s %11s %10s %6s\n"
				, "|ID Staff|", "Name Staff|", "Address|"
				, "Phone Number|", "Birthday|", "Gender|");
		System.out.println("+----------+--------------------+-----------------------------+-----------+----------+------+");
        System.out.printf("|%9s| %19s| %29s| %10s| %9s| %5s|\n"
                , getIDCustomer(), getName()
                , getAddress(), getPhone()
                , getDate(), getSex()
        	);
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }

	public void writeFile(BufferedWriter out) {
		try{
            out.write(this.IDCustomer + ",");
            out.write(this.getName() + ",");
            out.write(this.getAddress() + ",");
            out.write(this.getPhone() + ",");
            out.write(this.getDate() + ",");
            out.write(this.getSex() + ",");
            out.newLine();
        }
        catch(Exception e){
            System.out.println("Lỗi, không thể viết File !!");
        }
		
		
	}

	public boolean readFile(String s) {
		if(s!=null){
            String[] inp= s.split("\\,");	// tách theo dấu ,
            this.setIDCustomer(inp [0]);
            this.setName(inp [1]);	// lấy từ đầu tiên theo vị trí index 0
            this.setAddress(inp [2]);
            this.setPhone(inp [3]);
            this.setDate(inp [4]);
            this.setSex(inp [5]);
            return true;
        }
        return false;
	}
//	
//	public static void main(String[] args) throws IOException {
//		CustomerList l = new CustomerList();
//		Customer cu = new Customer();
//		l.add();
//		l.display();
//	}
}

