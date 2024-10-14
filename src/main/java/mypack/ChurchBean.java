//create package
package mypack;
import java.util.Date;

//bean class
public class ChurchBean {
	//create date object
	private Date currentDate = new Date();
	
	//get current date and return it to caller
	public Date getCurrentDate() {
		return currentDate;
	}
}