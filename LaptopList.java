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

public class LaptopList implements Computer {
	
    static Scanner scanner = new Scanner(System.in);
    
    private float SALES;
	
	private float PERCENT;
	
	static List<Laptop> LAPTOP = new ArrayList<>();

	private String List_Laptop = "D:\\SAVE.ELIPSE\\PROJECT_HAWKSTAR_01\\LTHDT\\src\\main\\java\\ExamMidTermOOP\\Comtuter_File\\list_laptop.txt";
	
    private String Backup_List_Laptop ="./LTHDT/src/main/java/ExamMidTermOOP/Computer_File/backup_list_laptop.txt";

	public LaptopList(List<Laptop> LAPTOP) {
		LaptopList.LAPTOP = LAPTOP;
	}
	
	public LaptopList() {
		// TODO Auto-generated constructor stub
	}

	// 1. Thêm Laptop vào danh sách
	public static void AddLaptop (Laptop laptop) {
		LAPTOP.add(laptop);
	}

	// 2. In danh sách sản phẩm Laptop
//	public void PrintLaptop() {
//		for (Laptop laptop : LAPTOP) {
//			laptop.display();
//		}
//	}
	
	
	// 2.1. In danh sách sản phẩm Laptop
	public void display() {
		System.out.println("+---------+--------------------+-----------+---------------+---------------+---------------+---------------+");
		System.out.printf("%10s %20s %10s %15s %15s %15s %15s\n"
				, "|ID Laptop|", "Name Laptop|", "Neccessery|"
				, "CPU|", "Card|", "RAM|", "Price|");
		System.out.println("+---------+--------------------+-----------+---------------+---------------+---------------+---------------+");
		for(Iterator<Laptop>  it = LAPTOP.iterator(); it.hasNext();){
            Laptop laptop = it.next();
            
            System.out.printf("|%9s| %19s| %10s| %14s| %14s| %14s| %14s|\n"
                    , laptop.getIDLaptop(), laptop.getNameLaptop()
                    , laptop.getTypesLaptop(), laptop.getCpu()
                    , laptop.getCard(), laptop.getRam()
                    , laptop.getPriceLaptop()
            );
            System.out.println("------------------------------------------------------------------------------------------------------------");
        }

	}
	
	public void add() {
		int key = 1;
		do {
			Scanner sc = new Scanner(System.in);
			Laptop laptop = new Laptop();
			
			System.out.println("Input ID products: ");
			laptop.setIDLaptop(sc.nextLine());
			
			System.out.println("Input name products: ");
			laptop.setNameLaptop(sc.nextLine());
			
			System.out.println("Input neccessery (Nhu cầu): ");
			laptop.setTypesLaptop(sc.nextLine());
			
			System.out.println("Input CPU (Bộ vi xử lý): ");
			laptop.cpu = sc.nextLine();
			
			System.out.println("Input CARD (Card VGA): ");
			laptop.card = sc.nextLine();
			
			System.out.println("Input RAM (Bộ nhớ): ");
			laptop.ram = sc.nextLine();
			
			System.out.println("Input price (Giá tiền): ");
			laptop.setPriceLaptop(sc.nextLine());
			
			LaptopList.AddLaptop(laptop);
			System.out.println("Nhấn một phím bất kỳ để nhập thêm sản phẩm hoặc nhấn \"1\" để thoát");
			key = sc.nextInt();
		} while(key != 1);
	}
	
	
	
