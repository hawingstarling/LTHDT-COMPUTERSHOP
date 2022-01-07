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

public class StaffList {
	
	static List<Staff> STAFF = new ArrayList<>();
	
	// * ---------------------------------------------------- * //
	// * ---------- Lưu dữ liệu vào File danh sách ---------- * //
	// * ---------------------------------------------------- * //
	private String List_Staff = "D:\\SAVE.ELIPSE\\PROJECT_HAWKSTAR_01\\LTHDT\\src\\main\\java\\ExamMidTermOOP\\Comtuter_File\\list_staff.txt";
	
	
	// * -------------------------------------------------------- * //
	// * ---------- Lưu dữ liệu dự phòng khi có backup ---------- * //
	// * -------------------------------------------------------- * //
    private String Backup_List_Staff ="./LTHDT/src/main/java/ExamMidTermOOP/Computer_File/backup_list_staff.txt";

	public StaffList(List<Staff> STAFF) {
		StaffList.STAFF = STAFF;
	}

	public StaffList() {
		super();
	}
	
	// 1. Thêm nhân viên vào danh sách
	public static void AddStaff (Staff sta) {
		STAFF.add(sta);
	}
	
	// 2. In danh sách nhân viên
//	public void PrintStaff(Staff sta) {
//		for (Staff staff : STAFF) {
//			staff.display();
//		}
//	}
	// 2.1 In danh sách nhân viên
	public void display() {
		System.out.println("+----------+--------------------+-----------------------------+-----------+----------+------+");
		System.out.printf("%10s %20s %30s %11s %10s %6s\n"
				, "|ID Staff|", "Name Staff|", "Address|"
				, "Phone Number|", "Birthday|", "Gender|");
		System.out.println("+----------+--------------------+-----------------------------+-----------+----------+------+");
		for(Iterator<Staff>  it = STAFF.iterator(); it.hasNext();){
            Staff st = it.next();
            
            System.out.printf("|%9s| %19s| %29s| %10s| %9s| %5s|\n"
                    , st.getIDStaff(), st.getName()
                    , st.getAddress(), st.getPhone()
                    , st.getDate(), st.getSex()
            );
            System.out.println("------------------------------------------------------------------------------------------------------------");
        }

	}
	
	public void input() {
		int key = 1;
		do {
			Scanner sc = new Scanner(System.in);
			Staff sf = new Staff();
		
			System.out.println("Nhập ID Staff: ");
			sf.setIDStaff(sc.nextLine());
			
			sf.input();
			StaffList.AddStaff(sf);
			System.out.println("Enter number '0' if you want input add Staff ! and enter '1' to exit");
			key = sc.nextInt();
		} while(key != 1);
	}
	
	// * --------------------------------------------------- * //
	// * -------------------- Viết File -------------------- * //
	// * --------------------------------------------------- * //
	
	public void writeFile() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(List_Staff));
		for (Staff st : STAFF) {
			st.writeFile(out);
		}
		out.close();
	}
	// * --------------------------------------------------- * //
	// * -------------------- Đọc File --------------------- * //
	// * --------------------------------------------------- * //
	
	public void readFile() throws IOException {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(List_Staff));
			String s = null;
			do {
				s = input.readLine();
				Staff st = new Staff();
				if (st.readFile(s))
					STAFF.add(st);
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
		BufferedWriter out = new BufferedWriter(new FileWriter(Backup_List_Staff));
        for(Staff st : STAFF){
            st.writeFile(out);
        }
        out.close(); 
	}
	// * --------------------------------------------------------- * //
	// * -------------------- Đọc File Backup -------------------- * //
	// * --------------------------------------------------------- * //
	
	public void readFile_Backup() throws IOException {
		BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(Backup_List_Staff));
            String s = null;
            do {
                s = input.readLine();
                Staff st = new Staff();
                if ( st.readFile(s) )
                    STAFF.add(st);
            } while ( s!=null);
            
            input.close();
        } catch (Exception e) {
            System.out.println("Lỗi, không thể đọc File");
        }
		
	}
	
	// * --------------------------------------------------------- * //
	// * ----------------- Xóa nhân viên theo ID ----------------- * //
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
        for (Iterator<Staff> it = STAFF.iterator(); it.hasNext();) {
            Staff st = it.next();
            if (st.getIDStaff().compareToIgnoreCase(id)==0){
                it.remove();
                return true;
            }
        }
        return false;
    }
	
	// * --------------------------------------------------------- * //
	// * ------------------ Xóa tất cả nhân viên ----------------- * //
	// * --------------------------------------------------------- * //
	public void deleteAll() {
		STAFF.removeAll(STAFF);
	}
	
	
	// * ---------------------------------------------------------- * //
	// * ------------------ Sửa nhân viên theo id ----------------- * //
	// * ---------------------------------------------------------- * //
	// * ----- Vào hàm menu trong phần switch case để nhập ID ----- * //
	public boolean fixID(String id) {
		for (Iterator<Staff> it = STAFF.iterator(); it.hasNext();) {
            Staff st = it.next();
            if(st.getIDStaff().compareToIgnoreCase(id) == 0) {
                st.input();
                return true;
            }
		}
		System.out.println("Không có ID nhân viên trong dữ liệu");
		return false;
		
	}
	
	
	// * -------------------------------------------------------------------- * //
	// * ------------------ Tìm kiếm nhân viên theo id ---------------------- * //
	// * -------------------------------------------------------------------- * //
	public boolean searchID(String id) {
		for (Iterator<Staff> it = STAFF.iterator(); it.hasNext();) {
            Staff st = it.next();
            if(st.getIDStaff().compareToIgnoreCase(id) == 0) {
                st.display();
                return true;
            }
		}
		System.out.println("Tìm kiếm nhân viên không có ID");
		return false;
	}
}
