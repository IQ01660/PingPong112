/** 
 * the class is used to interpret 
 * properties having x and y components
 * @author ikramgabiyev
 *
 */
public class Pair {
	//variables
	private double x; //individual x coordinate
	private double y; //individual y coordinate
	
	public Pair(double _x, double _y) {
		this.x = _x;
		this.y = _y;
	}
	/**
	 * adds individual components of pairs
	 * @param _addedPair
	 * @return a new pair
	 */
	public Pair add(Pair _addedPair) {
		double finalX = this.x + _addedPair.x;
		double finalY = this.y + _addedPair.y;
		return new Pair(finalX, finalY);
	}
	/**
	 * subtracts individual components of two pairs
	 * @param _subtractingPair
	 * @return a new pair
	 */
	public Pair subtract(Pair _subtractingPair) {
		double finalX = this.x - _subtractingPair.x;
		double finalY = this.y - _subtractingPair.y;
		return new Pair(finalX, finalY);
	}
	/**
	 * if you enter a pair as a parameter
	 * it multiplies each component of this pair
	 * by those of the parameter
	 * @param _multipliedPair
	 * @return
	 */
	public Pair times(Pair _multipliedPair) {
		double finalX = this.x * _multipliedPair.x;
		double finalY = this.y * _multipliedPair.y;
		return new Pair(finalX, finalY);
	}
	/**
	 * if you enter a double as a parameter
	 * it multiplies each component of this pair
	 * by that multiple
	 * @param _multipliedPair
	 * @return
	 */
	public Pair times(double _multiple) {
		double finalX = this.x * _multiple;
		double finalY = this.y * _multiple;
		return new Pair(finalX, finalY);
	}
}