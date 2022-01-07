package ExamMidTermOOP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Promotion {
	
	static List<Laptop> LAPTOP = new ArrayList<>();
	
	static List<PC> PC = new ArrayList<>();
	
    private float SALES;
	
	private float PERCENT = 0.5f;
	
	public static LaptopList list_laptop = new LaptopList();
	
	public static PCList list_personalComputer = new PCList();
	
	// * -------------------------------------------------------------------- * //
	// * ----------------- Khuyến mãi theo ID Products ---------------------- * //
	// * -------------------------------------------------------------------- * //
	public void laptop_promotion(String id) throws IOException {
		list_laptop.readFile();
		for(Iterator<Laptop>  it = LAPTOP.iterator(); it.hasNext();) {
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
	
	// * -------------------------------------------------------------------- * //
	// * ----------------- Khuyến mãi theo ID Products ---------------------- * //
	// * -------------------------------------------------------------------- * //
	public void pc_promotion(String id) {
		
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
