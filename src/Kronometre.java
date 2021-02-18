
public class Kronometre {

	private int seconds,minutes,hours;
	private int days, months, years;
	
	
	public int getSeconds() {
		return seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public void daypass()
	{
		if(this.months == 1 && this.days == 31) {this.days = 1; this.months = 2; return;}
		if(this.months == 2 && (this.days == 29 && this.years % 4 == 0 || this.days == 28 && this.years % 4 != 0)) {this.days = 1; this.months = 3;return;}
		if(this.months == 3 && this.days == 31) {this.days = 1; this.months = 4;return;}
		if(this.months == 4 && this.days == 30) {this.days = 1; this.months = 5;return;}
		if(this.months == 5 && this.days == 31) {this.days = 1; this.months = 6;return;}
		if(this.months == 6 && this.days == 30) {this.days = 1; this.months = 7;return;}
		if(this.months == 7 && this.days == 31) {this.days = 1; this.months = 8;return;}
		if(this.months == 8 && this.days == 31) {this.days = 1; this.months = 9;return;}
		if(this.months == 9 && this.days == 30) {this.days = 1; this.months = 10;return;}
		if(this.months == 10 && this.days == 31) {this.days = 1; this.months = 11;return;}
		if(this.months == 11 && this.days == 30) {this.days = 1; this.months = 12;return;}
		if(this.months == 12 && this.days == 31) {this.days = 1; this.months = 1; this.years++;return;}
		days++;
	}

	public Kronometre() {
		seconds=0;
		minutes=0;
		hours=0;
	}
	public void arttir() {
				minutes++;
				seconds=0;
				if(minutes==60) {
					hours++;
					minutes=0;
				}
				if(hours == 24)
				{
					daypass();
					hours = 0;
				}
			}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
}
