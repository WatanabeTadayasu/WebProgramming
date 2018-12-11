package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {

	/**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginInfo(String loginId, String result) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

            // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, result);
            ResultSet rs = pStmt.executeQuery();

            // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }


    /*loginIdに紐づくユーザー情報を返す*/

    public User findByLoginInfo(String loginId) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ?";

            // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            ResultSet rs = pStmt.executeQuery();

         // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

                String loginIdDate = rs.getString("login_id");
                return new User(loginIdDate);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }


    /*idに紐づくユーザー情報を返す*/

    public User findByLoginInfo(int id) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE id = ?";

            // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

         // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                String birthdate = rs.getString("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                return new User(loginId, name, birthdate, password, createDate, updateDate);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    /*idに紐づくユーザー情報を返す*/

    public User findDeleteInfo(int id) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE id = ?";

            // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

         // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

                String loginId = rs.getString("login_id");
                String name = rs.getString("name");

                return new User(loginId, name);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    /*  String loginId;
	private String name;
	private Date birthDate;
	private String password;
	private String createDate;
	private String updateDate;

    ユーザー削除*/

    public void deletemethod(String loginId) {
		// TODO 自動生成されたメソッド・スタブ
    	Connection conn = null;
    	try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "DELETE FROM user WHERE login_id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);

            conn.setAutoCommit(false);

            pStmt.setString(1, loginId);

            int rs = pStmt.executeUpdate();

            System.out.println(rs + "行が削除されました。");

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            return;

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

    }

  /*  String loginId;
	private String name;
	private Date birthDate;
	private String password;
	private String createDate;
	private String updateDate;

    ユーザー情報更新password込み*/

    public void Updatemethod(String name, String birthdate, String result, String loginId) {
		// TODO 自動生成されたメソッド・スタブ
    	Connection conn = null;
    	try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "UPDATE user SET name = ?, birth_date = ?, password = ? WHERE login_id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);

            conn.setAutoCommit(false);

            pStmt.setString(1, name);
            pStmt.setString(2, birthdate);
            pStmt.setString(3, result);
            pStmt.setString(4, loginId);

            int rs = pStmt.executeUpdate();

            System.out.println(rs + "行が更新されました。");

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            return;

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

    }

    /*  ユーザー情報更新passwordなし*/

    public void Updatemethod1(String name, String birthdate, String loginId) {
		// TODO 自動生成されたメソッド・スタブ
    	Connection conn = null;
    	try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "UPDATE user SET name = ?, birth_date = ? WHERE login_id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);

            conn.setAutoCommit(false);

            pStmt.setString(1, name);
            pStmt.setString(2, birthdate);
            pStmt.setString(3, loginId);

            int rs = pStmt.executeUpdate();

            System.out.println(rs + "行が更新されました。");

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            return;

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

    }

    /*  String loginId;
	private String name;
	private Date birthDate;
	private String password;
	private String createDate;
	private String updateDate;

    新規登録*/

    public void insertmethod(String loginId, String name, String birthdate, String result) {
		// TODO 自動生成されたメソッド・スタブ
    	Connection conn = null;
    	try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "INSERT INTO user (login_id, name, birth_date, password, create_date, update_date) VALUES (?, ?, ?, ?, now(), now())";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);

            conn.setAutoCommit(false);

            pStmt.setString(1, loginId);
            pStmt.setString(2, name);
            pStmt.setString(3, birthdate);
            pStmt.setString(4, result);

            int rs = pStmt.executeUpdate();

            System.out.println(rs + "行が追加されました。");

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            return;

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

    }

    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user WHERE login_id != 'admin'";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                String birthdate = rs.getString("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthdate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;

    }

    /*検索*/

    public List<User> findSearch(String loginIdP, String nameP, String birthdateP, String birthdateP1) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id != 'admin'";

            if(!loginIdP.equals("")) {
            	sql += " AND login_id = '" + loginIdP  + "'" ;
            }

            if(!nameP.equals("")) {
            	sql += " AND name like '%" + nameP  + "%'" ;
            }

            if(!birthdateP.equals("")) {
            	sql += " AND birth_date >= '" + birthdateP  + "'" ;
            }

            if(!birthdateP1.equals("")) {
            	sql += " AND birth_date <= '" + birthdateP1  + "'" ;
            }

            System.out.println(sql);

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                String birthdate = rs.getString("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthdate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

    /*暗号化*/

    public String hash(String password) {

    	//ハッシュを生成したい元の文字列
    	//String source = "暗号化対象";
    	String source = password;
    	//ハッシュ生成前にバイト配列に置き換える際のCharset
    	Charset charset = StandardCharsets.UTF_8;
    	//ハッシュアルゴリズム
    	String algorithm = "MD5";
    	//ハッシュ生成処理
    	byte[] bytes = null;

		try {

			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));

		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

    	String result = DatatypeConverter.printHexBinary(bytes);
    	//標準出力
    	System.out.println(result);

		return result;
    }

}
