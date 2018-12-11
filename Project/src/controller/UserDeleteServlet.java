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
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
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
		User Detail = userDao.findDeleteInfo(id);

		// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード
		// リクエストスコープにユーザ情報をセット
		request.setAttribute("Detail", Detail);

//		HttpSession session = request.getSession();
//        session.setAttribute("Detail", Detail);

        // サーブレットクラスの動作を決定する「action」の値を
        // リクエストパラメーターから取得(P142)
        String action = request.getParameter("action");

        // 「登録の開始」をリクエストされた時の処理
        if (action == null) {
            // フォワード先を指定
            //forwardPath = "WEB-INF/jsp/userDeleteconfirm.jsp";

        	// 設定されたフォワード先にフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userDeleteform.jsp");
            dispatcher.forward(request, response);
        }

        }else {


        String action = request.getParameter("action");
        // 登録確認画面から「登録実行」をリクエストされた時の処理
        if (action.equals("done")) {

            // セッションスコープに保存された登録ユーザーを取得
            HttpSession session = request.getSession();
            String loginId = (String) session.getAttribute("loginId");

            // 登録処理の呼び出し
            UserDao logic = new UserDao();
            logic.deletemethod(loginId);

            // 不要となったセッションスコープ内のインスタンスを削除
            session.removeAttribute("loginId");

            // 登録後のフォワード先を設定
            //forwardPath = "WEB-INF/jsp/userDeletedone.jsp";
            // 設定されたフォワード先にフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userDeletedone.jsp");
            dispatcher.forward(request, response);
        }

    }

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// リクエストパラメーターの取得
        request.setCharacterEncoding("UTF-8");
        String loginId = request.getParameter("loginId");

//        HttpSession session = request.getSession();
//        String loginId = (String) session.getAttribute("loginId");


		/** テーブルに該当のデータが見つからなかった場合**/
		if (loginId.equals("")) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力された内容が正しくありません。");

			// 新規登録jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDeleteform.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// 登録するユーザーの情報を設定
        User deleteUser = new User(loginId);

        // セッションスコープに登録ユーザーを保存
        HttpSession session = request.getSession();
        session.setAttribute("deleteUser", deleteUser);
        session.setAttribute("loginId", loginId);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userDeleteconfirm.jsp");
        dispatcher.forward(request, response);

	}

}
