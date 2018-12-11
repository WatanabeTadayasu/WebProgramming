package model;

/**
 * Userテーブルのデータを格納するためのBeans
 * @author takano
 *
 Date birthDate   */

public class User {
	private int id;
	private String loginId;
	private String name;
	private String birthdate;
	private String password;
	private String createDate;
	private String updateDate;
	private String password1;
	private String birthdate1;


	// ログインセッションを保存するためのコンストラクタ
	public User(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}

	// 登録セッションを保存するためのコンストラクタ
	public User(String loginId, String name, String birthdate, String password) {
		this.loginId = loginId;
		this.name = name;
		this.birthdate = birthdate;
		this.password = password;
	}

	// 登録セッションを保存するためのコンストラクタ
	public void User1(String loginId) {
		this.loginId = loginId;
	}

	// 登録セッションを保存するためのコンストラクタ
	public void User2(String name) {
		this.name = name;
	}

	// 登録セッションを保存するためのコンストラクタ
	public void User3(String birthdate) {
		this.birthdate = birthdate;
	}

	// 登録セッションを保存するためのコンストラクタ
	public void User4( String password) {
		this.password = password;
	}

	// 参照セッションを保存するためのコンストラクタ
	public User(String loginId, String name, String birthdate, String password, String createDate, String updateDate) {
		this.loginId = loginId;
		this.name = name;
		this.birthdate = birthdate;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	// 更新セッションを保存するためのコンストラクタ
		public User(String name, String birthdate, String password, String password1, String loginId) {
			this.name = name;
			this.birthdate = birthdate;
			this.password = password;
			this.password1 = password1;
			this.loginId = loginId;
		}

	// 更新
		//public User(String name, String formatDate) {
			//this.name = name;
			//this.birthDate = formatDate;
		//}

	 //削除セッションを保存するためのコンストラクタ
		public User(String loginId) {
			this.loginId = loginId;
		}

	// 全てのデータをセットするコンストラクタ
	public User(int id, String loginId, String name, String birthdate, String password, String createDate,
			String updateDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.birthdate = birthdate;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	// 全てのデータをセットするコンストラクタ
		public void User1(String loginId, String name, String birthdate, String birthdate1) {
			this.loginId = loginId;
			this.name = name;
			this.birthdate = birthdate;
			this.birthdate1 = birthdate1;
		}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getBirthdate1() {
		return birthdate1;
	}

	public void setBirthdate1(String birthdate1) {
		this.birthdate1 = birthdate1;
	}

}
