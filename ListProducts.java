package ExamMidTermOOP;

import java.util.Iterator;

public class ListProducts {
	
	LaptopList laptop_list = new LaptopList();
	
	private static String IDL;
	
	private static String IDP;

	public ListProducts(String iDL, String iDP) {
		IDL= null;
		IDP = null;
	}
	
	public ListProducts() {
		
	}

	public String getIDL() {
		return IDL;
	}

	public void setIDL(String iDLaptop) {
		IDL = iDLaptop;
	}

	public String getIDP() {
		return IDP;
	}

	public void setIDProducts(String iDPC) {
		IDP = iDPC;
	}
	
	public String InputLaptop(String id) {
		for (Iterator<Laptop> it = laptop_list.LAPTOP.iterator(); it.hasNext();) {
    		Laptop l = it.next();
    		if (l.getIDLaptop().compareToIgnoreCase(id) == 0) {
    			IDL = l.getIDLaptop();
    			return id;
    		}
    	}
		System.out.println("===== Mã Laptop không có trong dữ liệu =====");
    	return null;
	}
	
	public String PriceLaptop(String id) {
		for (Iterator<Laptop> it = laptop_list.LAPTOP.iterator(); it.hasNext();) {
    		Laptop l = it.next();
    		if (l.getIDLaptop().compareToIgnoreCase(id) == 0) {
    			IDL = l.getPriceLaptop();
    			break;
    		}
    	}
    	return IDL;
	}
	
	public static String InputPC(String id) {
		for (Iterator<PC> it = PCList.PC.iterator(); it.hasNext();) {
    		PC p = it.next();
    		if (p.getIDProducts().compareToIgnoreCase(id) == 0) {
    			IDP = p.getIDProducts();
    			return id;
    		}
    	}
    	System.out.println("===== Mã máy tính không có trong dữ liệu =====");
    	return null;
	}
	
	public static String PricePC(String id) {
		for (Iterator<PC> it = PCList.PC.iterator(); it.hasNext();) {
    		PC p = it.next();
    		if (p.getIDProducts().compareToIgnoreCase(id) == 0) {
    			IDP = p.getPrice();
    		}
    	}
    	return IDP;
	}
}
