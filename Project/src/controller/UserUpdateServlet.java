package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// フォワード先
        //String forwardPath = null;

        String num = request.getParameter("id");
        if (num != null) {
		int id = Integer.parseInt(num);

		// 確認用：idをコンソールに出力
		System.out.println(id);

		// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		UserDao userDao = new UserDao();
		User Detail = userDao.findByLoginInfo(id);

		// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード
		// リクエストスコープにユーザ情報をセット
		request.setAttribute("Detail", Detail);

		// サーブレットクラスの動作を決定する「action」の値を
        // リクエストパラメーターから取得(P142)
        String action = request.getParameter("action");

        // 「登録の開始」をリクエストされた時の処理
        if (action == null) {

        	// フォワード先を指定
            //forwardPath = "WEB-INF/jsp/userUpdateform.jsp";
        	// 設定されたフォワード先にフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userUpdateform.jsp");
            dispatcher.forward(request, response);
        }

        }else {

        String action = request.getParameter("action");
        // 登録確認画面から「登録実行」をリクエストされた時の処理
        if (action.equals("done")) {

            // セッションスコープに保存された登録ユーザーを取得
            HttpSession session = request.getSession();
            String loginId = (String) session.getAttribute("loginId");
            String name = (String) session.getAttribute("name");
            String  birthdate = (String) session.getAttribute("birthdate");
            //String password = (String) session.getAttribute("password");

            if (session.getAttribute("password").equals("")) {
            	// 登録処理の呼び出し
                UserDao logic = new UserDao();
                logic.Updatemethod1(name, birthdate, loginId);

            }else {
            	String password = (String) session.getAttribute("password");

            	// 暗号化処理の呼び出し
                UserDao rs = new UserDao();
                String result = rs.hash(password);

            	// 登録処理の呼び出し
                UserDao logic = new UserDao();
                logic.Updatemethod(name, birthdate, result, loginId);
            }

            // 不要となったセッションスコープ内のインスタンスを削除
            session.removeAttribute("loginId");
            session.removeAttribute("name");
            session.removeAttribute("birthdate");
            session.removeAttribute("password");

            // 登録後のフォワード先を設定
            //forwardPath = "WEB-INF/jsp/userUpdatedone.jsp";

            // 設定されたフォワード先にフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userUpdatedone.jsp");
            dispatcher.forward(request, response);

        }

    }

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメーターの取得
        request.setCharacterEncoding("UTF-8");
        String loginId = request.getParameter("loginId");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        String birthdate = request.getParameter("birthdate");

		/** テーブルに該当のデータが見つからなかった場合**/
		if (name.equals("") || birthdate.equals("")) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg5", "入力された内容が正しくありません。");

			// 更新jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdateform.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if (password.equals(password1)) {

		} else {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg6", "パスワードが異なります。");

			// 新規登録jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdateform.jsp");
			dispatcher.forward(request, response);
			return;
		}

			// 登録するユーザーの情報を設定
	        User updateUser = new User(loginId, name, birthdate, password);

	        // セッションスコープに登録ユーザーを保存
	        HttpSession session = request.getSession();
	        session.setAttribute("updateUser", updateUser);
	        session.setAttribute("loginId", loginId);
	        session.setAttribute("name", name);
	        session.setAttribute("birthdate", birthdate);
	        session.setAttribute("password", password);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userUpdateconfirm.jsp");
        dispatcher.forward(request, response);

	}

}
