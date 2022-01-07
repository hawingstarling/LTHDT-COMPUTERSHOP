package ExamMidTermOOP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CustomerList {
	
	Random random_generator = new Random();
	
	static List<Customer> CUSTOMER = new ArrayList<>();
	
	// * ---------------------------------------------------- * //
	// * ---------- Lưu dữ liệu vào File danh sách ---------- * //
	// * ---------------------------------------------------- * //
	private String List_Customer = "D:\\SAVE.ELIPSE\\PROJECT_HAWKSTAR_01\\LTHDT\\src\\main\\java\\ExamMidTermOOP\\Comtuter_File\\list_customer.txt";
	
	
	// * -------------------------------------------------------- * //
	// * ---------- Lưu dữ liệu dự phòng khi có backup ---------- * //
	// * -------------------------------------------------------- * //
    private String Backup_List_Customer ="./LTHDT/src/main/java/ExamMidTermOOP/Computer_File/backup_list_customer.txt";

	public CustomerList(List<Customer> CUSTOMER) {
		CustomerList.CUSTOMER = CUSTOMER;
	}
	
	public CustomerList() {
		// TODO Auto-generated constructor stub
	}

	// 1. Thêm khách hàng vào danh sách
	public static void AddCustomer (Customer cus) {
		CUSTOMER.add(cus);
	}
	
	// 2. In danh sách khách hàng
//	public void PrintCustomer() {
//		for (Customer customer : CUSTOMER) {
//			customer.display
//			();
//		}
//	}
	
	public void display() {
		System.out.println("+----------------+--------------------+-----------------------------+-------------+-----------+-------+");
		System.out.printf("%18s %20s %29s %11s %11s %4s\n"
				, "ID Customer|", "Name Staff|", "Address|"
				, "Phone Number|", "Birthday|", "Gender|");
		for (Iterator<Customer> it = CUSTOMER.iterator(); it.hasNext();) {
			Customer cu = it.next();
			System.out.println("+----------------+--------------------+-----------------------------+-------------+-----------+-------+");
	        System.out.printf("|%11s| %19s| %28s| %12s| %9s| %6s|\n"
	                , cu.getIDCustomer(), cu.getName()
	                , cu.getAddress(), cu.getPhone()
	                , cu.getDate(), cu.getSex()
	        	);
		}
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
	
	public void add() {
		int key = 1;
		do {
			Scanner sc = new Scanner(System.in);
			Customer customer = new Customer();
			
			customer.setIDCustomer("Customer_" + random_generator.nextInt(1000) + "_" + random_generator.nextInt(1000));
			customer.input();
			CustomerList.AddCustomer(customer);
			System.out.println("Enter number '0' if you want input add Customer ! and enter '1' to exit");
			key = sc.nextInt();
		} while(key != 1);
	}
	
	// * --------------------------------------------------- * //
	// * -------------------- Viết File -------------------- * //
	// * --------------------------------------------------- * //

	public void writeFile() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(List_Customer));
		for (Customer cu : CUSTOMER) {
			cu.writeFile(out);
		}
		out.close();
	}
	// * --------------------------------------------------- * //
	// * -------------------- Đọc File --------------------- * //
	// * --------------------------------------------------- * //

	public void readFile() throws IOException {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(List_Customer));
			String s = null;
			do {
				s = input.readLine();
				Customer cu = new Customer();
				if (cu.readFile(s))
					CUSTOMER.add(cu);
			} while (s != null);
			input.close();
		} catch (Exception e) {
			System.out.println("Lỗi, không thể đọc File. Vui lòng thử lại !!");
		}
	}
	// * ---------------------------------------------------------- * //
	// * -------------------- Viết File Backup -------------------- * //
	// * ---------------------------------------------------------- * //

	public void writeFile_Backup() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(Backup_List_Customer));
        for(Customer cu : CUSTOMER){
            cu.writeFile(out);
        }
        out.close(); 
	}
	// * --------------------------------------------------------- * //
	// * -------------------- Đọc File Backup -------------------- * //
	// * --------------------------------------------------------- * //

	public void readFile_Backup() throws IOException {
		BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(Backup_List_Customer));
            String s = null;
            do {
                s = input.readLine();
                Customer cu = new Customer();
                if ( cu.readFile(s) )
                    CUSTOMER.add(cu);
            } while ( s!=null);
            
            input.close();
        } catch (Exception e) {
            System.out.println("Lỗi, không thể đọc File");
        }
	}
	
	// * --------------------------------------------------------- * //
	// * --------------- Xóa khách hàng theo ID ------------------ * //
	// * --------------------------------------------------------- * //
	
	// Iterator : duyệt các phần tử từ đầu đến cuối của một Collection
	// Cú pháp :  
	// +===== ArrayList<String> list = new ArrayList<>(); +=====
	// +===== Iterator<String> itr = list.iterator(); +=====
	// Iterator gồm các phương thức :
	// 1. hasNext() : trả về true nếu iterator còn phần tử kế tiếp phần tử đang duyệt
	// 2. next() : trả về phần tử hiện tại và di chuyển con trỏ đến phần tử tiếp theo
	// 3. remove() : loại bỏ phần tử cuối được trả về vởi Iterator
	
	public boolean delete(String id){
        for (Iterator<Customer> it = CUSTOMER.iterator(); it.hasNext();) {
        	Customer cu = it.next();
            if (cu.getIDCustomer().compareToIgnoreCase(id)==0){
                it.remove();
                return true;
            }
        }
        return false;
    }
	
	// * --------------------------------------------------------- * //
	// * ---------------- Xóa tất cả khách hàng ------------------ * //
	// * --------------------------------------------------------- * //
	public void deleteAll() {
		CUSTOMER.removeAll(CUSTOMER);
	}
	
	
	// * ---------------------------------------------------------- * //
	// * ------------------- Sửa laptop theo id ------------------- * //
	// * ---------------------------------------------------------- * //
	// * ----- Vào hàm menu trong phần switch case để nhập ID ----- * //
	public boolean fixID(String id) {
		for (Iterator<Customer> it = CUSTOMER.iterator(); it.hasNext();) {
			Customer cu = it.next();
            if(cu.getIDCustomer().compareToIgnoreCase(id) == 0) {
            	cu.input();
                return true;
            }
		}
		System.out.println("Không có ID khách hàng này");
		return false;
		
	}
	
	
	// * -------------------------------------------------------------------- * //
	// * ------------------- Tìm kiếm laptop theo id ------------------------ * //
	// * -------------------------------------------------------------------- * //
	public boolean searchID(String id) {
		for (Iterator<Customer> it = CUSTOMER.iterator(); it.hasNext();) {
			Customer l = it.next();
            if(l.getIDCustomer().compareToIgnoreCase(id) == 0) {
                l.display();
                return true;
            }
		}
		System.out.println("Tìm kiếm khách hàng không có ID");
		return false;
	}
}
