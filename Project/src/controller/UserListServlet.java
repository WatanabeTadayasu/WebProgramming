package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる
		HttpSession session = request.getSession();
		if (session.getAttribute("userInfo") == null){
			// if (session == null){
			// session = request.getSession(true);
			// ログインのサーブレットにリダイレクト
			response.sendRedirect("LoginServlet");
		}else {

			if (session.getAttribute("searchUser") != null){
				// セッションスコープに保存された登録ユーザーを取得
				String loginIdP = (String) session.getAttribute("loginId");
				String nameP = (String) session.getAttribute("name");
				String  birthdateP = (String) session.getAttribute("birthdate");
				String  birthdateP1 = (String) session.getAttribute("birthdate1");

				//検索処理の呼び出し
				UserDao logic = new UserDao();
				List<User> userList1 = logic.findSearch(loginIdP, nameP, birthdateP, birthdateP1);

				// リクエストスコープにユーザ一覧情報をセット
				request.setAttribute("userList", userList1);

				// ユーザ一覧のjspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
				dispatcher.forward(request, response);

			}else {

		// ユーザ一覧情報を取得
		UserDao userDao = new UserDao();
		List<User> userList = userDao.findAll();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("userList", userList);

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);

			}

		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO  未実装：検索処理全般

		// リクエストパラメーターの取得
        request.setCharacterEncoding("UTF-8");
        String loginId = request.getParameter("loginId");
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");
        String birthdate1 = request.getParameter("birthdate1");

			// 登録するユーザーの情報を設定
	        User searchUser = new User(loginId, name, birthdate, birthdate1);

	        // セッションスコープに登録ユーザーを保存
	        HttpSession session = request.getSession();
	        session.setAttribute("searchUser", searchUser);
	        session.setAttribute("loginId", loginId);
	        session.setAttribute("name", name);
	        session.setAttribute("birthdate", birthdate);
	        session.setAttribute("birthdate1", birthdate1);

        // フォワード
        //RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
        //dispatcher.forward(request, response);
	    // ユーザ一覧のサーブレットにリダイレクト
	    response.sendRedirect("UserListServlet");

	}

}
