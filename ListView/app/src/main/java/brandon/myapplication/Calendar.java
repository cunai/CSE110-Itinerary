package brandon.myapplication;

import android.util.Log;
import android.widget.TextView;

import java.util.*;
public class Calendar{
	ArrayList<Event> myCalendar;
	public Calendar(){
		myCalendar = new ArrayList<Event>();
	}
	public void insert(Event insertion){
		myCalendar.add(insertion);	
	}
	public void sort(){
		Collections.sort(myCalendar);
	}
	public void print(TextView m_text_event){

		String l_str = m_text_event.getText().toString();
		//m_text_event.setText(l_str);
		for(Event e:myCalendar){
//			System.out.print("Event: "+e.getDescription()+"\t\t|");
//			System.out.print("Start Time: "+e.getStartTime().getTime()+"\t|");
//			System.out.println("End Time: "+e.getEndTime().getTime());
			l_str+=e.getDescription() + "\t|\t" + e.getStartTime().getTime() + "\t-\t" + e.getEndTime().getTime()+"\n";

		}
		l_str+="\n\n";
		m_text_event.setText(l_str);
		//return l_str;
	}
	public Event findTime(long length, Date deadline, String description){
		Event possibleTime = new Event(new Date(0), new Date(length), description);
		Event iter;
		for(int i = 0; i<myCalendar.size(); i++){
			if(possibleTime.getEndTime().compareTo(deadline)>=0){
				System.out.println("nnnsssn");
				return null;
			}
			iter = myCalendar.get(i);
			if(!iter.intersects(possibleTime)){
				System.out.println("n");
				int j = i;
				boolean collision = false;
				while(++j<myCalendar.size()&& iter.getStartTime().before(possibleTime.getEndTime())){
					
					iter = myCalendar.get(j);
					if(iter.intersects(possibleTime)){
						System.out.println("nnnn");
						collision = true;
					}

				}
				if(!collision){
					return possibleTime;
				}
			}
			iter = myCalendar.get(i);
			possibleTime.setStartingTime(iter.getEndTime().getTime()+1);
			possibleTime.setEndingTime(iter.getEndTime().getTime()+length);
		}
		System.out.println("nnn");
		return possibleTime;
}
	}
	

