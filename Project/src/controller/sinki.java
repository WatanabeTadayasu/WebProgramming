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
 * Servlet implementation class sinki
 */
@WebServlet("/sinki")
public class sinki extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public sinki() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub







		// フォワード先
        String forwardPath = null;

        // サーブレットクラスの動作を決定する「action」の値を
        // リクエストパラメーターから取得(P142)
        String action = request.getParameter("action");

        // 「登録の開始」をリクエストされた時の処理
        if (action == null) {
            // フォワード先を指定
            forwardPath = "WEB-INF/jsp/sinkiform.jsp";
        }

        // 登録確認画面から「登録実行」をリクエストされた時の処理
        else if (action.equals("done")) {

            // セッションスコープに保存された登録ユーザーを取得
            HttpSession session = request.getSession();
            String loginId = (String) session.getAttribute("loginId");
            String name = (String) session.getAttribute("name");
            String birthdate = (String) session.getAttribute("birthdate");
            String password = (String) session.getAttribute("password");

            // 暗号化処理の呼び出し
            UserDao rs = new UserDao();
            String result = rs.hash(password);

            // 登録するユーザーの情報を設定
    		//User registerUser = new User(loginId, name, formatDate, password, password1, createDate, updateDate);

            // 登録処理の呼び出し
            UserDao logic = new UserDao();
            logic.insertmethod(loginId, name, birthdate, result);

            // 不要となったセッションスコープ内のインスタンスを削除
            session.removeAttribute("loginId");
            session.removeAttribute("name");
            session.removeAttribute("birthdate");
            session.removeAttribute("password");

            // 登録後のフォワード先を設定
            forwardPath = "WEB-INF/jsp/sinkidone.jsp";
        }

        // 設定されたフォワード先にフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);

	}

	/**
	 * @param birthDate
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメーターの取得
        request.setCharacterEncoding("UTF-8");
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");

		/** テーブルに該当のデータが見つからなかった場合**/
		if (loginId.equals("") || password.equals("") || password1.equals("") || name.equals("")|| birthdate.equals("")) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg1", "入力された内容が正しくありません。");

			// 新規登録jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sinkiform.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if (password.equals(password1)) {

		} else {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg2", "パスワードが異なります。");

			// 新規登録jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sinkiform.jsp");
			dispatcher.forward(request, response);
			return;
		}

		UserDao userDao = new UserDao();
		User user = userDao.findByLoginInfo(loginId);

		/** テーブルに該当のデータが見つからなかった場合 **/
		if (user == null) {

		}else {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg3", "ログインに失敗しました。");

			// ログインjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sinkiform.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// 登録するユーザーの情報を設定
		User registerUser = new User(loginId, name, birthdate, password);

        // セッションスコープに登録ユーザーを保存
        HttpSession session = request.getSession();
        session.setAttribute("registerUser", registerUser);
        session.setAttribute("loginId", loginId);
        session.setAttribute("name", name);
        session.setAttribute("birthdate", birthdate);
        session.setAttribute("password", password);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/sinkiconfirm.jsp");
        dispatcher.forward(request, response);

	}

}
