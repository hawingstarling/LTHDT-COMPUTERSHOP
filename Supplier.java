package ExamMidTermOOP;
import java.io.BufferedWriter;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Scanner;

public class Supplier {
	private String IDSupplier;
	
    private String nameSupplier;
    
    private String address;
    
    private String sdt;
    
    static Scanner sc = new Scanner(System.in);

    public Supplier(){
    	this.nameSupplier =null;
        this.IDSupplier =null;
        this.address = null;
        this.sdt =null;
    }       

    public String getIDSupplier() {
		return IDSupplier;
	}

	public void setIDSupplier(String iDSupplier) {
		IDSupplier = iDSupplier;
	}

	public String getNameSupplier() {
		return nameSupplier;
	}

	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public static boolean isNum(String s){
        for (int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                
            } else return false;
        }
        return true;
    }

    public void input(){ 
        System.out.println("Hãy nhập tên nhà cung cấp: ");
        nameSupplier = sc.nextLine();
        
        System.out.println("Nhập địa chỉ nhà cung cấp: ");
        address = sc.nextLine();
        
        do {
            System.out.println("Hãy nhập số điện thoại (10 kí tự)");
            setSdt(sc.nextLine());
            while(isNum(getSdt()) != true){
                System.out.println("Bạn đã nhập sai. Hãy nhập số nguyên: ");
                setSdt(sc.nextLine());
            }
        } while(getSdt() == "" || Long.parseLong(getSdt()) < 0  || getSdt().length() != 10);
    }

	public void display() {
		System.out.println("+---------+--------------------+------------------------------+-----------+");
		System.out.printf("%10s %20s %30s %11s\n"
				, "|ID Supplier|", "Name Supplier|", "Address|"
				, "Phone Number|");
		System.out.println("+---------+--------------------+------------------------------+-----------+");
            
        System.out.printf("|%9s| %19s| %29s| %11s|\n"
                , getIDSupplier(), getNameSupplier()
                , getAddress(), getSdt()
        );
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Supplier other = (Supplier) obj;
        if (IDSupplier == null) {
            if (other.IDSupplier != null)
                return false;
        } else if (!IDSupplier.equals(other.IDSupplier))
            return false;
        return true;
    }

	// BuferedWriter : ghi file với đối tượng out, .write dùng để ghi một kí tự duy nhất
	public void writeFile(BufferedWriter out) {
		try{
            out.write(this.getIDSupplier() + ",");
            out.write(this.getNameSupplier() + ",");
            out.write(this.getAddress() + ",");
            out.write(this.getSdt() + ",");
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
            this.setIDSupplier(inp [0]);
            this.setNameSupplier(inp [1]);	// lấy từ đầu tiên theo vị trí index 0
            this.setAddress(inp [2]);
            this.setSdt(inp [3]);
            return true;
        }
        return false;
	}
}
