package ExamMidTermOOP;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	static LaptopList laptoplist = new LaptopList();
	static PCList pclist = new PCList();
	static Promotion a = new Promotion();
//	public static void menu() {
//		String choose = null;
//		do {
//			System.out.println("+------------------------------------------------------+");
//			System.out.println("|---------------- QUẢN LÝ BÁN MÁY TÍNH ----------------|");
//			System.out.println("+------------------------------------------------------+");
//			System.out.println("| 1. Nhập sản phẩm                                     |");
//			System.out.println("| 2. Hiển thị thông tin sản phẩm                       |");
//			System.out.println("| 3. Quản lý thông tin khách hàng                      |");
//			System.out.println("| 4. Quản lý hóa đơn                                   |");
//			System.out.println("| 5. Cập nhật chế độ bảo hành                          |");
//			System.out.println("| 6. Cập nhật thông tin khuyến mãi                     |");
//			System.out.println("| 7. Quản lý thông tin trả góp                         |");
//			System.out.println("| 8. Thoát                                             |");
//			System.out.println("+------------------------------------------------------+");
//			
//			Scanner inputs = new Scanner(System.in);
//			try {
//				System.out.print("Chọn chức năng: ");
//				choose = inputs.nextLine();
//				switch (choose) {
//				case "1":
//					// insert
//					break;
//				case "2":
//					// insert
//					break;
//				case "3":
//					// insert
//					break;
//				case "4":
//					// insert
//					break;
//				case "5":
//					// insert
//					break;
//				case "6":
//					// insert
//					break;
//				case "7":
//					// insert
//					break;
//					
//				default:
//					break;
//				}
//			} catch (InputMismatchException ei) {
//				System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		} while (choose.equalsIgnoreCase("0"));
//		System.out.println("Cám ơn bạn đã sử dụng phần mềm!");
//	}
	
	public static void main(String[] args) throws IOException {
		Laptop laptop = new Laptop();
		PC pc = new PC();
		laptoplist.readFile();
//		laptoplist.fixID("Laptop_02");
//		laptoplist.writeFile();
//		laptoplist.display();
//		Promotion.laptop_promotion("Laptop_05");
////		pclist.readFile();
//		pclist.display();
	}
}

