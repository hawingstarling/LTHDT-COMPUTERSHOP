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

public class SupplierList {
	
	Scanner scanner = new Scanner(System.in);
	
	List<Supplier> SUPPLIER = new ArrayList<>();
	
	// * ---------------------------------------------------- * //
	// * ---------- Lưu dữ liệu vào File danh sách ---------- * //
	// * ---------------------------------------------------- * //
	private String List_Supplier = "D:\\SAVE.ELIPSE\\PROJECT_HAWKSTAR_01\\LTHDT\\src\\main\\java\\ExamMidTermOOP\\Comtuter_File\\list_supplier.txt";
	
	
	// * -------------------------------------------------------- * //
	// * ---------- Lưu dữ liệu dự phòng khi có backup ---------- * //
	// * -------------------------------------------------------- * //
    private String Backup_List_Supplier ="./LTHDT/src/main/java/ExamMidTermOOP/Computer_File/backup_list_Supplier.txt";


	public SupplierList() {
		
	}

	public SupplierList(List<Supplier> SUPPLIER) {
		this.SUPPLIER = SUPPLIER;
	}
    
    // 1. Thêm nhà cung cấp vào danh sách
	public void AddSupplier(Supplier s) {
		this.SUPPLIER.add(s);
	}
	
	// 2. In danh sách nhà cung cấp
	public void display() {
		System.out.println("+---------+--------------------+------------------------------+-----------+");
		System.out.printf("%10s %20s %30s %11s\n"
				, "|ID Supplier|", "Name Supplier|", "Address|"
				, "Phone Number|");
		System.out.println("+---------+--------------------+------------------------------+-----------+");
		for(Iterator<Supplier>  it = SUPPLIER.iterator(); it.hasNext();){
			Supplier su = it.next();
            
            System.out.printf("|%9s| %19s| %29s| %11s|\n"
                    , su.getIDSupplier(), su.getNameSupplier()
                    , su.getAddress(), su.getSdt()
            );
            System.out.println("------------------------------------------------------------------------------------------------------------");
        }
	}
	
	// 3. Nhập danh sách nhà cung cấp
    public void input(){
    	int key = 1;
    	do {
    		Scanner sc = new Scanner(System.in);
    		Supplier su = new Supplier();
    		
            System.out.println("Hãy nhập tên nhà cung cấp: ");
            su.setNameSupplier(sc.nextLine());
            
            System.out.println("Nhập địa chỉ nhà cung cấp: ");
            su.setAddress(sc.nextLine());
            
            do {
                System.out.println("Hãy nhập số điện thoại (10 kí tự)");
                su.setSdt(sc.nextLine());
                while(Supplier.isNum(su.getSdt()) != true){
                    System.out.println("Bạn đã nhập sai. Hãy nhập số nguyên: ");
                    su.setSdt(sc.nextLine());
                }
            } while(su.getSdt() == "" || Long.parseLong(su.getSdt()) < 0  || su.getSdt().length() != 10);
            AddSupplier(su);
			System.out.println("Enter number '0' if you want input add Supplier ! and enter '1' to exit");
			key = sc.nextInt();
    	} while (key != 1);
    }
    
	// * --------------------------------------------------- * //
	// * -------------------- Viết File -------------------- * //
	// * --------------------------------------------------- * //
	
	public void writeFile() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(List_Supplier));
		for (Supplier su : SUPPLIER) {
			su.writeFile(out);
		}
		out.close();
	}
	// * --------------------------------------------------- * //
	// * -------------------- Đọc File --------------------- * //
	// * --------------------------------------------------- * //
	
	public void readFile() throws IOException {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(List_Supplier));
			String s = null;
			do {
				s = input.readLine();
				Supplier su = new Supplier();
				if (su.readFile(s))
					SUPPLIER.add(su);
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
		BufferedWriter out = new BufferedWriter(new FileWriter(Backup_List_Supplier));
        for(Supplier su : SUPPLIER){
            su.writeFile(out);
        }
        out.close(); 
	}
	// * --------------------------------------------------------- * //
	// * -------------------- Đọc File Backup -------------------- * //
	// * --------------------------------------------------------- * //
	
	public void readFile_Backup() throws IOException {
		BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(Backup_List_Supplier));
            String s = null;
            do {
                s = input.readLine();
                Supplier su = new Supplier();
                if ( su.readFile(s) )
                    SUPPLIER.add(su);
            } while ( s!=null);
            
            input.close();
        } catch (Exception e) {
            System.out.println("Lỗi, không thể đọc File");
        }
	}
	
	// * --------------------------------------------------------- * //
	// * ------------------- Xóa Supplier theo ID ------------------ * //
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
        for (Iterator<Supplier> it = SUPPLIER.iterator(); it.hasNext();) {
            Supplier pb = it.next();
            if (pb.getIDSupplier().compareToIgnoreCase(id)==0){
                it.remove();
                return true;
            }
        }
        return false;
    }
	
	// * --------------------------------------------------------- * //
	// * ------------------- Xóa tất cả Supplier ------------------- * //
	// * --------------------------------------------------------- * //
	public void deleteAll() {
		SUPPLIER.removeAll(SUPPLIER);
	}
	
	
	// * ---------------------------------------------------------- * //
	// * ------------------- Sửa Supplier theo id ------------------- * //
	// * ---------------------------------------------------------- * //
	// * ----- Vào hàm menu trong phần switch case để nhập ID ----- * //
	public boolean fixID(String id) {
		for (Iterator<Supplier> it = SUPPLIER.iterator(); it.hasNext();) {
            Supplier su = it.next();
            if(su.getIDSupplier().compareToIgnoreCase(id) == 0) {
                su.input();
                return true;
            }
		}
		System.out.println("Không có ID nhà cung cấp này");
		return false;
		
	}
	
	
	// * -------------------------------------------------------------------- * //
	// * ------------------- Tìm kiếm Supplier theo id ------------------------ * //
	// * -------------------------------------------------------------------- * //
	public boolean searchID(String id) {
		for (Iterator<Supplier> it = SUPPLIER.iterator(); it.hasNext();) {
            Supplier su = it.next();
            if(su.getIDSupplier().compareToIgnoreCase(id) == 0) {
                su.display();
                return true;
            }
		}
		System.out.println("Tìm kiếm sản phẩm không có ID");
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		SupplierList sl = new SupplierList();
		sl.input();
		sl.readFile();
		sl.writeFile();
	}

}
