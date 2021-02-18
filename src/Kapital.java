public class Kapital {
	private String city;
	private String takeoffs;
	private String landed;
	
	public void setTakeoffs(String takeoffs) {
		if(this.takeoffs=="") {
			this.takeoffs=takeoffs;
		}
		else {
			this.takeoffs =this.takeoffs +", "+ takeoffs;
		}
		
	}

	public void setLanded(String landed) {
		if(this.landed=="") {
			this.landed=landed;
		}
		else {
			this.landed = this.landed +", "+landed;
		}
	}

	public String getCity() {
		return city;
	}
	
	public Kapital (String a) {
		city=a;
		takeoffs="";
		landed="";
	}
	
	public String toString() 
	{
		return city+"\nTakeoffs:"+takeoffs+"\tLanded:"+landed+"\n";
	}
	
}
