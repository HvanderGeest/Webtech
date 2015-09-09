package nl.saxion.views;

import java.util.List;

import nl.saxion.model.Huurder;
import nl.saxion.model.Kamer;
import nl.saxion.model.Model;
import nl.saxion.model.User;
import nl.saxion.model.Verhuurder;

public class Table {
	public static String getUsersTable(List<User> users) {
		String tableHtml = " <h1>Users:</h1><br><TABLE BORDER='1'><TR> <TH>username</TH> <TH>type</TH> </TR>";
		for(User user : users){
			String row = "";
			if(user instanceof Huurder){
				row = "<TR> <TD>"+user.getUsername()+"</TD> <TD>"+"Huurder"+"</TD></TR>";
			} else if(user instanceof Verhuurder) {
				row = "<TR> <TD>"+user.getUsername()+"</TD> <TD>"+"Verhuurder"+"</TD></TR>";
			}
			tableHtml+= row;
		}
		tableHtml+="</TABLE>";
		
		return tableHtml;
	}
	
	public static String getSearchRoomsTable(List<Kamer> rooms, Model model){
		String html = "<h1>Search Results</h1><br><TABLE BORDER='1'><TR> <TH>Surface (mm2)</TH> <TH>Price</TH> <TH>Place</TH><TH>Landlord</TH> </TR>";
		for(Kamer k : rooms){
			String row = "<TR> <TD>"+k.getSurfaceInMeter()+"</TD> <TD>"+k.getPriceInEuro()+"</TD> <TD>"+k.getPlace()+"</TD><TD>"+model.getLandlord(k).getUsername()+"</TD>  </TR>";
			html+= row;
		}
		html+="</TABLE>";
		return html;
	}
	
	public static String getRoomsFromVerhuurderTable(List<Kamer> rooms){
		String html = "<h1>My Rooms</h1><br><TABLE BORDER='1'><TR> <TH>Surface (mm2)</TH> <TH>Price</TH> <TH>Place</TH> </TR>";
		for(Kamer k :rooms){
			String row = "<TR> <TD>"+k.getSurfaceInMeter()+"</TD> <TD>"+k.getPriceInEuro()+"</TD> <TD>"+k.getPlace()+"</TD> </TR>";
			html+= row;
		}
		html+="</TABLE>";
		return html;
	}
}