	// * --------------------------------------------------- * //
	// * -------------------- Viết File -------------------- * //
	// * --------------------------------------------------- * //
	@Override
	public void writeFile() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(List_Laptop));
		for (Laptop lt : LAPTOP) {
			lt.writeFile(out);
		}
		out.close();
	}
	// * --------------------------------------------------- * //
	// * -------------------- Đọc File --------------------- * //
	// * --------------------------------------------------- * //
	@Override
	public void readFile() throws IOException {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(List_Laptop));
			String s = null;
			do {
				s = input.readLine();
				Laptop lp = new Laptop();
				if (lp.readFile(s))
					LAPTOP.add(lp);
			} while (s != null);
			input.close();
		} catch (Exception e) {
			System.out.println("Lỗi, không thể đọc File. Vui lòng thử lại !!");
		}
	}
	// * ---------------------------------------------------------- * //
	// * -------------------- Viết File Backup -------------------- * //
	// * ---------------------------------------------------------- * //
	@Override
	public void writeFile_Backup() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(Backup_List_Laptop));
        for(Laptop lp : LAPTOP){
            lp.writeFile(out);
        }
        out.close(); 
	}
	// * --------------------------------------------------------- * //
	// * -------------------- Đọc File Backup -------------------- * //
	// * --------------------------------------------------------- * //
	@Override
	public void readFile_Backup() throws IOException {
		BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(Backup_List_Laptop));
            String s = null;
            do {
                s = input.readLine();
                Laptop lp = new Laptop();
                if ( lp.readFile(s) )
                    LAPTOP.add(lp);
            } while ( s!=null);
            
            input.close();
        } catch (Exception e) {
            System.out.println("Lỗi, không thể đọc File");
        }
		
	}
	
	// * --------------------------------------------------------- * //
	// * ------------------- Xóa laptop theo ID ------------------ * //
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
        for (Iterator<Laptop> it = LAPTOP.iterator(); it.hasNext();) {
            Laptop pb = it.next();
            if (pb.getIDLaptop().compareToIgnoreCase(id) == 0){
                it.remove();
                return true;
            }
        }
        return false;
    }
	
	// * --------------------------------------------------------- * //
	// * ------------------- Xóa tất cả laptop ------------------- * //
	// * --------------------------------------------------------- * //
	public void deleteAll() {
		LAPTOP.removeAll(LAPTOP);
	}
	
	
	// * ---------------------------------------------------------- * //
	// * ------------------- Sửa laptop theo id ------------------- * //
	// * ---------------------------------------------------------- * //
	// * ----- Vào hàm menu trong phần switch case để nhập ID ----- * //
	public boolean fixID(String id) {
		for (Iterator<Laptop> it = LAPTOP.iterator(); it.hasNext();) {
            Laptop l = it.next();
            if(l.getIDLaptop().compareToIgnoreCase(id) == 0) {
                l.input();
                return true;
            }
		}
		System.out.println("Không có ID sản phẩm trong kho hàng");
		return false;
		
	}
	
	
	// * -------------------------------------------------------------------- * //
	// * ------------------- Tìm kiếm laptop theo id ------------------------ * //
	// * -------------------------------------------------------------------- * //
	public boolean searchID(String id) {
		for (Iterator<Laptop> it = LAPTOP.iterator(); it.hasNext();) {
            Laptop l = it.next();
            if(l.getIDLaptop().compareToIgnoreCase(id) == 0) {
                l.display();
                return true;
            }
		}
		System.out.println("Tìm kiếm sản phẩm không có ID");
		return false;
	}
	
	// * -------------------------------------------------------------------- * //
	// * ----------------- Khuyến mãi theo ID Products ---------------------- * //
	// * -------------------------------------------------------------------- * //
	public void laptop_promotion(String id) {
		
		System.out.println("- Nhập phần trăm khuyến mãi sản phẩm này : ");
		PERCENT = scanner.nextFloat();
		
		for(Iterator<Laptop>  it = LAPTOP.iterator(); it.hasNext();){
            Laptop laptop = it.next();
            if ( laptop.getIDLaptop().compareToIgnoreCase(id) == 0 ) {
            	float price = Float.parseFloat(laptop.getPriceLaptop());
            	SALES = price * (1 - PERCENT);
            	String total = Float.toString(SALES);
            	laptop.setPriceLaptop(total);
            	laptop.display();
            }
		}
	}
}
