package ExamMidTermOOP;

import java.io.BufferedWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;

public class Bill {
	private String IDBill;
	
	private String IDCustomer;
	
	private String IDProduct;
	
	private String date;
	
	private String total;
	
	private String quantity;
	
	private float price;
	
	Random random_generator = new Random();

	public String getIDBill() {
		return IDBill;
	}

	public void setIDBill(String iDBill) {
		IDBill = iDBill;
	}

	public String getIDCustomer() {
		return IDCustomer;
	}

	public void setIDCustomer(String iDCustomer) {
		IDCustomer = iDCustomer;
	}

	public String getIDProduct() {
		return IDProduct;
	}

	public void setIDProduct(String iDProduct) {
		IDProduct = iDProduct;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Bill() {
		this.total = null;
		this.quantity = null;
		this.IDBill = "Bill_" + random_generator.nextInt(1000) + "_" + random_generator.nextInt(1000);
		this.price = 0;
		this.IDProduct = null;
		this.date = null;
		
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		date = myDateObj.format(myFormatObj);
		
	}

	public Bill(String iDBill, String iDCustomer, String iDProduct, String date, String total, String quantity, float price) {
		super();
		IDBill = iDBill;
		IDCustomer = iDCustomer;
		IDProduct = iDProduct;
		this.date = date;
		this.total = total;
		this.quantity = quantity;
		this.price = price;
	}
	
	void PrintBill() {
		System.out.println("+------------+-----------------+-----------+--------------------+---------+-----------+");
		System.out.printf("%14s %17s %10s %20s %8s %11s\n"
				,"ID Bill|" , "ID Customer|"
				, "ID Product|", "Date buy|", "Quantity|", "Total|");
		System.out.println("+------------+-----------------+-----------+--------------------+---------+-----------+");
		System.out.printf("|%12s| %16s| %10s| %19s| %8s| %10s|\n"
				, getIDBill(), getIDCustomer()
				, getIDProduct(), getDate(), getQuantity(), getTotal());
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	public void writeFile(BufferedWriter out) {
		try{
            out.write(this.IDBill + ",");
            out.write(this.IDCustomer + ",");
            out.write(this.IDProduct + ",");
            out.write(this.getDate() + ",");
            out.write(this.getQuantity() + ",");
            out.write(this.getTotal() + ",");
            out.newLine();
        }
        catch(Exception e){
            System.out.println("Lỗi, không thể viết File !!");
        }
		
	}

	public boolean readFile(String s) {
		if(s!=null){
            String[] inp= s.split("\\,");	// tách theo dấu ,
            this.setIDBill(inp [0]);
            this.setIDCustomer(inp [1]);	// lấy từ đầu tiên theo vị trí index 0
            this.setIDProduct(inp [2]);
            this.setDate(inp [3]);
            this.setQuantity(inp [4]);
            this.setTotal(inp [5]);
            return true;
        }
        return false;
	}
}
