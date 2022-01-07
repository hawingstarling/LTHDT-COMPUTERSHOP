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

public class PCList implements Computer {
	
	static Scanner scanner = new Scanner(System.in);
	
	static List<PC> PC = new ArrayList<>();
	
	private static float SALES;
	
	private static float PERCENT;

	private String List_PC ="D:\\SAVE.ELIPSE\\PROJECT_HAWKSTAR_01\\LTHDT\\src\\main\\java\\ExamMidTermOOP\\Comtuter_File\\list_pc.txt";
	
    private String Backup_List_PC ="./Computer_File/backup_list_pc.txt";

	public PCList(List<PC> PC) {
		PCList.PC = PC;
	}
	
	public PCList() {
		// TODO Auto-generated constructor stub
	}

	// 1. Thï¿½m Laptop vï¿½o danh sï¿½ch
	public static void AddPC (PC pc) {
		PC.add(pc);
	}


	// 2. In danh sï¿½ch khï¿½ch hï¿½ng
//	public void PrintPC() {
//		for (PC pc : PC) {
//			pc.display();
//		}
//	}
	
	public void display() {
		System.out.println("+-----------+--------------------+-----------+---------------+---------------+---------------+---------------+---------------+");
		System.out.printf("%10s %20s %10s %15s %15s %15s %15s %15s\n"
				, "|ID Computer|", "Name Computer|", "Neccessery|"
				, "CPU|", "Card|", "RAM|", "Mass|", "Price|");
		System.out.println("+-----------+--------------------+-----------+---------------+---------------+---------------+---------------+---------------+");
		for(Iterator<PC>  it = PC.iterator(); it.hasNext();){
            PC pc = it.next();
            
            System.out.printf("|%11s| %19s| %10s| %14s| %14s| %14s| %14s| %14s|\n"
                    , pc.getIDProducts(), pc.getNameProducts()
                    , pc.getTypes(), pc.getCpu()
                    , pc.getCard(), pc.getRam()
                    , pc.getMass(), pc.getPrice()
            );
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        }

	}
	
	public void add() {
		int key = 1;
		do {
			Scanner sc = new Scanner(System.in);
			PC pc = new PC();
			
			System.out.println("Input ID products: ");
			pc.IDProducts = sc.nextLine();
			
			System.out.println("Input name products: ");
			pc.nameProducts = sc.nextLine();
			
			System.out.println("Input neccessery (Nhu cầu): ");
			pc.types = sc.nextLine();
			
			System.out.println("Input CPU (Bộ vi xử lý): ");
			pc.cpu = sc.nextLine();
			
			System.out.println("Input CARD (Card VGA): ");
			pc.card = sc.nextLine();
			
			System.out.println("Input RAM (Bộ nhớ): ");
			pc.ram = sc.nextLine();
			
			System.out.println("Input Mass (Khối lượng): ");
			pc.mass = sc.nextLine();

			System.out.println("Input price (Giá tiền): ");
			pc.price = sc.nextLine();
			
			PCList.AddPC(pc);
			System.out.println("Nhấn một phím bất kỳ để nhập thêm sản phẩm hoặc nhấn \"1\" để thoát ");
			key = sc.nextInt();
		} while(key != 1);
	}

	// * --------------------------------------------------- * //
	// * -------------------- Đọc File --------------------- * //
	// * --------------------------------------------------- * //
	
	@Override
	public void readFile() throws IOException{    
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(List_PC));
            String s = null;
            do {
                s = in.readLine();
                PC pc = new PC();
                if ( pc.readFile(s) )
					PC.add(pc);
            } while ( s!=null);
            
            in.close();
        } catch (Exception e) {
            System.out.println("Something wrong when reading file");
        }
    }
	

	// * ---------------------------------------------------------- * //
	// * -------------------- Viết File  -------------------------- * //
	// * ---------------------------------------------------------- * //
	
	@Override
    public void writeFile() throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(List_PC));
        for(PC pc : PC){
            pc.writeFile(out);
        }
        out.close();       
    }

    
	// * --------------------------------------------------------- * //
	// * -------------------- Đọc File Backup -------------------- * //
	// * --------------------------------------------------------- * //
	
	@Override
    public void readFile_Backup() throws IOException{    
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(Backup_List_PC));
            String s = null;
            do {
                s = in.readLine();
                PC pc = new PC();
                if ( pc.readFile(s) )
                    PC.add(pc);
            } while ( s!=null);
            
            in.close();
        } catch (Exception e) {
          System.out.println("Something wrong when reading file");
        }
    }

    
	// * ---------------------------------------------------------- * //
	// * -------------------- Viết File Backup -------------------- * //
	// * ---------------------------------------------------------- * //
	
	@Override
    public void writeFile_Backup() throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(Backup_List_PC));
        for(PC pc : PC){
            pc.writeFile(out);
        }
        out.close();       
    }
    
    
    // * --------------------------------------------------------- * //
 	// * ------------------- Xóa PC theo ID ---------------------- * //
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
         for (Iterator<PC> it = PC.iterator(); it.hasNext();) {
             PC pc = it.next();
             if (pc.getIDProducts().compareToIgnoreCase(id)==0){
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
		PC.removeAll(PC);
	}
	
	
	// * ---------------------------------------------------------- * //
	// * ------------------- Sửa pc theo id ----------------------- * //
	// * ---------------------------------------------------------- * //
	public boolean fixID(String id) {
		for (Iterator<PC> it = PC.iterator(); it.hasNext();) {
            PC p = it.next();
            if(p.getIDProducts().compareToIgnoreCase(id) == 0) {
                p.input();
                return true;
            }
		}
		System.out.println("Không có ID sản phẩm trong kho hàng");
		return false;
	}
	
	
	// * -------------------------------------------------------------------- * //
	// * ------------------- Tìm kiếm pc theo id ---------------------------- * //
	// * -------------------------------------------------------------------- * //
	public boolean searchID(String id) {
		for (Iterator<PC> it = PC.iterator(); it.hasNext();) {
			PC p = it.next();
            if(p.getIDProducts().compareToIgnoreCase(id) == 0) {
                p.display();
                return true;
            }
		}
		System.out.println("Tìm kiếm sản phẩm không có ID");
		return false;
		
	}
	
	// * -------------------------------------------------------------------- * //
	// * ----------------- Khuyến mãi theo ID Products ---------------------- * //
	// * -------------------------------------------------------------------- * //
	public void pc_promotion(String id) {
		
		System.out.println("- Nhập phần trăm khuyến mãi sản phẩm này : ");
		PERCENT = scanner.nextFloat();
		
		for(Iterator<PC>  it = PC.iterator(); it.hasNext();){
			PC pc = it.next();
            if ( pc.getIDProducts().compareToIgnoreCase(id) == 0 ) {
            	float price = Float.parseFloat(pc.getPrice());
            	SALES = price * (1 - PERCENT);
            	String total = Float.toString(SALES);
            	pc.setPrice(total);
            	pc.display();
            }
		}
	}
}
