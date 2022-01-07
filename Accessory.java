package ExamMidTermOOP;

import java.io.IOException;

public abstract class Accessory {
	
	protected String cpu;
	
	protected String ram;
	
	protected String card;
	
	protected String mainboard;
	
	protected String radiators;
	
	protected String casePC;
	
	protected String psu;

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getMainboard() {
		return mainboard;
	}

	public void setMainboard(String mainboard) {
		this.mainboard = mainboard;
	}

	public String getRadiators() {
		return radiators;
	}

	public void setRadiators(String radiators) {
		this.radiators = radiators;
	}

	public String getCasePC() {
		return casePC;
	}

	public void setCasePC(String casePC) {
		this.casePC = casePC;
	}

	public String getPsu() {
		return psu;
	}

	public void setPsu(String psu) {
		this.psu = psu;
	}

	public Accessory(String cpu, String ram, String card, String mainboard, String radiators, String casePC,
			String psu) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.card = card;
		this.mainboard = mainboard;
		this.radiators = radiators;
		this.casePC = casePC;
		this.psu = psu;
	}

	public Accessory() {
		super();
	}
	
	public abstract void input();
	
	public abstract void display();
	
}
