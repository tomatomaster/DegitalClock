

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Clock {
	static private Calendar now = null;
	static final private Map<String, Integer> timeMap = new HashMap<String, Integer>();
	
	/**
	 * get time and return 
	 * @return
	 */
	public Map<String, Integer> getTimeMap(){
		now = Calendar.getInstance();
		int h = now.get(now.HOUR_OF_DAY);
		int m = now.get(now.MINUTE);
		int s = now.get(now.SECOND);
		timeMap.put("hour", h);
		timeMap.put("minutes", m);
		timeMap.put("second", s);
		return timeMap;
	}
	
	/**
	 * Returns time strings
	 * ex: call this method by 15h 23m 22s returns 15:23:22
	 * @return
	 */
	public String getTimeString() {
		Map<String, Integer> timeMap = getTimeMap();
		String sh, sm, ss;
		int h =  timeMap.get("hour");
		int m =  timeMap.get("minutes");
		int s =  timeMap.get("second");
		
		sh = h < 10 ? ( "0" + String.valueOf(h) ) : (  String.valueOf(h) );
		sm = m < 10 ? ( "0" + String.valueOf(m) ) : (  String.valueOf(m) );
		ss = s < 10 ? ( "0" + String.valueOf(s) ) : (  String.valueOf(s) );
		return sh + ":" + sm + ":" + ss;
	}
}
