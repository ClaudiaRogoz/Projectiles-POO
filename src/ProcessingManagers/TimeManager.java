package ProcessingManagers;

/**
 * Time object
 */
public class TimeManager {
	private int h,m,s;
	
	/**
	 * Constructor
	 * 
	 * @param h hour
	 * @param m minutes
	 * @param s seconds
	 */
	public TimeManager(int h, int m, int s){
		setTime(h,m,s);
	}
	
	/**
	 * sets time with the given paarmeters
	 * 
	 * @param h hour
	 * @param m minutes
	 * @param s seconds
	 */
	void setTime(int h, int m, int s){
		this.setH(h);
		this.setM(m);
		this.setS(s);
	}
	
	/**
	 * Returns no. of seconds
	 * 
	 * @return s
	 */
	public int getS() {
		return s;
	}

	/**
	 * Sets seconds
	 * 
	 * @param s seconds
	 */
	public void setS(int s) {
		this.s = s;
	}

	/**
	 * Returns no. of minutes
	 * 
	 * @return m minutes
	 */
	public int getM() {
		return m;
	}

	/**
	 * Sets minutes
	 * 
	 * @param m minutes
	 */
	public void setM(int m) {
		this.m = m;
	}

	/**
	 * 
	 * Returns no. of hours
	 * 
	 * @return h hour
	 */
	public int getH() {
		return h;
	}

	/**
	 * Sets hour with the given parameter
	 * 
	 * @param h hour
	 */
	public void setH(int h) {
		this.h = h;
	}
}