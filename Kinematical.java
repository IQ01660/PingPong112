		/* This interface will be implemented for those classes
		 * which have elements of Kinematics, such as
		 * Paddle and Ball (list may change down the road)
		*/
public interface Kinematical {
	//POSITION METHODS
	
	/**
	 * Gives the current position of the object
	 * @return this.position
	 */
	public Pair getPosition();
	/**
	 * Sets a new position to the object
	 * @param new position
	 */
	public void setPosition(Pair _position);
	//VELOCITY METHODS
	
	/**
	 * Gives the current velocity the object
	 * @return this.velocity
	 */
	public Pair getVelocity();
	/**
	 * Sets a new velocity to the object
	 * @param new velocity
	 */
	public void setVelocity(Pair _velocity);
	//ACTION METHODS
	
	/**
	 * Uses kinematic equations to change the current position
	 * of the object
	 * @param _position
	 * @param velocity
	 * @param time
	 */
	public void move(double _time);
}