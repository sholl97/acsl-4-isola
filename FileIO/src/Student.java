
public class Student {
		String fn;
		String mn;
		String ln;
		String sex;
		String gr_ent;
		String gr_cur;
		String grad;
		String bd;
		String bm;
		String by;
		public String getFn() {
			return fn;
		}

		public void setFn(String fn) {
			this.fn = fn;
		}

		public String getMn() {
			return mn;
		}

		public void setMn(String mn) {
			this.mn = mn;
		}

		public String getLn() {
			return ln;
		}

		public void setLn(String ln) {
			this.ln = ln;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getGr_ent() {
			return gr_ent;
		}

		public void setGr_ent(String gr_ent) {
			this.gr_ent = gr_ent;
		}

		public String getGr_cur() {
			return gr_cur;
		}

		public void setGr_cur(String gr_cur) {
			this.gr_cur = gr_cur;
		}

		public String getGrad() {
			return grad;
		}

		public void setGrad(String grad) {
			this.grad = grad;
		}

		public String getBd() {
			return bd;
		}

		public void setBd(String bd) {
			this.bd = bd;
		}

		public String getBm() {
			return bm;
		}

		public void setBm(String bm) {
			this.bm = bm;
		}

		public String getBy() {
			return by;
		}

		public void setBy(String by) {
			this.by = by;
		}

		public String getAdv() {
			return adv;
		}

		public void setAdv(String adv) {
			this.adv = adv;
		}

		String adv;
		
		public Student(String first_name, String middle_name, String last_name, String sex_code, String grade_entered, String current_grade, String class_year,
				String birth_day, String birth_month, String birth_year, String advisor_name) {
			fn = first_name;
			mn = middle_name;
			ln = last_name;
			sex = sex_code;
			gr_ent = grade_entered;
			gr_cur = current_grade;
			grad = class_year;
			bd = birth_day;
			bm = birth_month;
			by = birth_year;
			adv = advisor_name;
		}
	}