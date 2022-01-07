package ExamMidTermOOP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ListBill {
	
	private String temp_id_pc;
	
	private String temp_id_laptop;
	
	private int temp_quantity;	// biến tạm để lưu quantity
	
	private String quantity;	// biến tạm quantity chuyển kiểu int thành String
	
	private float temp_total_price;	// . . .
	
	private String total;	// . . .
	
	static private List<Bill> BILL = new ArrayList<>();
	
	Customer customer = new Customer();
	
	CustomerList list_customer = new CustomerList();
	
	ListProducts list_products = new ListProducts();
	
	public LaptopList list_laptop = new LaptopList();
	
	public PCList list_personalComputer = new PCList();
	
	// * ---------------------------------------------------- * //
	// * ---------- Lưu dữ liệu vào File danh sách ---------- * //
	// * ---------------------------------------------------- * //
	private String List_Bill = "D:\\SAVE.ELIPSE\\PROJECT_HAWKSTAR_01\\LTHDT\\src\\main\\java\\ExamMidTermOOP\\Comtuter_File\\list_bill.txt";
	
	// * -------------------------------------------------------- * //
	// * ---------- Lưu dữ liệu dự phòng khi có backup ---------- * //
	// * -------------------------------------------------------- * //
    private String Backup_List_Laptop ="./LTHDT/src/main/java/ExamMidTermOOP/Computer_File/backup_list_bill.txt";

	public void readFiles() throws IOException, InterruptedException {
		list_laptop.readFile();
		
		list_personalComputer.readFile();
		
		list_customer.readFile();
		
		System.out.println("+ ===== Đang vào hệ thống ===== +");
		TimeUnit.SECONDS.sleep(1);
	}
    
	public ListBill(List<Bill> BILL) {
		this.BILL = BILL;
	}
	
	public ListBill() {
		
	}

	public void AddBill (Bill bill_object) {
		this.BILL.add(bill_object);
	}
	
	public void menu_add() throws IOException {
		String choose = null;
		do {
			System.out.println("+=====  Bạn muốn mua gì ? =====+");
			System.out.println("+ ---------------------------- +");
			System.out.println("|           Sản phẩm           |");
			System.out.println("+ ---------------------------- +");
			System.out.println("|1. Laptop                     |");
			System.out.println("|2. PC                         |");
			System.out.println("|0. Thoát                      |");
			System.out.println("+ ---------------------------- +");
			
 			Scanner scanner = new Scanner(System.in);
 			System.out.print("- Chọn chức năng: ");
 			choose = scanner.nextLine();
			
			switch (choose) {
				case "1":
					menu_laptop_bill();
					break;
				case "2":
					menu_pc_bill();
					break;
				case "0":
					break;
				default:
					System.out.println("+===== Bạn đã nhập sai. Xin mời nhập lại =====+");
	 				break;
			}
		} while (choose.equalsIgnoreCase("0") != true);
	}
	
	public void menu_laptop_bill() throws IOException {
		
		Bill b = new Bill();
		
		String choose = null;
		
		Scanner sc_choose = new Scanner(System.in);
		
		System.out.println("Bạn có muốn xem danh sách Laptop trước khi mua không ? 1: yes / \"Nhấn phím bất kỳ\": no");
		
		choose = sc_choose.nextLine();
		while (choose.equalsIgnoreCase("1")) {
			list_laptop.display();
			break;
		}
		
		do {
			System.out.print("- Mời bạn nhập mã laptop để mua : ");
			
			Scanner sc_laptop_input = new Scanner(System.in);
			temp_id_laptop = sc_laptop_input.nextLine();
			
			b.setIDProduct(list_products.InputLaptop(temp_id_laptop));
			
			if (temp_id_laptop != list_products.InputLaptop(b.getIDProduct())) {
				System.out.println("+===== Mời bạn nhập lại =====+");
			}
		} while (temp_id_laptop != list_products.InputLaptop(b.getIDProduct()));
		
		do {
			System.out.println("- Xin hãy nhập số lượng mua sản phẩm này : ");
			
			Scanner sc_laptop_quantity = new Scanner(System.in);
			
			temp_quantity = sc_laptop_quantity.nextInt();
			quantity = Integer.toString(temp_quantity);
			b.setQuantity(quantity);
			if (temp_quantity < 0) {
				System.out.println("Số lượng sản phẩm phải là số dương"
						+ ". Mời bạn nhập lại");
			}
		} while (temp_quantity < 0);
		
		temp_total_price = Integer.parseInt(b.getQuantity()) * Integer.parseInt(list_products.PriceLaptop(temp_id_laptop));
		total = Float.toString(temp_total_price);
		b.setTotal(total);
		
		System.out.println("Bạn có chắc chắn mua sản phẩm này không ? 1: yes / Phím bất kỳ: no");
		
		Scanner sc_choose_sure = new Scanner(System.in);
		String choose_sure = null;
		choose_sure = sc_choose_sure.nextLine();
		switch (choose_sure) {
		case "1":
			System.out.println("+===== Mời bạn nhập thông tin của mình =====+");
			customer.input();
			b.setIDCustomer(customer.getIDCustomer());
			CustomerList.CUSTOMER.add(customer);
			list_customer.writeFile();
			System.out.println("Đơn hàng đang được xử lý"
					+ ". Chúng tôi sẽ gọi cho quý khách sau 5 phút");
			AddBill(b);
			ListBill lb = new ListBill();
			b.PrintBill();
			lb.writeFile();
			break;
		default:
			System.out.println("Cảm ơn bạn đã mua sản phẩm");
			break;
		}
	}
	
	public void menu_pc_bill() throws IOException {
		
		Bill b = new Bill();
		
		String choose = null;
		
		Scanner sc_choose = new Scanner(System.in);
		
		System.out.println("Bạn có muốn xem danh sách PC trước khi mua không ? 1: yes / \"Nhấn phím bất kỳ\": no");
		
		choose = sc_choose.nextLine();
		while (choose.equalsIgnoreCase("1")) {
			list_personalComputer.display();
			break;
		}

		do {
			System.out.print("- Mời bạn nhập mã pc để mua : ");
			
			Scanner sc_pc_input = new Scanner(System.in);
			temp_id_pc = sc_pc_input.nextLine();
			
			b.setIDProduct(list_products.InputPC(temp_id_pc));
			
			if (temp_id_pc != list_products.InputPC(b.getIDProduct())) {
				System.out.println("+ ===== Mời bạn nhập lại ===== +");
			}
		} while (temp_id_pc != list_products.InputPC(b.getIDProduct()));
		
		do {
			System.out.println("- Xin hãy nhập số lượng mua sản phẩm này : ");
			
			Scanner sc_pc_quantity = new Scanner(System.in);
			
			temp_quantity = sc_pc_quantity.nextInt();
			quantity = Integer.toString(temp_quantity);
			b.setQuantity(quantity);
			if (temp_quantity < 0) {
				System.out.println("Số lượng sản phẩm phải là số dương"
						+ ". Mời bạn nhập lại");
			}
		} while (temp_quantity < 0);
		
		temp_total_price = Integer.parseInt(b.getQuantity()) * Integer.parseInt(list_products.PricePC(temp_id_pc));
		total = Float.toString(temp_total_price);
		b.setTotal(total);
	
		System.out.println("Bạn có chắc chắn mua sản phẩm này không ? 1: yes / Phím bất kỳ: no");
		
		Scanner sc_choose_sure = new Scanner(System.in);
		String choose_sure = null;
		choose_sure = sc_choose_sure.nextLine();
		switch (choose_sure) {
		case "1":
			System.out.println("+===== Mời bạn nhập thông tin của mình =====+");
			customer.input();
			b.setIDCustomer(customer.getIDCustomer());
			CustomerList.CUSTOMER.add(customer);
			list_customer.readFile();
			System.out.println("Đơn hàng đang được xử lý"
					+ ". Chúng tôi sẽ gọi cho quý khách sau 5 phút");
			AddBill(b);
			ListBill lb = new ListBill();
			b.PrintBill();
			lb.writeFile();
			break;
		default:
			System.out.println("Bạn đã hủy đơn. Tạm biệt");
			break;
		}
	}
	
	void PrintBill() {
		System.out.println("+------------+-----------------+-----------+--------------------+---------+-----------+");
		System.out.printf("%14s %17s %10s %20s %8s %11s\n"
				,"ID Bill|" , "ID Customer|"
				, "ID Product|", "Date buy|", "Quantity|", "Total|");
		System.out.println("+------------+-----------------+-----------+--------------------+---------+-----------+");
		for (Iterator<Bill> it = BILL.iterator(); it.hasNext();) {
			Bill b = it.next();
			System.out.printf("|%12s| %16s| %10s| %19s| %8s| %10s|\n"
					,b.getIDBill(), b.getIDCustomer()
					, b.getIDProduct(), b.getDate(), b.getQuantity(), b.getTotal());
			System.out.println("---------------------------------------------------------------------------------------");
		}
	}
	
	public void statistical_date(String date) {
		System.out.println("+------------+-----------------+-----------+--------------------+---------+-----------+");
		System.out.printf("%14s %17s %10s %20s %8s %11s\n"
				,"ID Bill|" , "ID Customer|"
				, "ID Product|", "Date buy|", "Quantity|", "Total|");
		for (Iterator<Bill> it = BILL.iterator(); it.hasNext();) {
			Bill b = it.next();
			if (b.getDate().contains(date)) {
				System.out.println("+------------+-----------------+-----------+--------------------+---------+-----------+");
				System.out.printf("|%12s| %16s| %10s| %19s| %8s| %10s|\n"
						, b.getIDBill(), b.getIDCustomer()
						, b.getIDProduct(), b.getDate(), b.getQuantity(), b.getTotal());
			
			}
		}
		
		System.out.println("---------------------------------------------------------------------------------------");
		
	}
	
	public void statistical_laptop(String laptop) throws IOException {
		
		int quantity = 0;
		
		for (Iterator<Bill> it = BILL.iterator(); it.hasNext();) {
			Bill b = it.next();
			if (b.getIDProduct().contains(laptop)) {
				quantity += Integer.parseInt(b.getQuantity());
			}
		}
		System.out.println("Có " + quantity + " sản phẩm Laptop bán trong tháng này");
	}
	
	public void statistical_pc(String pc) {
		
		int quantity = 0;
		
		for (Iterator<Bill> it = BILL.iterator(); it.hasNext();) {
			Bill b = it.next();
			if (b.getIDProduct().contains(pc)) {
				quantity += Integer.parseInt(b.getQuantity());
			}
		}
		System.out.println("Có " + quantity + " sản phẩm PC bán trong tháng này");
	}
	
	public void statistical_total(String bill) {
		
		double total = 0;
		
		for (Iterator<Bill> it = BILL.iterator(); it.hasNext();) {
			Bill b = it.next();
			if (b.getIDBill().contains(bill)) {
				total += Float.parseFloat(b.getTotal());
			}
		}
		System.out.println("Tháng này cửa hàng kiếm được " + total + " ngàn đồng");
	}
	
	// * --------------------------------------------------- * //
	// * -------------------- Viết File -------------------- * //
	// * --------------------------------------------------- * //
	
	public void writeFile() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(List_Bill));
		for (Bill b : BILL) {
			b.writeFile(out);
		}
		out.close();
	}
	// * --------------------------------------------------- * //
	// * -------------------- Đọc File --------------------- * //
	// * --------------------------------------------------- * //
	
	public void readFile() throws IOException {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(List_Bill));
			String s = null;
			do {
				s = input.readLine();
				Bill b = new Bill();
				if (b.readFile(s))
					BILL.add(b);
			} while (s != null);
			input.close();
		} catch (Exception e) {
			System.out.println("Lỗi, không thể đọc File. Vui lòng thử lại !!");
		}
	}
	
	public static void main(String[] args) throws IOException {
		ListBill lb = new ListBill();
		lb.readFile();
		lb.statistical_date("05/01/2022");
	}
}
