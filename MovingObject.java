public class MovingObject implements Kinematical{
	//variables
		private Pair position;
		private Pair velocity;
		//position methods
		@Override
		public Pair getPosition() {
			return this.position;
		}
		@Override
		public void setPosition(Pair _position) {
			this.position = _position;
		}
		//velocity methods
		@Override
		public Pair getVelocity() {
			return this.velocity;
		}
		@Override
		public void setVelocity(Pair _velocity) {
			this.velocity = _velocity;
		}
		@Override
		public void move(double _time) {
			// x_f = x_i + Vt => the formula used (the same for y)
			this.position = this.position.add(this.velocity.times(_time));
		}
}