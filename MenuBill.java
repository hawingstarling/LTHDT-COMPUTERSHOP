package ExamMidTermOOP;

import java.io.IOException;
import java.util.Scanner;

public class MenuBill {
	
	static Scanner scanner = new Scanner(System.in);
	MenuMain menu_main = new MenuMain();
	String account = "admin";
	String password = "admin";
	String re_account = null;
	String re_password = null;
	
	ListBill list_bill = new ListBill();
	
	public void menu() throws IOException, InterruptedException {
		int select = 0;
		do {
			Scanner scanner = new Scanner(System.in);
	        System.out.println(
	                " _______________________________________________ \n" +
	                "|                                               |\n" +
	                "|         WELCOME TO OUR APPLICATION            |\n" +
	                "|_______________________________________________|\n" +
	                "|                                               |\n" +
	                "|                    Login                      |\n" +
	                "|_______________________________________________|  "
	        );
			System.out.println("|1. Bạn là quản trị viên ?                      |");
			System.out.println("|2. Bạn là khách hàng ?                         |");
			System.out.println("+_______________________________________________+");
			System.out.println("+ ===== Xin mời chọn chức năng ===== +");
			System.out.println("- Chức năng : ");
			select = scanner.nextInt();
		switch (select) {
			case 1:	// Vào trang Admin
				Scanner scanner1 = new Scanner(System.in); 
				System.out.println("- Nhập tài khoản : ");
				re_account = scanner1.nextLine();

				Scanner scanner2 = new Scanner(System.in);
				System.out.println("- Mật khẩu : ");
				re_password = scanner2.nextLine();

				if ( (account.equals(re_account)) && (password.equals(re_password)) ) {
					menu_main.readFile();
					menu_main.menu();
				} else { 
					System.out.println("+ ===== Tài khoản hoặc mật khẩu của bạn không chính xác ===== +");
				}
				break;
			case 2:	// Vào trang users
				list_bill.readFile();
				list_bill.readFiles();
				list_bill.menu_add();
					break;
			default:
				System.out.println("+ ===== Bạn đã nhập sai giá trị. Xin mời nhập lại ===== +");
					break;
		}
			
	} while (select != 0);
	System.out.println("+ ===== Hệ thống đã thoát ! ===== +");
}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		MenuBill m = new MenuBill();
		m.menu();
	}
}
