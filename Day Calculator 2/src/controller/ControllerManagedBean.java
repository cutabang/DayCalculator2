package controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import sheridan.DayCalculator;

@ManagedBean
@RequestScoped
public class ControllerManagedBean {
    public static String SUCCESS = "success";
	
	private DayCalculator calculator;
    private int days;
    
    @PostConstruct
    public void init() {
    	calculator = new DayCalculator();
    }

    public String calculateDay() {
    	calculator.addDays(days);
    	FacesContext.getCurrentInstance().getExternalContext().getFlash().put("controllerManagedBean", this);
    	
    	return SUCCESS;
    }
	public DayCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(DayCalculator calculator) {
		this.calculator = calculator;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
    
}
