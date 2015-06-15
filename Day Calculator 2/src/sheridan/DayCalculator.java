
package sheridan;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class DayCalculator implements Serializable{
    
    final private GregorianCalendar calendar;
    private Locale locale;
    
    private Date startDate;
    private Date today;
    private Date resultDate;
    
    public DayCalculator(){
        
        calendar = new GregorianCalendar();
        locale = Locale.CANADA;
        today = new Date();
        
        //setDate();
    }
    
    /*private void setDate(){
        
        int year = calendar.get(Calendar.YEAR);
        int month = 1 + calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        
        date = String.format("%04d-%02d-%02d", year, month, day);
    }*/
    
    public Date getStartDate(){
        return startDate;
    }
    
    public String getDateDisplay(){
        
        StringBuilder buf = new StringBuilder();
        
//        buf.append(calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG_FORMAT, locale));
        buf.append(calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, locale));
        buf.append(", ");
//        buf.append(calendar.getDisplayName(Calendar.MONTH,Calendar.LONG_FORMAT, locale));
        buf.append(calendar.getDisplayName(Calendar.MONTH,Calendar.LONG, locale));
        buf.append(" ");
        buf.append(calendar.get(Calendar.DAY_OF_MONTH));
        buf.append(", ");
        buf.append(calendar.get(Calendar.YEAR));
        
        return buf.toString();
    }
    
    public void setStartDate(Date date){
        this.startDate = date;
        /*try{
            String[] arr = date.split("-");
            int year = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]);
            int day = Integer.parseInt(arr[2]);
            
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month-1);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            
            setDate();
        }catch(Exception e){
            throw new IllegalArgumentException("Wrong date format");
        }*/
    }
    
    public void addDays(int days){
    	calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        
        resultDate = calendar.getTime();
//        setDate();
    }
    
    public void addDays(String days){
        try{
            addDays(Integer.parseInt(days));
        }catch(Exception e){
            throw new IllegalArgumentException("Illegal number of the days");
        }
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public Date getResultDate() {
		return resultDate;
	}

	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	// this is only useful for testing this bean, and it is useless othewise
    public static void main(String[] args){
        
        DayCalculator calculator = new DayCalculator();
        
        Scanner input = new Scanner(System.in);
        boolean repeat;
        
        System.out.println("Today is " + calculator.getToday() + 
                " or " + calculator.getDateDisplay() + ".");
        do{
            try{
                System.out.print("Enter a start date in the format \"YYYY-MM-DD\": ");
                String dateString = input.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                Date date = dateFormat.parse(dateString);
                
                calculator.setStartDate(date);
                System.out.println("The start date is " + 
                    calculator.getStartDate() + " or " + 
                    calculator.getDateDisplay());
                repeat = false;
            }catch(Exception e){
                System.out.println("Input Error: " + e.getMessage());
                repeat = true;
            }
        }while(repeat);
        
        
        do{
            System.out.print("Enter a number of days to add: ");
            try{
                int days = input.nextInt();
                calculator.addDays(days);
                System.out.println("The result date is " + 
                    calculator.getResultDate() + 
                    " or " + calculator.getDateDisplay());
                repeat = false;
            }catch(Exception e){
                System.out.println("Input Error: Illegal number of the days");
                repeat = true;
                input.nextLine();
            }
        }while(repeat);
    }
}
