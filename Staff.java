package ExamMidTermOOP;

import java.io.BufferedWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Staff extends Person {
	private String IDStaff;
	
	public Staff() {

	}

	public Staff(String name, String address, String phone, String date, String sex, String IDStaff) {
		super(name, address, phone, date, sex);
		this.IDStaff = IDStaff;
	}

	public String getIDStaff() {
		return IDStaff;
	}

	public void setIDStaff(String iDStaff) {
		IDStaff = iDStaff;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập ID Staff: ");
		IDStaff = sc.nextLine();
		
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
                , getIDStaff(), getName()
                , getAddress(), getPhone()
                , getDate(), getSex()
        	);
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }

	public void writeFile(BufferedWriter out) {
		try{
            out.write(this.IDStaff + ",");
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
            this.setIDStaff(inp [0]);
            this.setName(inp [1]);	// lấy từ đầu tiên theo vị trí index 0
            this.setAddress(inp [2]);
            this.setPhone(inp [3]);
            this.setDate(inp [4]);
            this.setSex(inp [5]);
            return true;
        }
        return false;
	}
}

