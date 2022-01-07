package ExamMidTermOOP;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MenuMain {
	String select;
	
	Promotion promotion_product = new Promotion();
	
	ListProducts list_product = new ListProducts();
	
	public static CustomerList list_customer = new CustomerList();
	public static ListBill list_bill = new ListBill();
	public static LaptopList list_laptop = new LaptopList();
	public static PCList list_personalComputer = new PCList();
	
	public static void readFile() throws IOException, InterruptedException {
		list_laptop.readFile();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("+ ===== Read File Laptop ===== +");
		
		list_bill.readFile();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("+ ===== Read File Bill ===== +");
		
		list_personalComputer.readFile();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("+ ===== Read File Personal Computer ===== +");
		
		list_customer.readFile();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("+ ===== Read File Customer ===== +");
		
		TimeUnit.SECONDS.sleep(1);
		System.out.println("+ ===== Read File Done ===== +");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println("+ ===== Đang tải dữ liệu lên hệ thống ===== +");
		TimeUnit.SECONDS.sleep(1);
	}
	
	public static void writeFile() throws IOException {
		list_laptop.writeFile();
		list_personalComputer.writeFile();
		System.out.println("+===== Write File Done =====+");
	}
	
	public static void readFile_Backup() throws IOException{
		list_laptop.deleteAll();
		list_personalComputer.deleteAll();
        list_laptop.readFile_Backup();
        list_personalComputer.readFile_Backup();
        System.out.println("ReadFile Backup Done");
    }
    
    public static void writeFile_Backup() throws IOException{
    	list_laptop.writeFile_Backup();
    	list_personalComputer.writeFile_Backup();
    }
    
    public static void menu_main() {
    	
    }
    // * -------------------------------------------------------------------- * //
 	// * --------------------------- MENU PROMOTION ------------------------- * //
 	// * -------------------------------------------------------------------- * //
	public void menu_promotion() throws IOException {
		String choose = null;
		do {
			System.out.println("+------------------------------------------------------+");
			System.out.println("|---------------- QUẢN LÝ BÁN MÁY TÍNH ----------------|");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 1. Nhập khuyến mãi cho Laptop                        |");
			System.out.println("| 2. Nhập khuyến mãi cho PC                            |");
			System.out.println("| 3. Thoát                                             |");
			System.out.println("+------------------------------------------------------+");
			
			Scanner inputs = new Scanner(System.in);
			System.out.print("- Chọn chức năng: ");
			choose = inputs.nextLine();
			switch (choose) {
			case "1":
				String id = null;
				do {
					Scanner sc_promotion_laptop = new Scanner(System.in);
					
					System.out.print("- Mời bạn nhập mã Laptop : ");
					id = sc_promotion_laptop.nextLine();
					
				} while (id != list_product.InputLaptop(id));
				list_laptop.laptop_promotion(id);
				list_laptop.writeFile();
				break;
			case "2":
				String id1 = null;
				do {
					Scanner sc_promotion_pc = new Scanner(System.in);
					
					System.out.print("- Mời bạn nhập mã PC : ");
					id1 = sc_promotion_pc.nextLine();
					
				} while (id1 != list_product.InputPC(id1));
				list_personalComputer.pc_promotion(id1);
				list_personalComputer.writeFile();
				break;
			case "3":
				// insert
				break;
			default:
				System.out.println("+===== Bạn đã nhập sai. Xin mời nhập lại =====+");
			}
		} while (choose.equalsIgnoreCase("3") != true);
	}

	
    // * -------------------------------------------------------------------- * //
 	// * --------------------------- MENU 2.1 ------------------------------- * //
 	// * -------------------------------------------------------------------- * //
	
	public void menu_2_1() throws IOException {
		String choose = null;
		do {
			System.out.println("+------------------------------------------------------+");
			System.out.println("|---------------- QUẢN LÝ BÁN MÁY TÍNH ----------------|");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 1. Hiển thị danh sách Laptop                         |");
			System.out.println("| 2. Hiển thị danh sách PC                             |");
			System.out.println("| 3. Thoát                                             |");
			System.out.println("+------------------------------------------------------+");
			
			Scanner inputs = new Scanner(System.in);
			System.out.print("- Chọn chức năng: ");
			choose = inputs.nextLine();
			switch (choose) {
			case "1":
				list_laptop.display();
				break;
			case "2":
				list_personalComputer.display();
				break;
			case "3":
				break;
			default:
				System.out.println("+===== Bạn đã nhập sai. Xin mời nhập lại =====+");
				break;
			}
		} while (choose.equalsIgnoreCase("3") != true);
	}
    
    // * -------------------------------------------------------------------- * //
 	// * ----------------------------- MENU CHÍNH  -------------------------- * //
 	// * -------------------------------------------------------------------- * //
    
	public void menu() throws IOException {
		String choose = null;
		do {
			System.out.println("+------------------------------------------------------+");
			System.out.println("|------------ Cửa hàng quản lý bán máy tính -----------|");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 1. Quản lý sản phẩm                                  |");
			System.out.println("| 2. Hiển thị thông tin sản phẩm                       |");
			System.out.println("| 3. Quản lý thông tin khách hàng                      |");
			System.out.println("| 4. Quản lý hóa đơn                                   |");
			System.out.println("| 5. Cập nhật thông tin khuyến mãi                     |");
			System.out.println("| 6. Thống kê sản phẩm                                 |");
			System.out.println("| 7. Thoát                                             |");
			System.out.println("+------------------------------------------------------+");
			
			Scanner inputs = new Scanner(System.in);
			System.out.print("- Chọn chức năng: ");
			choose = inputs.nextLine();
			switch (choose) {
			case "1":
				menu_1_1();
				break;
			case "2":
				menu_2_1();
				break;
			case "3":
				list_customer.display(); 
				break;
			case "4":
				list_bill.PrintBill();
				break;
			case "5":
				menu_promotion();
				break;
			case "6":
				menu_statistical();
				break;
			case "7":
				break;
			default:
				System.out.println("+===== Bạn đã nhập sai. Xin mời nhập lại =====+");
				break;
			}

		} while (choose.equalsIgnoreCase("7") != true);
		System.out.println("Cám ơn bạn đã sử dụng phần mềm!");
	}
	
	public void menu_statistical() throws IOException {
		Scanner scanner_statistical = new Scanner(System.in);
	
		do {
			System.out.println("+------------------------------------------------------+");
			System.out.println("|------------ Cửa hàng quản lý bán máy tính -----------|");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 1. Thống kê đơn hàng theo ngày tháng                 |");
			System.out.println("| 2. Thống kê số lượng sản phẩm Laptop                 |");
			System.out.println("| 3. Thống kê số lượng sản phẩm PC                     |");
			System.out.println("| 4. Thống kê tổng tiền của cửa hàng                   |");
			System.out.println("| 5. Thoát                                             |"); 
			System.out.println("+------------------------------------------------------+");
			
			System.out.println("- Chọn chức năng : ");
			select = scanner_statistical.nextLine();
			
			switch (select) {
				case "1":
					System.out.println("- Nhập thống kê ngày tháng ( định dạng : dd/MM/yyyy) : ");
					String date = scanner_statistical.nextLine();
					list_bill.statistical_date(date);
					break;
				case "2":
					list_bill.statistical_laptop("Laptop");
					break;
				case "3":
					list_bill.statistical_pc("PC");
					break;
				case "4":
					list_bill.statistical_total("Bill");
					break;
				case "5":
					break;
				default:
					System.out.println("+ ===== Bạn đã nhập sai. Xin mời nhập lại ===== +");
					break;
			}
		} while (select.equalsIgnoreCase("5") != true);
	}
	
	public void menu_1_1() throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("+------------------------------------------------------+");
			System.out.println("|------------ Cửa hàng quản lý bán máy tính -----------|");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 1. Quản lý Laptop                                    |");
			System.out.println("| 2. Quản lý PC                                        |");
			System.out.println("| 3. Thoát                                             |");
			System.out.println("+------------------------------------------------------+");
			
			
			System.out.println("- Chọn chức năng : ");
			select = scanner.nextLine();
			
			switch (select) {
				case "1":
					menu_list_laptop();
					break;
				case "2":
					menu_list_pc();
					break;
				case "3":
					break;
				default:
					System.out.println("+===== Bạn đã nhập sai. Xin mời nhập lại =====+");
			}
		} while (select.equalsIgnoreCase("3") != true);
	}
    
    // * -------------------------------------------------------------------- * //
 	// * ----------------------------- MENU LAPTOP -------------------------- * //
 	// * -------------------------------------------------------------------- * //
 	public static void menu_list_laptop() throws IOException {
 		String choose = null;
 		do {
 			System.out.println("+------------------------------------------------------+");
			System.out.println("|------------ Cửa hàng quản lý bán máy tính -----------|");
 			System.out.println("+------------------------------------------------------+");
 			System.out.println("| 1. Nhập sản phẩm                                     |");
 			System.out.println("| 2. Hiển thị thông tin sản phẩm                       |");
 			System.out.println("| 3. Sửa sản phẩm theo ID Product                      |");
 			System.out.println("| 4. Xóa tất cả sản phẩm                               |");
 			System.out.println("| 5. Xóa sản phẩm theo ID Product                      |");
 			System.out.println("| 6. Tìm kiếm sản phẩm theo ID Product                 |");
 			System.out.println("| 7. Thoát                                             |");
 			System.out.println("+------------------------------------------------------+");
 			
 			Scanner scanner = new Scanner(System.in);
 			System.out.print("Chọn chức năng: ");
 			choose = scanner.nextLine();
 			switch (choose) {
 			case "1":
 				list_laptop.add();
 				list_laptop.display();
 				list_laptop.writeFile();
 				break;
 			case "2":
 				list_laptop.display();
 				break;
 			case "3":
 				System.out.println("Hãy nhập ID Laptop cần sửa : ");
 				String fix = scanner.nextLine();
 				list_laptop.fixID(fix);
 				list_laptop.writeFile();
				System.out.println("+ ===== Đã hoàn tất sửa sản phẩm ===== +");
 				break;
 			case "4":
 				list_laptop.deleteAll();
				System.out.println("+ ===== Đã xóa tất cả sản phẩm trong File ===== +");
 				break;
 			case "5":
 				System.out.println("Hãy nhập ID Laptop cần xóa : ");
				String del = scanner.nextLine();
 				list_laptop.delete(del);
 				list_laptop.writeFile();
				System.out.println("+ ===== Đã xóa thành công sản phẩm ===== +");
 				break;
 			case "6":
 				System.out.println("Hãy nhập ID Laptop cần tìm kiếm : ");
				String search = scanner.nextLine();
 				list_laptop.searchID(search);
 				break;
 			default:
				System.out.println("+ ===== Bạn đã nhập sai. Xin mời nhập lại ===== +");
 				break;
 			}
 		} while (choose.equalsIgnoreCase("7"));
 	}
 	
 	
 	public static void menu_list_pc() throws IOException {
 		String choose = null;
 		do {
 			System.out.println("+------------------------------------------------------+");
			System.out.println("|------------ Cửa hàng quản lý bán máy tính -----------|");
 			System.out.println("+------------------------------------------------------+");
 			System.out.println("| 1. Nhập sản phẩm                                     |");
 			System.out.println("| 2. Hiển thị thông tin sản phẩm                       |");
 			System.out.println("| 3. Sửa sản phẩm theo ID Product                      |");
 			System.out.println("| 4. Xóa tất cả sản phẩm                               |");
 			System.out.println("| 5. Xóa sản phẩm theo ID Product                      |");
 			System.out.println("| 6. Tìm kiếm sản phẩm theo ID Product                 |");
 			System.out.println("| 7. Thoát                                             |");
 			System.out.println("+------------------------------------------------------+");
 			
 			Scanner scanner = new Scanner(System.in);

 			System.out.print("- Chọn chức năng: ");
 			choose = scanner.nextLine();
 			switch (choose) {
 			case "1":
 				list_personalComputer.add();
 				list_personalComputer.display();
 				list_personalComputer.writeFile();
 				break;
 			case "2":
 				list_personalComputer.display();
 				break;
 			case "3":
 				System.out.println("- Hãy nhập ID Computer cần sửa : ");
 				String fix = scanner.nextLine();
 				list_personalComputer.fixID(fix);
 				list_personalComputer.writeFile();
 				break;
			case "4":
				list_personalComputer.deleteAll();
 				System.out.println("+ ===== Đã xóa tất cả sản phẩm trong File ===== +");
 				break;
 			case "5":
 				System.out.println("Hãy nhập ID Computer cần xóa : ");
 				String del = scanner.nextLine();
 				list_personalComputer.delete(del);
 				list_personalComputer.writeFile();
 				System.out.println("+ ===== Đã xóa thành công sản phẩm ===== +");
 				break;
 			case "6":
 				System.out.println("- Hãy nhập ID Computer cần tìm kiếm : ");
 				String search = scanner.nextLine();
 				list_personalComputer.searchID(search);
 				break;
 			default:
				System.out.println("+ ===== Bạn đã nhập sai. Xin mời nhập lại ===== +");
 				break;
 			}
 		} while (choose.equalsIgnoreCase("7") != true);
 		System.out.println("+ ===== Cám ơn bạn đã sử dụng phần mềm! ===== +");
 	}
 	
 	public static void main(String args[]) throws IOException, InterruptedException {
 		MenuMain m = new MenuMain();
 		m.menu();
 	}
}
